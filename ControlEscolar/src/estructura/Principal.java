package estructura;

import modelo.Alumno;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Principal {
//Creación de nuestro arregro
    private List<Alumno> alumnoList = new ArrayList<Alumno>();
    File Archivo = new File("ControlEscolar");
    Alumno registro = null;

    public void InsertarAlumno(Alumno alumno) {
        try {
            BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Archivo, true), "utf-8"));
            escribir.write(alumno.getNombre() + "\t" + alumno.getApellP() + "\t" + alumno.getApellM() + "\t" + alumno.getMatricula()
                    + "\t" + alumno.getPromedio() + "\t" + alumno.getSexo() + "\t" + alumno.getEdad() + "\r\n");
            escribir.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void Transformar() {
        try {
            String raya;
            BufferedReader LeerArchivo = new BufferedReader(new FileReader(Archivo));
            while ((raya = LeerArchivo.readLine()) != null) {
                StringTokenizer mistokens = new StringTokenizer(raya, "\t");
                String Nombre = mistokens.nextToken().trim();
                String ApellP = mistokens.nextToken().trim();
                String ApellM = mistokens.nextToken().trim();
                String Matricula = mistokens.nextToken().trim();
                String Promedio = mistokens.nextToken().trim();
                String Sexo = mistokens.nextToken().trim();
                String Edad = mistokens.nextToken().trim();
                float PromedioOperador = Float.parseFloat(Promedio);
                int EdadOperador = Integer.parseInt(Edad);
                registro = new Alumno(Nombre, ApellP, ApellM,Matricula, PromedioOperador, Sexo, EdadOperador);
                alumnoList.add(registro);
            }
            LeerArchivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Consulta del arreglo
    public void Consultar() {

        String Matricula;
        JOptionPane.showMessageDialog(null, "Consulta");
        Matricula = JOptionPane.showInputDialog(null, "Cual es la matricula del registro a consultar");

        for (Alumno a : alumnoList) {
            if (a.getMatricula().equals(Matricula)) {
                JOptionPane.showMessageDialog(null,"nombre: "+a.getNombre() + "\n" +"apellido paterno: "+ a.getApellP() + "\n"+"apellido materno: " + a.getApellM() + "\n" +
                        "matricula: "+ a.getMatricula()+ "\n" +"promedio: "+ a.getPromedio() + "\n" +"sexo"+ a.getSexo() + "\n" +"edad"+ a.getEdad() + "\r\n");
                break;

            }
        }

    }

//modifica los componentes del arreglo
    public void modificarFichero() {
        try {

            if (alumnoList.size() == 0) {
                Transformar(); }

            int opc = 10;

            while (opc != 9) {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1-Modificar ID"+"\t\n"+"2-Modificar Nombre"+"\t\n"+"3-Modificar Apellido Paterno"+
                                "\t\n"+"4-Modificar Apellido Materno"+"\t\n"+"5-Guardar Modificaciones","",1
                        ));
                switch (opc) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Actualizar matricula ");

                        String MatriculaAnterior;
                        MatriculaAnterior = JOptionPane.showInputDialog(null, "Cual es la matricula actual", "Matricula a modificar");
                        String MatriculaNueva;
                        MatriculaNueva = JOptionPane.showInputDialog(null, "Cual es la nueva Matricula", "Matricula nueva");

                        for (Alumno a : alumnoList) {

                            if (a.getMatricula().equals(MatriculaAnterior)) {

                                a.setMatricula(MatriculaNueva);
                                JOptionPane.showMessageDialog(null, a.getMatricula());
                                break;
                            } else {
                                System.out.println("la Matricula no fue encontrada");
                            }
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Actualizar nombre ");

                        String NombreAnterior;
                        NombreAnterior = JOptionPane.showInputDialog(null, "Cual es el nombre actual", "Nombre a modificar");
                        String NombreNuevo;
                        NombreNuevo = JOptionPane.showInputDialog(null, "Cual es el nuevo nombre", "Nombre nuevo");

                        for (Alumno a : alumnoList) {

                            if (a.getNombre().equals(NombreAnterior)) {

                                a.setNombre(NombreNuevo);
                                JOptionPane.showMessageDialog(null, a.getNombre());
                                break;
                            } else {
                                System.out.println("El nombre no fue encontrado");
                            }
                        }
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Actualizar apellido paterno ");

                        String ApellPAnterior;
                        ApellPAnterior = JOptionPane.showInputDialog(null, "Cual es el apellido paterno actual", "Apellido a modificar");
                        String ApellPNuevo;
                        ApellPNuevo = JOptionPane.showInputDialog(null, "Cual es el nuevo apellido", "Apellido Paterno nuevo");

                        for (Alumno a : alumnoList) {

                            if (a.getApellP().equals(ApellPAnterior)) {

                                a.setApellP(ApellPNuevo);
                                JOptionPane.showMessageDialog(null, a.getApellP());
                                break;
                            } else {
                                System.out.println("El apellido no fue encontrado");
                            }
                        }
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Actualizar apellido materno ");

                        String ApellMAnterior;
                        ApellMAnterior = JOptionPane.showInputDialog(null, "Cual es el apellido materno actual", "Apellido a modificar");
                        String ApellMNuevo;
                        ApellMNuevo = JOptionPane.showInputDialog(null, "Cual es el nuevo apellido", "Apellido Materno nuevo");

                        for (Alumno a : alumnoList) {

                            if (a.getApellM().equals(ApellMAnterior)) {

                                a.setApellM(ApellMNuevo);
                                JOptionPane.showMessageDialog(null, a.getApellM());
                                break;
                            } else {
                                System.out.println("El apellido no fue encontrado");
                            }
                        }
                        break;

                    case 5:
                        BufferedWriter Rescribir = new BufferedWriter(new FileWriter(Archivo));
                        for (Alumno a: alumnoList) {
                            Rescribir.write(a.getNombre()+"\t"+ a.getApellP() +"\t"+ a.getApellM() +"\t"+ a.getMatricula() +"\t"+ a.getPromedio()+"\t"+
                                    a.getSexo()+"\t"+ a.getEdad()+"\t\n");
                        }
                        Rescribir.close();
                }

            }
        }catch (Exception e){

        }
    }
    //ordenamiento del arreglo por promedio
    public void OrdenamientoMetodoBurbuja() {
        if (alumnoList.size() == 0) {
            Transformar();
        }
        try {
            BufferedWriter Rescribir = new BufferedWriter(new FileWriter(Archivo));
            for (Alumno a : alumnoList) {
                if (a.getPromedio()>=70) {
                    Rescribir.write(a.getNombre() + "\t" + a.getApellP() + "\t" + a.getApellM() + "\t" + a.getMatricula() + "\t" + a.getPromedio() + "\t" +
                            a.getSexo() + "\t" + a.getEdad()+ "\t\n");
                }
             }
            for (Alumno a : alumnoList) {
                if (a.getPromedio()<70) {
                    Rescribir.write(a.getNombre() + "\t" + a.getApellP() + "\t" + a.getApellM() + "\t" + a.getMatricula() + "\t" + a.getPromedio() + "\t" +
                            a.getSexo() + "\t" + a.getEdad()+"\t\n");
                }
            }
            Rescribir.close();
            } catch (Exception e) {

        }

    }
    //Borra el registro dependiendo la matricula ingresada
    public void Borrar() {
        String v;
        v = JOptionPane.showInputDialog(null, "Numero del Matricula para borrar su registro");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Archivo));
            for (Alumno a : alumnoList) {
                if (!Objects.equals(a.getMatricula(), v)) {
                    bw.write(a.getNombre() + "\t" + a.getApellP() + "\t" + a.getApellM() + "\t" + a.getMatricula() + "\t" + a.getPromedio() + "\t" +
                            a.getSexo() + "\t" + a.getEdad()+"\t\n");
                } else {
                    System.out.println("los gatos dominaran el mundo ");
                }
            }
            bw.close();
            alumnoList.clear();
            Transformar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
