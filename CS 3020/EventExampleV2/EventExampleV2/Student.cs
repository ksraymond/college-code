using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventExampleV2
{
    class Student
    {
        //events for students
        public event EventHandler Study;
        public event EventHandler Party;

        //data fields
        string name;
        int stress;
        float gpa;

        #region Properties
        /// <summary>
        /// Stores the name of the student
        /// </summary>
        public string Name { get => name; set => name = value; }

        /// <summary>
        /// Stores the student's stress level
        /// </summary>
        public int Stress { get => stress; set => stress = value; }

        /// <summary>
        /// stores the student's GPA
        /// </summary>
        public float Gpa { get => gpa; set => gpa = value; }
        #endregion

        #region Constructors
        /// <summary>
        /// Student Constructor
        /// </summary>
        /// <param name="name">Name of student</param>
        /// <param name="stress">stress level (1-100)</param>
        /// <param name="gpa">current GPA (0.0-4.0)</param>
        public Student(string name, int stress, float gpa)
        {
            this.name = name;
            this.stress = stress;
            this.gpa = gpa;
        }

        /// <summary>
        /// Default Student constructor
        /// </summary>
        public Student()
        {
            this.name = "John Doe";
            stress = 50;
            this.gpa = 2.0f;
        }
        #endregion

        /// <summary>
        /// overrides the ToString method to show pertinant student information.
        /// </summary>
        /// <returns></returns>
        public override string ToString()
        {
            return $"Name: {name} GPA: {gpa} Stress Level: {stress}";
        }

        /// <summary>
        /// Triggers the Party event.
        /// </summary>
        public void GoToParty()
        {
            OnPartyHandler();
        }

        /// <summary>
        /// Triggers the Study event.
        /// </summary>
        public void GoStudy()
        {
            OnStudyHandler();
        }

        /// <summary>
        /// Raises the party event for all subscribers
        /// </summary>
        protected virtual void OnPartyHandler()
        {
            EventHandler myEvent = Party;
            ActivityEventArgs args = new ActivityEventArgs();
            args.Hours = 1;

            if(myEvent != null)
            {
                myEvent(this, args);
            }
        }

        /// <summary>
        /// Raises the study event for all subscribers
        /// </summary>
        protected virtual void OnStudyHandler()
        {
            EventHandler myEvent = Study;

            if (myEvent != null)
            {
                myEvent(this, EventArgs.Empty);
            }
        }

        public void OnPopQuizHandler(object sender, EventArgs e)
        {
            if (stress < 50)
            {
                Console.WriteLine($"{name}'s pretty chill taking the quiz.");
                stress += 10;
            }
            else
            {
                Console.WriteLine($"{name}'s panicking pretty hard the quiz.");
                stress += 25;
            }
        }
    }
}
