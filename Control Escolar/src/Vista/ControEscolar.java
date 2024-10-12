package Vista;

import Clases.Alumno;
import Clases.Fichero;
import Clases.Lista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControEscolar extends JFrame{
    private JPanel JFConEsc;
    private JButton JBTAgregar;
    private JButton JBTOrdenar;
    private JButton JBTrecuperar;
    private JButton JBTBuscar;
    private JTextField JTFNoC;
    private JTextField JTFNom;
    private JTextField JTFCal;
    private JList JlDatos;


    private Fichero controler = new Fichero();
    private Lista list;
    private Alumno alumno;

    public ControEscolar(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.JFConEsc);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.list = new Lista();

        JBTrecuperar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mostrar en la lista los datos del arcgivo recuperado
                //JlDatos.setModel(controler.recuperar());

            }
        });
        JBTAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aañadir un nuevo alumno a la clase alumno
                alumno = new Alumno(
                        Integer.parseInt(JTFNoC.getText()),
                        JTFNom.getText(),
                        Integer.parseInt(JTFCal.getText()));
                //El alumno añadido de agrega a la lista
                    list.listar(alumno);
                //La lista se añade a guardar el alumno en el fichero
                    controler.GuardarAlumno(list.getAlumnos());


                /*
                controler.GuardarAlumno(alumno = new Alumno(
                        Integer.parseInt(JTFNoC.getText()),
                        JTFNom.getText(),
                        Integer.parseInt(JTFCal.getText())));

                 */
                //Limpiar los Jtextfield
                JTFNoC.setText("");
                JTFNom.setText("");
                JTFCal.setText("");

                //Mostrar mensaje de inserccion
                JOptionPane.showMessageDialog(null,"Se ha añandido el alumno correctamente",
                        "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JBTOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo de ordenmiento de burbuja
                controler.ordBurbuja(list.getAlumnos());
            }
        });
        JBTBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                //Ingresar los datos que se solicitan
                int NoCon = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de control"));
                String nom = JOptionPane.showInputDialog("Ingresa el nombre");
                int Cal = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la calificacion"));
                //Verifica si el alumno esiste al llamar el metodo buscar
                if (controler.Buscar(NoCon,nom,Cal)){
                    JOptionPane.showMessageDialog(null,"El alumno si existe", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"No se encontro el alumno en la lista", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
                 */

            }
        });
    }




    public static void main(String[] args) {
        ControEscolar frame = new ControEscolar("Proyecto :: Control Escolar");
        frame.setVisible(true);
    }
}
