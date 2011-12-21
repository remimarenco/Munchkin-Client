/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Meg4mi
 */
public class BackgroundPanel extends JPanel {
    
    private Image image;
  public BackgroundPanel(String imagePath)
  {
    try
    {
      image = ImageIO.read(new File(imagePath));
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  }
     @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g); 
    if (image != null)
      g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
  }
}
