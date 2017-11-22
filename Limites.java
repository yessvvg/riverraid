/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Andry
 */
public class Limites extends JPanel{
    int x,y;
    Tierra t;
    
    public Limites(){
        
        
    }
    
    public void Paint(Graphics g){
        Graphics2D g2= (Graphics2D) g;
        g2.draw(t.area());
        
    }
    
    
    
}
