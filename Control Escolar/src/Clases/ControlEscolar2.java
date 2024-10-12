package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControlEscolar2 {
    private List<Alumno> alumnos = new ArrayList<>();
    File Fichero = new File("ControlEscolar");
    Alumno registro = null;

    public void nuevoAlumno (Alumno alumno){
        try {
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Fichero,true),"utf-8"));
            bf.write(alumno.getNoControl()+"\t"+alumno.getNombreC()+"\t"+alumno.getCal()+"\r\n");
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
