/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;
import Modele.InfoBDD;
import Modele.Personne;
//import Vue.VueTree;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Vue.*;

/**
 * Classe main permettant de lancer l'application
 *
 * @author grp5
 */
public class IHM {

    /**
     * Main permettant de lancer l'application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VueTentativeSansModif Test = new VueTentativeSansModif();
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    //VueTree frame = new VueTree();
//
//                    //frame.createTree();
//                    System.out.println(InfoBDD.getListEleve());
//                   // SQLiteConnection sql = new SQLiteConnection();
//                    //sql.connect();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } 
//            }
//        });
    }
}
