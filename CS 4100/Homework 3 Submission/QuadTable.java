//Keaton Raymond
//CS 4100-001 Fall 2022

package ADT;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class QuadTable {
    private int nextAvailable = 0; //keeps track of the current size of the array
    private int[][] quadArray; //2d int array for the quad table

    //constructor builds the 2d array with maxSize rows
    public QuadTable(int maxSize)
    {
        quadArray = new int[maxSize][4];
    }

    //returns index of the next open slot in quad table
    public int NextQuad()
    {
        return nextAvailable;
    }

    //adds a new quad to the quad table
    //increments the nextAvailable variable to keep track of the active size
    public void AddQuad(int opcode, int op1, int op2, int op3)
    {
        quadArray[nextAvailable][0] = opcode;
        quadArray[nextAvailable][1] = op1;
        quadArray[nextAvailable][2] = op2;
        quadArray[nextAvailable][3] = op3;

        nextAvailable++;
    }

    //returns the quad at a given index
    public int[] GetQuad(int index)
    {
        return quadArray[index];
    }
    
    //change contents of an existing quad's 3rd operand at index
    public void UpdateJump(int index, int op3)
    {
        quadArray[index][3] = op3;
    }

    //prints the quad table to a user given file
    public void PrintQuadTable(String filename)
    {
        try
       {
            FileOutputStream outputStream = new FileOutputStream(filename);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("Index\tOpcode\top1\top2\top3\n");
            for(int i = 0; i<nextAvailable; i++)
            {
                bufferedWriter.write(i + "\t" + quadArray[i][0] + "\t" + 
                                    quadArray[i][1] + "\t" + quadArray[i][2] + "\t" + quadArray[i][3] + "\n");
            }

            bufferedWriter.close();
       } catch(IOException e)
       {
            e.printStackTrace();
       }
    }
}
