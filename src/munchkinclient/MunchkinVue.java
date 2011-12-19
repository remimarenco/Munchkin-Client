/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MunchkinVue.java
 *
 * Created on 11 déc. 2011, 15:56:41
 */
package munchkinclient;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Meg4mi
 */
public class MunchkinVue extends JFrame {

    private Communication com = null;
    private Socket socket = null;
    private String login = null;
    private String fileName = new String("");
    private String login_dest = "Partie";
    private JScrollPane jScrollpane;
    private JTextPane jTextPane2;
    private int pourcent = 0;
    private boolean connected = false;
    private boolean nickexist = false;
    
    /** Creates new form MunchkinVue */
    public MunchkinVue() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();    
        jTabbedPane1.setTitleAt(0, "Partie");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        send_button = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        labelActionPrompt = new javax.swing.JLabel();
        buttonNon = new javax.swing.JButton();
        buttonYes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelJoueurSelectionné = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaInfoJoueur = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        connexion_item = new javax.swing.JMenuItem();
        deconnexion_Item = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Munchkin");

        jPanel.setPreferredSize(new java.awt.Dimension(693, 500));

        send_button.setText("Envoyer");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        jTextField1.setText("Tapez votre texte ici");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTextPane1.setBackground(new java.awt.Color(2, 155, 47));
        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);

        jTabbedPane1.addTab("Partie", jScrollPane2);

        labelActionPrompt.setText("Action :");

        buttonNon.setText("Non");
        buttonNon.setEnabled(false);
        buttonNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNonActionPerformed(evt);
            }
        });

        buttonYes.setText("Oui");
        buttonYes.setEnabled(false);
        buttonYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYesActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Infos du joueur :");

        jButton1.setText("Voir Jeu");
        jButton1.setEnabled(false);

        jButton2.setText("Voir Main");
        jButton2.setEnabled(false);

        labelJoueurSelectionné.setText("x");

        textAreaInfoJoueur.setColumns(20);
        textAreaInfoJoueur.setEditable(false);
        textAreaInfoJoueur.setRows(5);
        jScrollPane3.setViewportView(textAreaInfoJoueur);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labelJoueurSelectionné)
                .addGap(172, 172, 172))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelJoueurSelectionné))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(5, 5, 5)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(send_button)
                        .addGap(23, 23, 23))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelActionPrompt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                .addComponent(buttonNon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(buttonYes))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(labelActionPrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonNon)
                            .addComponent(buttonYes))
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(send_button))
                .addContainerGap())
        );

        fileMenu.setText("File");

        connexion_item.setText("Connexion");
        connexion_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connexion_itemActionPerformed(evt);
            }
        });
        fileMenu.add(connexion_item);

        deconnexion_Item.setText("Deconnexion");
        deconnexion_Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexion_ItemActionPerformed(evt);
            }
        });
        fileMenu.add(deconnexion_Item);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-777)/2, (screenSize.height-650)/2, 777, 650);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Appelé par la classe de communication lors de la reception d'un message.
     * Traite le message reçu en focntion de sont ype et son contenu
     * @param msg
     * @param com 
     */
     public void interpretMessage(Message msg, Communication com) {        
        switch (msg.getType()) {
            case Message.MESSAGE:
                miseaJour(msg);
                jTextPane1.setCaretPosition(jTextPane1.getDocument().getLength());
                break;
            case Message.LISTE:
                miseaJourListe(msg.getMessage());
                break;            
            case Message.NICKEXIST:
                nickexist = true;
                miseaJour(msg);
                break;
            case Message.QUESTION:
                miseajourAction(msg);
                break;
            case Message.INFO_JOUEUR:
                miseaJourInfoJoueur(msg);
                break;
        }
    }

     private void appendText(JTextPane jpane,String str,Color color){
         StyledDocument doc = jpane.getStyledDocument();
        try {
             Style style = doc.addStyle("StyleName", null);
            StyleConstants.setForeground(style,color );
            
            doc.insertString(doc.getLength(), str,style );
        } catch (BadLocationException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     /**
      * Appelé apres avoir reçu un message de type messageet met a jour l'interface en fonction de son contenu
      * @param message 
      */
    public void miseaJour(Message message) {
       if(message.getColor()!=null)
           jTextPane1.setForeground(message.getColor());
       
        if (message.getNick_dest().equals("Partie")) {
            if(!message.getNick_src().equals(login))
            appendText(jTextPane1, message.getNick_src() +" : " + message.getMessage()+"\n",message.getColor());            
        } else if (message.getNick_dest().equals("deconnexion")) {
            int i = 0;
            while (i < jTabbedPane1.getTabCount() - 1 && jTabbedPane1.getTitleAt(i) != message.getMessage()) {
                i++;
            }
            if (jTabbedPane1.getTitleAt(i).equals(message.getNick_src()) || message.getNick_src().equals("admin")) {
                if (jTextPane2 != null && jTextPane2.getName().equals(login_dest)) {
                    appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage() + " est maintenant deconnecté !\n",Color.BLACK);                    
                }
            }

        } else if (message.getNick_dest().equals("connexion")) {
            int i = 0;
            while (i < jTabbedPane1.getTabCount() - 1 && jTabbedPane1.getTitleAt(i) != message.getMessage()) {
                i++;
            }
            if (jTabbedPane1.getTitleAt(i).equals(message.getNick_src()) || message.getNick_src().equals("admin")) {
                if (jTextPane2 != null && jTextPane2.getName().equals(login_dest)) {
                    appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage() + " est maintenant connecté \n!",Color.BLACK);                    
                }
            }

        } else if (message.getNick_dest().equals(login)) {

            
            if(ongletExist(message.getNick_src())){
                 appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage()+"\n",Color.BLACK);
                
            }
            
//            int i = 0;
//            while (i < jTabbedPane1.getTabCount()-1 && jTabbedPane1.getTitleAt(i) != message.getNick_src()) {
//                i++;
//            }
//            if (jTabbedPane1.getTitleAt(i).equals(message.getNick_src()) || message.getNick_src().equals("admin")) {
//                if (jTextPane2 != null && jTextPane2.getName().equals(login_dest)) {
//                    appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage()+"\n",Color.BLACK);      
//
//                    if (jTabbedPane1.getSelectedIndex() != i) {
//                        jTabbedPane1.setBackgroundAt(i, Color.RED);
//                    }
//                }
             else {
                //login_dest = message.getNick_src();
                jScrollpane = new JScrollPane();
                newTab(message.getNick_src());                
                appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage()+"\n ",Color.BLACK);               
               // jTabbedPane1.setSelectedIndex(i + 1);
               //message = new Message(Message.DEMANDEAVATAR, login, login_dest, "");
                //this.com.sendMessage(message);
            }
        }


    }
    
    private void newTab(String name){
        if(!name.equals(login) && !ongletExist(name)){
         jTextPane2 = new JTextPane();
         jTextPane2.setName(name);
         jTextPane2.setEditable(false);
         jTabbedPane1.addTab(name, jScrollpane);
         jScrollpane.setViewportView(jTextPane2);      
        }
    }
    
    private boolean ongletExist(String name){
        boolean ret=false;
        for(int i=0;i<jTabbedPane1.getTabCount();i++){           
            
            if(jTabbedPane1.getTitleAt(i).equals(name)){
                ret=true;
                break;
            }
        }
        return ret;
    }
    
    private void miseaJourInfoJoueur(Message msg){
        String out=new String();
        for(Map.Entry<String,String> m: msg.getMap().entrySet())
            out+=m.getKey()+":" +m.getValue()+"\n";      
          this.textAreaInfoJoueur.setText(out);  
    }
    /**
     * Met a jour l'action proposé par le serveur
     * @param msg 
     */
    private void miseajourAction(Message msg) {
       this.labelActionPrompt.setText(msg.getMessage());
       this.buttonNon.setEnabled(true);
       this.buttonYes.setEnabled(true);
    }
  
    /**
     * met a jour la liste des connectés
     * @param liste 
     */    
    public void miseaJourListe(String liste) {

        Vector<String> listData = new Vector<String>();
        StringTokenizer l2 = new StringTokenizer(liste, ";");
        while (l2.hasMoreTokens()) {
            listData.add(l2.nextToken());
        }
        jList1.setListData(listData);
    }

    
private void connexion_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connexion_itemActionPerformed
        try {            
            Connexion connexion = new Connexion(this,true);
           connexion.setLocationRelativeTo(this);     
           connexion.setVisible(true);
           if (connexion.getEtat()) {

                login = connexion.getLogin();      
             
                socket = new Socket(connexion.getServeur(), connexion.getPort());                
                com = new Communication(socket, this);
                com.start();

                Message msg = new Message(Message.CONNECT, login);
                connected = com.sendMessage(msg);                
               
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                   
                }
                if (nickexist) {

                    deconnexion_Item.setEnabled(false);
                } else {
                    deconnexion_Item.setEnabled(true);
                    connexion_item.setEnabled(false);
                }
                nickexist = false;
            }
        } catch (ConnectException e) {
            appendText(jTextPane1, "Le serveur n'est sans doute pas demarré\n  " +e.toString(),Color.BLACK);
       
        } catch (UnknownHostException e) {
            System.out.println("Serveur : " + socket.getInetAddress().getHostName() + " inconnu");
        } catch (Exception e) {
            System.out.println("Exception :" + e.toString());
        }


}//GEN-LAST:event_connexion_itemActionPerformed

private void deconnexion_ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexion_ItemActionPerformed
        try {
            // TODO add your handling code here:
            Message msg = new Message(Message.DISCONNECT, login);
            com.sendMessage(msg);

            connexion_item.setEnabled(true);
            deconnexion_Item.setEnabled(false);
            connected = false;            


        } catch (Exception ex) {
            System.out.println("exception deco");
        }


}//GEN-LAST:event_deconnexion_ItemActionPerformed

/**
 * Methode appelée lorsque le joueur envoi un message sur la chat
 */
private void sendMessage(){
     try {
            String text = jTextField1.getText()+"\n";

            if (connected) {
                if (login_dest != "Partie")
                    appendText(jTextPane2, "Moi : " + text +" \n",Color.BLACK);                    
                else
                    appendText(jTextPane1,"Moi : "+text +"\n",Color.BLACK);                
                Message msg = new Message(Message.MESSAGE, login, login_dest, text);
                com.sendMessage(msg);
            }

            jTextField1.setText("");

        } catch (Exception e) {
            System.out.println("Exception :" + e.toString());
        }
}

private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
       sendMessage();
}//GEN-LAST:event_send_buttonActionPerformed

private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");        // TODO add your handling code here:
}//GEN-LAST:event_jTextField1MouseClicked

private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
           sendMessage();
        }
}//GEN-LAST:event_jTextField1KeyPressed
/**
 * Appelé lors d'un click dans la liste de joueur
 * @param evt 
 */
private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {


            login_dest = jList1.getSelectedValue().toString();
            jScrollpane = new JScrollPane();
            newTab(login_dest);            
            //jScrollpane.setViewportView(jTextPane2);

        } else if (evt.getButton() == evt.BUTTON3) {
            JPopupMenu popup = new JPopupMenu();
            JMenuItem menuItem1 = new JMenuItem("Conversation privée");
            

            menuItem1.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                     
                    login_dest = jList1.getSelectedValue().toString();
                    jScrollpane = new JScrollPane();
                    newTab(login_dest);
                    //jScrollpane.setViewportView(jTextPane2);

                }
            });           

            popup.add(menuItem1);          
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        else if(evt.getClickCount() == 1){
           
            this.labelJoueurSelectionné.setText(jList1.getSelectedValue().toString());
            Message msg= new Message(Message.INFO_JOUEUR, login,this.labelJoueurSelectionné.getText());
            com.sendMessage(msg);
        }
}//GEN-LAST:event_jList1MouseClicked
/**
 * Appelée lors d'un clic sur les onglet
 * @param evt 
 */
private void buttonNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNonActionPerformed
  com.sendMessage(new Message(Message.QUESTION, login, login_dest, "Non"));
  this.buttonNon.setEnabled(false);
  this.buttonYes.setEnabled(false);
}//GEN-LAST:event_buttonNonActionPerformed

private void buttonYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYesActionPerformed
  com.sendMessage(new Message(Message.QUESTION, login, login_dest, "Yes"));
  this.buttonNon.setEnabled(false);
  this.buttonYes.setEnabled(false);
}//GEN-LAST:event_buttonYesActionPerformed

private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (evt.getButton() == evt.BUTTON1) {
            login_dest = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex());
            jTabbedPane1.setBackgroundAt(jTabbedPane1.getSelectedIndex(), null);
            if(jTextPane2!=null)
                jTextPane2.setName(login_dest);            
                
            if (login_dest != "Partie" && connected) {
//                Message message = new Message(Message.DEMANDEAVATAR, login, login_dest, "");
//                this.com.sendMessage(message);                
            }             
        } else if (evt.getButton() == evt.BUTTON3) {
            final JPopupMenu popup = new JPopupMenu();
            final JMenuItem menuItem2 = new JMenuItem("Fermer");
            if (jTabbedPane1.getSelectedIndex() == 0) {
                menuItem2.setEnabled(false);
            }

            menuItem2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    if (jTabbedPane1.getSelectedIndex() != 0) {
                        jTabbedPane1.removeTabAt(jTabbedPane1.getSelectedIndex());
                    }
                }
            });
            popup.add(menuItem2);
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }

}//GEN-LAST:event_jTabbedPane1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MunchkinVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MunchkinVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MunchkinVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MunchkinVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MunchkinVue().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNon;
    private javax.swing.JButton buttonYes;
    private javax.swing.JMenuItem connexion_item;
    private javax.swing.JMenuItem deconnexion_Item;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelActionPrompt;
    private javax.swing.JLabel labelJoueurSelectionné;
    private javax.swing.JButton send_button;
    private javax.swing.JTextArea textAreaInfoJoueur;
    // End of variables declaration//GEN-END:variables
    
  
}

