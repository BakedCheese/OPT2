import Enums.Pizza_size;
import Enums.Pizza_type;

import java.util.ArrayList;

public class Main {

    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

    public static void main(String[] args) {
        //Menus.Panel_Mainmenu();

        Pizza Pepperoni = new Pizza(Pizza_type.Pepperoni, 7.9);
        Delivery delivery1 = new Delivery(Pepperoni, Pizza_size.Medium, "3223GC", "Hackfortstraat",
                "Hellevoetsluis", 21, "");

        System.out.println(delivery1.getAllInfomation());
    }


}
