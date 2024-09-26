/* Keaton Raymond
 * CS 4100-001
 * Part 2: lexical analyzer
 */
package LexicalMain;

import ADT.Lexical;
//import ADT.LexicalReserve;
//import ADT.LexicalReserve;
import ADT.SymbolTable;
//import ADT.Lexical;
/**
*
* @author abrouill FALL 2022
*/
public class mainhw4 {
public static void main(String[] args) {
    String inFileAndPath = args[0];
    String outFileAndPath = args[1];
    System.out.println("Keaton Raymond CS4100 Lexical Analyzer, Fall 2022");
    System.out.println("Lexical for " + inFileAndPath);
    boolean traceOn = true;

    // Create a symbol table to store appropriate symbols found
    SymbolTable symbolList;
    symbolList = new SymbolTable(150);
    Lexical myLexer = new Lexical(inFileAndPath, symbolList, traceOn);
    Lexical.token currToken;
    currToken = myLexer.GetNextToken();

    while (currToken != null) {
        System.out.println("\t" + currToken.mnemonic + " | \t" + String.format("%04d", currToken.code) + " | \t" + currToken.lexeme);
        currToken = myLexer.GetNextToken();
    }

    symbolList.PrintSymbolTable(outFileAndPath);
    System.out.println("Done.");

    }
}