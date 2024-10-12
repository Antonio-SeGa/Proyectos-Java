package Clases;

public class Alumno {
    //Variables de la clase
    private String NoControl;
    private String NombreCom;
    private int Calif;

    //Constructor con parametros
    public Alumno(String noControl, String nombreCom, int calif) {
        NoControl = noControl;
        NombreCom = nombreCom;
        Calif = calif;
    }

    //Connstructor sin parametros
    public Alumno() {

    }

    //Metodos getter and setter de las variables
    public String getNoControl() {
        return NoControl;
    }

    public void setNoControl(String noControl) {
        NoControl = noControl;
    }

    public String getNombreCom() {
        return NombreCom;
    }

    public void setNombreCom(String nombreCom) {
        NombreCom = nombreCom;
    }

    public int getCalif() {
        return Calif;
    }

    public void setCalif(int calif) {
        Calif = calif;
    }

    //Metodo toString
    @Override
    public String toString() {
        return NoControl + "   " + NombreCom + "   " + Calif;
    }
}

