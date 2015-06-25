package principal;

import static java.lang.System.out;
import java.util.ArrayList;
import java.io.*;

/**
 * <h1>Clase Profesor</h1>
 * Gestiona métodos específicos de un profesor
 * @author botarga
 */
public class Profesor extends Persona{
    /*-----ATRIBUTOS-----*/
    private Gestor gestorPert;
    private ArrayList<Alumno> alumnos;
    private static BufferedReader in = 
            new BufferedReader(new InputStreamReader(System.in));
    
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado de la clase Profesor
     * @param nombre nombre del profesor
     * @param login nombre de login del profesor
     * @param contrasenya contraseña del profesor
     * @param dni dni del profesor
     */
    public Profesor (String nombre, String login, String password, String dni
            , Gestor g){
        super(nombre, login, password, dni);
        alumnos = new ArrayList<>();
        gestorPert = g;
    }
    
    
    /*-----MÉTODOS-----*/
    /**
     * Método que muestra el menú de usuario de un profesor
     */
    @Override
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
    
    /**
     * Método que gestiona las opciones posibles de un menu para el usuario
     * profesor
     * @param opcion opcion escogida en el menu
     * @return true si se quiere salir del menu, false en caso contrario
     */
    @Override
    public boolean gestionMenu(int opcion) {
        boolean resultado = false;
        
        switch(opcion){
            case 1:
                mostrarAlumnos();
                break;
                
            case 2:
                mostrarAlumno();
                break;
                
            case 3:
                prepararTest();
                break;
                
            case 4:
                matricularAlumno();
                break;
                
            case 5:
                desmatricularAlumno();
                break;
                
            case 6:
                resultado = true;
                break;
            default: break;
        }
        
        return resultado;
    }
    
    /**
     * Método que muestra la lista completa de alumnos del profesor identificados
     * con un número
     */
    public void mostrarAlumnos (){
        if (alumnos.size() > 0){
            out.println("LISTA DE ALUMNOS");
            for(int i = 0; i < alumnos.size(); i++)
                out.println((i+1) + ": " + alumnos.get(i).getNombre());     
        }
        else
            out.println("Actualmente no tienes ningun alumno " + nombre);       
    }
    
    /**
     * Método que muestra detalladamente información específica de un alumno
     */
    public void mostrarAlumno(){
        int opcion;
        Asignatura aux;
        
        if (alumnos.size() > 0){
            out.println("Introduce el numero del alumno para mostrar informacion"
                + " (1-" + alumnos.size() + ")");
            
            try{
                //Pedir número de alumno comprobando validez
                do{
                    opcion = Integer.parseInt(in.readLine());
                }while(opcion <= 0 || opcion > alumnos.size());
                
                opcion--;
                alumnos.get(opcion).mostrarInformacionAlumno();
            }
            catch(Exception e){
                out.println("Error: " + e.getMessage());
            }
        }
        else
            out.println("Actualmente no tienes ningun alumno matriculado");
    }
    
    /**
     * Método para matricular a un alumno con sus datos y asignaturas
     */
    public void matricularAlumno(){
        boolean correcto;
        String nombre, login, contrasenya = "", dni = "", nombreAsignatura;
        int numeroAsignaturas;
        ArrayList<Asignatura>asignaturas = new ArrayList<>();
        out.println("INTERFAZ DE MATRICULACIÓN DE ALUMNO");
        
        try{
            do{
                correcto = true;
                out.println("Introduce el nombre del nuevo alumno");
                nombre = in.readLine();
                out.println("Introduce el nombre de login del nuevo alumno");
                login = in.readLine();
                
                if (login.compareToIgnoreCase("salir") == 0){
                    out.println("El nombre del usuario no puede ser salir");
                    correcto = false;
                    continue;
                }
                
                //Comprobar que ya existe el usuario tanto en nombre como login              
                for(int i = 0; i < gestorPert.getUsuarios().size() && correcto; i++){
                    if (gestorPert.getUsuarios().get(i).getNombre().compareTo(nombre) == 0
                            || gestorPert.getUsuarios().get(i).getLogin()
                            .compareTo(login) == 0){
                        out.println("El nombre de usuario introducido o login "
                            + "ya esta registrado");
                        correcto = false;
                    }
                }
                
                //Si todo va bien seguimos pidiendo datos
                if (correcto){
                    out.println("Introduce la contraseña del alumno");
                    contrasenya = in.readLine();
                    out.println("Introduce el dni del alumno");
                    dni = in.readLine();
                    
                    out.println("Introduce el numero de asignaturas que tendra");
                    numeroAsignaturas = Integer.parseInt(in.readLine());
                    for(int i = 0; i < numeroAsignaturas; i++){
                        out.println("Introduce el nombre de la asignatura (" 
                            + (i+1) + " de " + numeroAsignaturas + ")");
                        asignaturas.add(new Asignatura(in.readLine()));
                    }
                }              
            }while(!correcto);
            
            if (correcto){
                Alumno alumnoAux = new Alumno(nombre, login, contrasenya, dni
                    , asignaturas);
                out.println("Usuario agregado con exito");
                alumnos.add(alumnoAux);
                gestorPert.getUsuarios().add(alumnoAux);
            }
            else{
                out.println("Error al agregar al usuario");
            }
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método que desmatricula a un alumno de su profesor y de la base de datos
     * del gestor
     */
    public void desmatricularAlumno(){
        int opcion;
        String aux;
        
        try{
            if (alumnos.size() > 0){
                out.println("Introduce el numero de alumno para desmatricular "
                + "( 0: salir, (1-" + alumnos.size() + ") )");
                do{
                    opcion = Integer.parseInt(in.readLine());
                }while(opcion < 0 || opcion > alumnos.size());
                
                if(opcion != 0){
                    opcion--;
                    out.println("Borrando al alumno..." 
                        + alumnos.get(opcion).getNombre());
                                       
                    //Borrar del gestor
                    for(int i = 0; i < gestorPert.getUsuarios().size(); i++){
                        aux = gestorPert.getUsuarios().get(i).getNombre();
                        if (aux.compareToIgnoreCase(alumnos.get(opcion)
                                .getNombre()) == 0)
                            gestorPert.getUsuarios().remove(i);                       
                    }
                    
                    //Borrar de alumnos
                    alumnos.remove(opcion);                        
                }
            }
            else{
                out.println("Actualmente no tienes alumnos para desmatricular");
            }
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para guiar al profesor por la creación de un test para sus alumnos
     */
    public void prepararTest(){
        String asignatura, titulo;
        Test testAux;
        int n;
        boolean exito = false;
        
        out.println("Interfaz de creacion de test");
        try{
            out.println("Introduce el nombre de la asignatura del test (\"salir\""
                + " para salir de la interfaz)");
            asignatura = in.readLine();
            
            if (asignatura.compareToIgnoreCase("salir") != 0){
                out.println("Introduce el titulo del test");
                titulo = in.readLine();
                testAux = new Test(titulo);
                testAux.crear();
                
                out.println("El test se añadirá a todos los alumnos matriculados"
                    + " en la asignatura " + asignatura);
                for (Alumno alumno : alumnos) {
                    for (int j = 0; j < alumno.getAsignaturas().size(); j++) {
                        if (alumno.getAsignaturas().get(j).getNombre()
                                .compareToIgnoreCase(asignatura) == 0) {                   
                            alumno.getAsignaturas().get(j).anyadirTest(new Test(testAux));
                            alumno.anyadirExamen(new Test(testAux));
                        }
                    }
                }
                
                exito = true;
            }
            
            if (exito)
                out.println("Examen creado con exito");            
            else
                out.println("Error al crear el examen");
            
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
            return;
        }
    }
}
