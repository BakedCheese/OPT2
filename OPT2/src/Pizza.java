import Enums.Pizza_type;

public class Pizza extends Food {
    private Pizza_type pizza_type;

    public Pizza(Pizza_type pizza_type, Double price) {
        this.pizza_type = pizza_type;
        this.setPrice(price);
    }



    @Override
    public Enum getFoodType() {
        return pizza_type;
    }
}
