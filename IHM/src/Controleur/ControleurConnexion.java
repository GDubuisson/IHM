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
import static ihm.SQLiteConnection.connect;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author grp5 
 */


  
public class ControleurConnexion {
   private static boolean isProf; 
   
   public static boolean connexion (int idPersonne, String mdp){
        ArrayList<Personne> listPersonne = InfoBDD.getListPersonne(); //recupere la liste des personnes inscrites
         
        for (Personne personne : InfoBDD.getListPersonne()) {
            if ((personne.getIdPersonne() == idPersonne) && (personne.getMdp().equals(mdp))){
                isProf=personne.isEnseignant(); 

                return(true); 
            }
        } 
        return(false);
    }
    
   public static boolean getProf(){
       return isProf; 
   }
}
