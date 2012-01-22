package munchkinclient;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Fenetre de connexion
 * @author Guillaume Renoult
 */
public class Connexion extends JDialog {
    
    private String login;
    private InetAddress serveur;
    private int port;
    private boolean saisie_effectué=false;
    private int sexe=Constantes.SEXE_M;   

    /** 
     * Creates new form Connexion 
     */
    public Connexion(JFrame parent,boolean b) {
        super(parent,b);
        try {
            initComponents();          
            Font font1= Font.createFont(Font.TRUETYPE_FONT, MunchkinVue.class.getResourceAsStream("resources/CASLANTR.TTF"));
            font1=font1.deriveFont(18f);
            this.jLabel1.setFont(font1);
            this.jLabel2.setFont(font1);
            this.jLabel3.setFont(font1);           
            this.connectButton.setFont(font1);
            this.cancelButton.setFont(font1);
            this.radioBUttonLocal.setFont(font1);
            this.radioButtonInternet.setFont(font1);
            this.radioButtonF.setFont(font1);
            this.radioButtonM.setFont(font1);
            
            
        } catch (FontFormatException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
 
    
    // ===== ACCESSEURS & MUTATEURS ===== //
    public boolean getEtat(){ 
        return saisie_effectué; 
    }
    
    public String getLogin(){ 
        return login; 
    }   

    public int getSexe() {
        return sexe;
    }   
    
    public InetAddress getServeur(){ 
        return serveur; 
    }
    
    public int getPort(){ 
        return port; 
    }
    // ================================== //

    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        serveur_ComboBox = new javax.swing.JComboBox();
        login_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        radioButtonInternet = new javax.swing.JRadioButton();
        radioBUttonLocal = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        radioButtonM = new javax.swing.JRadioButton();
        radioButtonF = new javax.swing.JRadioButton();
        avatarLabel = new javax.swing.JLabel();

        setTitle("Connexion");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(520, 320));
        setResizable(false);

        connectButton.setText("Connect");
        connectButton.setName("connectButton"); // NOI18N
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        serveur_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "localhost", "192.168.0.17", "192.168.1.2", "meg4mi.no-ip.org", " ", " " }));

        login_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                login_fieldKeyPressed(evt);
            }
        });

        jLabel2.setText("Login :");

        jLabel1.setText("Choisissez le Serveur :");

        buttonGroup1.add(radioButtonInternet);
        radioButtonInternet.setText("Internet");
        radioButtonInternet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonInternetItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radioBUttonLocal);
        radioBUttonLocal.setSelected(true);
        radioBUttonLocal.setText("Local");
        radioBUttonLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioBUttonLocalItemStateChanged(evt);
            }
        });

        jLabel3.setText("Sexe :");

        buttonGroup2.add(radioButtonM);
        radioButtonM.setSelected(true);
        radioButtonM.setText("Masculin");
        radioButtonM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonMItemStateChanged(evt);
            }
        });

        buttonGroup2.add(radioButtonF);
        radioButtonF.setText("Feminin");

        avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/munchkinclient/resources/avatar.jpg"))); // NOI18N
        avatarLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        avatarLabel.setPreferredSize(new java.awt.Dimension(168, 168));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(login_field, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioBUttonLocal)
                                        .addGap(27, 27, 27)
                                        .addComponent(radioButtonInternet))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(serveur_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioButtonM)
                                        .addGap(10, 10, 10)
                                        .addComponent(radioButtonF)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                        .addComponent(connectButton)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioBUttonLocal)
                            .addComponent(radioButtonInternet))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(serveur_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(login_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(radioButtonM)
                            .addComponent(radioButtonF)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
private void connecter(){
     try {
            serveur = InetAddress.getByName(serveur_ComboBox.getSelectedItem().toString());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
login=login_field.getText();
if(this.radioBUttonLocal.isSelected())
    port=8767;
else
    port=80;
saisie_effectué=true;
this.dispose();
}
    
private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
connecter();
}//GEN-LAST:event_connectButtonActionPerformed

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    saisie_effectué=false;              
}//GEN-LAST:event_cancelButtonActionPerformed

private void radioButtonInternetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonInternetItemStateChanged
if( this.radioButtonInternet.isSelected()){
    this.serveur_ComboBox.setSelectedIndex(3);
    this.serveur_ComboBox.setEnabled(false);    
}
}//GEN-LAST:event_radioButtonInternetItemStateChanged

private void radioBUttonLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioBUttonLocalItemStateChanged
if( this.radioBUttonLocal.isSelected()){
    this.serveur_ComboBox.setSelectedIndex(0);
    this.serveur_ComboBox.setEnabled(true);
}
}//GEN-LAST:event_radioBUttonLocalItemStateChanged

private void login_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_login_fieldKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    connecter();
}//GEN-LAST:event_login_fieldKeyPressed

private void radioButtonMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonMItemStateChanged
if(this.radioButtonM.isSelected())
    this.sexe=Constantes.SEXE_M;
else
    this.sexe=Constantes.SEXE_F;
}//GEN-LAST:event_radioButtonMItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField login_field;
    private javax.swing.JRadioButton radioBUttonLocal;
    private javax.swing.JRadioButton radioButtonF;
    private javax.swing.JRadioButton radioButtonInternet;
    private javax.swing.JRadioButton radioButtonM;
    private javax.swing.JComboBox serveur_ComboBox;
    // End of variables declaration//GEN-END:variables

}
