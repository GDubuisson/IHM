package controleur;

import Vue.VueTree;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
//import Vue.VueTree;

/**
 * Classe permettant de gérer le JavaTree
 *
 * @author grp5
 */
public class ControleurTree_1 implements TreeSelectionListener {

	private VueTree vue;
	private JTree tree;

	public ControleurTree_1(VueTree vue, JTree tree) {
		this.vue = vue;
		this.tree = tree;
	}
        
        public ControleurTree_1(JTree tree) {
		this.tree = tree;
	}

    @Override
    public void valueChanged(TreeSelectionEvent arg0) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
                .getLastSelectedPathComponent();

        if (node == null) {
            return;
        } else {

            Object nodeInfo = node.getUserObject();
            System.out.println("node info " + nodeInfo.getClass().getName());
            vue.controllerJTreeCall(nodeInfo);
        }

    }

}
