package servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author vaio
 */
public class Candidato {
    protected String id;
    protected String nombre;
    protected int noDeVotos;

    public Candidato(String id, String nombre, int noDeVotos) {
        this.id = id;
        this.nombre = nombre;
        this.noDeVotos = noDeVotos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the noDeVotos
     */
    public int getNoDeVotos() {
        return noDeVotos;
    }

    /**
     * @param noDeVotos the noDeVotos to set
     */
    public void aumentarNoDeVotos() {
        this.noDeVotos ++;
    }
    
}
