package UserInterface;
import java.io.IOException;
import java.util.ArrayList;
import BusinessLogic.UserPilot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewDetails {
    @FXML
    private Button view;

    @FXML
    private TableColumn<UserPilot, String> ID;//fncol
    @FXML
    private Label info;

    @FXML
    private TableColumn<UserPilot, String> role;//lncol

    @FXML
    private TableColumn<UserPilot, Integer> avail;//avail

    @FXML
    private TableView<UserPilot> pilotTable;
    @FXML
    void View(ActionEvent event) {
        Main m = new Main();
        ArrayList<UserPilot> stu = m.getBLController().ViewPilotDetails();

        if (stu.isEmpty()) {
            info.setText("No Pilots registered");
        }

        else {
            final ObservableList<UserPilot> data = FXCollections.observableArrayList(stu);

           // ID.setCellValueFactory(new PropertyValueFactory<UserPilot, String>("ID"));
            role.setCellValueFactory(new PropertyValueFactory<UserPilot, String>("Role"));
            //avail.setCellValueFactory(new PropertyValueFactory<UserPilot, Integer>("Availibility"));

            pilotTable.setItems(data);
        }

    }

}