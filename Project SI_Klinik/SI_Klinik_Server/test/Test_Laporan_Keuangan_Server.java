/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import database.entity.Laporan_Keuangan;
import ServerApplication.Service.Laporan_Keuangan_Server;
import database.Service.Laporan_Keuangan_Service;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
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
public class Test_Laporan_Keuangan_Server{
    Laporan_Keuangan_Server lk;

    public Test_Laporan_Keuangan_Server() {
        try {
            lk = new Laporan_Keuangan_Server();
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Server_Login.class.getName()).log(Level.SEVERE, null, ex);
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
     * Test of getLaporanKeuangan method, of class Laporan_Keuangan_Server.
     */
    
    @Test
    public void insertPengeluaran() throws Exception{
        String tanggal1 = "2015-04-01";
        Laporan_Keuangan_Server lkServer = new Laporan_Keuangan_Server();
        Laporan_Keuangan lk = new Laporan_Keuangan();
            
        lk.setTanggal("2015-06-08");
        lk.setId("GD201568");
        lk.setPengeluaran(100000);
        lk.setSaldo(2404000);
        lk.setFlag(2);

        lkServer.insertPengeluaran(lk);
        Laporan_Keuangan output = lkServer.getPengeluaranAwal(tanggal1);
        Laporan_Keuangan target = lk;

            assertEquals(target.getTanggal(), output.getTanggal());
            assertEquals(target.getId(), output.getId());
            assertEquals(target.getPengeluaran(), output.getPengeluaran());
            assertEquals(target.getSaldo(), output.getSaldo());
            assertEquals(target.getFlag(), output.getFlag());
    }
    
    @Test
    public void testGetLaporanKeuangan_String_String() throws Exception {
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-05";

        List<Laporan_Keuangan> output = lk.getLaporanKeuangan(tanggal1, tanggal2);
        List<Laporan_Keuangan> target = new ArrayList<>();
        Laporan_Keuangan ambil = new Laporan_Keuangan();
        ambil.setTanggal("2015-04-01");
        ambil.setRef("O-1");
        ambil.setPemasukan(150000);
        ambil.setSaldo(2554000);
        ambil.setFlag(3);
        target.add(ambil);

        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
            assertEquals(target.get(i).getRef(), output.get(i).getRef());
            assertEquals(target.get(i).getPemasukan(), output.get(i).getPemasukan());
            assertEquals(target.get(i).getSaldo(), output.get(i).getSaldo());
            assertEquals(target.get(i).getFlag(), output.get(i).getFlag());
        }
    }
    
    @Test
    public void testGetSaldoAwal() throws Exception {
        String tanggal1 = "2015-04-01";
        int saldo;
        Laporan_Keuangan output = lk.getSaldoAwal(tanggal1);
        Laporan_Keuangan ambil = new Laporan_Keuangan();
        ambil.setTanggal("2015-03-25");
        ambil.setRef("B-1");
        ambil.setPemasukan(100000);
        ambil.setSaldo(2404000);
        ambil.setFlag(2);

        assertEquals(ambil.getTanggal(), output.getTanggal());
        assertEquals(ambil.getRef(), output.getRef());
        assertEquals(ambil.getPemasukan(), output.getPemasukan());
        assertEquals(ambil.getSaldo(), output.getSaldo());
        assertEquals(ambil.getFlag(), output.getFlag());
    }
    
    @Test
    public void testGetPengeluaranAwal() throws Exception {
        String tanggal1 = "2015-03-25";
        int saldo;
        Laporan_Keuangan output = lk.getPengeluaranAwal(tanggal1);
        Laporan_Keuangan ambil = new Laporan_Keuangan();
        ambil.setTanggal("2015-03-25");
        ambil.setRef("B-1");
        ambil.setPemasukan(100000);
        ambil.setSaldo(2404000);
        ambil.setFlag(2);

        assertEquals(ambil.getTanggal(), output.getTanggal());
        assertEquals(ambil.getRef(), output.getRef());
        assertEquals(ambil.getPemasukan(), output.getPemasukan());
        assertEquals(ambil.getSaldo(), output.getSaldo());
        assertEquals(ambil.getFlag(), output.getFlag());
    }
}
