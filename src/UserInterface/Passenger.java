package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Passenger {
    @FXML
    private Button BOOKFLIGHTS;

    @FXML
    void BOOKFLIGHTS(ActionEvent event) throws IOException {
            Main m=new Main();
            m.changeScene("BookFlight.fxml");
    }



}
