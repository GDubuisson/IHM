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
public class ListExo {
    private int idExercice;
    private int idPersonne;
    private int Difficulté;
    private ArrayList<ListExo> listEx;

    public ListExo() {
    }
    
    
    public ListExo(int idExercice,int Difficulté,int idPersonne) {
        this.idExercice = idExercice;
        this.Difficulté =Difficulté;
        this.idPersonne = idPersonne;
    }
    
    

  
   

    /**
     * @return the idExercice
     */
    public int getIdExercice() {
        return idExercice;
    }

    /**
     * @param idExercice the idExercice to set
     */
    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    /**
     * @return the idPersonne
     */
    public int getIdPersonne() {
        return idPersonne;
    }

    /**
     * @param idPersonne the idPersonne to set
     */
    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    /**
     * @return the Difficulté
     */
    public int getDifficulté() {
        return Difficulté;
    }

    /**
     * @param Difficulté the Difficulté to set
     */
    public void setDifficulté(int Difficulté) {
        this.Difficulté = Difficulté;
    }
    
    public String InfoExo(){
        return this.getIdExercice()+" "+this.getDifficulté()+" "+this.getIdPersonne(); 
    }
}
