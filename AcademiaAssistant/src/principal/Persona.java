package principal;

import java.io.*;

/**
 * <h1>Clase Persona</h1>
 * Guarda y administra datos básicos de una persona como usuario en el sistema
 * @author botarga
 */
public abstract class Persona {
    /*-----ATRIBUTOS-----*/
    //Estáticos
    private static BufferedReader in = 
        new BufferedReader(new InputStreamReader(System.in));
    
    //No Estáticos
    protected String nombre;
    protected String dni;
    protected String login;
    protected String contrasenya;
    
    
    /*-----CONSTRUCTORES-----*/
    /**
     * Constructor parametrizado de la clase Persona
     * @param nombre nombre de la persona
     * @param login nombre de login de la persona
     * @param contrasenya contraseña de la 
     * @param dni dni de la persona
     */
    public Persona (String nombre, String login, String contrasenya, String dni){
        this.nombre = nombre;
        this.login = login;
        this.contrasenya = contrasenya;
        this.dni = dni;
    }
    
    
    /*-----MÉTODOS-----*/
    /**
     * Método que comprueba una identificación del usuario preguntado su 
     * contraseña
     * @return true en caso de login correcto, false en caso contrario
     */
    public boolean login (){
        String aux;
        boolean exito = false;
        
        try{
            System.out.print("Contraseña: ");
            aux = in.readLine();
            if (aux.compareTo(contrasenya) == 0)
                exito = true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return exito;
    }
    
    //Abstractos
    /**
     * Método abstracto redefinido por clases hijas para mostrar el menu de 
     * usuario
     */
    public abstract void mostrarMenu();
    /**
     * Método abstracto redefinido por clases hijas para gestionar el menu de
     * usuario
     * @param opcion dependiente de la implementación de las hijas
     * @return dependiente de la implementación de las hijas
     */
    public abstract boolean gestionMenu(int opcion);
    
    
    /*-----SETTERS-----*/
    /**
     * Método para establecer el valor de la variable nombre
     * @param nombre nuevo valor de la variable nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Método para establecer el valor de la variable dni
     * @param dni nuevo valor de la variable dni
     */
    public void setDni(String dni){
        this.dni = dni;
    }   
    /**
     * Método para establecer el valor de la variable login
     * @param login nuevo valor de la variable login
     */
    public void setLogin (String login){
        this.login = login;
    } 
    /**
     * Método para establecer el valor de la variable contrasenya
     * @param contrasenya nuevo valor de la variable contrasenya
     */
    public void setContrasenya (String contrasenya){
        this.contrasenya = contrasenya;
    }
    
    
    /*-----GETTERS-----*/
    /**
     * Método que devuelve el valor del atributo nombre
     * @return valor del atributo nombre
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Método que devuelve el valor del atributo dni
     * @return valor del atributo dni
     */
    public String getDni(){
        return dni;
    }
    /**
     * Método que devuelve el valor del atributo login
     * @return valor del atributo login
     */
    public String getLogin(){
        return login;
    }
    /**
     * Método que devuelve el valor del atributo contrasenya
     * @return valor del atributo contrasenya
     */
    public String getContrasenya(){
        return contrasenya;
    }
}
