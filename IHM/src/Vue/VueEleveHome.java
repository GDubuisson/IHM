/*
 *-----------------------------------------------------------------------------
 *L'accueil élève est composé d’un tableau qui liste tous les exercices.
 *Il y a 3 colonnes : Une colonne identifiant l’exercice, une colonne score 
 *(acquis/en cours d’acquisition/ non acquis), et une colonne nombre d’essai.
 *Une couleur Bleue apparaît sur les exercices non effectués, une couleur verte
 *sur les exercices effectué réussi, et une couleur rouge sur les exercice 
 *effectué non réussi. En cliquant sur l'identifiant d’un exercice on a alors 
 *accès au plan de travail de résolution d’exercice
 *Si l’exercice a déjà été tenté, une interface avec le dessin du professeur,
 *le dessin fait par l’élève et le code s’affichent. L’élève à la possibilité 
 *de cliquer sur un bouton pour refaire l’exercice. Ce bouton emmène au plan de 
 *travail.
 *-----------------------------------------------------------------------------
 *La vue eleve 
 *une entête comprenant :
 *                      - Le nom et le prenom de l'eleve
 *                      -un bouton quitter sur la droite
 *un tableau possédant 3 collones et un nombre de ligne non défini:
 *                  
 *                      -une colone Nom exercice
 *                      -une colone Score
 *                      -une colone nombre d'essai
 *-----------------------------------------------------------------------------
 * 27:03            :   Besoin de connexion BDD et Besoin de JTABLE
 *                      Passer les ActionListener dans le controleur
 *-----------------------------------------------------------------------------
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
