namespace DFAImplementation
{
    class Program
    {
        static void Main(string[] args)
        {
            StreamReader reader = new StreamReader("DFA1.txt");

            //variable definitions
            string inputString;
            char[] inputArray;
            int alphabetIndex;
            int currentState;
            int acceptState;
            char[] alphabetString = reader.ReadLine().Split("\t\t;")[0].ToCharArray(); //put alphabet into a char array
            int[,] transitionTable = new int[alphabetString.Length, Convert.ToInt32(reader.ReadLine().Split("\t\t;")[0])]; //create transition table array w/ dimensions
            
            //fill transition table
            string[] tempStateTransitions;
            for (int i = 0; i < transitionTable.GetLength(1); i++)
            {
                tempStateTransitions = reader.ReadLine().Split("\t\t;")[0].Split(" ");

                for (int j = 0; j < transitionTable.GetLength(0); j++)
                {
                    transitionTable[j, i] = Convert.ToInt32(tempStateTransitions[j]);
                }
            }

            acceptState = Convert.ToInt32(reader.ReadLine().Split("\t\t;")[0]); //read accept state

            reader.Close();

            //prompt for initial string
            Console.WriteLine("Type \"done\" to quit");
            Console.Write("Input a string: ");
            inputString = Console.ReadLine();

            
            while (inputString != "done")
            {
                //reset variables
                inputArray = inputString.ToCharArray();
                currentState = 0;

                //go through all states in the string
                for(int i = 0; i < inputArray.Length; i++)
                {
                    alphabetIndex = GetAlphabetIndex(alphabetString, inputArray[i]);
                    currentState = transitionTable[alphabetIndex, currentState];
                }

                //check for accept state
                if (currentState == acceptState)
                    Console.WriteLine("String {0} is accepted.", inputString);
                else
                    Console.WriteLine("String {0} is rejected.", inputString);

                //ask for new string
                Console.Write("Input a string: ");
                inputString = Console.ReadLine();
            }
        }

        //gets the index that matches to the character of the input
        static int GetAlphabetIndex(char[] alphabet, char letter)
        {
            int letterIndex = 0;
            for(int i = 0; i < alphabet.Length; i++)
            {
                if (alphabet[i] == letter)
                    letterIndex = i;
            }
            return letterIndex;
        }
    }
}
