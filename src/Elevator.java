import java.util.EventListener;
import java.util.LinkedList;

public class Elevator {

    boolean isItFree;
    boolean isItMoving;
    short currentFloor;
    short destination;
    LinkedList<Floor> floorQueue;

    public Elevator(){
        isItFree = true;
        isItMoving = false;
        currentFloor = 0;
        floorQueue = new LinkedList<>();
    }


}
