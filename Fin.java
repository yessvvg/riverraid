/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Andry && Yess
 * Clase para mostar cual fue el puntaje al finalizar el juegos
 */
public class Fin extends JFrame{
    JLabel fondo,texto;
    AudioClip sonido1;///
    int j;////
    public Fin(int x,String nombre,int puntaje){
        
      
        super("River Raid Developed A&Y");
        super.setLayout(null);
        super.setBounds(0, 0, 500, 500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBackground(Color.GREEN);
        j=x;//////
        if(j==0){///
         sonido1= java.applet.Applet.newAudioClip(getClass().getResource("/sonido/win.wav"));/////////////////////////////////////
         
        }/////
        if(j==1){///
         sonido1= java.applet.Applet.newAudioClip(getClass().getResource("/sonido/game_over.wav"));////////////////////////////
         
        }/////
        sonido1.play(); //////
        if(puntaje<0){
            puntaje=0;
        }
        Guardar g=new Guardar();
        try {
            g.Cargando(nombre,puntaje);
            //g.leerarchivo();
            //g.ordenar();
            //g.mostrar();
        } catch (IOException ex) {
          //  Logger.getLogger(Fin.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        texto=new JLabel("Gracias "+nombre+" por jugar River Raid 2.0 "+
                "\ntu puntaje es: "+puntaje);
        texto.setBounds(100, 100, 500, 200);
        getContentPane().add(texto);
        
        ImageLoader loader= ImageLoader.getInstance();          
        ImageIcon icon =loader.getImage(ImageLoader.portada);
        fondo=new JLabel(icon);
        fondo.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        getContentPane().add(fondo);
        
       dispose();

        
    }
    
}
