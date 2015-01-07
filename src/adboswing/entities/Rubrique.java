/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adboswing.entities;

/**
 *
 * @author Malcolm
 */
public class Rubrique {
    private int idRubrique;
    private String rubrique;

    public int getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }

    @Override
    public String toString() {
        return "Rubrique{" + "idRubrique=" + idRubrique + ", rubrique=" + rubrique + '}';
    }

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
