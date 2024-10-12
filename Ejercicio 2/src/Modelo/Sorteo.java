package Modelo;

import java.util.ArrayList;
import java.util.*;

public class Sorteo {
    private List<Participante> participantes;
    private int totalParticipantes;
    private int totalAportaciones;
    private float totalGralTandaP;
    private int totalTanda;


    public Sorteo(){
        this.participantes = new ArrayList<>();
        this.totalParticipantes = 0;
        this.totalAportaciones = 0;
        this.totalGralTandaP = 0;
        this.totalTanda = 0;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    //añadir a los participantes a un arreglo
    public void setParticipantes(Participante participante){
        this.participantes.add(participante);
        this.totalAportaciones = participante.getTotalAportaciones();
    }

    //Regresa cuantos participantes estan en la tanda
    public int getTotalParticipantes(){
        return this.totalParticipantes = participantes.size();
    }

    //Regresa el total de aportaciones por partuicipante
    public int getTotalAportaciones(){
        return this.totalAportaciones;
    }

    //regresa el total por participante
    public float getTotalGralTandaP() {
        return totalGralTandaP = participantes.get(0).getTotal();
    }

    //Calcula el total general de la tanda
    public float getTotalTanda(){
        for (Participante p: participantes) {
            totalTanda += getTotalGralTandaP();
        }
        return totalTanda;
    }

    //Mostrar el orden de los participantes
    public int[] getOrdenar(){
        Random random = new Random();
        int tamaño = participantes.size();
        int[] order = new int[tamaño];

        for(int c1=0; c1<tamaño;) {
            boolean find  = false;
            order[c1] = random.nextInt(tamaño) + 1;

            for(int c2=0; c2<c1 && !find; c2++) {
                find = order[c1]==order[c2];
            }

            if(!find) c1++;
        }

        return order;
    }


}
