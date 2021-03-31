package Enums;

public enum Pizza_type {
    Margherita (7.0),
    Pepperoni (7.5),
    Quattro_Formaggi (9.0),
    Tonno (9.0),
    ;

    private final double price;

    Pizza_type(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
