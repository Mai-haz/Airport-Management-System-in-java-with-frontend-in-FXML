package BusinessLogic;
public class ControlTower {
    int allowed=10;
    public
    int returnapproval()
    {
        if(allowed<1)
            return 0;
        else
            return 1;
    }
    void incrementall()
    {
        allowed++;
    }
    void decrementall()
    {
        allowed--;
    }
}
