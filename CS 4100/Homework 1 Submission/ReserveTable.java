package ADT;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ReserveTable {
    private int currentSize = 0; //used to add elements to the end of the list and so that, if extra spaces are created, they aren't printed
    private ReserveElement reserveArray[]; //array of reserved words

    //constructor builds the array with the given max size
    public ReserveTable(int maxSize)
    {
        this.reserveArray = new ReserveElement[maxSize];
    }

    //add new row to storage with name and code
    //returns index of row where data was placed
    public int Add(String name, int code)
    {
        reserveArray[currentSize] = new ReserveElement(code, name);
        currentSize++;
        return currentSize-1;
    }

    //returns the code associated with a given name if it is in the table
    //if not in the table, return -1
    public int LookupName(String name)
    {
        for(int i = 0; i<currentSize; i++)
        {
            if(reserveArray[i].name.compareToIgnoreCase(name) == 0)
                return reserveArray[i].code;
        }
        return -1;
    }

    //returns the name associated with a given code if it is in the table
    //if not in the table, return empty string
    public String LookupCode(int code)
    {
        for(int i = 0; i<currentSize; i++)
        {
            if(reserveArray[i].code == code)
                return reserveArray[i].name;
        }
        return "";
    }

    //prints the reserve table to the user given file
    public void PrintReserveTable(String filename)
    {
       try
       {
            FileOutputStream outputStream = new FileOutputStream(filename);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("Index\tName\tCode\n");
            for(int i = 0; i<currentSize; i++)
            {
                bufferedWriter.write(i + "\t" + reserveArray[i].name + "\t" + reserveArray[i].code + "\n");
            }

            bufferedWriter.close();
       } catch(IOException e)
       {
            e.printStackTrace();
       }

        
    }

    //internal class to hold the information for each of the reserve words
    private class ReserveElement 
    {
        private int code;
        private String name;

        ReserveElement(int code, String name)
        {
            this.code = code;
            this.name = name;
        }
    }
}
