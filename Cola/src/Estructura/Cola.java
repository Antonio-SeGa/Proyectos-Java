package Estructura;

import Clase.Producto;

public class Cola {
    private int fin;
    private Producto[] productos;
    private int frente;
    private int ultimo;
    private int tamanio;

    private int totalProd;
    private float costoTotal;


    public Cola(int fin) {
        this.fin = fin;

        this.productos = new Producto[this.fin];

        this.frente = 0;
        this.ultimo = 0;

        this.tamanio = 0;

        this.totalProd = 0;
        this.costoTotal = 0;

    }

    public void añadir(Producto producto) throws Exception {  //Instertar productos
        if(this.llena()) throw new Exception("La cola de productos esta llena!!!");

        if (this.ultimo == this.fin){
            this.ultimo = 0;
        }

        if (this.ultimo == 0) this.productos[this.ultimo++] = producto;
        else {
            for (int i = this.ultimo++ ; i > 0 ; i--){
                this.productos[i] = this.productos[i-1];
            }
            this.productos[0] = producto;
        }

        this.tamanio ++;
        this.totalProd += producto.getCantidad();
        this.costoTotal += producto.getTotal();
    }

    public void retirar() throws Exception{ //Eliminar o retirar a un producto
        if (this.vacio())  throw new Exception("La cola de productos esta vacia!!!");

        Producto producto = this.productos[--this.ultimo];

        this.productos[this.ultimo] = null;

        this.tamanio--;


        this.totalProd -= producto.getCantidad();
        this.costoTotal -= producto.getTotal();
    }

    public boolean vacio() {
        return this.tamanio == 0;
    }

    public boolean llena() {
        return this.fin == this.tamanio;

    }

    public Producto[] getPersonas() {
        return productos;
    }

    public int getTotalProd() {
        return totalProd;
    }

    public float getCostoTotal() {
        return costoTotal;
    }
}
