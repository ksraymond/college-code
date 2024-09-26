using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventExampleV2
{
    class Course
    {
        public event EventHandler PopQuiz;
        private List<Student> roster;
        Random rand = new Random();

        public Course()
        {
            PopulateRoster();
        }

        /// <summary>
        /// Have everyone in class perform a random activity
        /// </summary>
        public void RandomActivity()
        {
            foreach (Student student in roster)
            {
                if(rand.Next() % 2 == 0)
                {
                    student.GoToParty();
                }
                else
                {
                    student.GoStudy();
                }
            }
        }

        /// <summary>
        /// Populate the class roster
        /// </summary>
        private void PopulateRoster()
        {
            roster = new List<Student>();
            roster.Add(new Student("Bobby Hill", 20, 2.5f));
            roster.Add(new Student("Hank Hill", 80, 3.5f));
            roster.Add(new Student("Peggy Hill", 75, 3.7f));
            roster.Add(new Student("Dale Gribble", 75, 1.5f));
            SubscribeEvents();
        }

        /// <summary>
        /// subscribe all course based handlers for student events
        /// </summary>
        private void SubscribeEvents()
        {
            foreach (Student student in roster)
            {
                student.Party += OnPartyHandler;
                student.Study += OnStudyHandler;
                PopQuiz += student.OnPopQuizHandler;
            }

            var dale = from student in roster
                         where student.Name.CompareTo("Dale Gribble") == 0
                         select student;
            PopQuiz -= dale.First().OnPopQuizHandler;
        }

        public void GivePopQuiz()
        {
            OnPopQuizHandler(this, EventArgs.Empty);
        }

        protected virtual void OnPopQuizHandler(object sender, EventArgs e)
        {
            EventHandler myEvent = PopQuiz;

            if(myEvent != null)
            {
                myEvent(sender, e);
            }
        }

        /// <summary>
        /// What happens to a student when the party
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnPartyHandler(object sender, EventArgs e)
        {
            Student student = (Student)sender;
            Console.WriteLine($"{student.Name} went to a party!");
            student.Gpa -= .1f;
            student.Stress -= 10;
        }

        /// <summary>
        /// What happens to a student when they study.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnStudyHandler(object sender, EventArgs e)
        {
            Student student = (Student)sender;
            Console.WriteLine($"{student.Name} went to study.");
            student.Gpa += .1f;
            student.Stress += 5;
        }

        /// <summary>
        /// Displays the status of all students currently on the roster
        /// </summary>
        public void DisplayStudentStatus()
        {
            foreach(Student student in roster)
            {
                Console.WriteLine(student.ToString());
            }
        }
        
    }
}
