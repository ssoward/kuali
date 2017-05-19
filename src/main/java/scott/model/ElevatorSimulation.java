package scott.model;

import scott.utils.ElevatorUtils;

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
        Elevator closest = null;
        for(Elevator e: elevators){
            closest = closest != null ? closest: e;
            if(!e.maintenance){
                if(e.currentFloor == callingFloor){
                    return e;
                }
                if(ElevatorUtils.getDistance(e.currentFloor, callingFloor) < ElevatorUtils.getDistance(closest.currentFloor, callingFloor)){
                    closest = e;
                }
            }
        }
        return closest;
    }

    public void requestFloor(Elevator e, int i) {

    }
}
