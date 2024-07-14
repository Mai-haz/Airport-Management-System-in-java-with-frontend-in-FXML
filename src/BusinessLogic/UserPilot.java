package BusinessLogic;

public class UserPilot {
    private String ID;
    private String password;
    private String Role;

    private String Availibility;
    public UserPilot()
    {}
    public UserPilot(String id, String password, String role) {
        this.ID = id;
        this.password = password;
        this.Role = role;

    }
    public UserPilot(String id, String password, String role,String Avail) {
        this.ID = id;
        this.password = password;
        this.Role = role;
        this.Availibility=Avail;

    }
    @Override
    public String toString() {
        return "Pilot [ID=" + ID + ", Password=" + password + ", Role=" + Role + "]";
    }
    public String getId() {
        return ID;
    }
    public String setId(String id) {
        this.ID = id;return id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        this.Role = role;
    }
    public void setAvailibility(String avail) {
        this.Availibility = avail;
    }

}

