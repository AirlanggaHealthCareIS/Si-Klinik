/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_StafKlinik;

import Client_Application_Model.TableModel_Penggajian;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import database.Service.Penggajian_Service;
import database.entity.Laporan_Keuangan;
import database.entity.Penggajian;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 8.1
 */
public class Panel_Penggajian extends javax.swing.JPanel {

    Penggajian_Service penggajianService;
    TableModel_Penggajian tabel;
    Penggajian p = new Penggajian();
    int baris;
    String tanggal1;
    String tanggal2;
    
    private Font font1 = new Font(Font.FontFamily.HELVETICA,14,Font.BOLD);
    private Font font2 = new Font(Font.FontFamily.HELVETICA,18,Font.BOLD);
    private Font font3 = new Font(Font.FontFamily.HELVETICA,11,Font.BOLD);
    private Font font5 = new Font(Font.FontFamily.HELVETICA,11);
    private Font font4 = new Font(Font.FontFamily.HELVETICA,9);
    private Font font6 = new Font(Font.FontFamily.HELVETICA,9,Font.BOLD);
    
    /**
     * Creates new form Panel_Penggajian
     */
    public Panel_Penggajian() {
        initComponents();
    }

     public Panel_Penggajian(GUI_StafKlinik gui) {
        initComponents();
        tabel = new TableModel_Penggajian();
        penggajianService = gui.penggajianServer;
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        tampilButton = new javax.swing.JToggleButton();
        refreshButton = new javax.swing.JToggleButton();
        cetakSlipGajiButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPenggajian = new javax.swing.JTable();
        pegawaiList = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        jLabel15.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jLabel15.setText("Laporan Keuangan");

        setMinimumSize(new java.awt.Dimension(700, 450));

        jLabel16.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jLabel16.setText("Laporan Penggajian");

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jLabel3.setText("Periode :");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setMaxSelectableDate(null);
        jDateChooser1.setMinSelectableDate(null);
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });

        jLabel4.setText("S/D");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setMaxSelectableDate(null);
        jDateChooser2.setMinSelectableDate(null);

        tampilButton.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        tampilButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next-32.png"))); // NOI18N
        tampilButton.setText("Tampilkan");
        tampilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilButtonActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh-32.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        cetakSlipGajiButton.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        cetakSlipGajiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agt_print-32.png"))); // NOI18N
        cetakSlipGajiButton.setText("Cetak Slip Gaji");
        cetakSlipGajiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakSlipGajiButtonActionPerformed(evt);
            }
        });

        tabelPenggajian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "ID  Penggajian", "ID Pegawai", "Nama Pegawai", "Gaji Pokok", "Gaji Tambahan", "Total Gaji"
            }
        ));
        tabelPenggajian.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelPenggajianComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPenggajian);

        pegawaiList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[pilih]", "Dokter", "Non Dokter" }));
        pegawaiList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegawaiListActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jLabel5.setText("Jenis Pegawai :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(cetakSlipGajiButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(pegawaiList, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(tampilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshButton)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pegawaiList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tampilButton)
                                .addComponent(refreshButton))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(cetakSlipGajiButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(191, 191, 191))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPenggajianComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelPenggajianComponentShown
        // TODO add your handling code here:
        //        refresh();
    }//GEN-LAST:event_tabelPenggajianComponentShown

    private void cetakSlipGajiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakSlipGajiButtonActionPerformed
        // TODO add your handling code here:
        if(!jDateChooser1.getDate().toString().isEmpty()&&!jDateChooser2.getDate().toString().isEmpty()){

            Date tanggal3 =(Date) jDateChooser1.getDate();
            tanggal1 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
            tanggal3 =(Date) jDateChooser2.getDate();
            tanggal2 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
//            refresh1(tanggal1, tanggal2);
        }
        else{
            JOptionPane.showMessageDialog(null, "Mohon isikan periode", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetakSlipGajiButtonActionPerformed

    private void tampilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilButtonActionPerformed
        if(jDateChooser1.getDate().toString().isEmpty() && jDateChooser2.getDate().toString().isEmpty() && pegawaiList.getSelectedItem().equals("[pilih]")){
            JOptionPane.showMessageDialog(null, "Mohon isikan periode", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(pegawaiList.getSelectedItem().equals("Non Dokter")){
                Date tanggal3 =(Date) jDateChooser1.getDate();
                tanggal1 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
                tanggal3 =(Date) jDateChooser2.getDate();
                tanggal2 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
                refreshNonDokter(tanggal1, tanggal2);
            }
        }
    }//GEN-LAST:event_tampilButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:

        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        pegawaiList.setSelectedItem("[pilih]");
        List list = new ArrayList<>();
        tabel.setData(list);
        tabelPenggajian.setModel(tabel);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void pegawaiListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegawaiListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pegawaiListActionPerformed

//    private void refreshSemuaPegawai(String tanggal1, String tanggal2){
//        int totalGaji;
//        int gajiPeriksa;
//        int totalPeriksa;
//        int tarifPeriksa;
//        int gajiPokok;
//        
//        List<Penggajian> list = new ArrayList<>();
//        try {
//            list = penggajianService.getPenggajianSemuaPegawai(tanggal1, tanggal2);
//            if (list.size()>0){
//                for(int i=0;i<list.size();i++ ){
//                    if(list.get(i).getIdPegawai().startsWith("PET")){
//                        System.out.println("list PETUGAS");
//                        totalGaji = list.get(i).getGajiPokok();
//                        list.get(i).setGajiTambahan(0);
//                        list.get(i).setTotalGaji(totalGaji);
//                        System.out.println("ID Pegawai : "+list.get(i).getIdPegawai()+"\tGaji Pokok : "+list.get(i).getGajiPokok()+"\tGaji Tambahan : "+0+"\tTotal Gaji : "+totalGaji);
//                    }
//                    else if (list.get(i).getIdPegawai().startsWith("DOK")){
//                        System.out.println("list DOKTER");
//                        totalPeriksa = list.get(i).getTotalPeriksa();
//                        System.out.println("periksa "+totalPeriksa);
//                        tarifPeriksa = list.get(i).getTarifPeriksa();
//                        System.out.println("tarif "+tarifPeriksa);
//                        gajiPeriksa = totalPeriksa * tarifPeriksa;
//                        gajiPokok = list.get(i).getGajiPokok();
//                        totalGaji = gajiPokok + gajiPeriksa;
//                        list.get(i).setGajiTambahan(gajiPeriksa);
//                        list.get(i).setTotalGaji(totalGaji);
//                        System.out.println("ID Pegawai : "+list.get(i).getIdPegawai()+"\tGaji Pokok : "+gajiPokok+"\tGaji Tambahan : "+gajiPeriksa+"\tTotal Gaji : "+totalGaji);
//                    }
//                }
//                tabel.setData(list);
//                tabelPenggajian.setModel(tabel);
//            }
//        } catch (RemoteException ex) {
//            Logger.getLogger(Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
    private void refreshNonDokter(String tanggal1, String tanggal2){
        List<Penggajian> list = new ArrayList<>();
        try {
            list = penggajianService.getPenggajianNonDokter(tanggal1, tanggal2);
            tabel.setData(list);
            tabelPenggajian.setModel(tabel);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetakSlipGajiButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pegawaiList;
    private javax.swing.JToggleButton refreshButton;
    private javax.swing.JTable tabelPenggajian;
    private javax.swing.JToggleButton tampilButton;
    // End of variables declaration//GEN-END:variables
}
