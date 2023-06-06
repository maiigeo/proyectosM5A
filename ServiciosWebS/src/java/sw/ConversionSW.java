/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HP
 */
@WebService(serviceName = "ConversionSW")
public class ConversionSW {

    ArrayList<Usuarios> lisUsuarios = new ArrayList<>();
    
    Usuarios usuarios;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "euroAdolar")
    public Double euroAdolar(@WebParam(name = "euros") double euros) {
        //TODO write your implementation code here:
        return euros*1.15;
    }
    


    @WebMethod(operationName = "Ingresar")
    public String ingresar(@WebParam(name = "usuario") String user, @WebParam(name = "contrase") String password) {

        String mensaje = null;
        usuarios = new Usuarios("Marilyn","maii");
        lisUsuarios.add(usuarios);
        for (int i = 0; i < lisUsuarios.size(); i++) {
            if (lisUsuarios.get(i).getUsuario().equals(user)) {
                if (lisUsuarios.get(i).getUsuario().equals(user) && lisUsuarios.get(i).getPassword().equals(password)) {
                    mensaje = "Inicio sesión correctamente";
                } else {
                    mensaje = "Contraseña no coincide con su registro ";
                }
            } else {
                mensaje = "Este usuario no existe";
            }

        }
        return mensaje;

    }


    
    @WebMethod(operationName = "Sumar")
    public String Sumar(@WebParam(name = "Dato1") Double dato1, @WebParam(name = "Dato 2") Double dato2) {
        String mensaje = null;
        Double datos = dato1 + dato2;
        mensaje="La suma de sus datos es "+datos;
        
        return mensaje;
    
   }
    
    
    
}
