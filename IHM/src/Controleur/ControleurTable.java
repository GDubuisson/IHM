///*package Controleur;
//
//import javax.swing.JTable;
//import javax.swing.ListSelectionModel;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import Vue.VueTree;
//import Modele.Classe;
//import Modele.Eleve;
//
///**
// * Classe permet de gérer la JavaTable
// *
// * @author grp5
// *
// *//*
//public class ControleurTable implements ListSelectionListener {
//	private JTable table;
//	private Classe classe;
//	private VueTree vue;
//
//    /**
//     * Constructeur de la classe ControleurTable
//     * @param table
//     * @param classe
//     * @param vue
//     *//*
//    public ControleurTable(JTable table, Classe classe, VueTree vue) {
//        this.table = table;
//        this.classe = classe;
//        this.vue = vue;
//
//    }
//
//    @Override
//    public void valueChanged(ListSelectionEvent listSelectionEvent) {
//        if (listSelectionEvent.getValueIsAdjusting()) {
//            return;
//        }
//        ListSelectionModel lsm = (ListSelectionModel) listSelectionEvent
//                .getSource();
//        if (lsm.isSelectionEmpty()) {
//            System.out.println("No rows selected");
//        } else {
//
//            int selectedRow = lsm.getMinSelectionIndex();
//
//            Eleve selectedEleve = classe
//                    .get(table.convertRowIndexToModel(selectedRow));
//            System.out.println(
//                    "The row " + selectedEleve.toString() + " is now selected");
//
//            vue.afficheInfo(selectedEleve);
//        }
//    }
//}
//*/