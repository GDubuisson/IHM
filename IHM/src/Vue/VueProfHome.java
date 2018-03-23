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
import javax.swing.JTextField;

/**
 *
 * @author grp5
 */
public class VueProfHome {
 private JButton nouvelExo;
    private JButton modifExo;
    private JButton evaluer;
    private JButton result;
    private JPanel myPanel1;
    private JPanel myPanelButton;
    private JLabel nomProf; 
    protected JFrame myFrameProfHome;

    public VueProfHome(int idProf) {
        myFrameProfHome = new JFrame("Vue prof");
        myFrameProfHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel1 = new JPanel();
        myPanelButton = new JPanel();
        myPanelButton.setLayout(new GridLayout(4,0));
        
        nouvelExo= new JButton("Nouvel exercice");
        nouvelExo.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                VueCreaExercice nouvelExo =  new VueCreaExercice(); 
            }
        });
        modifExo= new JButton("Modifier exercice");
        evaluer= new JButton("Evaluer");
        result = new JButton("Résultats");
        result.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                VueTree resultats =  new VueTree(); 
                resultats.CreationTree();
            }
        });
        
        myPanelButton.add(nouvelExo); 
        myPanelButton.add(modifExo); 
        myPanelButton.add(evaluer); 
        myPanelButton.add(result); 
        
        nomProf = new JLabel("nom prof"); 
        myPanel1.setLayout(new BorderLayout());
        myPanel1.add(nomProf, BorderLayout.NORTH);
        myPanel1.add(myPanelButton, BorderLayout.CENTER);

        //connectButton.addActionListener(new GestionAction(this, "connexion"));
        myFrameProfHome.add(myPanel1);
        myFrameProfHome.setVisible(true);
        myFrameProfHome.pack();

}   
}
