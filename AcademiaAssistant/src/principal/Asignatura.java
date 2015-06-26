package principal;

import java.util.ArrayList;

/**
 * Clase que gestiona información de una asignatura
 * @author botarga
 */
public class Asignatura {
    /*-----ATRIBUTOS-----*/
    private String nombre;
    private ArrayList<Test> examenes;
    private float nota;
    private int numNotas;
    
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado que inicializa la clase asinatura
     * @param nombre nombre de la asignatura
     */
    public Asignatura (String nombre){
        this.nombre = nombre;
        examenes = new ArrayList<>();
        nota = numNotas = 0;
    }
    
    
    /*-----MÉTODOS-----*/
    /**
     * Método que añade un examen a la lista de examenes que tenga el alumno
     * en una asignatura
     * @param e examen nuevo para añadir a la asignatura
     */
    public void anyadirTest (Test e){
        e.setAsignaturaPert(this);
        examenes.add(e);
    }
    
    /**
     * Método que actualiza la nota de la asignatura calculando la media
     * @param notaNueva nota nueva para la asignatura
     */
    public void anyadirNota (float notaNueva){
        nota = ((nota * numNotas) + notaNueva) / (numNotas+1);
        numNotas++;
    }
    
    
    /*-----SETTERS-----*/
    
    
    /*-----GETTERS-----*/
    /**
     * Método para obtener el valor del atributo nombre
     * @return nombre de la asignatura
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Método que devuelve el valor del atributo nota
     * @return valor del atributo nota
     */
    public float getNota(){
        return nota;
    }
    /**
     * Método que devuelve el valor del atributo examenes
     * @return examenes de la asignatura
     */
    public ArrayList<Test> getExamenes(){
        return examenes;
    }
}
