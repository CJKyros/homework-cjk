package entity;

public class Perfume {
    private int id;
    private String name;
    private float price;
    private String capacity;
    private String other;

    public Perfume() {
    }

    public Perfume(int id, String name, float price, String capacity, String other) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
