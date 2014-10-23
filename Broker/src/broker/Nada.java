package broker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author a09001005
 */
public class Nada {

    ArrayList<String> servicios;
    ProtocoloBroker pb=new ProtocoloBroker();

    public Nada() {
        servicios = new ArrayList();
        servicios.add("Graficar");
    }

    
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    DataOutputStream salida;
    BufferedReader entrada;

    public void connect() {
        try {
            
            /*server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = entrada.readLine();
            */
            String msg=pb.recibeDeCliente();
            
            //System.out.println(msg);
            msg = procesarPeticion(msg) ? "Solicitud aceptada" : "Peticion no encontrada";
            
            pb.terminaConCliente(msg);
            
            /*
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(msg);

            entrada.close();
            salida.close();
            socket.close();
            * */

        } catch (Exception e) {

        }

    }

    private boolean procesarPeticion(String msg) {
        StringTokenizer token = new StringTokenizer(msg);
        for (String servicio : servicios) {
            if (servicio.equals(token.nextToken())) {
                realizarPeticion(token.nextToken());
                return true;
            }
        }
        return false;
    }

    private void realizarPeticion(String nextElement) {
        System.out.println(nextElement);
        connect(nextElement);
    }
    
    Socket cliente;
    String ip="127.0.0.1";
    int puertoBroker=9001;
    PrintStream salidaCliente;
    BufferedReader entradaCliente;
    
    private void connect(String mensaje){
        try{
            /*
            cliente=new Socket(ip,puertoBroker);
            entradaCliente=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            salidaCliente = new PrintStream(cliente.getOutputStream());           
            salidaCliente.println(mensaje);
            String msg=entradaCliente.readLine();
            */
            pb.conectaConServidor(mensaje);
            //System.out.println("Respuesta "+msg);
            //JOptionPane.showMessageDialog(null, "Respuesta "+msg);
            
            pb.terminaConServidor();
            
            /*
            entradaCliente.close();
            salidaCliente.close();
            cliente.close();
            * */
                    
        }catch(Exception e){
            
        }
               
    }

    public static void main(String[] args) {
        Nada server = new Nada();
        server.connect();
        //System.out.println(InetAdress.getLocalHost()); 
    }


}
    

