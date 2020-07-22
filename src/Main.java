import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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


        Button bottomRightButton;
        Button bottomLeftButton;
        bottomRightButton = new Button("Stop right elevator");
//        bottomRightButton.setOnAction(e -> manager.rightElevator.call(rightCombo.getValue()));
        bottomLeftButton = new Button("Stop left elevator");
//        bottomLeftButton.setOnAction(e -> manager.leftElevator.call(leftCombo.getValue()));

        BorderPane layout = new BorderPane();

        VBox leftButtons = new VBox();
        leftButtons.setAlignment(Pos.CENTER);
        leftButtons.setPadding(new Insets(40,40,40,40));
        leftButtons.setSpacing(20);
        layout.setLeft(leftButtons);

        VBox rightButtons = new VBox();
        rightButtons.setAlignment(Pos.CENTER);
        rightButtons.setPadding(new Insets(40,40,40,40));
        rightButtons.setSpacing(20);
        layout.setRight(rightButtons);

        for(Integer f: floors){
            Integer floor = floors.length - (f+1);
            Button leftButton = new Button(floor.toString());
            leftButton.setPrefWidth(40);
            Button rightButton = new Button(floor.toString());
            rightButton.setPrefWidth(40);
            leftButton.setOnAction(e -> manager.leftElevator.call(floor));
            rightButton.setOnAction(e -> manager.rightElevator.call(floor));
            leftButtons.getChildren().add(leftButton);
            rightButtons.getChildren().add(rightButton);
        }

        HBox bottomButtons = new HBox();
        layout.setBottom(bottomButtons);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setSpacing(20);
        bottomButtons.setPadding(new Insets(30,10,30,10));
        bottomButtons.getChildren().add(bottomLeftButton);
        bottomButtons.getChildren().add(bottomRightButton);


        primaryStage.setTitle("Elevator Simulator");
        Scene mainScene = new Scene(layout, 720, 1280);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


}
