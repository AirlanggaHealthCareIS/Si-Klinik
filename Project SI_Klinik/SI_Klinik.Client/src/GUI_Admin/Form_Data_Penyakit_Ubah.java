/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Admin;

import GUI_Admin.*;
import database.Service.Obat_Service;
import database.Service.Penyakit_Service;
import database.entity.Penyakit;
import database.entity.obat;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Form_Data_Penyakit_Ubah extends javax.swing.JFrame {
    GUI_Admin gui;
    public Penyakit penyakit;
    Penyakit_Service penyakitservice;
    Registry registry;
    /**
     * Creates new form TAMBAH
     */
    public Form_Data_Penyakit_Ubah(GUI_Admin gui, Penyakit s) {
        initComponents();
        penyakitservice = (Penyakit_Service) gui.ss;
        penyakit = s;
        this.gui = gui;
        nama1.setText(penyakit.getId_Penyakit());
        NAMA.setText(penyakit.getNama_Penyakit());
       
    }
    
    
    public Form_Data_Penyakit_Ubah() throws RemoteException, NotBoundException {
        initComponents();
        registry = LocateRegistry.getRegistry("0.0.0.0", 9750);
        penyakitservice = (Penyakit_Service) registry.lookup("service16");
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
        NAMA = new javax.swing.JTextField();
        CANCEL = new javax.swing.JButton();
        OK = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nama1 = new javax.swing.JTextField();
        BACK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        jLabel1.setText("UPDATE DATA PENYAKIT");

        jLabel3.setText("NAMA SUPPLIER ");

        CANCEL.setText("CANCEL");
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });

        OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save-32.png"))); // NOI18N
        OK.setText("SIMPAN");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jLabel10.setText("ID SUPPLIER ");

        nama1.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 217, Short.MAX_VALUE)
                        .addComponent(OK)
                        .addGap(193, 193, 193)
                        .addComponent(CANCEL))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nama1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NAMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                        .addGap(0, 193, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(322, 322, 322)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CANCEL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(107, 107, 107)
                .addComponent(BACK, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BACK)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        Form_data_penyakit o1;
        try {
            o1 = new Form_data_penyakit(gui);
            gui.updatePanel(o1);
                this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Data_Penyakit_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Form_Data_Penyakit_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CANCELActionPerformed

    public void setNama (String a){
        NAMA.setText(a);
    }
    
    
     public boolean cekNamaPenyakitSudahAda(){
        boolean ada = false;
        try {
            List<Penyakit> list = penyakitservice.getPenyakitAll();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getNama_Penyakit().equalsIgnoreCase(NAMA.getText())){
                    ada = true;
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Data_Penyakit_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ada;
    }
    
    public boolean UbahPenyakit(){
        boolean isi1 = false;
        boolean sukses = false;
        if(!NAMA.getText().equals("")){
            isi1 = true;
            System.out.println("isi1");
        }
        boolean nama = false;
        if(!penyakit.getNama_Penyakit().equals(NAMA.getText())){ 
            nama = cekNamaPenyakitSudahAda();
            System.out.println(NAMA.getText());
        }
        if(!nama&&isi1)    {
            String N = NAMA.getText();
               penyakit.setNama_Penyakit(N);
              
               try {                    
                    penyakitservice.updatePenyakit(penyakit);
                    sukses = true;
                    JOptionPane.showConfirmDialog(null, "Data Anda berhasil disimpan. Apakah Anda ingin mengubah data lagi?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(gui!=null){
                    gui.updatePanel(new Form_data_penyakit (gui));
                    this.dispose();}
                } catch (NotBoundException ex) {
                    Logger.getLogger(Form_Data_Penyakit_Ubah.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(RemoteException exception){
                    exception.printStackTrace();
                }       
        }
        else{
            if(!isi1){
                NAMA.setBackground(Color.red);
            }
            JOptionPane.showMessageDialog(null, "Ada kesalahan pada kolom isian Anda. Mohon memperbaiki field yang berwarna merah untuk melanjutkan.", "ERROR", JOptionPane.ERROR_MESSAGE);
    
        }
        return sukses;
    }
    
    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_OKActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        // TODO add your handling code here:
        Form_data_penyakit o1;
        try {
            o1 = new Form_data_penyakit(gui);
            gui.updatePanel(o1);
                this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Data_Penyakit_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Form_Data_Penyakit_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_BACKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JButton CANCEL;
    private javax.swing.JTextField NAMA;
    private javax.swing.JButton OK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nama1;
    // End of variables declaration//GEN-END:variables
}
