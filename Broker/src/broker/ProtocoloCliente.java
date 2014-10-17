package broker;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author a09001005
 */
public class ProtocoloCliente {

    ArrayList<String> servicios;

    public ProtocoloCliente() {
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
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = entrada.readLine();
            System.out.println(msg);
            msg = procesarPeticion(msg) ? "Solicitud aceptada" : "Peticion no encontrada";
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(msg);

            entrada.close();
            salida.close();
            socket.close();

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
    }

    public static void main(String[] args) {
        ProtocoloCliente server = new ProtocoloCliente();
        server.connect();
    }

}
