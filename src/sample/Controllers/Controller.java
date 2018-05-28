package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;

public class Controller {

    @FXML
    public void login() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/LoginPage.fxml"));
        Parent root=loader.load();
        Stage stage = new Stage();
        stage.setTitle("Login");
        LoginController.loginStage = stage;
        stage.setScene(new Scene(root,1280,1024));
        stage.show();
        LoginController loginController = loader.getController();
        Main.currentStage.close();
    }

    @FXML
    public void signup() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/signup.fxml"));
        Parent root=loader.load();
        Stage stage = new Stage();
        stage.setTitle("Sign up");
        SignupController.signupStage = stage;
        stage.setScene(new Scene(root,1280,1024));
        stage.show();
        SignupController signupController = loader.getController();
        Main.currentStage.close();
    }

}
