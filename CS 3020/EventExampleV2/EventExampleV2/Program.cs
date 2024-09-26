using System;

namespace EventExampleV2
{
    class Program
    {
        /// <summary>
        /// A program to help us better understand the use and purpose of events
        /// in C#, as well as delegates, event handlers, and EventArgs.
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            Course course = new Course();
            course.DisplayStudentStatus();
            Console.WriteLine("Class dismissed, do what you want.");
            course.RandomActivity();
            course.DisplayStudentStatus();
            course.GivePopQuiz();
            course.DisplayStudentStatus();
        }
    }
}
