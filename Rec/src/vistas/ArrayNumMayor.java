package vistas;

import Clases.RecNumMayorArray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayNumMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("¿Cuantos numeros desea tener?");
        int numeros[] = new int[sc.nextInt()];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(50);
        }

        System.out.println("Los elementos del arreglo son");
        System.out.println(Arrays.toString(numeros));

        RecNumMayorArray mayor = new RecNumMayorArray();
        System.out.println("El numero mayor del arreglo sin recursividad es "+ mayor.NumMayor_Array_sRec(numeros));
        System.out.println("El numero mayor del arreglo con recursividad es "+ mayor.Max_Rec(numeros, 0));
    }
}
