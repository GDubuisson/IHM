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
 * @author IH5
 */
public class InfoBDD {
    
    private static ArrayList<Personne> listP,enseignantClasse;
    private static ArrayList<Personne> listE;
    private static ArrayList<Classe> listC;
    private static ArrayList<Personne> listEleveClasse;
    /**
    * Création de la liste Tentative (tentatives des exercices)
    */
    public static ArrayList<Personne> getListPersonne () {
        
        listP = new ArrayList<Personne>();
        Connection recon = connect();
        Statement stmt = null;
        String sql = "select IdPersonne, Nom, Prenom, Mdp, Enseignant from Personne";

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idP = rs.getInt("IdPersonne");
                String NomP = rs.getString("Nom");
                String  PrenomP = rs.getString("Prenom"); 
                String Mdp = rs.getString("Mdp");
                boolean Enseignant = rs.getBoolean("Enseignant");
                Personne p = new Personne(idP,NomP,PrenomP,Mdp,Enseignant);
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
       
        String sql = "select IdPersonne, Nom, Prenom, Mdp, Enseignant,NomClasse from Personne,classe where Enseignant=0";
        
        
        
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idP = rs.getInt("IdPersonne");
                String NomP = rs.getString("Nom");
                String  PrenomP = rs.getString("Prenom"); 
                String classeP = rs.getString("NomClasse");
                String Mdp = rs.getString("Mdp");
                boolean Enseignant = rs.getBoolean("Enseignant");
                
                for (Classe classe : getListClasse()){
                    if(classe.getNomClasse().equals(classeP)){
                        Personne p = new Personne(idP,NomP,PrenomP,classe,Mdp,Enseignant);
                        listE.add(p); 
                        System.out.println(p.Info());
                    }
                }
              //  Personne p = new Personne(idP,NomP,PrenomP,Classe,Mdp,Enseignant);
                

                                         
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
        String sql = "select NomClasse from classe";
        
        try{
            stmt = recon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //int idC = rs.getInt("IdClasse");
                String NomC = rs.getString("NomClasse");
                Classe c = new Classe(NomC);
                listC.add(c);          
                System.out.println(c.Info());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listC;
    }
    
    public static ArrayList<Personne> getEnseignantClasse (Classe classe) {
        
        enseignantClasse = new ArrayList<Personne>();
        
        Connection recon = connect();
        Statement stmt = null;   
        String nomClasse = classe.getNomClasse();
        String sql = "select IdPersonne, Nom, Prenom, nomClasse from Personne,classe where Enseignant=1 and nomClasse="+'"'+nomClasse+'"';

        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEnseignant = rs.getInt("IdPersonne");
                String  nomEnseignant = rs.getString("Nom"); 
                String  prenomEnseignant = rs.getString("Prenom");
                
                
               Personne enseignant = new Personne(idEnseignant,nomEnseignant,prenomEnseignant,classe);
               enseignantClasse.add(enseignant);                          
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enseignantClasse;
    } 
    
    public static ArrayList<Personne> getListEleveClasse (Classe classe) {
        
        listEleveClasse = new ArrayList<Personne>();
        
        Connection recon = connect();
        Statement stmt = null;    
        //int idC = classe.getIdClasse();
        String nomC = classe.getNomClasse();
        System.out.println("Nom de la classe : "+nomC);
        String sql = "select IdPersonne, Nom, Prenom, NomClasse from Personne,Classe where Enseignant=0 and NomClasse="+'"'+nomC+'"';
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEleve = rs.getInt("IdPersonne");
                String  nomEleve = rs.getString("Nom"); 
                String  prenomEleve = rs.getString("Prenom");
                
                
               Personne eleve = new Personne(idEleve,nomEleve,prenomEleve,classe);
               listEleveClasse.add(eleve); 
               System.out.println("Nom de la classe"+nomC + listEleveClasse.toString());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listEleveClasse;
    } 
    
}
