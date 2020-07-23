import java.util.LinkedList;
import java.util.concurrent.Callable;

public class Elevator implements Callable<Integer> {

    private String name;
    private boolean isItFree;
    private boolean doorOpen;
    private boolean isItMoving;
    private Integer currentFloor;
    private Integer destination;
    LinkedList<Floor> floorQueue;

    public Elevator(String name){
        this.name = name;
        isItFree = true;
        isItMoving = false;
        currentFloor = 0;
        floorQueue = new LinkedList<>();
    }
    @Override
    public Integer call() throws Exception {
        closeTheDoor();
        move(true);
        while(!currentFloor.equals(destination)){
            if(currentFloor < destination) {
                currentFloor++;
                Thread.sleep(2000);
                System.out.println("I'm on the floor no. " + currentFloor);
            }
            else{
                currentFloor--;
                Thread.sleep(2000);
                System.out.println("I'm on the floor no. " + currentFloor);
            }
        }
        return currentFloor;
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
        System.out.println("Opening the door");
        doorOpen = true;
    }
    public void closeTheDoor(){
        System.out.println("Closing the door");
        doorOpen = false;
    }
    public boolean isItMoving(){
        return isItMoving;
    }
    public void move(boolean isItMoving){
        this.isItMoving = isItMoving;
    }
    public Integer getCurrentFloor(){
        return currentFloor;
    }
    public void setCurrentFloor(Integer currentFloor){
        this.currentFloor = currentFloor;
    }
    public Integer getDestination(){
        return destination;
    }
    public void setDestination(Integer destination){
        this.destination = destination;
    }
    public void displayTheMessage(){
        System.out.println("Go to the other elevator");
    }
    public String toString(){
        return name;
    }


}
