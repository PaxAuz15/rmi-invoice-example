/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclientecondb.red;

import java.io.IOException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Client;
import rosadodannes.rmiconbd.v1.bd.ICrudFactura;

/**
 *
 * @author lucho
 */
public class ClienteRMI {
    
    private CallHandler objectManagment;
    private Client cliente;
    private String ipServer;
    private int puerto = 9008;
    private ICrudFactura crudFactura;
    
    public ClienteRMI(){
        
    }

    public ClienteRMI(String ipServer, int puerto) throws Exception {
        this.objectManagment = new CallHandler();
        try {
            this.cliente = new Client(ipServer,puerto,objectManagment);
            crudFactura = (ICrudFactura) cliente.getGlobal(ICrudFactura.class);
        } catch (IOException ex) {
            throw new Exception("Error al conectar con el server IP: "+ipServer+":"+puerto);
        }
    }
    
   public ICrudFactura getCrudFactura(){
      return crudFactura;  
    }
}
