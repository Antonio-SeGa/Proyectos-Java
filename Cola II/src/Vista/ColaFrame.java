package Vista;

import Clase.Producto;
import Estructura.Cola;
import Modelo.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaFrame extends JFrame {
    private JList jlsProductos;
    private JTextField jtfCodBar;
    private JTextField jtfDescrpcion;
    private JTextField jtfCantidad;
    private JTextField jtfPrecio;
    private JButton jbtAgregar;
    private JButton JbtReniciar;
    private JButton jbtRetirar;
    private JPanel ColaFrame;
    private JLabel jlbTotalProd;
    private JLabel jlbPrecioTotal;

    private Cola cola;
    private Producto producto;
    private Venta venta;

    public ColaFrame(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.ColaFrame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        cola = new Cola(4);
        venta = new Venta();

        //cola = new Cola(Integer.parseInt(JOptionPane.showInputDialog(null ,"Ingresa el tamaño de la cola de prpductos")));
        //setTitle("Punto de venta :: Cola de articulos = "+cola.getPersonas().length);

        jlbTotalProd.setText(""+venta.getTotalProd());
        jlbPrecioTotal.setText(""+venta.getCostoTotal());

        jbtAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Producto producto = new Producto(
                            jtfCodBar.getText(),
                            jtfDescrpcion.getText(),
                            Integer.parseInt(jtfCantidad.getText()),
                            Float.parseFloat(jtfPrecio.getText())
                    );

                    cola.añadir(producto);

                    venta.setSuma(producto);

                    jlbTotalProd.setText(""+venta.getTotalProd());
                    jlbPrecioTotal.setText(""+venta.getCostoTotal());

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
                mostrar();

                // lImpiar los JTextFiel
                jtfCodBar.setText(null);
                jtfDescrpcion.setText(null);
                jtfCantidad.setText(null);
                jtfPrecio.setText(null);
            }
        });
        jbtRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cola.retirar();

                    venta.setResta(cola);

                    jlbTotalProd.setText(""+venta.getTotalProd());
                    jlbPrecioTotal.setText(""+venta.getCostoTotal());

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
                mostrar();
            }
        });
        JbtReniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola = new Cola(Integer.parseInt(JOptionPane.showInputDialog(null ,"Ingresa el tamaño de la cola de prpductos")));
                setTitle("Punto de venta :: Cola de articulos = "+cola.getPersonas().length);


            }
        });
    }
    public void mostrar(){
        Producto[] productos = this.cola.getPersonas();

        DefaultListModel list = new DefaultListModel();

        for(Producto producto : productos) {
            list.addElement(producto);

        }
        
        jlsProductos.setModel(list);
    }


    public static void main(String[] args) {
        ColaFrame frame = new ColaFrame("Punto de venta :: Cola de articulos = 4");
        frame.setVisible(true);
    }
}
