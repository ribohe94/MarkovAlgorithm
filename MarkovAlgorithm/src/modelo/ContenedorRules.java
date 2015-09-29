/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 *
 * @author Riccardo
 */
public class ContenedorRules {

    public ContenedorRules() {
        rules = new LinkedList<>();
    }

    //Sets & Gets
    public LinkedList<Rule> getRules() {
        return rules;
    }

    public void setRules(LinkedList<Rule> rules) {
        this.rules = rules;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    //Metodos
    public String ejecutarAlgoritmo(String doc, String from, String to) {
        if (!doc.equals(doc.replace(from, to))) {
            return doc.replace(from, to);
        }
    }

    public String sustituir(String doc) {
        return "";
    }

    //Atributos
    LinkedList<Rule> rules;
    String doc;
}
