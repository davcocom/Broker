package Votos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Protocolo {
    Socket cliente;
    String ip="127.0.0.1";
    int puerto=9000;
    PrintStream salida;
    BufferedReader entrada, teclado;
    
    public String conectaConBroker(String mensaje) throws IOException{
        cliente=new Socket(ip,puerto);
            entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado=new BufferedReader(new InputStreamReader(System.in));
            
            //String tec=teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());           
            salida.println(mensaje);
            String msg=entrada.readLine();
            return msg;
    }
    
    public void terminaConexionConBroker() throws IOException{
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
    }
}
