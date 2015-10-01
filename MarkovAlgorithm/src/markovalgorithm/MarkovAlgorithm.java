/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markovalgorithm;

import control.Gestor;
import java.util.LinkedList;
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
        String doc = "101";
        Rule r1 = new Rule("|0", "0||", false);
        Rule r2 = new Rule("1", "0|", false);
        Rule r3 = new Rule("0", "", true);
        LinkedList<Rule> l1 = new LinkedList<>();
        l1.add(r1);
        l1.add(r2);
        l1.add(r3);
        
        System.out.println(Gestor.markov(doc, l1));
        
//        String doc = "0|01";
//        doc = doc.replaceFirst(Pattern.quote("|0"), "0||");
//        
//        
//        System.out.println(doc);
        
    }

}
