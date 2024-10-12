package vista;

import entidad.Persona;
import estructura.Pila;

public class Principal {
    public static void main(String[] args) {

        Pila pila = new Pila(4);

        try {

            pila.push(new Persona("Abril", "Ramirez"));
            pila.push(new Persona("Antonio", "Serrano"));
            pila.push(new Persona("Cesar", "Hernandez"));
            pila.push(new Persona("Joan", "Hernandez"));
           // pila.push(new Persona("Kevin", "Guadalupe"));


            Persona[] personas = pila.getPersonas();
            for(Persona persona : personas) {
                System.out.println(persona.getNombre()+" "+persona.getApellidos());
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }

    }
}
