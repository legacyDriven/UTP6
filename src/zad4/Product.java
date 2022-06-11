package zad4;

import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
@Immutable
public class Product {

    private final long id;

    private final Integer weightInKG;

    public static Product parseFromString(String argument){
        return new Product(Long.parseLong(argument.split(" ")[0]), Integer.parseInt(argument.split(" ")[1]));
    }

    public Product(long id, Integer weight) {
        this.id = id;
        this.weightInKG = weight;
    }

    public long getId() {
        return id;
    }

    public Integer getWeight() {
        return weightInKG;
    }

    @Override
    public String toString() {
        return id + " " + weightInKG;
    }
}
