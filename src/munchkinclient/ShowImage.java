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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 * Classe qui permet d'afficher les images.
 * Elle gere les evenement de la souris et permet de faire un zoom quand on survole une carte, ou une action si on clic sur la carte
 * @author Guillaume Renoult
 */
public class ShowImage extends JPanel implements MouseListener{
    
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
     * Setter du boolean qui permet de voir si le click sur la carte est autorisé
     * @param click_allowed 
     */
    public void setClick_allowed(boolean click_allowed) {
        this.click_allowed = click_allowed;       
        this.repaint();
    }

    
    /**
     * Setter du boolean qui permet de grisée une carte non clicable
     * @param grisee 
     */
    public void setGrisee(boolean grisee) {
        this.grisee = grisee;
        this.repaint();
    }
    
    
    /**
     * getter du nom, de l'id de la carte
     * @return 
     */
    public String getImageName(){
        return this.name;
    }
    
    
    /**
     * Constructeur pour les miniatures des cartes
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
     * Constructeur pour la carte en cours
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
     * Evenement click
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
     * Non Necessaire, mais on peut pas supprimer car interface
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    /**
     * Non Necessaire, mais on peut pas supprimer car interface
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    
    /**
     * Evenement survol de la carte
     * On gere le zoom de la carte
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
     * ON dezoom
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {       
        ip.setVisible(false);        
    }    
}
