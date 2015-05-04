/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import database.entity.Transaksi_Periksa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author win7
 */
public class Transaksi_PeriksaTest {
    Transaksi_Periksa p;
    public Transaksi_PeriksaTest() {
        p = new Transaksi_Periksa();
                
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
     * Test of getId_Transaksi_Periksa method, of class Transaksi_Periksa.
     */
    @Test
    public void testSetGetId_Transaksi_Periksa() {
        String idtransaksiperiksa="1";
       p.setId_Transaksi_Periksa(idtransaksiperiksa);
       assertEquals(idtransaksiperiksa, p.getId_Transaksi_Periksa());
       
    }

    
    @Test
    public void testSetGetId_Dokter() {
        String iddokter="DOK002";
        p.setId_Dokter(iddokter);
        assertEquals(iddokter, p.getId_Dokter());
        
    }
    @Test
    public void testSetGetId_Pasien() {
       String idpasien="0";
       p.setId_Pasien(idpasien);
      assertEquals(idpasien, p.getId_Pasien());
    }

    
    @Test
    public void testSetGetSubtotal_Transaksi_Periksa() {
        String subtotal="100000";
        p.setSubtotal_Transaksi_Periksa(subtotal);
        assertEquals(subtotal, p.getSubtotal_Transaksi_Periksa());
    }

   
   
    @Test
    public void testSetGetPPN_Transaksi_Periksa() {
        String ppntransaksi="10000";
        p.setPPN_Transaksi_Periksa(ppntransaksi);
        assertEquals(ppntransaksi, p.getPPN_Transaksi_Periksa());
        
        
    }

   
    @Test
    public void testSetGetTotal_Transaksi_Periksa() {
         String totaltransaksi="110000";
        p.setTotal_Transaksi_Periksa(totaltransaksi);
        assertEquals(totaltransaksi, p.getTotal_Transaksi_Periksa());
        
    }

    
    @Test
    public void testSetGetKlaim_BPJS() {
        String klaimbpjs="0";
        p.setKlaim_BPJS(klaimbpjs);
        assertEquals(klaimbpjs, p.getKlaim_BPJS());
        
    }

  
    @Test
    public void testSetGetNo_Kartu_Transaksi() {
        String nokartu="1011";
        p.setNo_Kartu_Transaksi(nokartu);
        assertEquals(nokartu, p.getNo_Kartu_Transaksi());
        
    }

    
    public void testGetTanggal_Transaksi_Periksa() {
        String tanggal="2015-04-10";
        p.setTanggal_Transaksi_Periksa(tanggal);
        assertEquals(tanggal, p.getTanggal_Transaksi_Periksa());
    }
}
