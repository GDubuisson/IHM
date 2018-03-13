package Vue;

import Modele.Eleve;
import Modele.Classe;
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

	private JSplitPane splitPane;
	private JTree tree;
	private DefaultMutableTreeNode racine;
        
	private JPanel panelEleve;
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
	private VueTable viewTable;

	// create the frame
	public VueTree() {

		// Base
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Projet - Gr5");

		// Creation des modeles
		this.model = new Modele();

		// Creation de la table
		this.viewTable = new VueTable(this);
		viewTable.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		panelBottom = new JPanel();
		getContentPane().add(panelBottom, BorderLayout.SOUTH);
		panelBottom.setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		getContentPane().add(splitPane);

		racine = new DefaultMutableTreeNode(model.getEtablissement().getNom());
		tree = new JTree(racine);
		tree.setShowsRootHandles(true);
		tree.getSelectionModel()
				.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		//Listenner
		tree.addTreeSelectionListener(new ControleurTree(this, this.tree));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);
		splitPane.setLeftComponent(scrollPane);
		JPanel panContent = new JPanel();
		splitPane.setRightComponent(panContent);
		panContent.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panForm = new JPanel();
		panContent.add(panForm);
		panForm.setLayout(new GridLayout(2, 1, 0, 0));

		panelProf = new JPanel();
		panForm.add(panelProf);
		panelProf.setLayout(new BorderLayout(0, 0));

		panelFormField = new JPanel();

		panelProf.add(panelFormField);
		panelFormField.setLayout(new GridLayout(0, 3, 0, 0));

		lblProfesseur = new JLabel("Professeur");
		lblProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
		panelFormField.add(lblProfesseur);

		lblNIveau = new JLabel("Niveau");
		lblNIveau.setHorizontalAlignment(SwingConstants.CENTER);
		panelFormField.add(lblNIveau);

		lblNbrEleves = new JLabel("Nombre d'élèves");
		lblNbrEleves.setHorizontalAlignment(SwingConstants.CENTER);
		panelFormField.add(lblNbrEleves);

		setProf = new JTextField();
		lblProfesseur.setLabelFor(setProf);
		panelFormField.add(setProf);
		setProf.setText("Nom Professeur");
		setProf.setColumns(10);
                setProf.setHorizontalAlignment(JTextField.CENTER);

		setNiveau = new JTextField();
		panelFormField.add(setNiveau);
		setNiveau.setText("Niveau");
		setNiveau.setColumns(10);
                setNiveau.setHorizontalAlignment(JTextField.CENTER);

		setNombreEleves = new JTextField();
		setNombreEleves.setEditable(false);
		lblNbrEleves.setLabelFor(setNombreEleves);
		panelFormField.add(setNombreEleves);
		setNombreEleves.setText("Nombre d'élèves");
		setNombreEleves.setColumns(10);
                setNombreEleves.setHorizontalAlignment(JTextField.CENTER);

		ModificationClasse = new JButton("Modifier");
		ModificationClasse.addActionListener(new ControleurSave(this));

		panelProf.add(ModificationClasse, BorderLayout.EAST);

		panelEleve = new JPanel();
		panForm.add(panelEleve);
		panelEleve.setLayout(new BorderLayout(0, 0));

		panelEleveContent = new JPanel();
		panelEleve.add(panelEleveContent, BorderLayout.CENTER);
		panelEleveContent.setLayout(new GridLayout(0, 1, 0, 0));

		panelEleveContentFields = new JPanel();
		panelEleveContent.add(panelEleveContentFields);
		panelEleveContentFields.setLayout(new GridLayout(0, 4, 0, 0));

		lblPrenomEleve = new JLabel("Prenom");
		lblPrenomEleve.setLabelFor(lblPrenomEleve);
		lblPrenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblPrenomEleve);

		lblNomEleve = new JLabel("Nom");
		lblNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblNomEleve);

		lblAgeEleve = new JLabel("Age");
		lblAgeEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblAgeEleve);

		lblSexeEleve = new JLabel("Sexe");
		lblSexeEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblSexeEleve);

		setPrenom = new JTextField();
		panelEleveContentFields.add(setPrenom);
		setPrenom.setText("Prenom");
		setPrenom.setColumns(10);
                setPrenom.setHorizontalAlignment(JTextField.CENTER);

		setNom = new JTextField();
		lblNomEleve.setLabelFor(setNom);
		panelEleveContentFields.add(setNom);
		setNom.setText("Nom");
		setNom.setColumns(10);
                setNom.setHorizontalAlignment(JTextField.CENTER);

		setAge = new JTextField();
		lblAgeEleve.setLabelFor(setAge);
		panelEleveContentFields.add(setAge);
		setAge.setText("Age");
		setAge.setColumns(10);
                setAge.setHorizontalAlignment(JTextField.CENTER);

		setSexe = new JTextField();
		panelEleveContentFields.add(setSexe);
		setSexe.setText("Sexe");
		setSexe.setColumns(10);
                setSexe.setHorizontalAlignment(JTextField.CENTER);

		ModificationEleve = new JButton("Modifier");
		ModificationEleve.addActionListener(new ControleurSave(this));
		panelEleve.add(ModificationEleve, BorderLayout.EAST);

		JPanel panFiche = new JPanel();
		panFiche.setBackground(Color.LIGHT_GRAY);
		panContent.add(panFiche);
		panFiche.setLayout(new GridLayout(0, 1, 0, 0));

		this.pack(); 

		// Permet d'effectuer le Scroll
		JPanel panScroll = new JPanel();
		panScroll.setBackground(Color.WHITE);
		panFiche.add(panScroll);
		panScroll.setLayout(new GridLayout(0, 1, 0, 0));
		panScroll.add(viewTable);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	/**
	 * @return SetProf
	 */
	public JTextField getTxtProf() {
		return setProf;
	}

	/**
	 * @return SetNombreEleves
	 */
	public JTextField getTxtNombreEleves() {
		return setNombreEleves;
	}

	/**
	 * @return SetNiveau
	 */
	public JTextField getTxtNiveau() {
		return setNiveau;
	}

	/**
	 * @return the SetPrenom
	 */
	public JTextField getTxtPrenom() {
		return setPrenom;
	}

	/**
	 * @return the SetNom
	 */
	public JTextField getTxtNom() {
		return setNom;
	}

	/**
	 * @return SetAge
	 */
	public JTextField getTxtAge() {
		return setAge;
	}

	/**
	 * @return setSexe
	 */
	public JTextField getTxtSexe() {
		return setSexe;
	}

	/**
	 * Creation du JTree
	 */
	public void createTree() {
		for (Classe classe : this.model.getEtablissement().getClasses()) {
			DefaultMutableTreeNode laClasse = new DefaultMutableTreeNode(
					classe);
			for (Eleve el : classe.getEleves()) {
				System.out.println(el);
				DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
				laClasse.add(eleve);
			}
			racine.add(laClasse);
		}
	}

	/**
	 * Recpteur du controler JTree JTree
	 * 
	 * @param node
	 */
	public void afficheInfo(Object node) {
		if (node instanceof Eleve) {
			currentEleve = (Eleve) node;
			currentClasse =currentEleve.getClasse();
			
			update();
		} else if (node instanceof Classe) {
			currentClasse = (Classe) node;
			currentEleve = null;
			update();
			
		} else {
			System.out.println("Print");
		}

	}

	/**
	 * @return the currentEleve
	 */
	public Eleve getCurrentEleve() {
		return currentEleve;
	}

	/**
	 * @return the currentClasse
	 */
	public Classe getCurrentClasse() {
		return currentClasse;
	}

	/**
	 * Recepteur des modifs de table
	 */
	public void afficheInfo(VueTree this,Eleve node) {
		if (node instanceof Eleve) {
			currentEleve = node;
			currentClasse =currentEleve.getClasse();
			update();
		}
	}

	/**
	 * Met a jour tous les champs de la view;
	 */
	public void update() {
		if (currentEleve != null) {
			setSexe.setText(currentEleve.getSexe());
			setAge.setText(currentEleve.getAge());
			setNom.setText(currentEleve.getNom());
			setPrenom.setText(currentEleve.getPrenom());
			String taille = ""
					+ (currentEleve.getClasse().getNombreEleves() + "");
			setNombreEleves.setText(taille);
			setProf.setText(currentEleve.getClasse().getProfesseur());
			setNiveau.setText("" + currentEleve.getClasse().getNiveau());
			this.viewTable.setData(currentEleve.getClasse());
		} else if (currentClasse != null) {
			String taille = "" + (currentClasse.getNombreEleves());
			setNombreEleves.setText(taille);
			setProf.setText(currentClasse.getProfesseur());
			setNiveau.setText("" + currentClasse.getNiveau());
			this.viewTable.setData(currentClasse);
			setSexe.setText("");
			setAge.setText("");
			setNom.setText("");
			setPrenom.setText("");
		} else {
			System.out.println("null");
		}
	}

}
