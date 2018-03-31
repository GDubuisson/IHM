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
 * Classe permettant de controler les boutons de la VueConnexion 
 * @author grp5 
 */
public class ControleurConnexion implements ActionListener{
   private boolean isProf;
   private int idPersonneField; 
   private String mdpField; 
   private JFrame wint;
   private VueConnexion currentVue;  
  
   public ControleurConnexion(VueConnexion currentVue){
    ArrayList<Personne> listPersonne = InfoBDD.getListPersonne(); //recupere la liste des personnes inscrites  
    this.currentVue = currentVue; 
    wint = currentVue.getFrame(); 
   }

    @Override
public void actionPerformed(ActionEvent ae) {
    int idPersonneField = currentVue.getIdPersonneField();
    String mdpField = currentVue.getMdpField();
    if (connexion(idPersonneField, mdpField)==true){
        if (getProf()){
            VueProfHome vueProfHome = new VueProfHome(idPersonneField, wint);
            //ferme la fenetre de connexion
            System.out.println("connexion reussie");
        }  
        else{
            VueEleveHome vueEleveHome = new VueEleveHome(idPersonneField, wint);
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

/**
 * Fonction permettant de voir si l'identifiant et le mot de passe correspondent à une personne de la base de donnée  
 *
 * @return un booléen permenttant de savoir si la personne a été trouvée et si l'on peut se connecter 
 */
   public boolean connexion (int idPersonne, String mdp){        
        for (Personne personne : InfoBDD.getListPersonne()) {
            if ((personne.getIdPersonne() == idPersonne) && (personne.getMdp().equals(mdp))){
                isProf=personne.isEnseignant(); 

                return(true); 
            }
        } 
        return(false);
    }
   
/**
* Fonction permettant de savoir si une personne est un professeur  
*
* @return un booléen permettant de savoir si une personne est un professeur  
*/
   public boolean getProf(){
       return isProf; 
   }
}
