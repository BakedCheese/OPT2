import Enums.Pasta_type;
import Enums.Pizza_type;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Pizza> pizzas = new ArrayList<>();
    private static ArrayList<Pasta> pastas = new ArrayList<>();
    ;


    public static void Hardcode_Food() {
        pizzas.add(new Pizza(Pizza_type.Pepperoni, 7.5));
        pizzas.add(new Pizza(Pizza_type.Margherita, 7.0));
        pizzas.add(new Pizza(Pizza_type.Quattro_Formaggi, 8.0));
        pizzas.add(new Pizza(Pizza_type.Tonno, 8.0));

        pastas.add(new Pasta(Pasta_type.spaghetti, 7.0));
        pastas.add(new Pasta(Pasta_type.Lasagne, 8.0));
        pastas.add(new Pasta(Pasta_type.Carbonara, 10.0));
    }

    public static ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public static ArrayList<Pasta> getPastas() { return pastas; }



}
