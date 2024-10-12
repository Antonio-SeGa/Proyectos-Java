package vista;

import entidad.Persona;
import estructura.Pila;
import javafx.scene.transform.Scale;

import java.util.Scanner;
import java.util.Stack;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pila pila = new Pila(4);
        Persona[] personas = pila.getPersonas();
        /*
        try {
            pila.push(new Persona("Abril", "Ramirez"));
            pila.push(new Persona("Antonio", "Serrano"));
            pila.push(new Persona("Cesar", "Hernandez"));
            pila.push(new Persona("Joan", "Hernandez"));
            //pila.push(new Persona("Kevin", "Guadalupe"));


            for(Persona persona : personas) {
                System.out.println(persona.getNombre()+" "+persona.getApellidos());
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
        String op = "s";

        do {

            try {
                pila.pop();
            } catch (Exception e) {
                System.out.println("ERROR:" + e.getMessage());
            }
            System.out.println("desea eliminar otro elemento [s/N]");
            op = sc.next();

        }while (op.charAt(0)=='s' || op.charAt(0)=='S');

        for (Persona persona: personas) {
            System.out.println(persona.getNombre());
        }
        */

        int op;

        do {
            System.out.println("Menu");
            System.out.println("1. Insertar persona\n" +
                               "2. Eliminar datos\n" +
                               "3. Mostrar la pila\n" +
                               "4. Salir");
            System.out.println("Elija una opcion");
            op = sc.nextInt();

            switch (op){
                case 1:
                    try {
                        Persona p = new Persona();

                        System.out.println("Ingresa el nombre de la persona");
                        p.setApellidos(sc.next());
                        System.out.println("Ingresa los apellidos de la persona");
                        p.setApellidos(sc.next());

                        pila.push(p);

                    } catch (Exception e) {
                        System.out.println("ERROR:" + e.getMessage());
                    }

                    break;

                case 2:
                    try {
                        pila.pop();
                        System.out.println("Se a eleiminado la persona de la pila");

                    } catch (Exception e) {
                        System.out.println("ERROR:" + e.getMessage());
                    }
                    break;

                case 3:
                        for (Persona persona: personas) {
                            System.out.println(persona.getNombre());
                        }

                    break;

                case 4:
                    System.exit(0);
                    break;
            }

        }while (op!=4);

    }
}