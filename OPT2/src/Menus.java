import Enums.Logs;
import Enums.Pizza_size;
import Tools.*;

import java.util.Scanner;

public class Menus {


    static class MenuTools{

        //Will create a Space between panels
        private static void Space(){
            System.out.println("\n---------------------------------------\n");
        }

        private static void Main() {Space(); Panel_Mainmenu();}


    }


    public static void Panel_Mainmenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Panel: Main menu\n");

        System.out.println("Choose you next menu (pick a number)\n");

        System.out.println("1.  Create new Delivery");
        System.out.println("2.  Delete an Delivery");
        System.out.println("3.  View Delivery");
        System.out.println("4.  More information about options");

        System.out.println("\nSelect your option:");

        MenuTools.Space();

        switch (Tools.SafeIntegerInputWithInBounds(1,4)) {
            case 1: {
                System.out.println("Panel: Main menu - Create new Delivery\n");
                Panel_NewDelivery();
                break;
            }
            case 2: {
                System.out.println("Panel: Main menu - Delete an Delivery\n");
                Panel_DeleteDelivery();
                break;
            }
            case 3: {
                System.out.println("Panel: Main menu - View Delivery\n");
                Panel_ViewDeliveries();
                break;
            }
            case 4: {
                System.out.println("Panel: Main menu - More information about options\n");
                System.out.println( " 1. Create new Delivery              - Here you create a new Delivery that will contain, pizza type, pizza size, Address of customer and total price of the Delivery.\n" +
                                    " 2. Delete an Delivery               - Here you Edit or Delete existing Delivery that where created by option 1.\n" +
                                    " 3. View Deliveries                  - Here you can view all existing Deliveries that where created by option 1.");
                break;
            }
        }

        MenuTools.Main();

    }

    public static void Panel_NewDelivery(){

        Scanner scanner = new Scanner(System.in);

        Pizza pizza = null;
        Pizza_size pizza_size;
        String zipcode;
        String street;
        String city;
        String house_number;
        String house_numberExtras;

        System.out.println("Before creating a new Delivery, you will have to fill in some laking information:");
        System.out.println("What type of pizza is it? (pick a number)\n");

        for (int i = 0; i < Data.getPizzas().size(); i++){
            System.out.println(i+1 + ". " + Data.getPizzas().get(i).getPizza_type());
        }

        System.out.println();



        pizza = Data.getPizzas().get(Tools.SafeIntegerInputWithInBounds(1, Data.getPizzas().size()));
        Tools.PrintTheChosenOne(pizza.getPizza_type());


        System.out.println("What is the size of the pizza (pick a number)\n");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        switch (Tools.SafeIntegerInputWithInBounds(1, 3)) {
            case 1: pizza_size = Pizza_size.Small;
            case 2: pizza_size =  Pizza_size.Large;
            default: pizza_size = Pizza_size.Medium;
        };


        Tools.PrintTheChosenOne(pizza_size);

        System.out.println("Enter Zip/postal code:");
        zipcode = scanner.nextLine();
        System.out.println("Enter Street name:");
        street = scanner.nextLine();
        System.out.println("Enter City name:");
        city = scanner.nextLine();
        System.out.println("Enter House number:");
        house_number = scanner.nextLine();
        System.out.println("If needed an addition (If not, just keep it blank):");
        house_numberExtras = scanner.nextLine();

        System.out.println("That's all!, creating a new Delivery...");

        MenuTools.Space();

        DeliveryHandler.AddDelivery(pizza, pizza_size, zipcode, street, city, house_number, house_numberExtras);

        System.out.println(Data.getDeliveries().get(Data.getDeliveries().size() - 1).getAllInformation());

        System.out.println("\nSuccessfully created a new Delivery,\nyou can see your deliveries in the Deliveries View in the Main menu.");

    }

    public static void Panel_DeleteDelivery(){


        Panel_ViewDeliveries();

        System.out.println();
        System.out.println("Choose a Delivery to Delete");

        int chosenDelivery = Tools.SafeIntegerInputWithInBounds(1, DeliveryHandler.getDeliveries().size());

        System.out.println("To confirm this deletion, type: \"delete\" ");
        System.out.println("To cancel this deletion, type: \"exit\" ");



        if(CustomTools.SafeStringInputPlusIfStatement("delete", "exit")){
            DeliveryHandler.DeleteDelivery(chosenDelivery);
        }else{
            return;
        }


    }

    public static void Panel_ViewDeliveries(){
        for (int i = 0; i < Data.getDeliveries().size(); i++){

            Delivery delivery = Data.getDeliveries().get(i);

            System.out.println("Delivery " + (i + 1) + " ------------------- " + delivery.getTime());
            System.out.println(delivery.getAllInformation());
            System.out.println();
        }
    }








}
