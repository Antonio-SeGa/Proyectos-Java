package vistas;

import Clases.Recursividad;

import java.util.Random;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();

        /*
        //System.out.println("Ingresa A: ");
        //int a = sc.nextInt();
        int a = rdm.nextInt(10);
        System.out.println("El valor de A: "+ a);

        //System.out.println("Ingresa B: ");
        //int b = sc.nextInt();
        int b = rdm.nextInt(10);
        System.out.println("El valor de B: "+ b);

        //System.out.println("Ingresa C: ");
        //int c = sc.nextInt();
        int c = rdm.nextInt(10);
        System.out.println("El valor de C: "+ c);

        int mayor = (a > b && a > b) ? a : (b > c ? b : c);
        int minimo = (a < b && a < c) ? a : (b < c ? b : c) ;

        System.out.println("El numero mayor es " + mayor);
        System.out.println("El numero menor es " + minimo);

         */


        Recursividad rec = new Recursividad();

        System.out.println("Ingresa A: ");
        int a = sc.nextInt();

        System.out.println("El factorial de "+ a +" es "+ rec.factorial_con_recursividad(a));
        //System.out.println("El factorial de "+ a +" es "+ rec.factorial_sin_recursividad(a));
    }
}
