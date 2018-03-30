/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.VueCreaExercice;
import Vue.VueEvaluationTentative;
import Vue.VueModificationExercice;
import Vue.VueTree;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Adèlounette
 */
public class ControleurEleve implements ActionListener{
 private JFrame wint; 
   private String nameButton; 
   private int idEleve; 
  
   public ControleurEleve(JFrame currentFrame, String nameButton, int idPersonne){
    wint = currentFrame; 
    this.nameButton = nameButton; 
    this.idEleve = idPersonne; 
    
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
