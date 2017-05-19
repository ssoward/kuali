package scott.controller;

import scott.model.Elevator;
import scott.model.MoveReport;
import scott.model.ReportType;
import scott.utils.ElevatorUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
            if(!e.maintenance && e.getOccupied() == -1){
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
        MoveReport moveReport = new MoveReport(e, Arrays.asList(ReportType.MOVED_FROM_FLOOR)); moveReports.add(moveReport);
    }

    public void setUnoccupied(Elevator e) {
        e.setOccupied(-1);
    }
}
