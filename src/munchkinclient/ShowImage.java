/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;

/**
 *
 * @author guillaume.renoult
 */
public class ShowImage extends JRootPane implements MouseListener,DragGestureListener{
    private BufferedImage  image;
    private ImageGlassPane ip;
    private JFrame parent;
    private int width=60;
    private int height=110;
    private String name;
    private boolean click_allowed=false;

    public void setClick_allowed(boolean click_allowed) {
        this.click_allowed = click_allowed;
    }
    
    
    
    public ShowImage(String name, JFrame parent) {
        try {
            this.parent = parent;
            this.name=name;
            setPreferredSize(new Dimension(this.width, this.height));
            File input = new File("src/munchkinclient/resources/cartes/"+this.name+".jpg");
            image = ImageIO.read(input);
            addMouseListener(this);             
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }

    public ShowImage(String name, JFrame parent, int width, int height) {
        try {
            this.name=name;
            this.width = width;
            this.height = height;
            this.parent = parent;
            setPreferredSize(new Dimension(this.width, this.height));
            File input = new File("src/munchkinclient/resources/cartes/"+this.name+".jpg");
            image = ImageIO.read(input);
            //addMouseListener(this);           
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }
   
  public void paint(Graphics g) {
  g.drawImage( image, 0, 0,this.width,this.height, null);  
  }
  
  public void paintOver(Graphics g,int width,int height){      
      g.drawImage( image, 0, 0,width,height, null);      
  }


    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(click_allowed){            
            JPanel panel= new JPanel();
            panel.setSize(this.getWidth(), this.getHeight());
            panel.setBorder(BorderFactory.createLineBorder(Color.red, 5));           
            this.setGlassPane(panel);
            this.getGlassPane().setVisible(true);
            //((MunchkinVue)this.parent).poserCarte(this.name);
        }        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {   
        Point p=this.getLocation();
         ip=new ImageGlassPane(image,p.getX(),p.getY()); 
         parent.setGlassPane(ip); 
         ip.repaint();
         ip.setVisible(true);       
    }

    @Override
    public void mouseExited(MouseEvent e) {       
        ip.setVisible(false);        
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
       
    }
   
  
  
    
}
