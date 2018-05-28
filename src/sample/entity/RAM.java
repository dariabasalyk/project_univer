package sample.entity;

import sample.entity.enums.TypeOfMemory;
import sample.entity.enums.TypeRam;


public class RAM {
    private int id;
    private String name;
    private int memory_size;
    private TypeRam typeOfMemory;
    private double supply_voltage;
    private int memory_frequency;
    private int effective_bandwidth;
    private int number_if_strips;
    private int guarantee;
    private double price;

    public RAM(int memorySize, String name, double price) {
        this.memory_size = memorySize;
        this.name = name;
        this.price = price;
    }

    public RAM(int id, String name, int memory_size, TypeRam typeOfMemory, double supply_voltage, int memory_frequency, int effective_bandwidth, int number_if_strips, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.memory_size = memory_size;
        this.typeOfMemory = typeOfMemory;
        this.supply_voltage = supply_voltage;
        this.memory_frequency = memory_frequency;
        this.effective_bandwidth = effective_bandwidth;
        this.number_if_strips = number_if_strips;
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

    public int getMemory_size() {
        return memory_size;
    }

    public void setMemory_size(int memory_size) {
        this.memory_size = memory_size;
    }

    public TypeRam getTypeOfMemory() {
        return typeOfMemory;
    }

    public void setTypeOfMemory(TypeRam typeOfMemory) {
        this.typeOfMemory = typeOfMemory;
    }

    public double getSupply_voltage() {
        return supply_voltage;
    }

    public void setSupply_voltage(double supply_voltage) {
        this.supply_voltage = supply_voltage;
    }

    public int getMemory_frequency() {
        return memory_frequency;
    }

    public void setMemory_frequency(int memory_frequency) {
        this.memory_frequency = memory_frequency;
    }

    public int getEffective_bandwidth() {
        return effective_bandwidth;
    }

    public void setEffective_bandwidth(int effective_bandwidth) {
        this.effective_bandwidth = effective_bandwidth;
    }

    public int getNumber_if_strips() {
        return number_if_strips;
    }

    public void setNumber_if_strips(int number_if_strips) {
        this.number_if_strips = number_if_strips;
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
        return "Оперативная память{" + "\r\n" +
                ", название='" + name + "\r\n" +
                ", memory_size=" + memory_size + "\r\n" +
                ", typeOfMemory=" + typeOfMemory + "\r\n" +
                ", supply_voltage=" + supply_voltage + "\r\n" +
                ", memory_frequency=" + memory_frequency + "\r\n" +
                ", effective_bandwidth=" + effective_bandwidth + "\r\n" +
                ", number_if_strips=" + number_if_strips + "\r\n" +
                ", guarantee=" + guarantee + "\r\n" +
                ", price=" + price + "\r\n" +
                '}';
    }
}
