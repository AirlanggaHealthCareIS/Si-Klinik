/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Dokter;
import Client_Application_Model.TabelModel_InputResep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import database.Service.Detail_Resep_Service;
import database.Service.Obat_Service;
import database.entity.detail_lihat_resep;
import database.entity.detail_resep_obat;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author tinot
 */
public class Panel_Resep extends javax.swing.JPanel {
    private Detail_Resep_Service detResepService;
    private Obat_Service service10;
    Registry registry;
    private TabelModel_InputResep tableModelResep = new TabelModel_InputResep();
    List <detail_lihat_resep> list= new ArrayList <detail_lihat_resep>();    
    GUI_Dokter gui;
    detail_lihat_resep ll;
    String id;
    int index;
    public String nama = "";
    /**
     * Creates new form Panel_Resep
     */
    public Panel_Resep(GUI_Dokter gui, String id_rekam) throws RemoteException, NotBoundException{
        initComponents();
        detResepService = (Detail_Resep_Service) gui.drs;
        this.gui= gui;
        id=id_rekam;
        detResepService = gui.drs;
                      
            tableModelResep.setData(list);
            tabel_resep.setModel(tableModelResep);
        
        this.gui=gui;
        tabel_resep.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int row = tabel_resep.getSelectedRow();
                 if(row != -1){
                   ll = tableModelResep.get(row);
                   index = row;
                 }
            }
        });
    }
    
    public Panel_Resep(){
        
    }
    
    public void updateTable(List <detail_lihat_resep> list){
        tableModelResep.setData(list);
        tabel_resep.setModel(tableModelResep);
    }
    
    public void remove(){
        list.remove(tabel_resep.getSelectedRow());
        tableModelResep.setData(list);
        tabel_resep.setModel(tableModelResep);
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
        jPanel6 = new javax.swing.JPanel();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_resep = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(700, 450));

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel1.setText("Resep Pasien");

        tabel_resep.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabel_resep);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(tambah)
                                .addGap(43, 43, 43)
                                .addComponent(ubah)))
                        .addGap(39, 39, 39)
                        .addComponent(hapus)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(254, 254, 254))))
        );

        jScrollPane2.setViewportView(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        Form_Tambah_Resep a;
        try {
            a = new Form_Tambah_Resep(this);
            a.setVisible(true);
            //a.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Resep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Panel_Resep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tambahActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        Form_Ubah_Resep a;
        try {
            a = new Form_Ubah_Resep(this, index);
            a.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Resep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Panel_Resep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini ?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a==0) {
            remove();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*
         * kurang id resep. seharusnya pake for
         * masih bingung di bagian menampilkan list obat yang dipilih dengan 3 kolom sekaligus
         */
        
        String hasil = "";
        try {
            for (int i = 0; i < list.size(); i++) {
                hasil = list.get(i).getIdObat();
                detail_resep_obat resep = new detail_resep_obat();
                //resep.setid_detail_resep("1");
                resep.setid_rekam_medis(id);
                resep.setid_obat(list.get(i).getIdObat());
                resep.setqty_detail_resep(list.get(i).getQty());
                detResepService.insertResep(resep);
            }
            JOptionPane.showMessageDialog(null, "Data Rekam Medis berhasil Disimpan", "Pesan Rekam Medis", JOptionPane.OK_OPTION);
            Panel_Rekam_Medik_Awal pra = new Panel_Rekam_Medik_Awal(gui);
            pra.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Resep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public String getIdresep(){
        return "";
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabel_resep;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables


}


