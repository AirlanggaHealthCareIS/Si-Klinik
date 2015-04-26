/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Apoteker;

import database.Service.Obat_Service;
import database.entity.Penjualan;
import database.entity.obat;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author win7
 */
public class Form_Penjualan_Tambah extends javax.swing.JFrame {
    Obat_Service obs;
    List<Penjualan> list;
    GUI_Apoteker gui;
    Panel_PenjualanObat p;
    
    public Form_Penjualan_Tambah(List<Penjualan> list, GUI_Apoteker gui, Panel_PenjualanObat p) {
        initComponents();        
        obs = gui.os;
        this.p = p;
        this.gui= gui;
        this.list = list;
    }

     private void initiateComboBox1(){
        jComboBox1.removeAllItems();        
        List<obat> lb;
        try {
            lb =obs.getAllObatSort();
            for(int i = 0; i<lb.size();i++){                
               jComboBox1.addItem(lb.get(i).getnama_obat().toUpperCase());                
            }            
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Penjualan_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("JUMLAH   ");

        jLabel5.setText("NAMA OBAT");

        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("HARGA OBAT");

        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel7.setText("TOTAL HARGA");

        jTextField5.setEnabled(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeVisible(evt);
            }
        });
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

        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinner1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSpinner1MouseEntered(evt);
            }
        });
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSpinner1FocusGained(evt);
            }
        });
        jSpinner1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jSpinner1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jSpinner1InputMethodTextChanged(evt);
            }
        });
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSpinner1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addComponent(jComboBox1, 0, 107, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tambah Pembelian");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int stok = obs.getObat(obs.getIdObat(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString())).getstok_obat();
            if((Integer)jSpinner1.getValue()>stok){
                JOptionPane.showMessageDialog(null, "Stok tidak memenuhi. \nStok yang ada hanya "+stok, "ERROR", JOptionPane.ERROR_MESSAGE);
                jSpinner1.setValue(stok);
            }
            else{
                Penjualan p = new Penjualan();            
                String namaobat = jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString();   
                obat o = obs.getObat(obs.getIdObat(namaobat));
                p.setId_Obat(o.getid_obat());
                p.setNama_Obat(o.getnama_obat());
                p.setHarga(o.getharga_obat());
                p.setQty((Integer)jSpinner1.getValue());
                p.setTotal(p.getHarga()*p.getQty());
                p.setStok(o.getstok_obat());
                if(p.getStok()>p.getQty()){
                        p.setKeterangan("Memenuhi");
                    }
                    else{
                        p.setKeterangan("Tidak Memenuhi, jumlah stok="+p.getStok());
                    }
                if(list.size()>0){
                    int row=-1;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).getId_Obat().equals(p.getId_Obat())){                       
                       row = i;
                    }
                }
                if (row>-1) {
                    p.setQty((Integer)jSpinner1.getValue()+list.get(row).getQty());
                    p.setTotal(p.getHarga()*p.getQty());
                    if(p.getStok()>p.getQty()){
                        p.setKeterangan("Memenuhi");
                    }
                    else{
                        p.setKeterangan("Tidak Memenuhi, jumlah stok="+p.getStok());
                    } 
                    list.set(row, p);
                }
                else{
                    list.add(p);
                }                                           
            }
                else{
                    list.add(p);
                }
            }
            this.p.updateTabel();
            this.gui.setVisible(true);
            this.dispose();
            }
         catch (RemoteException ex) {
            Logger.getLogger(Form_Penjualan_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        initiateComboBox1();
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
  
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:        
        try {
            int stok = obs.getObat(obs.getIdObat(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString())).getstok_obat();
            if(!jTextField4.getText().equals("")){
                if((Integer)jSpinner1.getValue()>stok){
                JOptionPane.showMessageDialog(null, "Stok tidak memenuhi. \nStok yang ada hanya "+stok, "ERROR", JOptionPane.ERROR_MESSAGE);
                jSpinner1.setValue(stok);
                }
                jTextField5.setText(""+Integer.parseInt(jTextField4.getText())*(Integer)jSpinner1.getValue());
        }
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Penjualan_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    if(jComboBox1.getItemCount()>=1&&!jComboBox1.getItemAt(0).equals("Pilih")){
        try {
            int harga= obs.getObat(obs.getIdObat(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString())).getharga_obat();
            jTextField4.setText(""+harga);
            jTextField5.setText(""+(harga*(Integer)jSpinner1.getValue()));
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Penjualan_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jSpinner1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyTyped
        // TODO add your handling code here:
        try {
            int stok = obs.getObat(obs.getIdObat(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString())).getstok_obat();
            
            if(!jTextField4.getText().equals("")){
                if((Integer)jSpinner1.getValue()>stok){
                JOptionPane.showMessageDialog(null, "Stok tidak memenuhi. \nStok yang ada hanya "+stok, "ERROR", JOptionPane.ERROR_MESSAGE);
                jSpinner1.setValue(stok);
                }
                jTextField5.setText(""+Integer.parseInt(jTextField4.getText())*(Integer)jSpinner1.getValue());
        }
        } catch (RemoteException ex) {
            Logger.getLogger(Form_Penjualan_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSpinner1KeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:       
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jSpinner1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseClicked
        // TODO add your handling code here:
      System.out.println("lalalaclick");
         if(!jTextField4.getText().equals("")){
            jTextField5.setText(""+Integer.parseInt(jTextField4.getText())*(Integer)jSpinner1.getValue());
        }
    }//GEN-LAST:event_jSpinner1MouseClicked

    private void jSpinner1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyPressed
        // TODO add your handling code here:        
    }//GEN-LAST:event_jSpinner1KeyPressed

    private void jSpinner1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSpinner1CaretPositionChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jSpinner1CaretPositionChanged

    private void jSpinner1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSpinner1InputMethodTextChanged
        // TODO add your handling code here:
         if(!jTextField4.getText().equals("")){
            jTextField5.setText(""+Integer.parseInt(jTextField4.getText())*(Integer)jSpinner1.getValue());
        }
    }//GEN-LAST:event_jSpinner1InputMethodTextChanged

    private void jSpinner1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSpinner1FocusGained
        // TODO add your handling code here:        
    }//GEN-LAST:event_jSpinner1FocusGained

    private void jSpinner1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseEntered
        // TODO add your handling code here:
         System.out.println("lalalaenterd");
         if(!jTextField4.getText().equals("")){
            jTextField5.setText(""+Integer.parseInt(jTextField4.getText())*(Integer)jSpinner1.getValue());
        }
    }//GEN-LAST:event_jSpinner1MouseEntered

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
