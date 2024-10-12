package vista;

import modelo.Venta;
import modelo.Articulo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField jtfCodBarras;
    private JTextField jtfDescripcion;
    private JTextField jtfPrecio;
    private JTextField jtfCantidad;
    private JButton jbtAgregar;
    private JLabel jltotal;
    private JLabel jlartTotales;
    private JButton jbtNuevaLista;

    private Venta venta;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.venta = new Venta();

        jbtAgregar.addActionListener(new ActionListener() {
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
                jtfCodBarras.setText(null);
                jtfDescripcion.setText(null);
                jtfPrecio.setText(null);
                jtfCantidad.setText(null);

                jltotal.setText(""+venta.getTotal());
                jlartTotales.setText(""+venta.getTotalArticulos());

            }
        });

        jbtNuevaLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame("Punto de Venta");
        frame.setVisible(true);
    }

}
