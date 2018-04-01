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

/**
 *
 * @author popor
 */
public class InfoBDD {
    
    private static ArrayList<Personne> listP,enseignantClasse;
    private static ArrayList<Personne> listE;
    private static ArrayList<Classe> listC;
    private static ArrayList<Personne> listEleveClasse;
    private static ArrayList<ListExo> ListEx;
    /**
    * Création de la liste Tentative (tentatives des exercices)
    */
    public static ArrayList<Personne> getListPersonne () {
        
        listP = new ArrayList<Personne>();
        Connection recon = connect();
        Statement stmt = null;
        String sql = "select IdPersonne, Nom, Prenom, IdClasse, Mdp, Enseignant from Personne";

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idP = rs.getInt("IdPersonne");
                String NomP = rs.getString("Nom");
                String  PrenomP = rs.getString("Prenom"); 
                int Classe = rs.getInt("IdClasse");
                String Mdp = rs.getString("Mdp");
                boolean Enseignant = rs.getBoolean("Enseignant");

                Personne p = new Personne(idP,NomP,PrenomP,Classe,Mdp,Enseignant);
                System.out.println(p.Info());

                listP.add(p);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listP;
    }
    
    public static ArrayList<Personne> getListEleve () {
        
        listP = new ArrayList<Personne>();

        Connection recon = connect();
        Statement stmt = null;
       
        String sql = "select IdPersonne, Nom, Prenom, IdClasse, Mdp, Enseignant from Personne where Enseignant=0";
        
        
        
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idP = rs.getInt("IdPersonne");
                String NomP = rs.getString("Nom");
                String  PrenomP = rs.getString("Prenom"); 
                int Classe = rs.getInt("IdClasse");
                String Mdp = rs.getString("Mdp");
                boolean Enseignant = rs.getBoolean("Enseignant");

                Personne p = new Personne(idP,NomP,PrenomP,Classe,Mdp,Enseignant);
                System.out.println(p.Info());

                listE.add(p);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listE;
    }
    
    public static ArrayList<Classe> getListClasse () {
        
        listC = new ArrayList<Classe>();

        Connection recon = connect();
        Statement stmt = null;        
        String sql = "select IdClasse, NomClasse from classe";
        
        try{
            stmt = recon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idC = rs.getInt("IdClasse");
                String NomC = rs.getString("NomClasse");
                Classe c = new Classe(idC,NomC);
                listC.add(c);          
                System.out.println(c.Info());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listC;
    }
    
    public static ArrayList<Personne> getEnseignantClasse (int idClasse) {
        
        enseignantClasse = new ArrayList<Personne>();
        
        Connection recon = connect();
        Statement stmt = null;            
        String sql = "select IdPersonne, Nom, Prenom, IdClasse from Personne where Enseignant=1 and IdClasse="+'"'+idClasse+'"';

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEnseignant = rs.getInt("IdPersonne");
                String  nomEnseignant = rs.getString("Nom"); 
                String  prenomEnseignant = rs.getString("Prenom");
                
                
               Personne enseignant = new Personne(idEnseignant,nomEnseignant,nomEnseignant,idClasse);
               enseignantClasse.add(enseignant);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enseignantClasse;
    } 
    
    public static ArrayList<Personne> getListEleveClasse (int idClasse) {
        
        listEleveClasse = new ArrayList<Personne>();
        
        Connection recon = connect();
        Statement stmt = null;            
        String sql = "select IdPersonne, Nom, Prenom, IdClasse from Personne where Enseignant=0 and IdClasse="+'"'+idClasse+'"';

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEleve = rs.getInt("IdPersonne");
                String  nomEleve = rs.getString("Nom"); 
                String  prenomEleve = rs.getString("Prenom");
                
                
               Personne enseignant = new Personne(idEleve,nomEleve,prenomEleve,idClasse);
               listEleveClasse.add(enseignant);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEleveClasse;
    } 
    
        public static ArrayList<ListExo> getListExercice () {
        
        ListEx = new ArrayList<ListExo>();
        Connection recon = connect();
        Statement stmt = null;
        String sql = "select IdExercice, Difficulté, IdPersonne from Exercice";

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEx = rs.getInt("IdExercice");
                int Dif = rs.getInt("Difficulté");
                int idP = rs.getInt("IdPersonne");
                
              
                ListExo ex = new ListExo (idEx, Dif, idP);
                System.out.println(ex.InfoExo());

                ListEx.add(ex);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ListEx;
    }
    
    
    
}
