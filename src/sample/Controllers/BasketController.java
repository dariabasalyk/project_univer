package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Main;
import sample.view.View;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;


public class BasketController implements Initializable {
    public static Stage basketStage;
    private double totalCoast=0;
    @FXML
    TableView<Object> tableBasket;
    @FXML
    TableColumn<Object,String> basketName;
    @FXML
    TableColumn<Object,String> basketPrice;
    @FXML
    TextField totalPrice;
    @FXML
    Button clearBasket;
    @FXML
    private Button createCheck;

    private static ObservableList<Object> elements = FXCollections.observableArrayList();

    public static ObservableList<Object> getElements() {
        return elements;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalPrice.setEditable(false);
        basketName.setCellValueFactory(new PropertyValueFactory<>("name"));
        basketPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableBasket.setItems(elements);
        if(!elements.isEmpty()){
            for(Object object:elements){
                try {
                    Field field = object.getClass().getDeclaredField("price");
                    field.setAccessible(true);
                    totalCoast += field.getDouble(object);
                    totalPrice.setText("" + totalCoast);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }else {
            clearBasket.setDisable(true);
        }
    }

    @FXML
    private void clearBasket(){
        elements.clear();
        tableBasket.getItems().clear();
        totalPrice.clear();
        clearBasket.setDisable(true);

    }

    @FXML
    private void createCheck(){
        String fileName = LoginController.user.getFname()+LoginController.user.getLname()+" "+(int)(Math.random()*1000);
        if(!elements.isEmpty()){
            try(FileWriter writer = new FileWriter("C:\\Users\\user\\Desktop\\" + fileName + ".txt",false)){
                StringBuilder text = new StringBuilder();
                writer.append(LoginController.user.toString());
                writer.append("\r\n");
                for(Object object:elements){
                    try{
                        writer.append((String)object.getClass().getMethod("toString").invoke(object));
                    }catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    writer.append("\r\n" + "\r\n");
                }
                writer.append("______________________________________________________________________________");
                writer.append("\r\n" + "Стоимость заказа: " + totalCoast + "\r\n");
                writer.write(text.toString());
                writer.flush();
                View.createSuccesCheck(View.successPay + fileName);
            }catch (Exception e){e.printStackTrace();}
        }else {
            View.createSuccesCheck(View.badPay);
        }
    }
}
