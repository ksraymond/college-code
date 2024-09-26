using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EventDrivenProgramming
{
    static class Program
    {
        /// <summary>
        /// next tab is for the GUI design... get elements from toolbox
        /// double click on a button to create an event for clicking on that thing
        /// can change properties of buttons and such by using the bottom menu on the right
        /// just fuck around with looking at different events and what you can do with said events
        /// if you remove an event, be sure to go into form1.designer.cs and remove all references
        /// can highlight and right click a variable to rename it, basically a find and replace for the whole program
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
