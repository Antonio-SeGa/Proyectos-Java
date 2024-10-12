package vista;

import entidad.Persona;
import estructura.Pila;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JList jlsPersonas;
    private JPanel MainPanel;
    private JButton jbtAgregar;
    private JButton jbtRetirar;
    private JButton jbtMostrar;
    private JTextField jtfNombre;
    private JTextField jtfApellidos;
    private JButton jbtReiniciar;
    private Pila pila;

    public MainForm(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.pila = new Pila(4);

        jbtAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        pila.push(new Persona(jtfNombre.getText(),jtfApellidos.getText()));
                        mostrar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        jbtRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila.pop();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage());
                }
                mostrar();
            }
        });
        jbtReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tope;
                tope=Integer.parseInt(JOptionPane.showInputDialog("TOPE SE LA PILA"));
                pila = new Pila(tope);
                setTitle("Estructura :: Pila("+tope+")");

            }
        });
    }

    public void mostrar() {
        Persona[] personas = this.pila.getPersonas();

        //this.jlsPersonas.removeAll();

        DefaultListModel list = new DefaultListModel();

        for(Persona persona : personas) {
            list.addElement(persona);
        }

        jlsPersonas.setModel(list);
    }

    public static void main(String[] args) {
        MainForm frame = new MainForm("Estructura :: Pila(4)");
        frame.setVisible(true);
    }

}
