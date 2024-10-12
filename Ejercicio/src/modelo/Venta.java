package modelo;

import java.util.*;

public class Venta {
    public static long folio = 1;
    private List<Articulo> articulos; //Arreglo dinamico
    private float total;
    private int cantArticulos;

    //Constructor sin parametros
    public Venta() {
        this.articulos = new ArrayList<>();
        this.total = 0.0f;
        this.cantArticulos = 0;
    }

    //Realizar las operaciones
    public void setArticulo(Articulo articulo) {
        this.articulos.add(articulo); //Agregar el Articulo
        this.total += articulo.getTotal(); //Calcular el total de la venta
        this.cantArticulos += articulo.getCantidad(); //Calcular la antidad de articulos
    }

    //Regresar el valor del total de la venta
    public float getTotal() {
        return this.total;
    }

    //Regresar el valor de la cantidad de articulos de la venta
    public int getTotalArticulos() {
        return this.cantArticulos;
    }
}
