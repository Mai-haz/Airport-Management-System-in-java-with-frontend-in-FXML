package UserInterface;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class scheduledeparture{
    ArrayList<String> fido=new ArrayList<String>();
    ArrayList<String> dtimeo=new ArrayList<String>();
    ArrayList<String> ctimeo=new ArrayList<String>();
    ArrayList<String> laneo=new ArrayList<String>();
    ArrayList<String> piloto=new ArrayList<String>();
    void setdschedule(String f,String d,String c,String l,String p)
    {
        fido.add(f);
        dtimeo.add(d);
        ctimeo.add(c);
        laneo.add(l);
        piloto.add(p);
    }
    @FXML
    private TextField FID;
    @FXML
    private TextField DTime;

    @FXML
    private TextField CTime;
    @FXML
    private TextField Lane;
    @FXML
    private TextField pilot;
    @FXML
    private Label info;
    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent event) throws IOException {
        String fid=FID.getText();
        String dtime=DTime.getText();
        String Pilot=pilot.getText();
        String lane=Lane.getText();

        String ctime=CTime.getText();
        Main m=new Main();
        if(fid.isEmpty()||dtime.isEmpty()||Pilot.isEmpty()||lane.isEmpty()||ctime.isEmpty())
        {
            info.setText("Enter Data in all fields");
        }
        else {
            boolean check = m.getBLController().ScheduleDeparture(fid,dtime,ctime,Pilot,lane);
            // int roll=Integer.parseInt(rollNumber.getText());
            if(check)
            {info.setText("Departure Schedule Successfull");
                setdschedule(fid,dtime,ctime,Pilot,lane);

            }
            else
            {info.setText("Departure Schedule Failed");}
        }
    }
}
