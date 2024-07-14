package BusinessLogic;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;

public class Flights {
String id;
String dtime;
String atime;
String ctime;
String pid;
String lane;
String availibility;
String onair;//if onair is 1 = not in air
                // onair is 0= in air
    ArrayList<String> seats=new ArrayList<String>();
    String value1="0";
    String value2="1";
    void initialize(){
    seats.add(value1);
    seats.add(value2);
    seats.add(value1);
    seats.add(value2);
    seats.add(value1);
    seats.add(value2);
    seats.add(value1);
    seats.add(value2);
    seats.add(value1);
    seats.add(value2);}


public
    String EnterFlightId(String Id)
    {
    id=Id;
    return id;
    }
    String CheckAvailibility(String id)
    {
        return id;
    }
    String CheckonAir(String id)
    {
        return id;
    }
    boolean getSeat(String sno)
    {
        int sno1=Integer.parseInt(sno);
        String seat=seats.get(sno1);
        int seat1=Integer.parseInt(seat);
        if(seat1==1)
            return false;
        else
            return true;

    }

}
