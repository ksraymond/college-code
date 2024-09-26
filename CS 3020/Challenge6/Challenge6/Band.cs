using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Challenge6
{
    class Band
    {
        int index;
        string name;
        int fans;
        int formed;
        string origin;
        int split;
        string style;

        public Band(int index, string name, int fans, int formed, string origin, int split, string style)
        {
            this.Index = index;
            this.Name = name;
            this.Fans = fans;
            this.Formed = formed;
            this.Origin = origin;
            this.Split = split;
            this.Style = style;
        }

        public int Index { get => index; set => index = value; }
        public string Name { get => name; set => name = value; }
        public int Fans { get => fans; set => fans = value; }
        public int Formed { get => formed; set => formed = value; }
        public string Origin { get => origin; set => origin = value; }
        public int Split { get => split; set => split = value; }
        public string Style { get => style; set => style = value; }
    }
}
