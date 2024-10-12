package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int fil, col;

        Scanner S = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Ingresar cuantas Filas quiere que tenga la matriz: ");
        fil = S.nextInt();
        System.out.println("Ingrese cuantas Columnas quiere que tenga la matriz: ");
        col = S.nextInt();


        int[][] m1 = new int[col][fil];
        int[][] m2 = new int[col][fil];


        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = r.nextInt(50);
                m2[i][j] = r.nextInt(50);
            }
        }
        System.out.println("\nMatriz 1");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print("[ "+m1[i][j] + " ]");
            }
            System.out.println("");
        }

        System.out.println("\nMatriz 2");
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.print("[ "+m2[i][j] + " ]");
            }
            System.out.println("");
        }

        Matrix m = new Matrix(m1,m2);
        int[][] mSuma;
        int[][] mResta;
        int[][] mMulltiplicacion;

        try {
            mSuma = m.getSuma();
            /*
            for (int[] v : mSuma) {
                System.out.println(Arrays.toString(v));
            }
             */
            for (int i = 0;     i < mSuma.length; i++) {
                for (int j = 0; j < mSuma[0].length; j++) {
                    System.out.print("[ " + mSuma[i][j] + " ]");
                }
                System.out.println("");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            mResta = m.getResta();
            for (int[] v : mResta) {
                System.out.println(Arrays.toString(v));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            mMulltiplicacion = m.getMultiplicacion();
            for (int[] i : mMulltiplicacion) {
                System.out.println(Arrays.toString(i));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
}
