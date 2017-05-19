package scott.controller;

import scott.model.Elevator;
import scott.model.MoveReport;
import scott.model.ReportType;
import scott.utils.ElevatorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorSimulation {
    int topFloor = 0;
    List<Elevator> elevators;
    List<MoveReport> moveReports = new ArrayList<>();
    int floors = 1;

    public ElevatorSimulation(){}

    public ElevatorSimulation(int elevatorCount, int floors){
        if(floors<1){ //log error: cannot be lower than 1 }
            this.topFloor = floors;
            this.elevators = new ArrayList<>();

            for(int i = 0; i <= elevatorCount; i++){
                Elevator e = new Elevator(1, false, i, 0, 0, false );
                this.elevators.add(e);
            }
            this.floors = floors;
        }
    }

    public Elevator getClosestElevator(int callingFloor) {
        Elevator closest = null;
        for(Elevator e: elevators){
            closest = closest != null ? closest: e;
            //check to see if an occupied elevator will "pass that floor on its way"
            if(!e.maintenance ){
                if(e.currentFloor == callingFloor || callingFloor < e.getOccupied()){
                    return e;
                }
                if(e.getOccupied() == -1 && ElevatorUtils.getDistance(e.currentFloor, callingFloor) < ElevatorUtils.getDistance(closest.currentFloor, callingFloor)){
                    closest = e;
                }
            }
        }
        //check the case where all elevators were occupied and none passed by destination, add to queue
        if(closest.getOccupied()>-1){
            closest.nextStop.add(callingFloor);
        }
        return closest;
    }

    public void requestFloor(Elevator e, int destinationFloor) {
        e.setOccupied(destinationFloor);
        if(destinationFloor <= this.topFloor){
            move(e, destinationFloor);
        }
    }

    public void move(Elevator e, int toFloor) {
        int travel = ElevatorUtils.getDistance(e.currentFloor, toFloor);
        for(int i = 0; i < travel; i++){
            reportFloorMove(e);
        }
    }

    public void reportDoor(Elevator e, boolean isOpen){
        MoveReport moveReport = new MoveReport(e, Arrays.asList(isOpen ? ReportType.OPENED_DOOR : ReportType.CLOSED_DOOR));
        moveReports.add(moveReport);
    }

    private void reportFloorMove(Elevator e){
        e.floorsPassed = e.floorsPassed ++;
        MoveReport moveReport = new MoveReport(e, Arrays.asList(ReportType.MOVED_FROM_FLOOR)); moveReports.add(moveReport);
    }

    public void setUnoccupied(Elevator e) {
        e.setOccupied(-1);
    }

    public void requestElevator(int callingFloor, int destinationFloor) {
        Elevator e = getClosestElevator(callingFloor);
        //Move the closest elevator to requesting floor
        makeTrip(e, destinationFloor);

        for (Iterator<Integer> iterator = e.nextStop.iterator(); iterator.hasNext();) {
            Integer nextStop = iterator.next();
            e.setOccupied(nextStop);
            iterator.remove();
            makeTrip(e, nextStop);
        }
        //No current action/destination: mark unoccupied
        e.maintenance = e.trips>100;
        setUnoccupied(e);
    }

    private void makeTrip(Elevator e, int destinationFloor) {
        e.trips = e.trips++;
        move(e, destinationFloor);
        //Open elevator door, log event
        reportDoor(e, true);
        //Close elevator door, log event
        reportDoor(e, false);
        //Set destination floor, mark occupied
        requestFloor(e, 5);
        //Open elevator door, log event
        reportDoor(e, true);
        //Close elevator door, log event
        reportDoor(e, false);
    }
}
