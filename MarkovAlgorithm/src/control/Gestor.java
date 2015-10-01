/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import java.util.regex.Pattern;
import modelo.Rule;

/**
 *
 * @author Riccardo
 */
public class Gestor {

    public Gestor() {
    }

    public static String markov(String input, LinkedList<Rule> rules) {
        for (Rule rule : rules) {
            if (!input.equals(input.replace(rule.getFrom(), rule.getTo()))) {
                if (rule.isTerminating()) {
                    input = input.replaceFirst(Pattern.quote(rule.getFrom()), rule.getTo());
                    System.out.println(input);
                    return input;
                } else {
                    input = input.replaceFirst(Pattern.quote(rule.getFrom()), rule.getTo());
                    System.out.println(input);
                    return markov(input, rules);
                }
            }
        }
        return input;
    }
}
