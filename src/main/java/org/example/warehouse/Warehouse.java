package org.example.warehouse;

import java.math.BigDecimal;
import java.util.*;


public class Warehouse {

    public static void main(String[] args) {


        // Skapar ett nytt warehouse, ange namn
        Warehouse warehouse = new Warehouse("Varuhuset");

        //lägg till products i listan i warehouse
        warehouse.addProduct(UUID.randomUUID(), "Banan",Category.of("fruit"), BigDecimal.valueOf(700,2));
        warehouse.addProduct(UUID.randomUUID(), "Strömming",Category.of("fish"), BigDecimal.valueOf(1300,3));


        //skapa lista som uppdateras med ändrade varor, alltså varje gång en vara ändras - metod getChangedProducts
        // om varan har uppdaterats förut skall den gamla varan tas bort. Ska det vara ett hashSet
        // lägga listan i warehouse??
        System.out.println(warehouse);
    }


        //Sortera efter varan
        //ta bort varor ur listan
        //söka vara efter UUID
        //
        //göra map över alla kategorier
//        Map<Category, List<ProductRecord>> aMapWithAllProductsForEachCategory = new HashMap<>();



    private Warehouse(String name) {
    }
    private final List<ProductRecord> addedProducts = new ArrayList<>();
    private final List<ProductRecord> changedProducts = new ArrayList<>();

    public static Warehouse getInstance(String name) {
        if (name == null)
            throw new RuntimeException();

        return new Warehouse(name);
    }

    public List<ProductRecord> getProducts() {
        return Collections.unmodifiableList(addedProducts);

    public boolean isEmpty() {
        return addedProducts.isEmpty();
    }
/*


    }
     */


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
    //Uppdatera pris i ProductRecord sök på uuid, uppdatera nytt pris, uppdatera ArrayList med ändrade produkter
    // BigDecimal price är det nya priset
        //hitta rätt productRecord via uuid
        //uppdatera priset
        // kolla om det finns i changedProducts, ta bort om det finns.
        // lägga till productRecord i changedProducts

        // lägga till changedProducts.add();




    }

    public boolean getChangedProducts() {
        //metod att fånga ändrade produkter
        return false;
    }

    public boolean getProductsGroupedByCategories() {
        // HashMap??
        return false;
    }

    public ProductRecord getProductsBy(Category category) {
        //sortera produktlista efter kategorier
        return null;
    }
}





