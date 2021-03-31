import Enums.Food_size;
import Enums.Logs;
import Enums.Pasta_type;
import Enums.Pizza_type;
import Tools.Tools;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    void TestTotalMealPrize(){


        ArrayList<Food> food = new ArrayList<>();

        food.add(new Pasta(Pasta_type.spaghetti, Food_size.Medium)); // spaghetti 7.0 + 2.0
        food.add(new Pizza(Pizza_type.Pepperoni, Food_size.Medium)); // Pepperoni 7.5 + 2.0

        Delivery delivery = new Delivery(food, "3223GC", "Hackfortstraat", "Hellevoetsluis", "21", "");

        Double price = delivery.TotalPriceOfMeals();
        assertEquals(18.5, price);
    }

    @Test
    void TestPizzaType(){
        Food pizza1 = new Pizza(Pizza_type.Quattro_Formaggi, Food_size.Medium);

        assertEquals("Quattro_Formaggi", pizza1.getFoodType().toString());

    }


    @Test
    void AddAndDeleteFood(){

        DeliveryHandler deliveryHandler = new DeliveryHandler();

        ArrayList<Food> food1 = new ArrayList<>();

        food1.add(new Pasta(Pasta_type.spaghetti, Food_size.Medium)); // spaghetti 7.0 + 2.0
        food1.add(new Pizza(Pizza_type.Pepperoni, Food_size.Medium)); // Pepperoni 7.5 + 2.0

        deliveryHandler.AddDelivery(food1, "3223GC", "Hackfortstraat", "Hellevoetsluis", "21", "");

        ArrayList<Food> food2 = new ArrayList<>();

        food2.add(new Pasta(Pasta_type.spaghetti, Food_size.Medium)); // spaghetti 7.0 + 2.0
        food2.add(new Pizza(Pizza_type.Pepperoni, Food_size.Medium)); // Pepperoni 7.5 + 2.0

        deliveryHandler.AddDelivery(food2, "3223GC", "Hackfortstraat", "Hellevoetsluis", "21", "");

        assertEquals(2, deliveryHandler.getDeliveries().size());

        deliveryHandler.DeleteDelivery(2);

        assertEquals(1, deliveryHandler.getDeliveries().size());

    }

    @Test
    void TestLog(){
        assertEquals("Input is niet geldig, probeer opnieuw.", Logs.NotValid.label);
    }


}