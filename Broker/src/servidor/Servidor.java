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
