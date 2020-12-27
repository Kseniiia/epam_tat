package model;

import java.util.Objects;

public class Item {
    private String number;
    private String name;
    private Double price;

    public Item(String number) {
        this.number = number;
        this.name = "";
        this.price = 0.0;
    }

    public Item(String number, String name, Double price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return number.equals(item.number) &&
                name.equals(item.name) &&
                price.equals(item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, price);
    }
}
