/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Tortue.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Guillaume
 */
public class VueCreaExercice extends JFrame implements ActionListener {
    
    private JButton btValider, btUndo,btEffacer, btRetourMenu, btAvancer, btTourner, btEcrire, btNePasEcrire,btSelTortue;
    private JPanel barreHaut, panelPrincip, panelCode, barreBas, panelDessinProf;
    private Stack<String> lastAction;
    private TortueG myTortue,myGraphicTurtle,myColorTurtle;
    
     public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == btAvancer) {
            myTortue.avancer();
            lastAction.add("avancer");
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
    
    public VueCreaExercice (){
        myGraphicTurtle = new TortueG();
        myColorTurtle = new TortueCouleur("RED");
        myTortue = myGraphicTurtle;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        barreHaut = new JPanel();
        panelPrincip = new JPanel();
        panelCode = new JPanel();
        barreBas = new JPanel();
        panelDessinProf = Tortue.Canvas.getCanvasPanel();
        lastAction=new Stack();
        
        
        btValider = new JButton("Valider");
        btUndo = new JButton("Annuler");
        btEffacer = new JButton("Effacer");
        btRetourMenu = new JButton("Retour au menu");
        btAvancer = new JButton("Avancer");
        btTourner = new JButton("Tourner");
        btEcrire = new JButton("Ecrire");
        btNePasEcrire = new JButton("Ne pas ecrire");
        btSelTortue = new JButton("Selectionner autre tortue");
        
        barreHaut.setLayout(new GridLayout(1, 4));
        barreBas.setLayout(new GridLayout(1,5));
        panelPrincip.setLayout(new BorderLayout());
        panelCode.setPreferredSize(new Dimension(100, 100));
        
        btValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Valide
            }
        });
        
        btUndo.addActionListener(this);    
        
        btRetourMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //retourmenu
            }
        });
        
        btEffacer.addActionListener(this);
        
        btAvancer.addActionListener(this);
        btTourner.addActionListener(this);
        btEcrire.addActionListener(this);
        btNePasEcrire.addActionListener(this);
        btSelTortue.addActionListener(this); 
        
        barreHaut.add(btValider);
        barreHaut.add(btUndo);
        barreHaut.add(btEffacer);
        barreHaut.add(btRetourMenu);
        
        
        barreBas.add(btAvancer);
        barreBas.add(btTourner);
        barreBas.add(btEcrire);
        barreBas.add(btNePasEcrire);
        barreBas.add(btSelTortue);
        
        
        panelPrincip.add(barreHaut,BorderLayout.NORTH);
        panelPrincip.add(barreBas, BorderLayout.SOUTH);
        panelPrincip.add(panelDessinProf,BorderLayout.WEST);
        panelPrincip.add(panelCode,BorderLayout.EAST);
        this.add(panelPrincip);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        
    }
    
}