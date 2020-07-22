import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ElevatorManager //implements EventHandler<ActionEvent>
{
    Elevator leftElevator;
    Elevator rightElevator;

    public ElevatorManager(Elevator leftElevator, Elevator rightElevator){
        this.leftElevator = leftElevator;
        this.rightElevator = rightElevator;
    }

}
