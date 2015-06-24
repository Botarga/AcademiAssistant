package principal;

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
    public Delegado(String nombre, String login, String contrasenya, String dni){
        super(nombre, login, contrasenya, dni);
    }

}
