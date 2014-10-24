package servidor;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class ProtocoloServidor {
    ServerSocket server;
    Socket socket;
    int puerto = 9001;
    DataOutputStream salida;
    BufferedReader entrada;
    

    
    public String recibeDeBroker() throws IOException{
        server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = entrada.readLine();
            return msg;
    }
    public void terminaConBroker() throws IOException{
            //AQUI DEVUELVE AL BROKER!
        
            //_________________
            
            entrada.close();
            
            socket.close();
    }
    
    public boolean verificarServicio(ArrayList<Servidor> servidores,String servicioSolicitado){
        for (Servidor servidor : servidores) {
            if (servidor) {
                
            }
        }
        return false;
    }
    
}
