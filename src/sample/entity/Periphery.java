package sample.entity;


public class Periphery {

    private int id;
    private String name;
    private String description;
    private int guarantee;
    private double price;

    public Periphery(int id, String name, String description, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guarantee = guarantee;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Перифирия{" + "\r\n" +
                ", название='" + name + "\r\n" +
                ", описание='" + description + "\r\n" +
                ", guarantee=" + guarantee + "\r\n" +
                ", price=" + price + "\r\n" +
                '}';
    }
}
