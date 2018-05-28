package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Main;
import sample.Model;
import sample.entity.User;
import sample.view.View;

import java.sql.*;


public class LoginController {
    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String PASSWORD = "root";
    private final String USERNAME = "root";
    @FXML
    public javafx.scene.control.Label errorLabel;

    @FXML
    public TextField login;

    @FXML
    public TextField password;

    static Stage loginStage;
    static User user;

    @FXML
    public void backToFirstPage(){
        loginStage.close();
        Main.currentStage.show();
    }

    @FXML
    public void login() throws Exception{
        boolean flag = false;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  admin");
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login.getText()) && resultSet.getString("pass").equals(password.getText())) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../fxml/deletePage.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Login");
                    DeletePageController.deletePage = stage;
                    stage.setScene(new Scene(root, 1280, 1024));
                    stage.show();
                    DeletePageController deletePageController = loader.getController();
                    loginStage.close();
                    flag = true;
                }
            }
        }catch (SQLException e){
            System.out.print(e);
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login.getText()) && resultSet.getString("pass").equals(password.getText())) {
                    user = new User(resultSet.getString("fname"),
                            resultSet.getString("lname"),
                            resultSet.getString("email"),
                            resultSet.getString("phonenumber"));
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/view/user.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("User");
                    UserController.userStage = stage;
                    stage.setScene(new Scene(root, 1270, 577));
                    stage.show();
                    Model model = new Model();
                    View view = new View();
                    UserController userController = loader.getController();
                    userController.setModelAndView(model,view);
                    loginStage.close();
                    flag = true;

                    UserController.userStage.setOnCloseRequest((WindowEvent event) -> {
                        UserController.userStage.close();
                        loginStage.show();
                        login.setText("");
                        password.setText("");

                    });
                }
            }
        }catch (SQLException e){

        }

        if (!flag){
            View.createErrorAlert(login.getText(),password.getText());
            login.setText("");
            password.setText("");
        }
    }
}
