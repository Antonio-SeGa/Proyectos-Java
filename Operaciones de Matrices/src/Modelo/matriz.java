package Modelo;

public class matriz {
    public int[][] m1;
    public int[][] m2;

    public matriz() {
    }

    public matriz(int[][] m1, int[][] m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    public int[][] getM1() {
        return m1;
    }

    public void setM1(int[][] m1) {
        this.m1 = m1;
    }

    public int[][] getM2() {
        return m2;
    }

    public void setM2(int[][] m2) {
        this.m2 = m2;
    }

    public int[][] getSuma() throws Exception {

        int[][] suma = new int[m1.length][m1[0].length];
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    suma[i][j] = m1[i][j] + m2[i][j];
                }
            }
        }
        else {
            throw new  Exception("El tamaño no es el correcto de las matrices");
        }
        return suma;
    }

    public int[][] getResta() throws Exception{

        int[][] resta = new int[m1.length][m1[0].length];
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    resta[i][j] = m1[i][j] - m2[i][j];
                }
            }
        }else {
            throw new Exception("El tamaño no es el correcto de las matrices");
        }
        return resta;
    }

    public int[][] getMultiplicacion() throws Exception{
        int[][] multiplicacion = new int[m1.length][m1[0].length];
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    multiplicacion[i][j] = m1[i][j] * m2[i][j];
                }
            }
        }else {
            throw new Exception("El tamaño no es el correcto de las matrices");
        }

        return multiplicacion;
    }
}
