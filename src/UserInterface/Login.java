package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Login {
    @FXML
    private Button SignIn;
    @FXML
    private Button SignUp;

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("SignUp.fxml");
    }
    @FXML
    void SignIn(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("SignIn.fxml");
    }
}







