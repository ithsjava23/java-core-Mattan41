package org.example.warehouse;

public class Warehouse {


    private String name;

    public Warehouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Warehouse getInstance(String myStore) {
        return new Warehouse(myStore);

    }

    // todo: create method isEmpty
    // todo: create method addProduct
    //todo: create method getProduct
    //todo: create method getProductByld
    //todo: create method getProducts
    //todo: create method getProductBy
    //todo: create method getChangedProduct
    //todo: create method getProductsGroupedByCategories
    //todo: create method uuid
    //todo: create method updateProductsPrice



}
