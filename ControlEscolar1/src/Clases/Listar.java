package Clases;

public class Listar {

    private Alumno[] alumnos = new Alumno[10];

    public void Listar(Alumno alumno){
        //Alumno alumno = new Alumno();
        for (int i =0 ; i < alumnos.length; i++){
            alumnos[i] = alumno;
        }
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }
}
