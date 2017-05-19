package scott.controller;

import scott.model.Elevator;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorController {
    public static void main(String args[]){
        ElevatorSimulation simulation = new ElevatorSimulation(5, 20);
        //find the closest elevator
        Elevator e = simulation.getClosestElevator(1);
        //Move the closest elevator to requesting floor
        simulation.move(e, 1);
        //Open elevator door, log event
        simulation.reportDoor(e, true);
        //Close elevator door, log event
        simulation.reportDoor(e, false);
        //Set destination floor, mark occupied
        simulation.requestFloor(e, 5);
        //Open elevator door, log event
        simulation.reportDoor(e, true);
        //Close elevator door, log event
        simulation.reportDoor(e, false);
        //No current action/destination: mark unoccupied
        simulation.setUnoccupied(e);

    }
}
