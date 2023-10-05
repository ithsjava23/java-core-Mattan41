package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class Warehouse {

    public static void main(String[] args) {


        // Skapar ett nytt warehouse, ange namn
        Warehouse warehouse = new Warehouse("Varuhuset");
        Warehouse warehouse2 = getInstance("Haruvuset");
        //lägg till products i listan i warehouse
        warehouse.addProduct(UUID.randomUUID(), "Banan",Category.of("fruit"), BigDecimal.valueOf(700,2));
        warehouse.addProduct(UUID.randomUUID(), "Strömming",Category.of("fish"), BigDecimal.valueOf(1300,3));
        warehouse.addProduct(UUID.randomUUID(), "Ost",Category.of("Dairy"), BigDecimal.valueOf(1300,3));
        warehouse.updateProductPrice(UUID.randomUUID(), BigDecimal.valueOf(453,34));



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
        return Collections.unmodifiableList(addedProducts);
        //return List.copyOf(addedProducts);
    }

    public boolean isEmpty() {
        return addedProducts.isEmpty();
    }

    public ProductRecord addProduct(UUID uuid, String product, Category category, BigDecimal price) {

    /*    if (Objects.equals(product, "") || product == null)
            throw new IllegalArgumentException("Product name can't be null or empty.");

        if (category == null)
            throw new IllegalArgumentException("Category can't be null.");

        if (addedProducts.stream().anyMatch(ProductRecord -> ProductRecord.uuid().equals(uuid))) {
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
        }
     */

        Optional.ofNullable(product).filter(p -> !p.isBlank()).orElseThrow(() -> new IllegalArgumentException("Product name can't be null or empty."));

        Optional.ofNullable(category).orElseThrow(() -> new IllegalArgumentException("Category can't be null."));

        addedProducts.stream().filter(ProductRecord -> ProductRecord.uuid().equals(uuid)).findFirst().ifPresent(ProductRecord -> {
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
                });

        addedProducts.add(new ProductRecord(uuid, product, category, price));
        return new ProductRecord(uuid, product, category, price);

    }

    public Optional<ProductRecord> getProductById (UUID uuid) {

        for (ProductRecord product : addedProducts) {

                if (ProductRecord.uuid.equals(uuid)) {
                    return Optional.of(product);
                }
        }
        return Optional.empty();

    }
    public void updateProductPrice(UUID uuid, BigDecimal price) {
    //todo fixa denna

        if (addedProducts.stream().noneMatch(ProductRecord -> ProductRecord.uuid().equals(uuid))) {
            throw new IllegalArgumentException("Product with that id doesn't exist.");
        }

        /*//ta bort tidigare instans om det finns i changedProducts
        changedProducts.removeIf(ProductRecord -> ProductRecord.uuid().equals(uuid));
        //Uppdatera priset
        addedProducts.stream().filter(addedProducts -> ProductRecord.uuid.equals(uuid)).forEach(product -> product.setPrice(price));
        //lägga till i changedProducts
        addedProducts.stream().filter(product -> ProductRecord.uuid.equals(uuid)).forEach(product -> changedProducts.add(product));

         */
        addedProducts.stream().filter(product -> ProductRecord.uuid.equals(uuid)).peek(product -> product.setPrice(price)).forEach(changedProducts::add);





        //lägg till kopia av det nya objectet till changedProducts


        // if (!addedProducts.isEmpty()) {
        //    changedProducts.add(addedProducts.get(0));
        //}
    }

    public List<ProductRecord> getChangedProducts() {
        //todo: ?? Om en productRecord tas bort så ska den tas bort från addedProduct och changedProducts
                return List.copyOf(changedProducts);
    }

    /*public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        // todo: sortera array addedProducts efter category, eller skapa en hashmap via Stream?
        return Map<Category, List<ProductRecord>> aMapWithAllProductsForEachCategory = new HashMap<>();;
    }

     */
    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return addedProducts.stream().collect(Collectors.groupingBy(ProductRecord::category));
    }


    public List<ProductRecord> getProductsBy(Category category) {

        return addedProducts.stream().filter(addedProducts -> ProductRecord.category.equals(category)).toList();

    }
}





