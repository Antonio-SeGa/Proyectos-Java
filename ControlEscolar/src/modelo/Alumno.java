package modelo;

public class Alumno {
    private String Nombre;
    private String ApellP;
    private String ApellM;
    private String Matricula;
    private float Promedio;
    private String Sexo;
    private int Edad;

    public Alumno (){
    }
    public Alumno(String nombre, String apellP, String apellM, String matricula, float promedio, String sexo, int edad) {
        Nombre = nombre;
        ApellP = apellP;
        ApellM = apellM;
        Matricula = matricula;
        Promedio = promedio;
        Sexo = sexo;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellP() {
        return ApellP;
    }

    public void setApellP(String apellP) {
        ApellP = apellP;
    }

    public String getApellM() {
        return ApellM;
    }

    public void setApellM(String apellM) {
        ApellM = apellM;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public float getPromedio() {
        return Promedio;
    }

    public void setPromedio(float promedio) {
        Promedio = promedio;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}


