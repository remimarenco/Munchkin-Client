/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.InvalidDnDOperationException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author guillaume.renoult
 */
public class DnDScrollPane extends JScrollPane implements DropTargetListener,DragGestureListener{

    private JFrame parent;
    
    public DnDScrollPane(JFrame parent) {
        this.parent=parent;
    }

    
    
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
       
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
         try {
      Transferable t = dtde.getTransferable();

      if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        dtde.acceptDrop(dtde.getDropAction());

        String s;
        s = (String) t.getTransferData(DataFlavor.stringFlavor);
        ((MunchkinVue)parent).envoyerCarte(s);
        

        dtde.dropComplete(true);
      } else
        dtde.rejectDrop();
    } catch (java.io.IOException e2) {
    } catch (UnsupportedFlavorException e2) {
    }
        
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        try {
      Transferable t = new StringSelection("Test");      
      dge.startDrag(DragSource.DefaultCopyNoDrop, t);
    } catch (InvalidDnDOperationException e2) {
      System.out.println(e2);
    }
    }
    
    
    
    
}
