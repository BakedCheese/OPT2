import Enums.Pizza_type;

public class Pizza {
    private Pizza_type pizza_type;
    private Double price;

    public Pizza(Pizza_type pizza_type, Double price) {
        this.pizza_type = pizza_type;
        this.price = price;
    }

    public Pizza_type getPizza_type() {
        return pizza_type;
    }

    public Double getPrice() {
        return price;
    }
}
