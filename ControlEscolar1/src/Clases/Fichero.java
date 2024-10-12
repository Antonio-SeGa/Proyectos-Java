package Clases;

import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Fichero {
    private List<Alumno> alumnos = new ArrayList<>(); //Crear un arreglo para almacenar los alumnos
    File Fichero = new File("ControlEscolar"); //llamar al archivo
    Alumno registro = null; //crear registros de objetos

    //Metodo para la inserccion de datos en el archivo
    public void nuevoAlumno (Alumno alumno){
        try {
            //Abro el flujo de escritura, sobre el fichero con codificacion utf8 con la clase BufferedWriter
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Fichero,true),"utf-8"));
            //Escribir en el fichero
            bf.write(alumno.getNoControl()+"\t"+alumno.getNombreCom()+"\t"+alumno.getCalif()+"\r\n");
            bf.close(); //Cierre del flujo de escritura
        } catch (Exception e) {
            //Captura de un posible error
            e.printStackTrace();
        }
    }

    //Metodo que que permite leer los datos en archivo y poderlos leer
    public void token(){
        String dato;
        try {
            //Abro el flujo de lectura, sobre el fichero
            BufferedReader bfread = new BufferedReader(new FileReader(Fichero));
            //meter todos los datos leidos del archivo de texto separlo en atributos y convertirlos a objeto
            while ((dato= bfread.readLine()) != null){
                //Separar en tokens
                StringTokenizer toeken = new StringTokenizer(dato,"\t");
                String NoC = toeken.nextToken().trim();
                String Nom = toeken.nextToken().trim();
                String Cal = toeken.nextToken().trim();

                //Convertir el tipo string a int
                int Calif = Integer.parseInt(Cal);
                //Pasarlos al constructor del objeto que se creo antes
                registro = new Alumno(NoC, Nom, Calif);
                //añadir el objeto al arrays
                alumnos.add(registro);
            }
            bfread.close(); //Cierre de flujo de lectura
        } catch (Exception e) {
            //Captura de un posble error
            e.printStackTrace();
        }
    }

    //metodo que actualiza los datos solicitado por el usuario
    public void Actualizar(){
        if(alumnos.size() == 0) { token(); }
        int resp = 10;
        while (resp != 5){
            //Menu para la seleccion de que dato se desea modificar
            resp = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1.- Modificar Numero de Control\n2.- Modificar Nombre del alumno\n3.- Modificar la calificacion\n4.-Guardar Cambios","Modificar", JOptionPane.INFORMATION_MESSAGE));
            //seleccion de las opciones de acuerdo a cada caso
            switch (resp){
                //Modificar al numero de control que se ingrese
                case 1:
                    String NoControMod = JOptionPane.showInputDialog(null,"Ingresa el numero de control a modificar","Modificar",JOptionPane.INFORMATION_MESSAGE);
                    String NuevoNumControl = JOptionPane.showInputDialog(null,"Ingresa el nuevo numero de control");
                    for (Alumno a:alumnos) {
                        if (a.getNoControl().equals(NoControMod)){
                            a.setNoControl(NuevoNumControl);
                        } else {}
                    }
                    //Mandar un mensaje de que ya han sido actualizado los datos
                    JOptionPane.showMessageDialog(null,"Se han actualizado el numero de control correctamete", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:
                    //Modificar el nombre que se ingrese
                    String NombreMod = JOptionPane.showInputDialog(null,"Ingresa el nombre a modificar","Modificar",JOptionPane.INFORMATION_MESSAGE);
                    String NuevoNombre = JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre");
                    for (Alumno a:alumnos) {
                        if (a.getNombreCom().equals(NombreMod)){
                            a.setNombreCom(NuevoNombre);
                        } else {}
                    }
                    //Mandar un mensaje de que ya han sido actualizado los datos
                    JOptionPane.showMessageDialog(null,"Se han actualizado el nombre correctamete", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    //Modificar la calificacion que se ingrese
                    int CalMod = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la calificacion a modificar"));
                    int NuevaCal = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la nueva calificacion"));
                    for (Alumno a:alumnos) {
                        if (a.getCalif() == CalMod){
                            a.setCalif(NuevaCal);
                        } else {}
                    }
                    //Mandar un mensaje de que ya han sido actualizado los datos
                    JOptionPane.showMessageDialog(null,"Se han actualizado la calificacion correctamete", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
                    break;

                //Guardar los cambios realizados
                case 4:
                    try {
                        BufferedWriter bfGuardar = new BufferedWriter(new FileWriter(Fichero));
                        for (Alumno a : alumnos) {
                            bfGuardar.write(a.getNoControl() + "\t" + a.getNombreCom() + "\t" + a.getCalif() + "\r\n");
                        }
                        bfGuardar.close();

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    //Metodo que elimina los datos del alumno que se desea ingresando con su nomuero de control
    public void eliminar(){
        if(alumnos.size()==0) { token(); }
        //leer el numero de control que se ingresa
        String NoControlBorrar = JOptionPane.showInputDialog(null,"Ingresa el numero de control a eliminar","Eliminar",JOptionPane.INFORMATION_MESSAGE);
        try {
            //Abro el flujo de escritura, sobre el fichero
            BufferedWriter bfEliminar = new BufferedWriter(new FileWriter(Fichero));
            for (Alumno a:alumnos) {
                //Buscar al alumno que se desea eliminara a traves de un forech y buscando al alumno para eliminar sus registros
                if(!Objects.equals(a.getNoControl(),NoControlBorrar)){
                    //borra los registros
                    bfEliminar.write(a.getNoControl() + "\t" + a.getNombreCom() + "\t" + a.getCalif() + "\r\n");
                }else {}
            }
            bfEliminar.close();//cierre del flujo de escritura
            alumnos.clear(); //limpiar los registros en el arreglo
            token();//llamar de lectura
        } catch (IOException e) {
            //Captura de un posible error
            e.printStackTrace();
        }
    }

    //Metodo que permite al usuario realizar una busqueda a traves del numero de control
    public void consulta(){
        //Lectura del numero de control que se desea consultar
        String NoControConsulta = JOptionPane.showInputDialog(null,"Ingresa el numero de control a consultar","Consulta",JOptionPane.INFORMATION_MESSAGE);
        for (Alumno a:alumnos) {
            //Atraves del forech realiza la busqueda a traves del if en el que regresa la consulta generada
            if (a.getNoControl().equals(NoControConsulta)){
                JOptionPane.showMessageDialog(null, "Numero de Control: \t"+a.getNoControl()+
                                                        "\nNombre del alumno: \t"+a.getNombreCom()+"\ncalificacion: \t"+a.getCalif());
            } else {}
        }
    }

    //Metodo que orden la lista de alumnos de acuerdo a las calificaciones obtenidas
    public void Ordenar(){
        if(alumnos.size() == 0) {token();}
        try {
            //Abro el flujo de escritura, sobre el fichero
            BufferedWriter bfOrdenar = new BufferedWriter(new FileWriter(Fichero));
            //realizar el ordenmaiento de los alumnos
            for (Alumno a:alumnos) {
                if(a.getCalif() >= 90 && a.getCalif() <=100){
                    bfOrdenar.write(a.getNoControl() + "\t" + a.getNombreCom() + "\t" + a.getCalif() + "\r\n");
                }
            }
            for (Alumno a:alumnos) {
                if( a.getCalif() >= 80 && a.getCalif() < 90){
                    bfOrdenar.write(a.getNoControl() + "\t" + a.getNombreCom() + "\t" + a.getCalif() + "\r\n");
                }
            }
            for (Alumno a:alumnos) {
                if(a.getCalif() >= 70 && a.getCalif() < 80){
                    bfOrdenar.write(a.getNoControl() + "\t" + a.getNombreCom() + "\t" + a.getCalif() + "\r\n");
                }
            }
            for (Alumno a:alumnos) {
                if(a.getCalif() <= 60){
                    bfOrdenar.write(a.getNoControl() + "\t" + a.getNombreCom() + "\t" + a.getCalif() + "\r\n");
                }
            }
            bfOrdenar.close(); //fin del flujo de escritura
        }
        catch (IOException e) {
            //Captura de un posible error
            e.printStackTrace();
        }
    }

    //retorno de la lista de alumnos generada
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}


