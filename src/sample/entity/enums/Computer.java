package sample.entity.enums;

public class Computer {
    private int id;
    private String name;
    private String type;
    private int cpu_id;
    private int hdd_id;
    private int housing_id;
    private int mother_board_id;
    private int ram_id;
    private int video_card_id;
    private int mouse_id;
    private int modem_id;
    private int printer_id;
    private int guarantee;
    private int price;

    public Computer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Computer(int id, String name, String type, int cpu_id, int hdd_id, int housing_id, int mother_board_id, int ram_id, int video_card_id, int mouse_id, int modem_id, int printer_id, int guarantee, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cpu_id = cpu_id;
        this.hdd_id = hdd_id;
        this.housing_id = housing_id;
        this.mother_board_id = mother_board_id;
        this.ram_id = ram_id;
        this.video_card_id = video_card_id;
        this.mouse_id = mouse_id;
        this.modem_id = modem_id;
        this.printer_id = printer_id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCpu_id() {
        return cpu_id;
    }

    public void setCpu_id(int cpu_id) {
        this.cpu_id = cpu_id;
    }

    public int getHdd_id() {
        return hdd_id;
    }

    public void setHdd_id(int hdd_id) {
        this.hdd_id = hdd_id;
    }

    public int getHousing_id() {
        return housing_id;
    }

    public void setHousing_id(int housing_id) {
        this.housing_id = housing_id;
    }

    public int getMother_board_id() {
        return mother_board_id;
    }

    public void setMother_board_id(int mother_board_id) {
        this.mother_board_id = mother_board_id;
    }

    public int getRam_id() {
        return ram_id;
    }

    public void setRam_id(int ram_id) {
        this.ram_id = ram_id;
    }

    public int getVideo_card_id() {
        return video_card_id;
    }

    public void setVideo_card_id(int video_card_id) {
        this.video_card_id = video_card_id;
    }

    public int getMouse_id() {
        return mouse_id;
    }

    public void setMouse_id(int mouse_id) {
        this.mouse_id = mouse_id;
    }

    public int getModem_id() {
        return modem_id;
    }

    public void setModem_id(int modem_id) {
        this.modem_id = modem_id;
    }

    public int getPrinter_id() {
        return printer_id;
    }

    public void setPrinter_id(int printer_id) {
        this.printer_id = printer_id;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cpu_id=" + cpu_id +
                ", hdd_id=" + hdd_id +
                ", housing_id=" + housing_id +
                ", mother_board_id=" + mother_board_id +
                ", ram_id=" + ram_id +
                ", video_card_id=" + video_card_id +
                ", mouse_id=" + mouse_id +
                ", modem_id=" + modem_id +
                ", printer_id=" + printer_id +
                ", guarantee=" + guarantee +
                ", price=" + price +
                '}';
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
