package oracleolap;

import com.sun.xml.internal.ws.util.StringUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abb703
 */
public class MainWindow extends javax.swing.JFrame {

    private Connection connection = null;

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        makeJList();
    }
    // <editor-fold defaultstate="collapsed" desc="Attribute">  

    private void makeJList() {
        DefaultListModel<AttributInfo> listModel = new DefaultListModel<AttributInfo>();
        listModel.addElement(new AttributInfo("Artikelname", "ARTIKEL", "ARTNAME"));
        listModel.addElement(new AttributInfo("Gruppenname", "ARTIKEL", "GRPNAME"));
        listModel.addElement(new AttributInfo("Jahr", "DATUM", "JAHR"));
        listModel.addElement(new AttributInfo("Monat", "DATUM", "MONAT"));
        listModel.addElement(new AttributInfo("Tag", "DATUM", "TAG"));
        listModel.addElement(new AttributInfo("Filiale", "FILIALE", "NAME"));
        listModel.addElement(new AttributInfo("Kunde", "KUNDEN", "NAME"));
        listModel.addElement(new AttributInfo("Verkäufer", "VERKAEUFER", "NAME"));
        listModel.addElement(new AttributInfo("Preis", "BONDATEN", "PREIS"));
        listModel.addElement(new AttributInfo("Anzahl", "BONDATEN", "ANZAHL"));
        jLAttribute.setModel(listModel);
        jLSelected.setModel(new DefaultListModel<AttributInfo>());
    }
    // </editor-fold>

    private void moveElement(JList<AttributInfo> list1, JList<AttributInfo> list2) {
        AttributInfo element = (AttributInfo) list1.getSelectedValue();
        ((DefaultListModel<AttributInfo>) list2.getModel()).addElement(element);
        ((DefaultListModel<AttributInfo>) list1.getModel()).removeElement(element);
    }

    private String makeSelectFields() {
        DefaultListModel<AttributInfo> listModel = (DefaultListModel<AttributInfo>) jLSelected.getModel();
        String fields = "";
        for (int i = 0; i < listModel.getSize(); i++) {
            fields += (!fields.isEmpty() ? ", " : "") + listModel.getElementAt(i).toField();
        }
        return fields;
    }

    private String makeWhereClausel() {
        String where = "";

        return where;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLAttribute = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLSelected = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTErgebnisse = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jCBDatum = new javax.swing.JCheckBox();
        jCBVerkaeufer = new javax.swing.JCheckBox();
        jCBFiliale = new javax.swing.JCheckBox();
        jCoBDatum = new javax.swing.JComboBox();
        jCoBVerkaeufer = new javax.swing.JComboBox();
        jCoBFiliale = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFUrl = new javax.swing.JTextField();
        jTFUser = new javax.swing.JTextField();
        jPFPassword = new javax.swing.JPasswordField();
        jBtnConnect = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLAttribute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAttributeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jLAttribute);

        jLSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLSelectedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jLSelected);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTErgebnisse.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTErgebnisse);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        jCBDatum.setText("Datum");

        jCBVerkaeufer.setText("Verkäufer");

        jCBFiliale.setText("Filiale");

        jCoBDatum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCoBVerkaeufer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCoBFiliale.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBVerkaeufer)
                    .addComponent(jCBDatum)
                    .addComponent(jCBFiliale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCoBFiliale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCoBDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCoBVerkaeufer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBDatum)
                    .addComponent(jCoBDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBVerkaeufer)
                    .addComponent(jCoBVerkaeufer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBFiliale)
                    .addComponent(jCoBFiliale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jLabel1.setText("ODBC Url:");

        jTFUrl.setText("jdbc:oracle:thin:@ora5:1521:inf09");

        jTFUser.setText("abb703");

        jPFPassword.setText("s@$vgn6$3!t6mc7");

        jBtnConnect.setText("Verbinden");
        jBtnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        jBtnRefresh.setText("Aktualisieren");
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTFUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jBtnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnRefresh)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRefresh)
                    .addComponent(jBtnConnect)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
    try {
        // TODO add your handling code here:
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection(jTFUrl.getText(), jTFUser.getText(), new String(jPFPassword.getPassword()));
    } catch (Exception ex) {
        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_connectActionPerformed

private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
// TODO add your handling code here:
    if (connection != null) {
        DefaultTableModel dtm = new DefaultTableModel();
        String sql = makeSql();
        try {
            ResultSet res = connection.createStatement().executeQuery(sql);
            ResultSetMetaData metaData = res.getMetaData();
            int colcnt = metaData.getColumnCount();
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<String> columns = new Vector<String>(colcnt);

            // Spaltennamen (Kopf)
            for (int i = 0; i < colcnt; i++) {
                columns.add(metaData.getColumnName(i + 1));
            }
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<Vector<String>> tbody = new Vector<Vector<String>>();
            for (int i = 0; res.next(); i++) {
                @SuppressWarnings("UseOfObsoleteCollectionType")
                Vector<String> zeile = new Vector<String>(colcnt);
                for (int j = 0; j < colcnt; j++) {
                    zeile.add(res.getString(j + 1));
                }
                tbody.add(zeile);
            }
            dtm.setDataVector(tbody, columns);
            jTErgebnisse.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_jBtnRefreshActionPerformed

private void jLAttributeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAttributeMouseClicked
// TODO add your handling code here:
    moveElement(jLAttribute, jLSelected);
}//GEN-LAST:event_jLAttributeMouseClicked

private void jLSelectedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLSelectedMouseClicked
// TODO add your handling code here:
    moveElement(jLSelected, jLAttribute);
}//GEN-LAST:event_jLSelectedMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnConnect;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JCheckBox jCBDatum;
    private javax.swing.JCheckBox jCBFiliale;
    private javax.swing.JCheckBox jCBVerkaeufer;
    private javax.swing.JComboBox jCoBDatum;
    private javax.swing.JComboBox jCoBFiliale;
    private javax.swing.JComboBox jCoBVerkaeufer;
    private javax.swing.JList jLAttribute;
    private javax.swing.JList jLSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTErgebnisse;
    private javax.swing.JTextField jTFUrl;
    private javax.swing.JTextField jTFUser;
    // End of variables declaration//GEN-END:variables

    private String makeSql() {
        String sql = "SELECT %s"
                + " FROM BONDATEN, ARTIKEL, DATUM, FILIALE, KUNDEN, VERKAEUFER"
                + " WHERE (BONDATEN.ARTIKEL = ARTIKEL.ARTNR AND BONDATEN.DATUM_ID = DATUM.ID AND BONDATEN.FILIALEN_ID = FILIALE.ID AND BONDATEN.KUNDE = KUNDEN.KUNDENNR AND BONDATEN.VERKAEUFER_ID = VERKAEUFER.ID)"
                + " AND %s";
        sql = String.format(sql, makeSelectFields(), " DATUM.ID IN (SELECT ID FROM DATUM WHERE TAG BETWEEN 2 AND 30) AND BONDATEN.FILIALEN_ID = (SELECT ID FROM FILIALE WHERE \"NAME\" = 'A')");
        System.out.println(sql);
        return sql;
    }
}
