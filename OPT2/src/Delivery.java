import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Delivery {
    private ArrayList<Food> foods = new ArrayList<>();
    private final String zipcode;
    private final String street;
    private final String city;
    private final String house_number;
    private final String house_numberExtras;
    private final String timeOfCreation;

    private final Double deliveryPrice;


    public Delivery(ArrayList<Food> foods, String zipcode, String street, String city, String house_number, String house_numberExtras) {
        this.foods = foods;
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
        this.house_number = house_number;
        this.house_numberExtras = house_numberExtras;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        timeOfCreation = dtf.format(now);
        deliveryPrice = 1.5;

    }

    public String getTime(){
        return timeOfCreation;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }


    public String getAllInformation(){


        return            "\nMeals:                 "
                        + "\n" + getAllMeals()
                        + "\n\nAddress:             "
                        + "\nZip/postal code:       " + getZipcode()
                        + "\nStreet name:           " + getStreet()
                        + "\nCity name:             " + getCity()
                        + "\nHouse number:          " + getHouse_number() + " Extra: " + getHouse_numberExtras()
                        + "\n\nCost:                "
                        + "\nTotal Cost of Meal(s): $ " + TotalPriceOfMeals()
                        + "\nCost of Delivery:      $ " + getDeliveryPrice()
                        + "\n"
                        + "\nTotal Cost:            $ " + (TotalPriceOfMeals() + getDeliveryPrice());
    }



    private String getAllMeals(){
        String std = "";
        for (Food food: foods) {

            std += " - " + food.getFoodType() + " (" + food.getSize() + ") = $ " + food.getPrice() + " + $ " + food.getSize().getPrice() + "\n";
        }

        return std;
    }

    public Double TotalPriceOfMeals(){

        Double total = 0.0;
        for (Food tempfood: getFoods()) {
            total += tempfood.getPrice() + tempfood.getSize().getPrice();
        }

        return total;
    }


    public ArrayList<Food> getFoods() {
        return foods;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getHouse_number() {
        return house_number;
    }

    public String getHouse_numberExtras() {
        return house_numberExtras;
    }

}
