
import ServerApplication.Service.Transaksi_Periksa_Server;
import database.entity.Transaksi_Periksa;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Indyka
 */
public class Test_Transaksi_Periksa_Server extends TestCase{
    
    
    Registry registry;
    Transaksi_Periksa_Server tps;
    
    public Test_Transaksi_Periksa_Server(String name) throws RemoteException, NotBoundException {
        super(name);
    }
    
    public Test_Transaksi_Periksa_Server() throws RemoteException, NotBoundException {        
    }

    @BeforeClass
    public static void server() throws RemoteException, NotBoundException {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws RemoteException {   
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test    
    public void testIfCekTagihanTrue() throws RemoteException, NotBoundException{
        
        tps = new Transaksi_Periksa_Server();
        String id_pasien = "0";
        List<Transaksi_Periksa> output = tps.getTransaksis(id_pasien);
        List<Transaksi_Periksa> target = new ArrayList<Transaksi_Periksa>();
        Transaksi_Periksa x = new Transaksi_Periksa();
        x.setId_Dokter("DOK002");
        x.setId_Pasien("0");
        x.setId_Transaksi_Periksa("1");
        x.setKlaim_BPJS("0");
        x.setNo_Kartu_Transaksi(null);
        x.setPPN_Transaksi_Periksa("10000");
        x.setSubtotal_Transaksi_Periksa("100000");
        x.setTanggal_Transaksi_Periksa("2015-04-10");
        x.setTotal_Transaksi_Periksa("110000");
        target.add(x);
        for (int i = 0; i < 1; i++) {
            assertEquals(target.get(i).getId_Dokter(), output.get(i).getId_Dokter());
            assertEquals(target.get(i).getId_Pasien(), output.get(i).getId_Pasien());
            assertEquals(target.get(i).getId_Transaksi_Periksa(), output.get(i).getId_Transaksi_Periksa());
            assertEquals(target.get(i).getKlaim_BPJS(), output.get(i).getKlaim_BPJS());
            assertEquals(target.get(i).getNo_Kartu_Transaksi(), output.get(i).getNo_Kartu_Transaksi());
            assertEquals(target.get(i).getPPN_Transaksi_Periksa(), output.get(i).getPPN_Transaksi_Periksa());
            assertEquals(target.get(i).getSubtotal_Transaksi_Periksa(), output.get(i).getSubtotal_Transaksi_Periksa());
            assertEquals(target.get(i).getTanggal_Transaksi_Periksa(), output.get(i).getTanggal_Transaksi_Periksa());
            assertEquals(target.get(i).getTotal_Transaksi_Periksa(), output.get(i).getTotal_Transaksi_Periksa());
        }  
        
    }
    
}
