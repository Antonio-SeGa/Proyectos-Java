package Modelo;

import Clase.Producto;
import Estructura.Cola;

public class Venta {
    private int totalProd;
    private float costoTotal;

    public Venta() {
        this.totalProd = 0;
        this.costoTotal = 0;
    }

    public void setSuma(Producto producto){
        this.totalProd += producto.getCantidad();
        this.costoTotal += producto.getTotal();
    }

    public void setResta(Cola cola){
        this.totalProd -= cola.getCantidad();
        this.costoTotal -= cola.getVentaTotal();
    }

    public int getTotalProd() {
        return totalProd;
    }

    public float getCostoTotal() {
        return costoTotal;
    }
}
