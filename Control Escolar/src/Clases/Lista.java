package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lista {
    //Variables de la clase
    private ArrayList<Alumno> alumnos;

    //Construuctor sin parametros
    public Lista() {
        this.alumnos = new ArrayList<>();
    }

    //Inserccion de los alumnos al ArrayList
    public void listar (Alumno alumno){
        alumnos.add(alumno);
    }

    //Retorno de la lista con los datos insertados
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
}
