
package Form_Server;
import ServerApplication.Service.Penyakit_Server;
import ServerApplication.Service.Rekam_Medis_Server;
import ServerApplication.Service.Supplier_Server;
import ServerApplication.Service.Tindakan_Dokter_Server;
import ServerApplication.Service.Tindakan_Periksa_Server;
import ServerApplication.Service.Transaksi_Periksa_Server;
import ServerApplication.Service.Assessment_Server;
import ServerApplication.Service.DetailTransaksiObat_Server;
import ServerApplication.Service.Detail_Resep_Server;
import ServerApplication.Service.Dokter_Server;
import ServerApplication.Service.Jadwal_Server;
import ServerApplication.Service.Pasien_Server;
import ServerApplication.Service.Pendaftaran_Server;
import ServerApplication.Service.Laporan_Keuangan_Server;
import ServerApplication.Service.Obat_Server;
import ServerApplication.Service.Lihat_Resep_Server;
import ServerApplication.Service.Detail_Lihat_Resep_Server;
import ServerApplication.Service.Petugas_Server;
import ServerApplication.Service.TransaksiObat_Server;
import ServerApplication.Service.Penggajian_Server;
import ServerApplication.Service.Detail_List_PO_Server;
import ServerApplication.Service.pemesanan_obat_server;
import ServerApplication.Service.Presensi_Server;
import database.Service.Detail_Lihat_Resep_Service;
import database.Service.Detail_Resep_Service;
import database.Service.Pemesanan_Obat_Service;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
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
    int port = 9750;


    public void start() throws RemoteException {
        server = LocateRegistry.createRegistry(port);
        
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
        Tindakan_Dokter_Server tindakanServer = new Tindakan_Dokter_Server();
        Assessment_Server assessmentServer = new Assessment_Server();
//        Jadwal_Server jadwalServer = new Jadwal_Server();                
        Obat_Server obatserver = new Obat_Server();
        Supplier_Server suppServer = new Supplier_Server();
        Tindakan_Periksa_Server tindakanpServer = new Tindakan_Periksa_Server();
        Transaksi_Periksa_Server transaksiServer = new Transaksi_Periksa_Server();
        Rekam_Medis_Server rekamServer = new Rekam_Medis_Server();
        Penyakit_Server penyakitServer = new Penyakit_Server();
        Detail_Resep_Server detailrServer = new Detail_Resep_Server();
        Detail_Lihat_Resep_Server detaillihatresepServer = new Detail_Lihat_Resep_Server();        
        Lihat_Resep_Server lihatresepServer = new Lihat_Resep_Server();       
        TransaksiObat_Server toServer = new TransaksiObat_Server();
        DetailTransaksiObat_Server dtoServer = new DetailTransaksiObat_Server();
        Penggajian_Server gajiServer = new Penggajian_Server();
        pemesanan_obat_server pesanServer = new pemesanan_obat_server();
        Presensi_Server presensiServer = new Presensi_Server();
        Detail_List_PO_Server detailListPO = new Detail_List_PO_Server();
        
        
        server.rebind("service1",   petugasServer);
        server.rebind("service2",   dokterServer);
        server.rebind("service3",   pendaftaranServer);
        server.rebind("service4", pasienServer);
        server.rebind("service5", laporanServer);
        server.rebind("service6", tindakanServer);
        server.rebind("service7", assessmentServer);
        server.rebind("service8", detailrServer);
  //      server.rebind("service9", jadwalServer);
        server.rebind("service10", obatserver);
        server.rebind("service12", suppServer);
        server.rebind("service13", tindakanpServer);
        server.rebind("service14", transaksiServer);
        server.rebind("service15", rekamServer);
        server.rebind("service16", penyakitServer);
        server.rebind("service17", lihatresepServer);
        server.rebind("service18", detaillihatresepServer);
        server.rebind("service19", toServer);
        server.rebind("service20", dtoServer);
        server.rebind("service21", gajiServer);
        server.rebind("service22", pesanServer);
        server.rebind("service23", presensiServer);
        server.rebind("service24", detailListPO);
        
        System.out.println("Server Berhasil Tersambung");
    }
    public void stop() throws RemoteException, NotBoundException{      
        System.out.println("Server Terputus");        
        server = new Registry() {

            @Override
            public Remote lookup(String name) throws RemoteException, NotBoundException, AccessException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void bind(String name, Remote obj) throws RemoteException, AlreadyBoundException, AccessException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void unbind(String name) throws RemoteException, NotBoundException, AccessException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void rebind(String name, Remote obj) throws RemoteException, AccessException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String[] list() throws RemoteException, AccessException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
}
