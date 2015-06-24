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
    
    public Asignatura (String nombre){
        this.nombre = nombre;
        examenes = new ArrayList<>();
        nota = 0;
    }
}
