package scott.utils;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorUtils {
    public static int getDistance(int elevator, int callingFloor) {
        return Math.abs(elevator - callingFloor);
    }
}
