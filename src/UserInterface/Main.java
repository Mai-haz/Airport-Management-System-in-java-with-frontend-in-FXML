package UserInterface;
import java.io.IOException;
import BusinessLogic.Airport;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;
public class Main extends Application {
    private static Stage stg;
    private static Airport air = new Airport(); // BL controller object

    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Airport Management System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Airport getBLController() {

        return air;
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}