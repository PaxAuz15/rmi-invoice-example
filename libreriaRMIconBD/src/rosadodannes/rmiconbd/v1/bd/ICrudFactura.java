/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosadodannes.rmiconbd.v1.bd;

import java.util.List;

/**
 *
 * @author lucho
 */
public interface ICrudFactura {
    public Factura buscarFactura(Integer numero) throws Exception;
    public List<Factura> listarFacturas () throws Exception;
}
