/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author bagdi
 */
@Entity
@Table(name = "detalleventa")
public class DetalleVenta implements Serializable {
    //intentar hacer el guradado
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleventa_idlinea_seq")
    @SequenceGenerator(name = "detalleventa_idlinea_seq", sequenceName = "detalleventa_idlinea_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "idlinea")
    private long id;
    
    @Column
    private double cantidad;
    
    @Column
    private double precio;
    
    @Column
    private String producto;

    @ManyToOne
    @JoinColumn(name = "id")
    private Venta venta;
    
    //@Column
    //private long idventa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    //public long getIdventa() {
    //    return idventa;
    //}
//
    //public void setIdventa(long idventa) {
    //    this.idventa = idventa;
    //}

}
