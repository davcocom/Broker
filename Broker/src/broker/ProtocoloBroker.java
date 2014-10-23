package broker;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class ProtocoloBroker {
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    DataOutputStream salida;
    BufferedReader entrada;
    
    
    Socket cliente;
    String ip="127.0.0.1";
    int puertoBroker=9001;
    PrintStream salidaCliente;
    BufferedReader entradaCliente;
    
    public String recibeDeCliente() throws IOException{
        server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = entrada.readLine();
            return msg;
    }
    
    public String conectaConServidor(String mensaje) throws IOException{
        cliente=new Socket(ip,puertoBroker);
            entradaCliente=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            salidaCliente = new PrintStream(cliente.getOutputStream());           
            salidaCliente.println(mensaje);
            String msg=entradaCliente.readLine();
            return msg;
    }
    
    public void terminaConCliente(String msg) throws IOException{
        salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(msg);

            entrada.close();
            salida.close();
            socket.close();
    }
    
    public void terminaConServidor() throws IOException{
        entradaCliente.close();
            salidaCliente.close();
            cliente.close();
    }
            
}
