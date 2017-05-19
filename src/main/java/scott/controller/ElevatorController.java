package scott.controller;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorController {
    public static void main(String args[]){
        ElevatorSimulation simulation = new ElevatorSimulation(5, 20);
        //find the closest elevator
        simulation.requestElevator(1, 10);



    }
}
