/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorrmiconbd;

import rosadodannes.servidorrmiconbd.v1.red.Servidor;

/**
 *
 * @author lucho
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Servidor s = new Servidor();
        try{
            s.publicarObjetosRemotos();
            System.out.println("SERVIDOR ONLINE");
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
}
