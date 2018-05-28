package sample.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

public class View {

    public static final String NO_ELEMENTS = "Ошибка,ничего не найдено!";
    public static final String NO_CHOOSE_ELEMENT = "Вы ничего не выбрали!";
    public static final String successPay = "Оплата успешна!Ваш чек вы сможете найти на своем рабочем столе.Его название :";
    public static final String badPay = "Оплата не прошла!Попробуйте снова.";

    public void createAlert(String message,Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Look, an Exception Dialog!");
        alert.setContentText(message);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    public void createWarningAllert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(message);
        alert.setContentText("Простите!Но вы не выбрали комплектующее или компьютер.Для выбора нажмите мышкой на" +
                "поле с товаром, далее на кнопку 'добавить в корзину'");
        alert.showAndWait();
    }

    public static void createErrorAlert(String useraname,String password){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Пользователя с такими данными не существует");
        alert.setContentText("username: " + useraname + '\n' +
        "password: " + password);
        alert.showAndWait();
    }

    public static void createSuccesCheck(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Покупка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
