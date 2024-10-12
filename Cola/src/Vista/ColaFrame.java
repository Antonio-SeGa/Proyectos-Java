package Vista;

import Clase.Producto;
import Estructura.Cola;

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

    public ColaFrame(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.ColaFrame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        cola = new Cola(4);

        jlbTotalProd.setText(""+cola.getTotalProd());
        jlbPrecioTotal.setText(""+cola.getCostoTotal());

        jbtAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cola.añadir( new Producto(
                            jtfCodBar.getText(),
                            jtfDescrpcion.getText(),
                            Integer.parseInt(jtfCantidad.getText()),
                            Float.parseFloat(jtfPrecio.getText())
                    ));

                    jlbTotalProd.setText(""+cola.getTotalProd());
                    jlbPrecioTotal.setText(""+cola.getCostoTotal());

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
                mostrar();
            }
        });
        jbtRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cola.retirar();

                    jlbTotalProd.setText(""+cola.getTotalProd());
                    jlbPrecioTotal.setText(""+cola.getCostoTotal());

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

                setTitle("Punto de venta :: Capacidad de articulos = "+cola.getPersonas().length);

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
        ColaFrame frame = new ColaFrame("Punto de venta :: Capacidad de articulos = 4");
        frame.setVisible(true);
    }
}
