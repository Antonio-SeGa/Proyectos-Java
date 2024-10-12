package Vista;

import Modelo.Alumno;
import Modelo.Listar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{
    private JPanel mainPanel;
    private JButton jbtAlumno;
    private JTextField jtfNombre;
    private JTextField jtfApPaterno;
    private JTextField jtfApMaterno;
    private JTextField jtfEdad;
    private JTextField jtfCalificacion;
    private JTextField jtfSexo;
    private JButton jbtPromedio;
    private JButton cantidadDeAlumnosPorButton;
    private JButton alumnoDestacadoButton;
    private JButton alumnoNoDestacadoButton;


    private Listar alumno;

    public Interfaz(String title) throws HeadlessException {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.alumno = new Listar(); //llamar a la clase listar

        //agregar al alumno
        jbtAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno alumnos = new Alumno(
                        jtfNombre.getText(),
                        jtfApPaterno.getText(),
                        jtfApMaterno.getText(),
                        Integer.parseInt(jtfEdad.getText()),
                        jtfSexo.getText(),
                        Float.parseFloat(jtfCalificacion.getText())
                );
                alumno.setAlumnos(alumnos);

                //Limpiar los textField
                jtfNombre.setText("");
                jtfApPaterno.setText("");
                jtfApMaterno.setText("");
                jtfEdad.setText("");
                jtfSexo.setText("");
                jtfCalificacion.setText("");
            }
        });
        //consultar el promedio de edades
        jbtPromedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El promedio de edades es " + alumno.getPromedio());
            }
        });
        //consultar el total de alumnos por sexo
        cantidadDeAlumnosPorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El total de alumno por sexo es: \nFemenino: "+alumno.getTotalMujeres()+"\nMasculino: "+alumno.getTotalHombres());
            }
        });
        //Buscar al alumno mas destacado
        alumnoDestacadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El alumno destacado es "+alumno.getAlumnoDestacado());
            }
        });
        //Buscar al alumno menos destacado
        alumnoNoDestacadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El alumno menos destacado "+alumno.getNOAlumno());
            }
        });

    }

    public static void main(String[] args) {
        Interfaz frame = new Interfaz("Alumnos");
        frame.setVisible(true);
    }

}
