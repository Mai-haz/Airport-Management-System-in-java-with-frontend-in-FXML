package BusinessLogic;
import Database.dbHandler;
import UserInterface.scheduledeparture;
import UserInterface.schedulelanding;
import java.util.ArrayList;
public class Airport { // BL controller
    private dbHandler db;
    private scheduledeparture sd;
    private schedulelanding sl;

    public Airport() {
        db = new dbHandler();
    }

    public String SignIn(String id, String password) {
        return db.SignInClass(id, password);
    }

    public boolean SignUp(String id, String password, String role) {
        if (role.equals("admin")) {
            UserAdmin a = new UserAdmin(id, password, role);
            return db.SignupClassAdmin(a);
        } else if (role.equals("pilot")) {
            UserPilot p = new UserPilot(id, password, role);
            return db.SignupClassPilot(p);
        } else if (role.equals("passenger")) {
            UserPassenger pl = new UserPassenger(id, password, role);
            return db.SignupClassPassenger(pl);
        } else
            return false;
    }

    public boolean ScheduleDeparture(String fid, String dtime, String ctime, String Pilot, String lane1) {
        //login has been approved
        boolean set = false;
        int count = 0;
        Flights f = new Flights();

        String id = f.EnterFlightId(fid);//id returned by flight
        //id=1; failed
        String id1 = db.Returnflightid(id);//id returned by db
        //id1=1; pass
        if (id1.equals("NULL"))
            count = 0;
        else {
            int id11 = Integer.parseInt(id1);
            if (id11 != 0)
                count++;
            //this means the flight exists
            //now check availibility
            String id2 = f.CheckAvailibility(id);
            //String id3=f.CheckonAir(id1);
            String avail1 = db.Returncheckavailibility(id);
            if (avail1.equals("NULL"))
                count = 0;
            else {
                int avail2 = Integer.parseInt(avail1);
                if (avail2 != 0) {
                    count++;
                    //means flight is avaliable
                    String avail3 = db.ReturncheckonAir(id);
                    if (avail3.equals("NULL"))
                        count = 0;
                    else {
                        int avail4 = Integer.parseInt(avail3);
                        if (avail4 != 0) {
                            count++;
                            //check on air passed
                            ControlTower c = new ControlTower();
                            int ct = c.returnapproval();
                            if (ct == 0)
                                count = 0;
                            else {
                                count++;
                                //we have recieved control towers approval
                                Lane l = new Lane();
                                String l1 = l.assignlane(lane1);//lane returned by lane
                                //id=1; failed
                                String l2 = db.laneExists(lane1);//id returned by db
                                //id1=1; pass
                                if (l2.equals("NULL"))
                                    count = 0;
                                else {
                                    count++;
                                    //means lane exists
                                    String l3 = db.laneAvaliable(lane1);
                                    if (l3.equals("NULL"))
                                        count = 0;
                                    else {
                                        count++;
                                        //so lane is available
                                        UserPilot up = new UserPilot();
                                        String p1 = up.setId(Pilot);
                                        String p2 = db.pilotExists(Pilot);
                                        if (p2.equals("NULL"))
                                            count = 0;
                                        else {
                                            count++;
                                            //pilot exists
                                            String p3 = db.pilotAvaliable(Pilot);
                                            if (p3.equals("NULL"))
                                                count = 0;
                                            else {
                                                count++;
                                                //pilot is avaliable
                                            }
                                        }

                                    }
                                }


                            }
                        }
                    }

                }

            }
        }

        if (count == 8) {
            set = true;
        } else
            set = false;
        return set;
    }


    public boolean ScheduleLanding(String fid, String atime, String lane1) {
        //login has been approved
        boolean set = false;
        int count = 0;
        Flights f = new Flights();
        String id = f.EnterFlightId(fid);//id returned by flight
        //id=1; failed
        String id1 = db.Returnflightid(id);//id returned by db
        //id1=1; pass
        if (id1.equals("NULL"))
            count = 0;
        else {
            int id11 = Integer.parseInt(id1);
            if (id11 != 0) {
                count++;
                //this means flight exists
                //now check availibility
                String id2 = f.CheckAvailibility(id);
                String avail1 = db.Returncheckavailibility(id);
                if (avail1.equals("NULL"))
                    count = 0;
                else {
                    int avail2 = Integer.parseInt(avail1);
                    if (avail2 != 0) {
                        count++;
                        //means flight is avaliable
                        String avail3 = db.ReturncheckonAir(id);
                        /////////////////////////////////////////////////////////////////////////////////////////
                        //change it to 0
                        if (avail3.equals("1"))//
                        {
                            count++;
                            ControlTower c = new ControlTower();
                            int ct = c.returnapproval();
                            if (ct == 0)
                                count = 0;
                            else {
                                count++;
                                //we have recieved control towers approval
                                //now we need to check completion time
                                String c1 = db.CheckCompletiontime(atime);
                                //c1 = "1";
                                if (c1.equals("NULL"))
                                    count = 0;
                                else {
                                    int c2 = Integer.parseInt(c1);
                                    if (c2 != 0) {
                                        count++;
                                        //completion time is fine
                                        Lane l = new Lane();
                                        String l1 = l.assignlane(lane1);//lane returned by lane
                                        String l2 = db.laneExists(lane1);//id returned by db
                                        //id1=1; pass
                                        if (l2.equals("NULL"))
                                            count = 0;
                                        else {
                                            count++;
                                            //means lane exists
                                            String l3 = db.laneAvaliable(lane1);
                                            if (l3.equals("NULL"))
                                                count = 0;
                                            else {
                                                count++;
                                                //so lane is available
                                            }
                                        }
                                    }
                                }
                            }

                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }

        if (count == 7)
            set = true;
        else
            set = false;

        return set;
    }

    public boolean ModifyPilotDetails(String pid, String pass, String avail) {
        return db.ModifyPilotDetails(pid, pass, avail);
    }

    public ArrayList<UserPilot> ViewPilotDetails() {
        return db.readPilots();

    }

    public boolean Book(String fno, String sno, String ano) {
        boolean check = false;
        //login has been approved
        boolean set = false;
        int count = 0;
        Flights f = new Flights();
        f.initialize();
        String id = f.EnterFlightId(fno);//id returned by flight
        //id=1; failed
        String id1 = db.Returnflightid(id);//id returned by db
        //id1=1; pass
        if (id1.equals("NULL"))
            count = 0;
        else {
            int id11 = Integer.parseInt(id1);
            if (id11 != 0)
                count++;
            //this means the flight exists
            //now check availibility
            String id2 = f.CheckAvailibility(id);
            //String id3=f.CheckonAir(id1);
            String avail1 = db.Returncheckavailibility(id);
            if (avail1.equals("NULL"))
                count = 0;
            else {
                int avail2 = Integer.parseInt(avail1);
                if (avail2 != 0) {
                    count++;
                    //means flight is avaliable
                    boolean got=f.getSeat(sno);
                    if(got==false)
                    {
                        count=0;
                    }
                    else
                    {
                        //seat is avaliable
                        count++;
                        String ac=db.CheckAccount(ano);
                        if(ac.equals("NULL"))
                            count=0;
                        else
                        {
                            count++;
                            //account is fine
                            db.deductmoney(ano);
                            //deduct money from account
                        }

                    }

                }
            }
        }
        if (count == 4) {
            set = true;
        } else
            set = false;
        return set;
    }
}


