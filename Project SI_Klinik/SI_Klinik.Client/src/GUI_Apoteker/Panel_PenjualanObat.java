/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;

import Client_Application_Model.TableModel_Lihat_Resep;
import Client_Application_Model.TableModel_Penjualan;
import database.Service.DetailTransaksiObat_Service;
import database.entity.detail_lihat_resep;
import database.entity.detail_resep_obat;
import database.Service.Detail_Lihat_Resep_Service;
import database.Service.Detail_Resep_Service;
import database.Service.Obat_Service;
import database.Service.TransaksiObat_Service;
import database.entity.Penjualan;
import database.entity.Transaksi_Obat;
import database.entity.detail_transaksi_obat;
import database.entity.obat;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Panel_PenjualanObat extends javax.swing.JPanel {
    private TableModel_Penjualan tabel = new TableModel_Penjualan();
    private GUI_Apoteker gui;
    private TransaksiObat_Service tos;
    private DetailTransaksiObat_Service dtos;        
    private Obat_Service obs;
    private List<Penjualan> listPenjualan= new ArrayList<>();    
    private Penjualan p;
    String action;
    int row;
    /**
     * Creates new form Panel_DetailResep
     */
    public Panel_PenjualanObat(GUI_Apoteker gui){
        obs = gui.os;
        tos = gui.tos;
        dtos = gui.dtos;
        initComponents();
        this.gui = gui;  
        action = "";
        edit.setEnabled(false);        
        delete.setEnabled(false);
        tabel.setData(listPenjualan);
        tabel_detail.setModel(tabel);        
        tanggal.setText(gui.getTanggalView());       
        jLabel7.setText("0");
        jLabel2.setText("0");
        jLabel9.setText("0");
         tabel_detail.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                row = tabel_detail.getSelectedRow();
                if (row !=-1&&(!action.equals("insert")||(!action.equals("")))){
                    edit.setEnabled(true);
                    delete.setEnabled(true);
                    p = tabel.get(row);
                }
            }
        });
    }
    
    public Panel_PenjualanObat(List<detail_lihat_resep> list, GUI_Apoteker gui){    
        obs = gui.os;
        tos = gui.tos;
        dtos = gui.dtos;
        initComponents();
        this.gui = gui;       
        cekMemenuhiTidak(list);
        action = "";
        edit.setEnabled(false);
        delete.setEnabled(false);
        tabel.setData(listPenjualan);
        tabel_detail.setModel(tabel);        
        tanggal.setText(gui.getTanggalView());       
        GetJumlah();
         tabel_detail.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                row = tabel_detail.getSelectedRow();
                if (row !=-1&&(!action.equals("insert")||(!action.equals("")))){
                    edit.setEnabled(true);
                    delete.setEnabled(true);
                    p = tabel.get(row);
                }
            }
        });
    }
    
    public boolean cekMemenuhiTidak(List<detail_lihat_resep> list){
        boolean memenuhi = true;
        for (int i = 0; i < list.size(); i++) {
            try {
                Penjualan p = new Penjualan();
                p.setId_Obat(list.get(i).getIdObat());
                p.setNama_Obat(list.get(i).getObat());
                obat o =obs.getObat(list.get(i).getIdObat());
                int harga = o.getharga_obat(); 
                p.setHarga(harga);                
                int q = list.get(i).getQty();
                p.setQty(q);
                p.setTotal(harga*q);
                p.setStok(o.getstok_obat());
                if(p.getStok()>=q){
                    p.setKeterangan("Memenuhi");                    
                }
                else{
                    p.setKeterangan("Tidak Memenuhi, jumlah stok="+p.getStok());
                    JOptionPane.showMessageDialog(null, "Ada barang yang tidak memenuhi stok","ERROR",JOptionPane.ERROR_MESSAGE);
                    jButton1.setVisible(false);
                    memenuhi = false;
                }
                listPenjualan.add(p);
            } catch (RemoteException ex) {
                Logger.getLogger(Panel_PenjualanObat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return memenuhi;
    }

    public void updateTabel(){
        tabel.setData(listPenjualan);
        tabel_detail.setModel(tabel); 
        boolean memenuhi = true;        
        for (int i = 0; i < listPenjualan.size(); i++) {
            if(listPenjualan.get(i).getQty()>listPenjualan.get(i).getStok()){
                memenuhi = false;
            }
        }
        if(memenuhi){
            jButton1.setVisible(true);
        }
        GetJumlah();
    }
    
    private void GetJumlah(){
        int jumlah = 0;
        for (int i = 0; i < listPenjualan.size(); i++) {
            jumlah = listPenjualan.get(i).getTotal()+jumlah;            
        }
        jLabel7.setText(""+jumlah);
        jLabel9.setText(""+(jumlah/10));
        jLabel2.setText(""+(jumlah*110/100));
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
        jLabel33 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_detail = new javax.swing.JTable();
        add = new javax.swing.JButton();
        tanggal = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1170, 570));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel33.setText("Tanggal                   :");

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 11)); // NOI18N
        jLabel6.setText("Daftar Obat");

        tabel_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabel_detail);

        add.setText("TAMBAH");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        tanggal.setText("tgl");

        delete.setText("HAPUS");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        edit.setText("UBAH");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel4.setText("Penjualan ");

        jLabel7.setText("jumlah");

        jLabel3.setText("Subtotal Transaksi       :");

        jLabel2.setText("jumlah");

        jLabel9.setText("jumlah");

        jLabel1.setText("TOTAL TRANSAKSI      :");

        jLabel8.setText("Pajak                            : ");

        jButton1.setText("SIMPAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(719, 719, 719))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        Form_Penjualan_Tambah f = new Form_Penjualan_Tambah(listPenjualan, gui,this);
        f.setVisible(true);
        this.gui.setVisible(false);
        edit.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        edit.setEnabled(false);
        delete.setEnabled(false);
        listPenjualan.remove(row);
        updateTabel();
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        Form_Penjualan_Ubah f = new Form_Penjualan_Ubah(listPenjualan, gui,this, row, p);
        f.setVisible(true);
        this.gui.setVisible(false);
        edit.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_editActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Transaksi_Obat to = new Transaksi_Obat();
        int id;
        try {            
            to.setTanggal_Jual(gui.getTanggal());
            to.setSubtotal_Transaksi_Obat(Integer.parseInt(jLabel7.getText()));
            to.setPPN_Transaksi_Obat(Integer.parseInt(jLabel9.getText()));
            to.setTotal_Transaksi_Obat(Integer.parseInt(jLabel2.getText()));            
            tos.insertTO(to);
            id = Integer.parseInt(tos.getLastTO().getId_Transaksi_Obat());
            for (int i = 0; i < listPenjualan.size(); i++) {
                detail_transaksi_obat dto = new detail_transaksi_obat();
                dto.setid_transaksi_obat(""+id);
                dto.setid_obat(listPenjualan.get(i).getId_Obat());
                dto.setqty_detail_transaksi(listPenjualan.get(i).getQty());
                dtos.insertDTO(dto);
                obat temp = obs.getObat(dto.getid_obat()) ;
                System.out.println("");
                temp.setstok_obat(temp.getstok_obat()-dto.getqty_detail_transaksi());
                obs.updateObat(temp);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_PenjualanObat.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_Resep panel = new Panel_Resep(gui);
        gui.updatePanel(panel);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_detail;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
