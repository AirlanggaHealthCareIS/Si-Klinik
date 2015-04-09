
package Form_Server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessia
 */
public class FormConnected extends javax.swing.JFrame {
    main m;
  
    /**
     * Creates new form FormConnected
     */
    public FormConnected() {
        super("SERVER");
        initComponents();
        setJam(Waktu);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        Connected = new javax.swing.JButton();
        Waktu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Status   :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 80, 90, 30);

        Status.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPanel1.add(Status);
        Status.setBounds(140, 80, 190, 30);

        Connected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/tower.png"))); // NOI18N
        Connected.setText("Connected");
        Connected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Connected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Connected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectedActionPerformed(evt);
            }
        });
        jPanel1.add(Connected);
        Connected.setBounds(130, 130, 130, 100);

        Waktu.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Waktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Waktu);
        Waktu.setBounds(200, 20, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectedActionPerformed
       m = new main();
        try {
            m.start();
            Connected.setEnabled(false);
            Status.setText("Connected");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal");
        }
    }//GEN-LAST:event_ConnectedActionPerformed
 
    
    
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
            java.util.logging.Logger.getLogger(FormConnected.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConnected.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConnected.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConnected.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConnected().setVisible(true);
            }
        });
    }
    public void setJam(final JLabel tampilJam) {
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Calendar cal = new GregorianCalendar();
        String nolJam = "";
        String nolMenit = "";
        String nolDetik = "";
        String nolTanggal = "";
        String nolBulan = "";
        String nolTahun = "";
        
        // Membuat Date
        Date dt = new Date();
        
        // Mengambil nilai JAM, MENIT, dan DETIK Sekarang
        int nilaiJam = dt.getHours();
        int nilaiMenit = dt.getMinutes();
        int nilaiDetik = dt.getSeconds();
        int nilaiTanggal = cal.get(Calendar.DAY_OF_MONTH);
        int nilaiBulan = cal.get(Calendar.MONTH);
        int nilaiTahun = cal.get(Calendar.YEAR);
        
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilaiJam <= 9) {
          // Tambahkan "0" didepannya
          nolJam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilaiMenit <= 9) {
          // Tambahkan "0" didepannya
          nolMenit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilaiDetik <= 9) {
          // Tambahkan "0" didepannya
          nolDetik = "0";
        }
        if (nilaiTanggal<10){
            nolTanggal="0";
        }
        if ((nilaiBulan+1)<10){
            nolBulan="0";
        }
        if (nilaiTahun<10){
            nolTahun="0";
        }
        
        // Membuat String JAM, MENIT, DETIK
        String jam = nolJam + Integer.toString(nilaiJam);
        String menit = nolMenit + Integer.toString(nilaiMenit);
        String detik = nolDetik + Integer.toString(nilaiDetik);
        String tanggal = nolTanggal + Integer.toString(nilaiTanggal);
        String bulan = nolBulan + Integer.toString(nilaiBulan+1);
        String tahun = nolTahun + Integer.toString(nilaiTahun);
        
        // Menampilkan pada Layar
        tampilJam.setText(jam+":"+menit+":"+detik);
      }
      
    };
    // Timer
    new Timer(1000, taskPerformer).start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connected;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Waktu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
