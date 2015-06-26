package principal;

import java.util.ArrayList;
import static java.lang.System.out;
import java.io.*;

/**
 * Clase que gestiona un examen que crearan profesores y resuelven alumnos
 * @author botarga
 */
public class Test {
    /*-----ATRIBUTOS-----*/
    //Estáticos
    private static BufferedReader in =
        new BufferedReader(new InputStreamReader(System.in));
    
    //No estáticos
    private String nombre;
    private float calificacion;
    private boolean resuelto;
    private Asignatura asignaturaPert;
    private ArrayList<Pregunta> preguntas;
    
    private class Pregunta{
        private String enunciado;
        private ArrayList<String>opciones;
        private int correcta;
        
        /**
         * Constructor parametrizado que inicializa la clase Pregunta
         * @param enunciado enunciado de la pregunta
         * @param opciones contenido de las opciones
         * @param correcta respuesta correcta
         */
        public Pregunta (String enunciado, ArrayList<String> opciones
            , int correcta){
            this.enunciado = enunciado;
            this.opciones = opciones;
            this.correcta = correcta;
        }
    }
    
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado que inicializ la clase Test
     * @param nombre nombre que da titulo al examen
     */
    public Test (String nombre){
        this.nombre = nombre;
        preguntas = new ArrayList<>();
        resuelto = false;
    }
    /**
     * Constructor copia
     * @param t test para copiar
     */
    public Test (Test t){
        this.nombre = t.getNombre();
        this.calificacion = t.getCalificacion();
        this.resuelto = t.getResuelto();
        this.asignaturaPert = t.getAsignaturaPert();
        this.preguntas = t.getPreguntas();
    }
    
    /*-----MÉTODOS------*/
    /**
     * Método auxiliar para mostrar el contenido del examen usado para debug
     */
    public void mostrarExamen (){
        out.println("Se va a mostrar informacion del examen");
        out.println("Asignatura: " + asignaturaPert.getNombre());
        out.println("Titulo: " + nombre);
        out.println("Numero de preguntas: " + preguntas.size());
        
        for(Pregunta p : preguntas){
            out.println("Enunciado: " + p.enunciado);
            for(String opc : p.opciones){
                out.println("\t" + opc);
            }
        }
    }
    
    /**
     * Método para crear el contenido de un examen
     */
    public void crear (){
        int n, numOpciones, correcta;
        String enunciado;
        ArrayList<String> opciones = new ArrayList<>();
        
        try{
            out.println("Introduce el numero de preguntas del test");
            n = Integer.parseInt(in.readLine());
            
            for(int i = 0; i < n; i++){
                opciones.clear();
                
                out.println("Pregunta " + (i+1) + " de " + n);
                out.println("Introduce el enunciado de la pregunta");
                enunciado = in.readLine();
                out.println("Introduce el numero de opciones");
                numOpciones = Integer.parseInt(in.readLine());
                
                for(int j = 0; j < numOpciones; j++){
                    out.println("Opcion " + (j+1) + " de " + numOpciones);
                    out.println("Introduce contenido de la opcion");
                    opciones.add(in.readLine());
                }
                
                out.println("Introduce el numero de la opcion correcta (1-" +
                    numOpciones + ")");
                do{
                    correcta = Integer.parseInt(in.readLine());
                }while(correcta <= 0 || correcta > numOpciones);
                
                preguntas.add(new Pregunta(enunciado
                        , (ArrayList<String>)opciones.clone(), correcta));               
            }
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Método para resolver un examen y guardar los resultados
     */
    public void resolver (){
        int opcion;
        
        try{
            out.println("Test: " + nombre);
            out.println("Asignatura: " + asignaturaPert.getNombre());
            out.println("Número de preguntas: " + preguntas.size());

            for(int i = 0; i < preguntas.size(); i++){
                out.println("Pregunta " + (i+1) + " de " + preguntas.size());
                out.println("Enunciado:\n" + preguntas.get(i).enunciado);
                
                //Imprimir opciones
                for(int j = 0; j < preguntas.get(i).opciones.size(); j++){
                    out.println("\t" + (j+1) + ": " + preguntas.get(i)
                        .opciones.get(j));
                }
                
                out.println("Escoge una opcion (1-" + preguntas.get(i).opciones
                    .size() + ")");
                opcion = Integer.parseInt(in.readLine());
                if (opcion == preguntas.get(i).correcta){
                    out.println("Respuesta correcta!");
                    calificacion++;
                }
                else{
                    out.println("Respuesta incorrecta");
                    int correcta = preguntas.get(i).correcta;
                    out.println("La respuesta correcta era " + preguntas.get(i)
                        .opciones.get(correcta-1));
                }
            }
            out.println("Fin del examen");
            out.println("Respuestas acertadas " + (int)calificacion + "/" 
                + preguntas.size());
            calificacion = calificacion * 10 / preguntas.size();
            out.println("La nota final es " + calificacion);
            asignaturaPert.anyadirNota(calificacion);
        }
        catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
    
    
    /*-----SETTERS-----*/
    /**
     * Método para asignar un valor al atributo asignatura
     * @param a valor nuevo para el atributo asignatura
     */
    public void setAsignaturaPert (Asignatura a){
        asignaturaPert = a;
    }
    
    
    /*-----GETTERS-----*/
    /**
     * Método que devuelve el valor del atributo nombre
     * @return nombre del examen
     */
    public String getNombre (){
        return nombre;
    }
    /**
     * Método que devuelve el valor del atributo califiación
     * @return calificación del examen
     */
    public float getCalificacion (){
        return calificacion;
    }
    /**
     * Método que devuelve el valor del atributo resuelto
     * @return valor resuelto del examen 
     */
    public boolean getResuelto (){
        return resuelto;
    }
    /**
     * Método que devuelve el valor del atributo AsignaturaPert
     * @return asignatura perteneciente al examen
     */
    public Asignatura getAsignaturaPert (){
        return asignaturaPert;
    }
    /**
     * Método que devuelve el valor del array list preguntas
     * @return preguntas del test
     */
    public ArrayList<Pregunta> getPreguntas(){
        return preguntas;
    }
}
