package servidor;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class ProxyServidor {
  
    ProtocoloServidor ps=new ProtocoloServidor();
    ArrayList<String> servicios=new ArrayList();
    ArrayList<Servidor> servidores=new ArrayList();

    public ProxyServidor() {
        Servidor serv=new Servidor();
        servidores.add(serv);
        servicios.add(serv.nombreServicio);
    }
    
    
    
    public ArrayList convierteCadena(String s){
        ArrayList<Candidato> candidatos=new ArrayList();
        StringTokenizer token = new StringTokenizer(s,"|");
        while(token.hasMoreTokens()){
            String candidato=token.nextToken();
            StringTokenizer token2= new StringTokenizer(candidato,",");
            
                String nombre=token2.nextToken();
                int votos=Integer.parseInt(token2.nextToken());
                String id=token2.nextToken();
            
                Candidato cand=new Candidato(id,nombre,votos);
                candidatos.add(cand);
        }
        return candidatos;
    }
    
    /*
    ServerSocket server;
    Socket socket;
    int puerto = 9001;
    DataOutputStream salida;
    BufferedReader entrada;
    * 
    
*/
    Servidor serv=new Servidor();
    public void connect() {
        try {
            /*
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = entrada.readLine();
            * */
            //System.out.println(msg);
            
            String msg=ps.recibeDeBroker();
            ArrayList<Candidato> candidatos=convierteCadena(msg);
            serv.actualizar(candidatos);
            /*
            serv.actualizar(candidatos);
            
            entrada.close();
            
            socket.close();
            */
            ps.terminaConBroker();
            

        } catch (Exception e) {

        }

    }
    public static void main(String[] args) {
        ProxyServidor proxy=new ProxyServidor();
        proxy.connect();
    }
}
