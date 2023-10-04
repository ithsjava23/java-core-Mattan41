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
    }

    public boolean isEmpty() {
        return changedProducts.isEmpty();
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
        // addedProducts.stream().filter(addedProducts -> ProductRecord.uuid.equals(uuid)).toList() ??

        //Uppdatera pris på object i ProductRecord sök på uuid, uppdatera nytt pris, uppdatera ArrayList med ändrade produkter
        // BigDecimal price är det nya priset

        //hitta rätt productRecord via uuid, söka igenom addedProduct (get på uuid)
        //uppdatera priset på objectet
        // kolla om productRecord finns i changedProducts, söka på uuid, ta bort det gamla objectet om det redan finns.
        // lägga till nya productRecord i changedProducts
        // lägga till changedProducts.add();


    }

    public boolean getChangedProducts() {
        //todo: denna.
        // metod att fånga ändrade produkter - stream?
        //bara returera changedProducts - eller även empty om tom
        return false;
    }

    public boolean getProductsGroupedByCategories() {
        // todo: sortera array addedProducts efter category, eller skapa en hashmap
        return false;
    }

    public List<ProductRecord> getProductsBy(Category category) {

        return addedProducts.stream().filter(addedProducts -> ProductRecord.category.equals(category)).toList();

    }
}





