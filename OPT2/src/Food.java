import Enums.Food_size;

public abstract class Food {
    private Food_size size;

    public void setSize(Food_size size) {
        this.size = size;
    }

    public Food_size getSize(){
        return size;
    }



    public abstract Enum getFoodType();
    public abstract double getPrice();

}
