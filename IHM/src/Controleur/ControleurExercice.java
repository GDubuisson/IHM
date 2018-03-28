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
    
    public ControleurExercice(String nameButton, TortueG myTortue, Stack<String> lastAction){
        nameB = nameButton;
        myTurtle=myTortue;
        lAction=lastAction;
    };
    
        @Override
        public void actionPerformed(ActionEvent ae) {
        myTurtle.avancer();
    };
    
    /*public void avancer (TortueG myTortue) {
        
    }
        else if (ae.getSource() == btEffacer) {
            while(!lastAction.empty()){
                lastAction.pop();
            }
            myTortue.reset();}
        else if (ae.getSource() == btTourner){
            myTortue.tourner();
            lastAction.add("tourner");
        }
        else if (ae.getSource() == btEcrire){
            myTortue.tracer(true);
            lastAction.add("ecrire");
        }
        else if (ae.getSource()== btNePasEcrire){
            myTortue.tracer(false);
            lastAction.add("npecrire");
        }
        else if (ae.getSource()==btUndo) {
            if (!lastAction.empty()) {
                lastAction.pop();
                myTortue.reset();
                for (int i = 0; i < lastAction.size(); i++) {
                    if (null == lastAction.elementAt(i)) {
                        break;
                    } else {
                        switch (lastAction.elementAt(i)) {
                            case "avancer":
                                myTortue.avancer();
                                break;
                            case "tourner":
                                myTortue.tourner();
                                break;
                            case "ecrire":
                                myTortue.tracer(true);
                                break;
                            case "npecrire":
                                myTortue.tracer(false);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } else if (ae.getSource()==btRetourMenu) {
            
        } else if (ae.getSource()==btValider) {
            
        }
        else {
            if (myTortue == myGraphicTurtle)
                myTortue = myColorTurtle;
            else
                myTortue = myGraphicTurtle;
            myTortue.reset();
            }           
    }
    
    }*/
}
