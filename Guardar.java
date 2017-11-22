/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andry
 */
public class Guardar extends JFrame{
    
    private String nombre;
    int punt;
    String puntajex;
    String puntd;
    int puntaje;
    int puntajeaux=0;
    File apuntador;
    int punto;
    int n;
    ArrayList<Jugador> score=new ArrayList<Jugador>();
    int cont=0;
    public static int MAX = 10;
    /**
     * esta clase nos sirve para guarddar el top 10 y para leerlo de forma decreciente
     */

    public Guardar() {
     setSize(300, 300);
     setVisible(true);
     setLayout(null); 
     JTextArea text= new JTextArea();
     text.setSize(250,250);
     String linea=new String();
                Scanner s=null;
                try {
                File f=new File("src/riverraid/top1.txt");
                s=new Scanner(f);
                while (s.hasNextLine()){
		linea = s.nextLine();
                text.append(linea +"\n");
                   
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
	try {
		if (s != null)
			s.close();
	} catch (Exception ex) {
            }
        }
     //text.append(linea+"\n");
     add(text);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     apuntador=new File("src/riverraid/top.txt"); 
     
     n=score.size();
     leerarchivo();
     Collections.sort(score);
         
     mostrar();
          
    }
    
    
    public void Cargando(String nombre,int puntaje) throws IOException{
        
        System.out.println("asdsa"+nombre);
        
        FileWriter escritor= new FileWriter(apuntador,true);
        BufferedWriter esc= new BufferedWriter(escritor);
        PrintWriter pw=new PrintWriter(esc);
        String puntajex=String.valueOf(puntaje);
        punto=(Integer.parseInt(puntajex));
        pw.write(nombre);
        pw.write(":");
        pw.write(puntajex);
        pw.write("\r\n");
        pw.close();
      
        }
    public void Cargando2(String nombre,int puntaje) throws IOException{
        
        System.out.println("asdsa"+nombre);
        File newapuntador;
        newapuntador=new File("src/riverraid/top1.txt"); 
        FileWriter escritor2= new FileWriter(newapuntador,true);
        BufferedWriter esc2= new BufferedWriter(escritor2);
        PrintWriter pw2=new PrintWriter(esc2);
        String puntajex=String.valueOf(puntaje);
        punto=(Integer.parseInt(puntajex));
        pw2.write(nombre);
        pw2.write(":");
        pw2.write(puntajex);
        pw2.write("\r\n");
        pw2.close();
        
                }
    public void leerarchivo(){
        
        Scanner s=null;
        try {
            s=new Scanner(apuntador);
            while (s.hasNextLine()){
		String linea = s.nextLine();
                String [] cortarString = linea.split(":");
                Jugador j=new Jugador();
                j.setNombre(cortarString[0]);
                j.setPuntaje(Integer.parseInt(cortarString[1]));
                        
                score.add(j);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
	try {
		if (s != null)
			s.close();
	} catch (Exception ex) {
            }
        }
        
        }
    public void mostrar() {
        int x=0;
        try {
            eliminardatos();
        } catch (IOException ex) {
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        x=score.size();
        if(x<10){
         Iterator<Jugador> datosIterator = score.iterator();
        
        while(datosIterator.hasNext()){
             try {
                 Jugador elemento = datosIterator.next();
                 System.out.print(elemento.getNombre()+" : "+elemento.getPuntaje()+"\n");
                 
                 Cargando2(elemento.getNombre(),elemento.getPuntaje());
             } catch (IOException ex) {
                 Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
             }
        }   
        }else if(x>=10){
            Iterator<Jugador> datosIterator = score.iterator();
            for (int i = 0; i < 10; i++) {
                try { 
                    Jugador elemento = datosIterator.next();
                    System.out.print(elemento.getNombre()+" : "+elemento.getPuntaje()+"\n");
                    
                    Cargando2(elemento.getNombre(),elemento.getPuntaje());
             } catch (IOException ex) {
                 Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
             }
                
            }
  
        }
    }
    public void eliminardatos() throws IOException{
        String cadena;
        try {
            File le=new File("src/riverraid/top1.txt");
        FileReader leer= new FileReader(le); 
            BufferedReader br= new BufferedReader(leer);
            br.close();
            leer.close();
            le.delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
       
    }








    

    
