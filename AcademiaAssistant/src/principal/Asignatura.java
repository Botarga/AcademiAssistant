package principal;

import java.util.ArrayList;

/**
 *
 * @author botarga
 */
public class Asignatura {
    private String nombre;
    private ArrayList<Test> examenes;
    private int nota;
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado que inicializa la clase asinatura
     * @param nombre nombre de la asignatura
     */
    public Asignatura (String nombre){
        this.nombre = nombre;
        examenes = new ArrayList<>();
        nota = 0;
    }
    
    /*-----MÉTODOS-----*/
    /**
     * Método que añade un examen a la lista de examenes que tenga el alumno
     * en una asignatura
     * @param e examen nuevo para añadir a la asignatura
     */
    public void anyadirTest (Test e){
        examenes.add(e);
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
    public int getNota(){
        return nota;
    }
    public ArrayList<Test> getExamenes(){
        return examenes;
    }
}
