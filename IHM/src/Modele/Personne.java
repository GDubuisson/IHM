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
    private String Classe;
    private String Mdp;
    private boolean Enseignant;
    
    private ArrayList<Personne> listP;

    public Personne() {
    }
    
    
    public Personne(int idPersonne, String Nom, String Prenom, String Classe, String Mdp, boolean Enseignant) {
        this.idPersonne = idPersonne;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Classe = Classe;
        this.Mdp = Mdp;
        this.Enseignant = Enseignant;
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

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String Classe) {
        this.Classe = Classe;
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
        return this.getIdPersonne()+" "+this.getPrenom()+" "+this.getNom()+" "+this.getClasse()+ " enseignant : "+this.isEnseignant(); 
    }
}
