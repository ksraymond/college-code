using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventProgrammingPractice
{
    class Classroom
    {
        public event EventHandler Test;
        public Student bobert = new Student("Bobert T. GoldLewis", "Chemistry", 2.5f, true, 1234567890, 50, 50);
        public Student joey = new Student("Joey Jilly", "CS", 3.5f, false, 1234567891, 50, 50);


        public Classroom()
        {
            bobert.SleepsIn += SleepsIn;
            Test += bobert.OnTest;
            Test += bobert.OnTest;
            Test += joey.OnTest;
            bobert.SleepIn();
        }

        public void TestAnnounced()
        {
            Console.WriteLine("A test was announced!");
            Test.Invoke(this, EventArgs.Empty);
        }

        public void SleepsIn(object sender, EventArgs e)
        {
            Console.WriteLine("The Classroom is appauled!");
        }

        public void DropClass(Student student)
        {
            Test -= student.OnTest;
        }

        protected virtual void OnTest(object sender, EventArgs e)
        {
            if(Test != null)
            {
                Test.Invoke(sender, e);
            }
        }
    }
}
