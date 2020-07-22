import java.util.LinkedList;

public class Elevator {

    private boolean isItFree;
    private boolean doorOpen;
    private boolean isItMoving;
    private short currentFloor;
    private short destination;
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



    public boolean isItFree(){
        return isItFree;
    }
    public void setItFree(boolean isItFree){
        this.isItFree = isItFree;
    }
    public boolean isDoorOpen(){
        return doorOpen;
    }
    public void openTheDoor(){
        doorOpen = true;
    }
    public void closeTheDoor(){
        doorOpen = false;
    }
    public boolean isItMoving(){
        return isItMoving;
    }
    public void move(boolean isItMoving){
        this.isItMoving = isItMoving;
    }
    public short getCurrentFloor(){
        return currentFloor;
    }
    public void setCurrentFloor(short currentFloor){
        this.currentFloor = currentFloor;
    }
    public short getDestination(){
        return destination;
    }
    public void setDestination(short destination){
        this.destination = destination;
    }

}
