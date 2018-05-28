package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupController {
    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String PASSWORD = "root";
    private final String USERNAME = "root";

    private final String number = "((\\+)(38))?(([\\-\\s])?(\\d){1}){10}";
    private final String adress = "([a-zA-Z0-9])+(([\\.\\_\\-])?([a-zA-Z0-9])+)*" +
            "@([a-z])+((\\.){1}([a-z]){2,4})+";
    private final String name = "([A-Z]){1}([a-z]){0,}(([\\-])([A-Z]){1}([a-z]){0,})?";

    static Stage signupStage;
    private String loginField, passwordField, fnameField, lnameField, emailField, phoneField;

    @FXML
    public TextField login;

    @FXML
    public TextField password;

    @FXML
    public TextField fname;

    @FXML
    public TextField lname;

    @FXML
    public TextField email;

    @FXML
    public TextField phone;

    @FXML
    public Label error;

    @FXML
    public void backToFirstPage(){
        signupStage.close();
        Main.currentStage.show();
    }


    @FXML
    public void signup() throws Exception{
        boolean flag = true;
        loginField = login.getText();
        passwordField = password.getText();
        fnameField = fname.getText();
        lnameField = lname.getText();
        emailField = email.getText();
        phoneField = phone.getText();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(loginField)) {
                    flag = false;
                    error.setText("Даний логін уже використовується. Придумайте новий");
                }
            }
        }catch (SQLException e){

        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(emailField)) {
                    flag = false;
                    error.setText("Дана адреса електронної пошти уже використовується.");
                }
            }
        }catch (SQLException e){

        }

        if (!checkData(fnameField,name)){
            flag = false;
            error.setText("Некоректно введено імя");
        }
        if (!checkData(lnameField,name)){
            flag = false;
            error.setText("Некоректно введено прізвище");
        }
        if (!checkData(emailField,adress)){
            flag = false;
            error.setText("Некоректно введено електронну адресу");
        }
        if (!checkData(phoneField,number)){
            flag = false;
            error.setText("Некоректно введено телефон");
        }

        String update = String.format("insert into users values('%s','%s','%s','%s','%s','%s');",loginField,passwordField,fnameField,lnameField,emailField,phoneField);
        if(flag){
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
            statement.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/userPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Automatic-system");
            UserPageController.userPageStage = stage;
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            UserPageController userPageController = loader.getController();
            signupStage.close();
        }
    }

    public static boolean checkData(String field, String value){
        Pattern p = Pattern.compile(value);
        Matcher m = p.matcher(field);
        return m.matches();
    }

}
