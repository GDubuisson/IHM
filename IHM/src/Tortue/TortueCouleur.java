package Tortue;
/**
 * Tortue LOGO capable d'Žcrire en couleur
 * Seules les couleurs suivantes sont autorisŽes :
 *  "black", "red", "blue", "green", "yellow" , "magenta"
 *  Si la couleur demandŽe est diffŽrente, la tortue Žcrit en noir
 *  
 * @author Patrick Girard 
 * @version fŽvrier 2017
 */


public class TortueCouleur extends TortueG {

    // Couleurs
    private static final String lesCouleurs[] = { "black", "red", "blue", "green", "yellow" , "magenta" };
    
    /**
     * Constructeur par dŽfaut, la tortue Žcrit en noir
     *
     */
    public TortueCouleur() {
        super();
    }

    
    /**
     * Constructeur permettant de spŽcifier la couleur
     *
     * @param coul la couleur demandŽe
     */
    public TortueCouleur(String coul) {
        super();
        couleurTrace = rendCouleur(coul);
    }
    
    /**
     * MŽthode setCouleur : change la couleur de la tortue
     *
     * @param coul la couleur demandŽe
     */
    public void setCouleur(String coul){
        couleurTrace = rendCouleur(coul);
    }
    
    /**
     * Accesseur de la couleur
     *
     * @return la couleur de la tortue
     */
    public String getCouleur() {
        return couleurTrace;
    }
    
    /**
     * MŽthode rendCouleur : permet de vŽrifier que la couleur demandŽe est correcte
     * rend "black" sinon
     *
     * @param coul la couleur demandŽe
     * @return la couleur vŽrifiŽe
     */
    private String rendCouleur(String coul) {
        for (int i=0; i<lesCouleurs.length; i++)
            if (coul.equalsIgnoreCase(lesCouleurs[i]))
              return coul.toLowerCase();
        return "black";
    }

}