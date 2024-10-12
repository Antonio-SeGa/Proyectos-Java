package Modelo;

import java.util.*;

public class Listar {
    private List<Alumno> alumnos; //Arreglo dinamico
    private float promedio;
    private int hombres;
    private int mujeres;

    private String alumnoDestacado;
    private String alumnoNoDestacado;
    private float altaCalif;
    private float bajaCalif;


    //Contructor sin parametros
    public Listar(){
        this.alumnos = new ArrayList<>();
        this.promedio = 0;
        this.hombres = 0;
        this.mujeres = 0;
        this.alumnoDestacado = "";
        this.alumnoNoDestacado = "";
    }

    //Realizar las operaciones
    public void setAlumnos(Alumno alumno){
        this.alumnos.add(alumno);
        this.promedio += alumno.getEdad(); //Sumar las edades

        //Cotabilizar a hombres y mujeres
        if(alumno.getSexo().charAt(0) == 'M'|| alumno.getSexo().charAt(0) == 'm'){
            this.hombres ++;
            alumno.setSexo("Masculino");
        }
        if (alumno.getSexo().charAt(0) == 'F' || alumno.getSexo().charAt(0) == 'f'){
            this.mujeres ++;
            alumno.setSexo("Femenino");
        }

        //Buscar al alumno destacado y no destacado
        this.bajaCalif = this.altaCalif = alumnos.get(0).getCalificacion();
        for (int i = 0; i < alumnos.size() ; i++){
            if (alumnos.get(i).getCalificacion() > this.altaCalif){
                this.altaCalif = alumnos.get(i).getCalificacion();
                alumnoDestacado = "["+alumnos.get(i).toString()+"]";
            }
            if (alumnos.get(i).getCalificacion() < this.bajaCalif){
                this.bajaCalif = alumnos.get(i).getCalificacion();
                alumnoNoDestacado = "["+alumnos.get(i).toString()+"]";
            }
        }

    }

    //Calcular el promedio de edades
    public float getPromedio(){
        return promedio/this.alumnos.size();
    }

    //regresar el valor total de hombres
    public int getTotalHombres(){
        return this.hombres;
    }

    //regresar el valor total de mujeres
    public int getTotalMujeres(){
        return this.mujeres;
    }

    //Reegresar los datos de alumno destacado
    public String getAlumnoDestacado(){
        return alumnoDestacado;

    }
    //regresar los datos de alumno no destacado
    public String getNOAlumno(){
        return alumnoNoDestacado;
    }
}
