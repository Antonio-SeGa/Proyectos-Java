package Vista;

import Clases.Alumno;
import Clases.Fichero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlEscolar extends JFrame {
    private JButton JbnCrear;
    private JButton JbtnModificar;
    private JButton JbtnBuscar;
    private JTextField JTFNoC;
    private JTextField JTFNOM;
    private JTextField JTFCal;
    private JPanel JFControl;
    private JButton JbtnOrdenar;
    private JButton eliminarButton;
    private JList Jlist;
    private JButton recuperarButton;

    private Fichero fichero;
    private Alumno alumno;

    public ControlEscolar(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.JFControl);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.fichero = new Fichero();

        JbnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Inserccion dl nuevo alumno al fihero
                fichero.nuevoAlumno(new Alumno(JTFNoC.getText(),
                        JTFNOM.getText(),
                        Integer.parseInt(JTFCal.getText())));

                //Limpiar los JTextField
                JTFNoC.setText(null);
                JTFNOM.setText(null);
                JTFCal.setText(null);

                //Mandar el mensaje de la inserccion
                JOptionPane.showMessageDialog(null,"El alumno ha sido registrado correctamente", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JbtnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo actualizar
                fichero.Actualizar();
            }
        });
        JbtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo buscar
                fichero.consulta();
            }
        });
        JbtnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar a metodo ordenar
                fichero.Ordenar();
                //Mandar un mensaje cuando el metodo se haya realizado
                JOptionPane.showMessageDialog(null,"Los datos de han ordendo por calificaion","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo de eliminar a un alumno
                fichero.eliminar();
                //Mensaje de la eliminacion del alumno
                JOptionPane.showMessageDialog(null,"Ela alumno ha sido eliminado");
            }
        });
        recuperarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo mostrar
                mostrar();
            }
        });
    }
    
    public void mostrar(){
        //Este metodo realiza su funcion de acumular los datos a traves de una lista
        DefaultListModel list = new DefaultListModel();
        ArrayList<Alumno> alumnos = (ArrayList<Alumno>) fichero.getAlumnos(); //Llamar al metodo que returna la lista de alumnos
        for (Alumno a:alumnos){
            list.addElement(a);
        }
        Jlist.setModel(list);
    }
    
    public static void main(String[] args) {
        ControlEscolar frame = new ControlEscolar("Proyecto :: Control Escolar");
        frame.setVisible(true);
    }

}
