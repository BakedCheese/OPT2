import Enums.Pizza_size;

public class DeliveryHandler extends Data{

    public static void AddDelivery(Pizza pizza, Pizza_size pizza_size, String zipcode,
                            String street, String city, String house_number, String house_numberExtras){
        getDeliveries().add(new Delivery(pizza, pizza_size, zipcode, street, city, house_number, house_numberExtras));
    }

    public static void DeleteDelivery(int chosenDelivery){
        getDeliveries().remove(chosenDelivery - 1);
    }



}
