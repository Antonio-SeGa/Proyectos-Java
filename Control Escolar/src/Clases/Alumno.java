package Clases;

public class Alumno {
    //Variebles de la clase
    private int NoControl;
    private String NombreC;
    private int Cal;

    //Construcctor sin parametros
    public Alumno() {
    }

    //Constructor con parametros
    public Alumno(int noControl, String nombreC, int cal) {
        NoControl = noControl;
        NombreC = nombreC;
        Cal = cal;
    }

    //Metodos Getter y Setter
    public int getNoControl() {
        return NoControl;
    }

    public void setNoControl(int noControl) {
        NoControl = noControl;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String nombreC) {
        NombreC = nombreC;
    }

    public int getCal() {
        return Cal;
    }

    public void setCal(int cal) {
        Cal = cal;
    }

    //Metodo para mostrar los valores en el arrays
    @Override
    public String toString() {
        return NoControl +"  "+ NombreC +"  "+ Cal;
    }
}