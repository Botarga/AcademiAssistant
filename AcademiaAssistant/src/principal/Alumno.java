package principal;

import static java.lang.System.out;

/**
 * <h1>Clase Alumno</h1>
 * Establece métodos específicos de un alumno
 * @author botarga
 */
public class Alumno extends Persona{
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado de la clase Alumno
     * @param nombre nombre del alumno
     * @param login nombre de login del alumno
     * @param contrasenya contraseña del alumno
     * @param dni dni del delegado alumno
     */
    public Alumno (String nombre, String login, String password, String dni){
        super(nombre, login, password, dni);
    }

    /*-----MÉTODOS-----*/
    @Override
    /**
     * Método que muestra el menu de usuario de un alumno
     */
    public void mostrarMenu() {
        out.println("\nPanel de control del alumno " + nombre);
        out.println("1. Mirar notas de asignatura");
        out.println("2. Mirar test pendientes");
        out.println("3. Mirar notas de test");
        out.println("4. Mostrar datos de alumno");
        out.println("5. Salir");
        out.print("Introduce una opcion: ");
    }

    @Override
    /**
     * Método que gestiona las opciones posibles de un menu para el usuario
     * alumno
     */
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
                out.println("Saliendo...");
                resultado = true;
                break;
            default: break;
        }
        
        return resultado;
    }

}
