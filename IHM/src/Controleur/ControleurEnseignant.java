/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.InfoBDD;
import Modele.Personne;
import Vue.VueConnexion;
import Vue.VueCreaExercice;
import Vue.VueEleveHome;
import Vue.VueEvaluationTentative;
import Vue.VueModificationExercice;
import Vue.VueProfHome;
import Vue.VueTable;
import Vue.VueTree;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe permettant de controler les boutons de la classe VueProfHome 
 * @author grp_5
 */
public class ControleurEnseignant implements ActionListener{
    
   private JFrame wint; 
   private String nameButton; 
   private int idProf; 
  
   /**
 * constructeur de la classe 
 * @param la frame pour ne pas avoir à ouvrir une nouvelle fenêtre, 
 * le nom du boutton sur lequel on a cliqué et l'identifiant de la personne connectée 
 */
   public ControleurEnseignant(JFrame currentFrame, String nameButton, int idProf){
    wint = currentFrame; 
    this.nameButton = nameButton; 
    this.idProf = idProf; 
    
   }

    @Override
public void actionPerformed(ActionEvent ae) {
    if (null != nameButton) switch (nameButton) {
        case "creaExo":{
            VueCreaExercice nouvelExo =  new VueCreaExercice();
            break; 
        }
        case "resultats": {
            VueTree resultats =  new VueTree(); 
            resultats.CreationTree();
            break; 
        }
        case "modifExo":{
            VueModificationExercice modifExo =  new VueModificationExercice();
            break; 
        }
        case "evaluer":{
            VueEvaluationTentative evaluerExo =  new VueEvaluationTentative();
            break; 
        }    
        default:
                break;
    }
}
    
}