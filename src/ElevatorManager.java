import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ElevatorManager {
    Elevator leftElevator;
    Elevator rightElevator;
    Future<Floor> task;
    ExecutorService exec;

    public ElevatorManager(Elevator leftElevator, Elevator rightElevator){
        this.leftElevator = leftElevator;
        this.rightElevator = rightElevator;
        this.exec = Executors.newFixedThreadPool(2);
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
                    exec.submit(elevator);
                }
                // if not free, is it above the caller?
                else{
                    if(elevator.getCurrentFloor() >= (floor+2) && elevator.getDestination()< elevator.getCurrentFloor()){
                        // TODO Do I need to interrupt somehow this ongoing trip?
                        Integer tmp = elevator.getDestination();
                        elevator.setDestination(floor);
                        exec.submit(elevator);
                        elevator.openTheDoor();
                        elevator.setDestination(tmp);
                        exec.submit(elevator);
                    }

                }
            }
            // the other one is closer
            else{

            }
        }
    }




}
