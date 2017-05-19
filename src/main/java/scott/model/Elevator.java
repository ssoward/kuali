package scott.model;

/**
 * Created by ssoward on 5/18/17.
 */
public class Elevator {
    public int currentFloor = 0;
    public Boolean doorOpen = false;
    public int id = 0;
    public int trips = 0;
    public int floorsPassed = 0;
    public Boolean maintenance;
    private int occupied;

    public Elevator(){}

    public Elevator(int currentFloor, Boolean doorOpen, int id, int trips, int floorsPassed, Boolean maintenance){
        this.currentFloor = currentFloor;
        this.doorOpen     = doorOpen;
        this.id           = id;
        this.trips        = trips;
        this.floorsPassed = floorsPassed;
        this.maintenance  = maintenance;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getOccupied() {
        return occupied;
    }
}
