/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HP
 */
@WebService(serviceName = "hotel")
public class hotel {
    
    HashMap<String, String>hoteles = new HashMap<>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "hotel")
    public String hotel(@WebParam(name = "Nombre") String Nombre) {
                String llave=null;
        String resultado=null;
        hoteles.put("Gran Fernando", "Dispone de 10 habitaciones y 5 disponibles /n"+" Habitación lujo tiene un costo de $1000 por dia /n"+" Habitación normal tiene un costo de $200 por dia/n");
        hoteles.put("Oro Verde", "Dispone de 500 habitaciones y 20 disponibles /n"+" Habitación lujo tiene un costo de $5000 por dia /n"+" Habitación normal tiene un costo de $500 por dia/n");
        hoteles.put("Diamante", "Dispone de 40 habitaciones y 10 disponibles /n"+" Habitación lujo tiene un costo de $400 por dia /n"+" Habitación normal tiene un costo de $100 por dia/n");
        hoteles.put("Gran Muralla", "Dispone de 20 habitaciones y 3 disponibles /n"+" Habitación lujo tiene un costo de $50 por dia /n"+" Habitación normal tiene un costo de $30 por dia/n");
        
        for (Map.Entry<String, String> entry : hoteles.entrySet()) {
            llave= entry.getKey();
            if(llave.equals(Nombre)){
                resultado=entry.getValue();
            }else{
                resultado="No se encuentra el hotel";
            }
            
        }
        return resultado;
        
    }
}
