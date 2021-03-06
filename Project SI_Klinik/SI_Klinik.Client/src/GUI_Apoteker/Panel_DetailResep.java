/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;
import Client_Application_Model.TableModel_Lihat_Resep;
import database.entity.detail_lihat_resep;
import database.entity.detail_resep_obat;
import database.Service.Detail_Lihat_Resep_Service;
import database.Service.Detail_Resep_Service;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Panel_DetailResep extends javax.swing.JPanel {
    private TableModel_Lihat_Resep tableModelResep = new TableModel_Lihat_Resep();
    private Detail_Lihat_Resep_Service dlrs;
    private Detail_Resep_Service drs;
    public String noID;
    private String temp;
    private GUI_Apoteker gui;
    List<detail_lihat_resep> listResep = new ArrayList<detail_lihat_resep>();
    private List<detail_lihat_resep> list ;
    /**
     * Creates new form Panel_DetailResep
     */
    public Panel_DetailResep(Panel_Resep panel,GUI_Apoteker gui){
        dlrs = gui.dlrs;
        drs = gui.drs;
        noID = panel.ll.getId_rekam_medik();        
        temp = "";    
        this.gui = gui;        
        try{
            listResep = this.dlrs.getLihatResep(noID);
            list = this.dlrs.getLihatResepDetail(noID);            
        }catch(RemoteException exception){
            exception.printStackTrace();
        }        
        if(list.size()>0){                
            initComponents();
            if(listResep.size()>0){
                tableModelResep.setData(list);
                tabel_detail.setModel(tableModelResep);
                tanggal.setText(listResep.get(0).getTanggal());
                temp = ""+listResep.get(0).getId_Pasien();
                idPasien.setText(temp);
                nama.setText(listResep.get(0).getNama_Pasien());
                namaDokter.setText(listResep.get(0).getNama_Dokter());
            }                        
        }
        else {
            initComponents();
            JOptionPane.showMessageDialog(null, "Tidak ada data resep dari dokter","ERROR" , JOptionPane.ERROR_MESSAGE);
            Panel_Resep panels = new Panel_Resep(gui);
            gui.updatePanel(panels);            
        }
    }
    
     public Panel_DetailResep(String id,GUI_Apoteker gui){
        dlrs = gui.dlrs;
        drs = gui.drs;
        noID =id;        
        temp = "";        
        initComponents();
        this.gui = gui;        
        try{
            listResep = this.dlrs.getLihatResep(noID);
            list = this.dlrs.getLihatResepDetail(noID);
            tableModelResep.setData(list);
            tabel_detail.setModel(tableModelResep);
        }catch(RemoteException exception){
            exception.printStackTrace();
        }        
        if(listResep.size()>0){
            tanggal.setText(listResep.get(0).getTanggal());
            temp = ""+listResep.get(0).getId_Pasien();
            idPasien.setText(temp);
            nama.setText(listResep.get(0).getNama_Pasien());
            namaDokter.setText(listResep.get(0).getNama_Dokter());
        }
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
        jLabel31 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_detail = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        idPasien = new javax.swing.JLabel();
        namaDokter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1170, 570));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel33.setText("Tanggal                   :");

        jLabel31.setText("ID Pasien                 :");

        jLabel5.setText("Nama Dokter           :");

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 11)); // NOI18N
        jLabel6.setText("Daftar Obat");

        tabel_detail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel_detail);

        jButton3.setText("Kelola Penjualan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel4.setText("Detail Resep");

        tanggal.setText("tgl");

        idPasien.setText("id");

        namaDokter.setText("dokter");

        jLabel1.setText("Nama Pasien           :");

        nama.setText("nama");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idPasien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(namaDokter, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(nama)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jButton3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(idPasien))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nama))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(namaDokter))
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Panel_PenjualanObat panel = new Panel_PenjualanObat(list,gui);
        gui.updatePanel(panel); 
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idPasien;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel namaDokter;
    private javax.swing.JTable tabel_detail;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
