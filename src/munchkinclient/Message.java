/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package munchkinclient;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author user
 */
public class Message {
    
    
      public static final int CONNECT=0;
        public static final int DISCONNECT=1;
        public static final int MESSAGE=2;
        public static final int LISTE=3;       
        public static final int NICKEXIST=5;
        public static final int ANSWER=6;
        public static final int QUESTION=7;        
        private String nick_src=new String("");     
        private String nick_dest=new String("");    
        private String message=new String("");
        private int type;
        private Color color;
        
        

 public Message(){}

 public Message(int type,String nick_src){
            this.type=type;
            this.nick_src=nick_src;
           
        }
 /**
  * 
  * @param type
  * @param nick_src
  * @param nick_dest
  * @param msg 
  */
 public Message(int type,String nick_src,String nick_dest,String msg){
            this.type=type;            
            this.nick_src=nick_src;          
            this.nick_dest=nick_dest;        
            this.message=msg;
            this.color=Color.BLACK;
        }
 /**
  * 
  * @param type
  * @param nick_src
  * @param nick_dest
  * @param msg
  * @param color 
  */
   public Message(int type,String nick_src,String nick_dest,String msg,Color color){
            this.type=type;
            
            this.nick_src=nick_src;      
            
            this.color=color;
          
            this.nick_dest=nick_dest;
        
            this.message=msg;
           
        }

   /**
    * Methode qui lit un message qui arrive sur le socket
    * @param in
    * @return vrai si message bien lu
    */
    public boolean read(DataInputStream in) {
        try{
                type=in.readInt();
                
                nick_src=new String(in.readUTF());

                if(type>DISCONNECT){                      
                    nick_dest=new String(in.readUTF());                
                    message=new String(in.readUTF()); 
                    ObjectInputStream ois= new ObjectInputStream(in);
                    color=(Color) ois.readObject();
                }
                
                 return true;
            }
            catch(Exception e){
                return false;
            }
    }

    /**
     * Methode qui ecrit un message sur le socket
     * @param out
     * @return vrai si le message est bien envoyé
     */
    public boolean write(DataOutputStream out) {
        try{
                out.writeInt(type);
                
                out.writeUTF(nick_src);
                if(type>DISCONNECT){
                    out.writeUTF(nick_dest);                   
                    out.writeUTF(message); 
                    ObjectOutputStream oos=new ObjectOutputStream(out);
                    oos.writeObject(color);               
                }                 
                   
               return true;
            }
            catch(Exception e){
            return false;
            }
    }

    public int getType() {
       return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNick_src() {
        return this.nick_src;
    }

    public String getNick_dest() {
        return this.nick_dest;
    }

    public Color getColor() {
        return color;
    }
    
    
}
