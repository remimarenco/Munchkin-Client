/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package munchkinclient;

import java.io.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author tavernas
 */
public class Message {

        public static final int CONNECT=0;
        public static final int DISCONNECT=1;
        public static final int MESSAGE=2;
        public static final int LISTE=3;
        public static final int FILE=4;
        public static final int NICKEXIST=5;
        public static final int DEMANDEAVATAR=6;
        public static final int ENVOIAVATAR=7;

        private int type;
        private String nick_src=new String("");
        
     
        private String nick_dest=new String("");
     
       private String message=new String("");
       private ImageIcon avatar=new ImageIcon();
        private byte[] file = null;
        private String totalSize;
        public ImageIcon getAvatar(){return avatar;}
        public String getNick_src(){return nick_src;}
           public String getNick_dest(){return nick_dest;}
            public String getMessage(){return message;}
            public byte[] getFile(){return file;}
          
            public String getTotalSize(){return totalSize;}

 public Message(){}



 public Message(int type,String nick_src){
            this.type=type;
            this.nick_src=nick_src;
           
        }
 public Message(int type,String nick_src,String nick_dest,String msg){
            this.type=type;
            
            this.nick_src=nick_src;      

          
            this.nick_dest=nick_dest;

        
            this.message=msg;
           
        }
 public Message(int type,String nick_src,String nick_dest,String msg,ImageIcon icon){
            this.type=type;

            this.nick_src=nick_src;


            this.nick_dest=nick_dest;


            this.message=msg;
            this.avatar=icon;

        }

  
 
  public Message(int type,String nick_src,String nick_dest,String fileName,byte[] file,String totalSize){

            try{
            this.type=type;
            
            this.nick_src=nick_src;      

          
            this.nick_dest=nick_dest;

             this.message=fileName;
          
            this.file=new byte[file.length];
            this.file=file;
            this.totalSize=totalSize;
            }
            catch(Exception e){System.out.println("bouhhhhhhhhhhhhhhhhhhhhhhh");}
        }


        
      
        public boolean read(DataInputStream in){
            try{
                type=in.readInt();
                
                nick_src=new String(in.readUTF());

                if(type>DISCONNECT){                      
                nick_dest=new String(in.readUTF());
                
                message=new String(in.readUTF());
                if(type==FILE ){

                
                    int lenght=in.readInt();
                    file= new byte[lenght];
                   ObjectInputStream ois= new ObjectInputStream(in);
                   file=(byte[]) ois.readObject();
                   totalSize=in.readUTF();
                }
                else if ( type ==ENVOIAVATAR){
                    ObjectInputStream ois= new ObjectInputStream(in);
                    avatar=(ImageIcon) ois.readObject();
                }
               
                }
                 return true;
            }
            catch(Exception e){
                return false;
            }
            
        }
         public boolean write(DataOutputStream out){
            try{
                out.writeInt(type);
                
                out.writeUTF(nick_src);
                if(type>DISCONNECT){
                    out.writeUTF(nick_dest);
                    
                    out.writeUTF(message);
                    if(type==FILE ){
                        out.writeInt(file.length);
                        ObjectOutputStream oos=new ObjectOutputStream(out);
                        oos.writeObject(file);
                        out.writeUTF(totalSize);
                    }
                    else if(type==ENVOIAVATAR){
                        ObjectOutputStream oos=new ObjectOutputStream(out);
                        oos.writeObject(avatar);
                    }
                    
                 
                }
               return true;
            }
            catch(Exception e){
            return false;
            }
            
        }

        public int getType(){
            return type;
        }
        public void setType(int i){type=(byte)i;}
}
