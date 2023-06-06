/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static java.time.Clock.system;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Servidor {

    private int puerto;
    private ServerSocket server;

    public Servidor(int puerto) {
        this.puerto = puerto;
        try {
            server = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Servidor servi = new Servidor(3600);

        try {
            Socket sock = servi.getServer().accept();
            DataInputStream ingreso;
            DataOutputStream salida;
            ingreso = new DataInputStream(sock.getInputStream());
            salida = new DataOutputStream(sock.getOutputStream());

            salida.writeUTF("salida aceptada");//envio
            Scanner sc = new Scanner(System.in);

            Map<String, String> menu = new HashMap<String, String>();
            menu.put("HOLA", "Bienvenido al restaurante Maii, en qué te podemos ayudar?\n" + "-----Menú-----\n" + "---Reservas--- ");
            menu.put("MENU", " Ingresa lo que deseas:\n"+"Desayunos\n " + "Almuerzos\n " + "Meriendas\n");
            menu.put("DESAYUNOS", " Café con pan y mermelada, acompañado de jugo de naranja Costo:$3,80\n" + " Tostada con queso y chocolate americano Costo:$2,70\n"+ " Si desear reservar escribe la  palabra RESERVAR");
            menu.put("ALMUERZOS", " Pollo broster con menestra y ensalada de lechuga Costo:$5.30\n" + " Carne frita acompañada de platanos fritos y ensalada de col morada Costo:$3,80 \n"+ " Si desear reservar escribe la  palabra RESERVAR");
            menu.put("MERIENDAS", " Enrollado de pavo con aguacate Costo:4,70\n" + " Pollo en salsa de champiñones Costo:$5,60\n"+ " Si desear reservar escribe la  palabra RESERVAR");
            menu.put("GRACIAS", "Es un placer atendenderte, vuelve cuando gustes");
            menu.put("INFORMACIÓN", "Bienvenido querido usuario somos un restaurante Cuencano que estamos encantados de servirte puedes observar nuestro 1.menú o 2.reservaciones ");
            menu.put("CHAO", "Vuelve cuando gustes, te esperamos");
            menu.put("RESERVAS", "Si deseas reservar puedes escribir la hora para la que deseas:Día,Tarde,Noche ");
            menu.put("DIA", "Puedes observar nuestras opciones de desayunos escribiendo la palabra desayunos" + " Si desear reservar escribe la  palabra RESERVAR");
            menu.put("TARDE", "Puedes observar nuestras opciones de almuerzos escribiendo la palabra almuerzos " + " Si desear reservar escribe la  palabra RESERVAR");
            menu.put("NOCHE", "Puedes observar nuestras opciones de meriendas escribiendo la palabra meriendas " + " Si desear reservar escribe la  palabra RESERVAR");
            menu.put("", "Aún no haz realizado tu consulta, " + "Puedes consultar un Menú o Reservas");
            menu.put("RESERVAR", "Haz realizado tu reserva éxitosamente, puedes acercarte a nuestra sucursal a confirmar tu reserva.Gracias");
            menu.put("DIRECCION", "Estamos ubicados en la Av.Ordoñez Lazo y César Andrade y Cordero, te esperamos");
            menu.put("ADIOS", "Vuelve cuando gustes, te esperamos");
            menu.put("OK", "Encantados de ayudarte, vuelve cuando gustes");
            menu.put("NO", "Entendemos tu respuesta,gracias");
            menu.put("SI", "Prueba escribiendo la palabra reservar");
            //salida.writeUTF(String.valueOf(menu.keySet()));//envio
            salida.writeUTF("Bienvenido");//envio
            while (true) {
                String palabra = ingreso.readUTF();//recibo
                boolean val = false;
                for (Map.Entry<String, String> entry : menu.entrySet()) {
                    String llave = entry.getKey();

                    if (llave.equalsIgnoreCase(palabra)) {
                        salida.writeUTF(entry.getValue());//envio
                        val = true;
                        break;
                    }if(val==false){
                        salida.writeUTF("No encontramos la consulta que ingresaste, prueba con la palabra menu o reservas");//envio
                    }

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
