package munchkinclient;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 * // TODO : A commenter
 * @author Guillaume Renoult
 */
public class ImageGlassPane extends JComponent  {
    
    private BufferedImage  image;
    private double x;
    private double y;
    
    
    /**
     * // TODO : A commenter
     * @param img
     * @param x
     * @param y 
     */
    public ImageGlassPane(BufferedImage img,double x, double y) {
        this.image=img;
        this.x=x+40;
        this.y=312.0;        
    }

    
    /**
     * // TODO : A commenter
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, (int)x, (int)y,280,440,null);
        super.paintComponent(g);
    }
}
