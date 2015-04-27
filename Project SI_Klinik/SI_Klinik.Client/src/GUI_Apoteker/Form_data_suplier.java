/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import database.Service.Supplier_Service;
import database.entity.Supplier;
import Client_Application_Model.TableModel_Supplier;
import database.entity.Supplier;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author user
 */
public class Form_data_suplier extends javax.swing.JPanel {
    private Supplier_Service ss;
    private GUI_Apoteker gui;
    private TableModel_Supplier tabelSupplier = new TableModel_Supplier();
    Registry registry;
    private Supplier supplier;
    
    /**
     * Creates new form Form_data_suplier
     */
    public Form_data_suplier(GUI_Apoteker gui) throws RemoteException, NotBoundException {
        this.ss = gui.ss;
        this.gui=gui;        
        initComponents(); 
         TOMBOL_UBAH.setEnabled(false);
        tabelSupplier.setData(this.ss.getSupliers());
        tabelSup.setModel(tabelSupplier);
        tabelSup.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged (ListSelectionEvent e){
                int row = tabelSup.getSelectedRow();
                if (row != -1) {
                    TOMBOL_UBAH.setEnabled(true);
                   supplier = tabelSupplier.get(row);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSup = new javax.swing.JTable();
        TOMBOL_UBAH = new javax.swing.JButton();
        TOMBOL_TAMBAH = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(700, 450));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA SUPPLIER"));

        tabelSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID SUPPLIER", "NAMA", "ALAMAT", "KOTA", "TELEPON", "NPWP", "JENIS PAJAK SUPPLIER", "KODE PAJAK SUPPLIER"
            }
        ));
        jScrollPane1.setViewportView(tabelSup);

        TOMBOL_UBAH.setText("UBAH");
        TOMBOL_UBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOMBOL_UBAHActionPerformed(evt);
            }
        });

        TOMBOL_TAMBAH.setText("TAMBAH");
        TOMBOL_TAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOMBOL_TAMBAHActionPerformed(evt);
            }
        });

        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TOMBOL_TAMBAH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TOMBOL_UBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TOMBOL_UBAH)
                            .addComponent(TOMBOL_TAMBAH)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1)))
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TOMBOL_UBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOMBOL_UBAHActionPerformed
                TOMBOL_UBAH.setEnabled(false);
                Form_Data_Supplier_Ubah f= new Form_Data_Supplier_Ubah(gui,supplier);
                f.setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_TOMBOL_UBAHActionPerformed

    private void TOMBOL_TAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOMBOL_TAMBAHActionPerformed
                Form_Data_Supplier_Tambah o1 = new Form_Data_Supplier_Tambah(gui);
                o1.setVisible(true);
                this.setVisible(false);

    }//GEN-LAST:event_TOMBOL_TAMBAHActionPerformed
    public void refresh(){
        try {
            tabelSupplier.setData(this.ss.getSupliers());
            tabelSup.setModel(tabelSupplier);
        } catch (RemoteException ex) {
            Logger.getLogger(Form_data_suplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refresh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TOMBOL_TAMBAH;
    private javax.swing.JButton TOMBOL_UBAH;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelSup;
    // End of variables declaration//GEN-END:variables
}
