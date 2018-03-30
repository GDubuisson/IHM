/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class VueEleveHome extends JFrame {
    
    protected JFrame myFrameEleveHome;
    private JButton btQuitter;
    private JPanel affichageIdentite,tableau,panelP;
            
            
    public VueEleveHome(int idEleve, JFrame currentFrame) {
        
	
    myFrameEleveHome = currentFrame;
    myFrameEleveHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    affichageIdentite = new JPanel();
    panelP = new JPanel();
    tableau = new JPanel();
    
    btQuitter = new JButton("Quitter");
    
    btQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Valide
            }
        });
    
    affichageIdentite.setLayout(new GridLayout(1, 3));
    panelP.setPreferredSize(new Dimension(200, 200));
    
    
    
    affichageIdentite.add(btQuitter);
    
    
    panelP.add(affichageIdentite,BorderLayout.NORTH);
    myFrameEleveHome.add(panelP);
     
    
    
    
    myFrameEleveHome.setVisible(true);
    myFrameEleveHome.pack();
  }
  
}
