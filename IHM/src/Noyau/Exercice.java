/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau;

import java.util.*;
//import Tortue.*;

/**
 *
 * @author Group5
 */
public class Exercice {
    
    //public Canvas canvasTortue;
    public boolean modifiable = true;
    public ArrayList<String> listeCode;
    
    public Exercice (ArrayList<String> Code) {
        //contient : le canvas, la liste de code interpretée pour tracer le canevas. 
        //Il faut recuperer la liste de code, ensuite tracer le canvas.
        listeCode = Code;
        
    }
    
    //lorsque l'enseignant ajoute un nouvel exercice, l'exercice est modifiable
    //quand un eleve fait une tentative, l'exercice n'est plus modifiable
    public void setModifiable(boolean Exmodif) {
        modifiable = Exmodif;
    }
    
    public void ajoutLigneCode(String code) {
        listeCode.add(code);
    }
    
    public String getLigneCode(int numeroL) {
        if (!listeCode.isEmpty()) {
        return listeCode.get(numeroL);
        } else{
            return "";
        }
    }
    
    public boolean getModifiable() {
        return modifiable;
    }
}
