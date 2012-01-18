/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author renoul01
 */
public class ListWithImage extends JList{

    private static class CustomCellRenderer implements ListCellRenderer {

        public CustomCellRenderer() {
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = (Component)value;
        component.setBackground
        (isSelected ? new Color(62,35, 2) : new Color(172, 158,123));
        component.setForeground(Color.white);
        return component;
        }
    }

    public ListWithImage() {
        super();
        setCellRenderer(new CustomCellRenderer()); 
        setForeground(Color.white);
    }
 
    
    
}
