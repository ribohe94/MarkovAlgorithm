/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 *
 * @author bove
 */
public class ContenedorValores {

    public ContenedorValores(LinkedList<Character> alfabeto, LinkedList<Character> marcadores, LinkedList<Character> variables) {
        this.alfabeto = alfabeto;
        this.marcadores = marcadores;
        this.variables = variables;
    }

    //Sets & Gets
    public LinkedList<Character> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(LinkedList<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public LinkedList<Character> getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(LinkedList<Character> marcadores) {
        this.marcadores = marcadores;
    }

    public LinkedList<Character> getVariables() {
        return variables;
    }

    public void setVariables(LinkedList<Character> variables) {
        this.variables = variables;
    }

    //Metodos
    
    public String GetAlfabetoRegEx() {
        String regex = "([";
        for (int i = 0; i < alfabeto.size(); i++) {
            if (i < alfabeto.size() - 1) {
                regex += alfabeto.get(i) + ",";
            } else {
                regex += alfabeto.get(i);
            }
        }
        regex += "])";
        return regex;
    }
    
    public String GetAlfabetoIRegEx(int pos) {
        return "([" + alfabeto.get(pos) + "])";
    }
    
    public String GetMarcadoresRegEx() {
        String regex = "([";
        for (int i = 0; i < marcadores.size(); i++) {
            if (i < marcadores.size() - 1) {
                regex += marcadores.get(i) + ",";
            } else {
                regex += marcadores.get(i);
            }
        }
        regex += "])";
        return regex;
    }
    
    public String GetMarcadorIRegEx(int pos) {
        return "([" + marcadores.get(pos) + "])";
    }
    
    public String GetVariablesRegEx() {
        String regex = "([";
        for (int i = 0; i < variables.size(); i++) {
            if (i < variables.size() - 1) {
                regex += variables.get(i) + ",";
            } else {
                regex += variables.get(i);
            }
        }
        regex += "])";
        return regex;
    }

    //Atributos
    LinkedList<Character> alfabeto;
    LinkedList<Character> marcadores;
    LinkedList<Character> variables;
}
