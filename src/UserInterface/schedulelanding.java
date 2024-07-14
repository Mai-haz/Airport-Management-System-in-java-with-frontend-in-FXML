package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class schedulelanding{
    ArrayList<String> fido=new ArrayList<String>();
    ArrayList<String> atimeo=new ArrayList<String>();
    ArrayList<String> laneo=new ArrayList<String>();
    void setlschedule(String f,String a,String l)
    {
        fido.add(f);
        atimeo.add(a);
        laneo.add(l);
    }
    @FXML
    private TextField FID;
    @FXML
    private TextField ATime;
    @FXML
    private TextField Lane;
    @FXML
    private Label info;
    @FXML
    private Button Submit;

    @FXML
    void Submit(ActionEvent event) throws IOException {
        String fid=FID.getText();
        String atime=ATime.getText();
        String lane=Lane.getText();
        Main m=new Main();
        if(fid.isEmpty()||atime.isEmpty()||lane.isEmpty())
        {
            info.setText("Enter Data in all fields");
        }
        else {
            boolean check = m.getBLController().ScheduleLanding(fid,atime,lane);
            // int roll=Integer.parseInt(rollNumber.getText());
            if(check)
            {info.setText("Landing Schedule Successfull");
                setlschedule(fid,atime,lane);
            }
            else
            {info.setText("Landing Schedule Failed");}


        }
    }
}
