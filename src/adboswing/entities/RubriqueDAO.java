/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adboswing.entities;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.DropMode.INSERT;

/**
 *
 * @author Malcolm
 */
public class RubriqueDAO implements IDAO<Rubrique> {
    
private Connection DbConect;

// constructeur
// insert code
    public RubriqueDAO(Connection DbConect) {
        this.DbConect = DbConect;
    }


    @Override
    public int insert(Rubrique rubrique) {
        int LiAffecte = 0;
        String lsInsert = "INSERT INTO rubrique(rubrique) VALUES (?)";
        PreparedStatement prestmt = null;
        try {
            prestmt = this.DbConect.prepareStatement(lsInsert);
            prestmt.setString(1, rubrique.getRubrique());
            
            prestmt.executeUpdate();
            LiAffecte = 1;
            
            prestmt.setString(LiAffecte, lsInsert);
        } catch (Exception e) { 
            LiAffecte = 1;
        }
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return LiAffecte;
    }
    

    @Override
    public List<Rubrique> selectAll() {
        List<Rubrique> tRubrique = new ArrayList<>();
        String Lselect = "SELECT * FROM rubrique";
        PreparedStatement  prestmt = null;
        ResultSet rslt = null;
        try {
            prestmt = this.DbConect.prepareStatement(Lselect);
            rslt = prestmt.executeQuery();
            
            while (rslt.next()){
                Rubrique newRubrique = new Rubrique();
                newRubrique.setIdRubrique(rslt.getInt(1));
                tRubrique.add(newRubrique);
            }
        } catch (Exception e) {
        }
        
    return tRubrique;
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }// fin 

    @Override
    public Rubrique selectOne(int id) {
        Rubrique newRubrique = new Rubrique();
        String lsselect = "SELECT FROM * rubrique WHERE id=?";
        PreparedStatement prestmt = null;
        ResultSet rslt = null;
        try {
            prestmt = this.DbConect.prepareStatement(lsselect);
            rslt.next();
            newRubrique.setIdRubrique(id);
        } catch (Exception e) {
            return newRubrique;
        }
        
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }// fin selectOne

    @Override
    public int delete(Rubrique objet) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Rubrique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
