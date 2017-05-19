package scott.model;

/**
 * Created by ssoward on 5/18/17.
 */
public class Elevator {
    int currentFloor = 0;
    Boolean doorOpen = false;
    int maxFloor = 0;
    int id = 0;
    int trips = 0;
    int floorsPassed = 0;
    Boolean maintenance;

    public Elevator(){}

    public Elevator(int currentFloor, Boolean doorOpen, int maxFloor, int id, int trips, int floorsPassed, Boolean maintenance){
        this.currentFloor = currentFloor;
        this.doorOpen     = doorOpen;
        this.maxFloor     = maxFloor;
        this.id           = id;
        this.trips        = trips;
        this.floorsPassed = floorsPassed;
        this.maintenance  = maintenance;

    }

}
