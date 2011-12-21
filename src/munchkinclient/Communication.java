/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package munchkinclient;


import java.io.*;
import java.net.Socket;

/**
 * 
 * @author Meg4mi
 */
public class Communication extends Thread{
    private Message msg=new Message();
    private Object parent=null;
    private DataInputStream in=null;
    private DataOutputStream out=null;
    public Communication(Socket st,Object parent){
        try{
        this.parent=parent;
        in=new DataInputStream(st.getInputStream());
        out= new DataOutputStream(st.getOutputStream());
        }
        catch(Exception e){
            
        }
    }   

    /**
     * Envoi le message via la methode write
     * @param message
     * @return vrai quand message envoyer;
     */
    public boolean sendMessage(Message message){message.write(out); return true;}
    
  
   
  /**
     * Methode executer lorsque l'on lance le tread
     */
  synchronized public void run(){
       try{           
        while(true){
            this.msg= new Message();//Important pour distinguer les messages
            if(this.msg.read(in)){
                if(this.parent instanceof MunchkinVue){                    
                       ((MunchkinVue)this.parent).interpretMessage(this.msg,this);
                }
            }
        }
    }

    catch(Exception e){
        System.out.println(e.toString());
    }
    }
}
