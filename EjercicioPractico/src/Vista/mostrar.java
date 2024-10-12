package Vista;

import Modelo.Alumno;
import Modelo.Listar;

import java.util.Scanner;

public class mostrar {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String resp = "S";
        //Llamar a la clase listar
        Listar alumno = new Listar();
        do {
            //llamar a la clase alumno
            Alumno a = new Alumno();

            //Ingresar los datos del Articulo mediante el llamado de la clase
            System.out.println("Ingresar el nombre del alumno");
            a.setNombre(leer.next());

            System.out.println("Ingresar el Apellido Paterno");
            a.setaPaterno(leer.next());

            System.out.println("Ingresar el Apellido Materno");
            a.setaMaterno(leer.next());

            System.out.println("Ingresar la edad");
            a.setEdad(leer.nextInt());

            System.out.println("Ingresar sexo: Femenino[F] o Masculino[M]");
            a.setSexo(leer.next());

            System.out.println("Ingresar Calificación");
            a.setCalificacion(leer.nextFloat());

            alumno.setAlumnos(a); //Agregar al alumno a la clase Listar

            //Con este determinar el fin o seguir con el ingreso de alumno
            System.out.println("Deseas ingresar otro alumno [S/N]?");
            resp = leer.next();


        }while (resp.charAt(0)=='S' || resp.charAt(0)=='s');

        String opcion;

        //Ciclo para elegir la opcion
        do {
            System.out.println("**ELIJA UNA OPCION**");
            System.out.println("a) Promedio de edades");
            System.out.println("b) Cantidad de alumnos por sexo");
            System.out.println("c) Mostrar al alumno mas destacado");
            System.out.println("d) Mostrar al alumno menos destacado");

            System.out.println("SELECCIONE LA OPCCION; ");
            opcion=leer.next();

            //Mostrar el promedio demlas edades
            if (opcion.charAt(0) == 'A' || opcion.charAt(0) == 'a'){
                System.out.println("El promedio de edades es "+alumno.getPromedio());
            }
            //Mostrar el total de alumnos por sexo
            if (opcion.charAt(0) == 'B' || opcion.charAt(0) == 'b'){
                System.out.println("El total de alumno por sexo es: " +
                        "\nFemenino: "+alumno.getTotalMujeres()+"\nMasculino: "+alumno.getTotalHombres());
            }
            //Mostrar al alumno destacado
            if (opcion.charAt(0) == 'C' || opcion.charAt(0) == 'c'){
                System.out.println("El alumno destacado es "+alumno.getAlumnoDestacado());
            }
            //Mostrar al alumno menos detscado
            if (opcion.charAt(0) == 'D' || opcion.charAt(0) == 'd') {
                System.out.println("El alumno menos destacado " + alumno.getNOAlumno());
            }
        }while (opcion.charAt(0)  == 'a' || opcion.charAt(0) == 'b' || opcion.charAt(0) == 'c' || opcion.charAt(0) == 'd');

        System.exit(0);
    }
}
