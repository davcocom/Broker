package servidor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 *
 * @author Carlos
 */
public class Servidor {
    private ArrayList<Candidato> candidatos;
    graficaBarras gb=new graficaBarras();
    String nombreServicio="Graficar";
    boolean activo=true;

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public graficaBarras getGb() {
        return gb;
    }

    public void setGb(graficaBarras gb) {
        this.gb = gb;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

    
    public void actualizar(Object o) {
        
        this.candidatos= (ArrayList<Candidato>) o;
        System.out.println(candidatos.toString());
        activar();
    }

    



    public void activar() {
        
        gb.init(candidatos);
        gb.setVisible(true);
        
    }
}
