/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.ControleurEleve;
import Modele.InfoBDD;
import Modele.Personne;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class VueEleveHome extends JFrame {
    
    protected JFrame myFrameEleveHome;
    private JButton btQuitter;
    private JPanel affichageIdentite,tableau,panelP;
    private String nom, prenom; 
    private int idEleve;
    private JLabel nom_prenomEleve; 
            
            
    public VueEleveHome(int idPersonne, JFrame currentFrame) {
    myFrameEleveHome = currentFrame;
    myFrameEleveHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    idEleve = idPersonne; 
    
    ArrayList<Personne> listPersonne = InfoBDD.getListPersonne(); //recupere la liste des personnes inscrites
         
    for (Personne personne : InfoBDD.getListPersonne()) {
        if ((personne.getIdPersonne() == idEleve)){
            nom=personne.getNom(); 
            prenom=personne.getPrenom(); 
        }
    } 
    
    String nom_prenom = ("Bonjour "+prenom+" "+nom);
    nom_prenomEleve = new JLabel(nom_prenom);
        
    affichageIdentite = new JPanel();
    affichageIdentite.add(nom_prenomEleve); 
    panelP = new JPanel();
    tableau = new JPanel();
    
    btQuitter = new JButton("Quitter");
    
    btQuitter.addActionListener(new ControleurEleve(myFrameEleveHome, "Quitter", idEleve));
    
    affichageIdentite.setLayout(new GridLayout(3, 1));
    panelP.setPreferredSize(new Dimension(200, 200));
    
    
    
    affichageIdentite.add(btQuitter);
    
    
    panelP.add(affichageIdentite,BorderLayout.NORTH);
    myFrameEleveHome.add(panelP);
     
    myFrameEleveHome.setContentPane(panelP);
    myFrameEleveHome.repaint();
    myFrameEleveHome.revalidate();
    myFrameEleveHome.setVisible(true);
    myFrameEleveHome.pack();
  }
  
}
