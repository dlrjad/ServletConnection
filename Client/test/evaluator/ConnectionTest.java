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
        ControllerManager connect  = new ControllerConnection();
        Assert.assertEquals(true, connect.Connection());
    }
    
}
