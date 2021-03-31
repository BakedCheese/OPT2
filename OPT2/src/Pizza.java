import Enums.Food_size;
import Enums.Pizza_type;

public class Pizza extends Food {
    private Pizza_type pizza_type;

    public Pizza(Pizza_type pizza_type, Food_size size) {
        this.pizza_type = pizza_type;
        this.setSize(size);
    }



    @Override
    public Enum getFoodType() {
        return pizza_type;
    }

    @Override
    public double getPrice() {
        return pizza_type.getPrice();
    }
}
