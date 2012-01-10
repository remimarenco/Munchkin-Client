package munchkinclient;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/* // TODO : A supprimer ?
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
*/

/**
 * // TODO : A commenter
 * @author Guillaume Renoult
 */
public class BackgroundPanel extends JPanel {
    
    private Image image;
  
    /**
     * // TODO : A commenter
     * @param imagePath
     * @throws URISyntaxException 
     */
    public BackgroundPanel(URL imagePath) throws URISyntaxException{
        try {
          image = ImageIO.read(new File(imagePath.toURI()));
        }catch(IOException e){

        } 
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        if (image != null)
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
}
