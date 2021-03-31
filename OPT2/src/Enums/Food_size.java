package Enums;

public enum Food_size {
    Small (1.0),
    Medium (2.0),
    Large (3.0),
    ;

    public final double price;

    Food_size(double price) {
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
