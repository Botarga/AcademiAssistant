package principal;

import static java.lang.System.out;

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
        out.println("\nPanel de control del profesor " + nombre);
        out.println("1. Mirar lista de alumnos");
        out.println("2. Mirar informacion de alumno");
        out.println("3. Preparar test");
        out.println("4. Matricular alumno");
        out.println("5. Desmatricular alumno");
        out.println("6. Salir");
        out.print("Introduce una opcion: ");
    }
    
    @Override
    /**
     * Método que gestiona las opciones posibles de un menu para el usuario
     * profesor
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
                break;
                
            case 6:
                resultado = true;
                break;
            default: break;
        }
        
        return resultado;
    }
}
