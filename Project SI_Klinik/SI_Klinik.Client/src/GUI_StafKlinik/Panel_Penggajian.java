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
import database.Service.Laporan_Keuangan_Service;
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
    Laporan_Keuangan_Service laporanKeuanganService;
    TableModel_Penggajian tabel;
    Penggajian p = new Penggajian();
    Laporan_Keuangan lk = new Laporan_Keuangan();
    List<Penggajian> list;
    List<Penggajian> list1;
    int masuk;
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
        cetakSlipGaji.setEnabled(false);
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
        bayarGaji = new javax.swing.JButton();
        pegawaiList = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPenggajian = new javax.swing.JTable();
        cetakSlipGaji = new javax.swing.JButton();

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

        bayarGaji.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        bayarGaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/detail.jpg"))); // NOI18N
        bayarGaji.setText("Bayar Gaji");
        bayarGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarGajiActionPerformed(evt);
            }
        });

        pegawaiList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[pilih]", "Dokter", "Non Dokter" }));
        pegawaiList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegawaiListActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jLabel5.setText("Jenis Pegawai :");

        tabelPenggajian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pegawai", "Nama Pegawai", "Gaji Pokok", "Gaji Tambahan", "Total Gaji"
            }
        ));
        tabelPenggajian.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelPenggajianComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPenggajian);

        cetakSlipGaji.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        cetakSlipGaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agt_print-32.png"))); // NOI18N
        cetakSlipGaji.setText("Cetak Slip Gaji");
        cetakSlipGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakSlipGajiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(tampilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshButton))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(pegawaiList, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(bayarGaji)
                .addGap(32, 32, 32)
                .addComponent(cetakSlipGaji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tampilButton)
                        .addComponent(refreshButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pegawaiList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bayarGaji)
                    .addComponent(cetakSlipGaji))
                .addGap(23, 23, 23))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPenggajianComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelPenggajianComponentShown
        // TODO add your handling code here:
        //        refresh();
    }//GEN-LAST:event_tabelPenggajianComponentShown

    private void bayarGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarGajiActionPerformed
        // TODO add your handling code here:
        if(!jDateChooser1.getDate().toString().isEmpty()&&!jDateChooser2.getDate().toString().isEmpty()){
            cetakSlipGaji.setEnabled(true);
            Date tanggal3 =(Date) jDateChooser1.getDate();
            tanggal1 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
            tanggal3 =(Date) jDateChooser2.getDate();
            tanggal2 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
            if(pegawaiList.getSelectedItem().equals("Non Dokter")){
                setGajiNonDokter(tanggal1, tanggal2);
            }
            else if (pegawaiList.getSelectedItem().equals("Dokter")){
                setGajiDokter(tanggal1, tanggal2);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Mohon isikan periode", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bayarGajiActionPerformed

    private void tampilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilButtonActionPerformed
        if(jDateChooser1.getDate().toString().isEmpty() && jDateChooser2.getDate().toString().isEmpty() && pegawaiList.getSelectedItem().equals("[pilih]")){
            JOptionPane.showMessageDialog(null, "Mohon isikan periode", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            Date tanggal3 =(Date) jDateChooser1.getDate();
            tanggal1 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
            tanggal3 =(Date) jDateChooser2.getDate();
            tanggal2 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(tanggal3);
            
            if(pegawaiList.getSelectedItem().equals("Non Dokter")){
                gajiNonDokter(tanggal1, tanggal2);
            }
            else if (pegawaiList.getSelectedItem().equals("Dokter")){
                gajiDokter(tanggal1, tanggal2);
            }
        }
    }//GEN-LAST:event_tampilButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:

        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        pegawaiList.setSelectedItem("[pilih]");
        list = new ArrayList<>();
        tabel.setData(list);
        tabelPenggajian.setModel(tabel);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void pegawaiListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegawaiListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pegawaiListActionPerformed

    private void cetakSlipGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakSlipGajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakSlipGajiActionPerformed

    public String tanggalSekarang(){
        Calendar cal = new GregorianCalendar();
        int nilaiTanggal = cal.get(Calendar.DAY_OF_MONTH);
        int nilaiBulan = cal.get(Calendar.MONTH)+1;
        int nilaiTahun = cal.get(Calendar.YEAR);
        String tanggal = ""+nilaiTahun+"-"+nilaiBulan+"-"+nilaiTanggal;
        System.out.println(tanggal);
        
        return tanggal;
    }
    
    public void setGajiNonDokter(String tanggal1, String tanggal2){
        int uangMakan;
        int totalGaji;
        int gajiPokok;
        String id;
        String nama;
        int gajiTambahan;
        String tgl = tanggalSekarang();
        String idTransaksi = "GN"+tgl.replace("-", "");
        int penggajian = 0; // untuk dimasukkan di laporan keuangan
        try {
            list = new ArrayList<>();
            list1 = new ArrayList<>();
            list = penggajianService.getPenggajianNonDokter();
            list1 = penggajianService.getPresensi(tanggal1, tanggal2);
            System.out.println("list : "+list.size());
            System.out.println("list1 : "+list1.size());
            
            for (int i=0; i<list.size(); i++){
                gajiPokok = list.get(i).getGajiPokok();
                nama = list.get(i).getNamaPegawai();
                id = list.get(i).getIdPegawai();
                
                p.setTanggal(tgl);
                System.out.println(tgl);
                p.setNamaPegawai(nama);
                System.out.println(nama);
                p.setIdPegawai(id);
                System.out.println(id);
                p.setGajiPokok(gajiPokok);
                
                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai())) {
                        masuk = list1.get(j).getPresensi();
                        uangMakan = masuk*15000;
                        gajiTambahan = uangMakan;
                        totalGaji = gajiPokok + gajiTambahan;
                        
                        p.setGajiTambahan(gajiTambahan);
                        System.out.println(gajiTambahan);
                        p.setTotalGaji(totalGaji);
                        System.out.println(totalGaji);
                    }
                    else{
                        gajiTambahan = 0;
                        totalGaji = gajiPokok;
                        
                        p.setGajiTambahan(gajiTambahan);
                        p.setTotalGaji(totalGaji);
                        System.out.println(totalGaji);
                    }
                    penggajian = penggajian+totalGaji;
                    System.out.println("penggajian : "+penggajian);
                }
                penggajianService.insertGaji(p);
            }
            lk.setTanggal(tgl);
            System.out.println("tgl lk : "+tgl);
            lk.setId(idTransaksi);
            System.out.println("id tran : "+idTransaksi);
            lk.setPengeluaran(penggajian);
            System.out.println("kluar : "+penggajian);
            laporanKeuanganService.insertPengeluaran(lk);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setGajiDokter(String tanggal1, String tanggal2){
        int uangMakan;
        int tarif;
        int periksa;
        int gajiPeriksa=0;
        int totalGaji = 0;
        int gajiPokok;
        int gajiTambahan=0;
        int penggajian = 0; // untuk dimasukkan di laporan keuangan
        String id;
        String nama;
        String tgl = tanggalSekarang();
        String idTransaksi = "GD"+tgl.replace("-", "");
        
        try {
            list = new ArrayList<>();
            list1 = new ArrayList<>();
            list = penggajianService.getPenggajianDokter();
            list1 = penggajianService.getPresensi(tanggal1, tanggal2);
            List<Penggajian> list2 = new ArrayList<>();
            list2 = penggajianService.getGajiPeriksa(tanggal1, tanggal2);
            System.out.println("list : "+list.size());
            System.out.println("list1 : "+list1.size());
            System.out.println("list2 : "+list2.size());
            
            for (int i=0; i<list.size(); i++){
                gajiPokok = list.get(i).getGajiPokok();
                nama = list.get(i).getNamaPegawai();
                id = list.get(i).getIdPegawai();
                
                p.setTanggal(tgl);
                System.out.println(tgl);
                p.setNamaPegawai(nama);
                System.out.println(nama);
                p.setIdPegawai(id);
                System.out.println(id);
                p.setGajiPokok(gajiPokok);
                
                for (int j = 0; j < list1.size(); j++) {
                    for (int k = 0; k < list2.size(); k++) {
                        System.out.println("id : "+list.get(i).getIdPegawai()+" = "+list1.get(j).getIdPegawai()+" = "+list2.get(k).getIdPegawai());
                        if(list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai()) && list2.get(k).getIdPegawai().equals(list.get(i).getIdPegawai())){
                            masuk = list1.get(j).getPresensi();
                            System.out.println("masuk : "+masuk);
                            uangMakan = masuk*15000;
                            periksa = list2.get(k).getTotalPeriksa();
                            System.out.println("periksa : "+periksa);
                            tarif = list2.get(k).getTarifPeriksa();
                            gajiPeriksa = tarif * periksa;
                            
                            gajiTambahan = gajiPeriksa+uangMakan;
                            totalGaji = gajiPokok+gajiTambahan;
                            
                            p.setGajiTambahan(gajiTambahan);
                            System.out.println(gajiTambahan);
                            p.setTotalGaji(totalGaji);
                            System.out.println(totalGaji);
                        }
                        else if (!list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai()) && list2.get(k).getIdPegawai().equals(list.get(i).getIdPegawai())) {
                            periksa = list2.get(k).getTotalPeriksa();
                            System.out.println("periksa : "+periksa);
                            tarif = list2.get(k).getTarifPeriksa();
                            gajiPeriksa = tarif * periksa;
                            
                            gajiTambahan = gajiPeriksa;
                            totalGaji = gajiPokok + gajiTambahan;
                            
                            p.setGajiTambahan(gajiTambahan);
                            System.out.println(gajiTambahan);
                            p.setTotalGaji(totalGaji);
                            System.out.println(totalGaji);
                        }
                        else if (list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai()) && !list2.get(k).getIdPegawai().equals(list.get(i).getIdPegawai())) {
                            masuk = list1.get(j).getPresensi();
                            System.out.println("masuk : "+masuk);
                            uangMakan = masuk*15000;
                            
                            gajiTambahan = uangMakan;
                            totalGaji = gajiPokok+gajiTambahan;
                            
                            p.setGajiTambahan(gajiTambahan);
                            System.out.println(gajiTambahan);
                            p.setTotalGaji(totalGaji);
                            System.out.println(totalGaji);
                        }
                        else{
                            gajiTambahan = 0;
                            totalGaji = gajiPokok;
                            
                            p.setGajiTambahan(gajiTambahan);
                            System.out.println(gajiTambahan);
                            p.setTotalGaji(totalGaji);
                            System.out.println(totalGaji);
                        }
                        
                        penggajian = penggajian + totalGaji;
                        System.out.println("penggajian : "+penggajian);
                    }
                }
                penggajianService.insertGaji(p);
            }
            lk.setTanggal(tgl);
            System.out.println("tgl lk : "+tgl);
            lk.setId(idTransaksi);
            System.out.println("id tran : "+idTransaksi);
            lk.setPengeluaran(penggajian);
            System.out.println("kluar : "+penggajian);
            laporanKeuanganService.insertPengeluaran(lk);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gajiNonDokter(String tanggal1, String tanggal2){
        int uangMakan;
        int totalGaji;
        int gajiPokok;
        int gajiTambahan;
        
        try {
            list = new ArrayList<>();
            list1 = new ArrayList<>();
            list = penggajianService.getPenggajianNonDokter();
            list1 = penggajianService.getPresensi(tanggal1, tanggal2);
            System.out.println("list : "+list.size());
            System.out.println("list1 : "+list1.size());
            
            for (int i=0; i<list.size(); i++){
                gajiPokok = list.get(i).getGajiPokok();
                for (int j = 0; j < list1.size(); j++) {
                    if (list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai())) {
                        masuk = list1.get(j).getPresensi();
                        uangMakan = masuk*15000;
                        gajiTambahan = uangMakan;
                        totalGaji = gajiPokok + gajiTambahan;
                        list.get(i).setGajiTambahan(gajiTambahan);
                        list.get(i).setTotalGaji(totalGaji);
                    }
                    else{
                        gajiTambahan = 0;
                        totalGaji = gajiPokok;
                        list.get(i).setGajiTambahan(gajiTambahan);
                        list.get(i).setTotalGaji(totalGaji);
                    }
                }
            }
            tabel.setData(list);
            tabelPenggajian.setModel(tabel);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gajiDokter(String tanggal1, String tanggal2){
        int uangMakan;
        int tarif;
        int periksa;
        int gajiPeriksa=0;
        int totalGaji = 0;
        int gajiPokok;
        int gajiTambahan=0;
        
        try {
            list = new ArrayList<>();
            list1 = new ArrayList<>();
            list = penggajianService.getPenggajianDokter();
            list1 = penggajianService.getPresensi(tanggal1, tanggal2);
            List<Penggajian> list2 = new ArrayList<>();
            list2 = penggajianService.getGajiPeriksa(tanggal1, tanggal2);
            System.out.println("list : "+list.size());
            System.out.println("list1 : "+list1.size());
            System.out.println("list2 : "+list2.size());
            
            for (int i=0; i<list.size(); i++){
                gajiPokok = list.get(i).getGajiPokok();
                for (int j = 0; j < list1.size(); j++) {
                    for (int k = 0; k < list2.size(); k++) {
                        System.out.println("id : "+list.get(i).getIdPegawai()+" = "+list1.get(j).getIdPegawai()+" = "+list2.get(k).getIdPegawai());
                        if(list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai()) && list2.get(k).getIdPegawai().equals(list.get(i).getIdPegawai())){
                            masuk = list1.get(j).getPresensi();
                            System.out.println("masuk : "+masuk);
                            uangMakan = masuk*15000;
                            periksa = list2.get(k).getTotalPeriksa();
                            System.out.println("periksa : "+periksa);
                            tarif = list2.get(k).getTarifPeriksa();
                            gajiPeriksa = tarif * periksa;
                            
                            gajiTambahan = gajiPeriksa+uangMakan;
                            totalGaji = gajiPokok+gajiTambahan;
                            list.get(i).setGajiTambahan(gajiTambahan);
                            System.out.println("gajiTambahan1 : "+gajiTambahan);
                            list.get(i).setTotalGaji(totalGaji);
                        }
                        else if (!list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai()) && list2.get(k).getIdPegawai().equals(list.get(i).getIdPegawai())) {
                            periksa = list2.get(k).getTotalPeriksa();
                            System.out.println("periksa : "+periksa);
                            tarif = list2.get(k).getTarifPeriksa();
                            gajiPeriksa = tarif * periksa;
                            
                            gajiTambahan = gajiPeriksa;
                            totalGaji = gajiPokok + gajiTambahan;
                            list.get(i).setGajiTambahan(gajiTambahan);
                            System.out.println("gajiTambahan2 : "+gajiTambahan);
                            list.get(i).setTotalGaji(totalGaji);
                        }
                        else if (list1.get(j).getIdPegawai().equals(list.get(i).getIdPegawai()) && !list2.get(k).getIdPegawai().equals(list.get(i).getIdPegawai())) {
                            masuk = list1.get(j).getPresensi();
                            System.out.println("masuk : "+masuk);
                            uangMakan = masuk*15000;
                            
                            gajiTambahan = uangMakan;
                            totalGaji = gajiPokok+gajiTambahan;
                            list.get(i).setGajiTambahan(gajiTambahan);
                            System.out.println("gajiTambahan3 : "+gajiTambahan);
                            list.get(i).setTotalGaji(totalGaji);
                        }
                        else{
                            gajiTambahan = 0;
                            totalGaji = gajiPokok;
                            list.get(i).setGajiTambahan(gajiTambahan);
                            System.out.println("gajiTambahan4 : "+gajiTambahan);
                            list.get(i).setTotalGaji(totalGaji);
                        }
                    }
                }
            }
            tabel.setData(list);
            tabelPenggajian.setModel(tabel);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createPdf(List<Penggajian> list){
        JFileChooser saveFile = new JFileChooser();
        saveFile.setSelectedFile(new File("D:/document/Slip Gaji.pdf"));        
        String result = null;        
        if (saveFile.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
              result= saveFile.getSelectedFile().toString();
        } else {
            System.out.println("No Selection ");
            }
        try {            
            Document document = new Document();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(result));                
                document.open();
                PdfContentByte canvas = writer.getDirectContent();
                Rectangle rect = new Rectangle (50,800,550,700);
                rect.setBorder(Rectangle.BOX);
                rect.setBorderWidth(0);
                rect.setBorderColor(BaseColor.BLACK);
                canvas.rectangle(rect);
                Paragraph preface;
                preface = getPreface("Slip Gaji");                
                document.add(preface);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(createTableLaporan(list));
                document.close();
                open(result);                
            } catch (DocumentException ex) {
                Logger.getLogger(Panel_Laporan_Keuangan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Panel_Laporan_Keuangan.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    private PdfPTable createTableLaporan(List<Penggajian> list){
        PdfPTable tabel = new PdfPTable(2);   
        PdfPCell cell;

        for(int i=0;i<list.size();i++){ 
            cell = new PdfPCell(new Phrase(("ID Pegawai"), font6));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setColspan(1);
            cell.setBorder(Rectangle.BOX);
            cell.setBorderWidth(1);
            tabel.addCell(cell); 
            
            cell = new PdfPCell(new Phrase((""+list.get(i).getIdPegawai()),font5));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorderWidth(1);
            tabel.addCell(cell);
            
            cell = new PdfPCell(new Phrase(("Nama Pegawai"), font6));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setColspan(1);
            cell.setBorder(Rectangle.BOX);
            cell.setBorderWidth(1);
            tabel.addCell(cell); 
        
            cell = new PdfPCell(new Phrase((""+list.get(i).getNamaPegawai()),font5));
            cell.setVerticalAlignment(Element.ALIGN_TOP); 
            cell.setBorderWidth(1);
            tabel.addCell(cell);
            
            cell = new PdfPCell(new Phrase(("Gaji Pokok"), font6));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setColspan(1);
            cell.setBorder(Rectangle.BOX);
            cell.setBorderWidth(1);
            tabel.addCell(cell); 
        
            cell = new PdfPCell(new Phrase((""+list.get(i).getGajiPokok()),font5));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorderWidth(1);
            tabel.addCell(cell);
            
            cell = new PdfPCell(new Phrase(("Gaji Tambahan"), font6));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setColspan(1);
            cell.setBorder(Rectangle.BOX);
            cell.setBorderWidth(1);
            tabel.addCell(cell); 
            
            cell = new PdfPCell(new Phrase((""+list.get(i).getGajiTambahan()),font5));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorderWidth(1);
            tabel.addCell(cell);
            
            cell = new PdfPCell(new Phrase(("Total Gaji"), font6));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setColspan(1);
            cell.setBorder(Rectangle.BOX);
            cell.setBorderWidth(1);
            tabel.addCell(cell); 
        
            cell = new PdfPCell(new Phrase((""+list.get(i).getTotalGaji()),font5));
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorderWidth(1);
            tabel.addCell(cell);
        }
        return tabel;
    }
    
    private Paragraph getPreface(String status){
        Paragraph preface =new Paragraph();
        Calendar cal = new GregorianCalendar();
        String tanggal ="0";
        if(cal.get(Calendar.DATE)<0){
            tanggal="0"+cal.get(Calendar.DATE);
        }
        else{
            tanggal=""+cal.get(Calendar.DATE);
        }
        int bulan=(cal.get(Calendar.MONTH))+1;;                
        int tahun= cal.get(Calendar.YEAR);
        preface.setAlignment(Element.ALIGN_CENTER);     
        Chunk chunk = new Chunk("Slip Gaji",font1);
        preface.add(Chunk.NEWLINE);
        preface.add(chunk);
        chunk = new Chunk("SI Klinik",font2);
        preface.add(Chunk.NEWLINE);
        preface.add(chunk);
        chunk = new Chunk("Periode : "+tanggal1+" s/d "+tanggal2,font3);
        preface.add(Chunk.NEWLINE);
        preface.add(chunk);
        chunk = new Chunk("Diambil pada tanggal "+tanggal+"/"+bulan+"/"+tahun,font5);
        preface.add(Chunk.NEWLINE);
        preface.add(chunk);
        return preface;
    }
    
    private Paragraph getIsi(List<Penggajian>  list) throws RemoteException{
        Paragraph preface =new Paragraph();       
        preface.setAlignment(Element.ALIGN_LEFT);     
        Chunk chunk = new Chunk("Slip Gaji",font3);
        for(int i = 0; i<list.size();i++){           
            chunk = new Chunk("ID Pegawai : "+list.get(i).getIdPegawai(),font3);
            preface.add(Chunk.NEWLINE);
            preface.add(chunk);
         
            chunk = new Chunk("Nama Pegawai :"+list.get(i).getNamaPegawai(),font3);
            preface.add(Chunk.NEWLINE);
            preface.add(chunk);
            chunk = new Chunk("GAJI :",font3);
            preface.add(Chunk.NEWLINE);
            preface.add(chunk);  
            chunk = new Chunk("Gaji Pokok :"+list.get(i).getGajiPokok(),font3);
            preface.add(Chunk.NEWLINE);
            preface.add(chunk);
            chunk = new Chunk("Gaji Tambahan :"+list.get(i).getGajiTambahan(),font3);
            preface.add(Chunk.NEWLINE);
            preface.add(chunk);
            chunk = new Chunk("Gaji Total :"+list.get(i).getTotalGaji(),font3);
            preface.add(Chunk.NEWLINE);
            preface.add(chunk);
        }
        
        return preface;
    }

     public void open(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File(url));
            } else {
                System.out.println("Open is not supported");
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bayarGaji;
    private javax.swing.JButton cetakSlipGaji;
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
