/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package munchkinclient;


import java.io.*;
import java.net.Socket;

/**
 *
 * @author tavernas
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

    public void sendList(String list){
        new Message(Message.LISTE,"admin","General",list).write(out);

    }

    public boolean sendMessage(Message message){message.write(out); return true;}
    
  
    public boolean sendMessage(String message,String nick_dest){

        new Message(Message.MESSAGE,getName(),nick_dest,message).write(out);
        return true;
    }

  synchronized  public void run(){
       try{           
        while(true){
            if(msg.read(in)){
                if(parent instanceof MunchkinVue){
                    
                       ((MunchkinVue)parent).interpretMessage(msg,this);
                }
            }
        }
    }

    catch(Exception e){System.out.println(e.toString());}
    }
}
