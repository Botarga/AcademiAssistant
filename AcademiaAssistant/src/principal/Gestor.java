package principal;

import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author botarga
 */
public class Gestor {
    /*-----ATRIBUTOS-----*/
    //Estáticos
    private static BufferedReader in = 
        new BufferedReader(new InputStreamReader(System.in));
    private static boolean terminado;
    
    //No estáticos
    private ArrayList<Persona> usuarios;
    
    /*-----CONSTRUCTOR-----*/
    public Gestor(){
        terminado = false;
        usuarios = new ArrayList<>();
        usuarios.add(new Persona("Mario Vivas", "Mario", "abcd", "123456t"));
    }
    
    /*-----MÉTODOS-----*/
    public boolean login(){     
        boolean exito = false;
        boolean aux = false;
        String nombre, contrasenya;
        
        try{
            out.print("\nMenu de login (escribir \"salir\" para salir de la "
                + "aplicación)\nNombre: ");
            nombre = in.readLine();
            
            //Comprobar salida
            if (nombre.compareToIgnoreCase("salir") == 0){
                out.println("Hasta pronto!");
                terminado = true;
                return false;
            }
            
            //Buscar usuario y comprobar login
            for(int i = 0; i < usuarios.size() && !aux; i++){
                if (usuarios.get(i).getLogin().compareTo(nombre) == 0){
                    exito = usuarios.get(i).login();
                    aux = true;
                }
            }
            
            //Mostrar información de logeo
            if (aux)
                if (exito)
                    out.println("Logeado correctamente\nIniciando sesion...");              
                else
                    out.println("La contraseña introducida no es correcta");
            else
                out.println("El nombre introducido no se encuentra en la lista"
                    + " de usuarios");                                  
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
        
        return exito;
    }
    
    public void run(){
        boolean exitoLogin = false;
        
        while(!terminado){
            exitoLogin = login();
            if(exitoLogin){
                out.println("Sesion iniciada");
            }
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
