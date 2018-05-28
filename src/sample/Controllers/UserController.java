package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;
import sample.Model;
import sample.entity.*;
import sample.entity.enums.Computer;
import sample.entity.enums.TypeOfMemory;
import sample.entity.enums.TypeRam;
import sample.view.View;

import java.net.URL;
import java.util.ResourceBundle;


public class UserController implements Initializable {

    public static Stage userStage;

    @FXML
    private TableView<CPU> tableCPU;
    @FXML
    private TableView<VideoCard> tableVideoCard;
    @FXML
    private TableView<HDD> tableHDD;
    @FXML
    private TableView<RAM> tableRam;
    @FXML
    private TableView<Housing> tableHousing;
    @FXML
    private TableView<MotherBoard> tableMotherBoard;
    @FXML
    private TableView<Periphery> tablePeriphery;
    @FXML
    private TableView<Computer> tableComputer;


    /**
     * CPU Columns
     */
    @FXML
    private TableColumn<CPU,String> nameColumn;
    @FXML
    private TableColumn<CPU,String> connectorTypeColumn;
    @FXML
    private TableColumn<CPU,Integer> numberOfCoresColumn;
    @FXML
    private TableColumn<CPU,Integer> internalClockRateColumn;
    @FXML
    private TableColumn<CPU,String> unlockedMultiColumn;
    @FXML
    private TableColumn<CPU,Double> frequencyColumn;
    @FXML
    private TableColumn<CPU,Integer> numberOfContactsColumn;
    @FXML
    private TableColumn<CPU,Integer> TDPColumn;
    @FXML
    private TableColumn<CPU,String> kernelTypeColumn;
    @FXML
    private TableColumn<CPU,Integer> guaranteeColumn;
    @FXML
    private TableColumn<CPU,Double> priceColumn;

    /**
     * VideoCard Columns
     */
    @FXML
    private TableColumn<VideoCard,String> videoNameColumn;
    @FXML
    private TableColumn<VideoCard,String> graphicChipColumn;
    @FXML
    private TableColumn<VideoCard,Integer> memoryFrequencyColumn;
    @FXML
    private TableColumn<VideoCard,Integer> coreClockColumn;
    @FXML
    private TableColumn<VideoCard,Double> memorySizeColumn;
    @FXML
    private TableColumn<VideoCard,Integer> memoryBusColumn;
    @FXML
    private TableColumn<VideoCard,TypeOfMemory> memoryTypeColumn;
    @FXML
    private TableColumn<VideoCard,Integer> videoGuaranteeColumn;
    @FXML
    private TableColumn<VideoCard,Double> videoPrice;

    /**
     * HDD Columns
     */

    @FXML
    private TableColumn<HDD,String> hddNameColumn;
    @FXML
    private TableColumn<HDD,Integer> capacityColumn;
    @FXML
    private TableColumn<HDD,String> interfaceColumn;
    @FXML
    private TableColumn<HDD,Integer> bufferColumn;
    @FXML
    private TableColumn<HDD,Integer> dataRateColumn;
    @FXML
    private TableColumn<HDD,Integer> hddGuaranteeColumn;
    @FXML
    private TableColumn<HDD,Double> hddPriceColumn;

    /**
     * Ram Columns
     */
    @FXML
    private TableColumn<RAM,String> ramNameColumn;
    @FXML
    private TableColumn<RAM,Integer> ramMemorySizeColumn;
    @FXML
    private TableColumn<RAM,TypeRam> ramTypeOfMemoryColumn;
    @FXML
    private TableColumn<RAM,Double> ramVoltageColumn;
    @FXML
    private TableColumn<RAM,Integer> ramFrequencyColumn;
    @FXML
    private TableColumn<RAM,Integer> ramBandwidthColumn;
    @FXML
    private TableColumn<RAM,Integer> ramStripsColumn;
    @FXML
    private TableColumn<RAM,Integer> ramGuaranteeColumn;
    @FXML
    private TableColumn<RAM,Double> ramPriceColumn;

    /**
     * Housing Columns
     */
    @FXML
    private TableColumn<Housing,String> housingNameColumn;
    @FXML
    private TableColumn<Housing,String> housingMaterialColumn;
    @FXML
    private TableColumn<Housing,String> housingTypeColumn;
    @FXML
    private TableColumn<Housing,Integer> housingGuaranteeColumn;
    @FXML
    private TableColumn<Housing,Double> housingPriceColumn;

    /**
     * MotherBoard Column
     */
    @FXML
    private TableColumn<MotherBoard,String> mbNameColumn;
    @FXML
    private TableColumn<MotherBoard,String> mbConnectorTypeColumn;
    @FXML
    private TableColumn<MotherBoard,String> mbChipsetColumn;
    @FXML
    private TableColumn<MotherBoard,String> mbPhysicalDimensionColumn;
    @FXML
    private TableColumn<MotherBoard,Integer> mbGuaranteeColumn;
    @FXML
    private TableColumn<MotherBoard,Double> mbPriceColumn;

    /**
     * Periphery Column
     */
    @FXML
    private TableColumn<Periphery,String> peripheryNameColumn;
    @FXML
    private TableColumn<Periphery,String> peripheryDescriptionColumn;
    @FXML
    private TableColumn<Periphery,Integer> peripheryGuaranteeColumn;
    @FXML
    private TableColumn<Periphery,Double> peripheryPriceColumn;

    @FXML
    private TableColumn<Computer, String> computerNameColumn;

    @FXML
    private TableColumn<Computer, String> computerTypeColumn;

    @FXML
    private TableColumn<Computer, Integer> computerCpuColumn;

    @FXML
    private TableColumn<Computer, Integer> computerHddColumn;

    @FXML
    private TableColumn<Computer, Integer> computerHousingColumn;

    @FXML
    private TableColumn<Computer, Integer> computerMbColumn;

    @FXML
    private TableColumn<Computer, Integer> computerRamColumn;

    @FXML
    private TableColumn<Computer, Integer> computerVcColumn;

    @FXML
    private TableColumn<Computer, Integer> computerMouseColumn;

    @FXML
    private TableColumn<Computer, Integer> computerModemColumn;

    @FXML
    private TableColumn<Computer, Integer> computerPrinterColumn;

    @FXML
    private TableColumn<Computer, Integer> computerGuaranteeColumn;

    @FXML
    private TableColumn<Computer, Integer> computerPriceColumn;

    @FXML
    private Tab cpuTab;

    @FXML
    private Tab videoTab;

    @FXML
    private Tab hddTab;

    @FXML
    private Tab ramTab;

    @FXML
    private Tab housingTab;

    @FXML
    private Tab motherBoardTab;

    @FXML
    private Tab peripheryTab;

    @FXML
    private Tab computerTab;

    @FXML
    private Button addCpuToBasket;
    @FXML
    private Button addVideoCardToBasket;
    @FXML
    private Button addHDDToBasket;
    @FXML
    private Button addRamToBasket;
    @FXML
    private Button addHousingToBasket;
    @FXML
    private Button addMotherBoardToBasket;
    @FXML
    private Button addComputerToBasket;
    @FXML
    Button addPeripheryToBasket;

    private Model model;
    private View view;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        setTypeAndValueCpuColumn();
        setTypeAndValueVideoCardColumn();
        setTypeAndValueHDD();
        setTypeAndValueRam();
        setTypeAndValueHousing();
        setTypeAndValueMotherBoard();
        setTypeAndValuePeriphery();
        setTypeAndValueComputer();

        addCpuToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addVideoCardToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addHDDToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addRamToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addHousingToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addMotherBoardToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addPeripheryToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));
        addComputerToBasket.graphicProperty().setValue(new ImageView("/sample/view/ic_archive_black_18dp.png"));

    }

    private void setTypeAndValuePeriphery(){
        peripheryNameColumn.setCellValueFactory(new PropertyValueFactory<Periphery, String>("name"));
        peripheryDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Periphery, String>("description"));
        peripheryGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<Periphery, Integer>("guarantee"));
        peripheryPriceColumn.setCellValueFactory(new PropertyValueFactory<Periphery, Double>("price"));
    }

    private void setTypeAndValueComputer(){
        computerNameColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("name"));
        computerTypeColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("type"));
        computerCpuColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("cpu_id"));
        computerHddColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("hdd_id"));
        computerHousingColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("housing_id"));
        computerMbColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("mother_board_id"));
        computerRamColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("ram_id"));
        computerVcColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("video_card_id"));
        computerMouseColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("mouse_id"));
        computerModemColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("modem_id"));
        computerPrinterColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("printer_id"));
        computerGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("guarantee"));
        computerPriceColumn.setCellValueFactory(new PropertyValueFactory<Computer, Integer>("price"));
    }

    private void setTypeAndValueMotherBoard(){
        mbNameColumn.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("name"));
        mbConnectorTypeColumn.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("connector_type"));
        mbChipsetColumn.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("chipset"));
        mbPhysicalDimensionColumn.setCellValueFactory(new PropertyValueFactory<MotherBoard, String>("physical_dimension"));
        mbGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<MotherBoard, Integer>("guarantee"));
        mbPriceColumn.setCellValueFactory(new PropertyValueFactory<MotherBoard, Double>("price"));
    }

    private void setTypeAndValueHousing(){
        housingNameColumn.setCellValueFactory(new PropertyValueFactory<Housing, String>("name"));
        housingMaterialColumn.setCellValueFactory(new PropertyValueFactory<Housing, String>("housing_material"));
        housingTypeColumn.setCellValueFactory(new PropertyValueFactory<Housing, String>("type_of_housing"));
        housingGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<Housing, Integer>("guarantee"));
        housingPriceColumn.setCellValueFactory(new PropertyValueFactory<Housing, Double>("price"));
    }

    private void setTypeAndValueHDD(){
        hddNameColumn.setCellValueFactory(new PropertyValueFactory<HDD, String>("name"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("capacity"));
        interfaceColumn.setCellValueFactory(new PropertyValueFactory<HDD, String>("interface_hdd"));
        bufferColumn.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("the_volume_of_buffer"));
        dataRateColumn.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("the_data_rate"));
        hddGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<HDD, Integer>("guarantee"));
        hddPriceColumn.setCellValueFactory(new PropertyValueFactory<HDD, Double>("price"));
    }

    private void setTypeAndValueCpuColumn(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<CPU, String>("name"));
        connectorTypeColumn.setCellValueFactory(new PropertyValueFactory<CPU, String>("connector_type"));
        numberOfContactsColumn.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("number_of_contacts"));
        numberOfCoresColumn.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("number_of_cores"));
        internalClockRateColumn.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("internal_clock_rate"));
        unlockedMultiColumn.setCellValueFactory(new PropertyValueFactory<CPU, String>("the_unlocked_multiplier"));
        frequencyColumn.setCellValueFactory(new PropertyValueFactory<CPU, Double>("the_frequency_of_the_data_bus"));
        TDPColumn.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("TDP_power"));
        kernelTypeColumn.setCellValueFactory(new PropertyValueFactory<CPU, String>("kernel_type"));
        guaranteeColumn.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("guarantee"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void setTypeAndValueRam(){
        ramNameColumn.setCellValueFactory(new PropertyValueFactory<RAM, String>("name"));
        ramMemorySizeColumn.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("memory_size"));
        ramTypeOfMemoryColumn.setCellValueFactory(new PropertyValueFactory<RAM, TypeRam>("typeOfMemory"));
        ramVoltageColumn.setCellValueFactory(new PropertyValueFactory<RAM, Double>("supply_voltage"));
        ramFrequencyColumn.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("memory_frequency"));
        ramBandwidthColumn.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("effective_bandwidth"));
        ramStripsColumn.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("number_if_strips"));
        ramGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<RAM, Integer>("guarantee"));
        ramPriceColumn.setCellValueFactory(new PropertyValueFactory<RAM, Double>("price"));
    }

    private void setTypeAndValueVideoCardColumn(){
        videoNameColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, String>("name"));
        graphicChipColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, String>("the_graphics_chip"));
        memoryFrequencyColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("memory_frequency"));
        coreClockColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("core_clock"));
        memorySizeColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, Double>("memory_size"));
        memoryBusColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("bit_memory_bus"));
        memoryTypeColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, TypeOfMemory>("typeOfMemory"));
        videoGuaranteeColumn.setCellValueFactory(new PropertyValueFactory<VideoCard, Integer>("guarantee"));
        videoPrice.setCellValueFactory(new PropertyValueFactory<VideoCard, Double>("price"));
    }

    private ObservableList initDataPeriphery(){
        ObservableList<Periphery> obs = FXCollections.observableList(model.getPeripheries());
        return obs;
    }

    private ObservableList initDataComputer(){
        ObservableList<Computer> obs = FXCollections.observableList(model.getComputers());
        return obs;
    }

    private ObservableList initDataCpu(){
        ObservableList<CPU> obs = FXCollections.observableList(model.getCpuSet());
        return obs;
    }

    private ObservableList initDataVideoCard(){
        ObservableList<VideoCard> obs = FXCollections.observableList(model.getVideoCards());
        return obs;
    }

    private ObservableList initDataHDD(){
        ObservableList<HDD> obs = FXCollections.observableList(model.getHddSet());
        return obs;
    }

    private ObservableList initDataRam(){
        ObservableList<RAM> obs = FXCollections.observableList(model.getRamSet());
        return obs;
    }

    private ObservableList initDataHousing(){
        ObservableList<Housing> obs = FXCollections.observableList(model.getHousingSet());
        return obs;
    }

    private ObservableList initDataMotherBoard(){
        ObservableList<MotherBoard> obs = FXCollections.observableList(model.getMotherBoardSet());
        return obs;
    }

    public void setModelAndView(Model model, View view){
        this.model = model;
        this.view = view;

        computerTab.setOnSelectionChanged(event -> {
            tableComputer.setItems(initDataComputer());
        });

            peripheryTab.setOnSelectionChanged(event -> {
            tablePeriphery.setItems(initDataPeriphery());
        });

        tableCPU.setItems(initDataCpu());
        cpuTab.setOnSelectionChanged(event -> {
            tableCPU.setItems(initDataCpu());
        });

        videoTab.setOnSelectionChanged(event -> {
            tableVideoCard.setItems(initDataVideoCard());
        });

        hddTab.setOnSelectionChanged(event -> {
            tableHDD.setItems(initDataHDD());
        });

        ramTab.setOnSelectionChanged(event -> {
            tableRam.setItems(initDataRam());
        });

        housingTab.setOnSelectionChanged(event -> {
            tableHousing.setItems(initDataHousing());
        });

        motherBoardTab.setOnSelectionChanged(event -> {
            tableMotherBoard.setItems(initDataMotherBoard());
        });
    }

    @FXML
    private void addPeripheryToBasket(){
        Periphery periphery = (Periphery) tablePeriphery.getSelectionModel().getSelectedItem();
        if(periphery != null){
            BasketController.getElements().add(periphery);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addComputerToBasket(){
        Computer computer = (Computer) tableComputer.getSelectionModel().getSelectedItem();
        if(computer != null){
            BasketController.getElements().add(computer);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addCpuToBasket(){
        CPU cpu = (CPU) tableCPU.getSelectionModel().getSelectedItem();
        if(cpu != null) {
            sample.Controllers.BasketController.getElements().add(cpu);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addVideoCardToBasket(){
        VideoCard videoCard = (VideoCard) tableVideoCard.getSelectionModel().getSelectedItem();
        if(videoCard != null){
            sample.Controllers.BasketController.getElements().add(videoCard);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addHDDToBasket(){
        HDD hdd = (HDD) tableHDD.getSelectionModel().getSelectedItem();
        if(hdd != null){
            sample.Controllers.BasketController.getElements().add(hdd);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addHousingToBasket(){
        Housing housing = (Housing) tableHousing.getSelectionModel().getSelectedItem();
        if(housing != null){
            sample.Controllers.BasketController.getElements().add(housing);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addMotherBoardToBasket(){
        MotherBoard motherBoard = (MotherBoard) tableMotherBoard.getSelectionModel().getSelectedItem();
        if(motherBoard != null){
            sample.Controllers.BasketController.getElements().add(motherBoard);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void addRamToBasket(){
        RAM ram = (RAM) tableRam.getSelectionModel().getSelectedItem();
        if(ram != null){
            sample.Controllers.BasketController.getElements().add(ram);
        }else {
            view.createWarningAllert(View.NO_CHOOSE_ELEMENT);
        }
    }

    @FXML
    private void goToBasket() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/basket.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Корзина");
        sample.Controllers.BasketController.basketStage = stage;
        stage.setScene(new Scene(root,600,288));
        stage.setResizable(true);
        stage.show();
        sample.Controllers.BasketController controller=loader.getController();
        UserController.userStage.close();

        sample.Controllers.BasketController.basketStage.setOnCloseRequest(event -> {
            sample.Controllers.BasketController.basketStage.close();
            UserController.userStage.show();
        });

        stage.getIcons().add(new Image("/sample/view/ic_archive_black_18dp.png"));
    }

}
