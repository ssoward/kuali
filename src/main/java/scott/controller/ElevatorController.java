package scott.controller;

import scott.model.Elevator;
import scott.model.ElevatorSimulation;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorController {
    public static void main(String args[]){
        ElevatorSimulation simulation = new ElevatorSimulation(5, 20);
        Elevator e = simulation.getClosestElevator(1);
        simulation.requestFloor(e, 5);
    }
}
