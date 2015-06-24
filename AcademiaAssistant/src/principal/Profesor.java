package principal;

/**
 * <h1>Clase Profesor</h1>
 * Gestiona métodos específicos de un profesor
 * @author botarga
 */
public class Profesor extends Persona{
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado de la clase Profesor
     * @param nombre nombre del profesor
     * @param login nombre de login del profesor
     * @param contrasenya contraseña del profesor
     * @param dni dni del profesor
     */
    public Profesor (String nombre, String login, String password, String dni){
        super(nombre, login, password, dni);
    }
    
    /*-----MÉTODOS-----*/
    @Override
    /**
     * Método que muestra el menú de usuario de un profesor
     */
    public void mostrarMenu() {
        //TODO
    }
}
