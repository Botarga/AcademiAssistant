package principal;

import java.util.ArrayList;
/**
 *
 * @author botarga
 */
public class Test {
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
    public Test (Asignatura a){
        asignaturaPert = a;
        preguntas = new ArrayList<>();
    }
    
    /*------MÉTODOS------*/
    public void crear (){
        
    }
    
}
