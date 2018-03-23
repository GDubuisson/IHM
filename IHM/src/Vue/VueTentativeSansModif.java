/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Guillaume
 */
public class VueTentativeSansModif {
    
    private JButton btValider, btRecommencer, btRetourMenu;
    private JTextField idPersonne;
    private JTextField mdp;
    private JPanel barreHaut, panelPrincip, panelDessins, panelCode, barreBas, panelDessinProf, panelDessinEleve;
    protected JFrame myFrameExercice;
    
    public VueTentativeSansModif() {
        
        myFrameExercice = new JFrame("Exercice");
        myFrameExercice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        barreHaut = new JPanel();
        panelPrincip = new JPanel();
        panelDessins = new JPanel();
        panelCode = new JPanel();
        barreBas = new JPanel();
        
        btValider = new JButton("Valider");
        btRecommencer = new JButton("Recommencer");
        btRetourMenu = new JButton("Retour au menu");
        
        barreHaut.setLayout(new GridLayout(1, 3));
        panelPrincip.setLayout(new BorderLayout());
        panelDessins.setLayout(new BorderLayout());
        panelDessinProf.setPreferredSize(new Dimension(100, 100));
        panelDessinEleve.setPreferredSize(new Dimension(100,100));
        panelDessins.add(panelDessinProf,BorderLayout.NORTH);
        panelDessins.add(panelDessinEleve,BorderLayout.SOUTH);
        
        btValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Valide
            }
        });
        
        btRecommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });    
        
        btRetourMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        
        barreHaut.add(btValider);
        barreHaut.add(btRecommencer);
        barreHaut.add(btRetourMenu);
        
        panelPrincip.add(barreHaut,BorderLayout.NORTH);
        panelPrincip.add(barreBas, BorderLayout.SOUTH);
        panelPrincip.add(panelDessins,BorderLayout.WEST);
        panelPrincip.add(panelCode,BorderLayout.EAST);
        myFrameExercice.add(panelPrincip);
        
        myFrameExercice.setVisible(true);
        myFrameExercice.pack();
    }
    
}
