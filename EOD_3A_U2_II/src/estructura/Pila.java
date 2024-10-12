package estructura;

import entidad.Persona;

public class Pila {
    private int tope;
    private int posicion;
    private Persona[] personas;

    public Pila(int tope) {
        this.tope = tope;
        this.personas = new Persona[this.tope];
        this.posicion = 0;
    }

    public void push(Persona persona) throws Exception {  //Ingresar una persona
        if(this.llena()) throw new Exception("La pila de personas esta llena!!!");
        if (posicion == 0 ) this.personas[this.posicion++] = persona;
        else {
            for (int pos = this.posicion++; pos > 0 ; pos--){
                this.personas[pos] = this.personas[pos-1];
            }
            this.personas[0] = persona;
        }
    }

    public void pop() throws Exception{ //Eliminar o retirar a una persona
        if(this.vacio()) throw new Exception("La pila de personas esta vacia");
        this.personas[--posicion] = null;
    }

    public Persona[] getPersonas() {
        return this.personas;
    }

    public boolean vacio() {
        return this.posicion == 0;
    }

    public boolean llena() {
        return this.posicion >= this.tope;
    }

}
