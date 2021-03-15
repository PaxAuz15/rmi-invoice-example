/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosadodannes.servidorrmiconbd.v1.red;

import java.io.IOException;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;
import rosadodannes.rmiconbd.v1.bd.ICrudFactura;

/**
 *
 * @author lucho
 */
public class Servidor {

    private int puerto = 9008;
    CallHandler objetosEnRed;
    Server servidorRMI;

    public void publicarObjetosRemotos() throws Exception {
        try {
            ICrudFactura objetoRemoto = CrudFacturaImp.getInstancia();
            objetosEnRed = new CallHandler();
            servidorRMI = new Server();
            objetosEnRed.registerGlobal(ICrudFactura.class, objetoRemoto);
            servidorRMI.bind(puerto, objetosEnRed);
        } catch(LipeRMIException error){
            throw new Exception("ERROR Interno del Servidor");
        } catch(IOException error){
            throw new Exception("ERROR Puerto o IP del Servidor Ocupados");
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

}
