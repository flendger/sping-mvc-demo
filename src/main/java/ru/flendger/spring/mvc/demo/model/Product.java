package ru.flendger.spring.mvc.demo.model;

public class Product {

    private int id;
    private String title;
    private float price;

    public Product(int id, String title, float price) {
        this.id = id;
        this.title = title;
        setPrice(price);
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = (float) Math.round(price*100)/100;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + String.format("%.2f", price) +
                '}';
    }
}
