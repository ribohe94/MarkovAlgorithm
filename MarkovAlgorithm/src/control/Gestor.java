/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
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
                input = input.replace(rule.getFrom(), rule.getTo());
                return markov(input, rules);
            }
        }
        return input;
    }
}
