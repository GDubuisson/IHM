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

    public VueConnexion() {
        myFrameWelcome = new JFrame("Welcome");
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
        //int idPersonneField = Integer.parseInt(idPersonne.getText());
        //String mdpField = mdp.getText();
        connectButton.addActionListener(new ControleurConnexion(idPersonne,mdp, myFrameWelcome));
/*        connectButton.addActionListener(new ActionListener (idPersonne.getText(),mdp.getText(), myFrameWelcome) {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    int idPersonneField = Integer.parseInt(idPersonne.getText());
                    String mdpField = mdp.getText();
                    
                    System.out.println(idPersonneField); 
                    System.out.println(mdpField); 

                    if (controlConnexion.connexion(idPersonneField, mdpField)==true){
                        if (controlConnexion.getProf()){
                            VueProfHome vueProfHome = new VueProfHome(idPersonneField, myFrameWelcome);
                            //ferme la fenetre de connexion
                            System.out.println("connexion reussie");
                            dispose();
                        }  
                        else{
                            VueEleveHome vueEleveHome = new VueEleveHome(idPersonneField);
                            //ferme la fenetre de connexion
                            System.out.println("connexion reussie");
                            dispose();
                        }
                    }
                    
                    else{
                        JOptionPane erreur_connexion;
                        erreur_connexion = new JOptionPane();
                        erreur_connexion.showMessageDialog(null, "Identifiant ou mot de passe incorrect", "Echec connexion", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }); */
         
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
    public JTextField getIdPersonne(){
        return idPersonne; 
    }
    
    public JTextField getMdp(){
        return mdp; 
    }
    public JFrame getFrame(){
        return myFrameWelcome; 
    }
}

