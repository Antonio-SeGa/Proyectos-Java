package vista;

import modelo.Articulo;
import modelo.Venta;

import javax.swing.*;
import java.util.*;

public class mostrar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //llamar a la clase Venta
        Venta venta = new Venta();
        String resp = "S";


        do {
            //llamar a la clase articulo
            Articulo a = new Articulo();

            //Ingresar los datos del Articulo mediante el llamado de la clase
            System.out.println("Ingresa el codigo de barras: ");
            a.setCodBarras(sc.next());

            System.out.println("Ingresa la descripcion: ");
            a.setDescripcion(sc.next());

            System.out.println("Ingresa el precio: ");
            a.setPrecio(sc.nextFloat());

            System.out.println("Ingresa la cantidad de este producto: ");
            a.setCantidad(sc.nextInt());

            venta.setArticulo(a); //Agregar los datos del Articulo

            //Con este determinar el fin o seguir con agregar articulos
            System.out.println("Deseas ingresar otro producto [S/N]?");
            resp = sc.next();

        } while (resp.charAt(0)=='S' || resp.charAt(0)=='s');

        //Imprime los valores tanto de la venta total y del total de articulos de la Venta
        System.out.println("TOTAL DE LA VENTA: " + venta.getTotal());
        System.out.println("TOTAL DE ARTICULOS ADQUIRIDOS: " +  venta.getTotalArticulos());

        System.exit(0);
    }
}
