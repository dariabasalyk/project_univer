package sample.Test;

import javafx.fxml.FXMLLoader;
import org.testng.annotations.Test;
import sample.Controllers.UserController;
import sample.Model;
import sample.entity.RAM;
import sample.entity.enums.Computer;
import sample.entity.enums.TypeRam;
import sample.view.View;

import java.net.URL;

public class UnitTest {

    @Test
    public void checkIfSignUpFormExists() {
        URL signUpURL = getClass().getResource("../fxml/signup.fxml");
        assert signUpURL != null;
    }

    @Test
    public void checkIfLoginPageExists() {
        URL loginPageURL = getClass().getResource("../fxml/LoginPage.fxml");
        assert loginPageURL != null;
    }

    @Test
    public void userControllerTest() {
        UserController userController = new UserController();
        boolean isNullPointerException = false;
        try {
            userController.setModelAndView(new Model(), new View());
        } catch (NullPointerException e) {
            isNullPointerException = true;
        }
        assert isNullPointerException;
    }

    @Test
    public void ComputerTypeTest() {
        Computer computer = new Computer("testName", "testType");
        assert computer.getName() instanceof String;
        assert computer.getType() instanceof String;
    }

    @Test
    public void RAMGetTest() {
        RAM ram = new RAM(1, "testName", 100.10);
        assert ram.getMemory_size() == 1;
        assert ram.getName().equals("testName");
        assert ram.getPrice() == 100.10;
        assert ram.getTypeOfMemory() == null;
    }
}
