import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ElevatorManager {
    Elevator leftElevator;
    Elevator rightElevator;
    Future<Integer> leftTask;
    Future<Integer> rightTask;
    ExecutorService exec;
    LinkedList<Floor> floorQueue;

    public ElevatorManager(Elevator leftElevator, Elevator rightElevator){
        this.leftElevator = leftElevator;
        this.rightElevator = rightElevator;
        this.exec = Executors.newFixedThreadPool(2);
        floorQueue = new LinkedList<>();
    }

    public void call(Elevator elevator, Integer floor){
        Elevator otherElevator = elevator.equals(rightElevator) ? leftElevator : rightElevator;
        System.out.println(elevator + " called. Floor no. " + floor);

        /*
            Checking if any elevator is available on the caller's floor
         */
        if(elevator.getCurrentFloor() == floor && !elevator.isItMoving()){
            elevator.openTheDoor();
        }
        else if(otherElevator.getCurrentFloor() == floor && !elevator.isItMoving()){
            elevator.displayTheMessage();
            otherElevator.openTheDoor();
        }
        /*
            If there is no elevator available on the caller's floor. Check which one is closer to them
         */
        else{
            // the one is closer
            if(Math.abs(elevator.getCurrentFloor() - floor) <= Math.abs(otherElevator.getCurrentFloor() - floor)){
                // is it free?
                if(!elevator.isItMoving()) {
                    elevator.setDestination(floor);
                    if(elevator.getRole().equals("Left Elevator"))
                        leftTask = exec.submit(elevator);
                    else
                        rightTask = exec.submit(elevator);
                }
                // if not free, is it above the caller?
                else{
                    // if above the caller and going down
                    if(elevator.getCurrentFloor() >= (floor+2)){
                        if(elevator.getDestination() < elevator.getCurrentFloor()) {
                            makeAStop(elevator, floor);
                        }
                        else{
                            floorQueue.add(new Floor(floor));
                        }
                        // Elevator not above, but destination set for the caller's floor
                    }else if(elevator.getDestination().equals(floor)){
                        return; // Wait for the elevator
                    }
                    else{
                        floorQueue.add(new Floor(floor));
                    }
                }
            }
            // the other one is closer
            else{

            }
        }
    }
    public void makeAStop(Elevator elevator, Integer stop){
        Integer tmp = elevator.getDestination();
        elevator.setDestination(stop);
        if(elevator.getRole().equals("LeftElevator")) {
            while (!leftTask.isDone()) {
                ;
            }
            elevator.setDestination(tmp);
            leftTask = exec.submit(elevator);
        }else{
            while(!rightTask.isDone()){
                ;
            }
            elevator.setDestination(tmp);
            rightTask = exec.submit(elevator);
        }
    }




}
