import Enums.Pizza_size;
import com.sun.jdi.DoubleValue;

public class Delivery {
    private Pizza pizza;
    private Pizza_size pizza_size;
    private String zipcode;
    private String street;
    private String city;
    private Integer house_number;
    private String house_numberExtras;

    private final Double deliveryPrice;


    public Delivery(Pizza pizza, Pizza_size pizza_size, String zipcode, String street, String city, Integer house_number, String house_numberExtras) {
        this.pizza = pizza;
        this.pizza_size = pizza_size;
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
        this.house_number = house_number;

        deliveryPrice = 1.5;

    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public Double getTotalPriceDelivery(Double pricePizza, Double sizePrice, Double deliveryPrice){
        return pricePizza + sizePrice + deliveryPrice;
    }

    public String getAllInformation(){
        String AllInfo =  "\nPizza type:        " + getPizza().getPizza_type()
                        + "\nPizza Size:        " + getPizza_size()
                        + "\n\nAddress:         "
                        + "\nZip/postal code:   " + getZipcode()
                        + "\nStreet name:       " + getStreet()
                        + "\nCity name:         " + getCity()
                        + "\nHouse number:      " + getHouse_number() + " Extra: " + getHouse_numberExtras()
                        + "\n\nCost:            "
                        + "\nCost of Pizza :    $ " + getPizza().getPrice()
                        + "\nCost of Size:      $ " + getSizePrice()
                        + "\nCost of Delivery:  $ " + getDeliveryPrice()
                        + "\n"
                        + "\nTotal Cost:        $ " + getTotalPriceDelivery(getPizza().getPrice(), getSizePrice(), getDeliveryPrice());


        return AllInfo;
    }


    private Double getSizePrice(){
        switch (getPizza_size()){
            case Small:
                return 0.0;
            case Medium:
                return 1.0;
            case Large:
                return 2.0;
            default:
                return null;
        }
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza_size getPizza_size() {
        return pizza_size;
    }

    public void setPizza_size(Pizza_size pizza_size) {
        this.pizza_size = pizza_size;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHouse_number() {
        return house_number;
    }

    public void setHouse_number(Integer house_number) {
        this.house_number = house_number;
    }

    public String getHouse_numberExtras() {
        return house_numberExtras;
    }

    public void setHouse_numberExtras(String house_numberExtras) {
        this.house_numberExtras = house_numberExtras;
    }
}
