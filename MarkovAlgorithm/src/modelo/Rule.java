/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Riccardo
 */
public class Rule {

    public Rule(String from, String to, boolean terminating) {
        this.from = from;
        this.to = to;
        this.terminating = terminating;
    }
    
    //Gets & Sets
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isTerminating() {
        return terminating;
    }

    public void setTerminating(boolean terminating) {
        this.terminating = terminating;
    }
    
    //Atributos
    String from;
    String to;
    boolean terminating;
}
