/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosadodannes.servidorrmiconbd.v1.red;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rosadodannes.servidorrmiconbd.v1.bd.tablas.Factura;
import rosadodannes.rmiconbd.v1.bd.ICrudFactura;
import rosadodannes.servidorrmiconbd.v1.bd.crud.CrudFactura;
import sun.security.util.PropertyExpander;

/**
 *
 * @author lucho
 */
public class CrudFacturaImp implements ICrudFactura {

    private EntityManagerFactory conexion;
    private CrudFactura crudFactura;
    private static CrudFacturaImp instancia;

    private CrudFacturaImp() throws Exception {
        try {
            conexion = Persistence.createEntityManagerFactory("ServidorRMIconBDPU");
            crudFactura = new CrudFactura(conexion);
        } catch (Exception error) {
            throw new Exception("ERROR: No fue posible hacer conexion con la BD");
        }

    }

    public static CrudFacturaImp getInstancia() throws Exception {
        if (instancia == null) {
            instancia = new CrudFacturaImp();
        }
        return instancia;
    }

    @Override
    public rosadodannes.rmiconbd.v1.bd.Factura buscarFactura(Integer numero) throws Exception {
        try {
            Factura factura = crudFactura.findFactura(numero);
            rosadodannes.rmiconbd.v1.bd.Factura factura2 = null;
            factura2 = new rosadodannes.rmiconbd.v1.bd.Factura();
            factura2.setNumero(factura.getNumero());
            factura2.setCedula(factura.getCedula());
            factura2.setFecha(factura.getFecha());
            factura2.setIva(factura.getIva());
            factura2.setTotal(factura.getTotal());
            return factura2;
        } catch (Exception e) {
            throw new Exception("ERROR: No fue posible encontrar la factura: " + numero);
        }
    }

    @Override
    public List<rosadodannes.rmiconbd.v1.bd.Factura> listarFacturas() throws Exception {
        List<Factura> lista = crudFactura.findFacturaEntities();
        listaFactura = new ArrayList<rosadodannes.rmiconbd.v1.bd.Factura>();
        for (Factura factura : lista){
            agregarFacturaALaLista(factura);
        }
        return listaFactura;
    }

    List<rosadodannes.rmiconbd.v1.bd.Factura> listaFactura;

    public void agregarFacturaALaLista(Factura factura) {
        rosadodannes.rmiconbd.v1.bd.Factura factura2 = new rosadodannes.rmiconbd.v1.bd.Factura();
        factura2.setNumero(factura.getNumero());
        factura2.setCedula(factura.getCedula());
        factura2.setFecha(factura.getFecha());
        factura2.setIva(factura.getIva());
        factura2.setTotal(factura.getTotal());
        listaFactura.add(factura2);
    }

}
