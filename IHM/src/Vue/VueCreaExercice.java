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
import Controleur.ControleurExercice;

/**
 *
 * @author Guillaume
 */
public class VueCreaExercice extends JFrame {
    
    private JButton btValider, btUndo,btEffacer, btRetourMenu, btAvancer, btTourner, btEcrire, btNePasEcrire,btSelTortue;
    private JPanel barreHaut, panelPrincip, panelCode, barreBas, panelDessinProf;
    private Stack<String> lastAction;
    private TortueG myTortue,myGraphicTurtle,myColorTurtle;
    private ControleurExercice myC;
    
     
    
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
        myC = new ControleurExercice("Avancer", myTortue, myTortue, lastAction);
        
        
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
        

        
        btAvancer.addActionListener(new ControleurExercice("Avancer", myTortue,myColorTurtle, lastAction));
        btTourner.addActionListener(new ControleurExercice("Tourner", myTortue,myColorTurtle, lastAction));
        btEcrire.addActionListener(new ControleurExercice("Ecrire", myTortue,myColorTurtle, lastAction));
        btNePasEcrire.addActionListener(new ControleurExercice("Ne pas ecrire", myTortue,myColorTurtle, lastAction));
        btSelTortue.addActionListener(new ControleurExercice("Selectionner autre tortue", myTortue,myColorTurtle, lastAction));
        btUndo.addActionListener(new ControleurExercice("Annuler", myTortue,myColorTurtle, lastAction));
        btValider.addActionListener(new ControleurExercice("Valider", myTortue,myColorTurtle, lastAction));
        btEffacer.addActionListener(new ControleurExercice("Effacer", myTortue,myColorTurtle, lastAction));
        
        
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