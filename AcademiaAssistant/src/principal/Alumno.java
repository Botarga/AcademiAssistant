package principal;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 * <h1>Clase Alumno</h1>
 * Establece métodos específicos de un alumno
 * @author botarga
 */
public class Alumno extends Persona{
    /*-----ATRIBUTOS-----*/
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Test> examenesPendientes;
    private ArrayList<Test> examenesResueltos;
    
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado de la clase Alumno
     * @param nombre nombre del alumno
     * @param login nombre de login del alumno
     * @param contrasenya contraseña del alumno
     * @param dni dni del delegado alumno
     */
    public Alumno (String nombre, String login, String password, String dni
            , ArrayList<Asignatura> asignaturas){
        super(nombre, login, password, dni);
        this.asignaturas = asignaturas;
        examenesPendientes = new ArrayList<>();
        examenesResueltos = new ArrayList<>();
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
                mirarNotas();
                break;
                
            case 2:
                mirarTestPendientes();
                break;
                
            case 3:
                mirarNotasTest();
                break;
                
            case 4:
                mostrarInformacionAlumno();
                break;
                
            case 5:
                out.println("Saliendo...");
                resultado = true;
                break;
            default: break;
        }
        
        return resultado;
    }
    
    /**
     * Método que añade un examen a la lista de examenes pendientes
     * @param t examen para añadir
     */
    public void anyadirExamen(Test t){
        examenesPendientes.add(t);
    }
    
    /**
     * Método que muestra las asignaturas con su nota
     */
    public void mirarNotas(){
        out.println("Asignaturas con su nota");
        
        for(Asignatura a : asignaturas)
            out.println(a.getNombre() + "\tNota: " + a.getNota());    
    }
    
    /**
     * Método que muestra los examenes pendientes
     */
    public void mirarTestPendientes(){
        if (examenesPendientes.size() > 0){
            out.println("Tienes " + examenesPendientes.size() + " examenes "
                + "pendientes");
            for(int i = 0; i < examenesPendientes.size(); i++){
                out.println((i+1) + ": " + examenesPendientes.get(i).getNombre());
            }
        }
        else{
            out.println("Actualmente no tienes ningun test pendiente");
        }
    }
    
    /**
     * Método que muestra todos los tests resueltos y sus respectivas notas
     */
    public void mirarNotasTest(){
        if (examenesResueltos.size() > 0){
            out.println("Test resueltos:");
            
            for(Asignatura as : asignaturas){
                out.println("Asignatura: " + as.getNombre());
               for(Test t : examenesResueltos)
                   out.println("\tTitulo: " + t.getNombre() + "\tNota: " + t.getCalificacion());               
            }

        }
        else
            out.println("Actualmente no tienes ningun examen resuelto");       
    }
    
    /**
     * Método que muestra información completa sobre el alumno
     */
    public void mostrarInformacionAlumno(){
        Asignatura aux;
        
        //Mostrar datos del alumno
        out.println("Datos del alumno " + nombre);
        out.println("Nombre: " + nombre);
        out.println("Usuario de login: " + login);
        out.println("DNI: " + dni);

        out.println("Información de sus asignaturas");
        for(int i = 0; i < asignaturas.size(); i++){
            aux = asignaturas.get(i);
            out.println(aux.getNombre());
            out.println("\tNota de asignatura: " + aux.getNota());

            out.println("\tExamenes de la asignatura");
            for(int j = 0; j < aux.getExamenes().size(); j++){
                out.print("\t\tTitulo: " + aux.getExamenes().get(j)
                    .getNombre() + "\tCalificacion: " + 
                    aux.getExamenes().get(j).getCalificacion());
            }                    
        }
    }
    
    /*-----SETTERS-----*/
    
    
    /*-----GETTERS-----*/
    public ArrayList<Asignatura> getAsignaturas(){
        return asignaturas;
    }
}
