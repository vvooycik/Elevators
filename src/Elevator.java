import java.util.LinkedList;

public class Elevator {

    boolean isItFree;
    boolean doorOpen;
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
    public void call(Integer floor){
        System.out.println("Elevator called on floor " + floor.toString());
    }
    public void openTheDoor(){
        doorOpen = true;
    }
    public void closeTheDoor(){
        doorOpen = false;
    }
    public void move(){

    }



}
