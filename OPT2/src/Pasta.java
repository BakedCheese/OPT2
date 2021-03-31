import Enums.Food_size;
import Enums.Pasta_type;

public class Pasta extends Food {
    private Pasta_type pasta_type;

    public Pasta(Pasta_type pasta_type, Food_size size) {
        this.pasta_type = pasta_type;
        this.setSize(size);
    }


    @Override
    public Enum getFoodType() {
        return pasta_type;
    }

    @Override
    public double getPrice() {
        return pasta_type.getPrice();
    }

}
