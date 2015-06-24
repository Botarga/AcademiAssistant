package principal;

import java.io.*;

/**
 *
 * @author botarga
 */
public class Persona {
    /*-----ATRIBUTOS-----*/
    //Estáticos
    private static BufferedReader in = 
        new BufferedReader(new InputStreamReader(System.in));
    
    //No Estáticos
    private String nombre;
    private String dni;
    private String login;
    private String contrasenya;
    
    /*-----CONSTRUCTORES-----*/
    public Persona (String nombre, String login, String contrasenya, String dni){
        this.nombre = nombre;
        this.login = login;
        this.contrasenya = contrasenya;
        this.dni = dni;
    }
    
    /*-----MÉTODOS-----*/
    public boolean login (){
        String aux;
        boolean exito = false;
        
        try{
            System.out.println("Contraseña: ");
            aux = in.readLine();
            if (aux.compareTo(contrasenya) == 0)
                exito = true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return exito;
    }
    
    /*-----SETTERS-----*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDni(String dni){
        this.dni = dni;
    }   
    public void setLogin (String login){
        this.login = login;
    } 
    public void setContrasenya (String contrasenya){
        this.contrasenya = contrasenya;
    }
    
    /*-----GETTERS-----*/
    public String getNombre(){
        return nombre;
    }
    public String getDni(){
        return dni;
    }
    public String getLogin(){
        return login;
    }
    public String getContrasenya(){
        return contrasenya;
    }
}
