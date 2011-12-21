/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author renoul01
 */
public class ImageGlassPane extends JComponent  {
    private BufferedImage  image;
    private double x;
    private int y;
    
    public ImageGlassPane(BufferedImage img,double x) {
        this.image=img;
        this.x=x;
        this.y=330;
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        
        g.drawImage(image, (int)x, y,240,440,null);
        super.paintComponent(g);
    }

      
    
  
    
}
