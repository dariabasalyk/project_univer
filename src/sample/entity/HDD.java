package sample.entity;


public class HDD{
    private int id;
    private String name;
    private int capacity;
    private String interface_hdd;
    private int the_volume_of_buffer;
    private int the_data_rate;
    private int guarantee;
    private double price;

    public HDD(int id, String name, int capacity, String interface_hdd, int the_volume_of_buffer, int the_data_rate, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.interface_hdd = interface_hdd;
        this.the_volume_of_buffer = the_volume_of_buffer;
        this.the_data_rate = the_data_rate;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getInterface_hdd() {
        return interface_hdd;
    }

    public void setInterface_hdd(String interface_hdd) {
        this.interface_hdd = interface_hdd;
    }

    public int getThe_volume_of_buffer() {
        return the_volume_of_buffer;
    }

    public void setThe_volume_of_buffer(int the_volume_of_buffer) {
        this.the_volume_of_buffer = the_volume_of_buffer;
    }

    public int getThe_data_rate() {
        return the_data_rate;
    }

    public void setThe_data_rate(int the_data_rate) {
        this.the_data_rate = the_data_rate;
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
        return "Жесткий диск{" + "\r\n" +
                ", название='" + name + "\r\n" +
                ", capacity=" + capacity + "\r\n" +
                ", interface_hdd='" + interface_hdd + "\r\n" +
                ", the_volume_of_buffer=" + the_volume_of_buffer + "\r\n" +
                ", the_data_rate=" + the_data_rate +
                ", guarantee=" + guarantee + "\r\n" +
                ", price=" + price + "\r\n" +
                '}';
    }
}
