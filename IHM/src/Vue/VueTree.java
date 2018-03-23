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
	private DefaultMutableTreeNode racine;

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
                for (Personne p : InfoBDD.getListPersonne()){
                    DefaultMutableTreeNode noeudE = new DefaultMutableTreeNode (p.getNom());
                    noeudC.add(noeudE);    
                }   

            }
            
        }
        
        public static void main(String[] args) {
            VueTree vue = new VueTree();
            vue.CreationTree();
}
}