package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;


public class Warehouse {

    public static void main(String[] args) {


        // Skapar ett nytt warehouse, ange namn
        Warehouse warehouse = new Warehouse("Varuhuset");
        Warehouse warehouse2 = getInstance("Haruvuset");
        //lägg till products i listan i warehouse
        warehouse.addProduct(UUID.randomUUID(), "Banan",Category.of("fruit"), BigDecimal.valueOf(700,2));
        warehouse.addProduct(UUID.randomUUID(), "Strömming",Category.of("fish"), BigDecimal.valueOf(1300,3));
        warehouse.addProduct(UUID.randomUUID(), "Ost",Category.of("Dairy"), BigDecimal.valueOf(1300,3));

        ProductRecord produkt = new ProductRecord(UUID.randomUUID(), "Ost", Category.of("Dairy"), BigDecimal.valueOf(2342,12));
        produkt.setPrice(BigDecimal.valueOf(342,3));

        //skapa lista som uppdateras med ändrade varor, alltså varje gång en vara ändras - metod getChangedProducts
        // om varan har uppdaterats förut skall den gamla varan tas bort. Ska det vara ett hashSet
        // lägga listan i warehouse??

        System.out.println(warehouse.addedProducts);
        System.out.println(warehouse2.addedProducts);


    }


        //Sortera efter varan
        //ta bort varor ur listan
        //söka vara efter UUID
        //
        //göra map över alla kategorier
//        Map<Category, List<ProductRecord>> aMapWithAllProductsForEachCategory = new HashMap<>();



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
        return instance;
    }

    public List<ProductRecord> getProducts() {
        return Collections.unmodifiableList(addedProducts);
    }

    public boolean isEmpty() {
        return addedProducts.isEmpty();
    }

    public ProductRecord addProduct(UUID uuid, String product, Category category, BigDecimal price) {
        return new ProductRecord(UUID.randomUUID(), product, category, price);
        //todo: kolla att uuid inte redan är upptaget innan uuid assignas??
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
        //uppdatera priset
        addedProducts.stream().filter(addedProducts -> ProductRecord.uuid.equals(uuid)).forEach(product -> product.setPrice(price));
        //ta bort tidigare instans om det finns i changedProducts
        changedProducts.removeIf(ProductRecord -> ProductRecord.uuid().equals(uuid));

        //lägg till kopia av det nya objectet till changedProducts
        //changedProducts.add(getProductById(uuid));

        // if (!addedProducts.isEmpty()) {
        //    changedProducts.add(addedProducts.get(0));
        //}
    }

    public List<ProductRecord> getChangedProducts() {
        //todo: ?? Om en productRecord tas bort så ska den tas bort från addedProduct och changedProducts


                return List.copyOf(changedProducts);

    }

    public boolean getProductsGroupedByCategories() {
        // todo: sortera array addedProducts efter category, eller skapa en hashmap via Stream?
        return false;
    }

    public List<ProductRecord> getProductsBy(Category category) {

        return addedProducts.stream().filter(addedProducts -> ProductRecord.category.equals(category)).toList();

    }
}





