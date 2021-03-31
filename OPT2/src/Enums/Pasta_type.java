package Enums;

public enum Pasta_type {
    spaghetti (7.0),
    Lasagne (8.0),
    Carbonara (10.0);


    private final double price;

    Pasta_type(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
