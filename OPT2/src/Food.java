import Enums.Food_size;

public abstract class Food {
    private Double price;
    private Food_size size;

    public void setSize(Food_size size) {
        this.size = size;
    }

    public Food_size getSize(){
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public abstract Enum getFoodType();

}
