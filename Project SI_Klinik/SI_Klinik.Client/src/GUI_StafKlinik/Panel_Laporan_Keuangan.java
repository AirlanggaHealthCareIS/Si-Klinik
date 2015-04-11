/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_StafKlinik;

import GUI_StafKlinik.*;
import Client_Application_Model.TableModel_LaporanKeuangan;
import database.entity.Laporan_Keuangan;
import database.Service.Laporan_Keuangan_Service;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Windows 8.1
 */
public class Panel_Laporan_Keuangan extends javax.swing.JPanel {

    /**
     * Creates new form FormLaporanKeuangan
     */
    private TableModel_LaporanKeuangan tableModelLaporanKeuangan = new TableModel_LaporanKeuangan();
    private Laporan_Keuangan_Service laporanKeuanganService;
    String periode;
    
    public Panel_Laporan_Keuangan() {
        initComponents();
    }
    
    public Panel_Laporan_Keuangan(Laporan_Keuangan_Service laporanKeuanganService) throws RemoteException, NotBoundException {

        this.laporanKeuanganService = laporanKeuanganService;
        
        try{
            tableModelLaporanKeuangan.setLaporan_Keuangan(this.laporanKeuanganService.getLaporanKeuangan());
        }
        catch(RemoteException exception){
            exception.printStackTrace();
        }
        initComponents();

        tabelLaporanKeuangan.setModel(tableModelLaporanKeuangan);
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelLaporanKeuangan = new javax.swing.JTable();
        tampilButton = new javax.swing.JToggleButton();
        cetakLaporanButton = new javax.swing.JButton();
        bulanChooser = new com.toedter.calendar.JMonthChooser();
        tahunChooser = new com.toedter.calendar.JYearChooser();

        setMinimumSize(new java.awt.Dimension(700, 450));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jLabel3.setText("Periode :");

        tabelLaporanKeuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Keterangan", "Ref", "Pemasukan", "Pengeluaran", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tabelLaporanKeuangan);

        tampilButton.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        tampilButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next-32.png"))); // NOI18N
        tampilButton.setText("Tampilkan");
        tampilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilButtonActionPerformed(evt);
            }
        });

        cetakLaporanButton.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        cetakLaporanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agt_print-32.png"))); // NOI18N
        cetakLaporanButton.setText("Cetak Dokumen");
        cetakLaporanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakLaporanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bulanChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tahunChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tampilButton)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cetakLaporanButton)
                .addGap(252, 252, 252))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addContainerGap(634, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tampilButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bulanChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tahunChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(cetakLaporanButton)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jLabel3)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tampilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilButtonActionPerformed
         // TODO add your handling code here:
        
                String bulan = "" + (bulanChooser.getMonth()+1);
                System.out.println("bulan : "+bulan);
                String tahun = "" + (tahunChooser.getYear());
                System.out.println("tahun : "+tahun);
        
                int bln = bulanChooser.getMonth()+1;
                if (bln/10 != 1){
                        periode = tahun+"-0"+bulan;
                        System.out.println("periode : "+periode);
                    }
                else {
                        periode = tahun+"-"+bulan;
                        System.out.println("periode : "+periode);
                    }
        
                try{
                    Laporan_Keuangan laporan_keuangan = new Laporan_Keuangan();
                    laporan_keuangan.setPeriode(periode);
                    Laporan_Keuangan laporan_keuangan1 = laporanKeuanganService.getLaporanKeuangan(periode);
                }catch(RemoteException exception){
                    exception.printStackTrace();
                }
                
                try{
                    List<Laporan_Keuangan> list = laporanKeuanganService.getLaporanKeuangan();
                    tableModelLaporanKeuangan.setLaporan_Keuangan(list);
                }catch(RemoteException exception){
                    exception.printStackTrace();
                }
    }//GEN-LAST:event_tampilButtonActionPerformed

    private void cetakLaporanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakLaporanButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakLaporanButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser bulanChooser;
    private javax.swing.JButton cetakLaporanButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelLaporanKeuangan;
    private com.toedter.calendar.JYearChooser tahunChooser;
    private javax.swing.JToggleButton tampilButton;
    // End of variables declaration//GEN-END:variables
}
