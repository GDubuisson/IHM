/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modele.Personne;
import Modele.InfoBDD; 
import Vue.VueConnexion; 
import Vue.VueEleveHome;
import Vue.VueProfHome;
import static ihm.SQLiteConnection.connect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 *
 * @author grp5 
 */


  
public class ControleurConnexion implements ActionListener{
   private boolean isProf;
   private int idPersonneField; 
   private String mdpField; 
   private JFrame wint; 
  
   public ControleurConnexion(JTextField idPersonne, JTextField mdp, JFrame myFrameWelcome){
    ArrayList<Personne> listPersonne = InfoBDD.getListPersonne(); //recupere la liste des personnes inscrites
 idPersonneField = Integer.parseInt(idPersonne.getText());
         mdpField = mdp.getText();    
//idPersonneField = idPersonne;
    //mdpField = mdp;
    wint = myFrameWelcome; 
   }

    @Override
public void actionPerformed(ActionEvent ae) {
    if (connexion(idPersonneField, mdpField)==true){
        if (getProf()){
            VueProfHome vueProfHome = new VueProfHome(idPersonneField, wint);
            //ferme la fenetre de connexion
            System.out.println("connexion reussie");
        }  
        else{
            VueEleveHome vueEleveHome = new VueEleveHome(idPersonneField);
            //ferme la fenetre de connexion
            System.out.println("connexion reussie");
        }
    }
    else{
         JOptionPane erreur_connexion;
         erreur_connexion = new JOptionPane();
         erreur_connexion.showMessageDialog(null, "Identifiant ou mot de passe incorrect", "Echec connexion", JOptionPane.ERROR_MESSAGE);
         }
}

   
   public boolean connexion (int idPersonne, String mdp){        
        for (Personne personne : InfoBDD.getListPersonne()) {
            if ((personne.getIdPersonne() == idPersonne) && (personne.getMdp().equals(mdp))){
                isProf=personne.isEnseignant(); 

                return(true); 
            }
        } 
        return(false);
    }
    
   public boolean getProf(){
       return isProf; 
   }
}
