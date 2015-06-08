/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;
import java.awt.Color;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import database.entity.obat;
import database.Service.Obat_Service;
import database.Service.Supplier_Service;
import database.entity.Supplier;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class dataobat_menambah extends javax.swing.JFrame {
        Obat_Service ss;
        GUI_Apoteker a;
        Supplier_Service supplierservice;
                
    /**
     * Creates new form dataobat_menambah
     */
    public dataobat_menambah(GUI_Apoteker a) {
        initComponents();
        this.a = a;
        ss = a.os;
        supplierservice = a.ss;
        //Obat_Service ob;
    }
    private void refresh(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Pilih");
        field_nama_obat.setText("");
        field_dosis.setText("");
        field_keterangan_obat.setText("");
        field_stok_obat.setText("");
        field_stok_kritis.setText("");
        field_jenis_obat.setText("");
        field_kemasan.setText("");
        field_harga_obat.setText("");    
    }

    
    
    private boolean CheckNumber(String a){
        char b;
        StringBuffer s;        
        for(int i = 0; i<a.length();i++){
            b = a.charAt(i);                        
            s = new StringBuffer();
            s.append(b);          
            if(!s.toString().equals("1")&&!s.toString().equals("2")&&!s.toString().equals("3")&&!s.toString().equals("4")&&!s.toString().equals("5")&&!s.toString().equals("6")&&!s.toString().equals("7")&&!s.toString().equals("8")&&!s.toString().equals("9")&&!s.toString().equals("0")){               
               return false;
            }            
        }
        return true;
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
        entry_data_obat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dosisobat = new javax.swing.JLabel();
        hargaobat = new javax.swing.JLabel();
        pabrikobat = new javax.swing.JLabel();
        jenisobat = new javax.swing.JLabel();
        kemasanobat = new javax.swing.JLabel();
        namaobat = new javax.swing.JLabel();
        keterangan = new javax.swing.JLabel();
        stokobat = new javax.swing.JLabel();
        field_nama_obat = new javax.swing.JTextField();
        field_dosis = new javax.swing.JTextField();
        field_keterangan_obat = new javax.swing.JTextField();
        field_stok_obat = new javax.swing.JTextField();
        field_kemasan = new javax.swing.JTextField();
        field_harga_obat = new javax.swing.JTextField();
        tombol_save = new javax.swing.JButton();
        tombol_clear = new javax.swing.JButton();
        field_jenis_obat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        field_stok_kritis = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        tombol_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(700, 450));

        entry_data_obat.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        entry_data_obat.setText("ENTRY DATA OBAT");

        dosisobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dosisobat.setText("Dosis");

        hargaobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hargaobat.setText("Harga Obat");

        pabrikobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pabrikobat.setText("Pabrik Obat");

        jenisobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jenisobat.setText("Jenis Obat");

        kemasanobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kemasanobat.setText("Kemasan");

        namaobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        namaobat.setText("Nama Obat");

        keterangan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        keterangan.setText("Keterangan Obat");

        stokobat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stokobat.setText("Stock Obat");

        field_nama_obat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nama_obatActionPerformed(evt);
            }
        });

        tombol_save.setText("SAVE");
        tombol_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_saveActionPerformed(evt);
            }
        });

        tombol_clear.setText("CLEAR");
        tombol_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_clearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Batas Kritis");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeVisible(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pabrikobat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jenisobat)
                                    .addComponent(kemasanobat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hargaobat)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaobat))
                                .addGap(179, 179, 179))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(stokobat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(keterangan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dosisobat, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_nama_obat, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_stok_kritis, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_keterangan_obat)
                            .addComponent(field_dosis)
                            .addComponent(field_stok_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_jenis_obat)
                            .addComponent(field_kemasan)
                            .addComponent(field_harga_obat))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tombol_save, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombol_clear)
                        .addGap(234, 234, 234))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_nama_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaobat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_dosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosisobat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_keterangan_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keterangan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_stok_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokobat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_stok_kritis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pabrikobat, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jenisobat)
                    .addComponent(field_jenis_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kemasanobat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_kemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_harga_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaobat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombol_save)
                    .addComponent(tombol_clear))
                .addContainerGap())
        );

        tombol_back.setText("BACK");
        tombol_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombol_back)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(entry_data_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(214, 214, 214))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(entry_data_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_saveActionPerformed
        // TODO add your handling code here:
        boolean isi1 = false;
        boolean isi2 = false;
        boolean isi3 = false;
        boolean isi4 = false;
        boolean isi5 = false;
        boolean isi6 = false;
        boolean isi7 = false;
        boolean isi8 = false;
        boolean isi9 = false;

        if(!field_nama_obat.getText().equals("")){
            isi1 = true;
        }
        if(!field_dosis.getText().equals("")){
            isi2 = true;
        }
        if(!field_keterangan_obat.getText().equals("")){
            isi3 = true;
        }
        if(CheckNumber(field_stok_obat.getText())&&!field_stok_obat.getText().equals("")){
            isi4 = true;
        }
        if(CheckNumber(field_stok_kritis.getText())&&!field_stok_kritis.getText().equals("")){
            isi5 = true;
        }
        if(!jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString().equals("Pilih")){
            isi6 = true;
        }
        if(!field_jenis_obat.getText().equals("")) {
            isi7 = true;
        }
        if(!field_kemasan.getText().equals("")){
            isi8 = true;
        }
        if(!field_harga_obat.getText().equals("")){
            isi9 = true;
        }

        if(isi1&&isi2&&isi3&&isi4&&isi5&&isi6&&isi7&&isi8&&isi9)    {
            String NM = field_nama_obat.getText();
            float DS = Float.parseFloat(field_dosis.getText());
            String KT = field_keterangan_obat.getText();
            int ST = Integer.parseInt(field_stok_obat.getText());
            int SK = Integer.parseInt(field_stok_kritis.getText());
            String PB = jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString();
            String JN = field_jenis_obat.getText();
            String KM = field_kemasan.getText();
            int HG = Integer.parseInt(field_harga_obat.getText());
            String ID = null;
            System.out.println("satu");
            try {
                ID = "O"+(ss.getAllObat().size()+1);
                System.out.println(ID);
            } catch (RemoteException ex) {
                Logger.getLogger(dataobat_menambah.class.getName()).log(Level.SEVERE, null, ex);
            }
            //            try {
                //               obat s = new obat();
                //               s.setid_obat(ID);
                //               s.setnama_obat(NM);
                //               s.setdosis(DS);
                //               s.setketerangan_obat(KT);
                //               s.setstok_obat(ST);
                //               s.setstok_kritis(SK);
                //               s.setpabrik_obat(PB);
                //               s.setjenis_obat(JN);
                //               s.setkemasan(KM);
                //               s.setharga_obat(HG);

//                try {
//                    ID = "OBAT"+ss.getObat().size();
//                } catch (RemoteException ex) {
//                    Logger.getLogger(dataobat_menambah.class.getName()).log(Level.SEVERE, null, ex);
//                }
                try {
                    obat s = new obat();
                    s.setid_obat(ID);
                    s.setnama_obat(NM);
                    s.setdosis(DS);
                    s.setketerangan_obat(KT);
                    s.setstok_obat(ST);
                    s.setpabrik_obat(PB);
                    s.setjenis_obat(JN);
                    s.setkemasan(KM);
                    s.setharga_obat(HG);
                    s.setIdSupplier(supplierservice.getId_Supplier(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString()).getId_Supplier());
                    s.setstok_kritis(SK);
                    System.out.println("disni masuk insert");
                    if(ss.insertObat(s)!=null){
                        int opsi = JOptionPane.showConfirmDialog(null, "Data Anda berhasil disimpan. Apakah Anda akan menambahkan data lagi?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(opsi==0){
                            refresh();
                        }
                        else{
                          dataobat_home panel = new dataobat_home(this.a) ;
                           a.updatePanel(panel);
                           panel.UpdateTabel();
                           this.dispose();
                           a.setVisible(true);
                        }
                    }
                }
                catch(RemoteException exception){
                    exception.printStackTrace();
                }
            }
            else{
                if(!isi1){
                    field_nama_obat.setBackground(Color.red);
                }
                if(!isi2){
                    field_dosis.setBackground(Color.red);
                }
                if(!isi3){
                    field_keterangan_obat.setBackground(Color.red);
                }

                if(!isi4){
                    field_stok_obat.setBackground(Color.red);
                }

                if(!isi5){
                    field_stok_kritis.setBackground(Color.red);
                }
                if(!isi6){
                    jComboBox1.setBackground(Color.red);
                }
                if(!isi7){
                    field_jenis_obat.setBackground(Color.red);
                }

                if(!isi8){
                    field_kemasan.setBackground(Color.red);
                }

                if(!isi9){
                    field_harga_obat.setBackground(Color.red);
                }
                JOptionPane.showMessageDialog(null, "Ada kesalahan pada kolom isian Anda. Mohon memperbaiki field yang berwarna merah untuk melanjutkan.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        
    }//GEN-LAST:event_tombol_saveActionPerformed

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        List<Supplier> list;
        jComboBox1.removeAllItems();
        try {
            list = supplierservice.getSupliers();
            for (int i = 0; i < list.size(); i++) {
                jComboBox1.addItem(list.get(i).getNama_Supplier());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(dataobat_mengubah.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible

    private void field_nama_obatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nama_obatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nama_obatActionPerformed

    private void tombol_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_clearActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_tombol_clearActionPerformed

    private void tombol_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_backActionPerformed
        // TODO add your handling code here:
        a.updatePanel(new dataobat_home(this.a));
        this.dispose();
    }//GEN-LAST:event_tombol_backActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dosisobat;
    private javax.swing.JLabel entry_data_obat;
    private javax.swing.JTextField field_dosis;
    private javax.swing.JTextField field_harga_obat;
    private javax.swing.JTextField field_jenis_obat;
    private javax.swing.JTextField field_kemasan;
    private javax.swing.JTextField field_keterangan_obat;
    private javax.swing.JTextField field_nama_obat;
    private javax.swing.JTextField field_stok_kritis;
    private javax.swing.JTextField field_stok_obat;
    private javax.swing.JLabel hargaobat;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jenisobat;
    private javax.swing.JLabel kemasanobat;
    private javax.swing.JLabel keterangan;
    private javax.swing.JLabel namaobat;
    private javax.swing.JLabel pabrikobat;
    private javax.swing.JLabel stokobat;
    private javax.swing.JButton tombol_back;
    private javax.swing.JButton tombol_clear;
    private javax.swing.JButton tombol_save;
    // End of variables declaration//GEN-END:variables
}
