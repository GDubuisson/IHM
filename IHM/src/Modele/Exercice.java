/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static ihm.SQLiteConnection.connect;
import java.sql.*;
import java.util.*;
//import Tortue.*;

/**
 *
 * @author Group5
 */
public class Exercice {
    
    //public Canvas canvasTortue;
    public boolean modifiable = true;
    public Stack<String> listeCode;
    public int Exo;
    
    public Exercice (Stack<String> ListeCode, int exercice) {
        //contient : le canvas, la liste de code interpretée pour tracer le canevas. 
        //Il faut recuperer la liste de code, ensuite tracer le canvas.
        listeCode = ListeCode;
        Exo = exercice;        
    }
    
    //lorsque l'enseignant ajoute un nouvel exercice, l'exercice est modifiable
    //quand un eleve fait une tentative, l'exercice n'est plus modifiable
    public void setModifiable(boolean Exmodif) {
        modifiable = Exmodif;
    }
    
    public void ajoutLigneCode() {
        Connection recon = connect();
        Statement stmt = null;
        for (int i=0;i<listeCode.size();i++) {
            String sql = "";            
            sql += "INSERT INTO Instruction (Ordre,NomInstruction,Modele,IdExercice) VALUES ("+(i+1) + ",";
            sql += "'"+listeCode.elementAt(i) + "',";
            sql += "'TRUE'," + Exo + ");";
            System.out.println(sql);
            try {
                stmt = recon.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public Stack<String> getLigneCode(int exercice) {
        Stack<String> lCode = new Stack();
        Connection connexion = connect();
        Statement stmt = null;
        String req = "SELECT * FROM Instruction WHERE IdExercice="+exercice+" ORDER BY Ordre ASC";
        try {
            stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                lCode.add(rs.getString("NomInstruction"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lCode;
    }
    
    public boolean getModifiable() {
        return modifiable;
    }
}
