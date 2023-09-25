package org.example.warehouse;

import java.util.Objects;


public class Category {
    private String name;

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    /*

    public static void main(String[] args) {
        Category myObject = of("Banana");
        System.out.println(myObject.getName());
    }

     */

    public static Category of(String name) {
        return new Category(name);
    }

/*


    //setter

    public void setName(String name) {
        this.name = name;
    }
     */


}
