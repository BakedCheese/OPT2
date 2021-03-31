import Enums.Pasta_type;

public class Pasta extends Food {
    private Pasta_type pasta_type;

    public Pasta(Pasta_type pasta_type, Double price) {
        this.pasta_type = pasta_type;
        this.setPrice(price);
    }


    @Override
    public Enum getFoodType() {
        return pasta_type;
    }
}
