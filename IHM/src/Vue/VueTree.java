package Vue;

import Modele.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/*
import Modele.Classe;
import Modele.Eleve;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import controleur.ControleurSave;
import controleur.ControleurTree;
import Modele.*;

/**
 * Classe permettant l'affichage de l'interface.
 * 
 * @author grp5
 *
 */
public class VueTree extends JFrame {

	/*private JSplitPane splitPane;*/
        private final JFrame Interface = new JFrame();
	private JTree tree;
        private Personne persoSelectionne;
        private Classe classeSelectionnee;
	private DefaultMutableTreeNode racine;
        private Personne personneActive;
        private Classe classeActive;

	// create the frame
	public VueTree() {
            
            racine = new DefaultMutableTreeNode("GPhy");
            tree = new JTree(racine);
            tree.setShowsRootHandles(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            this.add(tree);
            this.pack();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.setPreferredSize(new Dimension(200,200));
            
        }
        
        public void CreationTree(){
            for (Classe classe : InfoBDD.getListClasse()){
                DefaultMutableTreeNode noeudC = new DefaultMutableTreeNode (classe.getNomClasse());
                racine.add(noeudC);
                 System.out.println(InfoBDD.getListEleveClasse(classe.getIdClasse()));
                for (Personne p : InfoBDD.getListEleveClasse(classe.getIdClasse())){
                    DefaultMutableTreeNode noeudE = new DefaultMutableTreeNode (p.getNom() + " " + p.getPrenom());
                    noeudC.add(noeudE);    
                }   

            }
            
        }
        
        public void controllerJTreeCall(Object selectedNode){
        if (selectedNode instanceof Personne) { //si l'élément choisi est un élève
            personneActive = (Personne)selectedNode; //l'élève courant est celui sélectionné
            int niveau =  personneActive.getClasse(); //la classe courante est celle de l'élève sélectionné
            classeActive= new Classe(niveau);
            //update();//mis à jour
            
        }else if(selectedNode instanceof Classe){ //si l'élément choisi est une classe
            personneActive = null; //il n'y a pas d'élève courant
            classeActive = (Classe)selectedNode; // la classe courante est celle sélectionnée
            //update(); //mis à jour
            
        }else{
            System.out.println("Erreur");
        }
    }
        public static void main(String[] args) {
            VueTree vue = new VueTree();
            vue.CreationTree();
}
}       

