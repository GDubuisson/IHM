package Vue;

//import Controleur.ControleurTree;
import Modele.*;
import Controleur.*;
import controleur.ControleurTree_1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * Classe permettant l'affichage de l'interface.
 * 
 * @author grp5
 *
 */
public class VueTree extends JFrame {

	private JTree tree;
        private VueTable viewTable;
        
        private Personne persoSelectionne;
        private Classe classeSelectionnee;
	private DefaultMutableTreeNode racine;
        private Personne personneActive;
        private Classe classeActive;

        private JPanel principal; 
        private JPanel panelEleve;
        private JLabel nomProf;
        private JLabel nomClasse;
        private JPanel panelResultat;
        private JLabel prenom;
        private JLabel nom;
        private JLabel classe;
        private JLabel labelNomEleve;
        
        
	// create the frame
	public VueTree() {
            
            this.classeSelectionnee = new Classe();

            this.viewTable = new VueTable(this);
	    viewTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            racine = new DefaultMutableTreeNode("GPhy");
            tree = new JTree(racine);
            tree.setShowsRootHandles(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            this.add(tree);
            this.pack();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.setPreferredSize(new Dimension(200,200));
            viewTable = new VueTable(this);
            nomProf = new JLabel("Hello");
            getContentPane().setLayout(new BorderLayout(0,0));
            getContentPane().add(nomProf);
            
            this.add(principal);

		// Ajout du Listenner
            tree.addTreeSelectionListener(new ControleurTree_1(this, this.tree));
            
            
            
        }
        
        public void CreationTree(){
            for (Classe classe : InfoBDD.getListClasse()){
                DefaultMutableTreeNode noeudC = new DefaultMutableTreeNode (classe.getNomClasse());
                racine.add(noeudC);
//                 System.out.println(InfoBDD.getListEleveClasse(classe.getIdClasse()));
                for (Personne p : InfoBDD.getListEleveClasse(classe)){
                    DefaultMutableTreeNode noeudE = new DefaultMutableTreeNode (p.getNom() + " " + p.getPrenom());
                    noeudC.add(noeudE);    
                }  
            }   
        }
        
        public void controllerJTreeCall(Object selectedNode){
        if (selectedNode instanceof Personne) { //si l'élément choisi est un élève
            personneActive = (Personne)selectedNode; //l'élève courant est celui sélectionné
         //   int niveau =  personneActive.getClasse(); //la classe courante est celle de l'élève sélectionné
        //    classeActive= new Classe(niveau);
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

