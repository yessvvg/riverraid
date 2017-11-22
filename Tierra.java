/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
//import jdk.nashorn.internal.ir.BreakableNode;

/**
 *
 * @author Andry & Yess
 * Clase que revise como parametro un entero para saber que rectangulo dibujar para el momento de evaluar la
 * colicion del avion con la tierra
 */
public class Tierra extends JPanel {
   int x;
   int y;
   int op;
   public Tierra(int n){
       
       op=n;
       
       
      switch (op){
       
      case 1:
          setBounds(540, 328, 100,274 );
      break;
      case 2:
          setBounds(295, 332, 65,275 );
      break;
      case 3:
          setBounds(655, -200, 10,520 );
      break;
      case 4:
          setBounds(240, -200, 10,520 );
      break;
      case 5:
          setBounds(870, -675, 10,304 );
      break;
      case 6:
          setBounds(95, -890, 10,510 );
      break;
      case 7:
          setBounds(745,-1060 , 10,288 );
      break;
      case 8:
          setBounds(770,-755 , 55,20 );
      break;
      case 9:
          setBounds(815,-720 , 20,20 );
      break;
      case 10:
          setBounds(125,-962 , 10,30);
      break;
      case 11:
          setBounds(149,-1010 , 10,30 );
      break;
      case 12:
           setBounds(171,-1083 , 10,30 );
      break;
      case 13:
          setBounds(209,-1145  , 10,30 );
      break;
      case 14:
          setBounds(660,-1167 , 10,20 );
      break;
      case 15:
          setBounds(690,-1120 , 10,23 );
      break;
          
      default:
         
      }       
             
               
               
               
        
       
   }
 
   Rectangle2D area(){
        return new Rectangle2D.Double(x, y, 100, 500);
    }
    
}
