/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Classe;
import Modele.Personne;
import Controleur.ControleurTable;
import Modele.InfoBDD;
import java.util.*;
import javax.swing.*;

import javax.swing.table.AbstractTableModel;

/**
 * Classe permettant de gérer l'affichage de la JTable
 *
 * @author grp5
 */
public class VueTable extends JScrollPane {

    private JTable table;
    private ModeleStatique modeleTable;
    private ListSelectionModel listSelectionModel;
    private VueTree vue;

    /**
     * Constructeur de la table VueTable
     *
     * @param vue
     */
    public VueTable(VueTree vue) {
        Classe classe = new Classe("");
        this.vue = vue;
        modeleTable = new ModeleStatique(classe);

        table = new JTable(modeleTable);
        table.setAutoCreateRowSorter(true); //trie automatique des cellules
        table.setCellSelectionEnabled(true); //possibilité de selectionner des cellules 
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(table);
        this.setViewportView(table);
    }

    /**
     * Méthode permettant de modifier les informations de la classe
     *
     * @param classe
     */
    public void setData(Classe classe) {
        
        modeleTable = new ModeleStatique(classe);
        table = new JTable(modeleTable);
        table.setAutoCreateRowSorter(true);
        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.add(table);
        this.setViewportView(table);
        listSelectionModel = table.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ControleurTable(table, classe, vue));
        for (Personne pers : classe.getEleves()) {
            System.out.println(pers.getNom());
            this.modeleTable.fireTableDataChanged();
        }
    }

    /**
     * Classe permettant la gestion de l'affichage la JTable
     */
    static class ModeleStatique extends AbstractTableModel {
        private static final long serialVersionUID = 3833559037349078513L;
        private ArrayList<Personne> personne;

        /**
         * Constructeur de la classe ModeleStatique
         *
         * @param classe
         */
      /*  public ModeleStatique() {
            for (Classe classeActive : InfoBDD.getListClasse()){
                 System.out.println(InfoBDD.getListEleveClasse(classeActive.getIdClasse()));
            }
        }*/
        public ModeleStatique(Classe classe) {
            personne = classe.getEleves();
            }

        @Override
        public int getRowCount() {
            return 5;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public int getColumnCount() {
           return 5;// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public String getColumnName(int columnIndex) {
	    return entetes[columnIndex];
	}

        private final String[] entetes = {"ID", "Nom", "Prénom", "Garçon/Fille", "Âge"};

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return personne.get(rowIndex).getIdPersonne();
                case 1:
                    return personne.get(rowIndex).getPrenom();
                case 2:
                    return personne.get(rowIndex).getNom();
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Accesseur à la JTable
     *
     * @return
     */
    public JTable getTable() {
        return this.table;
    }
    
    public static void main(String[] args) {
            VueTree vue = new VueTree();
            VueTable table = new VueTable(vue);
}
}

