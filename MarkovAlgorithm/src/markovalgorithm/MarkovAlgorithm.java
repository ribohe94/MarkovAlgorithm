/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markovalgorithm;

/**
 *
 * @author c09141a
 */
public class MarkovAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String doc = "100110||01|0|1||";
        doc = doc.replace("|01", "ABCD");
        System.out.println(doc);
    }
    
}
