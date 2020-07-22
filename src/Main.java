import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Elevator rightElevator = new Elevator();
        Elevator leftElevator = new Elevator();
        ElevatorManager manager = new ElevatorManager(leftElevator, rightElevator);
        Integer[] floors = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        ComboBox<Integer> rightCombo = new ComboBox<>();
        rightCombo.getItems().addAll(floors);
        rightCombo.setValue(0);
        ComboBox<Integer> leftCombo = new ComboBox<>();
        leftCombo.getItems().addAll(floors);
        leftCombo.setValue(0);

        Button rightButton;
        Button leftButton;
        rightButton = new Button("Call the right one");
        rightButton.setOnAction(e -> manager.rightElevator.call(rightCombo.getValue()));
        leftButton = new Button("Call the left one");
        leftButton.setOnAction(e -> manager.leftElevator.call(leftCombo.getValue()));

        BorderPane layout = new BorderPane();
        HBox buttons = new HBox();
        layout.setBottom(buttons);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        buttons.setPadding(new Insets(30,10,30,10));
        buttons.getChildren().add(leftCombo);
        buttons.getChildren().add(leftButton);
        buttons.getChildren().add(rightButton);
        buttons.getChildren().add(rightCombo);


        primaryStage.setTitle("Elevator Simulator");
        Scene mainScene = new Scene(layout, 720, 1280);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


}
