using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RaymondKA2
{
    static class Program
    {
        /// <summary>
        /// Author: Keaton Raymond
        /// Class: CS 3020-001
        /// Assignment 2: Cereal Killer App
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
