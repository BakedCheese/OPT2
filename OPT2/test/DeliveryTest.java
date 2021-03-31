import Enums.Food_size;
import Enums.Logs;
import Enums.Pizza_type;
import Tools.Tools;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    void TestTotalMealPrize(){

        Data.Hardcode_Food();

        ArrayList<Food> food = new ArrayList<>();



        food.add(Data.getPastas().get(0)); // spaghetti 7.0 +
        food.get(food.size() - 1).setSize(Food_size.Medium); // 2.0
        food.add(Data.getPizzas().get(0)); // Pepperoni 7.5 +
        food.get(food.size() - 1).setSize(Food_size.Medium); // 2.0

        Delivery delivery = new Delivery(food, "3223GC", "Hackfortstraat", "Hellevoetsluis", "21", "");

        Double price = delivery.TotalPriceOfMeals();
        assertEquals(18.5, price);
    }

    @Test
    void TestPizzaType(){
        Food pizza1 = new Pizza(Pizza_type.Quattro_Formaggi, 9.0);

        assertEquals("Quattro_Formaggi", pizza1.getFoodType().toString());

    }


    @Test
    void AddAndDeleteFood(){
        Data.Hardcode_Food();

        DeliveryHandler deliveryHandler = new DeliveryHandler();

        ArrayList<Food> food1 = new ArrayList<>();

        food1.add(Data.getPastas().get(0)); // spaghetti 7.0 +
        food1.get(food1.size() - 1).setSize(Food_size.Medium); // 2.0
        food1.add(Data.getPizzas().get(0)); // Pepperoni 7.5 +
        food1.get(food1.size() - 1).setSize(Food_size.Medium); // 2.0

        deliveryHandler.AddDelivery(food1, "3223GC", "Hackfortstraat", "Hellevoetsluis", "21", "");

        ArrayList<Food> food2 = new ArrayList<>();

        food2.add(Data.getPastas().get(0)); // spaghetti 7.0 +
        food2.get(food2.size() - 1).setSize(Food_size.Medium); // 2.0
        food2.add(Data.getPizzas().get(0)); // Pepperoni 7.5 +
        food2.get(food2.size() - 1).setSize(Food_size.Medium); // 2.0

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