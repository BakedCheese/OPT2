import Enums.Pizza_type;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Pizza> pizzas = new ArrayList<>();;
    private static ArrayList<Delivery> deliveries = new ArrayList<>();;


    public static void Hardcode_Pizzas() {
        pizzas.add(new Pizza(Pizza_type.Pepperoni, 7.5));
        pizzas.add(new Pizza(Pizza_type.Margherita, 7.0));
        pizzas.add(new Pizza(Pizza_type.Quattro_Formaggi, 8.0));
        pizzas.add(new Pizza(Pizza_type.Tonno, 8.0));
    }

    protected ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    protected ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

}
