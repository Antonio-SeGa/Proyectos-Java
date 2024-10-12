package Vista;

import Modelo.matriz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int fila,col;

        System.out.println("Ingresar cuantas Filas quiere que tenga la matriz: ");
        fila = sc.nextInt();
        System.out.println("Ingrese cuantas Columnas quiere que tenga la matriz: ");
        col = sc.nextInt();

        int[][] m1 = new int[col][fila];
        int[][] m2 = new int[col][fila];

        //Crear matrces 1 y 2
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = r.nextInt(50);
                m2[i][j] = r.nextInt(50);
            }
        }
        System.out.println("Matriz 1");
        for (int[] v1: m1) {
            System.out.println(Arrays.toString(v1));
        }
        System.out.println("Matriz 2");
        for (int[] v2: m2) {
            System.out.println(Arrays.toString(v2));
        }

        System.out.println("\nMatriz 2");
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.print("[ "+m2[i][j] + " ]");
            }
            System.out.println("");
        }

        matriz operaciones = new matriz(m1,m2);
        int[][] mSuma;
        int[][] mResta;
        int[][] mMulltiplicacion;

        System.out.println("La suma de M1 y M2 es");
        try {
            mSuma = operaciones.getSuma();
            for (int[] v : mSuma) {
                System.out.println(Arrays.toString(v));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("La resta de M1 y Ma2 es: ");
        try {
            mResta = operaciones.getResta();
            for (int[] v : mResta) {
                System.out.println(Arrays.toString(v));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("La mutipliicacion de M1 y M2 es ");
        try {
            mMulltiplicacion = operaciones.getMultiplicacion();
            for (int[] i : mMulltiplicacion) {
                System.out.println(Arrays.toString(i));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
