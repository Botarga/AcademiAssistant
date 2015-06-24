package principal;

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
        //TODO
    }
    

}
