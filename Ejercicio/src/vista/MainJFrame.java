package vista;

import modelo.Venta;
import modelo.Articulo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrame extends JFrame {
    private JPanel mainPanel;
    private JButton jbtTotales;
    private JTextField jtfCodBarras;
    private JTextField jtfDescripcion;
    private JTextField jtfPrecio;
    private JTextField jtfCantidad;
    private JLabel jltotal;
    private JLabel jlartTotales;

    private Venta venta;

    public MainJFrame(String title) throws HeadlessException {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.venta = new Venta();

        //Acciones del boton Agregar
        jbtTotales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Articulo articulo = new Articulo(
                        jtfCodBarras.getText(),
                        jtfDescripcion.getText(),
                        Float.parseFloat(jtfPrecio.getText()),
                        Integer.parseInt(jtfCantidad.getText())
                );
                venta.setArticulo(articulo);

                //Borrar elemetos del jTextField
                jtfCodBarras.setText("");
                jtfDescripcion.setText("");
                jtfPrecio.setText("");
                jtfCantidad.setText("");

                //este imprime el resultado en las etiquetas
                jltotal.setText(""+venta.getTotal());
                jlartTotales.setText(""+venta.getTotalArticulos());
            }
        });
    }

    public static void main(String[] args) {
        MainJFrame frame = new MainJFrame("Punto de Venta");
        frame.setVisible(true);

    }
}
