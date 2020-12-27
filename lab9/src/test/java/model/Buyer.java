package model;

import java.util.Objects;

public class Buyer {
    private String name;
    private String phone;

    public Buyer() {
        this.name = "";
        this.phone = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return name.equals(buyer.name) &&
                phone.equals(buyer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
