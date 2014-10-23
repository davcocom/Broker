package Votos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author a09001005
 */
public class Candidato {

    private String nombre;
    private int votos;
    private String id="CND";

    public Candidato(String nombre,int id) {
        this.nombre = nombre;
        this.votos = 0;
        this.id+=id;
    }

    @Override
    public String toString() {
        return nombre + "," + votos + "," + id+"|";
    }
    

    public void votar(){
        votos++;
    }

    public String getId() {
        return id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

}
