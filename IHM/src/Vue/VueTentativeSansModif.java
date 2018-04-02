  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Tortue.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controleur.ControleurExercice;
import java.util.*;

/**
 *
 * @author Guillaume
 */
public class VueTentativeSansModif {
    
    private JButton btValider, btRecommencer, btRetourMenu, btAvancer, btTourner, btEcrire,btSelTortue, btNePasEcrire, btUndo;
    private JPanel barreHaut, panelPrincip, panelDessins, panelCode, barreBas, panelDessinProf, panelDessinEleve;
    protected JFrame myFrameExercice;
    private TortueG myTortue,myGraphicTurtle,myColorTurtle;
    private Stack<String> lastAction;
    
    public VueTentativeSansModif() {
        
        myFrameExercice = new JFrame("Exercice");
        myFrameExercice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myGraphicTurtle = new TortueG();
        myColorTurtle = new TortueCouleur("RED");
        myTortue = myGraphicTurtle;
        
        lastAction = new Stack();
        
        barreHaut = new JPanel();
        panelPrincip = new JPanel();
        panelDessins = new JPanel();
        panelCode = new JPanel();
        barreBas = new JPanel();
        panelDessinProf = new JPanel();
        panelDessinEleve = new JPanel();
        
        btValider = new JButton("Valider");
        btRecommencer = new JButton("Recommencer");
        btRetourMenu = new JButton("Retour au menu");
        btAvancer = new JButton("Avancer");
        btTourner = new JButton("Tourner");
        btEcrire = new JButton("Ecrire");
        btSelTortue = new JButton("Selectionner autre tortue");
        btNePasEcrire = new JButton("Ne pas ecrire");
        btUndo = new JButton("Annuler");
        
        barreHaut.setLayout(new GridLayout(1, 3));
        barreBas.setLayout(new GridLayout(1,4));
        panelPrincip.setLayout(new BorderLayout());
        panelDessins.setLayout(new BorderLayout());
        panelCode.setPreferredSize(new Dimension(300, 400));
        panelDessinProf = Tortue.Canvas.getCanvasPanel();
        panelDessinEleve = Tortue.Canvas.getCanvasPanel();
        panelDessins.setLayout(new GridLayout(1,2));
        panelDessins.add(panelDessinProf);
        panelDessins.add(panelDessinEleve);
//        panelDessins.add(panelDessinProf,BorderLayout.WEST);
//        panelDessins.add(panelDessinEleve,BorderLayout.EAST);

        btAvancer.addActionListener(new ControleurExercice("Avancer", myTortue,myColorTurtle, lastAction,panelCode));
        btTourner.addActionListener(new ControleurExercice("Tourner", myTortue,myColorTurtle, lastAction,panelCode));
        btEcrire.addActionListener(new ControleurExercice("Ecrire", myTortue,myColorTurtle, lastAction,panelCode));
        btNePasEcrire.addActionListener(new ControleurExercice("Ne pas ecrire", myTortue,myColorTurtle, lastAction,panelCode));
        btSelTortue.addActionListener(new ControleurExercice("Selectionner autre tortue", myTortue,myColorTurtle, lastAction,panelCode));
        btUndo.addActionListener(new ControleurExercice("Annuler", myTortue,myColorTurtle, lastAction,panelCode));
        btValider.addActionListener(new ControleurExercice("Valider", myTortue,myColorTurtle, lastAction,panelCode));
        btRecommencer.addActionListener(new ControleurExercice("Effacer", myTortue,myColorTurtle, lastAction,panelCode));
        
        barreHaut.add(btValider);
        barreHaut.add(btRecommencer);
        barreHaut.add(btRetourMenu);
        
        
        barreBas.add(btAvancer);
        barreBas.add(btTourner);
        barreBas.add(btEcrire);
        barreBas.add(btSelTortue);
        
        
        panelPrincip.add(barreHaut,BorderLayout.NORTH);
        panelPrincip.add(barreBas, BorderLayout.SOUTH);
        panelPrincip.add(panelDessins,BorderLayout.WEST);
        //panelPrincip.add(panelCode,BorderLayout.EAST);
        myFrameExercice.add(panelPrincip);
        
        myFrameExercice.setVisible(true);
        myFrameExercice.pack();
    }
    
}
