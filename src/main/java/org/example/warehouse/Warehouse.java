package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;


public class Warehouse {

    //public static void main(String[] args) {}

    private String name;
    private ProductRecord productRecord;


    private Warehouse(String name) {
        this.name = name;
    }

    public static Warehouse getInstance(String name) {
        return new Warehouse(name);
    }

    public boolean isEmpty() {

    }

    public boolean getProducts() {
    }

    record Product(String name, Category category){
    }
}





