package Votos;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author a09001005
 */
public class ProxyCliente {
    ArrayList listaBroker;
    Protocolo protocolo=new Protocolo();
    
    
    public ProxyCliente() {
        listaBroker=new ArrayList();
        
    }
    
    /*
    
    Socket cliente;
    String ip="127.0.0.1";
    int puerto=9000;
    PrintStream salida;
    BufferedReader entrada, teclado;
    * */
    
    private void connect(String mensaje){
        try{
            /*
            cliente=new Socket(ip,puerto);
            entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado=new BufferedReader(new InputStreamReader(System.in));
            
            //String tec=teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());           
            salida.println(mensaje);
            String msg=entrada.readLine();
            */
            String respuesta=protocolo.conectaConBroker(mensaje);
            System.out.println("Respuesta "+respuesta);
            JOptionPane.showMessageDialog(null, "Respuesta "+respuesta);
            protocolo.terminaConexionConBroker();
            /*
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
            * */
                    
        }catch(Exception e){
            
        }
               
    }
    
    public void peticionServicio(String servicio, String votos){
        connect(servicio+" "+votos);
    }

}
