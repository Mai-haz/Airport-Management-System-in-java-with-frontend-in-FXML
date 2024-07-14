package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Admin {
    @FXML
    private Button ScheduleLanding;
    @FXML
    private Button ScheduleDeparture;
    @FXML
    private Button ModifyPilotDetails;


    @FXML
    void ScheduleDeparture(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("ScheduleDeparture.fxml");
    }
    @FXML
    void ScheduleLanding(ActionEvent event) throws IOException {
        Main m=new Main();
        m.changeScene("ScheduleLanding.fxml");
    }

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
