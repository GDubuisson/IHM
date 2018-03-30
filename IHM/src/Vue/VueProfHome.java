/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;
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
import javax.swing.JTextField;
import Controleur.ControleurEnseignant; 

/**
 *
 * @author grp5
 */
public class VueProfHome {
 private JButton nouvelExo;
    private JButton modifExo;
    private JButton evaluer;
    private JButton result;
    private JPanel myPanel2;
    private JPanel myPanelButton;
    private JLabel nom_prenomProf; 
    protected JFrame myFrameProfHome;
    private String nom, prenom; 

    public VueProfHome(int idProf,JFrame currentFrame) {
        myFrameProfHome = currentFrame; 
        myFrameProfHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Personne> listPersonne = InfoBDD.getListPersonne(); //recupere la liste des personnes inscrites
         
        for (Personne personne : InfoBDD.getListPersonne()) {
            if ((personne.getIdPersonne() == idProf)){
              nom=personne.getNom(); 
              prenom=personne.getPrenom(); 
            }
        } 
        
        myPanel2 = new JPanel();
        
        myPanelButton = new JPanel();
        myPanelButton.setLayout(new GridLayout(4,0));
        
        nouvelExo= new JButton("Nouvel exercice");
        nouvelExo.addActionListener(new ControleurEnseignant (myFrameProfHome,"creaExo"));
       
        modifExo= new JButton("Modifier exercice");
        modifExo.addActionListener(new ControleurEnseignant (myFrameProfHome,"modifExo"));
        
        evaluer= new JButton("Evaluer");
        evaluer.addActionListener(new ControleurEnseignant (myFrameProfHome,"evaluer"));
        
        result = new JButton("Résultats");
        result.addActionListener(new ControleurEnseignant (myFrameProfHome,"resultats"));
        
        myPanelButton.add(nouvelExo); 
        myPanelButton.add(modifExo); 
        myPanelButton.add(evaluer); 
        myPanelButton.add(result); 
        
        String nom_prenom = (prenom+" "+nom);
        nom_prenomProf = new JLabel(nom_prenom);
        
        myPanel2.setLayout(new BorderLayout());
        myPanel2.add(nom_prenomProf, BorderLayout.NORTH);
        myPanel2.add(myPanelButton, BorderLayout.CENTER);

        //connectButton.addActionListener(new GestionAction(this, "connexion"));
        myFrameProfHome.setContentPane(myPanel2);
        myFrameProfHome.repaint();
        myFrameProfHome.revalidate();
        myFrameProfHome.setVisible(true);
        myFrameProfHome.pack();

}   
}
