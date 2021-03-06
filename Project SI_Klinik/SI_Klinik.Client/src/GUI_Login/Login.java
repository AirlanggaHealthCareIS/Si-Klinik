
package GUI_Login;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import GUI_Admin.GUI_Admin;
import GUI_Apoteker.GUI_Apoteker;
import GUI_Dokter.GUI_Dokter;
import GUI_Kasir.GUI_Kasir;
import GUI_Presensi.GUI_Presensi;
import GUI_StafKlinik.GUI_StafKlinik;
import database.Service.Assessment_Service;
import database.Service.DetailTransaksiObat_Service;
import database.Service.Detail_Lihat_Resep_Service;
import database.Service.Detail_Resep_Service;
import database.Service.Petugas_Service;
import database.Service.Dokter_Service;
import database.Service.Penggajian_Service;
import database.Service.Jadwal_Service;
import database.Service.Laporan_Keuangan_Service;
import database.Service.Obat_Service;
import database.Service.Pasien_Service;
import database.Service.Pendaftaran_Service;
import database.Service.Penyakit_Service;
import database.Service.RekamMedik_Service;
import database.Service.Resep_Service;
import database.Service.Supplier_Service;
import database.Service.Tindakan_Dokter_Service;
import database.Service.Tindakan_Periksa_Service;
import database.Service.TransaksiObat_Service;
import database.Service.Transaksi_Periksa_Service;
import database.Service.lihat_Resep_Service;
import database.Service.Pemesanan_Obat_Service;
import database.Service.List_PO_Service;
import database.entity.detil_pesan_obat;
import database.Service.Presensi_Service;
import database.entity.Presensi;
import database.entity.petugas;
import database.entity.dokter;
import java.awt.Color;
import java.awt.Component;


/**
 * 
 *
 * @author JESSICA
 */
public class Login extends javax.swing.JFrame {
      public Petugas_Service service1;
      public Dokter_Service service2;
      public Pendaftaran_Service service3;
      public Pasien_Service service4;
      public Laporan_Keuangan_Service service5;
      public Tindakan_Dokter_Service service6;
      public Assessment_Service service7;
      public Detail_Resep_Service service8;
      public Jadwal_Service service9;
      public Obat_Service service10;
      public Resep_Service service11;
      public Supplier_Service service12;
      public Tindakan_Periksa_Service service13;
      public Transaksi_Periksa_Service service14;
      public RekamMedik_Service service15;
      public Penyakit_Service service16;
      public lihat_Resep_Service service17;
      public Detail_Lihat_Resep_Service service18;      
      public TransaksiObat_Service service19;
      public DetailTransaksiObat_Service service20;
      public Penggajian_Service service21;
      public Pemesanan_Obat_Service service22;
      public Presensi_Service service23;
      public List_PO_Service service24;
      Registry registry;
      public SocketClient client;
      public int port;
      public String serverAddr, username;
      public String jabatan;
      private Thread clientThread;
      private DefaultListModel model;
      private File file;
      private petugas p;
      private dokter d;
      public boolean aktorIniDokter;      
      public boolean absensi;
    /**
     * Creates new form Login
     */
    public Login() throws RemoteException, NotBoundException {        
        super("LOGIN");
        initComponents();  
        p=new petugas();
        d = new dokter();
        aktorIniDokter = false;
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);        
        boolean portBenar=false;
        absensi = false;
        while (!portBenar){            
            String portx = JOptionPane.showInputDialog(null, "Port Server Tujuan (angka 1000-9999): ", "input", JOptionPane.QUESTION_MESSAGE);
            if(!CheckNumber(portx)){                
                portBenar = false;
            }
            else{            
                if(Integer.parseInt(portx)>10000||Integer.parseInt(portx)<999)  {                    
                    portBenar = false;
                }            
                else{
                    portBenar = true;
                    port = Integer.parseInt(portx);
                }
            }
        }
        serverAddr = JOptionPane.showInputDialog(null, "IP Address Server Tujuan: ", "input", JOptionPane.QUESTION_MESSAGE);        
        registry = LocateRegistry.getRegistry(serverAddr, port);        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        masuk = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USER NAME ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 210, 80, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PASWORD");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(350, 280, 80, 30);

        nama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namaMouseClicked(evt);
            }
        });
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel1.add(nama);
        nama.setBounds(440, 210, 290, 30);

        jButton1.setText("Setting");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(710, 10, 73, 23);

        masuk.setText("LOGIN");
        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        jPanel1.add(masuk);
        masuk.setBounds(500, 350, 110, 40);

        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passMousePressed(evt);
            }
        });
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        pass.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                passCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel1.add(pass);
        pass.setBounds(440, 280, 290, 30);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sistem Informasi Klinik");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(230, 60, 380, 30);

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SI KLINIK");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(310, 10, 250, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOGIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(510, 140, 120, 40);

        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Password salah");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(450, 310, 200, 20);

        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Username salah");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(450, 240, 210, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.jpg"))); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void startRegistry() throws RemoteException, NotBoundException{    
        service3 = (Pendaftaran_Service) registry.lookup("service3");     
        service4 = (Pasien_Service) registry.lookup("service4");     
        service5 = (Laporan_Keuangan_Service) registry.lookup("service5");     
        service6 = (Tindakan_Dokter_Service) registry.lookup("service6");
        service7 = (Assessment_Service) registry.lookup("service7");
        service8 = (Detail_Resep_Service) registry.lookup("service8");
//        service9 = (Jadwal_Service) registry.lookup("service9");
        service10 = (Obat_Service) registry.lookup("service10");
//        service11 = (Resep_Service) registry.lookup("service11");
        service12 = (Supplier_Service) registry.lookup("service12");
        service13 = (Tindakan_Periksa_Service) registry.lookup("service13");
        service14 = (Transaksi_Periksa_Service) registry.lookup("service14");
        service15 = (RekamMedik_Service) registry.lookup("service15");
        service16 = (Penyakit_Service )registry.lookup("service16");
        service17 = (lihat_Resep_Service) registry.lookup("service17");
        service18 = (Detail_Lihat_Resep_Service) registry.lookup("service18");
        service19 = (TransaksiObat_Service) registry.lookup("service19");
        service20 = (DetailTransaksiObat_Service) registry.lookup("service20"); 
        service21 = (Penggajian_Service) registry.lookup("service21");
        service22 = (Pemesanan_Obat_Service) registry.lookup("service22");
        service23 = (Presensi_Service) registry.lookup("service23");
        service24 = (List_PO_Service) registry.lookup("service24");
    }
            
            
    public boolean ValidateLogin() throws RemoteException, NotBoundException {
        username = nama.getText();       
        nama.setBackground(Color.white);
        pass.setBackground(Color.white);
        String password = getPassword();        
        service1 = (Petugas_Service) registry.lookup("service1");        
        service2 = (Dokter_Service) registry.lookup("service2");  
        if(!username.equals("")&&password.length()>0){
            p = service1.getPetugas(username,password);
            if(p==null){
                d = service2.getDokter(username,password);
                if(d==null){
                    if(service1.getPetugas(username)!=null||service2.getDokter(username)!=null){
                        pass.setBackground(Color.red);
                        jLabel7.setVisible(true);
                        
                    }
                    else {
                        if(username.equals("absensi")&&password.equals("absensi")){
                            absensi=true;
                            return true;        
                        }
                        else{
                        nama.setBackground(Color.red);
                        pass.setBackground(Color.red);
                        jLabel7.setVisible(true);                        
                        jLabel8.setVisible(true);
                        
                    JOptionPane.showMessageDialog(null, "Mohon masukkan username dan password dengan benar", "ERROR",JOptionPane.ERROR_MESSAGE);
                                     
                        return false;        
                        }                        
                    }               
                }
                else{
                    aktorIniDokter = true;
                    return true;
                }                
            }
            else{
                jabatan = p.getJabatan();
                return true;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Ada field yang kosong. Mohon masukkan username dan password dengan benar", "ERROR",JOptionPane.ERROR_MESSAGE);            
            if(username.equals("")){
                System.out.println("masuk");
                nama.setBackground(Color.red);                
                jLabel8.setVisible(true);     
            }
            if(password.length()==0){
                pass.setBackground(Color.red);
                jLabel7.setVisible(true);     
            }
            return false;            
        }
        return false;
    }
    
    private void StartGUI(){
         try {
             if(ValidateLogin()){
                startRegistry(); 
                if(aktorIniDokter)   {
                    GUI_Dokter panggil = new GUI_Dokter(d,this);
                    panggil.show();
                    this.dispose();
                }   
                else{
                   if (absensi) {
                       GUI_Presensi panggil = new GUI_Presensi(this);
                       panggil.show();
                       this.dispose();
                   }
                   else if(jabatan.equalsIgnoreCase("kasir"))   {
                       GUI_Kasir panggil = new GUI_Kasir(p,this);
                       panggil.show();
                       this.dispose();
                   }
                   else if(jabatan.equalsIgnoreCase("apoteker"))   {
                        GUI_Apoteker panggil = new GUI_Apoteker (p,this);
                        panggil.show();
                        this.dispose();
                   }
                   else if(jabatan.equalsIgnoreCase("perawat"))   {
                        GUI_StafKlinik panggil = new GUI_StafKlinik (p,this);
                        panggil.show();
                        this.dispose();
                   }           
                   else if(jabatan.equalsIgnoreCase("staf klinik"))   {
                        GUI_StafKlinik panggil = new GUI_StafKlinik(p,this);
                        panggil.show();
                        this.dispose();
                   } 
                   
                   
                   else if(jabatan.equalsIgnoreCase("Admin"))   {
                        GUI_Admin panggil = new GUI_Admin(p,this);
                        panggil.show();
                        this.dispose();
                   }
                   
                } 
             }
          } catch (RemoteException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          } catch (NotBoundException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
}
        
    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
        StartGUI();
    }//GEN-LAST:event_masukActionPerformed

    
    public Color getColorNama(){
        return nama.getBackground();
    }
            
    public Color getColorPass(){
        return pass.getBackground();
    }
    
    public boolean getBooleanjLabel7(){
        return jLabel7.isVisible();
    }
    
    public boolean getBooleanjLabel8(){
        return jLabel8.isVisible();
    }
    
    public String getPassword(){
        char[] password = pass.getPassword();
        StringBuilder b = new StringBuilder();
        b.append(password,0,password.length);     
        return b.toString();
    }
    
    public void setUsernamePassword(String Username, String password){
        nama.setText(Username);
        pass.setText(password);
        System.out.println(Username);
        System.out.println(password);
    }
    
    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
        StartGUI();
    }//GEN-LAST:event_namaActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
        StartGUI();
    }//GEN-LAST:event_passActionPerformed

    private void passCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_passCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_passCaretPositionChanged

    private void passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passMousePressed

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        // TODO add your handling code here:
        pass.setBackground(Color.WHITE);
        jLabel7.setVisible(false);
        pass.setText("");
    }//GEN-LAST:event_passMouseClicked

    private void namaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namaMouseClicked
        // TODO add your handling code here:
        nama.setBackground(Color.WHITE);
        jLabel8.setVisible(false);
    }//GEN-LAST:event_namaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Setting s = new Setting(this);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    
//    
//    /**
//     * @param args the command line arguments
//     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }
     
    
    
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton masuk;
    public javax.swing.JTextField nama;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables


    
}