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
                        System.out.println("1");
                        myTurtle.reset();
                        for (int i = 0; i < lAction.size(); i++) {
                            System.out.println("2");
                            if (null == lAction.elementAt(i)) {
                                System.out.println("3");
                                break;
                            } else {
                                switch (lAction.elementAt(i)) {
                                    case "avancer":
                                        System.out.println("4");
                                        myTurtle.avancer();
                                        break;
                                    case "tourner":
                                        System.out.println("5");
                                        myTurtle.tourner();
                                        break;
                                    case "ecrire":
                                        System.out.println("6");
                                        myTurtle.tracer(true);
                                        break;
                                    case "npecrire":
                                        System.out.println("7");
                                        myTurtle.tracer(false);
                                        break;
                                    default:
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
            for (int i = 0; i < lAction.size(); i++) {
                System.out.println(lAction.elementAt(i));
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
