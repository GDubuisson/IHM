package Modele;

import java.util.ArrayList;

/**
 * Classe qui geres les Classes (promo). Chaque classe contient une liste
 * d'élève, possède un niveau et a un professeur attitré
 */
public class Classe {

    private ArrayList<Personne> listeEleves;
    private String nomClasse;
    private int idClasse;

    /**
     * Constructeur de la classe 
     * @param idClasse
     * @param nomClasse
     */    
      public Classe(String nomClasse) {
          this.nomClasse = nomClasse;
      //  this.idClasse = idClasse;
        //this.listeEleves = new ArrayList<Personne>();
    }
     
    public Classe(String nomClasse, int idClasse){
        this.nomClasse = nomClasse;
        this.idClasse = idClasse;
    }
      
     public Classe(){
     }

    /**
     * Méthode qui permet d'ajouter des élèves à la classe 
     * @param e -> l'élève a ajouter 
     *//*
    public void addEleve(Personne e) {
        this.listeEleves.add(e);
        e.setClasse(this);
    }

    /**
     * Méthode qui ressort le niveau de la classe 
     * @return niveau 
     */
    public String getNomClasse() {
        return this.nomClasse;
    }
    
    public int getIdClasse(){
        return idClasse;
    }
    /**
     * Methode qui donne la liste des élèves présent dans la classe 
     * @return liste d'élève
     */
    public ArrayList<Personne> getEleves() {
        return this.listeEleves;
    }

    /**
     * Méthode qui permet de transformer les allocations mémoires en string 
     * @return
     *//*
    @Override
    public String toString() {
        return this.niveau;
    }

    /**
     * Methode qui donne le nombre d'élèves dans la table 
     * @return
     *//*
    public int getNombreEleves() {
        return this.effectif.size();
    }

    /**
     * Methode qui permet d'accèder au nom du professeur affecté à la classe 
     * @return
     *//*
    public String getProfesseur() {
        return this.professeur;
    }

    /**
     * Methode qui permet de savoir si un élève est dans une classe 
     * @param eleve
     * @return boolean qui dit si l'élève passé en paramètre est dans la classe 
     *//*
    public boolean contains(Eleve eleve) {
        return this.effectif.contains(eleve);
    }

    /**
     * Methode qui retourne l'élève correspondant à un index 
     * @param index
     * @return élève correspondant 
     */
/*    public Personne get(int index) {

        return listeEleves.get(index);
    }

    /**
     *Méthode pour changer le niveau de la classe 
     * @param niveau
     *//*
    public void setNiveau(String niveau) {
        this.niveau = niveau;

    }*/
/*
public String Info(){
        return this.getIdClasse()+" "+this.getNomClasse()+" "; 
    }*/
    public String Info(){
        return this.getNomClasse()+" "; 
    }
}
