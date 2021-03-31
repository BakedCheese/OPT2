import java.util.ArrayList;

public class DeliveryHandler{

    private static ArrayList<Delivery> deliveries = new ArrayList<>();

    public void AddDelivery(ArrayList<Food> food, String zipcode,
                            String street, String city, String house_number, String house_numberExtras){
        getDeliveries().add(new Delivery(food, zipcode, street, city, house_number, house_numberExtras));
    }

    public void DeleteDelivery(int chosenDelivery){
        getDeliveries().remove(chosenDelivery - 1);
    }

    public  ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

}

