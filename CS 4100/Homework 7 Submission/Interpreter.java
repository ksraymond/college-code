package ADT;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Interpreter {

    Scanner scanner = new Scanner(System.in); //input scanner for the READ opcode
    private ReserveTable opTable;
    private int maxOpcode = 16; //used to keep track of how many opcodes in the opTable
    
    //constructor
    public Interpreter()
    {
         opTable = new ReserveTable(maxOpcode);
         initReserve(opTable);
    }

    //iterate through the quad table doing the quad operations
    public void InterpretQuads(QuadTable qTable, SymbolTable sTable, boolean traceOn, String filename)
    {
        int pc = 0;
        int[] holdQuad; //used to hold the quad that is currently being looked at
        int mathVal; //used as a holder var for math  operations
        String traceString;
        

        //while still within bounds of the quad table
        while(pc<qTable.NextQuad())
        {
            holdQuad = qTable.GetQuad(pc);

            if(traceOn) //print trace string to output and file
            {
                traceString = makeTraceString(pc, holdQuad[0], holdQuad[1], holdQuad[2], holdQuad[3]);

                System.out.println(traceString); //print to console
                
                //print to file
                try(FileWriter fw = new FileWriter(filename, true);
                    BufferedWriter writer = new BufferedWriter(fw))
                {
                    writer.write(traceString + "\n");
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(holdQuad[0] >= 0 && holdQuad[0] < maxOpcode) //verify valid opcode
            {
                if(holdQuad[0] == 0)//STOP
                {
                    System.out.println("Execution terminated by program STOP.");
                    //also print to file
                    pc = qTable.NextQuad();
                }
                else if(holdQuad[0] == 1)//DIV
                {
                    mathVal = (sTable.GetInteger(holdQuad[1])/sTable.GetInteger(holdQuad[2]));
                    sTable.UpdateSymbol(holdQuad[3], 'V', mathVal);
                    pc++;
                }
                else if(holdQuad[0] == 2)//MUL
                {
                    mathVal = (sTable.GetInteger(holdQuad[1])*sTable.GetInteger(holdQuad[2]));
                    sTable.UpdateSymbol(holdQuad[3], 'V', mathVal);
                    pc++;
                }
                else if(holdQuad[0] == 3)//SUB
                {
                    mathVal = (sTable.GetInteger(holdQuad[1])-sTable.GetInteger(holdQuad[2]));
                    sTable.UpdateSymbol(holdQuad[3], 'V', mathVal);
                    pc++;
                }
                else if(holdQuad[0] == 4)//ADD
                {
                    mathVal = (sTable.GetInteger(holdQuad[1])+sTable.GetInteger(holdQuad[2]));
                    sTable.UpdateSymbol(holdQuad[3], 'V', mathVal);
                    pc++;
                }
                else if(holdQuad[0] == 5)//MOV
                {
                    //assign value in op 1 into op 3
                    sTable.UpdateSymbol(holdQuad[3], sTable.GetUsage(holdQuad[1]), sTable.GetInteger(holdQuad[1]));
                    pc++;
                }
                else if(holdQuad[0] == 6)//PRINT
                {
                    char type = sTable.GetDataType(holdQuad[3]);
                    
                    if(type == 'I')
                    {
                        System.out.println(sTable.GetInteger(holdQuad[3]));
                    }
                    else if(type == 'F')
                    {
                        System.out.println(sTable.GetFloat(holdQuad[3]));
                    }
                    else
                    {
                        System.out.println(sTable.GetString(holdQuad[3]));
                    }
                    pc++;
                }
                else if(holdQuad[0] == 7)//READ
                {
                    int num;
                    num = scanner.nextInt();

                    sTable.UpdateSymbol(holdQuad[3], 'V', num);
                    pc++;
                }
                else if(holdQuad[0] == 8)//JMP
                {
                    pc = holdQuad[3];
                }
                else if(holdQuad[0] == 9)//JZ
                {
                    if(sTable.GetInteger(holdQuad[1]) == 0)
                    {
                        pc = holdQuad[3];
                    }
                    else
                    {
                        pc++;
                    }
                }
                else if(holdQuad[0] == 10)//JP
                {
                    if(sTable.GetInteger(holdQuad[1]) > 0)
                    {
                        pc = holdQuad[3];
                    }
                    else
                    {
                        pc++;
                    }
                }
                else if(holdQuad[0] == 11)//JN
                {
                    if(sTable.GetInteger(holdQuad[1]) < 0)
                    {
                        pc = holdQuad[3];
                    }
                    else
                    {
                        pc++;
                    }
                }
                else if(holdQuad[0] == 12)//JNZ
                {
                    if(sTable.GetInteger(holdQuad[1]) != 0)
                    {
                        pc = holdQuad[3];
                    }
                    else
                    {
                        pc++;
                    }
                }
                else if(holdQuad[0] == 13)//JNP
                {
                    if(sTable.GetInteger(holdQuad[1]) <= 0)
                    {
                        pc = holdQuad[3];
                    }
                    else
                    {
                        pc++;
                    }
                }
                else if(holdQuad[0] == 14)//JNN
                {
                    if(sTable.GetInteger(holdQuad[1]) >= 0)
                    {
                        pc = holdQuad[3];
                    }
                    else
                    {
                        pc++;
                    }
                }
                else//JINDR
                {
                    pc = sTable.GetInteger(holdQuad[3]);
                }
            }
            else
            {
                System.out.println("invalid opcode");
                break;
            }
         }
    }

    //initalize the symbol and quad tables for the summation test
    public boolean initializeFactorialTest(SymbolTable sTable, QuadTable qTable)
    {
        sTable.AddSymbol("n", 'V', 10);
        sTable.AddSymbol("i", 'V', 0);
        sTable.AddSymbol("product", 'V', 0);
        sTable.AddSymbol("1", 'C', 1);
        sTable.AddSymbol("$temp", 'V', 0);

        qTable.AddQuad(5, 3, 0, 2);
        qTable.AddQuad(5, 3, 0, 1);
        qTable.AddQuad(3, 1, 0, 4);
        qTable.AddQuad(10, 4, 0, 7);
        qTable.AddQuad(2, 2, 1, 2);
        qTable.AddQuad(4, 1, 3, 1);
        qTable.AddQuad(8, 0, 0, 2);
        qTable.AddQuad(6, 0, 0, 2);
        qTable.AddQuad(0, 0, 0, 0);
        return true;
    }
    
    //initialize the symbol and quad tables for the summation test
    public boolean initializeSummationTest(SymbolTable sTable, QuadTable qTable)
    {
        sTable.AddSymbol("n", 'V', 10);
        sTable.AddSymbol("i", 'V', 0);
        sTable.AddSymbol("sum", 'V', 0);
        sTable.AddSymbol("1", 'C', 1);
        sTable.AddSymbol("$temp", 'V', 0);

        qTable.AddQuad(5, 3, 0, 1);
        qTable.AddQuad(3, 1, 0, 4);
        qTable.AddQuad(10, 4, 0, 6);
        qTable.AddQuad(4, 2, 1, 2);
        qTable.AddQuad(4, 1, 3, 1);
        qTable.AddQuad(8, 0, 0, 1);
        qTable.AddQuad(6, 0, 0, 2);
        qTable.AddQuad(0, 0, 0, 0);
        return true;
    }

    //initialize the reserve table for the language
    private void initReserve(ReserveTable opTable)
    {
        opTable.Add("STOP", 0);
        opTable.Add("DIV", 1);
        opTable.Add("MUL", 2);
        opTable.Add("SUB", 3);
        opTable.Add("ADD", 4);
        opTable.Add("MOV", 5);
        opTable.Add("PRINT", 6);
        opTable.Add("READ", 7);
        opTable.Add("JMP", 8);
        opTable.Add("JZ", 9);
        opTable.Add("JP", 10);
        opTable.Add("JN", 11);
        opTable.Add("JNZ", 12);
        opTable.Add("JNP", 13);
        opTable.Add("JNN", 14);
        opTable.Add("JINDR", 15);
   }

    public int opcodeFor(String reserveWord) {
        return opTable.LookupName(reserveWord);
    }

   //make and return the formatted trace string if trace is on
   private String makeTraceString(int pc, int opcode,int op1,int op2,int op3){
    String result = "";
    result = "PC = "+String.format("%04d", pc)+": "+(opTable.LookupCode(opcode)
            +"     ").substring(0,6)+String.format("%02d",op1)+
                            ", "+String.format("%02d",op2)+", "
            +String.format("%02d",op3);
    return result;
}
}
