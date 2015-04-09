
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
import GUI_Apoteker.GUI_Apoteker;
import GUI_Dokter.GUI_Dokter;
import GUI_Kasir.GUI_Kasir;
import GUI_StafKlinik.GUI_StafKlinik;
import database.Service.Petugas_Service;
import database.Service.Dokter_Service;
import database.entity.petugas;
import database.entity.dokter;



      
/**
 * 
 *
 * @author JESSICA
 */
public class Login extends javax.swing.JFrame {
     private Petugas_Service service1;
     private Dokter_Service service2;
      Registry registry;
      public SocketClient client;
      public int port;
      public String serverAddr, username;
      private String jabatan;
      private Thread clientThread;
      private DefaultListModel model;
      private File file;
      private petugas p;
      private dokter d;
      private boolean aktorIniDokter;
      
    /**
     * Creates new form Login
     */
    public Login() throws RemoteException, NotBoundException {        
        super("LOGIN");
        initComponents();  
        p=new petugas();
        d = new dokter();
        aktorIniDokter = false;
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        masuk = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel5.setBounds(350, 260, 80, 30);
        jPanel1.add(nama);
        nama.setBounds(440, 210, 290, 30);

        masuk.setText("LOGIN");
        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        jPanel1.add(masuk);
        masuk.setBounds(500, 340, 90, 30);
        jPanel1.add(pass);
        pass.setBounds(440, 260, 290, 30);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        jLabel6.setText("Sistem Informasi Klinik");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(240, 60, 380, 30);

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel3.setText("SI KLINIK");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(330, 10, 250, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOGIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(510, 140, 120, 40);

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
    
    private boolean startReg() throws RemoteException, NotBoundException {
        username = nama.getText();       
        char[] password = pass.getPassword();
        StringBuilder b = new StringBuilder();
        b.append(password,0,password.length);
        registry = LocateRegistry.getRegistry("0.0.0.0", 9750);        
        service1 = (Petugas_Service) registry.lookup("service1");        
        service2 = (Dokter_Service) registry.lookup("service2");     
        if(username.contentEquals("")||password.length>0){
            p = service1.getPetugas(username,b.toString());
            jabatan = p.getJabatan();
            if(jabatan.equalsIgnoreCase("")){
                d = service2.getDokter(username,b.toString());
                if(d==null){
                    return false;
                }
                else{
                    aktorIniDokter = true;
                    return true;
                }                
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    
    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
        
         try {
             if(startReg()){
                if(aktorIniDokter)   {
                    GUI_Dokter panggil = new GUI_Dokter(d);
                    panggil.show();
                    this.dispose();
                }   
                else{
                   if(jabatan.equalsIgnoreCase("kasir"))   {
                       GUI_Kasir panggil = new GUI_Kasir(p);
                       panggil.show();
                       this.dispose();
                   }
                   else if(jabatan.equalsIgnoreCase("apoteker"))   {
                        GUI_Apoteker panggil = new GUI_Apoteker (p);
                        panggil.show();
                        this.dispose();
                   }
                   else if(jabatan.equalsIgnoreCase("perawat"))   {
                        GUI_StafKlinik panggil = new GUI_StafKlinik (p);
                        panggil.show();
                        this.dispose();
                   }           
                   else if(jabatan.equalsIgnoreCase("staf klinik"))   {
                        GUI_StafKlinik panggil = new GUI_StafKlinik(p);
                        panggil.show();
                        this.dispose();
                   }                 
                } 
             }
             else{
                 JOptionPane.showMessageDialog(null, "Mohon masukkan username dan password dengan benar", "ERROR",JOptionPane.ERROR_MESSAGE);
             }
          } catch (RemoteException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          } catch (NotBoundException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_masukActionPerformed

    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton masuk;
    public javax.swing.JTextField nama;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables


    
}