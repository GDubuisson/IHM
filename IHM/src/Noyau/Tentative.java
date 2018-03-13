/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau;

import java.util.ArrayList;
/**
 *
 * @author AS
 */
public class Tentative extends Exercice {
    public ArrayList<String> ListeCode;
    public int nbEssai;
    public int score;
    
    public Tentative (ArrayList<String> Code) {
        super(Code);
    }
    
    public int getNbEssai() {
        return nbEssai;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setNbEssai(int Essai ) {
        nbEssai=Essai;
    }
    
    public void setScore(int Scoring ) {
        score=Scoring;
    }
}
