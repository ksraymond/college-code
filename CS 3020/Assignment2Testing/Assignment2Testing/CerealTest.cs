using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment2Testing
{
    class CerealTest
    {
        string name;
        char mfr, type;
        int calories, protein, fat, sodium, sugar, potass, vitamins, shelfLife;
        double fiber, carbo, weight, cups, rating;

        public CerealTest(string name, char mfr, char type, int calories,
                      int protein, int fat, int sodium, double fiber, double carbo,
                      int sugar, int potass, int vitamins, int shelfLife,
                      double weight, double cups, double rating)
        {
            this.name = name;
            this.mfr = mfr;
            this.type = type;
            this.calories = calories;
            this.protein = protein;
            this.fat = fat;
            this.sodium = sodium;
            this.sugar = sugar;
            this.potass = potass;
            this.vitamins = vitamins;
            this.shelfLife = shelfLife;
            this.fiber = fiber;
            this.carbo = carbo;
            this.weight = weight;
            this.cups = cups;
            this.rating = rating;
        }

        public string Name { get => name; set => name = value; }
        public char Mfr { get => mfr; set => mfr = value; }
        public char Type { get => type; set => type = value; }
        public int Calories { get => calories; set => calories = value; }
        public int Protein { get => protein; set => protein = value; }
        public int Fat { get => fat; set => fat = value; }
        public int Sodium { get => sodium; set => sodium = value; }
        public int Sugar { get => sugar; set => sugar = value; }
        public int Potass { get => potass; set => potass = value; }
        public int Vitamins { get => vitamins; set => vitamins = value; }
        public int ShelfLife { get => shelfLife; set => shelfLife = value; }
        public double Fiber { get => fiber; set => fiber = value; }
        public double Carbo { get => carbo; set => carbo = value; }
        public double Weight { get => weight; set => weight = value; }
        public double Cups { get => cups; set => cups = value; }
        public double Rating { get => rating; set => rating = value; }
    }
}
