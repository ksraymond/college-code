using System;

namespace EventProgrammingPractice
{
    class Program
    {
        static void Main(string[] args)
        {
            Classroom theClass = new Classroom();

            theClass.TestAnnounced();
            theClass.DropClass(theClass.joey);
            theClass.TestAnnounced();
        }
    }
}
