package Clases;

public class Recursividad {

    public long factorial_con_recursividad(int n){
        return n == 0 ? 1 : factorial_con_recursividad(n-1)*n;
    }

    public long factorial_sin_recursividad(int n){
        long res = 1;
        if(n == 0) return 1;
        else for (int i = 1 ; i<= n ; i++) res *= i ;
        return res;
    }
}
