using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventProgrammingPractice
{
    class Student
    {

        public event EventHandler SleepsIn;

        //you can just type out these variables, right click, refactoring, generate constructor
        //also can click encapsulate field but still use field to generate getters and setters
        string name;
        string major;
        float grade;
        bool hangry;
        int sid;
        int sadness;
        int energy;

        public Student(string name, string major, float grade, bool hangry, int sid, int sadness, int energy)
        {
            this.name = name;
            this.major = major;
            this.grade = grade;
            this.hangry = hangry;
            this.sid = sid;
            this.sadness = sadness;
            this.energy = energy;
            this.SleepsIn += OnSleepIn;
            SleepIn();
        }

        public void OnTest(object sender, EventArgs e)
        {
            Console.WriteLine($"{name} starts to Panic!");
        }

        public void SleepIn()
        {
            SleepsIn.Invoke(this, EventArgs.Empty);
        }

        public void OnSleepIn(object sender, EventArgs e)
        {
            Console.WriteLine($"{name} slept in");
        }

        public string Name { get => name; set => name = value; }
        public string Major { get => major; set => major = value; }
        public float Grade { get => grade; set => grade = value; }
        public bool Hangry { get => hangry; set => hangry = value; }
        public int Sid { get => sid; set => sid = value; }
        public int Sadness { get => sadness; set => sadness = value; }
        public int Energy { get => energy; set => energy = value; }
    }
}
