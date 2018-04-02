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
 * 30:03                On passe a une architecture avec Bouton qui mene vers 
 *                      l'exercice aligné avec champ score et champ essais
 * 
 */
package Vue;

import Controleur.ControleurEleve;
import Modele.InfoBDD;
import Modele.ListExo;
import Modele.Personne;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class VueEleveHome extends JFrame {
    
    protected JFrame myFrameEleveHome;
    private JButton btQuitter;
    private JPanel affichageIdentite,tableau,panelP;
    private String nom, prenom; 
    private int idEleve;
    private JLabel nom_prenomEleve; 
    private JScrollPane scroll = new JScrollPane(myFrameEleveHome);
    
    int N = 1;
            
            
    public VueEleveHome(int idPersonne, JFrame currentFrame) {
    myFrameEleveHome = currentFrame;
    myFrameEleveHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    idEleve = idPersonne; 
    
    ArrayList<Personne> listPersonne = InfoBDD.getListPersonne(); //recupere la liste des personnes inscrites
    ArrayList<ListExo>  ListExercice = InfoBDD.getListExercice(); //recupere la liste des exercices
    
    for (Personne personne : InfoBDD.getListPersonne()) {
        if ((personne.getIdPersonne() == idEleve)){
            nom=personne.getNom(); 
            prenom=personne.getPrenom(); 
        }
    } 
    
    
    String nom_prenom = ("Bonjour "+prenom+" "+nom);
    nom_prenomEleve = new JLabel(nom_prenom);
        
    // boucle qui parcours le code pour determiner N = Nombre d'exercices réalisées par l'eleve
 // for (ListExo listExo : InfoBDD.getListExercice()) {
 //         N=N+1;
 //     }
  //} 
  
          InfoBDD.getListExercice().forEach((_item) -> {
            N=N+1;
        }); 
    
    
    
    affichageIdentite = new JPanel();
    affichageIdentite.add(nom_prenomEleve); 
    panelP = new JPanel();
    tableau = new JPanel();
    
    btQuitter = new JButton("Quitter");
    JButton[] Exercices = new JButton[N];
    
    for (int i=1; i<N; i++)
{
    Exercices[i] = new JButton("Exercice "+i);
   // Exercices[i].addActionListener(this);
    tableau.add(Exercices[i]);
}
    
    btQuitter.addActionListener(new ControleurEleve(myFrameEleveHome, "Quitter", idEleve));
    
    
    affichageIdentite.setLayout(new GridLayout(1, 3));
    tableau.setLayout(new GridLayout(N, 1));
    
    panelP.setPreferredSize(new Dimension(200, 200));
    
    
    
    affichageIdentite.add(btQuitter);
    panelP.add(scroll, BorderLayout.CENTER);
    panelP.add(affichageIdentite,BorderLayout.NORTH);
    panelP.add(tableau,BorderLayout.WEST);
    myFrameEleveHome.add(panelP);
     
    myFrameEleveHome.setContentPane(panelP);
    myFrameEleveHome.repaint();
    myFrameEleveHome.revalidate();
    myFrameEleveHome.setVisible(true);
    myFrameEleveHome.pack();
  }
  
}
