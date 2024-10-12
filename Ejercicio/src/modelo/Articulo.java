package modelo;

public class Articulo {
    private String codBarras;
    private String descripcion;
    private float precio;
    private int cantidad;

    // Constructor sin parametros
    public Articulo() {
    }

    //Constructor con parametros
    public Articulo(String codBarras, String descripcion, float precio, int cantidad) {
        this.codBarras = codBarras;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Metodo get y set de codigo de barras
    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    //Metodo get y set de descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Metodo get y set de precio
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    //Metodo get y set de cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Calcular el total de la cantidad por el precio del producto
    public float getTotal() {
        return this.precio * this.cantidad;
    }

}
