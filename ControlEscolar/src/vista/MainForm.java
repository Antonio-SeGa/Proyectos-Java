package vista;

import estructura.Principal;
import modelo.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    private JButton jbtEscribir;
    private JButton jbtEditar;
    private JButton jbtMostrar;
    private JButton jbtSalir;
    private JButton jbtOrdenar;
    private JPanel MainPanel;
    private JButton jbtBorrar;
    private Principal principal;
    private String Nombre;
    private String ApellP;
    private String ApellM;
    private String Matricula;
    private float Promedio;
    private String Sexo;
    private int Edad;


    public MainForm(String title) throws HeadlessException {
        super(title);
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.principal = new Principal();
//Designacion de la funcion de los botones
        jbtEscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre: ");
                ApellP = JOptionPane.showInputDialog(null,"Ingrese el apellido paterno: ");
                ApellM = JOptionPane.showInputDialog(null,"Ingrese el apellido materno: ");
                Matricula = JOptionPane.showInputDialog(null,"Ingrese la matricula: ");
                Promedio = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el promedio: "));
                Sexo = JOptionPane.showInputDialog(null,"Ingrese el sexo: ");
                Edad =Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad: "));
                principal.InsertarAlumno(new Alumno(Nombre,ApellP,ApellM,Matricula,Promedio,Sexo,Edad));
            }
        });

        jbtEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.modificarFichero();
            }
        });
        jbtOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.OrdenamientoMetodoBurbuja();
            }
        });
        jbtSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jbtMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.Consultar();
            }
        });
        jbtBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.Borrar();
            }
        });
    }
    public static void main(String[] args) {
        vista.MainForm frame = new vista.MainForm("");
        frame.setVisible(true);
    }
}


