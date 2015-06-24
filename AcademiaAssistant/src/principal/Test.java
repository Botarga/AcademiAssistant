package principal;

import java.util.ArrayList;
/**
 *
 * @author botarga
 */
public class Test {
    /*-----ATRIBUTOS-----*/
    private String nombre;
    private int calificacion;
    private Asignatura asignaturaPert;
    private ArrayList<Pregunta> preguntas;
    
    private class Pregunta{
        private String enunciado;
        private ArrayList<String>opciones;
        private int correcta;
        
        public Pregunta (String enunciado, ArrayList<String> opciones
            , int correcta){
            this.enunciado = enunciado;
            this.opciones = opciones;
            this.correcta = correcta;
        }
    }
    
    
    /*-----CONSTRUCTORES-----*/
    public Test (Asignatura a, String nombre){
        asignaturaPert = a;
        this.nombre = nombre;
        preguntas = new ArrayList<>();
    }
    
    
    /*------MÉTODOS------*/
    public void crear (){
        
    }
    
    
    /*-----SETTERS----*/
    
    
    /*-----GETTERS----*/
    /**
     * Método que devuelve el valor del atributo nombre
     * @return nombre del examen
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Método que devuelve el valor del atributo califiación
     * @return calificación del examen
     */
    public int getCalificacion (){
        return calificacion;
    }
}
