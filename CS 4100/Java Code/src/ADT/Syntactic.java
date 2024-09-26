/*
Keaton Raymond
CS 4100-001
Part 3B: Syntactic Analyzer
 */

/* CFG method template
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("methodName", true);



        trace("methodName", false);
        return recur;
 */

//I added a check for if !anyErrors to all error throwing statements so that it will skip over that when back tracking recursion stack to the statement block

/* Code Gen Requirements
 * implement:
 *      assignments: ident := <simpleExp> DONE
 *      outputs from WRITELN DONE
 *      inputs from READLN DONE
 *      if and if/else
 *      DOWHILE
 */

package ADT;

/**
 *
 * @author abrouill
 */
public class Syntactic {

    private String filein;              //The full file path to input file
    private SymbolTable symbolList, varList;     //Symbol table storing ident/const
    private Lexical lex;                //Lexical analyzer 
    private QuadTable quads;
    private Interpreter interp;
    private Lexical.token token;        //Next Token retrieved 
    private boolean traceon;            //Controls tracing mode 
    private int level = 0;              //Controls indent for trace mode
    private boolean anyErrors, semcoExpected;          //Set TRUE if an error happens 

    private final int symbolSize = 250;
    private final int quadSize = 1000;
    private int minus1Index;
    private int plus1Index;

    public Syntactic(String filename, boolean traceOn) {
        filein = filename;
        traceon = traceOn;
        symbolList = new SymbolTable(symbolSize);
        varList = new SymbolTable(symbolSize); //added varlist because I ran into an issue where the lexical automatically adds undeclared variables so to throw an error i can't use the symbollist
        
        minus1Index = symbolList.AddSymbol("-1", 'C', -1);
        plus1Index = symbolList.AddSymbol("1", 'C', 1);

        quads = new QuadTable(quadSize);
        interp = new Interpreter();
        
        lex = new Lexical(filein, symbolList, true);
        lex.setPrintToken(traceOn);
        anyErrors = false;
        semcoExpected = false;
    }

//The interface to the syntax analyzer, initiates parsing
// Uses variable RECUR to get return values throughout the non-terminal methods    
    public void parse() {
        String filenameBase = filein.substring(0, filein.length() - 4);
        System.out.println(filenameBase);
        int recur = 0;
// prime the pump to get the first token to process
        token = lex.GetNextToken();
// call PROGRAM
        recur = Program();

        quads.AddQuad(interp.opcodeFor("STOP"), 0, 0, 0); //add a STOP quad after program execution

        symbolList.PrintSymbolTable(filenameBase + "ST-before.txt");
        quads.PrintQuadTable(filenameBase + "QUADS.txt");

        if (!anyErrors) 
            interp.InterpretQuads(quads, symbolList, false, filenameBase + "TRACE.txt");
        else
            System.out.println("Errors, unable to run program");
        
        symbolList.PrintSymbolTable(filenameBase + "ST-after.txt");
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
                } else if (!anyErrors) {
                    error(lex.reserveFor("PERIO"), token.lexeme);
                }
            } else if (!anyErrors){
                error(lex.reserveFor("SEMCO"), token.lexeme);
            }
        } else if (!anyErrors){
            error(lex.reserveFor("UNIT_"), token.lexeme);
        }
        trace("Program", false);
        return recur;
    }

    //handles the block nonterminal
    private int Block() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Block", true);

        //handle optional variable declarations
        while((token.code == lex.codeFor("VAR__")) && (!lex.EOF()) && (!anyErrors)) {
            recur = VariableDecSec();
            //token = lex.GetNextToken();
        }

        //next is block body regardless, error handling in there
        recur = BlockBody();

        trace("Block", false);
        return recur;
    }

    //handles the variable declaration section nonterminal
    private int VariableDecSec() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("VariableDecSec", true);

        //while there is a variable declaration line
        while (token.code == lex.codeFor("VAR__")) {
            token = lex.GetNextToken();
            recur = VariableDeclaration();
        }
        // else {
        //     error(lex.reserveFor("VAR__"), token.lexeme);
        // }

        trace("VariableDecSec", false);
        return recur;
    }

    //handles the variable declaration nonterminal
    private int VariableDeclaration() {
        int recur = 0;
        boolean oneOrMore = false; //used to make sure that there is 1 or more variable declarations
        if (anyErrors) {
            return -1;
        }

        trace("VariableDeclaration", true);

        //do while to handle the commas
        do {
            if(token.code == lex.codeFor("IDENT")) {
                varList.AddSymbol(token.lexeme, 'V', 0);
                oneOrMore = true;
                token = lex.GetNextToken();

                //if more than 1 variable loop through starting with a comma
                while(token.code == lex.codeFor("COMMA") && (!lex.EOF()) && (!anyErrors)) {
                    token = lex.GetNextToken();
                    if(token.code == lex.codeFor("IDENT")) {
                        varList.AddSymbol(token.lexeme, 'V', 0);
                        token = lex.GetNextToken();
                    }
                    else if (!anyErrors){
                        error(lex.reserveFor("IDENT"), token.lexeme);
                    }
                }

                //after the variables there needs to be a colon
                if(token.code == lex.codeFor("COLON")) {
                    token = lex.GetNextToken();
                }
                else if (!anyErrors){
                    error(lex.reserveFor("COLON"), token.lexeme);
                }

                //after the variables there is a simple type assigned to them
                recur = SimpleType();

                //each line needs to be followed by a semicolon
                if(token.code == lex.codeFor("SEMCO")) {
                    token = lex.GetNextToken();
                }
                else if (!anyErrors){
                    error(lex.reserveFor("SEMCO"), token.lexeme);
                }

            }
            else if (!oneOrMore) { //only throw an error if the ident wasn't used at all, requires 1 or more
                error(lex.reserveFor("IDENT"), token.lexeme);
            }
        } while((token.code == lex.codeFor("IDENT")) && (!lex.EOF()) && (!anyErrors));

        trace("VariableDeclaration", false);
        return recur;
    }

    //handles the simple type nonterminal
    private int SimpleType() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("SimpleType", true);

        //if the token code matches one of the 3 simple types in the language
        if((token.code == lex.codeFor("INTEG")) || (token.code == lex.codeFor("FLOAT")) || (token.code == lex.codeFor("STRIN"))) {
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error("Simple Type", token.lexeme);
        }

        trace("SimpleType", false);
        return recur;
    }

    //old "block" nonterminal from part A, now becomes blockbody because block is different
    //also has added error checking for semicolons
    private int BlockBody() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("BlockBody", true);

        if (token.code == lex.codeFor("BEGIN")) {
            token = lex.GetNextToken();
            recur = Statement();
            while ((token.code == lex.codeFor("SEMCO")) && (!lex.EOF()) && (!anyErrors)) {
                token = lex.GetNextToken();
                if(token.code != lex.codeFor("END__")) {
                    recur = Statement();
                }
                
                //before re checking the loop condition, if the current token isn't a semicolon or the end of the program
                //then there is a missing semicolon and handle the error before re checking the loop condition
                if (IsStatementStart() && (token.code != lex.codeFor("END__"))) { 
                    semcoExpected = true;
                    error(lex.reserveFor("SEMCO"), token.lexeme);
                    HandleErrors();
                    if(!anyErrors) { //if the error could be resolved, then go back to statement start
                        recur = Statement();
                    }
                }

            }

            if (token.code == lex.codeFor("END__")) {
                token = lex.GetNextToken();
            }
            else if (!anyErrors){
                error(lex.reserveFor("END__"), token.lexeme);
            }

        } else if (!anyErrors){
            error(lex.reserveFor("BEGIN"), token.lexeme);
        }

        trace("BlockBody", false);
        return recur;
    }

    //handles the assignment case in statement, same as in part A
    private int handleAssignment() {
        int recur = 0;
        int lhs = 0;
        int rhs = 0;
        if (anyErrors) {
            return -1;
        }
        trace("handleAssignment", true);
        //have ident already in order to get to here, handle as Variable
        lhs = Variable();  //Variable moves ahead, next token ready

        if (token.code == lex.codeFor("EQUAL")) {
            token = lex.GetNextToken();
            if(token.code == lex.codeFor("STRNG")) {
                rhs = symbolList.LookupSymbol(token.lexeme); //if it is a string, then you want to assign that string constant to the variable
                recur = StringConstant();
            }
            else {
                rhs = SimpleExpression();
            }

            quads.AddQuad(interp.opcodeFor("MOV"), rhs, 0, lhs);
            
        } 
        else if (!anyErrors){
            error(lex.reserveFor("EQUAL"), token.lexeme);
        }

        trace("handleAssignment", false);
        return recur;
    }

    //handles the if case in statement
    private int HandleIf() {
        int recur = 0;
        int branchQuad, patchElse;
        if (anyErrors) {
            return -1;
        }

        trace("HandleIf", true);

        //move to next token because the current token when this is entered is "IF"
        token = lex.GetNextToken();

        //after the "if" token, a relExpression is required
        branchQuad = RelExpression();

        //after the RelExpression a then token is required
        if(token.code == lex.codeFor("THEN_")) {
            token = lex.GetNextToken();
            recur = Statement();
            if(token.code == lex.codeFor("ELSE_")) { //else statement is optional so no error handling for else
                //if there is an else statement add the jumps for it
                token = lex.GetNextToken();
                patchElse = quads.NextQuad();
                quads.AddQuad(interp.opcodeFor("JMP"), 0, 0, 0);
                quads.UpdateJump(branchQuad, quads.NextQuad());
                recur = Statement();
                quads.UpdateJump(patchElse, quads.NextQuad());
            }
            else { //if there is no else statement add the jump without the else
                quads.UpdateJump(branchQuad, quads.NextQuad());
            }
        }
        else if (!anyErrors){
            error(lex.reserveFor("THEN_"), token.lexeme);
        }

        trace("HandleIf", false);
        return recur;
    }

    //handles the dowhile case in statement
    private int HandleDoWhile() {
        int recur = 0;
        int saveTop, branchQuad;
        if (anyErrors) {
            return -1;
        }

        trace("HandleDoWhile", true);

        //next token because the current token is DOWHILE
        token = lex.GetNextToken();

        saveTop = quads.NextQuad();

        //next is a relexpression
        branchQuad = RelExpression();

        //next is another statement
        recur = Statement();
        quads.AddQuad(interp.opcodeFor("JMP"), 0, 0, saveTop); //jump to the top to reevaluate the condition

        quads.UpdateJump(branchQuad, quads.NextQuad());

        trace("HandleDoWhile", false);
        return recur;
    }

    //handles the for case in statement
    private int HandleFor() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("HandleFor", true);

        //next token because current is FOR
        token = lex.GetNextToken();

        //next token is a variable (error checking for this in the variable method)
        recur = Variable();

        if(token.code == lex.codeFor("EQUAL")) { //equal is required followed by a SimpExp
            token = lex.GetNextToken();
            recur = SimpleExpression();
            if(token.code == lex.codeFor("TO___")) { //then to is required followed by a SimpExp
                token = lex.GetNextToken();
                recur = SimpleExpression();
                if(token.code == lex.codeFor("DO___")) { //then do is required followed by a Statement
                    token = lex.GetNextToken();
                    recur = Statement();
                }
                else if (!anyErrors){
                    error(lex.reserveFor("DO___"), token.lexeme); //if do is missing
                }
            }
            else if (!anyErrors){
                error(lex.reserveFor("TO___"), token.lexeme); //if to is missing
            }
        }
        else if (!anyErrors){
            error(lex.reserveFor("EQUAL"), token.lexeme); //if the assignment is missing
        }

        trace("HandleFor", false);
        return recur;
    }

    //handles the writeln case in statement
    private int HandleWrite() {
        int recur = 0;
        int toPrint = 0;
        if (anyErrors) {
            return -1;
        }

        trace("HandleWrite", true);

        //get next token because current token is WRITELN
        token = lex.GetNextToken();

        if(token.code == lex.codeFor("OPENP")) { //a ( is required first
            token = lex.GetNextToken();
            //if token code STRNG
            if(token.code == lex.codeFor("STRNG")) { //a string is between the ()

                toPrint = symbolList.LookupSymbol(token.lexeme);

                recur = StringConstant();
                if(token.code == lex.codeFor("CLOSP")) { //a ) is required last
                    token = lex.GetNextToken();
                }
                else if (!anyErrors){ //if the parentheses aren't closed
                    error(lex.reserveFor("CLOSP"), token.lexeme);
                }
            }
            //elif token code IDENT
            else if (token.code == lex.codeFor("IDENT")) {

                toPrint = symbolList.LookupSymbol(token.lexeme);

                token = lex.GetNextToken();
                if(token.code == lex.codeFor("CLOSP")) {
                    token = lex.GetNextToken();
                }
                else if (!anyErrors){
                    error(lex.reserveFor("CLOSP"), token.lexeme);
                }
            }
            //else simpexp because that is the only other option
            else {
                toPrint = SimpleExpression();
                //recur = SimpleExpression();
                if(token.code == lex.codeFor("CLOSP")) {
                    token = lex.GetNextToken();
                }
                else if (!anyErrors){
                    error(lex.reserveFor("CLOSP"), token.lexeme);
                }
            }
            quads.AddQuad(interp.opcodeFor("PRINT"), 0, 0, toPrint);
        }
        else if (!anyErrors){
            error(lex.reserveFor("OPENP"), token.lexeme);
        }

        trace("HandleWrite", false);
        return recur;
    }

    //handles the repeat until case in statement
    private int HandleRepeat() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("HandleRepeat", true);

        //move past "repeat" token
        token = lex.GetNextToken();

        //after the repeat a statement is required
        recur = Statement();

        //after the statement there has to be an "UNTIL"
        if (token.code == lex.codeFor("UNTIL")) {
            token = lex.GetNextToken(); //move past the UNTIL
            recur = RelExpression(); //a relexpression is required after the UNTIL
        }
        else if (!anyErrors){
            error(lex.reserveFor("UNTIL"), token.lexeme);
        }

        trace("HandleRepeat", true);
        return recur;
    }

    //handles the READLN case in statement
    private int HandleRead() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("HandleRead", true);

        //next token because current token is READLN
        token = lex.GetNextToken();

        if(token.code == lex.codeFor("OPENP")) { //has to start with (
            token = lex.GetNextToken();
            if(token.code == lex.codeFor("IDENT")) { //an ident has to follow the (
                quads.AddQuad(interp.opcodeFor("READ"), 0, 0, symbolList.LookupSymbol(token.lexeme)); //add the quad for the read command with the variable in the read statement
                token = lex.GetNextToken();
                if(token.code == lex.codeFor("CLOSP")) { //must end with )
                    token = lex.GetNextToken();
                }
                else if (!anyErrors){ //if parentheses not closed
                    error(lex.reserveFor("CLOSP"), token.lexeme);
                }
            }
            else if (!anyErrors){ //if parentheses don't have ident
                error("Identifier", token.lexeme);
            }
        }
        else if (!anyErrors){ //if parentheses aren't opened
            error(lex.reserveFor("OPENP"), token.lexeme);
        }

        trace("HandleRead", false);
        return recur;
    }

//SAME AS PART A
// NT This is dummied in to only work for an identifier. 
//  It will work with the SyntaxAMiniTest file having ASSIGNMENT statements
//     containing only IDENTIFIERS.  TERM and FACTOR and numbers will be
//     needed to complete Part A.
// SimpleExpression MUST BE 
//  COMPLETED TO IMPLEMENT CFG for <simple expression>
    private int SimpleExpression() {
        int recur = 0;
        int lhs, rhs = 0;
        int temp = 0;
        int addopQuad = 0;
        if (anyErrors) {
            return -1;
        }

        trace("SimpleExpression", true);
        
        //if the first character is a + or -, then it is a sign for the term, but this isn't necessary
        if((token.code == lex.codeFor("ADD__") || (token.code == lex.codeFor("SUBTR")))) {
            recur = Sign();
        }
        
        //enter term regardles because that is what is next in simple expression
        lhs = Term();
        
        //because this part of term in the CFG is {addop term}*, if the next token is an addop, then call addop, then term, then if it is another addop loop back and do it again
        //because the addop has to be followed by a term
        while((token.code == lex.codeFor("ADD__") || (token.code == lex.codeFor("SUBTR"))) && (!lex.EOF()) && (!anyErrors)) {
            //check if it is an add or sub quad, and find the opcode for the appropriate one for the quad
            if(token.code == lex.codeFor("ADD__"))
                addopQuad = interp.opcodeFor("ADD");
            else if (token.code == lex.codeFor("SUBTR"))
                addopQuad = interp.opcodeFor("SUB");

            recur = Addop();
            rhs = Term();

            //get a new symbol for the temp variable
            //basically split all of the individual math ops up and then combine them using the different temps that are saved in the quad table
            temp = GenSymbol();

            quads.AddQuad(addopQuad, lhs, rhs, temp); //add the quad
            lhs = temp; //the "new" lhs is the temp index
        }

        trace("SimpleExpression", false);
        return lhs;
    }

    //generates a new symbol with a random 8 char string (the 8 is arbitrary) and creates a new symbol for it, used for math expressions in simple expression and term
    private int GenSymbol() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return symbolList.AddSymbol(sb.toString(), 'V', 0);
    }

    //handles the relexpression nonterminal
    private int RelExpression() {
        int recur = 0;
        int lhs, rhs, saveRelop, result, temp;
        if (anyErrors) {
            return -1;
        }

        trace("RelExpression", true);

        //simpleexpression is required next
        lhs = SimpleExpression();

        //relop is required after the simple expression
        saveRelop = Relop();

        //simple expression is required last
        rhs = SimpleExpression();

        temp = GenSymbol();

        quads.AddQuad(interp.opcodeFor("SUB"), lhs, rhs, temp);

        result = quads.NextQuad();

        quads.AddQuad(relopToOpcode(saveRelop), temp, 0, 0);

        trace("RelExpression", false);
        return result;
    }

    //given the relop token code, return the appropriate opcode
    private int relopToOpcode(int relop) {
        int result = 0;
        if(relop == lex.codeFor("GRTHN")) {
            result = interp.opcodeFor("JNP");
        }
        else if(relop == lex.codeFor("LSTHN")) {
            result = interp.opcodeFor("JNN");
        }
        else if(relop == lex.codeFor("GREQL")) {
            result = interp.opcodeFor("JN");
        }
        else if(relop == lex.codeFor("LSEQL")) {
            result = interp.opcodeFor("JP");
        }
        else if(relop == lex.codeFor("CONEQ")) {
            result = interp.opcodeFor("JNZ"); //jump not zero
        }
        else if(relop == lex.codeFor("NTEQL")) {
            result = interp.opcodeFor("JZ");
        }

        return result;
    }

    //handles the relop nonterminal
    private int Relop() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Relop", true);

        //GRTHN, LSTHN, GREQL, LSEQL, CONEQ, NTEQL
        if((token.code == lex.codeFor("GRTHN")) || (token.code == lex.codeFor("LSTHN")) || 
            (token.code == lex.codeFor("GREQL")) || (token.code == lex.codeFor("LSEQL")) || 
            (token.code == lex.codeFor("CONEQ")) || (token.code == lex.codeFor("NTEQL"))) {
            recur = token.code;
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error("Comparison Operator", token.lexeme);
        }

        trace("Relop", false);
        return recur;
    }

    //same as part A
    //handle the "sign" nonterminal, which is just a + or -
    private int Sign() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Sign", true);

        //validity is checked before this method but if the code enters this method and the token isn't a sign, throw an error
        if((token.code == lex.codeFor("ADD__")) || (token.code == lex.codeFor("SUBTR")))
        {
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error("'+' or '-", token.lexeme);
        }

        trace("Sign", false);
        return recur;
    }

    //same as part A
    //handle the "term" nonterminal
    private int Term() {
        int recur = 0;
        int lhs, rhs = 0;
        int temp = 0;
        int mulopQuad = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Term", true);
        
        //the first element of all terms is a factor so call that first and foremost
        lhs = Factor();

        //same logic applies to this method as the {addop term}* above, but this time with mulop instead of addop and factor instead of term
        while((token.code == lex.codeFor("MULTI") || (token.code == lex.codeFor("DIVID"))) && (!lex.EOF()) && (!anyErrors)) {
            //check if the token is a / or a * to determine the opcode
            if(token.code == lex.codeFor("MULTI"))
                mulopQuad = interp.opcodeFor("MUL");
            else if(token.code == lex.codeFor("DIVID"))
                mulopQuad = interp.opcodeFor("DIV");

            recur = Mulop();
            rhs = Factor();

            //generate a new, unique, random token to assign to temp, reasoning explained in simple expression
            temp = GenSymbol();

            quads.AddQuad(mulopQuad, lhs, rhs, temp); //add the quad
            lhs = temp; //the "new" lhs is now the temp
        }

        trace("Term", false);

        return lhs;
    }

    //same as part A
    //handle the "addop" nonterminal
    private int Addop() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Addop", true);

        //validity is checked before this method but if the code enters this method and the token isn't an addop, throw an error
        if(token.code == lex.codeFor("ADD__")) {
            token = lex.GetNextToken();
        }
        else if (token.code == lex.codeFor("SUBTR")) {
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error("'+' or '-'", token.lexeme);
        }

        trace("Addop", false);
        return recur;
    }

    //same as part A
    //handle the "mulop" nonterminal
    private int Mulop() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }
        trace("Mulop", true);

        //validity is checked before this method but if the code enters this method and the token isn't a sign, throw an error
        if(token.code == lex.codeFor("MULTI")) {
            token = lex.GetNextToken();
        }
        else if(token.code == lex.codeFor("DIVID")) {
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error("'*' or '/'", token.lexeme);
        }

        trace("Mulop", false);
        return recur;
    }

    //same as part A
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
            if(token.code != lex.codeFor("CLOSP") && (!anyErrors)) { //if the simple expression is not followed by a ) then throw an error
                error("')'", token.lexeme);
            }
            else {
                token = lex.GetNextToken();
            }
        }
        else if (!anyErrors){ //if the token is not an accepted factor then throw an error
            error("Number or Variable or '('", token.lexeme);
        }

        trace("Factor", false);

        return recur;
    }

    //same as part A
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
            recur = symbolList.LookupSymbol(token.lexeme);
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error("Number", token.lexeme);
        }
        
        trace("UnsignedNumber", false);
        trace("UnsignedConstant", false);

        return recur;
    }

    //handles all different cases of the statement nonterminal
    private int Statement() {
        int recur = 0;

        trace("Statement", true);

        if(!anyErrors) {
            if (token.code == lex.codeFor("IDENT")) {  //must be an ASSIGNMENT
                recur = handleAssignment();
            }
            else if (token.code == lex.codeFor("BEGIN")) { //must be a block body
                recur = BlockBody();
            }
            else if (token.code == lex.codeFor("IF___")) { //must be an if statement
                recur = HandleIf();
            }
            else if (token.code == lex.codeFor("DWHIL")) { //must be a do while loop
                recur = HandleDoWhile();
            }
            else if (token.code == lex.codeFor("FOR__")) { //must be a for loop
                recur = HandleFor();
            }
            else if (token.code == lex.codeFor("WRITE")) { //must be a writeln statement
                recur = HandleWrite();
            }
            else if (token.code == lex.codeFor("READL")) { //must be a readln statement
                recur = HandleRead();
            }
            else if (token.code == lex.codeFor("REPET")) { //must be a repeat until loop
                recur = HandleRepeat();
            }
            else { //doesn't match any of the statement starts
                error("Statement start", token.lexeme);
            }
        }

        trace("Statement", false);

        //if there are any errors then recover from them
        if(anyErrors) {
            HandleErrors();
            if(anyErrors == false) { //if the error could be resolved, then go back to statement start
                recur = Statement();
            }
        }

        return recur;
    }

    //error recovery loop, iterates through tokens until it finds the end of the current statement (a semicolon) and after that the start of another statement
    //while there are errors and not EOF, get the next token
    //if it is a semicolon then get the next token
    //if that token is the start of a new statement then set anyErrors to false
    private void HandleErrors() {
        trace("HandleErrors", true);

        //special case for if the program is missing a semicolon
        //don't want to go to the next token because the next token is already a statement start
        if(semcoExpected) {
            semcoExpected = false;
            anyErrors = false;
        }
        else {
            while (anyErrors && !(lex.EOF())) {
                token = lex.GetNextToken();
                if(token.code == lex.codeFor("SEMCO")) {
                    token = lex.GetNextToken();
                    if(IsStatementStart()) {
                        anyErrors = false;
                    }
                }
            }
        }
        trace("HandleErrors", false);
    }

    //helper method for error recovery to check if there is a statement start
    //use if else to avoid one single if statement with 7 different "or" checks
    private boolean IsStatementStart() {
        if (token.code == lex.codeFor("IDENT")) {
            return true;
        }
        else if (token.code == lex.codeFor("BEGIN")) {
            return true;
        }
        else if (token.code == lex.codeFor("IF___")) {
            return true;
        }
        else if (token.code == lex.codeFor("DWHIL")) {
            return true;
        }
        else if (token.code == lex.codeFor("FOR__")) {
            return true;
        }
        else if (token.code == lex.codeFor("WRITE")) {
            return true;
        }
        else if (token.code == lex.codeFor("READL")) {
            return true;
        }
        else if (token.code == lex.codeFor("REPET")) {
            return true;
        }
        else {
            return false;
        }
    }

//doesn't need to be changed
//Non-terminal VARIABLE just looks for an IDENTIFIER.  Later, a
//  type-check can verify compatible math ops, or if casting is required.    
    private int Variable(){
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("Variable", true);

        //check if the variable has already been declared
        // if(varList.LookupSymbol(token.lexeme) == -1) {
        //     System.out.println("Undeclared Identifier: " + token.lexeme);
        //     varList.AddSymbol(token.lexeme, 'V', 0);
        // }

        if (token.code == lex.codeFor("IDENT")) {
            //return the location of this variable for quad use
            recur = symbolList.LookupSymbol(token.lexeme);

            // bookkeeping and move on
           token = lex.GetNextToken();
        }
        else if (!anyErrors)
            error("Variable", token.lexeme);

        trace("Variable", false);
        return recur;

    }

    //string constant terminal
    private int StringConstant() {
        int recur = 0;
        if (anyErrors) {
            return -1;
        }

        trace("StringConstant", true);

        if (token.code == lex.codeFor("STRNG")) {
            token = lex.GetNextToken();
        }
        else if (!anyErrors){
            error(lex.reserveFor("STRNG"), token.lexeme);
        }

        trace("StringConstant", false);
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
