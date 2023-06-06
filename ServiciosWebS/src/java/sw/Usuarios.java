/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

/**
 *
 * @author HP
 */
public class Usuarios {

    String usuario;
    String password;


    public Usuarios() {
    }

    public Usuarios(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
