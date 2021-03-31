import Enums.Food_size;
import Enums.Pasta_type;
import Enums.Pizza_type;
import Tools.*;

import java.util.ArrayList;
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



        switch (Tools.SafeIntegerInputWithInBounds(1,4)) {
            case 1: {
                Tools.Space();
                System.out.println("Panel: Main menu - Create new Delivery\n");
                Panel_NewDelivery();
                break;
            }
            case 2: {
                Tools.Space();
                System.out.println("Panel: Main menu - Delete an Delivery\n");
                Panel_DeleteDelivery();
                break;
            }
            case 3: {
                Tools.Space();
                System.out.println("Panel: Main menu - View Delivery\n");
                Panel_ViewDeliveries();
                break;
            }
            case 4: {
                Tools.Space();
                System.out.println("Panel: Main menu - More information about options\n");
                System.out.println( " 1. Create new Delivery              - Here you create a new Delivery.\n" +
                                    " 2. Delete an Delivery               - Here you can Delete existing Delivery that where created by option 1.\n" +
                                    " 3. View Deliveries                  - Here you can view all existing Deliveries that where created by option 1.");
                break;
            }
        }

        Tools.Space();
        Panel_Mainmenu();

    }

    private static void Panel_NewDelivery(){

        Scanner scanner = new Scanner(System.in);
        DeliveryHandler deliveryHandler = new DeliveryHandler();

        ArrayList<Food> food = new ArrayList<>();
        Food_size food_size;
        String zipcode;
        String street;
        String city;
        String house_number;
        String house_numberExtras;

        System.out.println("Before creating a new Delivery, you will have to fill in some laking information:");

        while (true){
            System.out.println("Pizza or Pasta? (pick a number)\n");
            System.out.println("1. Pizza");
            System.out.println("2. Pasta");

            Pizza_type pizza_type = null;
            Pasta_type pasta_type = null;
            Food_size size = null;

            int chosen = Tools.SafeIntegerInputWithInBounds(1, 2);

            if(chosen == 1){
                System.out.println("What type of pizza is it? (pick a number)\n");

                System.out.println("1. " + Pizza_type.Margherita);
                System.out.println("2. " + Pizza_type.Pepperoni);
                System.out.println("3. " + Pizza_type.Quattro_Formaggi);
                System.out.println("4. " + Pizza_type.Tonno);

                System.out.println();

                switch (Tools.SafeIntegerInputWithInBounds(1, 4)){
                    case 1: pizza_type = Pizza_type.Margherita; break;
                    case 2: pizza_type = Pizza_type.Pepperoni; break;
                    case 3: pizza_type = Pizza_type.Quattro_Formaggi; break;
                    case 4: pizza_type = Pizza_type.Tonno; break;
                }

                Tools.PrintTheChosenOne(pizza_type);

            }else{
                System.out.println("What type of pasta is it? (pick a number)\n");

                System.out.println("1. " + Pasta_type.spaghetti);
                System.out.println("2. " + Pasta_type.Lasagne);
                System.out.println("3. " + Pasta_type.Carbonara);

                System.out.println();

                switch (Tools.SafeIntegerInputWithInBounds(1, 3)){
                    case 1: pasta_type = Pasta_type.spaghetti; break;
                    case 2: pasta_type = Pasta_type.Lasagne; break;
                    case 3: pasta_type = Pasta_type.Carbonara; break;
                }

                Tools.PrintTheChosenOne(pasta_type);

            }




            System.out.println("What is the size of the meal (pick a number)\n");
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");


            switch (Tools.SafeIntegerInputWithInBounds(1, 3)) {
                case 1: size = Food_size.Small; break;
                case 2: size = Food_size.Medium; break;
                case 3: size = Food_size.Large; break;
            };



            Tools.PrintTheChosenOne(size);

            if(chosen == 1){
                food.add(new Pizza(pizza_type, size));
            }else{
                food.add(new Pasta(pasta_type, size));
            }


            System.out.println("Is that it? (pick a number)\n");
            System.out.println("1. No, I want to order more.");
            System.out.println("2. Yes, I'm done.");

            if (Tools.SafeIntegerInputWithInBounds(1,2).equals(1)){
                Tools.Space();
            }else{
                break;
            }

        }

        System.out.println("Enter Zip/postal code:");
        zipcode = scanner.nextLine();
        Tools.PrintTheChosenOne(zipcode);
        System.out.println("Enter Street name:");
        street = scanner.nextLine();
        Tools.PrintTheChosenOne(street);
        System.out.println("Enter City name:");
        city = scanner.nextLine();
        Tools.PrintTheChosenOne(city);
        System.out.println("Enter House number:");
        house_number = scanner.nextLine();
        Tools.PrintTheChosenOne(house_number);
        System.out.println("If needed an addition (If not, just keep it blank):");
        house_numberExtras = scanner.nextLine();
        Tools.PrintTheChosenOne(house_numberExtras);

        System.out.println("That's all!, creating a new Delivery...");

        Tools.Space();

        deliveryHandler.AddDelivery(food, zipcode, street, city, house_number, house_numberExtras);

        System.out.println("Delivery " + (deliveryHandler.getDeliveries().size()) + " ------------------- " + deliveryHandler.getDeliveries().get(deliveryHandler.getDeliveries().size() - 1).getTime());
        System.out.println(deliveryHandler.getDeliveries().get(deliveryHandler.getDeliveries().size() - 1).getAllInformation());

        System.out.println("\nSuccessfully created a new Delivery,\nyou can see your deliveries in the Deliveries View in the Main menu.");

    }

    private static void Panel_DeleteDelivery(){
        DeliveryHandler deliveryHandler = new DeliveryHandler();

        Panel_ViewDeliveries();

        System.out.println();
        System.out.println("Choose a Delivery to Delete");

        int chosenDelivery = Tools.SafeIntegerInputWithInBounds(1, deliveryHandler.getDeliveries().size());

        Tools.PrintTheChosenOne(chosenDelivery);

        System.out.println("To confirm this deletion, type: \"delete\" ");
        System.out.println("To cancel this deletion, type: \"exit\" ");

        if(Tools.SafeStringInputPlusIfStatement("delete", "exit")){
            deliveryHandler.DeleteDelivery(chosenDelivery);
            Tools.PrintTheChosenOne("delete");
        }else{
            Tools.PrintTheChosenOne("exit");
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
