/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosadodannes.rmiconbd.v1.bd;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lucho
 */
public class Factura implements Serializable {
    private Integer numero;
    private String cedula;
    private Date fecha;
    private Float iva;
    private Float total;

    public Factura() {
    }

    public Factura(Integer numero,String cedula, Date fecha, Float iva, Float total) {
        this.numero = numero;
        this.cedula = cedula;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Factura(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
