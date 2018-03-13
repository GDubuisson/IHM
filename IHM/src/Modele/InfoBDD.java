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
    
    private static ArrayList<Personne> listP;
    /**
    * Création de la liste Tentative (tentatives des exercices)
    */
    public static ArrayList<Personne> getListPersonne () {
        
        listP = new ArrayList<Personne>();

        Connection recon = connect();
        Statement stmt = null;
        
        
        String sql = "select IdPersonne, Nom, Prenom, Classe, Mdp, Enseignant from Personne";
        
        
        try{
            stmt = recon.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idP = rs.getInt("IdPersonne");
                String NomP = rs.getString("Nom");
                String  PrenomP = rs.getString("Prenom"); 
                String Classe = rs.getString("Classe");
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
    
    
}
