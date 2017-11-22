/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andry & Yess
 * esta clase nos ayuda a crear un menu mediante botones, los cuales creamos, 
 * diseñamos e implementamos sus acciones.
 * 
 */
public class Menu extends JFrame{
    JButton jugar,instruciones,top,creditos,salir,ayuda;
    JLabel fondo;
    public Menu(){
        super("River Raid 2.0");
        this.getContentPane().setLayout(null);
        
        jugar=new JButton("Empezar Juego");
        jugar.setBackground(Color.BLUE);
        jugar.setForeground(Color.RED);
        jugar.setBounds(0, 550, 150, 50);
        this.getContentPane().add(jugar);
        
        instruciones=new JButton("Instrucciones");
        instruciones.setBackground(Color.DARK_GRAY);
        instruciones.setForeground(Color.RED);
        instruciones.setBounds(150, 550, 150, 50);
        this.getContentPane().add(instruciones);
        
        top=new JButton("Top 10 Jugadores");
        top.setBackground(Color.LIGHT_GRAY);
        top.setForeground(Color.RED);
        top.setBounds(300, 550, 150, 50);
        this.getContentPane().add(top);
        
        creditos=new JButton("Creditos ;)");
        creditos.setBackground(Color.GREEN);
        creditos.setForeground(Color.RED);
        creditos.setBounds(450, 550, 150, 50);
        this.getContentPane().add(creditos);

        salir=new JButton("Salir");
        salir.setBackground(Color.black);
        salir.setForeground(Color.RED);
        salir.setBounds(600, 550, 150,50);
        this.getContentPane().add(salir);
        
        ayuda=new JButton("Ayuda");
        ayuda.setBackground(Color.CYAN);
        ayuda.setForeground(Color.RED);
        ayuda.setBounds(750, 550, 150, 50);
        this.getContentPane().add(ayuda);
        
        /**
         * cargamos la imagen de fondo para nuestro menu. 
         */
        
        ImageLoader lodaer= ImageLoader.getInstance();
        ImageIcon icon= lodaer.getImage(ImageLoader.portada);
        fondo= new JLabel(icon);
        fondo.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(fondo);

        /**
         *asignacion de listener del mouse para cada jbutton 
         */
        this.addWindowListener(new WindowsEvents());
        
        jugar.addActionListener(new ManejarBoton());
        instruciones.addActionListener(new ManejarBoton());
        top.addActionListener(new ManejarBoton());
        creditos.addActionListener(new ManejarBoton());
        salir.addActionListener(new ManejarBoton());
        ayuda.addActionListener(new ManejarBoton());
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    /**
     * Adecuar el tamaño de la ventana al abrir tomando en cuenta 
     * las dimensiones de la imagen de fondo y de los 4 bordes
     * Para centrar la ventana en la pantalla
     */
        public class WindowsEvents extends WindowAdapter{
        @Override
        public void windowOpened(WindowEvent e) {
            Insets inset = getInsets();
            setSize(900+inset.left+inset.right,600+inset.bottom+inset.top); 
                                                                            
            setLocationRelativeTo(null); 
        }
        @Override
        
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    /**
     * clase para menejar el actionlistener para ejecutar una accion segun el boton.
     */
    public class ManejarBoton implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            if (event.getSource()==jugar) {
               String nombre= JOptionPane.showInputDialog("nombre del jugador");
                
               if(nombre==null || nombre.equals("")||nombre.equals(null)){
                   nombre="anonimo";
               } 
               
                Ventana vent = new Ventana(nombre);
                vent.setVisible(true);
                dispose();
            }else if (event.getSource()==instruciones) {
                System.out.println("\tinstruciones para le puto jeugo");
                JOptionPane.showMessageDialog(null,"Instrucciones de Juego:\n\n"
                + "El  movimiento sera con las flechas Izquierda y Derecha y "
                + "solo podras moverte en esas direcciones unicamente\n"
                + "Podras pausar el juego presionando ''ENTER'' \n"
                + "Tines unicamente 3 vidas por partida\n"
                + "Si te golpea un enemigo o pasas sobre tierra pierdes una vida\n"
                + "Cuando destruyas cada puente aumenta la dificultad del juegos\n"
                + "Entre mas enemigos destruyas y mas tiempo dures vivo mas puntos tendras");
            }else if (event.getSource()==top) {
                pack();
                dispose();
                Guardar g =new Guardar();
                
        
                //JOptionPane.showMessageDialog(null,"Lista de jugadores TOP");
                
                
                //JOptionPane.showMessageDialog(null,"Lista de jugadores TOP");
            }else if (event.getSource()==creditos) {
                JOptionPane.showMessageDialog(null,"Juego Creado en 2017 por Andry "
               + "ovalles y Yessika Vargas\nLos cuales esperaban pasar Programacion I");      
            }else if (event.getSource()==salir) {
                int op=JOptionPane.showConfirmDialog(null,"Salir del juego?");
                if (op==JOptionPane.YES_OPTION) {
                    System.exit(0);
                }else
                    JOptionPane.showMessageDialog(null,"Bien, sigue jugando vago jaja");
                
            }else if (event.getSource()==ayuda) {
                JOptionPane.showMessageDialog(null,"Solo tienes que intentar no "
                +"estrellarte contra los enemigos ni pasar sobre tierra para ganar");
                } 
        }  
    }   
}
