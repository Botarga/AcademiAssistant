//package academiaassistant;

import static java.lang.System.*;
import java.io.*;

/**
 *
 * @author botarga
 */
public class Gestor {
    private BufferedReader in = 
        new BufferedReader(new InputStreamReader(System.in));
    
    public boolean login(){
        boolean exito = false;
        
        try{
            out.println("Menu de login");
            in.readLine();
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
        
        return exito;
    }
    
    public Gestor(){
        
    }
    
    public void run(){
        boolean terminado = false;
        
        while(!terminado){
            login();
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Gestor g = new Gestor();
        g.run();
    }
    
}
