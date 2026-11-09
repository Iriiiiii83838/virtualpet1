import javax.xml.namespace.QName;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("VIRTUAL PET APP");


        //1. ELEGIREMOS EL TIPO DE MASCOTA
        String type = "";
        while (!type.equalsIgnoreCase("dog") && !type.equalsIgnoreCase("cat")) {
            System.out.print("CHOOSE YOUR PET (DOG/CAT):");
            type = scanner.nextLine().trim().toLowerCase();


        }
        System.out.print("Enter the name of your virtual pet ");
        String name = scanner.nextLine().trim();


        if (name.isEmpty()) {
            name = "Pet";
        }


        //Distanciar mascota del jugador y mascota dummy
        virtualpet pet = new virtualpet(name, type);
        virtualpet dummy = new virtualpet("dummy", 100);


        var running = true;
        while (running) {
            System.out.println("\n---MENU----");
            System.out.println("1- SLEEP");
            System.out.println("2-PLAY");
            System.out.println("3-EAT");
            System.out.println("4- CLEAN");
            System.out.println("!5-ATTACK");
            System.out.println("0.= EXIT APPLICATION");
            System.out.print("SELECT AN OPTION");


            String option = scanner.nextLine().trim();


            switch (option) {
                case "0":
                    System.out.println("EXITING APPLICATION...BYE BYE!");
                    running = false;
                    break;
                case "1":
                    pet.sleep();
                    System.out.println("\n" + name + "took a nap");
                    break;
                case "2":
                    pet.play();
                    System.out.println("\n Yoy played with" + name + ".");
                    break;

                case "3":
                    pet.play();
                    System.out.println("\n Yoy played ith" + pet.getClass() + ".");
                    break;


                case "4":
                    pet.shower();
                    System.out.println("\n You cleaned" + pet.getClass() + ".");
                    break;


                case "5":
                    System.out.println("How many hits you want to give to the dummy?");
                    try {
                        int hits = Integer.parseInt(scanner.nextLine().trim());
                        pet.attack(dummy, hits);
                        System.out.println("\n" + name + "attacked the dummy!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                        continue;
                    }
                    break;


                default:
                    System.out.println("\nInvalid option. TRY AGAIN");
                    continue;
            }
            //COMPROBAMOS MUERTE
            if (running) {
                if (pet.isDead()) {
                    System.out.println("\n--------------------------------------------------------------------------");
                    System.out.println(name.toUpperCase() + " is dead!");
                    running = false;
                } else {
                    pet.printStats();


                }

            }




        }
        scanner.close();
    }
}
