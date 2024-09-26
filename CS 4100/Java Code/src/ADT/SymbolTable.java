//Keaton Raymond
//CS 4100-001 Fall 2022

package ADT;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SymbolTable {

    private int currentIndex = 0; //keep track of the current index, i.e. the current size
    private int maxSize; //keep track of the max size, so the user doesn't try to go over
    private SymbolElement symbolArray[]; //an array of symbol objects

    //constructor sets the maxSize variable and builds the array of symbols to maxSize
    public SymbolTable(int maxSize)
    {
        this.maxSize = maxSize;
        this.symbolArray = new SymbolElement[maxSize];

    }

    //adds a symbol with given usage and value to end of symbol table
    //automatically sets correct dataType
    //returns index where symbol is located, if symbol is in table then it returns the row index where the symbol was found
    //if the table already has maxSize rows, then it returns -1
    public int AddSymbol(String symbol, char usage, int value)
    {
        //if the index is out of bounds, return -1
        if(currentIndex == maxSize)
            return -1;
        else
        {
            boolean inTable = false; //used to check if it is in the table
            int tempIndex = 0; //used as return value
            for(int i=0;i<currentIndex;i++) //checking if the symbol is already in the array
            {
                if(symbolArray[i].name == symbol)
                {
                    inTable = true;
                    tempIndex = i;
                    break;
                }
            }

            if(inTable) //if it is in the array, return that index
            {
                return tempIndex;
            }
            else //if it is not, add it and return that index
            {
                symbolArray[currentIndex] = new SymbolElement(symbol, usage, 'I', value, 0, "");
                currentIndex++;
                return currentIndex-1;
            }
        }
    }

    //same as above add symbol but for a double value
    public int AddSymbol(String symbol, char usage, double value)
    {
        if(currentIndex == maxSize)
            return -1;
        else
        {
            boolean inTable = false;
            int tempIndex = 0;
            for(int i=0;i<currentIndex;i++)
            {
                if(symbolArray[i].name == symbol)
                {
                    inTable = true;
                    tempIndex = i;
                    break;
                }
            }

            if(inTable)
            {
                return tempIndex;
            }
            else
            {
                symbolArray[currentIndex] = new SymbolElement(symbol, usage, 'F', 0, value, "");
                currentIndex++;
                return currentIndex-1;
            }
        }
    }
    
    //same as above add symbol but for string value
    public int AddSymbol(String symbol, char usage, String value)
    {
        if(currentIndex == maxSize)
            return -1;
        else
        {
            boolean inTable = false;
            int tempIndex = 0;
            for(int i=0;i<currentIndex;i++)
            {
                if(symbolArray[i].name == symbol)
                {
                    inTable = true;
                    tempIndex = i;
                    break;
                }
            }

            if(inTable)
            {
                return tempIndex;
            }
            else
            {
                symbolArray[currentIndex] = new SymbolElement(symbol, usage, 'S', 0, 0, value);
                currentIndex++;
                return currentIndex-1;
            }
        }
    }

    //looks for a user given symbol, returns index if found or -1 if not found
    public int LookupSymbol(String symbol)
    {
        boolean symbolFound = false; //used to signify if the symbol was found
        int tempIndex = 0; //used as an index if the symbol was found
        for(int i=0; i<currentIndex; i++) //iterate through checking if the symbol is there
        {
            if(symbolArray[i].name.compareToIgnoreCase(symbol) == 0)
            {
                symbolFound = true;
                tempIndex = i;
                break;
            }
        }
        if(symbolFound)
            return tempIndex;
        else
            return -1;
    }

    //returns symbol currently stored at index
    public String GetSymbol(int index)
    {
        return symbolArray[index].name;
    }

    //returns usage stored at index
    public char GetUsage(int index)
    {
        return symbolArray[index].usage;
    }

    //returns data type stored at index
    public char GetDataType(int index)
    {
        return symbolArray[index].dataType;
    }

    //returns string stored at index
    public String GetString(int index)
    {
        return symbolArray[index].stringValue;
    }

    //returns int stored at index
    public int GetInteger(int index)
    {
        return symbolArray[index].integerValue;
    }

    //returns double stored at index
    public double GetFloat(int index)
    {
        return symbolArray[index].floatValue;
    }

    //sets usage and int value fields for the symbol at index
    public void UpdateSymbol(int index, char usage, int value)
    {
        symbolArray[index].usage = usage;
        symbolArray[index].integerValue = value;
    }

    //sets usage and double value fields for the symbol at index
    public void UpdateSymbol(int index, char usage, double value)
    {
        symbolArray[index].usage = usage;
        symbolArray[index].floatValue = value;
    }

    //sets usage and string value fields for the symbol at index
    public void UpdateSymbol(int index, char usage, String value)
    {
        symbolArray[index].usage = usage;
        symbolArray[index].stringValue = value;
    }

    //prints the symbol table to a user given file
    public void PrintSymbolTable(String filename)
    {
        try
       {
            FileOutputStream outputStream = new FileOutputStream(filename);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(String.format("%-10s%-25s%-10s%-13s%s\n", 
                                "Index", "Symbol", "Usage", "dataType", "Value"));
            for(int i = 0; i<currentIndex; i++)
            {
                //different format for each type so that each one uses it's own type
                if(symbolArray[i].dataType == 'I')
                {
                    bufferedWriter.write(String.format("%-10d%-25s%-10c%-13c%d\n", 
                                        i, symbolArray[i].name, symbolArray[i].usage, symbolArray[i].dataType, 
                                        symbolArray[i].integerValue));
                }
                else if(symbolArray[i].dataType == 'F')
                {
                    bufferedWriter.write(String.format("%-10d%-25s%-10c%-13c%f\n", 
                                        i, symbolArray[i].name, symbolArray[i].usage, symbolArray[i].dataType,
                                        symbolArray[i].floatValue));
                }
                else
                {
                    bufferedWriter.write(String.format("%-10d%-25s%-10c%-13c%s\n", 
                                        i, symbolArray[i].name, symbolArray[i].usage, symbolArray[i].dataType, 
                                        symbolArray[i].stringValue));
                }
            }
            bufferedWriter.close();
       } catch(IOException e)
       {
            e.printStackTrace();
       }
    }

    //internal class to hold the info for each of the symbols
    private class SymbolElement
    {
        private String name; //symbol
        private char usage; //Label, Variable, or Constant
        private char dataType; //String, Int or Float
        private int integerValue;
        private double floatValue;
        private String stringValue;

        SymbolElement(String name, char usage, char dataType, int integerValue, double floatValue, String stringValue)
        {
            this.name = name;
            this.usage = usage;
            this.dataType = dataType;
            this.integerValue = integerValue;
            this.floatValue = floatValue;
            this.stringValue = stringValue;
        }
    }
}
