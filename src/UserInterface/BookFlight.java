package UserInterface;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
public class BookFlight {
    ArrayList<String> flightno=new ArrayList<String>();
    ArrayList<String> seatno=new ArrayList<String>();
    ArrayList<String> accountno=new ArrayList<String>();
    void setBooking(String f,String a,String l)
    {
        flightno.add(f);
        seatno.add(a);
        accountno.add(l);
    }
    @FXML
    private TextField fno;
    @FXML
    private TextField sno;
    @FXML
    private TextField ano;

    @FXML
    private Button Book;
    @FXML
    private Label info;
    @FXML
    void Book(ActionEvent event) throws IOException {
        String fno1=fno.getText();
        String sno1=sno.getText();
        String ano1=ano.getText();
        Main m = new Main();
        if(fno1.isEmpty()||sno1.isEmpty()||ano1.isEmpty())
        {
            info.setText("Enter Data in all fields");
        }
        else {
            boolean check = m.getBLController().Book(fno1,sno1,ano1);
            if(check)
            {info.setText("Booking Successfull");
                setBooking(fno1,sno1,ano1);
            }
            else
            {info.setText("Booking Failed");}


        }
    }
}
