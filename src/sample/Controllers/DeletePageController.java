package sample.Controllers;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.entity.*;
import sample.entity.enums.Computer;
import sample.entity.enums.TypeOfMemory;
import sample.entity.enums.TypeRam;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.sql.*;


public class DeletePageController {
    static Stage deletePage;
    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String PASSWORD = "root";
    private final String USERNAME = "root";

    @FXML
    private ChoiceBox updatePeriphery;

    @FXML
    private TextField updatePeripheryField;

    @FXML
    private TextField periphery_new_value;

    @FXML
    private TextField vc_new_value;

    @FXML
    private TextField updateVCField;

    @FXML
    private ChoiceBox updateVc;

    @FXML
    private TextField ram_new_value;

    @FXML
    private TextField updateRamField;

    @FXML
    private ChoiceBox updateRam;

    @FXML
    private TextField mb_new_value;

    @FXML
    private TextField updateMBField;

    @FXML
    private ChoiceBox updateMB;

    @FXML
    private TextField housing_new_value;

    @FXML
    private TextField updateHousingField;

    @FXML
    private ChoiceBox updateHousing;

    @FXML
    private TextField hdd_new_value;

    @FXML
    private TextField updateHddField;

    @FXML
    private ChoiceBox updateHdd;

    @FXML
    private TextField cpu_new_value;

    @FXML
    private TextField updateCpuField;

    @FXML
    private ChoiceBox updateCpu;

    @FXML
    private TextField add_vc_name;

    @FXML
    private TextField add_vc_graphics_chip;

    @FXML
    private TextField add_vc_frequency;

    @FXML
    private TextField add_vc_core_clock;

    @FXML
    private TextField add_vc_memory_size;

    @FXML
    private TextField add_vc_bit_memory_bus;

    @FXML
    private TextField add_vc_type_of_memory;

    @FXML
    private TextField add_vc_guarantee;

    @FXML
    private TextField add_vc_price;

    @FXML
    private TextField add_ram_name;

    @FXML
    private TextField add_ram_memory_size;

    @FXML
    private TextField add_ram_type_of_memory;

    @FXML
    private TextField add_ram_voltage;

    @FXML
    private TextField add_ram_frequency;

    @FXML
    private TextField add_ram_bandwidth;

    @FXML
    private TextField add_ram_number_of_strips;

    @FXML
    private TextField add_ram_guarantee;

    @FXML
    private TextField add_ram_price;

    @FXML
    private TextField add_mb_name;

    @FXML
    private TextField add_mb_connector;

    @FXML
    private TextField add_mb_chipset;

    @FXML
    private TextField add_mb_dimensions;

    @FXML
    private TextField add_mb_guarantee;

    @FXML
    private TextField add_mb_price;

    @FXML
    private TextField add_housing_name;

    @FXML
    private TextField add_housing_material;

    @FXML
    private TextField add_housing_type;

    @FXML
    private TextField add_housing_guarantee;

    @FXML
    private TextField add_housing_price;

    @FXML
    private TextField add_hdd_name;

    @FXML
    private TextField add_hdd_capacity;

    @FXML
    private TextField add_hdd_interface;

    @FXML
    private TextField add_hdd_volume;

    @FXML
    private TextField add_hdd_data_rate;

    @FXML
    private TextField add_hdd_guarantee;

    @FXML
    private TextField add_hdd_price;

    @FXML
    private TextField add_cpu_name;

    @FXML
    private TextField add_cpu_connector_type;

    @FXML
    private TextField add_cpu_numbers_of_cores;

    @FXML
    private TextField add_cpu_iternal_clock_rate;

    @FXML
    private TextField add_cpu_the_unlocked_multiplier;

    @FXML
    private TextField add_cpu_frequency;

    @FXML
    private TextField add_cpu_number_of_contacts;

    @FXML
    private TextField add_cpu_TDP;

    @FXML
    private TextField add_cpu_kernel;

    @FXML
    private TextField add_cpu_guarantee;

    @FXML
    private TextField add_cpu_price;

    @FXML
    private TableColumn<VideoCard,Integer> vc_id;

    @FXML
    private TableColumn<VideoCard,String> vc_name;

    @FXML
    private TableColumn<VideoCard,String> vc_graphics_chip;

    @FXML
    private TableColumn<VideoCard,Integer> vc_memory_frequency;

    @FXML
    private TableColumn<VideoCard,Integer> vc_core_clock;

    @FXML
    private TableColumn<VideoCard,Double> vc_memory_size;

    @FXML
    private TableColumn<VideoCard,Integer> vc_bit_memory_bus;

    @FXML
    private TableColumn<VideoCard,TypeOfMemory> vc_type_of_memory;

    @FXML
    private TableColumn<VideoCard,Integer> vc_guarantee;

    @FXML
    private TableColumn<VideoCard,Double> vc_price;

    @FXML
    private TableView<VideoCard> videoCardTableView;

    @FXML
    private TextField delete_vcID;

    @FXML
    private TableColumn<RAM,Integer> ram_id;

    @FXML
    private TableColumn<RAM,String> ram_name;

    @FXML
    private TableColumn<RAM,Integer> ram_memory_size;

    @FXML
    private TableColumn<RAM,TypeOfMemory> ram_type_of_memory;

    @FXML
    private TableColumn<RAM,Double> ram_supply_voltage;

    @FXML
    private TableColumn<RAM,Integer> ram_memory_frequency;

    @FXML
    private TableColumn<RAM,Integer> ram_bandwidth;

    @FXML
    private TableColumn<RAM,Integer> ram_number_of_strips;

    @FXML
    private TableColumn<RAM,Integer> ram_guarantee;

    @FXML
    private TableColumn<RAM,Double> ram_price;

    @FXML
    private TableView<RAM> ramTableView;

    @FXML
    private TextField delete_ramID;

    @FXML
    private TableColumn<MotherBoard,Integer> mb_id;

    @FXML
    private  TableColumn<MotherBoard,String> mb_name;

    @FXML
    private TableColumn<MotherBoard,String> mb_connector;

    @FXML
    private TableColumn<MotherBoard,String> mb_chipset;

    @FXML
    private TableColumn<MotherBoard,String> mb_dimensions;

    @FXML
    private TableColumn<MotherBoard,Integer> mb_guarantee;

    @FXML
    private TableColumn<MotherBoard,Double> mb_price;

    @FXML
    private TableView<MotherBoard> motherBoardTableView;

    @FXML
    private TextField mb_deleteID;

    @FXML
    private TableColumn<Housing,Integer> housing_id;

    @FXML
    private TableColumn<Housing,String> housing_name;

    @FXML
    private TableColumn<Housing,String> housing_material;

    @FXML
    private TableColumn<Housing,String> type_of_housing;

    @FXML
    private TableColumn<Housing,Integer> housing_guarantee;

    @FXML
    private TableColumn<Housing, Double> housing_price;

    @FXML
    private TableView<Housing> housingTableView;

    @FXML
    private TextField delete_housingID;

    @FXML
    private TableColumn<HDD,Integer> hdd_id;

    @FXML
    private TableColumn<HDD,String> hdd_name;

    @FXML
    private TableColumn<HDD,Integer> hdd_capacity;

    @FXML
    private TableColumn<HDD,String> hdd_interface;

    @FXML
    private TableColumn<HDD,Integer> hdd_volume;

    @FXML
    private TableColumn<HDD,Integer> hdd_data_rate;

    @FXML
    private TableColumn<HDD,Integer> hdd_guarantee;

    @FXML
    private TableColumn<HDD,Double> hdd_price;

    @FXML
    private TableView<HDD> hddTableView;

    @FXML
    private TextField hdd_deleteID;

    @FXML
    private TableColumn<CPU,Integer> id;

    @FXML
    private TableColumn<CPU,String> name;

    @FXML
    private TableColumn<CPU,String > connector;

    @FXML
    private TableColumn<CPU, Integer> number_of_cores;

    @FXML
    private TableColumn<CPU, Integer> iteranal_clock_rate;

    @FXML
    private TableColumn<CPU, String> the_unlocked_multiplier;

    @FXML
    private TableColumn<CPU,Double> freaquncy;

    @FXML
    private TableColumn<CPU,Integer> number_of_contacts;

    @FXML
    private TableColumn<CPU,Integer> TDP;

    @FXML
    private TableColumn<CPU,String> kernel;

    @FXML
    private TableColumn<CPU,Integer> guarantee;

    @FXML
    private TableColumn<CPU,Double> price;

    @FXML
    private TableView<CPU> cpuTableView;

    @FXML
    private TextField textField;

    @FXML
    private TableColumn<Computer, Integer> computer_id;

    @FXML
    private TableColumn<Computer, String> computer_name;

    @FXML
    private TableColumn<Computer, String> computer_type;

    @FXML
    private TableColumn<Computer, Integer> computer_cpu_id;

    @FXML
    private TableColumn<Computer, Integer> computer_hdd_id;

    @FXML
    private TableColumn<Computer, Integer> computer_housing_id;

    @FXML
    private TableColumn<Computer, Integer> computer_mother_board_id;

    @FXML
    private TableColumn<Computer, Integer> computer_ram_id;

    @FXML
    private TableColumn<Computer, Integer> computer_video_card_id;

    @FXML
    private TableColumn<Computer, Integer> computer_mouse_id;

    @FXML
    private TableColumn<Computer, Integer> modem_id;

    @FXML
    private TableColumn<Computer, Integer> printer_id;

    @FXML
    private TableColumn<Computer, Integer> computer_guarantee;

    @FXML
    private TableColumn<Computer, Integer> computer_price;

    @FXML
    private TableView<Computer> computerTableView;

    @FXML
    private TextField computer_deleteID;

    @FXML
    private TextField add_computer_name;

    @FXML
    private TextField add_computer_type;

    @FXML
    private TextField add_computer_cpu_id;

    @FXML
    private TextField add_computer_hdd_id;

    @FXML
    private TextField add_computer_housing_id;

    @FXML
    private TextField add_computer_mb_id;

    @FXML
    private TextField add_computer_ram_id;

    @FXML
    private TextField add_computer_vc_id;

    @FXML
    private TextField add_computer_mouse_id;

    @FXML
    private TextField add_computer_modem_id;

    @FXML
    private TextField add_computer_printer_id;

    @FXML
    private TextField add_computer_guarantee;

    @FXML
    private TextField add_computer_price;

    @FXML
    private ChoiceBox updateComputer;

    @FXML
    private TextField updateCoputerField;

    @FXML
    private TextField computerNewValue;

    @FXML
    private TableColumn<Periphery,Integer> periphery_id;

    @FXML
    private TableColumn<Periphery,String> periphery_name;

    @FXML
    private TableColumn<Periphery,String> periphery_description;

    @FXML
    private TableColumn<Periphery,Integer> periphery_guarantee;

    @FXML
    private TableColumn<Periphery,Double> periphery_price;

    @FXML
    private TableView<Periphery> peripheryTableView;

    @FXML
    private TextField deletePeriphery;

    @FXML
    private TextField add_periphery_name;

    @FXML
    private TextField add_periphery_desription;

    @FXML
    private TextField add_periphery_guarantee;

    @FXML
    private TextField add_periphery_price;

    @FXML
    public void updateCPU() throws Exception{
        String sql = String.format("update cpu set %s = %s where id = %s;",updateCpu.getValue(),cpu_new_value.getText(),updateCpuField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showCpu();
    }

    @FXML
    public void updateHDD() throws Exception{
        String sql = String.format("update hdd set %s = %s where id = %s;",updateHdd.getValue(),hdd_new_value.getText(),updateHddField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showHdd();
    }

    @FXML
    public void updateHousing() throws Exception{
        String sql = String.format("update housing set %s = %s where id = %s;",updateHousing.getValue(),housing_new_value.getText(),updateHousingField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showHousing();
    }

    @FXML
    public void updateMb() throws Exception{
        String sql = String.format("update mother_board set %s = %s where id = %s;",updateMB.getValue(),mb_new_value.getText(),updateMBField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showMB();
    }

    @FXML
    public void updateRAM() throws Exception{
        String sql = String.format("update ram set %s = %s where id = %s;",updateRam.getValue(),ram_new_value.getText(),updateRamField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showRam();
    }

    @FXML
    public void updateVC() throws Exception{
        String sql = String.format("update video_card set %s = %s where id = %s;",updateVc.getValue(),vc_new_value.getText(),updateVCField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showVC();
    }

    @FXML
    public void updatePeriphery() throws Exception{
        String sql = String.format("update periphery set %s = %s where id = %s;",updatePeriphery.getValue(),periphery_new_value.getText(),updatePeripheryField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showPeriphery();
    }

    @FXML
    public void updateComputer() throws Exception{
        String sql = String.format("update computer set %s = %s where id = %s;",updateComputer.getValue(),computerNewValue.getText(),updateCoputerField.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showComputer();
    }

    @FXML
    public void deleteVC() throws Exception{
        String sql = String.format("delete from video_card where id = %s;",delete_vcID.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showVC();
    }

    @FXML
    public void deleteRam() throws Exception{
        String sql = String.format("delete from ram where id = %s;",delete_ramID.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showRam();
    }


    @FXML
    public void deleteMB() throws Exception{
        String sql = String.format("delete from mother_board where id = %s;",mb_deleteID.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showMB();
    }

    @FXML
    public void deleteCpu() throws Exception{
        String sql = String.format("delete from cpu where id = %s;",textField.getText());
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            showCpu();
    }

    @FXML
    void deleteHdd() throws Exception{
        String sql = String.format("delete from hdd where id = %s;", hdd_deleteID.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showHdd();
    }

    @FXML
    void deleteHousing() throws Exception{
        String sql = String.format("delete from housing where id = %s;", delete_housingID.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showHousing();
    }

    @FXML
    public void deletePeriphery() throws Exception{
        String sql = String.format("delete from periphery where id = %s;",deletePeriphery.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showPeriphery();
    }

    @FXML
    public void deleteComputer() throws Exception{
        String sql = String.format("delete from computer where id = %s;",computer_deleteID.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        showComputer();
    }

    @FXML
    public void back(){
        deletePage.close();
        AdminPageController.adminPage.show();
    }

    @FXML
    public void showVC(){
        ObservableList<VideoCard> videoCardObservableList = FXCollections.observableArrayList();
        initVC(videoCardObservableList);
        vc_id.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("id"));
        vc_name.setCellValueFactory(new PropertyValueFactory<VideoCard, String>("name"));
        vc_graphics_chip.setCellValueFactory(new PropertyValueFactory<VideoCard, String>("the_graphics_chip"));
        vc_memory_frequency.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("memory_frequency"));
        vc_core_clock.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("core_clock"));
        vc_memory_size.setCellValueFactory(new PropertyValueFactory<VideoCard, Double>("memory_size"));
        vc_bit_memory_bus.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("bit_memory_bus"));
        vc_type_of_memory.setCellValueFactory(new PropertyValueFactory<VideoCard, TypeOfMemory>("typeOfMemory"));
        vc_guarantee.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("guarantee"));
        vc_price.setCellValueFactory(new PropertyValueFactory<VideoCard, Double>("price"));

        videoCardTableView.setItems(videoCardObservableList);
        updateVc.setItems(FXCollections.observableArrayList("video_name","the_graphics_chip","memory_frequency","core_clock","memory_size","bit_memory_bus","type_of_memory","guarantee","price"));
    }

    @FXML
    public void showRam(){
        ObservableList<RAM> ramObservableList = FXCollections.observableArrayList();
        initRam(ramObservableList);
        ram_id.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("id"));
        ram_name.setCellValueFactory(new PropertyValueFactory<RAM, String>("name"));
        ram_memory_size.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("memory_size"));
        ram_type_of_memory.setCellValueFactory(new PropertyValueFactory<RAM, TypeOfMemory>("typeOfMemory"));
        ram_supply_voltage.setCellValueFactory(new PropertyValueFactory<RAM, Double>("supply_voltage"));
        ram_memory_frequency.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("memory_frequency"));
        ram_bandwidth.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("effective_bandwidth"));
        ram_number_of_strips.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("number_if_strips"));
        ram_guarantee.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("guarantee"));
        ram_price.setCellValueFactory(new PropertyValueFactory<RAM, Double>("price"));

        ramTableView.setItems(ramObservableList);
        updateRam.setItems(FXCollections.observableArrayList("ram_name","memory_size","type_of_memory","supply_voltage","memory_frequency","effective_bandwidth","number_of_strips","guarantee","price"));
    }

    @FXML
    public void showMB(){
        ObservableList<MotherBoard> motherBoardObservableList = FXCollections.observableArrayList();
        initMB(motherBoardObservableList);
        mb_id.setCellValueFactory(new PropertyValueFactory<MotherBoard, Integer>("id"));
        mb_name.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("name"));
        mb_connector.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("connector_type"));
        mb_chipset.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("chipset"));
        mb_dimensions.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("physical_dimension"));
        mb_guarantee.setCellValueFactory(new PropertyValueFactory<MotherBoard, Integer>("guarantee"));
        mb_price.setCellValueFactory(new PropertyValueFactory<MotherBoard, Double>("price"));

        motherBoardTableView.setItems(motherBoardObservableList);
        updateMB.setItems(FXCollections.observableArrayList("mother_board_name","connector_type","chipset","physical_dimensions","guarantee","price"));
    }

    @FXML
    public void  showHousing(){
        ObservableList<Housing> housingObservableList = FXCollections.observableArrayList();
        initHousing(housingObservableList);
        housing_id.setCellValueFactory(new PropertyValueFactory<Housing, Integer>("id"));
        housing_name.setCellValueFactory(new PropertyValueFactory<Housing, String>("name"));
        housing_material.setCellValueFactory(new PropertyValueFactory<Housing, String>("housing_material"));
        type_of_housing.setCellValueFactory(new PropertyValueFactory<Housing, String>("type_of_housing"));
        housing_guarantee.setCellValueFactory(new PropertyValueFactory<Housing, Integer>("guarantee"));
        housing_price.setCellValueFactory(new PropertyValueFactory<Housing, Double>("price"));

        housingTableView.setItems(housingObservableList);
        updateHousing.setItems(FXCollections.observableArrayList("housing_name","housing_material","type_of_housing","guarantee","price"));
    }

    @FXML
    public void showHdd(){
        ObservableList<HDD> hddObservableList = FXCollections.observableArrayList();
        initHDD(hddObservableList);
        hdd_id.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("id"));
        hdd_name.setCellValueFactory(new PropertyValueFactory<HDD, String>("name"));
        hdd_capacity.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("capacity"));
        hdd_interface.setCellValueFactory(new PropertyValueFactory<HDD, String>("interface_hdd"));
        hdd_volume.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("the_volume_of_buffer"));
        hdd_data_rate.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("the_data_rate"));
        hdd_guarantee.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("guarantee"));
        hdd_price.setCellValueFactory(new PropertyValueFactory<HDD, Double>("price"));

        hddTableView.setItems(hddObservableList);
        updateHdd.setItems(FXCollections.observableArrayList("hdd_name","capacity_hdd","interface","the_volume_of_buffer","the_data_rate","guarantee","price"));
    }

    @FXML
    public void showCpu(){
        ObservableList<CPU> cpuObservableList = FXCollections.observableArrayList();
        init(cpuObservableList);
        id.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<CPU, String>("name"));
        connector.setCellValueFactory(new PropertyValueFactory<CPU, String>("connector_type"));
        number_of_cores.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("number_of_cores"));
        iteranal_clock_rate.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("internal_clock_rate"));
        the_unlocked_multiplier.setCellValueFactory(new PropertyValueFactory<CPU, String>("the_unlocked_multiplier"));
        freaquncy.setCellValueFactory(new PropertyValueFactory<CPU, Double>("the_frequency_of_the_data_bus"));
        number_of_contacts.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("number_of_contacts"));
        TDP.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("TDP_power"));
        kernel.setCellValueFactory(new PropertyValueFactory<CPU, String>("kernel_type"));
        guarantee.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("guarantee"));
        price.setCellValueFactory(new PropertyValueFactory<CPU, Double>("price"));

        cpuTableView.setItems(cpuObservableList);
        updateCpu.setItems(FXCollections.observableArrayList("cpu_name","connector_type","number_of_cores","internal_clock_rate","the_unlocked_multiplier","the_frequency_of_the_data_bus","number_of_contacts","TDP_power","kernel_name","guarantee","price"));
    }

    @FXML
    public void showPeriphery(){
        ObservableList<Periphery> peripheryObservableList = FXCollections.observableArrayList();
        initPeriphery(peripheryObservableList);
        periphery_id.setCellValueFactory(new PropertyValueFactory<Periphery, Integer>("id"));
        periphery_name.setCellValueFactory(new PropertyValueFactory<Periphery, String>("name"));
        periphery_description.setCellValueFactory(new PropertyValueFactory<Periphery, String>("description"));
        periphery_guarantee.setCellValueFactory(new PropertyValueFactory<Periphery, Integer>("guarantee"));
        periphery_price.setCellValueFactory(new PropertyValueFactory<Periphery, Double>("price"));

        peripheryTableView.setItems(peripheryObservableList);
        updatePeriphery.setItems(FXCollections.observableArrayList("periphery_name","description","guarantee","price"));
    }

    @FXML
    public void showComputer(){
        ObservableList<Computer> computerObservableList = FXCollections.observableArrayList();
        initComputer(computerObservableList);
        computer_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("id"));
        computer_name.setCellValueFactory(new PropertyValueFactory<Computer, String>("name"));
        computer_type.setCellValueFactory(new PropertyValueFactory<Computer, String>("type"));
        computer_cpu_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("cpu_id"));
        computer_hdd_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("hdd_id"));
        computer_housing_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("housing_id"));
        computer_mother_board_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("mother_board_id"));
        computer_ram_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("ram_id"));
        computer_video_card_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("video_card_id"));
        computer_mouse_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("mouse_id"));
        modem_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("modem_id"));
        printer_id.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("printer_id"));
        computer_guarantee.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("guarantee"));
        computer_price.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("price"));

        computerTableView.setItems(computerObservableList);
        updateComputer.setItems(FXCollections.observableArrayList("computer_name","computer_type","cpu_id","hdd_id", "housing_id", "mother_board_id", "ram_id", "video_card_id", "computer_mouse_id", "modem_id", "printer_id", "guarantee", "price"));
    }

    private void initVC(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  video_card");
            while (resultSet.next()) {
               observableList.add(new VideoCard(resultSet.getInt("id"),resultSet.getString("video_card_name"),resultSet.getString("the_graphics_chip"),resultSet.getInt("memory_frequency"), resultSet.getInt("core_clock"),resultSet.getDouble("memory_size"),resultSet.getInt("bit_memory_busl"),TypeOfMemory.valueOf(resultSet.getString("type_of_memory")),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    private void initRam(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  ram");
            while (resultSet.next()) {
                observableList.add(new RAM(resultSet.getInt("id"),resultSet.getString("ram_name"),resultSet.getInt("memory_size"), TypeRam.valueOf(resultSet.getString("type_of_memory")),resultSet.getDouble("supply_voltage"),resultSet.getInt("memory_frequency"),resultSet.getInt("effective_bandwidth"),resultSet.getInt("number_of_strips"),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    private void initMB(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  mother_board");
            while (resultSet.next()) {
                observableList.add(new MotherBoard(resultSet.getInt("id"),resultSet.getString("mother_board_name"),resultSet.getString("connector_type"),resultSet.getString("chipset"),resultSet.getString("physical_dimensions"),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    private void initHousing(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  housing");
            while (resultSet.next()) {
                observableList.add(new Housing(resultSet.getInt("id"),resultSet.getString("housing_name"),resultSet.getString("housing_material"),resultSet.getString("type_of_housing"),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    private void initHDD(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  hdd");
            while (resultSet.next()) {
                observableList.add(new HDD(resultSet.getInt("id"),resultSet.getString("hdd_name"),resultSet.getInt("capacity"),resultSet.getString("interface"),resultSet.getInt("the_volume_of_buffer"),resultSet.getInt("the_data_rate"),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    private void initPeriphery(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  periphery");
            while (resultSet.next()) {
                observableList.add(new Periphery(resultSet.getInt("id"),resultSet.getString("periphery_name"),resultSet.getString("description"),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    private void initComputer(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  computer");
            while (resultSet.next()) {
                observableList.add(new Computer(resultSet.getInt("id"),resultSet.getString("computer_name"),resultSet.getString("computer_type"), resultSet.getInt("cpu_id"), resultSet.getInt("hdd_id"), resultSet.getInt("housing_id"), resultSet.getInt("mother_board_id"), resultSet.getInt("ram_id"), resultSet.getInt("video_card_id"), resultSet.getInt("computer_mouse_id"), resultSet.getInt("modem_id"), resultSet.getInt("printer_id"), resultSet.getInt("guarantee"), resultSet.getInt("price")));
            }
        }catch (SQLException e){

        }
    }

    private void init(ObservableList observableList){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  cpu");
            while (resultSet.next()) {
                observableList.add(new CPU(resultSet.getInt("id"),resultSet.getString("cpu_name"),resultSet.getString("connector_type"),resultSet.getInt("number_of_cores"),resultSet.getInt("internal_clock_rate"),resultSet.getString("the_unlocked_multiplier"),resultSet.getDouble("the_frequency_of_the_data_bus"),resultSet.getInt("number_of_contacts"),resultSet.getInt("TDP_power"),resultSet.getString("kernel_name"),resultSet.getInt("guarantee"),resultSet.getDouble("price")));
            }
        }catch (SQLException e){

        }
    }

    @FXML
    public void addCpu() throws Exception{
        String sql = String.format("insert into cpu values (null,'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",add_cpu_name.getText(),add_cpu_connector_type.getText(),add_cpu_numbers_of_cores.getText(),add_cpu_iternal_clock_rate.getText(),add_cpu_the_unlocked_multiplier.getText(),add_cpu_frequency.getText(),add_cpu_number_of_contacts.getText(),add_cpu_TDP.getText(),add_cpu_kernel.getText(),add_cpu_guarantee.getText(),add_cpu_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showCpu();
    }

    @FXML
    public void addPeriphery() throws Exception{
        String sql = String.format("insert into periphery values (null,'%s','%s','%s','%s');",add_periphery_name.getText(),add_periphery_desription.getText(),add_periphery_guarantee.getText(),add_periphery_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showPeriphery();
    }

    @FXML
    public void addComputer() throws Exception{
        String sql = String.format("insert into computer values (null,'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",add_computer_name.getText(), add_computer_type.getText(), add_computer_cpu_id.getText(), add_computer_hdd_id.getText(), add_computer_housing_id.getText(), add_computer_mb_id.getText(), add_computer_ram_id.getText(), add_computer_vc_id.getText(), add_computer_mouse_id.getText(), add_computer_modem_id.getText(), add_computer_printer_id.getText(), add_computer_guarantee.getText(), add_computer_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showComputer();
    }

    @FXML
    public void addHdd() throws Exception{
        String sql = String.format("insert into hdd values (null,'%s','%s','%s','%s','%s','%s','%s');",add_hdd_name.getText(),add_hdd_capacity.getText(),add_hdd_interface.getText(),add_hdd_volume.getText(),add_hdd_data_rate.getText(),add_hdd_guarantee.getText(),add_hdd_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showHdd();
    }

    @FXML
    public void addHousing() throws Exception{
        String sql = String.format("insert into housing values (null,'%s','%s','%s','%s','%s');",add_housing_name.getText(),add_housing_material.getText(),add_housing_type.getText(),add_housing_guarantee.getText(),add_housing_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showHousing();
    }

    @FXML
    public void addMB() throws Exception{
        String sql = String.format("insert into mother_board values (null,'%s','%s','%s','%s','%s','%s');",add_mb_name.getText(),add_mb_connector.getText(),add_mb_chipset.getText(),add_mb_dimensions.getText(),add_mb_guarantee.getText(),add_mb_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showMB();
    }

    @FXML
    public void addRam() throws Exception{
        String sql = String.format("insert into ram values (null,'%s','%s','%s','%s','%s','%s','%s','%s','%s');",add_ram_name.getText(),add_ram_memory_size.getText(),add_ram_type_of_memory.getText(),add_ram_voltage.getText(),add_ram_frequency.getText(),add_ram_bandwidth.getText(),add_ram_number_of_strips.getText(),add_ram_guarantee.getText(),add_ram_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showRam();
    }

    @FXML
    public void addVC() throws Exception{
        String sql = String.format("insert into video_card values (null,'%s','%s','%s','%s','%s','%s','%s','%s','%s');",add_vc_name.getText(),add_vc_graphics_chip.getText(),add_vc_frequency.getText(),add_vc_core_clock.getText(),add_vc_memory_size.getText(),add_vc_bit_memory_bus.getText(),add_vc_type_of_memory.getText(),add_vc_guarantee.getText(),add_vc_price.getText());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        showVC();
    }
}
