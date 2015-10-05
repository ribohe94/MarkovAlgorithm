/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.ContenedorValores;
import modelo.Rule;

/**
 *
 * @author Riccardo
 */
public class Gestor {

    public Gestor() {
    }

    public String GetRegexFrom(String input, ContenedorValores cv, Rule rule) {
        String regexFrom = "";

        // Este for regresa el regex de FROM
        for (int i = 0; i < rule.getFrom().length(); i++) {

            for (int j = 0; j < cv.getVariables().size(); j++) {
                // IF es una variable
                if (rule.getFrom().charAt(i) == cv.getVariables().get(j)) {
                    if ("".equals(regexFrom)) {
                        regexFrom += cv.GetAlfabetoRegEx();
                    } else {
                        regexFrom += "+" + cv.GetAlfabetoRegEx();
                    }
                }
            }

            for (int j = 0; j < cv.getMarcadores().size(); j++) {
                // IF es un marcador
                if (rule.getFrom().charAt(i) == cv.getMarcadores().get(j)) {
                    if ("".equals(regexFrom)) {
                        regexFrom += cv.GetMarcadorIRegEx(j);
                    } else {
                        regexFrom += "+" + cv.GetMarcadorIRegEx(j);
                    }
                }
            }

            for (int j = 0; j < cv.getAlfabeto().size(); j++) {
                // IF es un alfabeto
                if (rule.getFrom().charAt(i) == cv.getAlfabeto().get(j)) {
                    if ("".equals(regexFrom)) {
                        regexFrom += cv.GetAlfabetoIRegEx(j);
                    } else {
                        regexFrom += "+" + cv.GetAlfabetoIRegEx(j);
                    }
                }
            }
        }
        for (int i = 0; i < regexFrom.length(); i++) {
            for (int j = 0; j < cv.getAlfabeto().size(); j++) {
                if (regexFrom.charAt(i) != cv.getAlfabeto().get(j)) {
                    return regexFrom;
                }

            }

        }
        if ("".equals(regexFrom)) {
            return regexFrom;
        }
        return Pattern.quote(regexFrom);
    }

    public String GetStringTo(String input, ContenedorValores cv, Rule rule, String regex) {
        if (cv.getVariables().isEmpty()) {
            return rule.getTo();
        }
        //Vamos a construir el TO
        Pattern pattern = Pattern.compile("(" + regex + ")");
        Matcher matcher = pattern.matcher(input);
        input = "";
        if (matcher.find()) {

            input = matcher.group(1);

        }

//        System.out.println(input);
        HashMap hmInput = new HashMap();
        HashMap hmFrom = new HashMap();
        for (int i = 0; i < input.length(); i++) {
            hmInput.put(i, input.charAt(i));
        }
        for (int i = 0; i < rule.getFrom().length(); i++) {
            hmFrom.put(i, rule.getFrom().charAt(i));
        }

        String valorTo = "";

        for (int i = 0; i < rule.getTo().length(); i++) {
            boolean flag = false;
            for (int j = 0; j < hmFrom.size(); j++) {
                if (rule.getTo().charAt(i) == (Character) hmFrom.get(j)) {
                    valorTo += hmInput.get(j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int j = 0; j < cv.getMarcadores().size(); j++) {
                    if (rule.getTo().charAt(i) == cv.getMarcadores().get(j)) {
                        valorTo += rule.getTo().charAt(i);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                valorTo += rule.getTo().charAt(i);
            }
        }

        for (int i = 0; i < valorTo.length(); i++) {
            for (int j = 0; j < cv.getAlfabeto().size(); j++) {
                if (valorTo.charAt(i) != cv.getAlfabeto().get(j)) {
                    return valorTo;
                }

            }

        }
        if ("".equals(valorTo)) {
            return valorTo;
        }
        return Pattern.quote(valorTo);
    }

    public String markov(String input, LinkedList<Rule> rules, ContenedorValores cv, int index) {
        int i = 0;
        for (Rule rule : rules) {
            if (index == -1) {
                if (!input.equals(input.replaceFirst(GetRegexFrom(input, cv, rule), GetStringTo(input, cv, rule, GetRegexFrom(input, cv, rule))))) {
                    if (rule.isTerminating()) {
                        input = input.replaceFirst(GetRegexFrom(input, cv, rule), GetStringTo(input, cv, rule, GetRegexFrom(input, cv, rule)));
                        System.out.println(input);
                        return input;
                    } else {
                        input = input.replaceFirst(GetRegexFrom(input, cv, rule), GetStringTo(input, cv, rule, GetRegexFrom(input, cv, rule)));

                        System.out.println(input);
                        return markov(input, rules, cv, rule.getNext());
                    }
                }
            } else {
                if (i >= index) {
                    if (!input.equals(input.replaceFirst(GetRegexFrom(input, cv, rule), GetStringTo(input, cv, rule, GetRegexFrom(input, cv, rule))))) {
                        if (rule.isTerminating()) {
                            input = input.replaceFirst(GetRegexFrom(input, cv, rule), GetStringTo(input, cv, rule, GetRegexFrom(input, cv, rule)));
                            System.out.println(input);
                            return input;
                        } else {
                            input = input.replaceFirst(GetRegexFrom(input, cv, rule), GetStringTo(input, cv, rule, GetRegexFrom(input, cv, rule)));

                            System.out.println(input);
                            return markov(input, rules, cv, rule.getNext());
                        }
                    }
                }
            }
            i++;
        }

        return input;
    }
}
