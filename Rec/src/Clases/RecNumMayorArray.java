package Clases;

import java.lang.reflect.Array;

public class RecNumMayorArray {
    public int Max_Rec(int arrayNum[], int pos){
        /*
        if(arrayNum.length - 1 == pos)   max = arrayNum[pos];
        else {
            if (arrayNum[pos] > NumMayor_Array_Rec(arrayNum, pos + 1)){
                max = arrayNum[pos];
            }
            else {
                max = NumMayor_Array_Rec(arrayNum, pos + 1);
            }
        }
         */

        return arrayNum.length - 1 == pos? arrayNum[pos] : arrayNum[pos] > Max_Rec(arrayNum, pos + 1)? arrayNum[pos] : Max_Rec(arrayNum, pos + 1);



    }

    public int NumMayor_Array_sRec(int arrayNum[]){
        int mayor = 0;
        for (int i = 0; i < arrayNum.length ; i++) if (arrayNum[i] > mayor) mayor = arrayNum[i];
        return mayor;
    }
}
