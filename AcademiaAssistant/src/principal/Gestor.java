package principal;

import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Clase que controla la gestión de los usuarios y sus métodos
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
    private Persona usuarioActual;
    
    /*-----CONSTRUCTOR-----*/
    /**
     * Constructor que inicializa la clase gestor
     */
    public Gestor(){
        terminado = false;
        usuarios = new ArrayList<>();
        //usuarios.add(new Alumno("Mario Vivas", "Mario", "abcd", "123456t"));
        usuarios.add(new Profesor("Rosa", "Rosa", "abcd", "101010j", this));
        //usuarios.add(new Delegado("Delegado", "Alberto", "abcd", "103023i"));
    }
    
    /*-----MÉTODOS-----*/
    /**
     * Método que simula un menú de login pidiendo nombre, contraseña y 
     * comprobando si es verificable en la base de datos de usuarios
     * @return true en caso de login con exito, false en caso contrario
     */
    public boolean login(){     
        boolean exito = false;
        boolean aux = false;
        int i;
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
            for(i = 0; i < usuarios.size() && !aux; i++){
                if (usuarios.get(i).getLogin().compareTo(nombre) == 0){
                    exito = usuarios.get(i).login();
                    aux = true;
                    break;
                }
            }
            
            //Mostrar información de logeo
            if (aux)
                if (exito){
                    usuarioActual = usuarios.get(i);
                    out.println("Logeado correctamente\nIniciando sesion con "
                        + "el usuario " + usuarioActual.getNombre());
                }
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
    
    /**
     * Método que lanza la aplicación de gestor
     */
    public void run(){
        boolean exitoLogin = false;
        
        while(!terminado){
            exitoLogin = login();
            if(exitoLogin){
                gestionCuenta ();
            }
        }
    }
    
    /**
     * Método que simula el panel de control y gestión de un usuario una vez
     * que ha logeado con éxito
     */
    public void gestionCuenta (){
        boolean terminado = false;
        int opcion;
        
        while(!terminado){
            try{
                usuarioActual.mostrarMenu();
                opcion = Integer.parseInt(in.readLine());
                terminado = usuarioActual.gestionMenu(opcion);
            }
            catch(Exception e){
                out.println("Error: " + e.getMessage());
            }
        }
        
        out.println("Saliendo del panel de control");
    }
    
    /**
     * Método principal que carga la aplicación, instancia un gestor y lo lanza
     * @param args argumentos por la linea de comandos
     */
    public static void main(String[] args) {

        Gestor g = new Gestor();
        g.run();
    }
    
    /*-----SETTERS-----*/
    
    /*-----GETTERS----*/
    /**
     * Método que obtiene la lista de usuarios del gestor
     * @return lista de usuarios
     */
    public ArrayList<Persona> getUsuarios(){
        return usuarios;
    }
    
}
