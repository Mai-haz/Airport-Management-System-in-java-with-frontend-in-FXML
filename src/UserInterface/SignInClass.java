package UserInterface;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import Database.dbHandler;
public class SignInClass {

    @FXML
    private TextField ID;
    @FXML
    private TextField password;
    @FXML
    private Button SignIn;
    @FXML
    private Label info;
    @FXML
    void SignIn(ActionEvent event) throws IOException {
        String id = ID.getText();
        String pass = password.getText();
        //check for this id what is the role
        Main m = new Main();
        String r=m.getBLController().SignIn(id,pass);
        if(r.equals("admin")) {
            m.changeScene("admin.fxml");
        }
        if(r.equals("pilot")) {
            m.changeScene("pilot.fxml");
        }
        if(r.equals("passenger")) {
            m.changeScene("passenger.fxml");
        }
        info.setText("Signin");
    }
}