/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import Tortue.*;


/**
 *
 * @author Guillaume
 */
public class ControleurExercice implements ActionListener {
    
    String nameB;
    TortueG myTurtle;
    Stack<String> lAction;
    TortueG graphicTurtle;
    int tTortue;
    
    public ControleurExercice(String nameButton, TortueG myTortue, TortueG myTurtle2, Stack<String> lastAction){
        nameB = nameButton;
        myTurtle=myTortue;
        lAction=lastAction;
        graphicTurtle = myTurtle2;
    };
    
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (nameB != null) switch (nameB){
                case "Valider":{
                    break;
                }
                case "Annuler":{
                    if (!lAction.empty()) {
                        lAction.pop();
                        //myTurtle.reset();
                        for (int i = 0; i < lAction.size(); i++) {
                            if (null == lAction.elementAt(i)) {
                                break;
                            } else {
                                switch (lAction.elementAt(i)) {
                                    case "avancer":
                                        myTurtle.avancer();
                                        break;
                                    case "tourner":
                                        myTurtle.tourner();
                                        break;
                                    case "ecrire":
                                        myTurtle.tracer(true);
                                        break;
                                    case "npecrire":
                                        myTurtle.tracer(false);
                                        break;
                                }
                            }
                        }
                    }
                }
                case "Effacer":{
                    while(!lAction.empty()){
                    lAction.pop();
                    }
                    myTurtle.reset();
                }
                case "Retour au menu": {
                    break;
                }
                case "Avancer": {
                    myTurtle.avancer();
                    lAction.add("avancer");
                    break;
                }
                case "Tourner": {
                    myTurtle.tourner();
                    lAction.add("tourner");
                    break;
                }
                case "Ecrire": {
                    myTurtle.tracer(true);
                    lAction.add("ecrire");
                    break;
                }
                case "Ne pas ecrire": {
                    myTurtle.tracer(false);
                    lAction.add("npecrire");
                    break;
                }
                case "Selectionner autre tortue":{
                    if (myTurtle != graphicTurtle) {
                        myTurtle = graphicTurtle;
                        break;}
                    else
                        break;
                    }
                default:
                    break;
            }
        };
    
    /*else if (ae.getSource()==btUndo) {
            
        } else if (ae.getSource()==btRetourMenu) {
            
        } else if (ae.getSource()==btValider) {
            
        }
        else {
                       
    }
    
    }*/
}
