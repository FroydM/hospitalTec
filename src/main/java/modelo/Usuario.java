/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author march
 */
public class Usuario extends Persona{
    private int user;
    private String password;

    public Usuario() {
        super();
        this.user = 0;
        this.password = "";
    }
    
    public Usuario(int user, String password) {
        super();
        this.user = user;
        this.password = password;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
