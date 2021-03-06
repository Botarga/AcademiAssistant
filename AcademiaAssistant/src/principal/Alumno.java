package principal;

import static java.lang.System.out;
import java.util.ArrayList;
import java.io.*;

/**
 * <h1>Clase Alumno</h1>
 * Establece métodos específicos de un alumno
 * @author botarga
 */
public class Alumno extends Persona{
    /*-----ATRIBUTOS-----*/
    //Estáticos
    private static BufferedReader in
            = new BufferedReader(new InputStreamReader(System.in));
    
    //No estáticos
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
    /**
     * Método que muestra el menu de un alumno
     */
    @Override
    public void mostrarMenu() {
        out.println("\nPanel de control del alumno " + nombre);
        out.println("1. Mirar notas de asignatura");
        out.println("2. Mirar test pendientes");
        out.println("3. Mirar notas de test");
        out.println("4. Mostrar datos de alumno");
        out.println("5. Resolver test pendiente");
        out.println("6. Salir");
        out.print("Introduce una opcion: ");
    }

    /**
     * Método que gestiona las opciones posibles de un menu para el usuario
     * alumno
     * @param opcion opcion que se ha escogido
     * @return true si el usuario decidió salir false en caso contrario
     */
    @Override
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
                resolverTest();
                break;
                
            case 6:
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
    public void anyadirExamen(Test t, String asignatura){
        for(int i = 0; i < asignaturas.size(); i++){
            if (asignaturas.get(i).getNombre().compareToIgnoreCase(asignatura) == 0){;
                t.setAsignaturaPert(asignaturas.get(i));
                break;
            }
        }
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
            for(int i = 0; i < examenesPendientes.size(); i++)
                out.println((i+1) + ": " + examenesPendientes.get(i)
                    .getNombre());           
        }
        else
            out.println("Actualmente no tienes ningun test pendiente");       
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
                   out.println("\tTitulo: " + t.getNombre() + "\tNota: " 
                        + t.getCalificacion());               
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
            
            //Examenes resueltos de sus asignaturas
            out.println("\tExamenes de la asignatura resueltos");
            for(int j = 0; j < aux.getExamenes().size(); j++){
                if (aux.getExamenes().get(j).getResuelto()){
                    out.println("\t\tTitulo: " + aux.getExamenes().get(j)
                        .getNombre() + "\tCalificacion: " + 
                        aux.getExamenes().get(j).getCalificacion());
                }
            }                    
        }
    }
    
    /**
     * Método que resuelve un examen pendiente elegido por el alumno
     */
    public void resolverTest(){
        int opcion;
        
        try{
            if (examenesPendientes.size() > 0){
                out.println("Introduce el numero de examen pendiente que "
                    + "quieras resolver: (0: salir, (1-" 
                    + examenesPendientes.size() + "))");
                do{
                    opcion = Integer.parseInt(in.readLine());
                }while(opcion < 0 || opcion > examenesPendientes.size());
                if (opcion != 0){
                    opcion--;
                    examenesPendientes.get(opcion).resolver();
                    examenesResueltos.add(examenesPendientes.get(opcion));
                    examenesPendientes.remove(opcion);
                }
            }
            else{
                out.println("Actualmente no tienes examenes por resolver");
            }
            out.println("Saliendo de la interfaz de examenes...");
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
    
    
    /*-----SETTERS-----*/
    
    
    /*-----GETTERS-----*/
    /**
     * Método que obtiene el valor del atributo asignaturas
     * @return asignaturas del alumno
     */
    public ArrayList<Asignatura> getAsignaturas(){
        return asignaturas;
    }
    /**
     * Método que devuelve el valor del atributo examenes pendientes
     * @return examenes pendientes del alumno
     */
    public ArrayList<Test> getExamenesPendientes(){
        return examenesPendientes;
    }
}
