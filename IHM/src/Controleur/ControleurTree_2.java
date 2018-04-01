/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.VueResultat;
import Vue.VueTree;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author popor
 */
public class ControleurTree_2 implements TreeSelectionListener {

	private VueResultat vue;
	private JTree tree;
        
        public ControleurTree_2(JTree tree, VueResultat vue) {
		this.tree = tree;
                this.vue = vue;
	}

    @Override
    public void valueChanged(TreeSelectionEvent arg0) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node == null) {
            return;
        } else {

            Object nodeInfo = node.getUserObject();
            System.out.println("node info " + nodeInfo);
            vue.controllerJTreeCall(nodeInfo);
        }

    }

}
