
package Form_Server;
import ServerApplication.Service.Petugas_Server;
import ServerApplication.Service.Dokter_Server;
import ServerApplication.Service.Resep_Server;
import ServerApplication.Service.Obat_Server;

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
        
        Petugas_Server petugasServer= new Petugas_Server();
        Dokter_Server dokterServer= new Dokter_Server();
        Resep_Server resepServer= new Resep_Server();
        Obat_Server obatServer= new Obat_Server();
        
        server.rebind("service1",   petugasServer);
        server.rebind("service2",   dokterServer);
        server.rebind("service3",   resepServer);
        server.rebind("service4",   obatServer);
        
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
