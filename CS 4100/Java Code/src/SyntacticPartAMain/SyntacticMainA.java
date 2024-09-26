package SyntacticPartAMain;

import ADT.*;
 
/**
 *
 * @author abrouill FALL 2022
 */
public class SyntacticMainA {

    public static void main(String[] args) {
        String filePath = args[0];
        //String filePath = "/Users/keatonraymond/Downloads/SyntaxB-GOOD.txt";
        boolean traceon = true;
        System.out.println("Keaton Raymond, Last 4 of student number: 5013, CS4100, FALL 2022");
        System.out.println("INPUT FILE TO PROCESS IS: "+filePath);
    
        Syntactic parser = new Syntactic(filePath, traceon);
        parser.parse();
        System.out.println("Done.");
    }

}
