import Enums.Pizza_size;
import Enums.Pizza_type;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private static ArrayList<Delivery> deliveries = new ArrayList<Delivery>();


    public static void main(String[] args) {
        HARDCODE_PIZZAS();

        Menus.Panel_Mainmenu();
    }

    private static void HARDCODE_PIZZAS(){
        pizzas.add(new Pizza(Pizza_type.Pepperoni, 7.5));
        pizzas.add(new Pizza(Pizza_type.Margherita, 7.0));
        pizzas.add(new Pizza(Pizza_type.Quattro_Formaggi, 8.0));
        pizzas.add(new Pizza(Pizza_type.Tonno, 8.0));
    }

    public static ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public static void setPizzas(ArrayList<Pizza> pizzas) {
        Main.pizzas = pizzas;
    }

    public static ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public static void setDeliveries(ArrayList<Delivery> deliveries) {
        Main.deliveries = deliveries;
    }
}
