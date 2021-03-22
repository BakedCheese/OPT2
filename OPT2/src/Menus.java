import java.util.Scanner;

public class Menus {

    static class MenuTransition{

        //Will create a Space between panels
        private static void Space(){
            System.out.println("\n---------------------------------------\n");
        }

        private static void Main() {MenuTransition.Space(); Panel_Mainmenu();}

    }




    //Mainmenu panel
    public static void Panel_Mainmenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Panel - Mainmenu\n");

        System.out.println("1.  Create new Delivery");
        System.out.println("2.  Edit or Delete an Delivery");
        System.out.println("3.  View Delivery");
        System.out.println("4.  More information about options");

        System.out.println("\nSelect your option:");

        int selected = scanner.nextInt();

        MenuTransition.Space();

        switch (selected){
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:
                System.out.println("Panel - Mainmenu - option 4\n");

                System.out.println( " 1. Create new Delivery              - Here you create a new Delivery that will contain, pizza type, pizza size, Address of customer and total price of the Delivery.\n" +
                                    " 2. Edit or Delete an Delivery       - Here you Edit or Delete existing Delivery that where created by option 1.\n" +
                                    " 3. View Deliveries                  - Here you can view all existing Deliveries that where created by option 1.");

                MenuTransition.Main();
                break;

        }




    }



}
