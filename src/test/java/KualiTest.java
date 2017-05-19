package scott;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ssoward on 5/18/17.
 */
public class KualiTest {
    @org.junit.Test
    public void getString() throws Exception {
    }

    @Test
    public void getClassTest() throws Exception {
        assertTrue("BOOLEAN".equals(Kuali.getClass(Boolean.class)));
        assertTrue("STRING".equals(Kuali.getClass(String.class)));
    }
}