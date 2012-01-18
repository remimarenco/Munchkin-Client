/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author renoul01
 */
public class ImagePanelList extends JPanel {
    private JLabel image=null;
    private JLabel nameJoueur;

    public JLabel getImage() {
        return image;
    }

    public JLabel getNameJoueur() {
        return nameJoueur;
    }
    
     public ImagePanelList() {        
        super(new FlowLayout(FlowLayout.LEFT));
     }

    public ImagePanelList( JLabel nameJoueur) {        
        super(new FlowLayout(FlowLayout.LEFT));
        this.nameJoueur = nameJoueur;        
        add(this.nameJoueur);
    }
    public ImagePanelList(JLabel image, JLabel nameJoueur) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.image = image;
        this.nameJoueur = nameJoueur;
        add(this.image);
        add(this.nameJoueur);
    }
    
    
}
