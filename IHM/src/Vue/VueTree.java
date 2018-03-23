package Vue;

import Modele.*;
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
        
	/*private JPanel panelEleve;
	private JPanel panelProf;
        private JPanel panelFormField;
        private JPanel panelEleveContent;
        private JPanel panelEleveContentFields;
        private JPanel panelBottom;
        
	private JTextField setProf;
	private JTextField setNombreEleves;
	private JTextField setNiveau;
	private JTextField setPrenom;
	private JTextField setNom;
	private JTextField setAge;
	private JTextField setSexe;
	
	private JButton ModificationClasse;
	private JButton ModificationEleve;
	
	private JLabel lblPrenomEleve;
	private JLabel lblSexeEleve;
	private JLabel lblAgeEleve;
	private JLabel lblNomEleve;
        private JLabel lblProfesseur;
	private JLabel lblNIveau;
	private JLabel lblNbrEleves;
        
	private Eleve currentEleve;
	private Classe currentClasse;
	private Modele model;
	private VueTable viewTable;*/

	// create the frame
	public VueTree() {
            
            racine = new DefaultMutableTreeNode("GPhy");
            tree = new JTree(racine);
            tree.setShowsRootHandles(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            this.add(tree);
            this.setVisible(true);
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