package org.example.warehouse;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRecord(UUID uuid, String product, Category category, BigDecimal price){

    public String product(){return product;}
    public UUID uuid() {
            return uuid;
    }

    public Category category() {
        return category;
    }
}
