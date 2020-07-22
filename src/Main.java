import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        Elevator rightElevator = new Elevator();
        Elevator leftElevator = new Elevator();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Elevator Simulator");
    }
}
