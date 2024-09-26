/* Keaton Raymond
 * CS 4100-001
 * Part 2: Lexical Analyzer
 */
package ADT;

/**
 *
 * @author abrouill
 */
import java.io.*;

public class Lexical {

    private File file;                        //File to be read for input
    private FileReader filereader;            //Reader, Java reqd
    private BufferedReader bufferedreader;    //Buffered, Java reqd
    private String line;                      //Current line of input from file   
    private int linePos;                      //Current character position
    //  in the current line
    private SymbolTable saveSymbols;          //SymbolTable used in Lexical
    //  sent as parameter to construct
    private boolean EOF;                      //End Of File indicator
    private boolean echo;                     //true means echo each input line
    private boolean printToken;               //true to print found tokens here
    private int lineCount;                    //line #in file, for echo-ing
    private boolean needLine;                 //track when to read a new line

//Tables to hold the reserve words and the mnemonics for token codes
    private final int sizeReserveTable = 50;
    private ReserveTable reserveWords = new ReserveTable(sizeReserveTable); //a few more than # reserves
    private ReserveTable mnemonics = new ReserveTable(sizeReserveTable); //a few more than # reserves

    //constructor
    public Lexical(String filename, SymbolTable symbols, boolean echoOn) {
        saveSymbols = symbols;  //map the initialized parameter to the local ST
        echo = echoOn;          //store echo status
        lineCount = 0;          //start the line number count
        line = "";              //line starts empty
        needLine = true;        //need to read a line
        printToken = false;     //default OFF, do not print tokens here
        //  within GetNextToken; call setPrintToken to
        //  change it publicly.
        linePos = -1;           //no chars read yet
        //call initializations of tables
        initReserveWords(reserveWords);
        initMnemonics(mnemonics);

        //set up the file access, get first character, line retrieved 1st time
        try {
            file = new File(filename);    //creates a new file instance  
            filereader = new FileReader(file);   //reads the file  
            bufferedreader = new BufferedReader(filereader);  //creates a buffering character input stream  
            EOF = false;
            currCh = GetNextChar();
        } catch (IOException e) {
            EOF = true;
            e.printStackTrace();
        }
    }

    // inner class "token" is declared here, no accessors needed
    public class token {

        public String lexeme;
        public int code;
        public String mnemonic;

        token() {
            lexeme = "";
            code = 0;
            mnemonic = "";
        }
    }
  
// ******************* PUBLIC USEFUL METHODS
// These are nice for syntax to call later 
// given a mnemonic, find its token code value
    public int codeFor(String mnemonic) {
        return mnemonics.LookupName(mnemonic);
    }

// given a mnemonic, return its reserve word
    public String reserveFor(String mnemonic) {
        return reserveWords.LookupCode(mnemonics.LookupName(mnemonic));
    }

    // Public access to the current End Of File status
    public boolean EOF() {
        return EOF;
    }
// DEBUG enabler, turns on/OFF token printing inside of GetNextToken

    public void setPrintToken(boolean on) {
        printToken = on;
    }

    //initialize the reserve words table
    private void initReserveWords(ReserveTable reserveWords) {
//  Student must provide the rest
        reserveWords.Add("GOTO", 0);
        reserveWords.Add("INTEGER", 1);
        reserveWords.Add("TO", 2);
        reserveWords.Add("DO", 3);
        reserveWords.Add("IF", 4);
        reserveWords.Add("THEN", 5);
        reserveWords.Add("ELSE", 6);
        reserveWords.Add("FOR", 7);
        reserveWords.Add("OF", 8);
        reserveWords.Add("WRITELN", 9);
        reserveWords.Add("READLN", 10);
        reserveWords.Add("BEGIN", 11);
        reserveWords.Add("END", 12);
        reserveWords.Add("VAR", 13);
        reserveWords.Add("DOWHILE", 14);
        reserveWords.Add("UNIT", 15);
        reserveWords.Add("LABEL", 16);
        reserveWords.Add("REPEAT", 17);
        reserveWords.Add("UNTIL", 18);
        reserveWords.Add("PROCEDURE", 19);
        reserveWords.Add("DOWNTO", 20);
        reserveWords.Add("FUNCTION", 21);
        reserveWords.Add("RETURN", 22);
        reserveWords.Add("FLOAT", 23);
        reserveWords.Add("STRING", 24);
        reserveWords.Add("ARRAY", 25);
        //1 and 2-char
        reserveWords.Add("/", 30);
        reserveWords.Add("*", 31);
        reserveWords.Add("+", 32);
        reserveWords.Add("-", 33);
        reserveWords.Add("(", 34);
        reserveWords.Add(")", 35);
        reserveWords.Add(";", 36);
        reserveWords.Add(":=", 37); //assignment
        reserveWords.Add(">", 38);
        reserveWords.Add("<", 39);
        reserveWords.Add(">=", 40);
        reserveWords.Add("<=", 41);
        reserveWords.Add("=", 42); //conditional equal
        reserveWords.Add("<>", 43); //not equal to
        reserveWords.Add(",", 44);
        reserveWords.Add("[", 45);
        reserveWords.Add("]", 46);
        reserveWords.Add(":", 47);
        reserveWords.Add(".", 48);
        reserveWords.Add("INVALID", 99);
    }

    //initialize the mnemonics for the reserve words
    private void initMnemonics(ReserveTable mnemonics) {
        // Student must create their own 5-char mnemonics
        mnemonics.Add("GOTO_", 0);
        mnemonics.Add("INTEG", 1);
        mnemonics.Add("TO___", 2);
        mnemonics.Add("DO___", 3);
        mnemonics.Add("IF___", 4);
        mnemonics.Add("THEN_", 5);
        mnemonics.Add("ELSE_", 6);
        mnemonics.Add("FOR__", 7);
        mnemonics.Add("OF___", 8);
        mnemonics.Add("WRITE", 9);
        mnemonics.Add("READL", 10);
        mnemonics.Add("BEGIN", 11);
        mnemonics.Add("END__", 12);
        mnemonics.Add("VAR__", 13);
        mnemonics.Add("DWHIL", 14);
        mnemonics.Add("UNIT_", 15);
        mnemonics.Add("LABEL", 16);
        mnemonics.Add("REPET", 17);
        mnemonics.Add("UNTIL", 18);
        mnemonics.Add("PROCE", 19);
        mnemonics.Add("DOWNT", 20);
        mnemonics.Add("FUNCT", 21);
        mnemonics.Add("RETUR", 22);
        mnemonics.Add("FLOAT", 23);
        mnemonics.Add("STRIN", 24);
        mnemonics.Add("ARRAY", 25);
        //1 and 2-char
        mnemonics.Add("DIVID", 30);
        mnemonics.Add("MULTI", 31);
        mnemonics.Add("ADD__", 32);
        mnemonics.Add("SUBTR", 33);
        mnemonics.Add("OPENP", 34);
        mnemonics.Add("CLOSP", 35);
        mnemonics.Add("SEMCO", 36);
        mnemonics.Add("EQUAL", 37); //assignment
        mnemonics.Add("GRTHN", 38);
        mnemonics.Add("LSTHN", 39);
        mnemonics.Add("GREQL", 40);
        mnemonics.Add("LSEQL", 41);
        mnemonics.Add("CONEQ", 42); //conditional equal
        mnemonics.Add("NTEQL", 43); //not equal to
        mnemonics.Add("COMMA", 44);
        mnemonics.Add("OPENB", 45);
        mnemonics.Add("CLOSB", 46);
        mnemonics.Add("COLON", 47);
        mnemonics.Add("PERIO", 48);
        mnemonics.Add("IDENT", 50);
        mnemonics.Add("_INT_", 51);
        mnemonics.Add("FCNST", 52);
        mnemonics.Add("STRNG", 53);
        mnemonics.Add("INVAL", 99);
    }


// ********************** UTILITY FUNCTIONS
    private void consoleShowError(String message) {
        System.out.println("**** ERROR FOUND: " + message);
    }

    // Character category for alphabetic chars
    private boolean isLetter(char ch) {
        return (((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z')));
    }

    // Character category for 0..9 
    private boolean isDigit(char ch) {
        return ((ch >= '0') && (ch <= '9'));
    }

    // Category for any whitespace to be skipped over
    private boolean isWhitespace(char ch) {
        // SPACE, TAB, NEWLINE are white space
        return ((ch == ' ') || (ch == '\t') || (ch == '\n'));
    }

    // Returns the VALUE of the next character without removing it from the
    //    input line.  Useful for checking 2-character tokens that start with
    //    a 1-character token.
    private char PeekNextChar() {
        char result = ' ';
        if ((needLine) || (EOF)) {
            result = ' '; //at end of line, so nothing
        } else // 
        {
            if ((linePos + 1) < line.length()) { //have a char to peek
                result = line.charAt(linePos + 1);
            }
        }
        return result;
    }

    // Called by GetNextChar when the cahracters in the current line are used up.
    // STUDENT CODE SHOULD NOT EVER CALL THIS!
    private void GetNextLine() {
        try {
            line = bufferedreader.readLine();
            if ((line != null) && (echo)) {
                lineCount++;
                System.out.println(String.format("%04d", lineCount) + " " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null) {    // The readLine returns null at EOF, set flag
            EOF = true;
        }
        linePos = -1;      // reset vars for new line if we have one
        needLine = false;  // we have one, no need
        //the line is ready for the next call to get a character
    }

    // Called to get the next character from file, automatically gets a new
    //      line when needed. CALL THIS TO GET CHARACTERS FOR GETIDENT etc.
    public char GetNextChar() {
        char result;
        if (needLine) //ran out last time we got a char, so get a new line
        {
            GetNextLine();
        }
        //try to get char from line buff
        if (EOF) {
            result = '\n';
            needLine = false;
        } else {
            if ((linePos < line.length() - 1)) { //have a character available
                linePos++;
                result = line.charAt(linePos);
            } else { //need a new line, but want to return eoln on this call first
                result = '\n';
                needLine = true; //will read a new line on next GetNextChar call
            }
        }
        return result;
    }

// The constants below allow flexible comment start/end characters    
    final char commentStart_1 = '{';
    final char commentEnd_1 = '}';
    final char commentStart_2 = '(';
    final char commentPairChar = '*';
    final char commentEnd_2 = ')';

// Skips past single and multi-line comments, and outputs UNTERMINATED 
//  COMMENT when end of line is reached before terminating
    String unterminatedComment = "Comment not terminated before End Of File";

    public char skipComment(char curr) {
        if (curr == commentStart_1) {
            curr = GetNextChar();
            while ((curr != commentEnd_1) && (!EOF)) {
                curr = GetNextChar();
            }
            if (EOF) {
                consoleShowError(unterminatedComment);
            } else {
                curr = GetNextChar();
            }
        } else {
            if ((curr == commentStart_2) && (PeekNextChar() == commentPairChar)) {
                curr = GetNextChar(); // get the second
                curr = GetNextChar(); // into comment or end of comment
//            while ((curr != commentPairChar) && (PeekNextChar() != commentEnd_2) &&(!EOF)) {
                while ((!((curr == commentPairChar) && (PeekNextChar() == commentEnd_2))) && (!EOF)) {
//                if (lineCount >=4) {
                    //              System.out.println("In Comment, curr, peek: "+curr+", "+PeekNextChar());}
                    curr = GetNextChar();
                }
                if (EOF) {
                    consoleShowError(unterminatedComment);
                } else {
                    curr = GetNextChar();          //must move past close
                    curr = GetNextChar();          //must get following
                }
            }

        }
        return (curr);
    }

    // Reads past all whitespace as defined by isWhiteSpace
    // NOTE THAT COMMENTS ARE SKIPPED AS WHITESPACE AS WELL!
    public char skipWhiteSpace() {

        do {
            while ((isWhitespace(currCh)) && (!EOF)) {
                currCh = GetNextChar();
            }
            currCh = skipComment(currCh);
        } while (isWhitespace(currCh) && (!EOF));
        return currCh;
    }

    private boolean isPrefix(char ch) {
        return ((ch == ':') || (ch == '<') || (ch == '>'));
    }

    private boolean isStringStart(char ch) {
        return ch == '"';
    }

//global char
    char currCh;

    //if the token starts with a letter, then it is an identifier
    private token getIdentifier() {
        token result = new token();
        result.lexeme = "" + currCh;
        currCh = GetNextChar(); //without this line the first character is added to the lexeme twice
        boolean tooLong = false;

        //while the input satisfies the restrictions for identifiers
        while(isLetter(currCh) || isDigit(currCh) || currCh == '_')
        {
            //ensure that the identifier isn't too long
            if(result.lexeme.length() < 20)
                result.lexeme = result.lexeme + currCh;
            else
                tooLong = true;

            currCh = GetNextChar();
        }

        if(tooLong)
            consoleShowError("Identifier too long");

        if(reserveWords.LookupName(result.lexeme) == -1) //not a reserve word
        {
            result.code = 50;
            result.mnemonic = mnemonics.LookupCode(result.code);
            if(saveSymbols.LookupSymbol(result.lexeme) == -1) //if not in symbol table, add it to the symbol table
                saveSymbols.AddSymbol(result.lexeme, 'V', 0);
        }
        else //is a reserve word
        {
            result.code = reserveWords.LookupName(result.lexeme);
            result.mnemonic = mnemonics.LookupCode(result.code);
        }

        return result;
    }

    //if the token starts with a number, then it is either an int, float, or exponent
    private token getNumber() {
        /* a number is:   <digit>+[.<digit>*[E<digit>+]] */
        token result = new token();
        result.lexeme = "" + currCh;
        currCh = GetNextChar();
        boolean tooLong = false;
        boolean isFloat = false;
        boolean isInt = true;

        //while the input satisfies the restrictions for numbers
        while(isDigit(currCh) || currCh == '.' || currCh == 'E')
        {
            if(currCh == '.') //check if float
            {
                isInt = false;
                isFloat = true;
            }

            if(result.lexeme.length() < 6 && isInt) //if it meets the length requirements for an int
            {
                result.lexeme = result.lexeme + currCh;
            }
            else if(result.lexeme.length() < 12 && isFloat) //if it meets the length requirements for a float
            {
                result.lexeme = result.lexeme + currCh;
            }
            else //if it is too long, don't add to the lexeme and set a boolean to true
            {
                tooLong = true;
            }
            currCh = GetNextChar();
        }

        if(tooLong) //if it is too long, then give an error
        {
            consoleShowError("Numeric constant too long");
        }

        if(isInt && integerOK(result.lexeme)) //if int and is a valid integer
        {
            result.code = 51;
            result.mnemonic = mnemonics.LookupCode(result.code);
            if(saveSymbols.LookupSymbol(result.lexeme) == -1) //if not in symbol table, add as a constant
                saveSymbols.AddSymbol(result.lexeme, 'C', Integer.parseInt(result.lexeme));
        }
        else if(isFloat && doubleOK(result.lexeme)) //if double and is a valid double
        {
            result.code = 52;
            result.mnemonic = mnemonics.LookupCode(result.code);
            if(saveSymbols.LookupSymbol(result.lexeme) == -1) //if not in symbol table, add as a constant
                saveSymbols.AddSymbol(result.lexeme, 'C', Double.parseDouble(result.lexeme));
        }
        else //else if it is not a valid int or double, code 99
        {
            consoleShowError("Invalid number.");
            result.code = 99;
            result.mnemonic = mnemonics.LookupCode(result.code);
        }

        return result;
    }

    //if the token begins with a "
    private token getString() {
        token result = new token();
        currCh = GetNextChar(); //don't have the result.lexeme = "" + currCh because then it includes the double quote in the token
        boolean invalid = false;

        //while it meets the requirements for being a string
        while(!EOF() && currCh != '\n' && currCh != '"')
        {
            result.lexeme = result.lexeme + currCh;
            currCh = GetNextChar();
        }

        //if the while loop was exited because of EOF or end of line, then the string is invalid
        if(EOF() || currCh == '\n')
        {
            consoleShowError("Unterminated string found.");
            invalid = true;
        }

        if(!invalid) //if string is valid, code 53
        {
            result.code = 53;
            result.mnemonic = mnemonics.LookupCode(result.code);
            if(saveSymbols.LookupSymbol(result.lexeme) == -1) //if not in symbol table, add to symbol table
                saveSymbols.AddSymbol(result.lexeme, 'C', result.lexeme);
        }
        else //if string is invalid, then it gets the invalid token code
        {
            result.code = 99;
            result.mnemonic = mnemonics.LookupCode(result.code);
        }

        //skips over the last double quote so that it isn't counted as an identifier
        //also skips over EOF or end of line but that doesn't cause any issues
        currCh = GetNextChar(); 

        return result;
    }

    //if the token doesn't match any of the other token types, either a 1-2 char operator or it is an invalid symbol
    private token getOtherToken() {
        token result = new token();
        result.lexeme = "" + currCh;

        //if the 1 char token is a prefix character and the next character is a special character then add the next character to the lexeme
        if(isPrefix(currCh) && !isWhitespace(PeekNextChar()) && !isDigit(PeekNextChar()) && !isLetter(PeekNextChar()) && !isStringStart(PeekNextChar()))
        {
            currCh = GetNextChar();
            result.lexeme = result.lexeme + currCh;
        }

        if(reserveWords.LookupName(result.lexeme) == -1) //not a reserve word, give code 99 for invalid
        {
            result.code = 99;
            result.mnemonic = mnemonics.LookupCode(result.code);
        }
        else //is a reserve word, get the correct code and mnemonic
        {
            result.code = reserveWords.LookupName(result.lexeme);
            result.mnemonic = mnemonics.LookupCode(result.code);
        }

        //without this, it will enter an infinite loop
        currCh = GetNextChar();

        return result;
    }

    // Checks to see if a string contains a valid DOUBLE 
    public boolean doubleOK(String stin) {
        boolean result;
        Double x;
        try {
            x = Double.parseDouble(stin);
            result = true;
        } catch (NumberFormatException ex) {
            result = false;
        }
        return result;
    }

    // Checks the input string for a valid INTEGER
    public boolean integerOK(String stin) {
        boolean result;
        int x;
        try {
            x = Integer.parseInt(stin);
            result = true;
        } catch (NumberFormatException ex) {
            result = false;
        }
        return result;
    }
    


    public token GetNextToken() {
        token result = new token();

        currCh = skipWhiteSpace();
        if (isLetter(currCh)) { //is identifier
            result = getIdentifier();
        } else if (isDigit(currCh)) { //is numeric
            result = getNumber();
        } else if (isStringStart(currCh)) { //string literal
            result = getString();
        } else //default char checks
        {
            result = getOtherToken();
        }

        if ((result.lexeme.equals("")) || (EOF)) {
            result = null;
        }
//set the mnemonic
        if (result != null) {
// THIS LINE REMOVED-- PUT BACK IN TO USE LOOKUP            
            result.mnemonic = mnemonics.LookupCode(result.code);
            if (printToken) {
                System.out.println("\t" + result.mnemonic + " | \t" + String.format("%04d", result.code) + " | \t" + result.lexeme);
            }
        }
        return result;

    }

}
