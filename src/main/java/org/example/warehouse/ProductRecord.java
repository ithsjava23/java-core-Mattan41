package org.example.warehouse;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record ProductRecord(UUID uuid, String product, Category category, BigDecimal price) implements Comparable{


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
