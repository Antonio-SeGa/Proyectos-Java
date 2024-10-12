package Clases;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Fichero {

    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();


    public DefaultListModel recuperar() {
        DefaultListModel lista = new DefaultListModel();
        Alumno alumno;
        try {
            //Varialble con la ruta donde esta el archivo de la bd de los productos
            FileReader fileLeAlumno = new FileReader("Control Escolar.txt");
            //Abrir flujo de lectura sobre el fichero con BufferedReader
            BufferedReader bufReadAlumno = new BufferedReader(fileLeAlumno);
            String dato;

            while ((dato = bufReadAlumno.readLine()) != null) {
                //Este bucle es para meter todos los datos leidos de archivo de texto
                //En una lista
                lista.addElement(dato);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista; //regresa la lista creada con los datos del archivo
    }

    //Escribir sobre el fichero
    public void GuardarAlumno(ArrayList<Alumno> alumnos) {
        try {
            //Varialble con la ruta donde esta el archivo de la bd de los productos
            FileWriter fileEscribeAlumno = new FileWriter("Control Escolar.txt", false);
            //Abrir flujo de escitura sobre el fichero con BufferedWriter
            BufferedWriter bufWritEscribeAlumno = new BufferedWriter(fileEscribeAlumno);
            //Escribe en el fichero la cadena que recibe la función
            for (Alumno alumno : alumnos) {
                //Se escribe a traves del BufferedWriter sobre el fichero
                bufWritEscribeAlumno.write(alumno.getNoControl() + "      " + alumno.getNombreC() + "     " + alumno.getCal() + "\n");
            }
            bufWritEscribeAlumno.close();  //Cierra el flujo de escritura

        } catch (Exception e) {
            //Captura de un posible error
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Metdodo de ordenamineto de Burbuja
    public void ordBurbuja(ArrayList<Alumno> alumnos) {
        ArrayList<Alumno> alumnosOrd;
        Alumno alumno;
        for (int i =  0 ; i < alumnos.size() ; i ++){
            for (int j = 0 ; j < alumnos.size() ; j++){
                // El if de abajo va a determinar si el primero es menor que el segundo
                // y si es true, se va a realizar el swap con una variable aux para
                // mover los objetos del array
                if (alumnos.get(j+1).getCal() < alumnos.get(j).getCal()){
                    alumno = alumnos.get(j+1);
                    alumnos.set(j+1,alumnos.get(j));
                    alumnos.set(j,alumno);
                }
            }
        }

    }

    //Realiza la busqeda del alumno
    public boolean Buscar(int NoCon, String num, int Cal) {
        Lista list = new Lista();
        Alumno busqueda = new Alumno(NoCon, num, Cal); //Se inserta un nuevo alumno a la clase alumno
        //boolean encontrado = false;
        //Crea un ciclo para realizar la buquda
        for (int i = 0; i < list.getAlumnos().size(); i++) {
            //verifica si se encientra el alumno de acuerdo al numero de control ingresado
            if (list.getAlumnos().get(i).getNoControl() == busqueda.getNoControl()){
                return true; //regresa al valor si existe
            }
        }
        return false; //Si no existe
    }

}
