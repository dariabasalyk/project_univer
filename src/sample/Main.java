package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controllers.Controller;


public class Main extends Application {
    public static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/sample.fxml"));
        Parent root=loader.load();
        primaryStage.setTitle("Automatic System");
        currentStage = primaryStage;
        primaryStage.setScene(new Scene(root, 1280, 1024));
        primaryStage.setResizable(false);
        primaryStage.show();
        //Model model = new Model();
        //View view = new View();
        Controller controller=loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
