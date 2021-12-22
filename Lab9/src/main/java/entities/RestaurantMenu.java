package entities;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_menu")
public class RestaurantMenu {
    private String id;
    private String name;
    private double price;
    private double weight;
    private boolean is_on_sale;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "is_on_sale")
    public Boolean getIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(Boolean is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, price: %f, weight: %f, is_on_sale: %b", id, name, price, weight, is_on_sale);
    }
}
