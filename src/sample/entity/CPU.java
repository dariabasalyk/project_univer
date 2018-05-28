package sample.entity;

// Описание сущности CPU
public class CPU {
    private int id;
    private String name;
    private String connector_type;
    private int number_of_cores;
    private int internal_clock_rate;
    private String the_unlocked_multiplier;
    private double the_frequency_of_the_data_bus;
    private int number_of_contacts;
    private int TDP_power;
    private String kernel_type;
    private int guarantee;
    private double price;

    // Консруктор
    public CPU(int id, String name, String connector_type, int number_of_cores, int internal_clock_rate, String the_unlocked_multiplier, double the_frequency_of_the_data_bus, int number_of_contacts, int TDP_power, String kernel_type, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.connector_type = connector_type;
        this.number_of_cores = number_of_cores;
        this.internal_clock_rate = internal_clock_rate;
        this.the_unlocked_multiplier = the_unlocked_multiplier;
        this.the_frequency_of_the_data_bus = the_frequency_of_the_data_bus;
        this.number_of_contacts = number_of_contacts;
        this.TDP_power = TDP_power;
        this.kernel_type = kernel_type;
        this.guarantee = guarantee;
        this.price = price;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getConnector_type() {
        return connector_type;
    }

    public int getNumber_of_cores() {
        return number_of_cores;
    }

    public int getInternal_clock_rate() {
        return internal_clock_rate;
    }

    public String getThe_unlocked_multiplier() {
        return the_unlocked_multiplier;
    }

    public double getThe_frequency_of_the_data_bus() {
        return the_frequency_of_the_data_bus;
    }

    public int getNumber_of_contacts() {
        return number_of_contacts;
    }

    public int getTDP_power() {
        return TDP_power;
    }

    public String getKernel_type() {
        return kernel_type;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConnector_type(String connector_type) {
        this.connector_type = connector_type;
    }

    public void setNumber_of_cores(int number_of_cores) {
        this.number_of_cores = number_of_cores;
    }

    public void setInternal_clock_rate(int internal_clock_rate) {
        this.internal_clock_rate = internal_clock_rate;
    }

    public void setThe_unlocked_multiplier(String the_unlocked_multiplier) {
        this.the_unlocked_multiplier = the_unlocked_multiplier;
    }

    public void setThe_frequency_of_the_data_bus(double the_frequency_of_the_data_bus) {
        this.the_frequency_of_the_data_bus = the_frequency_of_the_data_bus;
    }

    public void setNumber_of_contacts(int number_of_contacts) {
        this.number_of_contacts = number_of_contacts;
    }

    public void setTDP_power(int TDP_power) {
        this.TDP_power = TDP_power;
    }

    public void setKernel_type(String kernel_type) {
        this.kernel_type = kernel_type;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Центральный процессор{" + "\r\n" +
                ", название='" + name + "\r\n" +
                ", connector_type='" + connector_type + "\r\n" +
                ", number_of_cores=" + number_of_cores + "\r\n" +
                ", internal_clock_rate=" + internal_clock_rate + "\r\n" +
                ", the_unlocked_multiplier='" + the_unlocked_multiplier + "\r\n" +
                ", the_frequency_of_the_data_bus=" + the_frequency_of_the_data_bus + "\r\n" +
                ", number_of_contacts=" + number_of_contacts + "\r\n" +
                ", TDP_power=" + TDP_power + "\r\n" +
                ", kernel_type='" + kernel_type + "\r\n" +
                ", guarantee=" + guarantee + "\r\n" +
                ", price=" + price + "\r\n" +
                '}';
    }
}
