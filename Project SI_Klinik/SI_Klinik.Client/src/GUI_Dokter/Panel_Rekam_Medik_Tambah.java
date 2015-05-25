/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Dokter;

import database.Service.Assessment_Service;
import database.Service.Dokter_Service;
import database.Service.Pasien_Service;
import database.Service.RekamMedik_Service;
import database.entity.Pasien;
import database.entity.Rekam_Medis;
import database.entity.detail_Assessment;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author JESSICA
 */
public class Panel_Rekam_Medik_Tambah extends javax.swing.JPanel {
    Dokter_Service ds;            
    public Vector listTPL = new Vector();
    ArrayList arraylistTPL =new ArrayList();    
    Pasien p;
    int index;
    Pasien_Service ps;
    GUI_Dokter gui;
    RekamMedik_Service rs;
    private Assessment_Service assessmentservice;
    JLabel lblTitle;
    List <PanelAssessment> listpanel= new ArrayList();;
    Rekam_Medis rm;
    
    public Panel_Rekam_Medik_Tambah(GUI_Dokter gui) throws RemoteException  {
        initComponents();
        ds = gui.ds;
        ps = gui.pas;
        rs = gui.rs;
        this.gui=gui; 
        index = -1;
        assessmentservice = gui.as;
        p = gui.getPasien();
        try {        
            rm = rs.getLastRekamMedik(p.getId_Pasien());
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Rekam_Medik_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }        
        jLabel7.setText(p.getNama_Pasien());
        jLabel8.setText(p.getAlamat());        
        jLabel11.setText(getTanggal());                            
        jLabel14.setText(gui.d.getnama_dokter());
        namapasien.setText(p.getNama_Pasien());
        if (p.getJenis_Kelamin().equals("L")) {
            jenkelpasien.setText("Laki-Laki");
            jLabel9.setText("lAKI-LAKI");
        }
        else{
            jenkelpasien.setText("Perempuan");
            jLabel9.setText("PEREMPUAN");
        }
        alamatpasien.setText(p.getAlamat());
        pekerjaanpasien.setText(p.getPekerjaan());
        agamapasien.setText(p.getAgama());
        jButton16.setEnabled(false);
        sukupasien.setText(p.getSuku());        
        statuspasien.setSelectedIndex(Integer.parseInt(p.getStatus()));
        createNewTab();
        pekerjaan.setText(p.getPekerjaan());
        keluhan.setText(gui.keluhan);
        if(rm!=null){         
            List<detail_Assessment> lists = assessmentservice.getAssessments(rm.getId_Rekam_Medis());
            rm.setAssessment(lists);
            alergi.setText(rm.getAlergi_Obat());
            riwayatdahulu.setText(rm.getRiwayat_Dahulu()+"\n"+"Riwayat pemeriksaan tanggal "+rm.getTanggal_Rekam_Medis()+ " pasien didiagnosa: "+rm.getAssessments());
            riwayatkeluarga.setText(rm.getRiwayat_Keluarga());            
            ketpekerjaan.setText(rm.getKeterangan_Pekerjaan());
            kebiasaan.setText(rm.getKebiasaan());            
        }
    }
    
    public void updatePanel(JPanel panel1, JPanel panel2){
         panel1.removeAll();
         panel1.repaint();
         panel1.revalidate();                             
         panel2.setVisible(true);
         panel1.add(panel2);
         panel1.repaint();
         panel1.revalidate();  
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
            tanggal = (tanggal+"-"+bulan+"-"+tahun);
            return tanggal;
    }
    public String getTanggal2(){
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        riwayatsekarang = new java.awt.TextArea();
        jLabel39 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        keluhan = new java.awt.TextArea();
        jLabel2 = new javax.swing.JLabel();
        riwayatdahulu = new java.awt.TextArea();
        jLabel40 = new javax.swing.JLabel();
        riwayatkeluarga = new java.awt.TextArea();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        kebiasaan = new java.awt.TextArea();
        ketpekerjaan = new java.awt.TextArea();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpl = new javax.swing.JList();
        jLabel84 = new javax.swing.JLabel();
        gcs = new javax.swing.JTextField();
        keadaanumum = new javax.swing.JTextField();
        kesadaran = new javax.swing.JTextField();
        tensi = new javax.swing.JTextField();
        nadi = new javax.swing.JTextField();
        rr = new javax.swing.JTextField();
        temperature = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        pemeriksaanlain = new java.awt.TextArea();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        pekerjaan = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        alergi = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        namapasien = new javax.swing.JLabel();
        jenkelpasien = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        alamatpasien = new javax.swing.JTextField();
        pekerjaanpasien = new javax.swing.JTextField();
        agamapasien = new javax.swing.JTextField();
        sukupasien = new javax.swing.JTextField();
        statuspasien = new javax.swing.JComboBox();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();

        jPanel6.setPreferredSize(new java.awt.Dimension(1100, 1924));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("ANAMNESIS");

        riwayatsekarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatsekarangMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("KELUHAN UTAMA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("1.   Riwayat Penyakit Sekarang :");

        keluhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluhanMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("2.   Riwayat Penyakit Dahulu :");

        riwayatdahulu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatdahuluMouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("3.   Riwayat Penyakit Keluarga :");

        riwayatkeluarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatkeluargaMouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("4.   Riwayat Psikososial");

        jLabel42.setText("Pekerjaan               :");

        jLabel43.setText("Ket. Pekerjaan       :");

        jLabel44.setText("Kebiasaan              :");

        kebiasaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kebiasaanMouseClicked(evt);
            }
        });

        ketpekerjaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ketpekerjaanMouseClicked(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("PEMERIKSAAN FISIK");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("1.   Status Generalis");

        jLabel48.setText("Keadaan Umum   ");

        jLabel51.setText("GCS");

        jLabel52.setText(":");

        jLabel53.setText(":");

        jLabel55.setText(":");

        jLabel56.setText("Kesadaran");

        jLabel58.setText(":");

        jLabel59.setText("Tensi");

        jLabel61.setText(":");

        jLabel62.setText("Nadi");

        jLabel63.setText("x /menit");

        jLabel64.setText("RR");

        jLabel66.setText(":");

        jLabel67.setText("x /menit");

        jLabel68.setText("Temperature");

        jLabel70.setText("derajat C");

        jLabel71.setText(":");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("2. Pemeriksaan Lain");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setText("ASSESSMENT DAN PLANNING");

        tpl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tplMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tpl);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("TPL");

        gcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gcsMouseClicked(evt);
            }
        });
        gcs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcsActionPerformed(evt);
            }
        });

        keadaanumum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keadaanumumMouseClicked(evt);
            }
        });

        kesadaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kesadaranMouseClicked(evt);
            }
        });

        tensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tensiMouseClicked(evt);
            }
        });

        nadi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nadiMouseClicked(evt);
            }
        });

        rr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rrMouseClicked(evt);
            }
        });

        temperature.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                temperatureMouseClicked(evt);
            }
        });

        jLabel10.setText("2/4");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next-32.png"))); // NOI18N
        jButton13.setText("NEXT");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        pemeriksaanlain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemeriksaanlainMouseClicked(evt);
            }
        });

        jButton15.setText("ADD");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("DELETE");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 875, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 584, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel3);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jTabbedPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 880, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jTabbedPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 612, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pekerjaan.setText("pekerjaan");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("5.   Alergi Obat ");

        alergi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alergiMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(39, 39, 39)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(0, 0, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, keluhan, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, riwayatsekarang, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, riwayatkeluarga, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, riwayatdahulu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(24, 24, 24)
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel6Layout.createSequentialGroup()
                                        .add(jLabel42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(pekerjaan, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(jPanel6Layout.createSequentialGroup()
                                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel44, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(ketpekerjaan, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(kebiasaan, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, pemeriksaanlain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(209, 209, 209))
                    .add(jLabel46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 169, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jLabel45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(alergi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 448, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(52, 52, 52)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 652, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jButton16, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jButton15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 203, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 203, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(47, 47, 47)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jLabel68, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(2, 2, 2)
                                .add(jLabel71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jPanel6Layout.createSequentialGroup()
                                        .add(jLabel62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(2, 2, 2))
                                    .add(jPanel6Layout.createSequentialGroup()
                                        .add(jLabel64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)))
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(temperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(nadi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(rr, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                    .add(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(343, 343, 343)
                        .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jButton13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(39, 39, 39)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(2, 2, 2)
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel6Layout.createSequentialGroup()
                                        .add(jLabel52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(keadaanumum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 324, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jPanel6Layout.createSequentialGroup()
                                        .add(jLabel53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(gcs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 324, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(jLabel72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(49, 49, 49)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jLabel59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(2, 2, 2)
                                .add(jLabel58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(tensi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 324, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jLabel56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(2, 2, 2)
                                .add(jLabel55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(kesadaran, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 324, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(197, 197, 197))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jLabel39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(keluhan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(jLabel38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(riwayatsekarang, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(riwayatdahulu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(jLabel40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(riwayatkeluarga, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(jLabel41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel42, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .add(pekerjaan, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ketpekerjaan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(kebiasaan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(alergi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jLabel46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(keadaanumum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(gcs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kesadaran, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tensi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nadi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(rr, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(temperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(jLabel72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pemeriksaanlain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(jLabel73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(jLabel84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jButton15)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton16)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel6);
        jPanel6.getAccessibleContext().setAccessibleDescription("");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1076, Short.MAX_VALUE)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1056, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 2001, Short.MAX_VALUE)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1885, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 787, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 2248, Short.MAX_VALUE)
        );

        jScrollPane9.setViewportView(jPanel1);

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 789, Short.MAX_VALUE)
            .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel8Layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 2250, Short.MAX_VALUE)
            .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel8Layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 787, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 2248, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(jPanel5);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 789, Short.MAX_VALUE)
            .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel9Layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 2250, Short.MAX_VALUE)
            .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel9Layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );

        setMinimumSize(new java.awt.Dimension(1135, 578));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nama Pasien");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Alamat");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel15.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jLabel15.setText("Rekam Medik");

        jLabel11.setText(" ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Tanggal");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Nama Dokter");

        jLabel14.setText(" ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("IDENTITAS PENDERITA");

        jLabel17.setText("Nama");

        jLabel18.setText("Jenis Kelamin");

        jLabel19.setText("Alamat");

        jLabel20.setText("Pekerjaan");

        jLabel24.setText("Agama");

        jLabel27.setText("Suku Bangsa");

        jLabel28.setText("Status Pernikahan");

        jLabel29.setText(":");

        jLabel30.setText(":");

        jLabel31.setText(":");

        jLabel32.setText(":");

        jLabel21.setText(":");

        jLabel22.setText(":");

        jLabel23.setText(":");

        jenkelpasien.setText("jLabel24");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next-32.png"))); // NOI18N
        jButton12.setText("NEXT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel6.setText("1/4");

        alamatpasien.setEditable(false);
        alamatpasien.setText("jTextField8");
        alamatpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatpasienActionPerformed(evt);
            }
        });

        pekerjaanpasien.setEditable(false);
        pekerjaanpasien.setText("jTextField8");
        pekerjaanpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pekerjaanpasienActionPerformed(evt);
            }
        });

        agamapasien.setEditable(false);
        agamapasien.setText("jTextField8");
        agamapasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agamapasienActionPerformed(evt);
            }
        });

        sukupasien.setEditable(false);
        sukupasien.setText("jTextField8");
        sukupasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sukupasienActionPerformed(evt);
            }
        });

        statuspasien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belum Menikah", "Menikah" }));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel16)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel28, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel27, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel20, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(namapasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 446, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jenkelpasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 446, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(alamatpasien))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(pekerjaanpasien))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(agamapasien))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(sukupasien))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(statuspasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(390, 390, 390)
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(jButton12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel29)
                    .add(namapasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel30)
                    .add(jenkelpasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel31)
                    .add(alamatpasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel32)
                    .add(pekerjaanpasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel21)
                    .add(agamapasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel22)
                    .add(sukupasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel23)
                    .add(statuspasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .add(30, 30, 30))
        );

        jScrollPane7.setViewportView(jPanel2);

        jTabbedPane1.addTab("Identitas Pasien", jScrollPane7);

        jLabel85.setText(": ");

        jLabel86.setText(": ");

        jLabel87.setText(": ");

        jLabel89.setText(": ");

        jLabel90.setText(": ");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 969, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 432, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(0, 0, Short.MAX_VALUE)
                                        .add(jLabel15))
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 432, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel90, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(455, 455, 455))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jLabel15)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel85)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(9, 9, 9)
                                .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel86))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(14, 14, 14)
                                        .add(jLabel87))
                                    .add(layout.createSequentialGroup()
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel89)
                            .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(7, 7, 7)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel90))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 385, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void createNewTab() { 
        jTabbedPane2.remove(jTabbedPane2.getTabCount()-1);
        index=index+1;
        PanelAssessment panel = new PanelAssessment(gui, this, index);       
        jTabbedPane2.addTab("New Tab",panel);
        jTabbedPane2.addTab("+", null);
        jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount()-2);
        listpanel.add(panel);
      }
    
    public void updateLists(JList list, Vector a){
        list.removeAll();
        list.setListData(a);
    }
    
    public int getSelectedTab(){
        return jTabbedPane1.getSelectedIndex();
    }
    
    public void setTitleTab(int j, String nama){
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        lblTitle = new JLabel();
        JButton btnClose = new JButton( new ImageIcon(getClass().getResource("/Images/close.png") ) );
       
        btnClose.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
            Component selected = jTabbedPane2.getSelectedComponent();
            if (selected != null) {
                if(jTabbedPane2.getTabCount()>2){
                    listpanel.remove(jTabbedPane2.getSelectedIndex());                    
                    jTabbedPane2.remove(selected);                
                    jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount()-2);                
                    for (int i = 0; i < listpanel.size(); i++) {
                        listpanel.get(i).index = i;
                    }
                    index = index-1;
                }
            }
        }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        lblTitle.setText(nama);
        pnlTab.add(lblTitle, gbc);
        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(btnClose, gbc);
        jTabbedPane2.setTabComponentAt(j, pnlTab);
    }
    
    private void gcsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gcsActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        boolean isi1 = false;
        boolean isi2 = false;
        boolean isi3 = false;
        boolean isi4 = false;
        
        if(!alamatpasien.getText().equals("")){
            isi1 = true;
        }
        if(!pekerjaanpasien.getText().equals("")){
            isi2 = true;
        }
        if(!agamapasien.getText().equals("")){
            isi3 = true;
        }
        if(!sukupasien.getText().equals("")){
            isi4 = true;
        }
        if(isi1&&isi2&&isi3&&isi4){
            boolean changed = false;
            jButton12.setVisible(false);
            jTabbedPane1.addTab("SOAP",new JPanel().add(jScrollPane8));
            jTabbedPane1.setSelectedIndex(1);
            if(!alamatpasien.getText().equalsIgnoreCase(p.getAlamat())){
                p.setAlamat(alamatpasien.getText());
                changed = true;
            }
            if(!pekerjaanpasien.getText().equalsIgnoreCase(p.getPekerjaan())){
                p.setPekerjaan(pekerjaanpasien.getText());
                pekerjaan.setText(pekerjaanpasien.getText());
                changed = true;
            }
            if(!agamapasien.getText().equalsIgnoreCase(p.getAgama())){
                p.setAgama(agamapasien.getText());
                changed = true;
            }
            if(!sukupasien.getText().equalsIgnoreCase(p.getSuku())){
                p.setSuku(sukupasien.getText());
                changed = true;
            }
            if(statuspasien.getSelectedIndex()!=Integer.parseInt(p.getStatus())){
                p.setStatus(""+statuspasien.getSelectedIndex());
                changed= true;
            }
            if(changed){
                try {
                    ps.updatePasien(p);
                } catch (RemoteException ex) {
                    Logger.getLogger(Panel_Rekam_Medik_Tambah.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
            if(!isi1){
                alamatpasien.setBackground(Color.red);
            }
            if(!isi2){
                pekerjaanpasien.setBackground(Color.red);
            }
            if(!isi3){
                agamapasien.setBackground(Color.red);
            }
            if(!isi4){
                sukupasien.setBackground(Color.red);
            }
            JOptionPane.showMessageDialog(null, "Ada kesalahan pada kolom isian Anda. Mohon memperbaiki field yang berwarna merah untuk melanjutkan.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_jButton12ActionPerformed

    
    public void tabBaru(String judul, JPanel panel, int index){
        jTabbedPane1.addTab(judul,panel);
        jTabbedPane1.setSelectedIndex(index);
}
    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
        if(jTabbedPane2.getSelectedIndex()==jTabbedPane2.getTabCount()-1){
            createNewTab();
        }
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
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
        boolean isi10 = false;
        boolean isi11= false;
        boolean isi12 = false;
        boolean isi13 = false;
        boolean isi14 = false;
        boolean isi15 = false;
        boolean isi16 = false; 
        
        if(!keluhan.getText().equals("")){
            isi1 = true;
        }
        if(!riwayatsekarang.getText().equals("")){
            isi2 = true;
        }
        if(!riwayatdahulu.getText().equals("")){
            isi3 = true;
        }
        if(!riwayatkeluarga.getText().equals("")){
            isi4 = true;
        }
        if(!ketpekerjaan.getText().equals("")){
            isi5 = true;
        }
        if(!kebiasaan.getText().equals("")){
            isi6 = true;
        }
        if(!keadaanumum.getText().equals("")){
            isi7 = true;
        }
        if(!gcs.getText().equals("")){
            isi8 = true;
        }
        if(!kesadaran.getText().equals("")){
            isi9 = true;
        }
        if(!tensi.getText().equals("")){
            isi10 = true;
        }
        if(CheckNumber(nadi.getText())&&!nadi.getText().equals("")){
            isi11 = true;
        }
        if(CheckNumber(rr.getText())&&!rr.getText().equals("")){
            isi12 = true;
        }
        if(CheckNumber(temperature.getText())&&!temperature.getText().equals("")){
            isi13 = true;
        }
        if(!pemeriksaanlain.getText().equals("")){
            isi14 = true;
        }
        if(!arraylistTPL.isEmpty()){
            isi15 = true;
        }
        if(!alergi.getText().equals("")){
            isi16 = true;
        }
        
        boolean panelbenar = true;
        
        for (int i = 0; i < listpanel.size(); i++) {
            if(!listpanel.get(i).checkpanel()){
                panelbenar = false;
            }
        }
        
        if(isi1&&isi2&&isi3&&isi4&&isi5&&isi6&&isi7&&isi8&&isi9&&isi10&&isi11&&isi12&&isi13&&isi14&&isi15&&isi16&&panelbenar){            
            Rekam_Medis rm1 = new Rekam_Medis();
            rm1.setAlergi_Obat(alergi.getText());
            rm1.setGCS(Integer.parseInt(gcs.getText()));
            rm1.setId_Dokter(gui.d.getid_dokter());
            rm1.setId_Pasien(gui.getPasien().getId_Pasien());
            try {        
            rm = rs.getLastRekamMedik(p.getId_Pasien());
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Rekam_Medik_Tambah.class.getName()).log(Level.SEVERE, null, ex);
        }   
            if(rm!=null){
            int idTerakhir = Integer.parseInt(rm.getId_Rekam_Medis().split("-")[1]);
            System.out.println(idTerakhir);
            rm1.setId_Rekam_Medis(gui.getPasien().getId_Pasien()+"-"+(idTerakhir+1));
            rm1.setFlag(idTerakhir+1);
            }
            else{
                rm1.setId_Rekam_Medis(gui.getPasien().getId_Pasien()+"-"+(1));
            }
            
            rm1.setKeadaanUmum(keadaanumum.getText());
            rm1.setKebiasaan(kebiasaan.getText());
            rm1.setKesadaran(kesadaran.getText());
            rm1.setKeterangan_Pekerjaan(ketpekerjaan.getText());
            rm1.setNadi(Integer.parseInt(nadi.getText()));
            rm1.setNama_Dokter(gui.d.getnama_dokter());
            rm1.setPemeriksaan_Lain(pemeriksaanlain.getText());
            rm1.setRR(Integer.parseInt(rr.getText()));
            rm1.setRiwayat_Dahulu(riwayatdahulu.getText());
            rm1.setRiwayat_Keluarga(riwayatkeluarga.getText());
            rm1.setRiwayat_Sekarang(riwayatsekarang.getText());
            rm1.setTanggal_Rekam_Medis(getTanggal2());
            rm1.setTemperature(Integer.parseInt(temperature.getText()));
            rm1.setTensi(tensi.getText());            
            String temp = listTPL.get(0).toString();
            for (int i = 1; i < listTPL.size(); i++) {
                temp = temp+"~"+listTPL.get(i);
            }
            rm1.setTPL(temp);
            try {
                rs.insertRekamMedik(rm1);
                rm = rs.getLastRekamMedik(gui.getPasien().getId_Pasien());
                System.out.println("Id RM terakhir ="+rm.getId_Rekam_Medis());
                detail_Assessment assessment;
                for (int i = 0; i < listpanel.size(); i++) {
                    assessment = new detail_Assessment();
                    String ppl="";
                    String tx="";
                    String mx="";
                    String ex="";
                    String dx="";
                    for (int j = 0; j < listpanel.get(i).PPL.size(); j++) {
                            if (j==0) {
                                ppl = listpanel.get(i).PPL.get(0).toString();
                            }
                            else{ppl = ppl + "~"+ listpanel.get(i).PPL.get(j);}
                        }

                        for (int j = 0; j < listpanel.get(i).Tx.size(); j++) {
                            if(j==0){
                                tx = listpanel.get(i).Tx.get(0).toString();}
                            else{tx = tx + "~"+ listpanel.get(i).Tx.get(j);}                        
                        }

                        for (int j = 0; j < listpanel.get(i).Mx.size(); j++) {
                            if (j==0) {
                                mx = listpanel.get(i).Mx.get(0).toString();       
                            }
                            else{mx = mx + "~"+ listpanel.get(i).Mx.get(j);}
                        }
                        for (int j = 0; j < listpanel.get(i).Ex.size(); j++) {
                            if(j==0){
                                ex= listpanel.get(i).Ex.get(0).toString();       
                            }
                            else{ex = ex + "~"+ listpanel.get(i).Ex.get(j);}
                        }
                        for (int j = 0; j < listpanel.get(i).Dx.size(); j++) {
                            if(j==0){dx = listpanel.get(i).Dx.get(0).toString();}
                            else{dx = dx + "~"+ listpanel.get(i).Dx.get(j);}
                        }
                        assessment.setAssessment(listpanel.get(i).Assessment);
                        assessment.setDX(dx);
                        assessment.setEX(ex);
                        assessment.setMX(mx);
                        assessment.setTX(tx);
                        assessment.setPPL(ppl);
                        assessment.setId_Rekam_Medis(rm.getId_Rekam_Medis());
                        assessmentservice.insertAssessment(assessment);
                    }                                                   
            } catch (RemoteException ex) {
                Logger.getLogger(Panel_Rekam_Medik_Tambah.class.getName()).log(Level.SEVERE, null, ex);
            }
            jButton13.setVisible(false);
            Panel_Input_Tindakan_Medis panel = new Panel_Input_Tindakan_Medis(gui,rm.getId_Rekam_Medis());
            tabBaru("tindakan medis",panel,2);
        }
        else{
            if(!isi1){
                keluhan.setBackground(Color.red);
            }
            if(!isi2){
                riwayatsekarang.setBackground(Color.red);
            }
            if(!isi3){
                riwayatdahulu.setBackground(Color.red);
            }
            if(!isi4){
                riwayatkeluarga.setBackground(Color.red);
            }
            if(!isi5){
                ketpekerjaan.setBackground(Color.red);
            }
            if(!isi6){
                kebiasaan.setBackground(Color.red);
            }
            if(!isi7){
                keadaanumum.setBackground(Color.red);
            }
            if(!isi8){
                gcs.setBackground(Color.red);
            }
            if(!isi9){
                kesadaran.setBackground(Color.red);
            }
            if(!isi10){
                tensi.setBackground(Color.red);
            }
            if(!isi11){
                nadi.setBackground(Color.red);
            }
            if(!isi12){
                rr.setBackground(Color.red);
            }
            if(!isi13){
                temperature.setBackground(Color.red);
            }
            if(!isi14)
            {
                pemeriksaanlain.setBackground(Color.red);
            }
            if(!isi15){
                tpl.setBackground(Color.red);
            }
            if(!isi16){
                alergi.setBackground(Color.red);
            }
                
            JOptionPane.showMessageDialog(null, "Ada kesalahan pada kolom isian Anda. Mohon memperbaiki field yang berwarna merah untuk melanjutkan.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void alamatpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatpasienActionPerformed
        // TODO add your handling code here:
        alamatpasien.setBackground(Color.white);
    }//GEN-LAST:event_alamatpasienActionPerformed

    private void pekerjaanpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pekerjaanpasienActionPerformed
        // TODO add your handling code here:
        pekerjaanpasien.setBackground(Color.white);        
    }//GEN-LAST:event_pekerjaanpasienActionPerformed

    private void agamapasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agamapasienActionPerformed
        // TODO add your handling code here:
        agamapasien.setBackground(Color.white);
    }//GEN-LAST:event_agamapasienActionPerformed

    private void sukupasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sukupasienActionPerformed
        // TODO add your handling code here:
        sukupasien.setBackground(Color.white);
    }//GEN-LAST:event_sukupasienActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        tpl.setBackground(Color.white);
        String a = JOptionPane.showInputDialog(null, "TPL:", "");
        arraylistTPL.add(a);
        listTPL.add(a);
        updateLists(tpl,listTPL);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void tplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tplMouseClicked
        // TODO add your handling code here:
        jButton16.setEnabled(true);
    }//GEN-LAST:event_tplMouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini?");
        if(a==0){
            listTPL.remove(tpl.getSelectedIndex());
            arraylistTPL.remove(tpl.getSelectedIndex());
            updateLists(tpl,listTPL);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void keluhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluhanMouseClicked
        // TODO add your handling code here:
        keluhan.setBackground(Color.white);
    }//GEN-LAST:event_keluhanMouseClicked

    private void riwayatsekarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatsekarangMouseClicked
        // TODO add your handling code here:
        riwayatsekarang.setBackground(Color.white);
    }//GEN-LAST:event_riwayatsekarangMouseClicked

    private void riwayatdahuluMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatdahuluMouseClicked
        // TODO add your handling code here:
        riwayatdahulu.setBackground(Color.white);
    }//GEN-LAST:event_riwayatdahuluMouseClicked

    private void riwayatkeluargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatkeluargaMouseClicked
        // TODO add your handling code here:
        riwayatkeluarga.setBackground(Color.white);
    }//GEN-LAST:event_riwayatkeluargaMouseClicked

    private void ketpekerjaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ketpekerjaanMouseClicked
        // TODO add your handling code here:
        ketpekerjaan.setBackground(Color.white);
    }//GEN-LAST:event_ketpekerjaanMouseClicked

    private void kebiasaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kebiasaanMouseClicked
        // TODO add your handling code here:
        kebiasaan.setBackground(Color.white);
    }//GEN-LAST:event_kebiasaanMouseClicked

    private void alergiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alergiMouseClicked
        // TODO add your handling code here:
        alergi.setBackground(Color.white);
    }//GEN-LAST:event_alergiMouseClicked

    private void keadaanumumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keadaanumumMouseClicked
        // TODO add your handling code here:
        keadaanumum.setBackground(Color.white);
    }//GEN-LAST:event_keadaanumumMouseClicked

    private void gcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gcsMouseClicked
        // TODO add your handling code here:
        gcs.setBackground(Color.white);
    }//GEN-LAST:event_gcsMouseClicked

    private void kesadaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kesadaranMouseClicked
        // TODO add your handling code here:
        kesadaran.setBackground(Color.white);
    }//GEN-LAST:event_kesadaranMouseClicked

    private void tensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tensiMouseClicked
        // TODO add your handling code here:
        tensi.setBackground(Color.white);
    }//GEN-LAST:event_tensiMouseClicked

    private void nadiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nadiMouseClicked
        // TODO add your handling code here:
        nadi.setBackground(Color.white);
    }//GEN-LAST:event_nadiMouseClicked

    private void rrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rrMouseClicked
        // TODO add your handling code here:
        rr.setBackground(Color.white);
    }//GEN-LAST:event_rrMouseClicked

    private void temperatureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temperatureMouseClicked
        // TODO add your handling code here:
        temperature.setBackground(Color.white);
    }//GEN-LAST:event_temperatureMouseClicked

    private void pemeriksaanlainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemeriksaanlainMouseClicked
        // TODO add your handling code here:
        pemeriksaanlain.setBackground(Color.white);
    }//GEN-LAST:event_pemeriksaanlainMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agamapasien;
    private javax.swing.JTextField alamatpasien;
    private javax.swing.JTextField alergi;
    private javax.swing.JTextField gcs;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel jenkelpasien;
    private javax.swing.JTextField keadaanumum;
    private java.awt.TextArea kebiasaan;
    private java.awt.TextArea keluhan;
    private javax.swing.JTextField kesadaran;
    private java.awt.TextArea ketpekerjaan;
    private javax.swing.JTextField nadi;
    private javax.swing.JLabel namapasien;
    private javax.swing.JLabel pekerjaan;
    private javax.swing.JTextField pekerjaanpasien;
    private java.awt.TextArea pemeriksaanlain;
    private java.awt.TextArea riwayatdahulu;
    private java.awt.TextArea riwayatkeluarga;
    private java.awt.TextArea riwayatsekarang;
    private javax.swing.JTextField rr;
    private javax.swing.JComboBox statuspasien;
    private javax.swing.JTextField sukupasien;
    private javax.swing.JTextField temperature;
    private javax.swing.JTextField tensi;
    private javax.swing.JList tpl;
    // End of variables declaration//GEN-END:variables
}


