package Clases;

public class SumaArreglo {

    public int Suma_con_Recursividad(int arrayNum[], int pos){
        int tam = pos;
        return tam == 0 ? arrayNum[tam] : arrayNum[tam] + Suma_con_Recursividad(arrayNum, tam - 1);
        //return pos < arrayNum.length ? (arrayNum[pos]) + Suma_con_Recursividad(arrayNum, pos + 1) : 0;
    }

    public int Suma_sin_Recursividad(int arrayNum[]){
        int res = 0;
        for (int i = 0 ; i < arrayNum.length ; i++) res += arrayNum[i];
        return res;
    }
}
