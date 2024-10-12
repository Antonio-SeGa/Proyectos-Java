package Clases;

public class RecNnumeros {
    public int sumaPares_con_Recusrsividad(int n){

        return n==0? 0 : n%2 == 0? n + sumaPares_con_Recusrsividad(n - 2) : sumaPares_con_Recusrsividad(n-1);

    }

    public int sumaPares_sin_Recusrsividad(int n){
        int sum =0;
        for (int i = 0 ; i <= n ; i ++) if (i % 2 == 0) sum += i;
        return sum;
    }
}
