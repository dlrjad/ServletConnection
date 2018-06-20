package example;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dlrjad
 */
public class ControllerConnection implements ControllerManager{

    @Override
    public boolean Connection() {
        //replace localhost by ip address
        String location = "http://localhost:8080/Servlet/ExampleServlet";
        URL url;
        try {
            url = new URL(location);
            URLConnection connection = url.openConnection();
        
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type","application/x-java-serialized-object");
            
            OutputStream outstream = null;
            try {
                outstream = connection.getOutputStream();
                try (ObjectOutputStream s = new ObjectOutputStream(outstream)) {
                    s.writeObject("request");
                    s.flush();
                    s.close();
                }
                InputStream instream = connection.getInputStream();
                String recibir;
                try (ObjectInputStream e = new ObjectInputStream(instream)) {
                    recibir = (String) e.readObject();
                    System.out.println(recibir);
                    e.close();
                    return true;
                }
                
            } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(ControllerConnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    outstream.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControllerConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ControllerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
