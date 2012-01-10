package munchkinclient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
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
import javax.swing.TransferHandler;

/**
 * // TODO : A commenter
 * @author Guillaume Renoult
 */
public class ShowImage extends JPanel implements MouseListener,DragGestureListener,Transferable{
    
    private BufferedImage  image;
    private ImageGlassPane ip;
    private JFrame parent;
    private String name;
    private TransferHandler th;
    
    private int width             =60;
    private int height            =110;
    private boolean click_allowed =false;
    private boolean grisee        =false;
    private boolean imageEnCours  =false;

    
    /**
     * // TODO : A commenter
     * @param click_allowed 
     */
    public void setClick_allowed(boolean click_allowed) {
        this.click_allowed = click_allowed;       
        this.repaint();
    }

    
    /**
     * // TODO : A commenter
     * @param grisee 
     */
    public void setGrisee(boolean grisee) {
        this.grisee = grisee;
        this.repaint();
    }
    
    
    /**
     * // TODO : A commenter
     * @return 
     */
    public String getImageName(){
        return this.name;
    }
    
    
    /**
     * // TODO : A commenter
     * @param name
     * @param parent
     * @throws URISyntaxException 
     */
    public ShowImage(String name, JFrame parent) throws URISyntaxException {
        try {
            this.parent = parent;
            this.name   = name;
            setPreferredSize(new Dimension(this.width, this.height));
            File input = new File(MunchkinVue.class.getResource("resources/cartes/"+this.name+".jpg").toURI());
            image = ImageIO.read(input);
            addMouseListener(this);  
            this.setOpaque(false);             
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }

    
    /**
     * // TODO : A commenter
     * @param name
     * @param parent
     * @param width
     * @param height
     * @throws URISyntaxException 
     */
    public ShowImage(String name, JFrame parent, int width, int height) throws URISyntaxException {
        try {
            this.name   = name;
            this.width  = width;
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
    }

    
    /**
     * // TODO : A commenter
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(click_allowed){                       
            // this.setBorder(BorderFactory.createLineBorder(Color.RED,5));            
            ((MunchkinVue)this.parent).envoyerCarte(this.name);
        }        
    }

    
    /**
     * // TODO : A commenter
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    
    /**
     * // TODO : A commenter
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    
    /**
     * // TODO : A commenter
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {   
        Point p=this.getLocation();
         ip=new ImageGlassPane(image,p.getX(),p.getY()); 
         parent.setGlassPane(ip); 
         ip.repaint();
         if(!grisee){
            ip.setVisible(true);
         }
    }
    
    
    /**
     * // TODO : A commenter
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {       
        ip.setVisible(false);        
    }

    // TODO : Implémenter toutes les méthodes ci-dessous ou gérer les exceptions
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {        
      
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
  
  
    
}
