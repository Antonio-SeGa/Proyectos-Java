package proyarchivos;
import java.io.*;
import java.util.Scanner;
/**
 * @author Joan Hernandez Campero
 * @author Antonio Serrano Garcia
 */
public class Archivos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Declaracion de variables
        int opcion;
        String ruta="C:\\Users\\Windows 10\\Documents\\Practica Archivos\\";
        String crearArchivo;
        File archivo;
        String nombreArchivo;
        String texto;
        String textoArchivo="";
        String textoAgregar;
        do {
            // Elaboracion del menu
            System.out.println("M  E  N  Ú");
            System.out.println("1. Crear nuevo archivo");
            System.out.println("2. Leer archivo existente");
            System.out.println("3. Modificar archivo existente");
            System.out.println("4. Salir");
            
            // Seleccionar la opcion del menu
            System.out.println("Seleccione la opcion del menu:");
            opcion=sc.nextInt();
            
            // Presentar las opciones que sean seleccionadas
            switch(opcion){
                // En el caso 1 o Opcion 1, crea el archivo 
                case 1:
                    System.out.println("Proporcione el nombre del archivo que desea crear (.txt)");
                    crearArchivo=sc.next();
                    
                    // File: ayuda ala creacion del archivp en la ruta de la pc.
                    archivo = new File(ruta+crearArchivo); 
                    
                    try {
                        // Notificar que el archivo a sido creado
                        if (archivo.createNewFile()) {
                            System.out.println("El archivo se ha creado");
                        }else{
                            System.out.println("El archivo no se ha creado");
                        }
                    } catch (IOException e) {
                        System.err.println("No se ha creado el archivo"+e);
                    }
                break;
                
                // La opcion 2, lee el archivo ya creado
                case 2:
                    System.out.println("Proporcione el nombre del archivo que desea abrir (.txt)");
                    nombreArchivo=sc.next();
                    
                    try {
                        BufferedReader bf = new BufferedReader (new FileReader(ruta+nombreArchivo));
                        String temp = "";
                        String bfRead;
                        
                        while ((bfRead = bf.readLine())!= null) {
                            temp = temp + bfRead;
                        }
                        texto = temp;
                        System.out.println("El texto del archivo es:\n"+texto);
                        
                    } catch (IOException e) {
                        System.err.println("No se encontró el archivo"+e);
                    }
                    
                    
                break;
                
                // la opcion 3, poder agregar texto al archvo creado
                case 3:
                    System.out.println("Proporcione el nombre del archivo que desea modificar (.txt)");
                    crearArchivo=sc.next();
                    System.out.println("Escribe el texto que deseas agregar:");
                    textoAgregar=sc.next();
                    try {
                        String abrirArchicvo = ruta+crearArchivo;
                        archivo = new File(abrirArchicvo);
                try ( //PrintWriter escribir = new PrintWriter(archivo,"utf-8");
                    FileWriter escribir = new FileWriter(archivo,true)) {
                    escribir.append(textoAgregar);
                }
                    } catch (IOException e) {
                        System.err.println("Error al escribir en el archivo"+e);
                    }
                break;
                
                // La opcion 4, salir del ciclo
                case 4:
                    System.exit(0);
                break;
            } 
        } while (opcion!=4);
    }
}



