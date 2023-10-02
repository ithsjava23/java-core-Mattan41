package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;


public class Warehouse {

    public static void main(String[] args) {


        // Skapar ett nytt warehouse, ange namn
        Warehouse warehouse = new Warehouse("Varuhuset");

        //lägga till varor
        warehouse.addProduct(UUID.randomUUID(), "Banan",Category.of("fruit"), BigDecimal.valueOf(700,2));
        warehouse.addProduct(UUID.randomUUID(), "Strömming",Category.of("fish"), BigDecimal.valueOf(1300,3));

        var productRecord = warehouse.addProduct(UUID.randomUUID(), "Test", Category.of("Test"), null);
        System.out.println(productRecord);
        System.out.println(warehouse);
    }

        //lägg till products i listan i warehouse
        //Sortera efter varan
        //ta bort varor ur listan
        //söka vara efter UUID

        //göra map över alla kategorier
//        Map<Category, List<ProductRecord>> aMapWithAllProductsForEachCategory = new HashMap<>();



    private Warehouse(String name) {
    }
    public static List<ProductRecord> products = new ArrayList<>();

    public static Warehouse getInstance(String name) {
        if (name == null)
            throw new RuntimeException();

        return new Warehouse(name);
    }

    public Optional<List<ProductRecord>> getProducts() {
        return Optional.ofNullable(products);
    }

    public Optional<List<ProductRecord>> isEmpty(Warehouse warehouse) {
        return warehouse.getProducts();
    }

    public ProductRecord addProduct(UUID uuid, String product, Category category, BigDecimal price) {
        return new ProductRecord(UUID.randomUUID(), product, category, price);
    }

    public ProductRecord getProductById (UUID uuid) {

            for (ProductRecord product : products) {
                if (ProductRecord.uuid.equals(uuid)) {
                    return product;
                }
            }
            return null;

    }

    public void updateProductPrice(UUID uuid, BigDecimal price) {
    //Uppdatera pris i ProductRecord sök på uuid, uppdatera ny pris


    }

    public boolean getChangedProducts() {
        //
    }

    public boolean getProductsGroupedByCategories() {
        // HashMap
    }

    public ProductRecord getProductsBy(Category category) {
        //sortera produktlista efter kategorier
    }
}





