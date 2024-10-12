package Modelo;

public class Alumno {
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private int edad;
    private String sexo;
    private float calificacion;

    //Constructor sin parametros
    public Alumno() {
    }

    //Contsructor con parametros
    public Alumno(String nombre, String aPaterno, String aMaterno, int edad, String sexo, float calificacion) {
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.edad = edad;
        this.sexo = sexo;
        this.calificacion = calificacion;
    }

    //Metodos get y set de nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos get y set de Apellido paterno
    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    //Metodos get y set de Apellido materno
    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    //Metodos get y set de edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Metodos get y set de Sexo
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    //Metodos get y set de Calificacion
    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    //Metodo string para mostrar los datos del alumno
    public String toString(){
        String Alumno = "Nombre: "+getNombre()+" Apellido Paterno: " +getaPaterno()+" Apellido Materno: "+getaMaterno()+
                        " Edad: "+getEdad()+" Sexo: "+getSexo()+" Calificacion: "+getCalificacion();
        return Alumno;
    }
}
