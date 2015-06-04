/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import database.entity.Penggajian;
import database.entity.Laporan_Keuangan;
import ServerApplication.Service.Penggajian_Server;
import ServerApplication.Service.Laporan_Keuangan_Server;
import GUI_StafKlinik.Panel_Penggajian;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows 8.1
 */
public class Test_Panel_Penggajian {
    
    Penggajian p;
    Laporan_Keuangan l;
    Panel_Penggajian panel;
    Penggajian_Server penggajianServer;
    Laporan_Keuangan_Server laporanKeuangan;
    boolean isAdaSaldo;
    
    public Test_Panel_Penggajian() {
        p = new Penggajian();
        l = new Laporan_Keuangan();
        panel = new Panel_Penggajian();
        try {
            penggajianServer = new Penggajian_Server();
            laporanKeuangan = new Laporan_Keuangan_Server();
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tanggalSekarang method, of class Panel_Penggajian.
     */
    @Test
    public void testTanggalSekarang() {
        String tanggalSekarang = "2015-6-4" ;
        assertEquals(panel.tanggalSekarang(), tanggalSekarang);
    }

    /**
     * Test of setGajiNonDokter method, of class Panel_Penggajian.
     */
    @Test
    public void testSetGajiNonDokterIfSaldoTidakCukup() {
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-30";
        
        isAdaSaldo = panel.setGajiNonDokter(tanggal1, tanggal2);
        assertEquals(false, isAdaSaldo);
    }

    /**
     * Test of setGajiDokter method, of class Panel_Penggajian.
     */
    @Test
    public void testSetGajiDokterIfSaldoTidakCukup() {
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-30";
        
        isAdaSaldo = panel.setGajiDokter(tanggal1, tanggal2);
        assertEquals(false, isAdaSaldo);
        
    }
    
//    @Test
//    public void testSetGajiNonDokterIfSaldoCukup() {
//        String tanggal1 = "2015-04-01";
//        String tanggal2 = "2015-04-30";
//        
//        isAdaSaldo = panel.setGajiNonDokter(tanggal1, tanggal2);
//        assertEquals(true, isAdaSaldo);
//        try {
//            Laporan_Keuangan output = laporanKeuangan.getPengeluaranAwal(tanggal1);
//            
//            l.setId("GN201564");
//            l.setTanggal("2015-06-04");
//            l.setPengeluaran(300000);
//            l.setSaldo(2400000);
//            l.setFlag(0);
//
//            laporanKeuangan.insertPengeluaran(l);
//            Laporan_Keuangan target = l;
//            
//            assertEquals(target.getId(), output.getId());
//            assertEquals(target.getTanggal(), output.getTanggal());
//            assertEquals(target.getPengeluaran(), output.getPengeluaran());
//            assertEquals(target.getSaldo(), output.getSaldo());
//            assertEquals(target.getFlag(), output.getFlag());
//            
//        } catch (RemoteException ex) {
//            Logger.getLogger(Test_Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    public void testSetGajiDokterIfSaldoCukup() {
//        String tanggal1 = "2015-04-01";
//        String tanggal2 = "2015-04-30";
//        
//        isAdaSaldo = panel.setGajiDokter(tanggal1, tanggal2);
//        assertEquals(true, isAdaSaldo);
//        try {
//            Laporan_Keuangan output = laporanKeuangan.getPengeluaranAwal(tanggal1);
//            
//            l.setId("GD201566");
//            l.setTanggal("2015-06-04");
//            l.setPengeluaran(300000);
//            l.setSaldo(2400000);
//            l.setFlag(0);
//
//            laporanKeuangan.insertPengeluaran(l);
//            Laporan_Keuangan target = l;
//            
//            assertEquals(target.getId(), output.getId());
//            assertEquals(target.getTanggal(), output.getTanggal());
//            assertEquals(target.getPengeluaran(), output.getPengeluaran());
//            assertEquals(target.getSaldo(), output.getSaldo());
//            assertEquals(target.getFlag(), output.getFlag());
//            
//        } catch (RemoteException ex) {
//            Logger.getLogger(Test_Panel_Penggajian.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
