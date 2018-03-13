/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Noyau.*;

/**
 * Classe qui permet de créer un modèle contenant un établissement avec des
 * classes et des élèves
 *
 * @author grp5
 */
public class Modele {

    private Etablissement etablissement;

    /**
     * Constructeur du modèle Permet de créer les élèves, les classes et
     * l'établissement du modèle
     */
    public Modele() {

        etablissement = new Etablissement("Gphy");
        Classe classe1 = new Classe("CP", "Annie");
        Classe classe2 = new Classe("GS", "Allan");

        Eleve eleve1 = new Eleve(1, "Adèle", "Richard", true, 6);
        Eleve eleve2 = new Eleve(2, "Guillaume", "Dubuisson", false, 6);
        Eleve eleve3 = new Eleve(3, "Cécile", "Iaegi", true, 6);
        Eleve eleve4 = new Eleve(4, "Pauline", "Robineau", true, 5);
        Eleve eleve5 = new Eleve(5, "Peter", "Pan", false, 5);
        Eleve eleve6 = new Eleve(6, "Tom", "Sawyer", false, 5);

        classe1.addEleve(eleve1);
        classe1.addEleve(eleve2);
        classe1.addEleve(eleve3);
        classe2.addEleve(eleve4);
        classe2.addEleve(eleve5);
        classe2.addEleve(eleve6);

        etablissement.addClasse(classe1);
        etablissement.addClasse(classe2);
    }

    /**
     * Methode qui ressort le nom de l'établissement du modèle
     *
     * @return
     */
    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    /**
     * Methode qui permet de mettre à jour les infos
     *
     * @param o
     * @param o1
     */
    public void updateInfo(Object o, Object o1) {
        if (!o.equals(o1)) {
            System.out.println("differents");
        }
    }
}
