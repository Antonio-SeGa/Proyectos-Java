package Clase;

public class Producto {
    private String codBarras;
    private String descripcion;
    private int cantidad;
    private float precio;

    public Producto() {
    }

    public Producto(String codBarras, String descripcion, int cantidad, float precio) {
        this.codBarras = codBarras;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getTotal(){
        return Math.round(this.cantidad * this.precio);
    }

    @Override
    public String toString() {
        return this.descripcion+" "+ this.cantidad+" "+ this.getTotal();
    }
}
