/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;

import GUI_Dokter.GUI_Dokter;
import java.awt.Color;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import database.entity.Supplier;
import database.Service.Supplier_Service;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Form_Data_Supplier_Tambah extends javax.swing.JFrame {
    private Supplier_Service ss;     
    private GUI_Apoteker gui;
    private Form_data_suplier f;
    
    public Form_Data_Supplier_Tambah(GUI_Apoteker gui) {
        initComponents();
        ss = gui.ss;
        this.gui = gui;
    }
    
 private void refresh(){
        NAMA.setText("");
        ALAMAT.setText("");
        KOTA.setText("");
        TELEPON.setText("");
        NPWP.setText("");
        JENISPAJAK.setSelectedIndex(0);
        KODEPAJAK.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NAMA = new javax.swing.JTextField();
        KOTA = new javax.swing.JTextField();
        TELEPON = new javax.swing.JTextField();
        NPWP = new javax.swing.JTextField();
        JENISPAJAK = new javax.swing.JComboBox();
        KODEPAJAK = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        ALAMAT = new java.awt.TextArea();
        BACK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        jLabel1.setText("INPUT DATA SUPPLIER");

        jLabel3.setText("NAMA SUPPLIER ");

        jLabel4.setText("ALAMAT");

        jLabel5.setText("KOTA");

        jLabel6.setText("TELEPON");

        jLabel7.setText("NPWP");

        jLabel8.setText("JENIS PAJAK");

        jLabel9.setText("KODE PAJAK");

        JENISPAJAK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilihan", " " }));

        OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save-32.png"))); // NOI18N
        OK.setText("SIMPAN");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        RESET.setText("RESET");
        RESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESETActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(OK)
                        .addGap(157, 157, 157)
                        .addComponent(RESET))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(NAMA)
                                .addGap(166, 166, 166))
                            .addComponent(ALAMAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JENISPAJAK, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KODEPAJAK, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(NPWP)
                            .addComponent(TELEPON)
                            .addComponent(KOTA))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(KOTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TELEPON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NPWP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(JENISPAJAK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KODEPAJAK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addComponent(OK))
                    .addComponent(RESET))
                .addContainerGap())
        );

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Previous-32.png"))); // NOI18N
        BACK.setText("BACK");
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(101, 101, 101)
                        .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BACK, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        boolean isi1 = false;
        boolean isi2 = false;
        boolean isi3 = false;
        boolean isi4 = false;
        boolean isi5 = false;
        boolean isi6 = false;
        boolean isi7 = false;
        
        
        if(!NAMA.getText().equals("")){
            isi1 = true;
        }
        if(!ALAMAT.getText().equals("")){
            isi2 = true;
        }
        if(!KOTA.getText().equals("")){
            isi3 = true;
        }
        if(!TELEPON.getText().equals("")){
            isi4 = true;
        }
        if(!NPWP.getText().equals("")){
            isi5 = true;
        }
        if(!JENISPAJAK.getItemAt(JENISPAJAK.getSelectedIndex()).toString().equals("")) {
            isi6 = true;
        }
        if(!KODEPAJAK.getText().equals("")){
            isi7 = true;
        }
        if(isi1&&isi2&&isi3&&isi4&&isi5&&isi6&&isi7)    {
            String N = NAMA.getText();
            String A = ALAMAT.getText();
            String K = KOTA.getText();
            String T = TELEPON.getText();
            String NP = NPWP.getText();
            String JP = JENISPAJAK.getItemAt(JENISPAJAK.getSelectedIndex()).toString();
            String KP = KODEPAJAK.getText();
            String ID = null;
            try {
                ID = "SUP"+ss.getSupliers().size();
            } catch (RemoteException ex) {
                Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
               Supplier s= new Supplier();
               s.setId_Supplier(ID);
               s.setNama_Supplier(N);
               s.setAlamat_Supplier(A);
               s.setKota_Supplier(K);
               s.setTelepon_Supplier(T);
               s.setNPWP_Supplier(NP);
               //s.setJenis_pajak_Supplier(JP);
               s.setKode_Pajak_Supplier(KP);
               
               if(ss.insertSupplier(s)!=null){
                    System.out.println("masuk");
                    int opsi = JOptionPane.showConfirmDialog(null, "Data Anda berhasil disimpan. Apakah Anda akan menambahkan data lagi?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(opsi==0){
                        refresh();
                    }
                    else{
                       try {
                           gui.repaintPanel(new Form_data_suplier(this.gui));
                           this.dispose();
                       } catch (NotBoundException ex) {
                           Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
                }
                
            }
            catch(RemoteException exception){
                exception.printStackTrace();
            }
        }
        else{
            if(!isi1){
                NAMA.setBackground(Color.red);
            }
            if(!isi2){
                ALAMAT.setBackground(Color.red);
            }
            if(!isi3){
                KOTA.setBackground(Color.red);
            }

            if(!isi4){
                TELEPON.setBackground(Color.red);
            }
       
            
            if(!isi5){
                NPWP.setBackground(Color.red);
            }
            if(!isi6){
                JENISPAJAK.setBackground(Color.red);
            }

            if(!isi7){
                KODEPAJAK.setBackground(Color.red);
            }
            JOptionPane.showMessageDialog(null, "Ada kesalahan pada kolom isian Anda. Mohon memperbaiki field yang berwarna merah untuk melanjutkan.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OKActionPerformed

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        // TODO add your handling code here:
        refresh();   
    }//GEN-LAST:event_RESETActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        // TODO add your handling code here:
        Form_data_suplier o1;
        try {
            o1 = new Form_data_suplier(gui);
            gui.repaintPanel(o1);
                this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_BACKActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Data_Supplier_Tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea ALAMAT;
    private javax.swing.JButton BACK;
    private javax.swing.JComboBox JENISPAJAK;
    private javax.swing.JTextField KODEPAJAK;
    private javax.swing.JTextField KOTA;
    private javax.swing.JTextField NAMA;
    private javax.swing.JTextField NPWP;
    private javax.swing.JButton OK;
    private javax.swing.JButton RESET;
    private javax.swing.JTextField TELEPON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
