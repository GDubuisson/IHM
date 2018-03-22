/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

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
import javax.swing.JTextField;

/**
 *Classe permettant à l'utilisateur de se connecter 
 * @author grp5
 */
public class VueConnexion extends JFrame {

    private JButton connectButton;
    private JTextField idPersonne;
    private JTextField mdp;
    private JLabel idLabel;
    private JLabel mdpLabel;
    private JPanel myPanel1;
    private JPanel myPanelText;
    protected JFrame myFrameWelcome;

    public VueConnexion() {
        myFrameWelcome = new JFrame("Welcome");
        myFrameWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel1 = new JPanel();
        myPanelText = new JPanel();
        myPanelText.setLayout(new GridLayout(2,2));
        JTextField idPersonne = new JTextField();
        idPersonne.setColumns(10);

        idLabel = new JLabel("identifiant : "); 
        mdpLabel = new JLabel("mot de passe : "); 
        
        JTextField mdp = new JTextField();
        mdp.setColumns(10);
        myPanelText.add(mdp, BorderLayout.SOUTH);

        connectButton = new JButton("Se connecter");
         connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //connexion à la base de donnée  
                //if eleve
                // ouvre l'interface élève
                //else
                // ouvre l'interface prof : VueProfHome
            }
        });
        myPanelText.add(idLabel); 
        myPanelText.add(idPersonne); 
        myPanelText.add(mdpLabel); 
        myPanelText.add(mdp); 
        
        myPanel1.setLayout(new BorderLayout());
        myPanel1.add(myPanelText, BorderLayout.NORTH);
        myPanel1.add(connectButton, BorderLayout.CENTER);

        //connectButton.addActionListener(new GestionAction(this, "connexion"));
        myFrameWelcome.add(myPanel1);
        myFrameWelcome.setVisible(true);
        myFrameWelcome.pack();

    }
}

