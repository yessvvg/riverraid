/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Andry & Yess
 * clase creada para cargar las imagenes mediante los metodos ImageLoader
 * ImageIcon.
 * 
 */
public class ImageLoader {
    private static ImageLoader instance=null;
    public static final int avion=0;
    public static final int mapa1=1,mapa2=2,mapa3=3;
    public static final int cubo=4,helicoptero=5,barco=6;
    public static final int titulo=7,portada=8,combustible=9;
    public static final int puente=10,bala=11,isla=12;

    private  ImageIcon ico[] ; //javax.swing.ImageIcon(getClass().getResource("/images/rio.png"));    
    /**
     * metodo para cargar vector de iconos con todas las imagenes de las carpetas.
     */
    
    public ImageLoader(){
        String filenames[]= new String[]{"nave", "river","mapa2","mapa3","image_122",
                                         "helicoptero","barco","titulo","caratula","combustible",
                                         "puente","bala","isla"};   
        ico = new ImageIcon[13];
        for (int i = 0; i < 13; i++) {
            
          URL url=this.getClass().getResource("images/"+filenames[i]+".png");
          ico[i]=new ImageIcon(url);   
        } 
    }
    
    /**
     * metodo para instanciar la clase ImageLoader.
     * @return 
     */
     public static ImageLoader getInstance(){
        if(instance==null)
          instance = new ImageLoader();

        return instance;
    
    }
     
     /**
      * metodo para devolver el icono con la imagen.
      *
      * @return 
      */
     
         public ImageIcon getImage(int n){
           if(n<0 || n>=13)
            return null;
           
            return ico[n];
    }
}
