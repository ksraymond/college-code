package CodeGenMain;

import ADT.*;

public class CodeGenMain {
    public static void main(String[] args) {
        String filePath = args[0];
        System.out.println("Keaton Raymond, Last 4 of student number: 5013, CS4100, FALL 2022");
        System.out.println("Parsing " + filePath);
        boolean traceon = true;
        Syntactic parser = new Syntactic(filePath, traceon);
        parser.parse();

        System.out.println("Done.");
    }
}
