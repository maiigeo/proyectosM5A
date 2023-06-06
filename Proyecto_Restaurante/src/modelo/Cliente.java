/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Cliente {

    private int puerto;
    private Socket cliente;
    private DataInputStream ingreso;
    private DataOutputStream salida;
    

    public Cliente() {
        cliente = new Socket();
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public static void main(String[] args) {
        Cliente cli= new Cliente();
        
        try {
            cli.setCliente(new Socket("127.0.0.1",3600));
            DataInputStream ingreso;
            DataOutputStream salida;
            ingreso= new DataInputStream(cli.getCliente().getInputStream());
            salida= new DataOutputStream(cli.getCliente().getOutputStream());
            
            Scanner s=new Scanner(System.in);
            System.out.println(ingreso.readUTF());//recibo
            System.out.println(ingreso.readUTF());//recibo
            while(true){
                String lectura = s.nextLine();
                salida.writeUTF(lectura);//envio
                System.out.println(ingreso.readUTF());//recibo
                //System.out.println(ingreso.readUTF());
            }
            
            // TODO code application logic here
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
