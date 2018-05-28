package sample.entity;


public class Housing {
    private int id;
    private String name;
    private String housing_material;
    private String type_of_housing;
    private int guarantee;
    private double price;

    public Housing(int id, String name, String housing_material, String type_of_housing, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.housing_material = housing_material;
        this.type_of_housing = type_of_housing;
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

    public String getHousing_material() {
        return housing_material;
    }

    public void setHousing_material(String housing_material) {
        this.housing_material = housing_material;
    }

    public String getType_of_housing() {
        return type_of_housing;
    }

    public void setType_of_housing(String type_of_housing) {
        this.type_of_housing = type_of_housing;
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
        return "Корпус{" + "\r\n" +
                ", Название='" + name + "\r\n" +
                ", housing_material='" + housing_material + "\r\n" +
                ", type_of_housing='" + type_of_housing + "\r\n" +
                ", guarantee=" + guarantee + "\r\n" +
                ", price=" + price + "\r\n" +
                '}';
    }
}
