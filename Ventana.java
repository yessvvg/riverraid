/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ContainerListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.ABORT;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.applet.AudioClip;//////


/**
 *
 * @author Andry && YESS
 * clase ventana que no resive ningun parametro e inica todo el juego en general pintando la posicion 
 * inicial de todos los objetos dentro del Frame
 */

public class Ventana extends JFrame {
    
    public JLabel mapa1,mapa2,mapa3,mapa4,avion,cubo,helicoptero,barco,titulo,gasolina;
    public JLabel puente,isla,vidas,puntos;
    JPanel barraint=new JPanel();
    Timer timermapa;
    AudioClip sonido,sonidoboom,son1,son2,laser;/////
    int cont=0,acum=0,tiempo=100;
    int v=12,vida=3,puntaje=0,vidapuente=3,xr,band;
    int fuel=250;
    String nombre;
    Tierra t,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    Bala b;
    ArrayList <Bala> balas= new ArrayList<>();
    Random r = new Random();

    public int getPuntaje() {
        return puntaje;
    }
 
    
    public Ventana(String nombre){
        super("River Raid");
        this.setBounds(0, 0, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre=nombre;


        this.addWindowListener(new WindowsEvents());
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Point p = avion.getLocation();  
                timermapa.start();

                if(e.getKeyCode()==e.VK_RIGHT){
                    p.x += 5;                
                }else if(e.getKeyCode()==e.VK_LEFT){
                    p.x -= 5;
                }else if(e.getKeyCode()==e.VK_UP){
                     timermapa.setDelay(20);
                }else if(e.getKeyCode()==e.VK_ENTER){
                    timermapa.stop();
                }else if (e.getKeyCode()==e.VK_SPACE) {
                    laser= java.applet.Applet.newAudioClip(getClass().getResource("/sonido/silver_shot.wav"));
                    laser.play();
                    disparo();
                    
                }
                avion.setLocation(p); 
            } 

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
                if(e.getKeyCode()==e.VK_UP){
                    timermapa.setDelay(tiempo);
                }
            } 
         });
        
         initComponents();
        
        timermapa= new Timer(tiempo,new TimerMapa());
        
    }
    
    /**
     * Funcion disparo que no resive ningun valor y la cual genera las balas 
     * del avion 
     */
           
        public void disparo(){
            Point t;
            int x , y;
            t=avion.getLocation();
            x=t.x;
            x+=30;
            y=t.y;
            
            balas.add(new Bala(x, y));
            
            for (Bala bala :balas) {
                    getContentPane().add(bala);
                    //bala.mover(20);
                   // bala.repaint();
                }
        }
    
    /**
     * Funcion sin valores de entrada la cual pinta y inicia todos los objetos visibles y no 
     * visibles del juego
     */
    
    public void initComponents(){
         this.getContentPane().setLayout(null);
        
       // ImageLoader loader = ImageLoader.getInstance();
               sonido= java.applet.Applet.newAudioClip(getClass().getResource("/sonido/acid.wav"));////
        sonidoboom= java.applet.Applet.newAudioClip(getClass().getResource("/sonido/lose.wav"));/////
        ImageLoader loader= new ImageLoader();
       
        ImageIcon icon = loader.getImage(ImageLoader.avion);
        avion=new JLabel(icon);
        avion.setBounds(405, 410,icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(avion);
        
        t=new Tierra(1);
        getContentPane().add(t);
        t.setVisible(false);
        t2=new Tierra(2);
        getContentPane().add(t2);
        t2.setVisible(false);
        t3=new Tierra(3);
        getContentPane().add(t3);
        t3.setVisible(false);
        t4=new Tierra(4);
        getContentPane().add(t4);
        t4.setVisible(false);
        t5=new Tierra(5);
        getContentPane().add(t5);
        t5.setVisible(false);
        t6=new Tierra(6);
        getContentPane().add(t6);
        t6.setVisible(false);
        t7=new Tierra(7);
        getContentPane().add(t7);
        t7.setVisible(false);
        t8=new Tierra(8);
        getContentPane().add(t8);
        t8.setVisible(false);
        t9=new Tierra(9);
        getContentPane().add(t9);
        t9.setVisible(false);
        t10=new Tierra(10);
        getContentPane().add(t10);
        t10.setVisible(false);
        t11=new Tierra(11);
        getContentPane().add(t11);
        t11.setVisible(false);
        t12=new Tierra(12);
        getContentPane().add(t12);
        t12.setVisible(false);
        t13=new Tierra(13);
        getContentPane().add(t13);
        t13.setVisible(false);
        t14=new Tierra(14);
        getContentPane().add(t14);
        t14.setVisible(false);
        t15=new Tierra(15);
        getContentPane().add(t15);
        t15.setVisible(false);
        
        JLabel nombre=new JLabel("FUEL");
        nombre.setBounds(90, 470, 50, 30);
        nombre.setForeground(Color.CYAN);
 
        getContentPane().add(nombre);
        
        barraint.setBounds(5, 505, 250, 30);
        barraint.setBackground(Color.RED);
        getContentPane().add(barraint);          
        
        JLabel barraext=new JLabel();
        barraext.setBounds(0, 500, 260, 40);
        barraext.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        getContentPane().add(barraext);
        
        vidas=new JLabel("VIDAS: "+vida);
        vidas.setBounds(420,475,50,30);
        getContentPane().add(vidas);
        
        puntos=new JLabel("Puntos: "+puntaje);
        puntos.setBounds(420, 500, 100, 30);
        getContentPane().add(puntos);
        
        icon=loader.getImage(ImageLoader.titulo);
        titulo=new JLabel(icon);
        titulo.setBounds(0,470, icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(titulo);

        icon=loader.getImage(ImageLoader.combustible);
        gasolina=new JLabel(icon);
        xr=(int) ((r.nextDouble()*300+300));
        gasolina.setBounds(xr, 160,icon.getIconWidth(),icon.getIconHeight());
        getContentPane().add(gasolina);
        
        icon=loader.getImage(ImageLoader.puente);
        puente=new JLabel(icon);
        puente.setBounds(363, -1414,icon.getIconWidth(),icon.getIconHeight());
        getContentPane().add(puente);
        
        icon = loader.getImage(ImageLoader.cubo);
        cubo=new JLabel(icon);
        xr=(int) ((r.nextDouble()*200 +250));
        cubo.setBounds(xr, 50, icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(cubo);
        
        icon=loader.getImage(ImageLoader.helicoptero);
        helicoptero=new JLabel(icon);
        xr=(int) ((r.nextDouble()*200 +250));
        helicoptero.setBounds(xr,-600, icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(helicoptero);
        
        icon=loader.getImage(ImageLoader.barco);
        barco=new JLabel(icon);
        int xc=(int) ((r.nextDouble()*2+1));
        if(xc==1){
         barco.setBounds(210,-1000,icon.getIconWidth(),icon.getIconHeight());
         this.getContentPane().add(barco);
        }else{
         barco.setBounds(510,-1000,icon.getIconWidth(),icon.getIconHeight());
         this.getContentPane().add(barco);
        }
        
        icon=loader.getImage(ImageLoader.isla);
        isla=new JLabel(icon);
        isla.setBounds(291, -955, icon.getIconWidth(), icon.getIconHeight());
        getContentPane().add(isla);
        
        icon = loader.getImage(ImageLoader.mapa1);
        mapa1=new JLabel(icon);
        mapa1.setBounds(0, 0, icon.getIconWidth(),icon.getIconHeight());
        mapa1.setOpaque(true);
        this.getContentPane().add(mapa1);

        icon = loader.getImage(ImageLoader.mapa2);
        mapa2=new JLabel(icon);
        mapa2.setBounds(0, -600, icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(mapa2);
 
        icon = loader.getImage(ImageLoader.mapa3);
        mapa3=new JLabel(icon);
        mapa3.setBounds(0, -1200, icon.getIconWidth(),icon.getIconHeight());
        this.getContentPane().add(mapa3);
        setResizable(false); 
        sonido.loop();///////////////////
    }
    
    /**
     * Clase para acomodar el tamaño del Frame y centrarlo en la pantalla
     */
        class WindowsEvents extends WindowAdapter{
        @Override
        public void windowOpened(WindowEvent e) {
            Insets inset = getInsets();
            setSize(900+inset.left+inset.right,600+inset.bottom+inset.top); //Adecuar el tamaño de la ventana a abrir tomando en cuenta 
                                                                            //las dimensiones de la imagen de fondo y de los 4 bordes
            setLocationRelativeTo(null); //Para centrar la ventana en la pantalla    
        }
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }   
        
        /**
         * Clase timer la cual no revise ningun valor y es la encargada
         * de realizar el movimiento del juego y evaluar las condiciones
         * de si ha sucedido algun choque o terminado el tiempo de juego
         */
        
        class TimerMapa implements ActionListener{
            public void actionPerformed(ActionEvent e){
                
                int y=0;
                
                for (Bala bala : balas) {
                bala.mover(20);
                }
                
                vidas.setText("VIDAS: "+vida);
                vidas.setBounds(420,475,50,30);
                
                puntos.setText("Puntos: "+puntaje);
                puntos.setBounds(420,500,100, 30);
                repaint();
                
                cont+=1;
                fuel-=1;
                
                Point p1,p2,p3,p4,p5,is;
                Point t1;
                Point T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15;
                Point full;
                Point enemigo1,enemigo2,enemigo3;
                p1= mapa1.getLocation();
                p2= mapa2.getLocation();
                p3= mapa3.getLocation();
                p4=gasolina.getLocation();
                p5=puente.getLocation();
                
                t1=t.getLocation();
                T2=t2.getLocation();
                T3=t3.getLocation();
                T4=t4.getLocation();
                T5=t5.getLocation();
                T6=t6.getLocation();
                T7=t7.getLocation();
                T8=t8.getLocation();
                T9=t9.getLocation();
                T10=t10.getLocation();
                T11=t11.getLocation();
                T12=t12.getLocation();
                T13=t13.getLocation();
                T14=t14.getLocation();
                T15=t15.getLocation();
                
                enemigo1=cubo.getLocation();
                enemigo2=helicoptero.getLocation();
                enemigo3=barco.getLocation();
                is=isla.getLocation();
                full=barraint.getLocation();

                p1.y+=v;
                p2.y+=v;
                p3.y+=v;
                p4.y+=v;
                p5.y+=v;
                t1.y+=v;
                T2.y+=v;
                T3.y+=v;
                T4.y+=v;
                T5.y+=v;
                T6.y+=v;
                T7.y+=v;
                T8.y+=v;
                T9.y+=v;
                T10.y+=v;
                T11.y+=v;
                T12.y+=v;
                T13.y+=v;
                T14.y+=v;
                T15.y+=v;
                
                enemigo1.y+=v;
                enemigo2.y+=v;
                enemigo3.y+=v;
                is.y+=v;
                full.x-=1;
                
                mapa1.setLocation(p1);
                mapa2.setLocation(p2);
                mapa3.setLocation(p3);
                cubo.setLocation(enemigo1);
                helicoptero.setLocation(enemigo2);
                barco.setLocation(enemigo3);
                gasolina.setLocation(p4);
                puente.setLocation(p5);
                t.setLocation(t1);
                t2.setLocation(T2);
                t3.setLocation(T3);
                t4.setLocation(T4);
                t5.setLocation(T5);
                t6.setLocation(T6);
                t7.setLocation(T7);
                t8.setLocation(T8);
                t9.setLocation(T9);
                t10.setLocation(T10);
                t11.setLocation(T11);
                t12.setLocation(T12);
                t13.setLocation(T13);
                t14.setLocation(T14);
                t15.setLocation(T15);

                isla.setLocation(is);
                barraint.setLocation(full);

                if(p1.y>=600){
                    p1.y=-1200; 
                    mapa1.setLocation(p1);
                }
                if(p2.y>=600){
                    p2.y=-1200;
                    mapa2.setLocation(p2);     
                }
                if(p3.y>=600){
                    p3.y=-1200;
                    mapa3.setLocation(p3);
                } 
                if(enemigo1.y>=600){
                    enemigo1.y=-1200;
                    cubo.setLocation(enemigo1);     
                }
                if (enemigo2.y>=600){
                    enemigo2.y=-1200;
                    helicoptero.setLocation(enemigo2);
                }
                if (enemigo3.y>=600){
                    enemigo3.y=-1200;
                    barco.setLocation(enemigo3);
                }
                if(p4.y>=600){
                    p4.y=-1200;
                    gasolina.setLocation(p4);
                }
                if(is.y>=600){
                    is.y=-1200;
                    isla.setLocation(is);
                }
                if(t1.y>=600){
                    t1.y=-1200;
                    t.setLocation(t1);
                }
                if(T2.y>=600){
                    T2.y=-1200;
                    t2.setLocation(T2);
                }
                if(T3.y>=600){
                    T3.y=-1200;
                    t3.setLocation(T3);
                }
                if(T4.y>=600){
                    T4.y=-1200;
                    t4.setLocation(T4);
                }
                if(T5.y>=600){
                    T5.y=-1200;
                    t5.setLocation(T5);
                }
                if(T6.y>=600){
                    T6.y=-1200;
                    t6.setLocation(T6);
                }
                if(T7.y>=600){
                    T7.y=-1200;
                    t7.setLocation(T7);
                }
                if(T8.y>=600){
                    T8.y=-1200;
                    t8.setLocation(T8);
                }
                if(T9.y>=600){
                    T9.y=-1200;
                    t9.setLocation(T9);
                }
                if(T10.y>=600){
                    T10.y=-1200;
                    t10.setLocation(T10);
                }
                if(T11.y>=600){
                    T11.y=-1200;
                    t11.setLocation(T11);  
                }
                if(T12.y>=600){
                    T12.y=-1200;
                    t12.setLocation(T12);
                }
                if(T13.y>=600){
                    T13.y=-1200;
                    t13.setLocation(T13);
                }
                if(T14.y>=600){
                    T14.y=-1200;
                    t14.setLocation(T14);
                }
                if(T15.y>=600){
                    T15.y=-1200;
                    t15.setLocation(T15);
                }

                Point pv,pb ;
                for (int i = 0; i < balas.size(); i++) {

                    if(helicoptero.getBounds().intersects(balas.get(i).getBounds())){
                        sonidoboom.stop();/////////////
                        sonidoboom.play();////////////////
                        pv=helicoptero.getLocation();
                        y=(600-pv.y);
                        helicoptero.setLocation(300,(-1200-y));
                        puntaje+=200;
                        balas.remove(i);
                        
                    }else if(cubo.getBounds().intersects(balas.get(i).getBounds())){
                         sonidoboom.stop();/////////////////
                        sonidoboom.play();////////////////////
                        pv=cubo.getLocation();
                        y=(600-pv.y);
                        cubo.setLocation(400, (-1200-y));
                        puntaje+=200;
                        balas.remove(i);
                    }else if(barco.getBounds().intersects(balas.get(i).getBounds())){
                        //barco.setIcon(null);
                        sonidoboom.stop();/////////////////
                        sonidoboom.play();////////////////////
                        pv=barco.getLocation();
                        y=(600-pv.y);
                        barco.setLocation(210,(-1200-y));
                        puntaje+=200;
                        balas.remove(i);
                    }else if(gasolina.getBounds().intersects(balas.get(i).getBounds())) {
                        sonidoboom.stop();/////////////////
                        sonidoboom.play();////////////////////
                        pv=gasolina.getLocation();
                        y=(600-pv.y);
                        gasolina.setLocation(500, (-1200-y));
                        puntaje-=100;
                        balas.remove(i);
                    }else if(puente.getBounds().intersects(balas.get(i).getBounds())){
                         sonidoboom.stop();/////////////////
                        sonidoboom.play();////////////////////
                        vidapuente-=1;
                        puntaje+=100;
                        balas.remove(i);
                    }
                                     
                    if (balas.size()>0){
                        pb=balas.get(i).getLocation();
                        if (pb.y<0) {
                           balas.remove(i);
                        System.out.println("asdasdasd");  
                        }
                    }
                }
                    
                if(avion.getBounds().intersects(helicoptero.getBounds())
                   ||avion.getBounds().intersects(barco.getBounds())
                   ||avion.getBounds().intersects(cubo.getBounds())
                   ||avion.getBounds().intersects(puente.getBounds())
                   ||avion.getBounds().intersects(isla.getBounds())){
                    avion.setLocation(405,410);
                    vida-=1;
                    puntaje-=200;
                    fuel=250;
                    p1.y=0;
                    p2.y=-600;
                    p3.y=-1200;
                    enemigo1.y=50;
                    enemigo2.y=-600;
                    enemigo3.y=-1000;
                    p4.y=160;
                    p5.y=-1414;
                    t1.y=328;
                    is.y=-955;
                    full.x=0;
                    
                    t1.y=328;
                    T2.y=332;
                    T3.y=-200;
                    T4.y=-200;
                    T5.y=-675;
                    T6.y=-890;
                    T7.y=-1060;
                    T8.y=-755;
                    T9.y=-720;
                    T10.y=-962;
                    T11.y=-1010;
                    T12.y=-1083;
                    T13.y=-1145;
                    T14.y=-1167;
                    T15.y=-1120;
                    
                    mapa1.setLocation(p1);
                    mapa2.setLocation(p2);
                    mapa3.setLocation(p3);
                    cubo.setLocation(enemigo1);
                    helicoptero.setLocation(enemigo2);
                    barco.setLocation(enemigo3);
                    gasolina.setLocation(p4);
                    puente.setLocation(p5);
                    t.setLocation(t1);
                    isla.setLocation(is);
                    barraint.setLocation(full);
                    
                    t.setLocation(t1);
                    t2.setLocation(T2);
                    t3.setLocation(T3);
                    t4.setLocation(T4);
                    t5.setLocation(T5);
                    t6.setLocation(T6);
                    t7.setLocation(T7);
                    t8.setLocation(T8);
                    t9.setLocation(T9);
                    t10.setLocation(T10);
                    t11.setLocation(T11);
                    t12.setLocation(T12);
                    t13.setLocation(T13);
                    t14.setLocation(T14);
                    t15.setLocation(T15);      
                }
                if(avion.getBounds().intersects(t.getBounds())||avion.getBounds().intersects(t2.getBounds())
                 ||avion.getBounds().intersects(t3.getBounds())||avion.getBounds().intersects(t4.getBounds())
                 ||avion.getBounds().intersects(t5.getBounds())||avion.getBounds().intersects(t6.getBounds())
                 ||avion.getBounds().intersects(t7.getBounds())||avion.getBounds().intersects(t8.getBounds())
                 ||avion.getBounds().intersects(t9.getBounds())||avion.getBounds().intersects(t10.getBounds())
                 ||avion.getBounds().intersects(t11.getBounds())||avion.getBounds().intersects(t12.getBounds())
                 ||avion.getBounds().intersects(t13.getBounds())||avion.getBounds().intersects(t14.getBounds())
                 ||avion.getBounds().intersects(t15.getBounds())){
                    avion.setLocation(405, 410);
                    vida-=1;
                    puntaje-=200;
                    fuel=250;
                    
                    p1.y=0;
                    p2.y=-600;
                    p3.y=-1200;
                    enemigo1.y=50;
                    enemigo2.y=-600;
                    enemigo3.y=-1000;
                    p4.y=160;
                    p5.y=-1414;
                    t1.y=328;
                    is.y=-955;
                    full.x=0;
                    
                    t1.y=328;
                    T2.y=332;
                    T3.y=-200;
                    T4.y=-200;
                    T5.y=-675;
                    T6.y=-890;
                    T7.y=-1060;
                    T8.y=-755;
                    T9.y=-720;
                    T10.y=-962;
                    T11.y=-1010;
                    T12.y=-1083;
                    T13.y=-1145;
                    T14.y=-1167;
                    T15.y=-1120;
                    
                    mapa1.setLocation(p1);
                    mapa2.setLocation(p2);
                    mapa3.setLocation(p3);
                    cubo.setLocation(enemigo1);
                    helicoptero.setLocation(enemigo2);
                    barco.setLocation(enemigo3);
                    gasolina.setLocation(p4);
                    puente.setLocation(p5);
                    t.setLocation(t1);
                    isla.setLocation(is);
                    barraint.setLocation(full);
                    t.setLocation(t1);
                    t2.setLocation(T2);
                    t3.setLocation(T3);
                    t4.setLocation(T4);
                    t5.setLocation(T5);
                    t6.setLocation(T6);
                    t7.setLocation(T7);
                    t8.setLocation(T8);
                    t9.setLocation(T9);
                    t10.setLocation(T10);
                    t11.setLocation(T11);
                    t12.setLocation(T12);
                    t13.setLocation(T13);
                    t14.setLocation(T14);
                    t15.setLocation(T15);     
                }
                
                if(avion.getBounds().intersects(gasolina.getBounds())){
                    fuel=250;
                    full.x=0;
                    barraint.setLocation(full);
                }
                if(vidapuente==0){
                    tiempo-=10;
                    puntaje+=100;
                    pv=puente.getLocation();
                    y=(600-pv.y);
                    puente.setLocation(363, (-1200-y));
                    vidapuente=3;
                    timermapa.setDelay(tiempo);
                }
                
                if(fuel==0){
                    vida-=1;
                    fuel=250;
                    avion.setLocation(405, 410);
                    full.x=0;
                    barraint.setLocation(full);
                    
                    p1.y=0;
                    p2.y=-600;
                    p3.y=-1200;
                    enemigo1.y=50;
                    enemigo2.y=-600;
                    enemigo3.y=-1000;
                    p4.y=160;
                    p5.y=-1414;
                    t1.y=328;
                    is.y=-980;
                    
                    mapa1.setLocation(p1);
                    mapa2.setLocation(p2);
                    mapa3.setLocation(p3);
                    cubo.setLocation(enemigo1);
                    helicoptero.setLocation(enemigo2);
                    barco.setLocation(enemigo3);
                    gasolina.setLocation(p4);
                    puente.setLocation(p5);
                    t.setLocation(t1);
                    isla.setLocation(is);
                }
                
                if(vida==0){
                    System.out.println("tu puntaje fue: "+puntaje);
                     band=1;//////////////////////////////
                    dispose();
                    sonido.stop();//////////////////////////////
                    Fin f=new Fin(band,nombre,puntaje);///////////////////////
                   f.setVisible(true);
                    timermapa.stop();
                }    
                if (cont==900) {
                    band=0;/////////////////////
                    dispose();
                    sonido.stop(); //////////////////////
                    Fin f=new Fin(band,nombre,puntaje);/////////////////
                    f.setVisible(true);
                    timermapa.stop();
                }    
            }
        }    
}
