/*
Keaton Raymond
CS 4100-001
Part 3A: Syntactic Analyzer
 */
package ADT;

/**
 *
 * @author abrouill
 */
public class Syntactic {

    private String filein;              //The full file path to input file
    private SymbolTable symbolList;     //Symbol table storing ident/const
    private Lexical lex;                //Lexical analyzer 
    private Lexical.token token;        //Next Token retrieved 
    private boolean traceon;            //Controls tracing mode 
    private int level = 0;              //Controls indent for trace mode
    private boolean anyErrors;          //Set TRUE if an error happens 

    private final int symbolSize = 250;

    public Syntactic(String filename, boolean traceOn) {
        filein = filename;
        traceon = traceOn;
        symbolList = new SymbolTable(symbolSize);
        lex = new Lexical(filein, symbolList, true);
        lex.setPrintToken(traceOn);
        anyErrors = false;
    }

//The interface to the syntax analyzer, initiates parsing
// Uses variable RECUR to get return values throughout the non-terminal methods    
    public void parse() {
        int recur = 0;
// prime the pump to get the first token to process
        token = lex.GetNextToken();
// call PROGRAM
        recur = Program();
    }

//Non Terminal PROGIDENTIFIER is fully implemented here, leave it as-is.        
    private int ProgIdentifier() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        // This non-term is used to uniquely mark the program identifier
        if (token.code == lex.codeFor("IDENT")) {
            // Because this is the progIdentifier, it will get a 'P' type to prevent re-use as a var
            symbolList.UpdateSymbol(symbolList.LookupSymbol(token.lexeme), 'P', 0);
            //move on
            token = lex.GetNextToken();
        }
        return recur;
    }

//Non Terminal PROGRAM is fully implemented here.    
    private int Program() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Program", true);
        if (token.code == lex.codeFor("UNIT_")) {
            token = lex.GetNextToken();
            recur = ProgIdentifier();
            if (token.code == lex.codeFor("SEMCO")) {
                token = lex.GetNextToken();
                recur = Block();
                if (token.code == lex.codeFor("PERIO")) {
                    if (!anyErrors) {
                        System.out.println("Success.");
                    } else {
                        System.out.println("Compilation failed.");
                    }
                } else {
                    error(lex.reserveFor("PERIO"), token.lexeme);
                }
            } else {
                error(lex.reserveFor("SEMCO"), token.lexeme);
            }
        } else {
            error(lex.reserveFor("UNIT_"), token.lexeme);
        }
        trace("Program", false);
        return recur;
    }

//Non Terminal BLOCK is fully implemented here.    
    private int Block() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Block", true);

        if (token.code == lex.codeFor("BEGIN")) {
            token = lex.GetNextToken();
            recur = Statement();
            while ((token.code == lex.codeFor("SEMCO")) && (!lex.EOF()) && (!anyErrors)) {
                token = lex.GetNextToken();
                recur = Statement();
            }
            if (token.code == lex.codeFor("END__")) {
                token = lex.GetNextToken();
            } else {
                error(lex.reserveFor("END__"), token.lexeme);
            }

        } else {
            error(lex.reserveFor("BEGIN"), token.lexeme);
        }

        trace("Block", false);
        return recur;
    }

//Not a NT, but used to shorten Statement code body for readability.   
    //<variable> $COLON-EQUALS <simple expression>
    private int handleAssignment() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("handleAssignment", true);
        //have ident already in order to get to here, handle as Variable
        recur = Variable();  //Variable moves ahead, next token ready

        if (token.code == lex.codeFor("EQUAL")) {
            token = lex.GetNextToken();
            recur = SimpleExpression();
        } else {
            error(lex.reserveFor("EQUAL"), token.lexeme);
        }

        trace("handleAssignment", false);
        return recur;
    }

// NT This is dummied in to only work for an identifier. 
//  It will work with the SyntaxAMiniTest file having ASSIGNMENT statements
//     containing only IDENTIFIERS.  TERM and FACTOR and numbers will be
//     needed to complete Part A.
// SimpleExpression MUST BE 
//  COMPLETED TO IMPLEMENT CFG for <simple expression>
    private int SimpleExpression() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("SimpleExpression", true);
        
        //if the first character is a + or -, then it is a sign for the term, but this isn't necessary
        if((token.code == lex.codeFor("ADD__") || (token.code == lex.codeFor("SUBTR")))) {
            recur = Sign();
        }
        
        //enter term regardles because that is what is next in simple expression
        recur = Term();

        //because this part of term in the CFG is {addop term}*, if the next token is an addop, then call addop, then term, then if it is another addop loop back and do it again
        //because the addop has to be followed by a term
        while((token.code == lex.codeFor("ADD__") || (token.code == lex.codeFor("SUBTR"))) && (!lex.EOF()) && (!anyErrors)) {
            recur = Addop();
            recur = Term();
        }

        trace("SimpleExpression", false);
        return recur;
    }

    //handle the "sign" nonterminal, which is just a + or -
    private int Sign() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Sign", true);

        //validity is checked before this method but if the code enters this method and the token isn't a sign, throw an error
        if((token.code == lex.codeFor("ADD__") || (token.code == lex.codeFor("SUBTR"))))
        {
            token = lex.GetNextToken();
        }
        else {
            error("'+' or '-", token.lexeme);
        }

        trace("Sign", false);
        return recur;
    }

    //handle the "term" nonterminal
    private int Term() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Term", true);
        
        //the first element of all terms is a factor so call that first and foremost
        recur = Factor();

        //same logic applies to this method as the {addop term}* above, but this time with mulop instead of addop and factor instead of term
        while((token.code == lex.codeFor("MULTI") || (token.code == lex.codeFor("DIVID"))) && (!lex.EOF()) && (!anyErrors)) {
            recur = Mulop();
            recur = Factor();
        }

        trace("Term", false);

        return recur;
    }

    //handle the "addop" nonterminal
    private int Addop() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Addop", true);

        //validity is checked before this method but if the code enters this method and the token isn't an addop, throw an error
        if((token.code == lex.codeFor("ADD__") || (token.code == lex.codeFor("SUBTR")))) {
            token = lex.GetNextToken();
        }
        else {
            error("'+' or '-'", token.lexeme);
        }

        trace("Addop", false);
        return recur;
    }

    //handle the "mulop" nonterminal
    private int Mulop() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Mulop", true);

        //validity is checked before this method but if the code enters this method and the token isn't a sign, throw an error
        if((token.code == lex.codeFor("MULTI") || (token.code == lex.codeFor("DIVID")))) {
            token = lex.GetNextToken();
        }
        else {
            error("'*' or '/'", token.lexeme);
        }

        trace("Mulop", false);
        return recur;
    }

    //handle the "factor" nonterminal
    private int Factor() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Factor", true);

        //if variable
        if(token.code == lex.codeFor("IDENT")) {
            recur = Variable();
        }
        //elif unsigned const
        else if((token.code == lex.codeFor("_INT_")) || (token.code == lex.codeFor("FCNST"))) {
            recur = UnsignedConstant();
        }
        //elif lpar then simple exp then rpar
        else if((token.code == lex.codeFor("OPENP"))) {
            token = lex.GetNextToken();
            recur = SimpleExpression();
            if(token.code != lex.codeFor("CLOSP")) { //if the simple expression is not followed by a ) then throw an error
                error("')'", token.lexeme);
            }
            else {
                token = lex.GetNextToken();
            }
        }
        else { //if the token is not an accepted factor then throw an error
            error("Number or Variable or '('", token.lexeme);
        }

        trace("Factor", false);

        return recur;
    }

    //handle "unsigned constant" nonterminal
    private int UnsignedConstant() {
        int recur = 0;
        if(anyErrors) {
            return -1;
        }

        //because unsigned constant only has one path, that being unsigned number, so another method to handle the unsigned number nonterminal seemed unnecessary
        trace("UnsignedConstant", true);
        trace("UnsignedNumber", true);

        //though validity is checked before entering this method, if the code enters this method and doesn't get a number, throw an error
        if((token.code == lex.codeFor("_INT_")) || (token.code == lex.codeFor("FCNST"))) {
            token = lex.GetNextToken();
        }
        else {
            error("Number", token.lexeme);
        }
        
        trace("UnsignedNumber", false);
        trace("UnsignedConstant", false);

        return recur;
    }

// Eventually this will handle all possible statement starts in 
//    a nested if/else structure. Only ASSIGNMENT is implemented now.
    private int Statement() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Statement", true);

        if (token.code == lex.codeFor("IDENT")) {  //must be an ASSIGNMENT
            recur = handleAssignment();
        } else {
            if (token.code == lex.codeFor("IF___")) {  //must be an IF
                // this would handle the rest of the IF statment IN PART B
            } else 
		    // if/elses should look for the other possible statement starts...  
            //  but not until PART B
            {
                error("Statement start", token.lexeme);
            }
        }

        trace("Statement", false);
        return recur;
    }

//Non-terminal VARIABLE just looks for an IDENTIFIER.  Later, a
//  type-check can verify compatible math ops, or if casting is required.    
    private int Variable(){
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Variable", true);
        if ((token.code == lex.codeFor("IDENT"))) {
            // bookkeeping and move on
           token = lex.GetNextToken();
        }
        else
            error("Variable", token.lexeme);

        trace("Variable", false);
        return recur;

}  
    
/**
 * *************************************************
*/
    /*     UTILITY FUNCTIONS USED THROUGHOUT THIS CLASS */
// error provides a simple way to print an error statement to standard output
//     and avoid reduncancy
    private void error(String wanted, String got) {
        anyErrors = true;
        System.out.println("ERROR: Expected " + wanted + " but found " + got);
    }

// trace simply RETURNs if traceon is false; otherwise, it prints an
    // ENTERING or EXITING message using the proc string
    private void trace(String proc, boolean enter) {
        String tabs = "";

        if (!traceon) {
            return;
        }

        if (enter) {
            tabs = repeatChar(" ", level);
            System.out.print(tabs);
            System.out.println("--> Entering " + proc);
            level++;
        } else {
            if (level > 0) {
                level--;
            }
            tabs = repeatChar(" ", level);
            System.out.print(tabs);
            System.out.println("<-- Exiting " + proc);
        }
    }

// repeatChar returns a string containing x repetitions of string s; 
//    nice for making a varying indent format
    private String repeatChar(String s, int x) {
        int i;
        String result = "";
        for (i = 1; i <= x; i++) {
            result = result + s;
        }
        return result;
    }  
}
