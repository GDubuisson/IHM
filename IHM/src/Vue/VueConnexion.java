/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import Controleur.ControleurConnexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controleur.ControleurConnexion; 
import javax.swing.JOptionPane;

/**
 *Classe permettant à l'utilisateur de se connecter 
 * @author grp5
 */
public class VueConnexion extends JFrame {

    private JButton connectButton;
    private JTextField idPersonne;
    private JTextField mdp;
    private JLabel idLabel, mdpLabel;  
    private JPanel myPanel1;
    private JPanel myPanelText;
    private JLabel labelTortueImage; 
    protected JFrame myFrameWelcome;

    /**
    * Constructeur de la table VueConnexion
    * Cette table permet aux utilisateurs de se connecter via un identifiant 
    * qui lui est donné et un mot de passe qui correspond à son prénom
    * Exemple d'un élève : id = 1 ; mot de passe = pauline 
    * Exemple d'un professeur : id = 3 ; mot de passe = allan 
    *
    */
    public VueConnexion() {
        myFrameWelcome = new JFrame("PROJET LOGO");
        myFrameWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrameWelcome.setPreferredSize(new Dimension(750, 560));
        
        labelTortueImage = new JLabel(new ImageIcon(this.getClass().getResource("image/tortue_image.png")), JLabel.CENTER);
        myPanel1 = new JPanel();
        myPanelText = new JPanel();
        myPanelText.setLayout(new GridLayout(2,2));
        idPersonne = new JTextField();
        idPersonne.setColumns(10);

        idLabel = new JLabel("identifiant : "); 
        mdpLabel = new JLabel("mot de passe : "); 
        
        mdp = new JTextField();
        mdp.setColumns(10);
        myPanelText.add(mdp, BorderLayout.SOUTH);

        connectButton = new JButton("Se connecter");    
        connectButton.addActionListener(new ControleurConnexion(this));
         
        myPanelText.add(idLabel); 
        myPanelText.add(idPersonne); 
        myPanelText.add(mdpLabel); 
        myPanelText.add(mdp); 
        
        myPanel1.setLayout(new GridLayout(3,1));
        myPanel1.add(labelTortueImage); 
        myPanel1.add(myPanelText);
        myPanel1.add(connectButton);

        myFrameWelcome.add(myPanel1);
        myFrameWelcome.setVisible(true);
        myFrameWelcome.pack();
    }
    
     /**
     * Fonction permettant de retourner l'identifiant rentré par une personne 
     *
     * @return identifiant d'une personne 
     */
    public int getIdPersonneField(){
        //return idPersonne; 
        return Integer.parseInt(idPersonne.getText()); 
    }
    
     /**
     * Fonction permettant de retourner le mot de passe rentré par une personne 
     *
     * @return le mot de passe d'une personne 
     */
    public String getMdpField(){
        return mdp.getText(); 
    }
    public JFrame getFrame(){
        return myFrameWelcome; 
    }
}

