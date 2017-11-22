/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andry
 */
public class Bala extends JPanel{
    int x,y;
    JPanel bala;
    public Bala(int x, int y) {
        this.x = x;
        this.y = y;
        /*
        ImageLoader loader= new ImageLoader();
        ImageIcon icon =loader.getImage(ImageLoader.bala);
        bala=new JLabel(icon);
        bala.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
        getContentPane().add(bala);*/
       bala=new JPanel ();
        setBounds(x, y, 6, 20);
        setBackground(Color.RED);
        setVisible(true);

        
    }
    
    
    public void paint (Graphics e){
        e.setColor(Color.RED);
        e.fillRect(0, 0, getWidth(),getHeight());
        
   
        
    }

    public void mover(int m){
        y=y-m;
        setLocation(x, y-m);
        
        
    }
    
    
    
    
}
