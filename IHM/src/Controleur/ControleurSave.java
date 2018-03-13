package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Vue.VueTree;

/**
 * @author Gr5
 *
 */
public class ControleurSave implements ActionListener {

    private VueTree vue;

	/**
	 * Constructeur de la classe ControleurSave
	 * 
	 * @param vue
	 * 
	 */
	public ControleurSave(VueTree vue) {
		this.vue = vue;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vue.getCurrentEleve() != null) {
            int age = Integer.parseInt(vue.getTxtAge().getText());

            if ("F".equals(vue.getTxtSexe().getText())) {
                vue.getCurrentEleve().setSexe(true);
            } else {
                vue.getCurrentEleve().setSexe(false);
            }

            vue.getCurrentClasse().setNiveau(vue.getTxtNiveau().getText());
            vue.getCurrentClasse().setProf(vue.getTxtProf().getText());
            vue.getCurrentEleve().setNom(vue.getTxtNom().getText());
            vue.getCurrentEleve().setPrenom(vue.getTxtPrenom().getText());
            vue.getCurrentEleve().setAge(age);

            JOptionPane.showMessageDialog(vue,
                    "Les modifications sont enregistrées",
                    "Les modifications sont enregistrées", JOptionPane.INFORMATION_MESSAGE);
        } 
        else {
            vue.getCurrentClasse().setProf(vue.getTxtProf().getText());
            JOptionPane.showMessageDialog(vue,
                    "Les modifications sont enregistrées",
                    "Les modifications sont enregistrées", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
