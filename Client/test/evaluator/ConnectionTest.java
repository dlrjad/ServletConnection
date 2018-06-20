package evaluator;

import example.ControllerConnection;
import example.ControllerManager;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author dlrjad
 */
public class ConnectionTest {
    
    @Test
    public void evaluatorConnectionTest() {
        ControllerManager cm  = new ControllerConnection();
        Assert.assertEquals(true, cm.Connection());
    }
    
}
