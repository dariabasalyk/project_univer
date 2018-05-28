package sample;

import sample.entity.*;
import sample.entity.enums.Computer;
import sample.entity.enums.TypeOfMemory;
import sample.entity.enums.TypeRam;
import sample.jdbc.TExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import java.util.ArrayList;

public class Model {
    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String PASSWORD = "root";
    private final String USERNAME = "root";
    /**
     * Ниже перечислены запросы для извлечения всех товаров даного комплектующего
     */
    private final String queryCPU = "SELECT * FROM cpu";
    private final String queryVideoCard = "SELECT * FROM video_card";
    private final String queryHDD = "SELECT * FROM hdd";
    private final String queryMotherBoard = "SELECT * FROM mother_board";
    private final String queryRam = "SELECT * FROM ram";
    private final String queryHousing = "SELECT * FROM housing";
    private final String queryPeriphery = "SELECT * FROM periphery";
    private final String queryComputer = "SELECT * FROM computer";
    /**
     * Запросы для поиска по имени комплектующего
     */
    private final String searchCPU = "SELECT * FROM cpu WHERE cpu_name LIKE ";
    private final String searchVideoCard = "SELECT * FROM video_card where video_name LIKE ";
    private final String searchRam = "SELECT * FROM ram WHERE ram_name LIKE ";
    private final String searchMotherBoard = "SELECT * FROM mother_board where mother_board_name LIKE ";
    private final String searchHousing = "SELECT * FROM housing WHERE housing_name LIKE ";
    private final String searchHDD = "SELECT * FROM hdd WHERE hdd_name LIKE ";
    /**
     * Запросы на удаление по имени
     */
    private final String deleteFromCPU = "DELETE FROM cpu WHERE cpu_name = ";
    private final String deleteFromVideoCard = "DELETE FROM video_card WHERE video_name = ";
    private final String deleteFromHDD = "DELETE  FROM hdd WHERE hdd_name = ";
    private final String deleteFromMotherBoard = "DELETE FROM mother_board WHERE mother_board_name = ";
    private final String deleteFromRam = "DELETE FROM ram WHERE ram_name = ";
    private final String deleteFromHousing = "DELETE FROM housing WHERE housing_name = ";


    private ArrayList<VideoCard> videoCards;
    private ArrayList<CPU> cpuSet;
    private ArrayList<HDD> hddSet;
    private ArrayList<MotherBoard> motherBoardSet;
    private ArrayList<RAM> ramSet;
    private ArrayList<Housing> housingSet;
    private ArrayList<Periphery> peripheries;
    private ArrayList<Computer> computers;

    public Model() {
        this.videoCards = new ArrayList<>();
        this.cpuSet = new ArrayList<>();
        this.hddSet = new ArrayList<>();
        this.motherBoardSet = new ArrayList<>();
        this.ramSet = new ArrayList<>();
        this.housingSet = new ArrayList<>();
        this.peripheries = new ArrayList<>();
        this.computers = new ArrayList<>();
    }

    public ArrayList<CPU> getCpu(){
        return this.cpuSet;
    }

    public void setVideoCards(ArrayList<VideoCard> videoCards) {
        this.videoCards = videoCards;
    }

    public void setCpuSet(ArrayList<CPU> cpuSet) {
        this.cpuSet = cpuSet;
    }

    public void setHddSet(ArrayList<HDD> hddSet) {
        this.hddSet = hddSet;
    }

    public void setMotherBoardSet(ArrayList<MotherBoard> motherBoardSet) {
        this.motherBoardSet = motherBoardSet;
    }

    public void setRamSet(ArrayList<RAM> ramSet) {
        this.ramSet = ramSet;
    }

    public void setHousingSet(ArrayList<Housing> housingSet) {
        this.housingSet = housingSet;
    }

    public ArrayList<Periphery> getPeripheries(){
        TExecutor tExecutor = new TExecutor();

        if(!peripheries.isEmpty()){
            peripheries.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.peripheries = tExecutor.execQuery(connection,queryPeriphery,resultSet -> {
                while (resultSet.next()){
                    peripheries.add(new Periphery(
                            resultSet.getInt("id"),
                            resultSet.getString("periphery_name"),
                            resultSet.getString("description"),
                            resultSet.getInt("guarantee"),
                            resultSet.getDouble("price")
                    ));
                }
                return this.peripheries;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.peripheries;
    }

    public ArrayList<Computer> getComputers(){
        TExecutor tExecutor = new TExecutor();

        if(!computers.isEmpty()){
            computers.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.computers = tExecutor.execQuery(connection, queryComputer, resultSet -> {
                while (resultSet.next()){
                    computers.add(new Computer(
                            resultSet.getInt("id"),
                            resultSet.getString("computer_name"),
                            resultSet.getString("computer_type"),
                            resultSet.getInt("cpu_id"),
                            resultSet.getInt("hdd_id"),
                            resultSet.getInt("housing_id"),
                            resultSet.getInt("mother_board_id"),
                            resultSet.getInt("ram_id"),
                            resultSet.getInt("video_card_id"),
                            resultSet.getInt("computer_mouse_id"),
                            resultSet.getInt("modem_id"),
                            resultSet.getInt("printer_id"),
                            resultSet.getInt("guarantee"),
                            resultSet.getInt("price")
                            ));
                }
                return this.computers;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.computers;
    }

    public ArrayList<VideoCard> getVideoCards(){
        TExecutor tExecutor = new TExecutor();

        if(!videoCards.isEmpty()){
            videoCards.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            this.videoCards = tExecutor.execQuery(connection,queryVideoCard,resultSet ->{
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("video_card_name");
                    String the_graphics_chip = resultSet.getString("the_graphics_chip");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int core_clock = resultSet.getInt("core_clock");
                    double memory_size = resultSet.getDouble("memory_size");
                    int bit_memory_bus = resultSet.getInt("bit_memory_busl");
                    TypeOfMemory typeOfMemory = TypeOfMemory.valueOf(resultSet.getString("type_of_memory"));
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    videoCards.add(new VideoCard(id,name,the_graphics_chip,memory_frequency,core_clock,memory_size,bit_memory_bus,typeOfMemory,guarantee,price));
                }
                return this.videoCards;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.videoCards;
    }

    public ArrayList<CPU> getCpuSet(){
        TExecutor tExecutor = new TExecutor();

        if(!cpuSet.isEmpty()){
            cpuSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            this.cpuSet = tExecutor.execQuery(connection,queryCPU,resultSet ->{
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("cpu_name");
                    String connector_type = resultSet.getString("connector_type");
                    int number_of_cores = resultSet.getInt("number_of_cores");
                    int internal_clock_rate = resultSet.getInt("internal_clock_rate");
                    String the_unlocked_multiplier = resultSet.getString("the_unlocked_multiplier");
                    double frequency = resultSet.getDouble("the_frequency_of_the_data_bus");
                    int number_of_contacts = resultSet.getInt("number_of_contacts");
                    int TDP_power = resultSet.getInt("TDP_power");
                    String kernel_name = resultSet.getString("kernel_name");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.cpuSet.add(new CPU(id,name,connector_type,number_of_cores,internal_clock_rate,the_unlocked_multiplier,
                            frequency,number_of_contacts,TDP_power,kernel_name,guarantee,price));
                }

                return this.cpuSet;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.cpuSet;
    }

    public ArrayList<HDD> getHddSet(){
        TExecutor tExecutor = new TExecutor();

        if(!hddSet.isEmpty()){
            hddSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            this.hddSet = tExecutor.execQuery(connection,queryHDD,resultSet -> {
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("hdd_name");
                    int capacity = resultSet.getInt("capacity");
                    String interface_hdd = resultSet.getString("interface");
                    int the_volume_of_buffer = resultSet.getInt("the_volume_of_buffer");
                    int the_data_rate = resultSet.getInt("the_data_rate");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.hddSet.add(new HDD(id,name,capacity,interface_hdd,the_volume_of_buffer,the_data_rate,guarantee,
                            price));
                }
                return this.hddSet;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }

        return this.hddSet;
    }

    public ArrayList<MotherBoard> getMotherBoardSet(){
        TExecutor tExecutor = new TExecutor();

        if(!motherBoardSet.isEmpty()){
            motherBoardSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.motherBoardSet = tExecutor.execQuery(connection,queryMotherBoard,resultSet -> {
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("mother_board_name");
                    String connector_type = resultSet.getString("connector_type");
                    String chipset = resultSet.getString("chipset");
                    String physical_dimension = resultSet.getString("physical_dimensions");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");


                    this.motherBoardSet.add(new MotherBoard(id,name,connector_type,chipset,physical_dimension,guarantee,price));
                }
                return this.motherBoardSet;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.motherBoardSet;
    }

    public ArrayList<RAM> getRamSet(){
        TExecutor tExecutor = new TExecutor();

        if(!ramSet.isEmpty()){
            ramSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.ramSet = tExecutor.execQuery(connection,queryRam,resultSet ->{
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("ram_name");
                    int memory_size = resultSet.getInt("memory_size");
                    TypeRam typeRam = TypeRam.valueOf(resultSet.getString("type_of_memory").replaceAll(" ",""));
                    double supply_voltage = resultSet.getDouble("supply_voltage");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int effective_bandwidth = resultSet.getInt("effective_bandwidth");
                    int number_of_strips = resultSet.getInt("number_of_strips");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.ramSet.add(new RAM(id,name,memory_size,typeRam,supply_voltage,memory_frequency,effective_bandwidth,
                            number_of_strips,guarantee,price));
                }
                return this.ramSet;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.ramSet;
    }

    public ArrayList<Housing> getHousingSet(){
        TExecutor tExecutor = new TExecutor();

        if(!housingSet.isEmpty()){
            housingSet.clear();
        }

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            this.housingSet = tExecutor.execQuery(connection,queryHousing,resultSet -> {
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("housing_name");
                    String material = resultSet.getString("housing_material");
                    String type = resultSet.getString("type_of_housing");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    this.housingSet.add(new Housing(id,name,material,type,guarantee,price));
                }
                return this.housingSet;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.housingSet;
    }

    public ArrayList<CPU> searchCPU(String search){
        TExecutor tExecutor = new TExecutor();
        ArrayList<CPU> tempCPUArrayList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            tempCPUArrayList = tExecutor.execQuery(connection,searchCPU + "'" + search + "%'",resultSet -> {
                ArrayList<CPU> set = new ArrayList<CPU>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("cpu_name");
                    String connector_type = resultSet.getString("connector_type");
                    int number_of_cores = resultSet.getInt("number_of_cores");
                    int internal_clock_rate = resultSet.getInt("internal_clock_rate");
                    String the_unlocked_multiplier = resultSet.getString("the_unlocked_multiplier");
                    double frequency = resultSet.getDouble("the_frequency_of_the_data_bus");
                    int number_of_contacts = resultSet.getInt("number_of_contacts");
                    int TDP_power = resultSet.getInt("TDP_power");
                    String kernel_name = resultSet.getString("kernel_name");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    set.add(new CPU(id,name,connector_type,number_of_cores,internal_clock_rate,the_unlocked_multiplier,
                            frequency,number_of_contacts,TDP_power,kernel_name,guarantee,price));
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tempCPUArrayList;
    }

    public ArrayList<VideoCard> searchVideoCard(String search){
        TExecutor tExecutor = new TExecutor();
        ArrayList<VideoCard> tempVideoCardSet = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            tempVideoCardSet = tExecutor.execQuery(connection,searchVideoCard + "'" + search + "%'",resultSet -> {
                ArrayList<VideoCard> set = new ArrayList<VideoCard>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("video_name");
                    String the_graphics_chip = resultSet.getString("the_graphics_chip");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int core_clock = resultSet.getInt("core_clock");
                    double memory_size = resultSet.getDouble("memory_size");
                    int bit_memory_bus = resultSet.getInt("bit_memory_bus");
                    TypeOfMemory typeOfMemory = TypeOfMemory.valueOf(resultSet.getString("type_of_memory"));
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    set.add(new VideoCard(id,name,the_graphics_chip,memory_frequency,core_clock,memory_size,
                            bit_memory_bus,typeOfMemory,guarantee,price));
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tempVideoCardSet;
    }

    public ArrayList<RAM> searchRam(String search){
        TExecutor tExecutor = new TExecutor();
        ArrayList<RAM> searchSet = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            searchSet = tExecutor.execQuery(connection,searchRam + "'" + search + "%'",resultSet -> {
                ArrayList<RAM> set = new ArrayList<RAM>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("ram_name");
                    int memory_size = resultSet.getInt("memory_size");
                    TypeRam typeRam = TypeRam.valueOf(resultSet.getString("type_of_memory").replaceAll(" ",""));
                    double supply_voltage = resultSet.getDouble("supply_voltage");
                    int memory_frequency = resultSet.getInt("memory_frequency");
                    int effective_bandwidth = resultSet.getInt("effective_bandwidth");
                    int number_of_strips = resultSet.getInt("number_of_strips");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    set.add(new RAM(id,name,memory_size,typeRam,supply_voltage,memory_frequency,effective_bandwidth,
                            number_of_strips,guarantee,price));
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchSet;
    }

    public ArrayList<MotherBoard> searchMotherBoard(String search){
        TExecutor tExecutor = new TExecutor();
        ArrayList<MotherBoard> searchSet = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            searchSet = tExecutor.execQuery(connection,searchMotherBoard + "'" + search + "%'",resultSet -> {
                ArrayList<MotherBoard> set = new ArrayList<>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("mother_board_name");
                    String connector_type = resultSet.getString("connector_type");
                    String chipset = resultSet.getString("chipset");
                    String physical_dimension = resultSet.getString("physical_dimensions");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");
                    set.add(new MotherBoard(id,name,connector_type,chipset,physical_dimension,
                            guarantee,price));
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchSet;
    }

    public ArrayList<Housing> searchHousing(String search){
        TExecutor tExecutor = new TExecutor();
        ArrayList<Housing> searchHousingSet = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            searchHousingSet = tExecutor.execQuery(connection,searchHousing + "'" + search + "%'",resultSet -> {
                ArrayList<Housing> set = new ArrayList<Housing>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("housing_name");
                    String material = resultSet.getString("housing_material");
                    String type = resultSet.getString("type_of_housing");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    set.add(new Housing(id,name,material,type,guarantee,price));
                }
                return set;
            } );
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchHousingSet;
    }

    public ArrayList<HDD> searchHDD(String search){
        TExecutor tExecutor = new TExecutor();
        ArrayList<HDD> searchSet = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
            searchSet = tExecutor.execQuery(connection,searchHDD + "'" + search + "%'",resultSet -> {
                ArrayList<HDD> set = new ArrayList<HDD>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("hdd_name");
                    int capacity = resultSet.getInt("capacity_hdd");
                    String interface_hdd = resultSet.getString("interface");
                    int the_volume_of_buffer = resultSet.getInt("the_volume_of_buffer");
                    int the_data_rate = resultSet.getInt("the_data_rate");
                    int guarantee = resultSet.getInt("guarantee");
                    double price = resultSet.getDouble("price");

                    set.add(new HDD(id,name,capacity,interface_hdd,the_volume_of_buffer,the_data_rate,
                            guarantee,price));
                }
                return set;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
        return searchSet;
    }

    public void deleteCPU(String name){
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            TExecutor.execUpdate(connection,deleteFromCPU + "'" + name + "'");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteRam(String name){
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            TExecutor.execUpdate(connection,deleteFromRam + "'" + name + "'");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
