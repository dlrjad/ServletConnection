package example;

import javax.swing.JOptionPane;

/**
 *
 * @author dlrjad
 */
public class main {
    
    public static void main(String[] args) {
        ControllerManager cm = new ControllerConnection();
        if (cm.Connection()) {
            JOptionPane.showMessageDialog(null, "Conecta con servidor");
        } else {
            JOptionPane.showMessageDialog(null, "No es posible la conección");
        }
    }
    
}
