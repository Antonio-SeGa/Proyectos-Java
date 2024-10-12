package Vista;

import Modelo.Participante;
import Modelo.Sorteo;

import java.util.*;

public class Registro {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        String resp = "S";

        Sorteo tanda = new Sorteo(); //llamar la clase tanda
        Participante nuevo = new Participante(); //llamar la clase participante




        do {
            //solicitar e ingreso de los datos
            System.out.println("Ingresar el nombre del participante: ");
            nuevo.setNombre(leer.next());

            System.out.println("Ingresar la edad del Participante");
            nuevo.setApellidos(leer.next());

            tanda.setParticipantes(nuevo); //Agregar un participante al sorteo

            //Con este determinar el fin o seguir con el ingreso de un un nuevo participante
            System.out.println("Deseas ingresar otro particante [S/N]?");
            resp = leer.next();

        }while (resp.charAt(0)=='S' || resp.charAt(0)=='s');

        //solicitar el ingreso del monto total por participante
        System.out.println("Ingresar el monto total por participante ");
        nuevo.setMonto(leer.nextInt());

        //solicitar el ingreso del nomero de aportaciones
        System.out.println("Ingresar el numero total de aportaciones ");
        nuevo.setTotalAportaciones(leer.nextInt());

        //realizar el sorteo con los numeros de los participantes
        int[] ordenar = tanda.getOrdenar();
        tanda.getParticipantes();
        List<Participante> participante = tanda.getParticipantes();
        int tamaño = tanda.getTotalParticipantes();
        do{

            System.out.println("Turno de los participantes "+Arrays.toString(ordenar));

            for(int i = 0; i < tamaño ;i++){
                System.out.println("Nombre "+participante.get(ordenar[i]-1).getNombre()+
                        " Apellidos "+participante.get(ordenar[i]-1).getApellidos()+
                        " Monto "+participante.get(ordenar[i]-1).getMonto()+
                        " Total de aportaciones "+participante.get(ordenar[i]-1).getTotalAportaciones());
            }

            //Con este determinar el fin o crear un nuevo sorteo
            System.out.println("Desea crear un nuevo sorteo con los participantes [S/N]?");
            resp = leer.next();

        }while (resp.charAt(0)=='S' || resp.charAt(0)=='s');

        System.out.println("El total de Participantes es "+tanda.getTotalParticipantes());
        System.out.println("El tolal de aportaciones por participante es de "+nuevo.getTotalAportaciones()+" dias");
        System.out.println("El total de la tanda por participante es "+tanda.getTotalGralTandaP());
        System.out.println("El total general de la teanda es "+tanda.getTotalTanda());

        System.exit(0);

    }
}
