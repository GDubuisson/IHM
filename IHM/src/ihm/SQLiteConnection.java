/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author popor
 */
public class SQLiteConnection {
    private Connection conn;
    
    public static Connection connect(){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src/ihm/IHM_5.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return(conn);
    } 
    
    public static void main(String[] args) {
        Connection recon = connect();
        Statement stmt = null;
        String sql = "select IdPersonne,Nom,Prenom";
        try{
        stmt = recon.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("IdPersonne");
            String nomP = rs.getString("Nom");
            String prenomP = rs.getString("Prenom");
            System.out.println(id + "\t" + id );
        }
        
        
        
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}