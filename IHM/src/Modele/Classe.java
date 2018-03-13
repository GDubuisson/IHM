package Modele;

import java.util.ArrayList;

/**
 * Classe qui geres les Classes (promo). Chaque classe contient une liste
 * d'élève, possède un niveau et a un professeur attitré
 */
public class Classe {

    private ArrayList<Eleve> effectif;
    private String niveau;
    private String professeur;

    /**
     * Constructeur de la classe 
     * @param niveau
     * @param professeur : nom du professeur attitré 
     */
    public Classe(String niveau, String professeur) {

        this.niveau = niveau;
        this.professeur = professeur;
        this.effectif = new ArrayList<Eleve>();
    }

    /**
     * Méthode qui permet d'ajouter des élèves à la classe 
     * @param e -> l'élève a ajouter 
     */
    public void addEleve(Eleve e) {
        this.effectif.add(e);
        e.setClasse(this);
    }

    /**
     * Méthode qui ressort le niveau de la classe 
     * @return niveau 
     */
    public Object getNiveau() {
        return this.niveau;
    }

    /**
     * Methode qui donne la liste des élèves présent dans la classe 
     * @return liste d'élève
     */
    public ArrayList<Eleve> getEleves() {
        return this.effectif;
    }

    /**
     * Méthode qui permet de transformer les allocations mémoires en string 
     * @return
     */
    @Override
    public String toString() {
        return this.niveau;
    }

    /**
     * Methode qui donne le nombre d'élèves dans la table 
     * @return
     */
    public int getNombreEleves() {
        return this.effectif.size();
    }

    /**
     * Methode qui permet d'accèder au nom du professeur affecté à la classe 
     * @return
     */
    public String getProfesseur() {
        return this.professeur;
    }

    /**
     * Methode qui permet de savoir si un élève est dans une classe 
     * @param eleve
     * @return boolean qui dit si l'élève passé en paramètre est dans la classe 
     */
    public boolean contains(Eleve eleve) {
        return this.effectif.contains(eleve);
    }

    /**
     * Methode qui retourne l'élève correspondant à un index 
     * @param index
     * @return élève correspondant 
     */
    public Eleve get(int index) {

        return effectif.get(index);
    }

    /**
     * Methode qui permet de changer le professeur associé à une classe 
     * @param professeur -> nom du nouveau professeur de la classe 
     */
    public void setProf(String professeur) {
        this.professeur = professeur;
    }

    /**
     *Méthode pour changer le niveau de la classe 
     * @param niveau
     */
    public void setNiveau(String niveau) {
        this.niveau = niveau;

    }

}
