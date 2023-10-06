package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class Warehouse {

    public static void main(String[] args) {
/*
        // todo: ta bort main innan klar
        // Skapar ett nytt warehouse, ange namn
        Warehouse warehouse2 = getInstance("Varuhuset");
        //lägg till products i listan i warehouse
        UUID uuid1 = UUID.randomUUID();
        warehouse2.addProduct(uuid1, "Banan",Category.of("fruit"), BigDecimal.valueOf(700,2));
        warehouse2.addProduct(null, "Ost",Category.of("Dairy"), BigDecimal.valueOf(1300,3));
        warehouse2.addProduct(null, "Strömming",Category.of("fish"), BigDecimal.valueOf(1300,3));


        //System.out.println(warehouse2.addedProducts.stream().toList());
        System.out.println();
        //System.out.println(warehouse2.addedProducts.stream().map(Object::toString).collect(Collectors.toList()));
        List<String> stringList = warehouse2.addedProducts.stream()
                .map(p -> String.format("%s, %s, %s, %.2f", p.uuid(), p.product(), p.category(), p.price()))
                .collect(Collectors.toList());

        System.out.println(stringList);
*/

    }

    private String name;
    private List<ProductRecord> addedProducts = new ArrayList<>();
    private List<ProductRecord> changedProducts = new ArrayList<>();
    private static Warehouse instance;

    private Warehouse(String name) {
        this.name = name;
        this.addedProducts = new ArrayList<>();
        this.changedProducts = new ArrayList<>();
    }

    public static Warehouse getInstance(String name) {
        if (instance == null) {
            instance = new Warehouse(name);
        }
        return new Warehouse(name);
    }

    public List<ProductRecord> getProducts() {
        //return Collections.unmodifiableList(addedProducts);
        //return List.copyOf(addedProducts);
        return addedProducts.stream().toList();
    }

    public boolean isEmpty() {
        return addedProducts.isEmpty();
    }

    public ProductRecord addProduct(UUID uuid, String product, Category category, BigDecimal price) {

        Optional.ofNullable(product).filter(p -> !p.isBlank()).orElseThrow(() -> new IllegalArgumentException("Product name can't be null or empty."));

        Optional.ofNullable(category).orElseThrow(() -> new IllegalArgumentException("Category can't be null."));
        //Optional.ofNullable(uuid).orElse(uuid = UUID.randomUUID());
        if (uuid == null)
            uuid = UUID.randomUUID();

        checkIfIdAlreadyExist(uuid);

        Optional.ofNullable(price).orElse(price = BigDecimal.ZERO);

        //addedProducts.add(new ProductRecord(uuid, product, category, price));
        addedProducts.add(new ProductRecord(uuid, product, category, price));
        return new ProductRecord(uuid, product, category, price);

    }

    private void checkIfIdAlreadyExist(UUID uuid) {
        addedProducts.stream().filter(p -> p.uuid().equals(uuid)).findAny().ifPresent(ProductRecord -> {
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");});
    }

    public Optional<ProductRecord> getProductById (UUID uuid) {

      /*  for (ProductRecord product : addedProducts) {

                if (ProductRecord.uuid.equals(uuid)) {
                    return Optional.of(product);
                }
        }
        return Optional.empty();


       */

        return addedProducts.stream().filter(p -> p.uuid().equals(uuid)).findAny();

    }

    public void updateProductPrice(UUID uuid, BigDecimal price) {

        Optional<ProductRecord> oldRecord = addedProducts.stream()
                .filter(p -> p.uuid().equals(uuid))
                .findFirst();

        if (oldRecord.isEmpty())
            throw new IllegalArgumentException("Product with that id doesn't exist.");
        else {
            ProductRecord newRecord = new ProductRecord(uuid, oldRecord.get().product(), oldRecord.get().category(), price);

            addedProducts.remove(oldRecord.get());
            addedProducts.add(newRecord);

            changedProducts.removeIf(p -> p.uuid().equals(uuid));
            changedProducts.add(oldRecord.get());
        }
    }
        public List<ProductRecord> getChangedProducts() {
        //todo: ?? Om en productRecord tas bort så ska den tas bort från addedProduct och changedProducts
                //return List.copyOf(changedProducts);
                return changedProducts.stream().toList();
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return addedProducts.stream()
                .collect(Collectors.groupingBy(ProductRecord::category));
    }

    public List<ProductRecord> getProductsBy(Category category) {
        return addedProducts.stream()
                .filter(p -> p.category().equals(category))
                .toList();
    }


}





