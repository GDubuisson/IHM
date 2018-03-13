/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau;

import java.util.ArrayList;

/**
 * Classe permettant de gérer un établissement contenant des classes, contenant des élèves 
 * @author grp5
 */
public class Etablissement {

    private ArrayList<Classe> listeClasse;
    private String nomEtablissement;

    /**
     * Constructeur de la classe Etablissement 
     * @param nomEtablissement
     */
    public Etablissement(String nomEtablissement) {
        listeClasse = new ArrayList<Classe>();
        this.nomEtablissement = nomEtablissement;
    }

    /**
     * Ajout des classes à un établissement 
     * @param classe
     */
    public void addClasse(Classe classe) {
        listeClasse.add(classe);
    }

    /**
     *Methode qui retourne la liste des classes de l'établissement 
     * @return
     */
    public ArrayList<Classe> getClasses() {
        return listeClasse;
    }

    /**
     *Méthode qui retourne le nom de l'établissement 
     * @return
     */
    public String getNom() {
        return this.nomEtablissement;
    }

}
