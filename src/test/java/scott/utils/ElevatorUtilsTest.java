package scott.model;

import org.junit.Test;
import scott.Kuali;
import scott.utils.ElevatorUtils;

import static org.junit.Assert.assertTrue;

/**
 * Created by ssoward on 5/18/17.
 */
public class ElevatorUtilsTest {

    @Test
    public void getDistanceTest() throws Exception {
        assertTrue(ElevatorUtils.getDistance(10, 3) == 7);
        assertTrue(ElevatorUtils.getDistance(1, 3) == 2);
    }
}