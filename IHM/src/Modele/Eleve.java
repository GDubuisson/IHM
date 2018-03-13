/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 * Classe élève qui permet de gérer un élève 
 * @author Grp_5
 */
public class Eleve {

    private Integer id;
    private String prenom;
    private String nom;
    private Boolean sexe;
    private Integer age;
    private Classe classe;

    /**
     * Constructeur de la classe élève 
     * @param id
     * @param prenom
     * @param nom
     * @param sexe
     * @param age
     */
    public Eleve(Integer id, String prenom, String nom, Boolean sexe, Integer age) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    /**
     * Accesseur au prenom de l'élève 
     * @return
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Accesseur au sexe de l'élève 
     * @return
     */
    public String getSexe() {
        if (this.sexe) {
            return "F";

        } else {
            return "M";
        }

    }

    /**
     * Accesseur pour l'âge de l'élève 
     * @return
     */
    public String getAge() {
        return (this.age).toString();
    }

    /**
     * Accesseur au nom de l'élève 
     * @return
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * acceseur à la classe auquel appartient l'élève 
     * @return
     */
    public Classe getClasse() {
        return classe;
    }

    /**
     * Modifier pour la classe à laquelle appartient l'élève 
     * @param classe
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    /**
     * Accesseur à l'ID de l'élève 
     * @return
     */
    public Object getID() {
        return this.id;
    }

    /**
     * Modifier pour le nom de l'élève 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifier pour le prénom de l'élève 
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Modifier pour le sexe de l'élève 
     * @param sexe
     */
    public void setSexe(Boolean sexe) {
        this.sexe = sexe;
    }

    /**
     * Modifier de l'âge de l'élève 
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.prenom + " " + this.nom;
    }

}
