package zad4;

import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@ThreadSafe
@Immutable
public class Product {

    private final long id;

    private final BigDecimal weightInKG;

    public static Product parseFromString(String argument){
        return new Product(Long.parseLong(argument.split(" ")[0]), new BigDecimal(argument.split(" ")[1]));
    }

    private Product(long id, BigDecimal weight) {
        this.id = id;
        this.weightInKG = weight.round(new MathContext(2, RoundingMode.HALF_UP));
    }

    public long getId() {
        return id;
    }

    public BigDecimal getWeight() {
        return weightInKG;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", weight=" + weightInKG +
                '}';
    }
}
