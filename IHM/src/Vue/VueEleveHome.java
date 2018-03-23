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
/**
 *
 * @author Guillaume
 */
public class VueEleveHome extends JFrame {
    
    public VueEleveHome() {
        
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Eleve_Accueil");
    this.setSize(300, 120);

    //Les données du tableau
    Object[][] data = {
      {"Cysboy", "28 ans", "1.80 m"},
      {"BZHHydde", "28 ans", "1.80 m"},
      {"IamBow", "24 ans", "1.90 m"},
      {"FunMan", "32 ans", "1.85 m"}
      };
    
    //Les titres des colonnes

    String  title[] = {"Nom exercice", "Score", "Nombre d'essai"};

    JTable tableau = new JTable(data, title);

    //Nous ajoutons notre tableau à notre contentPane dans un scroll

    //Sinon les titres des colonnes ne s'afficheront pas !

    this.getContentPane().add(new JScrollPane(tableau));

  }   
      public static void main(String[] args){
    VueEleveHome fen = new VueEleveHome();
    fen.setVisible(true);
  }  
}
