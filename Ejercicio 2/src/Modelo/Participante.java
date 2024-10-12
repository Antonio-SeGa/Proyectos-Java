package Modelo;

public class Participante {
    private String Nombre;
    private String Apellidos;
    private float monto;
    private int totalAportaciones;


    //Constructor sin parametros
    public Participante() {
    }

    //Constructor con parametros
    public Participante(String nombre, String apellidos, float monto, int totalAportaciones) {
        Nombre = nombre;
        Apellidos = apellidos;
        this.monto = monto;
        this.totalAportaciones = totalAportaciones;
    }

    //Metodos get y set de nombre
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Metodos get y set de Appellidos
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    //Metodos get y set de monto
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    //Metodos get y set de total de dias por aportar
    public int getTotalAportaciones() {
        return totalAportaciones;
    }

    public void setTotalAportaciones(int totalAportaciones) {
        this.totalAportaciones = totalAportaciones;
    }

    //Calcular el total del monto por participante
    public float getTotal(){
        return this.totalAportaciones * this.monto;
    }


}
