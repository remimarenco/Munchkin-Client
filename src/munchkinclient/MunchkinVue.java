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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Classe principale du client, VUE
 * @author Guillaume Renoult
 */
public class MunchkinVue extends JFrame {

    private Communication com = null;
    private Socket socket = null;
    private String login = null;    
    private String login_dest = "Partie";
    private JScrollPane jScrollpane;
    private JTextPane jTextPane2;    
    private boolean connected = false;
    private boolean nickexist = false;
    private boolean sonActive = true;
    private boolean defilementActif = true;    
    private boolean campClicable=false;
    private boolean choisirJoueur=false;
    private HashMap<String,JTextArea> mapInfosJoueurs=new HashMap<String, JTextArea>();
    private HashMap<String,JTextPane> mapTxtToJoueurs=new HashMap<String, JTextPane>();   
    private int state = Constantes.ACTION_PRET;
    private Timer timer=new Timer("timer") ;;
    private javax.swing.Timer displayTimer=new javax.swing.Timer(1000, new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			labelTimer.setText(Integer.toString((Integer.valueOf(labelTimer.getText()))-1));
    		}
    	});;
    
    
    
    /** Creates new form MunchkinVue */
    public MunchkinVue() throws FontFormatException, IOException, URISyntaxException {
        UIManager.put("nimbusBase", new ColorUIResource(62,35, 2));         
        UIManager.put("nimbusFocus", new ColorUIResource(62,35, 2));         
        UIManager.put("nimbusLightBackground", new ColorUIResource(244,233,211));           
        UIManager.put("control", new ColorUIResource(172, 158,123));        
        initComponents();        
        initFont();         
        this.setIconImage(ImageIO.read(MunchkinVue.class.getResourceAsStream("resources/munchkin.png")));
    }

    private void initFont() throws FontFormatException, IOException, URISyntaxException{
        
        Font font1= Font.createFont(Font.TRUETYPE_FONT, MunchkinVue.class.getResourceAsStream("resources/Augusta.ttf"));
        Font font2= Font.createFont(Font.TRUETYPE_FONT,MunchkinVue.class.getResourceAsStream("resources/Windlass.ttf"));
        
        font1=font1.deriveFont(18f);
        //font1=font1.deriveFont(Font.BOLD);
        font2=font2.deriveFont(14f);
        this.jTextPane1.setFont(font1);            
        this.textAreaInfos.setFont(font1);
        this.jList1.setFont(font1);
        for(Component c2 : jPanel.getComponents())
            if(c2 instanceof JPanel)
                applyFontPanel((JPanel)c2, font2);
            else
                c2.setFont(font2);
          
        this.applyFont(jMenuBar1, font2);
        for(int i = 0; i < jMenuBar1.getMenuCount(); i++)
            this.applyFontMenu(jMenuBar1.getMenu(0), font2);
        
       this.jTextField1.setFont(font1);
    }
    
    private void applyFont(JComponent c, Font f){
        for(Component c2 : c.getComponents())
            this.applyFont((JComponent)c2, f);
        c.setFont(f);
    }
    
    private void applyFontPanel(JPanel c, Font f){
        for(Component c2 : c.getComponents())
            this.applyFont((JComponent)c2, f);
        c.setFont(f);
    }
    
    private void applyFontMenu(JMenu c, Font f){
        for(Component c2 : c.getMenuComponents())
            this.applyFont((JComponent)c2, f);
        c.setFont(f);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroupDefilement = new javax.swing.ButtonGroup();
        jPanel = new BackgroundPanel(MunchkinVue.class.getResourceAsStream("resources/bg4.jpg"));
        send_button = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new ListWithImage();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        labelActionPrompt = new javax.swing.JLabel();
        buttonNon = new javax.swing.JButton();
        buttonYes = new javax.swing.JButton();
        tabbedPaneJeuxJoueurs = new javax.swing.JTabbedPane();
        scrollPaneJeux = new javax.swing.JScrollPane();
        tabbedPaneInfosJoueurs = new javax.swing.JTabbedPane();
        scrollPaneInfos = new javax.swing.JScrollPane();
        textAreaInfos = new javax.swing.JTextArea();
        buttonPoserCarte = new javax.swing.JButton();
        tabbedPaneMainJoueur = new javax.swing.JTabbedPane();
        scrollPaneMain = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        scrollPaneCarteEnCours = new javax.swing.JScrollPane();
        tabbedPaneCampMechant = new javax.swing.JTabbedPane();
        scrollPaneCampMechant = new javax.swing.JScrollPane();
        listCampMechant = new javax.swing.JList();
        tabbedPaneCampGentil = new javax.swing.JTabbedPane();
        scrollPaneCampGentil = new javax.swing.JScrollPane();
        listCampGentil = new javax.swing.JList();
        labelTimer = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        connexion_item = new javax.swing.JMenuItem();
        deconnexion_Item = new javax.swing.JMenuItem();
        menuOption = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        radioBUttonMenuItemSonOui = new javax.swing.JRadioButtonMenuItem();
        radioBUttonMenuItemSonNon = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        radioBUttonMenuItemDefilOui = new javax.swing.JRadioButtonMenuItem();
        radioBUttonMenuItemDefilNon = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Munchkin");
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(231, 212, 181));
        jPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel.setMinimumSize(new java.awt.Dimension(800, 650));
        jPanel.setName("mainPanel"); // NOI18N
        jPanel.setOpaque(false);
        jPanel.setPreferredSize(new java.awt.Dimension(800, 767));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        send_button.setBackground(new java.awt.Color(168, 137, 59));
        send_button.setText("Envoyer");
        send_button.setEnabled(false);
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });
        jPanel.add(send_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 130, 40));

        jTextField1.setBackground(new java.awt.Color(244, 233, 211));
        jTextField1.setText("Tapez votre texte ici");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 420, 40));

        jList1.setBackground(new java.awt.Color(244, 233, 211));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 200, 120));

        jTabbedPane1.setBackground(new java.awt.Color(168, 137, 59));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(50, 148, 45));

        jTextPane1.setBackground(new java.awt.Color(244, 233, 211));
        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);

        jTabbedPane1.addTab("Partie", jScrollPane2);

        jPanel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 555, 320));
        jPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 388, 32767, -1));

        labelActionPrompt.setText("Etes vous pret ?");
        jPanel.add(labelActionPrompt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        buttonNon.setBackground(new java.awt.Color(168, 137, 59));
        buttonNon.setText("Non");
        buttonNon.setEnabled(false);
        buttonNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNonActionPerformed(evt);
            }
        });
        jPanel.add(buttonNon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, -1, -1));

        buttonYes.setBackground(new java.awt.Color(168, 137, 59));
        buttonYes.setText("Oui");
        buttonYes.setEnabled(false);
        buttonYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYesActionPerformed(evt);
            }
        });
        jPanel.add(buttonYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, -1, -1));

        tabbedPaneJeuxJoueurs.setBackground(new java.awt.Color(168, 137, 59));

        scrollPaneJeux.setBackground(new java.awt.Color(0, 102, 0));
        scrollPaneJeux.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPaneJeux.setName("Mon Jeu"); // NOI18N
        tabbedPaneJeuxJoueurs.addTab("Mon Jeu", scrollPaneJeux);

        jPanel.add(tabbedPaneJeuxJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 726, 162));

        textAreaInfos.setBackground(new java.awt.Color(244, 233, 211));
        textAreaInfos.setColumns(20);
        textAreaInfos.setRows(5);
        scrollPaneInfos.setViewportView(textAreaInfos);

        tabbedPaneInfosJoueurs.addTab("Mes Infos", scrollPaneInfos);

        jPanel.add(tabbedPaneInfosJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 200, 180));

        buttonPoserCarte.setBackground(new java.awt.Color(168, 137, 59));
        buttonPoserCarte.setText("Poser une carte");
        buttonPoserCarte.setEnabled(false);
        buttonPoserCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPoserCarteActionPerformed(evt);
            }
        });
        jPanel.add(buttonPoserCarte, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 240, 150));

        tabbedPaneMainJoueur.setBackground(new java.awt.Color(168, 137, 59));

        scrollPaneMain.setBackground(new java.awt.Color(0, 102, 0));
        scrollPaneMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tabbedPaneMainJoueur.addTab("Ma Main", scrollPaneMain);

        jPanel.add(tabbedPaneMainJoueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 730, 150));

        jLabel1.setText("Carte en cours");
        jPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        scrollPaneCarteEnCours.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPaneCarteEnCours.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneCarteEnCours.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPaneCarteEnCours.setHorizontalScrollBar(null);
        jPanel.add(scrollPaneCarteEnCours, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 260, 350));

        tabbedPaneCampMechant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneCampMechantMouseClicked(evt);
            }
        });

        scrollPaneCampMechant.setViewportView(listCampMechant);

        tabbedPaneCampMechant.addTab("Mechant", scrollPaneCampMechant);

        jPanel.add(tabbedPaneCampMechant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 370));

        tabbedPaneCampGentil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneCampGentilMouseClicked(evt);
            }
        });

        scrollPaneCampGentil.setViewportView(listCampGentil);

        tabbedPaneCampGentil.addTab("Gentil", scrollPaneCampGentil);

        jPanel.add(tabbedPaneCampGentil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 130, 310));

        labelTimer.setFont(new java.awt.Font("Tahoma", 0, 18));
        labelTimer.setText("30");
        jPanel.add(labelTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(179, 127, 81));
        jMenuBar1.setFont(new java.awt.Font("DejaVu Sans Light", 0, 13));

        fileMenu.setText("Serveur");

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

        menuOption.setText("Options");

        jMenu1.setText("Activer le Son");

        buttonGroup1.add(radioBUttonMenuItemSonOui);
        radioBUttonMenuItemSonOui.setSelected(true);
        radioBUttonMenuItemSonOui.setText("Oui");
        radioBUttonMenuItemSonOui.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioBUttonMenuItemSonOuiItemStateChanged(evt);
            }
        });
        jMenu1.add(radioBUttonMenuItemSonOui);

        buttonGroup1.add(radioBUttonMenuItemSonNon);
        radioBUttonMenuItemSonNon.setText("Non");
        jMenu1.add(radioBUttonMenuItemSonNon);

        menuOption.add(jMenu1);

        jMenu2.setText("Defilement du texte");

        buttonGroupDefilement.add(radioBUttonMenuItemDefilOui);
        radioBUttonMenuItemDefilOui.setSelected(true);
        radioBUttonMenuItemDefilOui.setText("Oui");
        radioBUttonMenuItemDefilOui.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioBUttonMenuItemDefilOuiItemStateChanged(evt);
            }
        });
        jMenu2.add(radioBUttonMenuItemDefilOui);

        buttonGroupDefilement.add(radioBUttonMenuItemDefilNon);
        radioBUttonMenuItemDefilNon.setText("Non");
        jMenu2.add(radioBUttonMenuItemDefilNon);

        menuOption.add(jMenu2);

        jMenuBar1.add(menuOption);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1189, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1205)/2, (screenSize.height-760)/2, 1205, 760);
    }// </editor-fold>//GEN-END:initComponents

   
    /**
     * Appelé par la classe de communication lors de la reception d'un message.
     * Traite le message reçu en focntion de sont ype et son contenu
     * @param msg
     * @param com 
     */
     public void interpretMessage(Message msg, Communication com) throws URISyntaxException {
        switch (msg.getType()) {
            case Message.MESSAGE:
                miseaJour(msg);
                jTextPane1.setCaretPosition(jTextPane1.getDocument().getLength());
                break;
            case Message.LISTE:                
                miseaJourListe(msg.getList());
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
            case Message.JEUX_JOUEUR:
                miseaJourJeuxJoueur(msg);
                break;
            case Message.MAIN_JOUEUR:
                miseaJourMainJoueur(msg);
                break;
            case Message.SOUND:
                if(sonActive)
                    playSound(msg);
                break;
            case Message.CARTE_EN_COURS:
                miseaJourCarteEnCours(msg);
                break;            
            case Message.CARTES_JOUABLES:
                allowClicOnCardMain(msg,true);
                allowClicOnCardJeu(msg, true);
                break;
            case Message.INFO_CAMPS:
                miseaJourInfosCamps(msg);
                break;
            case Message.CHOIXCAMP:
                appendText(jTextPane1,msg.getNick_src() + " : "+msg.getMessage()+"\n" , Color.red);
                this.campClicable=true;
                break;
            case Message.CHOIXJOUEUR:
                appendText(jTextPane1,msg.getNick_src() + " : "+msg.getMessage()+"\n" , Color.red);
                this.choisirJoueur=true;
                break;
            case Message.INTERVENTION:
                this.state=msg.getAction();
                if(this.state==Constantes.ACTION_PRET){
                    this.buttonPoserCarte.setEnabled(connected);
                    this.buttonYes.setEnabled(connected);
                }
                else if(this.state==Constantes.ACTION_DEFAUSSER){                    
                    this.buttonPoserCarte.setEnabled(false);
                }
                else if(this.state==Constantes.ACTION_FIN_CHARITE){                    
                    this.buttonPoserCarte.setEnabled(true);
                }
                break;
            case Message.STOP_QUESTION_INTERVENTION:
            	stopQuestionIntervention();
                break;
        }
    }

     private void stopQuestionIntervention() {
    	 disableYesNoLabelTimerDisplayTimer();
	}
	private void changeComponentForground(Component comp,Color col){
         comp.setForeground(col);
     }
     
     private void appendText(JTextPane jpane,String str,Color color){
         
         StyledDocument doc = jpane.getStyledDocument();         
        try {
            Style style = doc.addStyle("StyleName", null);
            StyleConstants.setForeground(style,color );  
            if(defilementActif){
                for(char c :str.toCharArray()){
                    doc.insertString(doc.getLength(), String.valueOf(c),style );              
                    try {
                        Thread.sleep(10);
                        jTextPane1.setCaretPosition(jTextPane1.getDocument().getLength());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{
                doc.insertString(doc.getLength(),str, style);
                jTextPane1.setCaretPosition(jTextPane1.getDocument().getLength());
            }
            
            
            
           
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
           //jTextPane1.setForeground(message.getColor());       
       if (message.getNick_dest().equals("Partie")) {
            if(!message.getNick_src().equals(login))
                appendText(jTextPane1, message.getNick_src() +" : " + message.getMessage()+"\n",message.getColor());            
        } 
       else if (message.getNick_dest().equals("deconnexion")){
            int i = 0;
            while (i < jTabbedPane1.getTabCount() - 1 && jTabbedPane1.getTitleAt(i) != message.getMessage()) {
                i++;
            }
            if (jTabbedPane1.getTitleAt(i).equals(message.getNick_src()) || message.getNick_src().equals("admin")) {
                if (jTextPane2 != null && jTextPane2.getName().equals(login_dest)) 
                    appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage() + " est maintenant deconnecté !\n",Color.BLACK);               
            }
        } 
       else if (message.getNick_dest().equals("connexion")) {
            int i = 0;
            while (i < jTabbedPane1.getTabCount() - 1 && jTabbedPane1.getTitleAt(i) != message.getMessage()) {
                i++;
            }
            if (jTabbedPane1.getTitleAt(i).equals(message.getNick_src()) || message.getNick_src().equals("admin")) {
                if (jTextPane2 != null && jTextPane2.getName().equals(login_dest)) {
                    appendText(jTextPane2, message.getNick_src() + " dit : " + message.getMessage() + " est maintenant connecté \n!",Color.BLACK);                    
                }
            }
        } 
       else if (message.getNick_dest().equals(login)) {            
            if(ongletExist(jTabbedPane1,message.getNick_src()))                
                 appendText(this.mapTxtToJoueurs.get(message.getNick_src()), message.getNick_src() + " dit : " + message.getMessage()+"\n",Color.BLACK);
            else {                               
                newTab(message.getNick_src());                
                appendText(this.mapTxtToJoueurs.get(message.getNick_src()), message.getNick_src() + " dit : " + message.getMessage()+"\n ",Color.BLACK);              
            }
       }
    }
    
    private void newTab(String name){
        if(!name.equals(login) && !ongletExist(jTabbedPane1,name)){
         jScrollpane=new JScrollPane();
         jScrollpane.setViewportView(createTextAreaChatToJoueurs(name));       
         jTabbedPane1.addTab(name, jScrollpane);
             
        }
    }
    
    private boolean ongletExist(JTabbedPane tabpane,String name){
        boolean ret=false;
        for(int i=0;i<tabpane.getTabCount();i++){           
            
            if(tabpane.getTitleAt(i).equals(name)){
                ret=true;
                break;
            }
        }
        return ret;
    }
    
     private void disallowClicOnCard(){
        JPanel p = (JPanel) this.scrollPaneMain.getViewport().getComponent(0);            
        if(p instanceof JPanel)
            for(Component c : p.getComponents())
             if(c instanceof ShowImage){
                ((ShowImage)c).setClick_allowed(false);
                ((ShowImage)c).setGrisee(false);
             }
    }
     
    private void allowClicOnCardMain(Message msg ,boolean bool){
        JPanel p = (JPanel) this.scrollPaneMain.getViewport().getComponent(0);            
        if(p instanceof JPanel)
            for(Component c : p.getComponents())
             if(c instanceof ShowImage &&  msg.getMap().containsValue(((ShowImage)c).getImageName())){
                ((ShowImage)c).setClick_allowed(bool);
                ((ShowImage)c).setGrisee(!bool);
             }
             else if(c instanceof ShowImage &&  !msg.getMap().containsValue(((ShowImage)c).getImageName()))
                ((ShowImage)c).setGrisee(bool);
             
    }   
    private void allowClicOnCardJeu(Message msg ,boolean bool){
        JPanel p = (JPanel) this.scrollPaneJeux.getViewport().getComponent(0);            
        if(p instanceof JPanel)
            for(Component c : p.getComponents())
             if(c instanceof ShowImage &&  msg.getMap().containsValue(((ShowImage)c).getImageName())){
                ((ShowImage)c).setClick_allowed(bool);
                ((ShowImage)c).setGrisee(!bool);
             }
             else if(c instanceof ShowImage &&  !msg.getMap().containsValue(((ShowImage)c).getImageName()))
                ((ShowImage)c).setGrisee(bool);
             
    }   
    private void playSound(Message msg) {
        AudioInputStream ais = null;
        try {
            //WaveFileReader wfr = new WaveFileReader();
            ais = AudioSystem.getAudioInputStream(MunchkinVue.class.getResource("resources/songs/"+msg.getAction()+".WAV"));
            //ais=AudioSystem.getAudioInputStream(new File("src/munchkinclient/resources/songs/"+msg.getAction()+".wav"));
            //ais = wfr.getAudioInputStream(new File("src/munchkinclient/resources/songs/"+msg.getAction()+".wav"));
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            Clip c=(Clip)AudioSystem.getLine(info);
            c.open(ais);
            c.start();
        } catch (LineUnavailableException ex) {
            System.out.println("pas de periph de sortie");
        } 
        catch (IllegalArgumentException i){
            System.out.println("pas de periph de sortie");
        }
        catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ais.close();
            } catch (IOException ex) {
                Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void miseaJourInfoJoueur(Message msg){
         String name=msg.getNick_dest();
            if(name.equals(login))
                name="Mes Infos";
        
        String out=new String();
        for(Map.Entry<String,String> m: msg.getMap().entrySet())
            out+=m.getKey()+":" +m.getValue()+"\n";    
        
        for(Map.Entry<String,JTextArea> m: this.mapInfosJoueurs.entrySet())           
            if( m.getKey().equals(name))
                m.getValue().setText(out);         
        
    }
    
    
    private void miseaJourInfosCamps(Message msg) {
         JList selectedList=this.listCampGentil;
         ArrayList<String> listData=new ArrayList<String>();
         for(Map.Entry<String,String> m: msg.getMap().entrySet()){
             if(m.getKey().equals("Camp Mechant")){
                 listData.clear();
                 selectedList=this.listCampMechant;
             }
             
             listData.add(m.getKey()+ " : " +m.getValue());
             selectedList.setListData(listData.toArray());
         }
    }

      
    private void miseaJourJeuxJoueur(Message msg) throws URISyntaxException {
         String name=msg.getNick_dest();
            if(name.equals(login))
                name = "Mon Jeu"; 
            
        for(Component spane : tabbedPaneJeuxJoueurs.getComponents()){
            if(spane instanceof JScrollPane){
                if(spane.getName()!=null && (spane.getName().equals(name))){
                    this.scrollPaneJeux=(JScrollPane)spane; 
                    break;
                }
            }
        }
        
       JPanel imgView=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        for(Map.Entry<String,String> m: msg.getMap().entrySet())                          
               imgView.add(
           new ShowImage(m.getValue(),this));      
        this.scrollPaneJeux.setViewportView(imgView);    
        
        
    }    
    
    private void miseaJourMainJoueur(Message msg) throws URISyntaxException {
       JPanel imgView=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        for(Map.Entry<String,String> m: msg.getMap().entrySet())                          
               imgView.add(
           new ShowImage(m.getValue(),this));            
        this.scrollPaneMain.setViewportView(imgView);  
        //imgView.setBorder(BorderFactory.createLineBorder(Color.red));
    }    
    
    private void miseaJourCarteEnCours(Message msg) throws URISyntaxException {

        JPanel imgView = new JPanel();
        imgView.add(new ShowImage(msg.getMessage(), this,this.scrollPaneCarteEnCours.getWidth()
                ,this.scrollPaneCarteEnCours.getHeight()));
        this.scrollPaneCarteEnCours.setViewportView(imgView);

    }

    /**
     * Met a jour l'action proposé par le serveur
     * @param msg 
     */
    private void miseajourAction(Message msg) {
        this.labelTimer.setText("30");
    	displayTimer.start();
    	timer=new Timer("timer") ;
    	timer.schedule(new TimerTask(){
    		@Override
    		public void run() {                
    			disableActionButtonAndSendNo();
    		}           
    	},30*1000);

    	this.labelActionPrompt.setText(msg.getMessage());
        if(!msg.getMessage().equals("Annuler ?"))
            this.buttonNon.setEnabled(true);
    	this.buttonYes.setEnabled(true);
    	changeComponentForground(this.buttonNon, Color.red);
    	changeComponentForground(this.buttonYes, Color.red);       
    }
    
    private void disableActionButtonAndSendNo(){        
        this.buttonNon.setEnabled(false);
        this.buttonYes.setEnabled(false);
        com.sendMessage(new Message(Message.QUESTION, login, login_dest, "Non"));
        this.labelTimer.setText("30");
        displayTimer.stop();
        timer.cancel();
    }
    
    /**
     * Méthode permettant de désactiver les boutons Oui et Non, le LabelTimer et le Display Timer
     */
    private void disableYesNoLabelTimerDisplayTimer(){        
        this.buttonNon.setEnabled(false);
        this.buttonYes.setEnabled(false);       
        this.labelTimer.setText("30");
        displayTimer.stop();
        timer.cancel();
    }
  
    /**
     * met a jour la liste des connectés
     * @param liste 
     */    
    public void miseaJourListe(LinkedHashMap<String,Integer> list) {        
        ImagePanelList ip=new ImagePanelList(); 
        ArrayList<ImagePanelList> data=new ArrayList<ImagePanelList>();
        for(Map.Entry<String,Integer> m : list.entrySet())
        {            
                createTabInfoJouers(m.getKey());
                createTabJeuxJouers(m.getKey());                
                try {
                    ImageIcon icon=new ImageIcon( ImageIO.read(MunchkinVue.class.getResourceAsStream("resources/"+m.getValue()+".jpg")));  
                    Image img=icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
                    icon=new ImageIcon(img);
                    ip=new ImagePanelList(new JLabel(icon),new JLabel(m.getKey()));
                } catch (IOException ex) {
                    Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
                }
                data.add(ip);           
        }       
        jList1.setListData(data.toArray());
    }   

    private JTextArea createTextAreaInfoJoueurs(String name){
        JTextArea txtA= new JTextArea();
        this.mapInfosJoueurs.put(name,txtA);
        return txtA;
    }
    
    private JTextPane createTextAreaChatToJoueurs(String name){
        JTextPane txtA= new JTextPane();
        this.mapTxtToJoueurs.put(name,txtA);
        return txtA;
    }
    private void createTabInfoJouers(String name){
         if(name.equals(login))
                name="Mes Infos";
        if(!ongletExist(tabbedPaneInfosJoueurs, name)){           
            scrollPaneInfos=new JScrollPane();           
            scrollPaneInfos.setViewportView(createTextAreaInfoJoueurs(name));           
            this.tabbedPaneInfosJoueurs.addTab(name, scrollPaneInfos);            
        }
    }
     private void createTabJeuxJouers(String name){
          if(name.equals(login))
                name="Mon Jeu";
         if(!ongletExist(tabbedPaneJeuxJoueurs, name)){
                scrollPaneJeux=new JScrollPane();
                scrollPaneJeux.setName(name);
                this.tabbedPaneJeuxJoueurs.addTab(name, scrollPaneJeux);
         }
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
                Message msg = new Message(Message.CONNECT, login,"Partie",String.valueOf(connexion.getSexe()),connexion.getAvatar());
                connected = com.sendMessage(msg);      
                this.setTitle("Munchkin - "+login);
                this.tabbedPaneInfosJoueurs.removeAll();
                createTabInfoJouers("Mes Infos");              
               this.send_button.setEnabled(connected);
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
         if(jTextField1.getText().equals(":)")) 
             com.sendMessage(new Message(Message.SOUND, login, "Partie", Constantes.SOUND_RIRES));
         String text = jTextField1.getText()+"\n";

            if (connected) {
                if (login_dest != "Partie")
                    appendText(this.mapTxtToJoueurs.get(login_dest), "Moi : " + text +" \n",Color.BLACK);                    
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

/**
 * Méthode qui permet d'envoyer la carte au serveur.
 * On envoie un message de type intervention, avec l'état actuel dans la vue cliente
 * @param idCard
 */
public void envoyerCarte(String idCard){
    Message msg= new Message(Message.INTERVENTION, login, "Partie", this.state,idCard);
    com.sendMessage(msg);
    this.disallowClicOnCard();    
    this.buttonPoserCarte.setText("Poser une carte");
}                    

private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        sendMessage();
}//GEN-LAST:event_send_buttonActionPerformed

private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
}//GEN-LAST:event_jTextField1MouseClicked

private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
           sendMessage();
        }
}//GEN-LAST:event_jTextField1KeyPressed
/**
 * Appelé lors d'un click dans la liste de joueur
 * @param evt 
 *//**
 * Appelée lors d'un clic sur les onglet
 * @param evt 
 */
private void buttonNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNonActionPerformed
  this.buttonNon.setEnabled(false);
  this.buttonYes.setEnabled(false);
  com.sendMessage(new Message(Message.QUESTION, login, login_dest, "Non"));   
  changeComponentForground(this.buttonNon, Color.black);
  changeComponentForground(this.buttonYes, Color.black);
  timer.cancel();
  displayTimer.stop();
  this.labelTimer.setText("30");
}//GEN-LAST:event_buttonNonActionPerformed

private void buttonYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYesActionPerformed
  this.buttonNon.setEnabled(false);
  this.buttonYes.setEnabled(false);  
  com.sendMessage(new Message(Message.QUESTION, login, login_dest, "Yes"));  
  changeComponentForground(this.buttonNon, Color.black);
  changeComponentForground(this.buttonYes, Color.black);
  timer.cancel();
  displayTimer.stop();
  this.labelTimer.setText("30");
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

private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

}//GEN-LAST:event_jTextField1ActionPerformed

private void buttonPoserCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPoserCarteActionPerformed
    if(this.buttonPoserCarte.getText().equals("Poser une carte")){        
        this.state=Constantes.ACTION_POSERCARTE;
        com.sendMessage(new Message(Message.INTERVENTION, login, login_dest, Constantes.ACTION_POSERCARTE));
        this.buttonPoserCarte.setText("Annuler");
    }
    else if(this.buttonPoserCarte.getText().equals("Annuler")){
        disallowClicOnCard();
        this.buttonPoserCarte.setText("Poser une carte");
    }
}//GEN-LAST:event_buttonPoserCarteActionPerformed

private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(evt.getClickCount()==1){
            if(choisirJoueur){
                com.sendMessage(new Message(Message.CHOIXJOUEUR, login, "Partie",((ImagePanelList)jList1.getSelectedValue()).getNameJoueur().getText()));
                choisirJoueur=false;
            }
        }            
        else if (evt.getClickCount() == 2) {
            
            if(jList1.getSelectedValue()!=null){
                login_dest = ((ImagePanelList)jList1.getSelectedValue()).getNameJoueur().getText();           
                newTab(login_dest);            
            }
         

        } 
        else if (evt.getButton() == evt.BUTTON3) {
            JPopupMenu popup = new JPopupMenu();
            JMenuItem menuItem1 = new JMenuItem("Conversation privée");
            

            menuItem1.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                     
                    login_dest = ((ImagePanelList)jList1.getSelectedValue()).getNameJoueur().getText();                 
                    newTab(login_dest);
                    //jScrollpane.setViewportView(jTextPane2);

                }
            });           

            popup.add(menuItem1);          
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
       
}//GEN-LAST:event_jList1MouseClicked

private void tabbedPaneCampMechantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneCampMechantMouseClicked
if(campClicable){
    com.sendMessage(new Message(Message.CHOIXCAMP, login, "Partie", tabbedPaneCampMechant.getTitleAt(tabbedPaneCampMechant.getSelectedIndex())));
    campClicable=false;
}
}//GEN-LAST:event_tabbedPaneCampMechantMouseClicked

private void tabbedPaneCampGentilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneCampGentilMouseClicked
if(campClicable){
    com.sendMessage(new Message(Message.CHOIXCAMP, login, "Partie", tabbedPaneCampGentil.getTitleAt(tabbedPaneCampGentil.getSelectedIndex())));
    campClicable=false;
}
}//GEN-LAST:event_tabbedPaneCampGentilMouseClicked

private void radioBUttonMenuItemSonOuiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioBUttonMenuItemSonOuiItemStateChanged
if(this.radioBUttonMenuItemSonOui.isSelected())
    this.sonActive=true;
else
    this.sonActive=false;
}//GEN-LAST:event_radioBUttonMenuItemSonOuiItemStateChanged

private void radioBUttonMenuItemDefilOuiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioBUttonMenuItemDefilOuiItemStateChanged
if(this.radioBUttonMenuItemDefilOui.isSelected())
    this.defilementActif=true;
else
    this.defilementActif=false;
}//GEN-LAST:event_radioBUttonMenuItemDefilOuiItemStateChanged

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
                try {
                    new MunchkinVue().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MunchkinVue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupDefilement;
    private javax.swing.JButton buttonNon;
    private javax.swing.JButton buttonPoserCarte;
    private javax.swing.JButton buttonYes;
    private javax.swing.JMenuItem connexion_item;
    private javax.swing.JMenuItem deconnexion_Item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelActionPrompt;
    private javax.swing.JLabel labelTimer;
    private javax.swing.JList listCampGentil;
    private javax.swing.JList listCampMechant;
    private javax.swing.JMenu menuOption;
    private javax.swing.JRadioButtonMenuItem radioBUttonMenuItemDefilNon;
    private javax.swing.JRadioButtonMenuItem radioBUttonMenuItemDefilOui;
    private javax.swing.JRadioButtonMenuItem radioBUttonMenuItemSonNon;
    private javax.swing.JRadioButtonMenuItem radioBUttonMenuItemSonOui;
    private javax.swing.JScrollPane scrollPaneCampGentil;
    private javax.swing.JScrollPane scrollPaneCampMechant;
    private javax.swing.JScrollPane scrollPaneCarteEnCours;
    private javax.swing.JScrollPane scrollPaneInfos;
    private javax.swing.JScrollPane scrollPaneJeux;
    private javax.swing.JScrollPane scrollPaneMain;
    private javax.swing.JButton send_button;
    private javax.swing.JTabbedPane tabbedPaneCampGentil;
    private javax.swing.JTabbedPane tabbedPaneCampMechant;
    private javax.swing.JTabbedPane tabbedPaneInfosJoueurs;
    private javax.swing.JTabbedPane tabbedPaneJeuxJoueurs;
    private javax.swing.JTabbedPane tabbedPaneMainJoueur;
    private javax.swing.JTextArea textAreaInfos;
    // End of variables declaration//GEN-END:variables

}

