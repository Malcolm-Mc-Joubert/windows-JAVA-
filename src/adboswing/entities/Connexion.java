



/*
 * Connexion.java
 */
package adboswing.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Laurent
 */
public class Connexion {

    private static Connection DbConect;

    /**
     *
     * @param asBD
     * @param asUT
     * @param asMDP
     * @return
     */
    public static Connection seConnecter(String asBD, String asUT, String asMDP) {
        try {
            // --- Facultatif avec JDBC4 et donc JAVA >= 7
            //Class.forName("org.gjt.mm.mysql.Driver");
            DbConect = DriverManager.getConnection("jdbc:mysql://170.26.10.180:3306/" + asBD, asUT, asMDP);
            DbConect.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Erreur connexion : " + e.getMessage());
        }
        return DbConect;
    }

    /**
     *
     * @return
     */
    public static Connection getConnexion() {
        return DbConect;
    }

    /**
     *
     * @return
     */
    public static boolean seDeconnecter() {
        boolean lbOK = false;
        try {
            DbConect.close();
        } catch (SQLException e) {
            System.out.println("Erreur Déconnexion : " + e.getMessage());
        }
        return lbOK;
    }
}




