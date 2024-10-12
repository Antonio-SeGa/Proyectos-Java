package vistas;

import Clases.RecNnumeros;

import java.util.Scanner;

public class SumaParesdeNnumeros {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Cuantos numeros desea tener");
        n = sc.nextInt();

        System.out.println("Los numeros de 1 a "+n+" son ");
        for (int i = 1 ; i <= n ; i++){
            System.out.println(i);
        }

        RecNnumeros suma = new RecNnumeros();
        System.out.println("La suma de numeros pares de 1 a N numeros sin recursividad es "+suma.sumaPares_sin_Recusrsividad(n));
        System.out.println("La suma de numeros pares de 1 a N numeros con recursividad es "+suma.sumaPares_con_Recusrsividad(n));

    }
}
