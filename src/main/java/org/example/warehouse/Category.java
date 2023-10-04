package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Category implements Comparable{



    //public class MyClass {
      //  private static Map<String, MyClass> instances = new HashMap<>();
        //private String name;

       // private MyClass(String name) {
        //    this.name = name;
        //}




    private String name;

    private static Map<String, Category> instances = new HashMap<>();
    private Category(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Category of(String name) {

        if (name == null)
            throw new IllegalArgumentException("Category name can't be null");

        if (!instances.containsKey(name)) {
            instances.put(name, new Category(name));
        }
        return instances.get(name);
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
