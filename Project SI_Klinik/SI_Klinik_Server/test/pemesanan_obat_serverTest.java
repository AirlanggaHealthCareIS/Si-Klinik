/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ServerApplication.Service.pemesanan_obat_server;
import database.entity.Pemesanan_Obat;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alif
 */
public class pemesanan_obat_serverTest {
    
    public pemesanan_obat_serverTest() {
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
     * Test of insertPemesananObat method, of class pemesanan_obat_server.
     */
    @Test
    public void testInsertPemesananObat() throws Exception {
        System.out.println("insertPemesananObat");
        Pemesanan_Obat PO = new Pemesanan_Obat();
        pemesanan_obat_server POserver = new pemesanan_obat_server();
        PO.setId_Pemesnan_obat("PO5");
        PO.setId_supplier("SUP004");
        PO.setTgl_Pemesanan("2015-05-21");
        POserver.insertPemesananObat(PO);
        Pemesanan_Obat output = POserver.getLastPO();
        Pemesanan_Obat target = PO;
        assertEquals(target.getId_Pemesanan_obat(), output.getId_Pemesanan_obat());
        assertEquals(target.getId_supplier(), output.getId_supplier());
        assertEquals(target.getTgl_Pemesanan(), output.getTgl_Pemesanan());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPO method, of class pemesanan_obat_server.
     */
    @Test
    public void testGetPO() throws Exception {
        System.out.println("getPO");
        pemesanan_obat_server POS = new pemesanan_obat_server();
        List<Pemesanan_Obat> output = POS.getPO();
        List<Pemesanan_Obat> target = new ArrayList<Pemesanan_Obat>();
        Pemesanan_Obat PO = new Pemesanan_Obat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
