import Enums.Logs;
import Enums.Pizza_size;
import Tools.*;

import java.util.Scanner;

public class Menus {



    public static void Panel_Mainmenu(){

        System.out.println("Panel: Main menu\n");

        System.out.println("Choose you next menu (pick a number)\n");

        System.out.println("1.  Create new Delivery");
        System.out.println("2.  Delete an Delivery");
        System.out.println("3.  View Delivery");
        System.out.println("4.  More information about options");

        System.out.println("\nSelect your option:");

        CustomTools.Space();

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

        CustomTools.Space();

    }

    private static void Panel_NewDelivery(){

        Scanner scanner = new Scanner(System.in);
        DeliveryHandler deliveryHandler = new DeliveryHandler();

        Pizza pizza;
        Pizza_size pizza_size;
        String zipcode;
        String street;
        String city;
        String house_number;
        String house_numberExtras;

        System.out.println("Before creating a new Delivery, you will have to fill in some laking information:");
        System.out.println("What type of pizza is it? (pick a number)\n");

        for (int i = 0; i < deliveryHandler.getPizzas().size(); i++){
            System.out.println(i+1 + ". " + deliveryHandler.getPizzas().get(i).getPizza_type());
        }

        System.out.println();



        pizza = deliveryHandler.getPizzas().get(Tools.SafeIntegerInputWithInBounds(1, deliveryHandler.getPizzas().size()));
        Tools.PrintTheChosenOne(pizza.getPizza_type());


        System.out.println("What is the size of the pizza (pick a number)\n");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        switch (Tools.SafeIntegerInputWithInBounds(1, 3)) {
            case 1: pizza_size = Pizza_size.Small; break;
            case 2: pizza_size = Pizza_size.Medium; break;
            case 3: pizza_size =  Pizza_size.Large; break;
            default: pizza_size = Pizza_size.Medium; break;

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

        CustomTools.Space();

        deliveryHandler.AddDelivery(pizza, pizza_size, zipcode, street, city, house_number, house_numberExtras);

        System.out.println(deliveryHandler.getDeliveries().get(deliveryHandler.getDeliveries().size() - 1).getAllInformation());

        System.out.println("\nSuccessfully created a new Delivery,\nyou can see your deliveries in the Deliveries View in the Main menu.");

    }

    private static void Panel_DeleteDelivery(){
        DeliveryHandler deliveryHandler = new DeliveryHandler();

        Panel_ViewDeliveries();

        System.out.println();
        System.out.println("Choose a Delivery to Delete");

        int chosenDelivery = Tools.SafeIntegerInputWithInBounds(1, deliveryHandler.getDeliveries().size());

        System.out.println("To confirm this deletion, type: \"delete\" ");
        System.out.println("To cancel this deletion, type: \"exit\" ");



        if(CustomTools.SafeStringInputPlusIfStatement("delete", "exit")){
            deliveryHandler.DeleteDelivery(chosenDelivery);
        }else{
            return;
        }


    }

    private static void Panel_ViewDeliveries(){
        DeliveryHandler deliveryHandler = new DeliveryHandler();

        for (int i = 0; i < deliveryHandler.getDeliveries().size(); i++){

            Delivery delivery = deliveryHandler.getDeliveries().get(i);

            System.out.println("Delivery " + (i + 1) + " ------------------- " + delivery.getTime());
            System.out.println(delivery.getAllInformation());
            System.out.println();
        }
    }








}
