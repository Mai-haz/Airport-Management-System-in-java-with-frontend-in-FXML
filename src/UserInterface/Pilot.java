package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Pilot {
    @FXML
    private Button ModifyPilotDetails;
    @FXML
        void ModifyPilotDetails(ActionEvent event) throws IOException {
            Main m=new Main();
            m.changeScene("ModifyPilotDetails.fxml");

        }
    @FXML
    void ViewDetails(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("ViewDetails.fxml");

    }
    }

