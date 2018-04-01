/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static ihm.SQLiteConnection.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author popor
 */
public class Personne {
    private int idPersonne; 
    private String Nom;
    private String Prenom;
    private String Mdp;
    private boolean Enseignant;
    private Classe classe;
    
    private ArrayList<Personne> listP;

    public Personne() {
    }
    
    
    public Personne(int idPersonne, String Nom, String Prenom, Classe Classe, String Mdp, boolean Enseignant) {
        this.idPersonne = idPersonne;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.classe = Classe;
        this.Mdp = Mdp;
        this.Enseignant = Enseignant;
    }
    
    public Personne(int idPersonne, String Nom, String Prenom) {
        this.idPersonne = idPersonne;
        this.Nom = Nom;
        this.Prenom = Prenom;
        //this.classe = Classe;
    }
    
    public Personne(int idPersonne, String nom, String prenom, String mdp, boolean ens) {
        this.idPersonne = idPersonne;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Mdp = mdp;
        this.Enseignant = ens;
        //this.classe = Classe;
    }
    
    public Personne(int idPersonne, String Nom, String Prenom, Classe classe) {
        this.idPersonne = idPersonne;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.classe = classe; 
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Classe getNomClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public boolean isEnseignant() {
        return Enseignant;
    }

    public void setEnseignant(boolean Enseignant) {
        this.Enseignant = Enseignant;
    }  
    
    public String Info(){
        return this.getIdPersonne()+" "+this.getPrenom()+" "+this.getNom()+" "+this.getNomClasse()+ " enseignant : "+this.isEnseignant(); 
    }
}
