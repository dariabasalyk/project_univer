package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Button;


public class AdminPageController {
    static Stage adminPage;


    @FXML
    private javafx.scene.control.Button delete;
    @FXML
    private javafx.scene.control.Button update;
    @FXML
    private javafx.scene.control.Button insert;
    @FXML
    private javafx.scene.control.Button exit;

    @FXML
    public void exitAction(){
        adminPage.close();
    }

    @FXML
    public void deleteAction() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/deletePage.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Видалити товар");
        DeletePageController.deletePage = stage;
        stage.setScene(new Scene(root, 1280, 1024));
        stage.show();
        DeletePageController deletePageController = loader.getController();
        adminPage.close();
    }


}
