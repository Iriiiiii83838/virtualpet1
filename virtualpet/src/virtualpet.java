
import java.util.Random;
    public class virtualpet {
        private String name;
        private String type; // dog,cat o dummy
        private int energy;
        private int hygiene;
        private int weight;
        private int mood;


        //Creamos el constructor para la mascota ddel usuario y ponemos atributos aleatorios entre 40 y 60
        public virtualpet(String name, String type) {
            this.name = name;
            this.type = type;
            Random random = new Random();
            this.energy = random.nextInt(21) + 40;
            this.hygiene = random.nextInt(21) + 40;
            this.weight = random.nextInt(21) + 40;
            this.mood = random.nextInt(21) + 40;
        }


        //Constructor especial para la mascota Dummy (con todos los atributos al 100)
        public virtualpet(String name, int initialValue) {
            this.name = name;
            this.type = type;
            this.energy = initialValue;
            this.hygiene = initialValue;
            this.weight = initialValue;
            this.mood = initialValue;
        }
        public boolean isDead() {
            return (energy <= 0 || energy >= 100 ||
                    hygiene <= 0 || hygiene >= 100 ||
                    weight <= 0 || weight >= 100 ||
                    mood <= 0 || mood >= 100) ;
        }


        public void sleep () {
            if (type.equalsIgnoreCase("dog")) {
                this.energy += 25;
            } else if (type.equalsIgnoreCase("cat")) {
                this.energy += 20;
            }
            this.mood += 10;
        }


        public void play () {
            this.energy -= 20;
            this.mood +=20;
            this.weight -=10;
        }
        public void eat() {
            this.energy += 10;
            this.hygiene -= 15;
            this.weight += 10;
        }


        public void shower() {
            if (type.equalsIgnoreCase("dog")) {
                this.energy += 10;
                this.hygiene -= 15;
                this.mood -= 15;
            } else if (type.equalsIgnoreCase("cat")) {
                this.energy -= 5;
                this.hygiene += 25;
                this.mood += 5;
            }
        }
        public void attack (virtualpet dummy, int times){
            for (int i = 0; i < times; i++) {
                //Descuenta a la mascota
                this.energy-= 3;
                this.hygiene -=3;
                this.mood -= 3 ;
                // Descuento al dummmy
                dummy.energy -= 3;
                dummy.hygiene -= 3;
                dummy.mood -= 3;


                if (this.isDead()) {
                    break;
                }
            }
        }
        public void printStats() {
            System.out.println("\n---------------------------------");
            System.out.println("STATS OF" + name.toUpperCase() + "(" + type.toUpperCase() + ")");
            System.out.println( "-----------------------------------------------");
            System.out.println("- Energy :  " + energy);
            System.out.println("-Hygiene : " + hygiene);
            System.out.println("-weight :" + weight);
            System.out.println("-Mood :" + mood);
            System.out.println("-----------------------------------------\n");


        }




    }


























