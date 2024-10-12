package Vista;

import Clase.Producto;
import Estructura.Cola;

public class mostrar {
    public static void main(String[] args) {

        Cola cola = new Cola(4);

        try {

            cola.añadir(new Producto("P","1",2,2));
            cola.añadir(new Producto("P","2",3,2));
            cola.añadir(new Producto("P","3",4,2));
            cola.añadir(new Producto("P","4",5,2));


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
