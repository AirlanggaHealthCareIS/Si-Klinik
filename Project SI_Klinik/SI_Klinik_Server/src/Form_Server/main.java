
package Form_Server;
import ServerApplication.Service.Petugas_Server;
import ServerApplication.Service.Dokter_Server;
import ServerApplication.Service.Pasien_Server;
import ServerApplication.Service.Pendaftaran_Server;
import ServerApplication.Service.Laporan_Keuangan_Server;
import ServerApplication.Service.Obat_Server;
import ServerApplication.Service.Resep_Server;
import ServerApplication.Service.Lihat_Resep_Server;
import ServerApplication.Service.Detail_Lihat_Resep_Server;
import ServerApplication.Service.Supplier_Server;
import si_klinik_server.DatabaseUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Jessica
 */
public class main {
    Registry server;


    public void start() throws RemoteException {
        Registry server = LocateRegistry.createRegistry(9750);
        
        /*
         TEMAN-TEMAN, TOLONG JANGAN NGERUBAH CODINGAN INI YA. 
         * KALIAN BOLEH NAMBAH, TAPI TOLONG JANGAN DIGANTI MENDING KALIAN NGUBAH DI FORM KALIAN :)
         * TERIMA KASIH :D
         */
        Petugas_Server petugasServer= new Petugas_Server();
        Dokter_Server dokterServer= new Dokter_Server();
        Pendaftaran_Server pendaftaranServer = new Pendaftaran_Server();
        Pasien_Server pasienServer = new Pasien_Server();
        Laporan_Keuangan_Server laporanServer = new Laporan_Keuangan_Server();
        Resep_Server resepServer= new Resep_Server();
        Obat_Server obatServer= new Obat_Server();
        Lihat_Resep_Server lihatResepServer= new Lihat_Resep_Server();
        Detail_Lihat_Resep_Server detailLihatResepServer = new Detail_Lihat_Resep_Server();
        Supplier_Server supplierServer = new Supplier_Server();
        
        server.rebind("service1",   petugasServer);
        server.rebind("service2",   dokterServer);
        server.rebind("service3",   pendaftaranServer);
        server.rebind("service4", pasienServer);
        server.rebind("service5", laporanServer);
        server.rebind("service6", supplierServer);
        server.rebind("service7", resepServer);
        server.rebind("service8", obatServer);
        server.rebind("service9", lihatResepServer);
        server.rebind("service10", detailLihatResepServer);
        
        
        
        System.out.println("Server Berhasil Tersambung");
    }
    public void stop(Registry server) throws RemoteException, NotBoundException{      
        System.out.println("Server Terputus");
        server = null;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
}
