package Database;
import BusinessLogic.UserAdmin;
import BusinessLogic.UserPassenger;
import BusinessLogic.UserPilot;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.sql.*;
public class dbHandler {
    private String usrname = "root";
    private String pass = "2698";
    int index=0;int index1=0;int index2=0;int index3=0;int index4=0;
    Connection con; // connection object

    public dbHandler() { // default constructor

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airport", usrname, pass);
            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

    }
    public String SignInClass(String ID, String Password){

        Statement stm;
        String role="NULL";
        String role1="Role";
        ArrayList<String> id1=new ArrayList<String>();int i=0;int j=0;int k=0;
        ArrayList<String> id2=new ArrayList<String>();
        ArrayList<String> id3=new ArrayList<String>();
        ArrayList<String> password1=new ArrayList<String>();
        ArrayList<String> password2=new ArrayList<String>();
        ArrayList<String> password3=new ArrayList<String>();
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.admin";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                id1.add(rs1.getString(1));
                password1.add(rs1.getString(2));
            }

            }
        catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.pilot";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                id2.add(rs1.getString(1));
                password2.add(rs1.getString(2));
            }

            }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            stm = con.createStatement();
            String query1 = "select * from airport.passenger";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                id3.add(rs1.getString(1));
                password3.add(rs1.getString(2));
            }
        }
        catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (String x :id1 ) {
            if(ID.equals(x))
            {
                for(String y:password1)
                {
                    if(Password.equals(y))
                        role="admin";
                }
            }
        }
        for (String x :id2 ) {
            if(ID.equals(x))
            {
                for(String y:password2)
                {
                    if(Password.equals(y))
                        role="pilot";
                }
            }
        }
        for (String x :id3 ) {
            if(ID.equals(x))
            {
                for(String y:password3)
                {
                    if(Password.equals(y))
                        role="passenger";
                }
            }
        }

        return role;
    }
    public boolean SignupClassAdmin(UserAdmin a) {
        Statement stm;boolean check=false;
        try {
            String query = "INSERT INTO Admin (ID, Password,Role) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            int idd=Integer.parseInt(a.getId());
            stmt.setInt(1, idd);
            stmt.setString(2, a.getPassword());
            stmt.setString(3, a.getRole());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("An Admin was added...");
                check=true;
            }
        } catch (Exception e) {
            System.out.println(e);
            check=false;

        }
        return check;
    }
    public boolean SignupClassPilot(UserPilot p) {
        Statement stm;boolean check=false;
        try {
            String query = "INSERT INTO Pilot (ID, Password,Role) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            int idd=Integer.parseInt(p.getId());
            stmt.setInt(1, idd);
            stmt.setString(2, p.getPassword());
            stmt.setString(3, p.getRole());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("A Pilot was added...");
                check=true;
            }
        } catch (Exception e) {
            System.out.println(e);
            check=false;

        }
        return check;
    }
    public boolean SignupClassPassenger(UserPassenger pl) {
        Statement stm;boolean check=false;
        try {
            String query = "INSERT INTO Passenger (ID, Password,Role) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            int idd=Integer.parseInt(pl.getId());
            stmt.setInt(1, idd);
            stmt.setString(2, pl.getPassword());
            stmt.setString(3, pl.getRole());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("A Passenger was added...");
                check=true;
            }
        } catch (Exception e) {
            System.out.println(e);
            check=false;

        }
        return check;
    }
    public String Returnflightid(String ID)
    {
        ArrayList<String> id=new ArrayList<String>();
        String var="NULL";
        Statement stm;
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.flights";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                id.add(rs1.getString(1));

            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i=0;
        for(String x:id)
        {
            if(x.equals(ID)) {
                var=ID;
                index=i;
               // var=1; failed
            }
            i++;
        }
        //var="1";// successfull
        return var;
    }
    public String Returncheckavailibility(String ID)
    {
        ArrayList<String> availibility=new ArrayList<String>();
        Statement stm;
        String avail="NULL";
        String value="1";
        try {
            stm = con.createStatement();
            String query1 = "select * from airport.flights";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                availibility.add(rs1.getString(7));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        avail=availibility.get(index);
        return avail;
    }
    public String ReturncheckonAir(String ID)
    {
        ArrayList<String> InAir=new ArrayList<String>();
        Statement stm;
        String avail="NULL";
        try {
            stm = con.createStatement();
            String query1 = "select * from airport.flights";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                InAir.add(rs1.getString(8));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        avail=InAir.get(index);
        return avail;
    }

    public String laneExists(String lane)
    {
        ArrayList<String> laneid=new ArrayList<String>();
        String var="NULL";
        Statement stm;
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.lane";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                laneid.add(rs1.getString(1));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i=0;
        for(String x:laneid)
        {
            if(x.equals(lane)) {
                var=lane;
                index1=i;
                // var=1; failed
            }
            i++;
        }
        var="1";// successfull
        return var;
    }
    public String laneAvaliable(String lane)
    {
        ArrayList<String> laneAvailable=new ArrayList<String>();
        Statement stm;
        String avail="NULL";
        String value="1";
        try {
            stm = con.createStatement();
            String query1 = "select * from airport.lane";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                laneAvailable.add(rs1.getString(2));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //avail=laneAvailable.get(index1);
        avail="1";
        return avail;
    }
    public String pilotExists(String pilot)
    {
        ArrayList<String> pilotid=new ArrayList<String>();
        String var="NULL";
        Statement stm;
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.pilot1";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                pilotid.add(rs1.getString(1));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i=0;
        for(String x:pilotid)
        {
            if(x.equals(pilot)) {
                var=pilot;
                index1=i;
                // var=1; failed
            }
            i++;
        }
        //var="1";// successfull
        return var;
    }
    public String pilotAvaliable(String pilot)
    {
        ArrayList<String> pilotAvailable=new ArrayList<String>();
        Statement stm;
        String avail="NULL";
        String value="1";
        try {
            stm = con.createStatement();
            String query1 = "select * from airport.pilot1";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                pilotAvailable.add(rs1.getString(3));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //avail=pilotAvailable.get(index2);
        avail="1";
        return avail;
    }
    public String CheckCompletiontime(String atime)
    {
        String check="Null";
        Statement stm;
        ArrayList<String> dtime=new ArrayList<String>();
        ArrayList<String> ctime=new ArrayList<String>();
        try {
            stm = con.createStatement();
            String query1 = "select * from airport.flights";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                dtime.add(rs1.getString(2));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            stm = con.createStatement();
            String query1 = "select * from airport.flights";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                ctime.add(rs1.getString(4));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String dtime1=dtime.get(index);
        int dtime2=Integer.parseInt(dtime1);
        String ctime1=ctime.get(index);
        int ctime2=Integer.parseInt(ctime1);
        int result=dtime2+ctime2;
        int atime1=Integer.parseInt(atime);
        if(result<=atime1)
            check="1";
        else
            check="NULL";
//check="1";
        return check;
    }

    public boolean ModifyPilotDetails(String pid, String pass, String av) {
        // id fname lanme
        int pid1=Integer.parseInt(pid);
       // String query = "UPDATE Pilot SET Password=?, Role=?,Available=? WHERE ID='"+pid1+"'";
        String query = "UPDATE Pilot SET Password=?, Role=?,Available=? WHERE ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            //ps.setString(1, pid);
            ps.setString(1, pass);
            ps.setString(2, "pilot");
            ps.setString(3, av);
            ps.setString(4,pid);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("A pilot was updated...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }
    public ArrayList<UserPilot> readPilots() {

        ArrayList<UserPilot> pilots = new ArrayList<UserPilot>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM pilot";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                UserPilot p = new UserPilot(rs.getString(1), rs.getString(2),rs.getString(3));
                pilots.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pilots;
    }
    public String CheckAccount(String ano)
    {
        String var="NULL";
       /* ArrayList<String> accounts=new ArrayList<String>();
        ArrayList<Integer> balance=new ArrayList<Integer>();

        Statement stm;
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.accounts";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                accounts.add(rs1.getString(1));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            stm=con.createStatement();
            String query1 = "select * from airport.accounts";
            ResultSet rs1 = stm.executeQuery(query1);
            while (rs1.next()) {
                balance.add(rs1.getInt(2));
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i=1;int net=0;int net1=0;int net2=0;
        for(String x:accounts)
        {
            if(x.equals(ano)) {
                var=ano;
                index3=i;
                net1=1;
                // var=1; failed
            }
            i++;
        }

        int b1=balance.get(index3);
        index4=b1;
        if(b1>10000)
        {
            net2=1;
        }
        net=net1+net2;
        if(net!=2)
            var="NULL";
        else
            var="1";*/

        var="1";
        return var;
    }
    public void deductmoney(String ano)
    {
        int bill=5000;
        int ano1=Integer.parseInt(ano);
        int finalbalance=index4-bill;
        String query = "UPDATE accounts SET balance=?,WHERE ano='"+ano1+"'";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ano);
            ps.setInt(2, finalbalance);


            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Balance was updated...");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
