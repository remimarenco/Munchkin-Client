package munchkinclient;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * Classe qui permet d'afficher une image en arriere plan d'un panel
 * @author Guillaume Renoult
 */
public class BackgroundPanel extends JPanel {
    
    private Image image;
  
    /**
     * Constructeur de la classe
     * @param imagePath
     * @throws URISyntaxException 
     */
    public BackgroundPanel(InputStream imagePath){        
           
            try {
                image = ImageIO.read(imagePath);
            } catch (IOException ex) {
                Logger.getLogger(BackgroundPanel.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        if (image != null)
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
}
