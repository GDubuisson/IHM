     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Classe;
import Modele.InfoBDD;
import Modele.Personne;
import javax.swing.*;   
import javax.swing.tree.DefaultMutableTreeNode;
import Vue.VueTree;
import Controleur.ControleurTree_2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Guillaume
 */
public class VueResultat extends JFrame{
    
    private JTree tree;
    private DefaultMutableTreeNode racine;
    private Personne personneActive;
    private Classe classeActive;
    
    private JPanel infoEleve;
    private JLabel prenom;
    private JLabel nom;
    private JLabel classe;
    protected JFrame myFrameResultat;
    
    public VueResultat(){        
         racine = new DefaultMutableTreeNode("GPhy");
         CreationTree();
         tree = new JTree(racine);
         tree.setShowsRootHandles(true);
         tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
         tree.addTreeSelectionListener(new ControleurTree_2(this.tree,this));
       
         nom = new JLabel("Nom");
         nom.setPreferredSize(new Dimension(150,150));
         infoEleve = new JPanel();
         infoEleve.add(nom);
         this.add(infoEleve);
         this.add(tree, BorderLayout.NORTH);
         this.setPreferredSize(new Dimension(200,200));
         this.setVisible(true);
    }
    
    public void CreationTree(){
            for (Classe classe : InfoBDD.getListClasse()){
                DefaultMutableTreeNode noeudC = new DefaultMutableTreeNode (classe);
                racine.add(noeudC);
                 System.out.println(InfoBDD.getListEleveClasse(classe));
                for (Personne p : InfoBDD.getListEleveClasse(classe)){
                    DefaultMutableTreeNode noeudE = new DefaultMutableTreeNode (p.getNom() + " " + p.getPrenom());
                    noeudC.add(noeudE);    
                }  
            }   
        }
    
    public void controllerJTreeCall(Object selectedNode){
        if (selectedNode instanceof Personne) {
            personneActive = (Personne)selectedNode; 
            classeActive= personneActive.getNomClasse();
            update(); //mis à jour
            
            System.out.println(classeActive);
            System.out.println("Personne" + personneActive);
            System.out.println("hey");
            update();//mis à jour
            
        }else if(selectedNode instanceof Classe){ //si l'élément choisi est une classe
            personneActive = null; //il n'y a pas d'élève courant
            classeActive = (Classe)selectedNode; // la classe courante est celle sélectionnée
            System.out.println(personneActive);
            System.out.println(classeActive);
            update(); //mis à jour
            
        }else{
            System.out.println("Erreur");
        }
    }
    
    public void update(){
        
        if (personneActive != null) {
           
            infoEleve.remove(nom);
           // infoEleve.remove(prenom);
            //infoEleve.remove(classe);
           // panExercice.remove(creerExercice);
          //  panExercice.remove(modifierExercice);
            
            nom.setText(personneActive.getNom()); // Nom de l'eleve
           // prenom.setText(personneActive.getPrenom()); //Prenom de l'eleve
            
            infoEleve.add(nom, BorderLayout.WEST);
           // infoEleve.add(prenom, BorderLayout.CENTER);
          //  infoEleve.add(classe,BorderLayout.EAST);
           // VisuTableExEleveProf tableExEleveProf = new VisuTableExEleveProf(currentEleve);
          //  panExercice.add(tableExEleveProf);
            this.repaint();
            this.validate();
             
        }else if(classeActive != null) {
            
            infoEleve.remove(nom);
           // infoEleve.remove(prenom);
            //infoEleve.remove(classe);
           // panExercice.remove(creerExercice);
          //  panExercice.remove(modifierExercice);
            
            nom.setText(classeActive.getNomClasse().toString()); // Nom de l'eleve
           // prenom.setText(personneActive.getPrenom()); //Prenom de l'eleve
            
            infoEleve.add(nom, BorderLayout.WEST);
           // infoEleve.add(prenom, BorderLayout.CENTER);
          //  infoEleve.add(classe,BorderLayout.EAST);
           // VisuTableExEleveProf tableExEleveProf = new VisuTableExEleveProf(currentEleve);
          //  panExercice.add(tableExEleveProf);
            this.repaint();
            this.validate();
            
        }
        else{
            System.out.print("Erreur_update");
        }
    }
    
     public static void main(String[] args) {
            VueResultat vue = new VueResultat();
}
    
}

