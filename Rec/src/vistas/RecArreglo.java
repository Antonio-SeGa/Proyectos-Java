package vistas;

import Clases.SumaArreglo;

import java.util.Scanner;

public class RecArreglo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuantos numeros desea ingresar?");
        int numeros[] = new int[sc.nextInt()];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingres el numero en la posicion ["+ i +"]");
            numeros[i] = sc.nextInt();
        }

        SumaArreglo n = new SumaArreglo();
        System.out.println("La suma de los elementos del arreglo con recursividad es " + n.Suma_con_Recursividad(numeros, numeros.length - 1));
        System.out.println("La suma de los elementos del arreglo sin recursividad es " + n.Suma_sin_Recursividad(numeros));
        System.exit(0);

    }
}
