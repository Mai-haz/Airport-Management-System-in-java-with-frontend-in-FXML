package UserInterface;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;
    public class SignUpClass {
        @FXML
        private TextField ID;
        @FXML
        private TextField password;
        @FXML
        private TextField role;
        @FXML
        private Button SignUp;
        @FXML
        private Label info;

        @FXML
        void SignUp(ActionEvent event) throws IOException {
            Main m=new Main();
            if(ID.getText().isEmpty() || password.getText().isEmpty()||role.getText().isEmpty())
            {
                info.setText("Enter Data in all fields");
            }
            else {
                String id = ID.getText();
                String Pass = password.getText();
                String Role= role.getText();
                boolean check = m.getBLController().SignUp(id,Pass,Role);

                //int roll=Integer.parseInt(rollNumber.getText());
                if(check)
                {info.setText("Signup Successfull");}
                else
                {info.setText("Signup Failed");}


            }
        }
    }



