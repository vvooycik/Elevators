import java.util.concurrent.Callable;

public class Elevator implements Callable<Integer> {



    private String role;
    private boolean isItFree;
    private boolean doorOpen;
    private boolean isItMoving;
    private Integer currentFloor;
    private Integer destination;

    public Elevator(String role){
        this.role = role;
        isItFree = true;
        isItMoving = false;
        currentFloor = 10;
    }
    @Override
    public Integer call() throws Exception {
        closeTheDoor();
        move(true);
        while(!currentFloor.equals(destination)){
            if(currentFloor < destination) {
                currentFloor++;
                Thread.sleep(5000);
                System.out.printf("I'm the %s on the floor no.%d, dest = %d%n", role, currentFloor, destination);
            }
            else{
                currentFloor--;
                Thread.sleep(5000);
                System.out.printf("I'm the %s on the floor no.%d, dest = %d%n", role, currentFloor, destination);
            }
        }
        move(false);
        openTheDoor();
        return currentFloor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return role;
    }


}
