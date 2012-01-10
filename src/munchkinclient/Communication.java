/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package munchkinclient;


import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe qui est un Thread, ce thread attends les messages du serveur, et envoi les messages vers le serveur
 * @author Guillaume Renoult
 */
public class Communication extends Thread{
    
    private Message msg          = new Message();
    private Object parent        = null;
    private DataInputStream in   = null;
    private DataOutputStream out = null;
    
    
    /**
     * Constructeur
     * @param st
     * @param parent 
     */
    public Communication(Socket st,Object parent){
        try{
            this.parent = parent;
            in          = new DataInputStream(st.getInputStream());
            out         = new DataOutputStream(st.getOutputStream());
        }
        catch(Exception e){
            
        }
    }   

    /**
     * Envoi le message via la methode write
     * @param message
     * @return vrai quand message envoyer;
     */
    public boolean sendMessage(Message message){ message.write(out); return true; }
    
  
   
    /**
     * Methode executer lorsque l'on lance le tread
     */
    synchronized public void run(){
        try{           
            while(true){
                this.msg= new Message();//Important pour distinguer les messages
                if(this.msg.read(in))
                    if(this.parent instanceof MunchkinVue)                    
                           ((MunchkinVue)this.parent).interpretMessage(this.msg,this);
            }
        } catch(Exception e) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
