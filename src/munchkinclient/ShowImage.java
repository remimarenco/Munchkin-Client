/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 *
 * @author guillaume.renoult
 */
public class ShowImage extends JRootPane implements MouseListener,DragGestureListener{
    private BufferedImage  image;
    private ImageGlassPane ip;
    private JFrame parent;
  public ShowImage(String name,JFrame parent) {
  try { 
      this.parent=parent;
   setPreferredSize(new Dimension(60, 110));         
  File input = new File(name);
  image = ImageIO.read(input);
  addMouseListener(this);   
  } catch (IOException ie) {
  System.out.println("Error:"+ie.getMessage());
  }
  }

  public void paint(Graphics g) {
  g.drawImage( image, 0, 0,60,110, null);  
  }
  
  public void paintOver(Graphics g,int width,int height){      
      g.drawImage( image, 0, 0,width,height, null);      
  }


    @Override
    public void mouseClicked(MouseEvent e) {
        
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
         ip=new ImageGlassPane(image,p.getX()); 
         parent.setGlassPane(ip); 
         ip.repaint();
         ip.setVisible(true);
         
         //paint(this.getGraphics());
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
        //paint(this.getGraphics());         
        //ip.repaint();
        ip.setVisible(false);
        
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
       
    }
   
  
  
    
}
