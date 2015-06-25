package principal;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 * <h1>Clase Delegado</h1>
 * Gestiona métodos específicos de un delegado
 * @author botarga
 */
public class Delegado extends Alumno{
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado de la clase Delegado
     * @param nombre nombre del delegado
     * @param login nombre de login del delegado
     * @param contrasenya contraseña del delegado
     * @param dni dni del delegado
     */
    public Delegado(String nombre, String login, String contrasenya, String dni
            , ArrayList<Asignatura>asignaturas){
        super(nombre, login, contrasenya, dni, asignaturas);
    }
    
    
    /*-----MÉTODOS-----*/
    /**
     * Método que muestra el menu de usuario de un delegado
     */
    @Override
    public void mostrarMenu (){
        out.println("\nPanel de control del delegado " + nombre);
        out.println("1. Mirar notas de asignatura");
        out.println("2. Mirar test pendientes");
        out.println("3. Mirar notas de test");
        out.println("4. Mostrar datos de alumno");
        out.println("5. Notificar faltas de asistencia");
        out.println("6. Salir");
        out.print("Introduce una opcion: ");
    }
    
    /**
     * Método que gestiona las opciones posibles de un menu para el usuario
     * delegado
     * @param opcion opción escogida en el menú
     * @return true si el usuario decide salir del menú, false en caso contrario
     */
    @Override
    public boolean gestionMenu(int opcion) {
        boolean resultado = false;
        
        switch(opcion){
            case 1:
                break;
                
            case 2:
                break;
                
            case 3:
                break;
                
            case 4:
                break;
                
            case 5:
                break;
                
            case 6:
                resultado = true;
                break;
            default: break;
        }
        
        return resultado;
    }
}
