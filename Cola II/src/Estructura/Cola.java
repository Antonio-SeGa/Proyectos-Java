package Estructura;

import Clase.Producto;

public class Cola {
    private int fin;
    private Producto[] productos;
    private int posicion;
    private int frente;
    private int Cantidad;
    private float VentaTotal;



    public Cola(int fin) {
        this.fin = fin;

        this.productos = new Producto[this.fin];
        this.posicion = 0;

        this.Cantidad = 0;
        this.VentaTotal = 0;

    }

    public void añadir(Producto producto) throws Exception {  //Instertar productos
        if(this.llena()) throw new Exception("La cola de productos esta llena!!!");
        
        if (this.posicion == 0 ) this.productos[this.posicion++] = producto;
        else {
            for (int i = this.posicion++ ; i > 0 ; i--){
                this.productos[i] = this.productos[i-1];
            }
            this.productos[0] = producto;
        }

    }

    public void retirar() throws Exception{ //Eliminar o retirar a un producto

        if (this.vacio())  throw new Exception("La cola de productos esta vacia!!!");

        //Producto producto = this.productos[--this.posicion];
        --this.posicion;
        /*
        this.Cantidad = producto.getCantidad();
        this.VentaTotal = producto.getTotal();
         */
        this.Cantidad = this.productos[this.posicion].getCantidad();
        this.VentaTotal = this.productos[this.posicion].getTotal();
        this.productos[this.posicion]=null;





    }

    public boolean vacio() {
        return this.posicion == 0;
    }

    public boolean llena() {

        return this.posicion >= this.fin;

    }

    public Producto[] getPersonas() {
        return productos;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public float getVentaTotal() {
        return VentaTotal;
    }
}
