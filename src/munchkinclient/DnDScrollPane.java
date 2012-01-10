package munchkinclient;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.InvalidDnDOperationException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

// import java.awt.dnd.DropTarget; // TODO : A supprimer


/**
 * // TODO : A commenter
 * @author Guillaume Renoult
 */
public class DnDScrollPane extends JScrollPane implements DropTargetListener,DragGestureListener{

    private JFrame parent;    
    
    public DnDScrollPane(JFrame parent) {
        super();
        this.parent=parent;
    }

    
    /**
     * // TODO : A commenter
     * @param dtde 
     */
    @Override
    public void drop(DropTargetDropEvent dtde) {
        String s;
        try {
            Transferable t = dtde.getTransferable();
            if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                dtde.acceptDrop(dtde.getDropAction());
                s = (String) t.getTransferData(DataFlavor.stringFlavor);
                ((MunchkinVue)parent).envoyerCarte(s);
                dtde.dropComplete(true);
            } else
                dtde.rejectDrop();
        } catch (java.io.IOException e2) {
        } catch (UnsupportedFlavorException e2) {
        } 
    }

    
    /**
     * // TODO : A commenter
     * @param dge 
     */
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        try {
            Transferable t = new StringSelection("Test");      
            dge.startDrag(DragSource.DefaultCopyNoDrop, t);
        } catch (InvalidDnDOperationException e2) {
            System.out.println(e2);
        }
    }

    
    // TODO : Implémenter toutes les méthodes ci-dessous ou gérer l'exception
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
