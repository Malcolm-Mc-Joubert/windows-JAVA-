/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adboswing.boudaries;

import adboswing.entities.Connexion;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malcolm
 */
public class InternalRubrique extends javax.swing.JInternalFrame {

    Connection DbConect;
    ResultSet irslt;
    Statement stmt;
    int iiPosition = 1;
    int iiCount;
    String lsSelect = "SELECT * FROM rubrique";
    StringBuilder lsbContenu = new StringBuilder("");

    /**
     * Creates new form InternalRubrique
     *
     * @throws java.sql.SQLException
     */
    public InternalRubrique() throws SQLException {
        initComponents();

        //this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(64, 159, 172));
        // connection a la base de donnée
        DbConect = Connexion.getConnexion();
        try {
//            Class.forName("org.gjt.mm.mysql.Driver");
//            DbConect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/journal2014", "root", "");
//            DbConect.setAutoCommit(false);

            // statement
            stmt = DbConect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // la requette
            irslt = stmt.executeQuery(lsSelect);
            while (irslt.next()) {
                lsbContenu.append(irslt.getString(1));
                lsbContenu.append("\t");
                lsbContenu.append(irslt.getString(2));
                lsbContenu.append("\n");
            }

            stmt.close();

        } catch (Exception e) {
            System.out.println("Erreur connexion : " + e.getMessage());
        }

        //
        remplirTable();
        afficheEnregistrement();
    }

    // un fonction deffini pour affiche les champs, on vas l appeler partour on voudras afficher.
    private void afficheEnregistrement() {
        int liLigne = jTableRubrique.getSelectedRow();
        if (liLigne >= 0) {
            jTextFieldId_Rubrique.setText((String) jTableRubrique.getValueAt(liLigne, 0));
            jTextFieldRubrique.setText(jTableRubrique.getValueAt(liLigne, 1).toString());
        }

    }

    private void remplirTable() {

        try {
            DbConect = Connexion.getConnexion();
            PreparedStatement Prestate = DbConect.prepareStatement("SELECT * FROM rubrique");
            ResultSet rslt = Prestate.executeQuery();

            Object[] tLigne;

            DefaultTableModel dfmodel = (DefaultTableModel) jTableRubrique.getModel();
            //pour vider les champ 
            dfmodel.getDataVector().removeAllElements();

            while (rslt.next()) {
                tLigne = new Object[2];

                tLigne[0] = rslt.getString(1);
                tLigne[1] = rslt.getString(2);

                dfmodel.addRow(tLigne);
            }

        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
            System.out.println("Jusqu a la cava");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelID = new javax.swing.JLabel();
        jTextFieldId_Rubrique = new javax.swing.JTextField();
        jLabelRubrique = new javax.swing.JLabel();
        jTextFieldRubrique = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jButtonActuliser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRubrique = new javax.swing.JTable();
        jButtonClear = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Rubrique");

        jLabelID.setText("ID");

        jLabelRubrique.setText("Rubrique");

        jTextFieldRubrique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRubriqueActionPerformed(evt);
            }
        });

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");

        jLabelMessage.setText("Message");

        jButtonActuliser.setText("Actualiser");

        jLabel1.setText("Comteur");

        jTableRubrique.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_rubrique", "rubrique"
            }
        ));
        jTableRubrique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRubriqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRubrique);

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonSupprimer)
                                .addGap(41, 41, 41)
                                .addComponent(jButtonModifier))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelRubrique)
                                    .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldId_Rubrique, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldRubrique, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelMessage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonActuliser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldId_Rubrique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRubrique)
                    .addComponent(jTextFieldRubrique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonSupprimer)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonActuliser)
                    .addComponent(jButtonClear))
                .addGap(38, 38, 38)
                .addComponent(jLabelMessage)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        // TODO add your handling code here:
        try {
            // pour clear les champs
            DbConect = Connexion.getConnexion();
            PreparedStatement Prestate = DbConect.prepareStatement("INSERT INTO rubrique (rubrique) VALUES(?)");
            Prestate.setString(1, jTextFieldRubrique.getText());

            Prestate.executeUpdate();
            DbConect.commit();
            remplirTable();

        } catch (SQLException ex) {
            Logger.getLogger(NewJInternaStatut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jTextFieldRubriqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRubriqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRubriqueActionPerformed

    private void jTableRubriqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRubriqueMouseClicked

        // TODO add your handling code here:
        afficheEnregistrement();

    }//GEN-LAST:event_jTableRubriqueMouseClicked

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here: 
        jTextFieldRubrique.setText("");

    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // TODO add your handling code here:
        // Suppression dans la JTable et dans la BD
        if (jTableRubrique.getSelectedRow() == -1) {
            jLabelMessage.setText("Veuillez sélectionner une ligne dans la table !!!");
        } else {
            int liAffecte = 0;
            Rubrique rubrique;
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActuliser;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelRubrique;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableRubrique;
    private javax.swing.JTextField jTextFieldId_Rubrique;
    private javax.swing.JTextField jTextFieldRubrique;
    // End of variables declaration//GEN-END:variables

    private static class Rubrique {

        public Rubrique() {
        }
    }
}
