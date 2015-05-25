/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;

import GUI_Login.Login;
import database.Service.DetailTransaksiObat_Service;
import database.Service.Detail_Lihat_Resep_Service;
import database.Service.Detail_Resep_Service;
import database.Service.Obat_Service;
import database.Service.Petugas_Service;
import database.Service.Resep_Service;
import database.Service.RekamMedik_Service;
import database.Service.Supplier_Service;
import database.Service.TransaksiObat_Service;
import database.Service.lihat_Resep_Service;
import database.Service.Pemesanan_Obat_Service;
import database.Service.Pendaftaran_Service;
import database.Service.Pasien_Service;
import database.Service.List_PO_Service;
import database.entity.Pasien;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import database.entity.petugas;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

public class GUI_Apoteker extends javax.swing.JFrame {
    petugas p;    
    Pasien pasi;
    Petugas_Service ps;
    Supplier_Service ss;
    Obat_Service os;
    lihat_Resep_Service lrs;
    Detail_Lihat_Resep_Service dlrs;
    Resep_Service rs;
    RekamMedik_Service rm; 
    Detail_Resep_Service drs;
    TransaksiObat_Service tos;
    DetailTransaksiObat_Service dtos;
    Pemesanan_Obat_Service pos;
    List_PO_Service listPO;
    public Pasien_Service pas;
    public Pendaftaran_Service pds;
    
    public GUI_Apoteker (petugas p, Login l){
        super("Apoteker");
        initComponents();
        this.p= p;
        ss = l.service12;
        ps = l.service1;
        lrs = l.service17;
        os = l.service10;
        dlrs = l.service18;
        rs = l.service11;
        tos = l.service19;
        dtos = l.service20;
        pos = l.service22;
        listPO = l.service24;
        drs = l.service8;
        pas = l.service4;
        pds= l.service3;
        rm= l.service15;
        jLabel3.setText(p.getNama_Petugas());
        Panel_Profil_Apoteker panel = new Panel_Profil_Apoteker(this);
        jPanel4.add(panel);
    }
    
    public void setPasien (Pasien pasi){
        this.pasi = pasi;
    } 
    
    public Pasien getPasien(){
        return pasi;
    }
    
     public String getTanggal(){
        Calendar cal = new GregorianCalendar();
            String tanggal ="0";
            if(cal.get(Calendar.DATE)<0){
                tanggal="0"+cal.get(Calendar.DATE);
            }
            else{
                tanggal=""+cal.get(Calendar.DATE);
            }
            String bulan="0";
            if(cal.get(Calendar.MONTH)<10){
                bulan="0"+(cal.get(Calendar.MONTH)+1);;
            }
            else{
                bulan=""+(cal.get(Calendar.MONTH)+1);
            }
            String tahun= ""+cal.get(Calendar.YEAR);
            tanggal = (tahun+"-"+bulan+"-"+tanggal);
            return tanggal;
    }
     
     public String getTanggalView(){
        Calendar cal = new GregorianCalendar();
            String tanggal ="0";
            if(cal.get(Calendar.DATE)<0){
                tanggal="0"+cal.get(Calendar.DATE);
            }
            else{
                tanggal=""+cal.get(Calendar.DATE);
            }
            String bulan="0";
            if(cal.get(Calendar.MONTH)<10){
                bulan="0"+(cal.get(Calendar.MONTH)+1);;
            }
            else{
                bulan=""+(cal.get(Calendar.MONTH)+1);
            }
            String tahun= ""+cal.get(Calendar.YEAR);
            tanggal = (tanggal+"-"+bulan+"-"+tahun);
            return tanggal;
    }
    
    public void updatePanel(JPanel panel){
         jPanel4.removeAll();
         jPanel4.repaint();
         jPanel4.revalidate();                             
         panel.setVisible(true);
         jPanel4.add(panel);
         jPanel4.repaint();
         jPanel4.revalidate();  
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        SUPPLIER = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banner.jpg"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 174, 217));
        jPanel5.setForeground(new java.awt.Color(51, 153, 255));

        jButton9.setText("HOME");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        SUPPLIER.setText("DATA SUPPLIER");
        SUPPLIER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPPLIERActionPerformed(evt);
            }
        });

        jButton11.setText("PEMESANAN OBAT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("DATA OBAT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("PENJUALAN OBAT");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SUPPLIER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SUPPLIER, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 174, 217));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selamat Datang, ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Account", "Log Out" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(109, 109, 109)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(700, 450));
        jPanel4.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 869, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         Panel_Resep panel = new Panel_Resep(this);
         updatePanel(panel);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void SUPPLIERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPPLIERActionPerformed

        try {
            Form_data_suplier panel = new Form_data_suplier(this);
            updatePanel(panel);
        } catch (RemoteException ex) {
            Logger.getLogger(GUI_Apoteker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(GUI_Apoteker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SUPPLIERActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         Panel_Profil_Apoteker panel = new Panel_Profil_Apoteker(this);
         updatePanel(panel);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
          if(jComboBox1.getSelectedIndex()==1){            
            try {
                Login l = new Login();
                l.setVisible(true);
                this.dispose();
            } catch (RemoteException ex) {
                Logger.getLogger(GUI_Apoteker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(GUI_Apoteker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        dataobat_home panel = new dataobat_home(this);
        panel.UpdateTabel();
        updatePanel(panel);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Panel_Generate_PO panel = new Panel_Generate_PO(this);
        try {
            panel.updatetable();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI_Apoteker.class.getName()).log(Level.SEVERE, null, ex);
        }
        updatePanel(panel);
    }//GEN-LAST:event_jButton11ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SUPPLIER;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
