package org.example.warehouse;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ProductRecord implements Comparable{

    static UUID uuid;
    static String product;
    static Category category;
    BigDecimal price;


    public ProductRecord(UUID uuid, String product, Category category, BigDecimal price) {
        ProductRecord.uuid = uuid;
        ProductRecord.product = product;
        ProductRecord.category = category;
        this.price = Objects.requireNonNullElse(price, BigDecimal.ZERO);
    }
    //factory
    /*
    public static ProductRecord createProductRecord(UUID uuid,String product, Category category, BigDecimal price) {
        return new ProductRecord(uuid, product, category, price);
    }

    public UUID getUuid() {
        return uuid;
    }

    public static String getProduct() {
        return product;
    }

    public Category getCategory() {
        return category;
    }
     */

    public BigDecimal price() {
            if (price == null)
                price = BigDecimal.ZERO;
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = Objects.requireNonNullElse(price, BigDecimal.ZERO);
    }

    public String product(){return product;}
    public UUID uuid() {
            return uuid;
    }

    public Category category() {
        return category;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
