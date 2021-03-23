import Enums.Pizza_size;

import java.util.Scanner;

public class Menus {

    static class MenuTransition{

        //Will create a Space between panels
        private static void Space(){
            System.out.println("\n---------------------------------------\n");
        }

        private static void Main() {MenuTransition.Space(); Panel_Mainmenu();}

    }


    public static void Panel_Mainmenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Panel: Main menu\n");

        System.out.println("Choose you next menu (pick a number)\n");

        System.out.println("1.  Create new Delivery");
        System.out.println("2.  Edit or Delete an Delivery");
        System.out.println("3.  View Delivery");
        System.out.println("4.  More information about options");

        System.out.println("\nSelect your option:");

        int selected = scanner.nextInt();

        MenuTransition.Space();

        switch (selected) {
            case 1 -> {
                System.out.println("Panel: Main menu - Create new Delivery\n");
                Panel_NewDelivery();
            }
            case 2 -> System.out.println("Panel: Main menu - Edit or Delete an Delivery\n");
            case 3 -> {
                System.out.println("Panel: Main menu - View Delivery\n");
                Panel_ViewDeliveries();
            }
            case 4 -> {
                System.out.println("Panel: Main menu - More information about options\n");
                System.out.println(" 1. Create new Delivery              - Here you create a new Delivery that will contain, pizza type, pizza size, Address of customer and total price of the Delivery.\n" +
                        " 2. Edit or Delete an Delivery       - Here you Edit or Delete existing Delivery that where created by option 1.\n" +
                        " 3. View Deliveries                  - Here you can view all existing Deliveries that where created by option 1.");
            }
            default -> System.out.println("Chosen number is out of bounds, please try again.");
        }

        MenuTransition.Main();

    }

    public static void Panel_NewDelivery(){

        Scanner scanner = new Scanner(System.in);

        Pizza pizza = null;
        Pizza_size pizza_size;
        String zipcode;
        String street;
        String city;
        int house_number;
        String house_numberExtras;

        System.out.println("Before creating a new Delivery, you will have to fill in some laking information:");
        System.out.println("What type of pizza is it? (pick a number)\n");

        for (int i = 0; i < Main.ArrayLists.getPizzas().size(); i++){
            System.out.println(i+1 + ". " + Main.ArrayLists.getPizzas().get(i).getPizza_type());
        }

        System.out.println();

        int ChosenPizza = scanner.nextInt() - 1;

        if(ChosenPizza >= 0 && ChosenPizza < Main.ArrayLists.getPizzas().size()){
            pizza = Main.ArrayLists.getPizzas().get(ChosenPizza);
            System.out.println("You have chosen: " + pizza.getPizza_type());
        }else{
            System.out.println("Chosen number is out of bounds, please try again.");
            return;
        }

        System.out.println("What is the size of the pizza (pick a number)\n");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        pizza_size = switch (scanner.nextInt()) {
            case 1 -> Pizza_size.Small;
            case 3 -> Pizza_size.Large;
            default -> Pizza_size.Medium;
        };

        scanner.nextLine();

        System.out.println("You have chosen: " + pizza_size);

        System.out.println("Enter Zip/postal code:");
        zipcode = scanner.nextLine();
        System.out.println("Enter Street name:");
        street = scanner.nextLine();
        System.out.println("Enter City name:");
        city = scanner.nextLine();
        System.out.println("Enter House number:");
        house_number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("If needed an addition (If not, just keep it blank):");
        house_numberExtras = scanner.nextLine();

        System.out.println("That's all!, creating a new Delivery...");

        MenuTransition.Space();

        Main.ArrayLists.getDeliveries().add(new Delivery(pizza, pizza_size, zipcode, street, city, house_number, house_numberExtras));

        System.out.println(Main.ArrayLists.getDeliveries().get(Main.ArrayLists.getDeliveries().size() - 1).getAllInformation());

        System.out.println("\nSuccessfully created a new Delivery,\nyou can see your deliveries in the Deliveries View in the Main menu.");

    }

    public static void Panel_ViewDeliveries(){
        for (int i = 0; i < Main.ArrayLists.getDeliveries().size(); i++){
            System.out.println("Delivery " + (i + 1) + " ----------------------------");
            System.out.println(Main.ArrayLists.getDeliveries().get(i).getAllInformation());
            System.out.println();
        }
    }



}
