package org.example.warehouse;

import java.util.Objects;


public class Category implements Comparable{
    private String name;

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static Category of(String name) {
        return new Category(name);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
