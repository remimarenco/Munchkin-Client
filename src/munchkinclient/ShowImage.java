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
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author guillaume.renoult
 */
public class ShowImage extends JPanel implements MouseListener,DragGestureListener{
    private BufferedImage  image;
    private ImageGlassPane ip;
    private JFrame parent;
    private int width=60;
    private int height=110;
    private String name;
    private boolean click_allowed=false;
    private boolean grisee=false;
    private boolean imageEnCours=false;

    public void setClick_allowed(boolean click_allowed) {
        this.click_allowed = click_allowed;       
        this.repaint();
    }

    public void setGrisee(boolean grisee) {
        this.grisee = grisee;
        this.repaint();
    }
    
    
    public String getImageName(){
        return this.name;
    }
    
    
    public ShowImage(String name, JFrame parent) throws URISyntaxException {
        try {
            this.parent = parent;
            this.name=name;
            setPreferredSize(new Dimension(this.width, this.height));
            File input = new File(MunchkinVue.class.getResource("resources/cartes/"+this.name+".jpg").toURI());
            image = ImageIO.read(input);
            addMouseListener(this);    
             this.setOpaque(false);
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }

    public ShowImage(String name, JFrame parent, int width, int height) throws URISyntaxException {
        try {
            this.name=name;
            this.width = width;
            this.height = height;
            this.parent = parent;
            setPreferredSize(new Dimension(this.width, this.height));
            File input = new File(MunchkinVue.class.getResource("resources/cartes/"+this.name+".jpg").toURI());
            image = ImageIO.read(input);
             this.setOpaque(false);
             this.imageEnCours=true;
            //addMouseListener(this);           
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }
   
  public void paint(Graphics g) {      
      g.drawImage( image, 0, 0,this.width,this.height, null); 
      if(grisee && !imageEnCours){
           g.setColor(new Color(255, 255, 255,155));
           g.fillRect(0, 0, this.width, height);
      }
        
       //super.printBorder(g); //putain de salope de ligne , 
                            //tu pouvais pas le dire qu'il fallait que je t'écrive pour que les bordures marchent
  }


    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(click_allowed){                       
           // this.setBorder(BorderFactory.createLineBorder(Color.RED,5));            
            ((MunchkinVue)this.parent).envoyerCarte(this.name);
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
