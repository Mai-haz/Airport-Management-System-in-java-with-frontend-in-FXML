package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class modifypilotdetails {
    @FXML
    private TextField pilotid;
    @FXML
    private TextField pass;
    @FXML
    private TextField av;
    @FXML
    private Label info;
    @FXML
    private Button Modify;
    @FXML
    void Modify(ActionEvent event) throws IOException {
        String pid1=pilotid.getText();
        String pass1=pass.getText();
        String av1=av.getText();
        Main m=new Main();
        if(pid1.isEmpty()||pass1.isEmpty()||av1.isEmpty())
        {
            info.setText("Enter Data in all fields");
        }
        else {
            boolean check = m.getBLController().ModifyPilotDetails(pid1,pass1,av1);
            if(check)
            {info.setText("Details Modified");
            }
            else
            {info.setText("Details Not Modified");}
        }
    }


}
