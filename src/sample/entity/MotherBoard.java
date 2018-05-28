package sample.entity;


public class MotherBoard {
    private int id;
    private String name;
    private String connector_type;
    private String chipset;
    private String physical_dimension;
    private int guarantee;
    private double price;

    public MotherBoard(int id, String name, String connector_type, String chipset, String physical_dimension, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.connector_type = connector_type;
        this.chipset = chipset;
        this.physical_dimension = physical_dimension;
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

    public String getConnector_type() {
        return connector_type;
    }

    public void setConnector_type(String connector_type) {
        this.connector_type = connector_type;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getPhysical_dimension() {
        return physical_dimension;
    }

    public void setPhysical_dimension(String physical_dimension) {
        this.physical_dimension = physical_dimension;
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
        return "Материнская карта{" + "\r\n" +
                ", название='" + name + "\r\n" +
                ", connector_type='" + connector_type + "\r\n" +
                ", chipset='" + chipset + "\r\n" +
                ", physical_dimension='" + physical_dimension + "\r\n" +
                ", guarantee=" + guarantee +
                ", price=" + price +
                "}\r\n";
    }
}
