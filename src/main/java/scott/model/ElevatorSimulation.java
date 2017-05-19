package scott.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorSimulation {
    List<Elevator> elevators;
    int floors = 1;

    public ElevatorSimulation(){}

    public ElevatorSimulation(int elevatorCount, int floors){
        if(floors<1){ //log error: cannot be lower than 1 }

            this.elevators = new ArrayList<>();

            for(int i = 0; i <= elevatorCount; i++){
                Elevator e = new Elevator(1, false, floors, i, 0, 0, false );
                this.elevators.add(e);
            }
            this.floors = floors;
        }
    }

    public Elevator getClosestElevator(int callingFloor) {

    }
}
