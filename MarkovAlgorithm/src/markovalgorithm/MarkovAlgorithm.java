/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markovalgorithm;

import control.Gestor;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javafx.scene.input.KeyCode.F;
import modelo.ContenedorValores;
import modelo.Rule;

/**
 *
 * @author c09141a
 */
public class MarkovAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String doc = "101";
//        Rule r1 = new Rule("|0", "0||", false);
//        Rule r2 = new Rule("1", "0|", false);
//        Rule r3 = new Rule("0", "", true);
//        LinkedList<Rule> l1 = new LinkedList<>();
//        l1.add(r1);
//        l1.add(r2);
//        l1.add(r3);
//        
//        System.out.println(Gestor.markov(doc, l1));

        LinkedList<Character> alfabeto = new LinkedList<>();
        LinkedList<Character> marcadores = new LinkedList<>();
        LinkedList<Character> variables = new LinkedList<>();
        
        alfabeto.add('a');
        alfabeto.add('b');
        alfabeto.add('c');
        
        marcadores.add('F');
        
        variables.add('x');
        variables.add('y');
        variables.add('z');
        
        Rule rule1 = new Rule("Fx", "xxF", false);
        Rule rule2 = new Rule("xF", "x", true);
        Rule rule3 = new Rule("x", "Fx", false);
        
        LinkedList<Rule> rules = new LinkedList<>();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        
        Gestor g = new Gestor();
        
        ContenedorValores cv = new ContenedorValores(alfabeto, marcadores, variables);

        String input = "abc";
        
        System.out.println(g.markov(input, rules, cv));
        
        
//        String mydata = "aaFcabFc";
//        Pattern pattern = Pattern.compile("(([a,b,c])+([a,b,c])+([F])+([a,b,c]))");
//        Matcher matcher = pattern.matcher(mydata);
//        if (matcher.find()) {
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//        }
//        
//        System.out.println(mydata.replaceFirst("([a,b,c])+([a,b,c])+([F])+([a,b,c])", "FFF"));
        
       

    }

}
