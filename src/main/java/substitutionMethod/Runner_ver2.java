package substitutionMethod;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
abstract class Car {
    int price;

    abstract public Number getPrice();
}

class Audi extends Car{

    @Override
    public Integer getPrice() {//Number changed to Integer
        return price = 15;
    }
}

public class Runner_ver2 {
    public static void main(String[] args) {
        Audi audi = new Audi();
        System.out.println(audi.getPrice());
    }
}
