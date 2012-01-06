/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author renoul01
 */
public class ImageGlassPane extends JComponent  {
    private BufferedImage  image;
    private double x;
    private double y;
    
    public ImageGlassPane(BufferedImage img,double x
            ,double y) {
        this.image=img;
        this.x=x;
        this.y=335.0;
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        
        g.drawImage(image, (int)x, (int)y,280,440,null);
        super.paintComponent(g);
    }

      
    
  
    
}
