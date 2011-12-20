/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author guillaume.renoult
 */
public class ShowImage extends JPanel implements MouseListener{
    BufferedImage  image;
  public ShowImage(String name) {
  try { 
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {        
         paintOver(this.getGraphics(),120,220);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        paint(this.getGraphics());
    }
   
  
  
    
}