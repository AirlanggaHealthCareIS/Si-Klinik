/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.detail_lihat_resep;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class Test_detail_lihat_resep {
    detail_lihat_resep dlr;
    public Test_detail_lihat_resep() {
        dlr = new detail_lihat_resep();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId_Pasien method, of class detail_lihat_resep.
     */
    @Test
    public void testGetId_Pasien() {
        int idPasien = 5;
        dlr.setId_Pasien(idPasien);
        assertEquals(idPasien, dlr.getId_Pasien());
    }

    /**
     * Test of setId_Pasien method, of class detail_lihat_resep.
     */

    /**
     * Test of getTanggal method, of class detail_lihat_resep.
     */
    @Test
    public void testGetTanggal() {
        String tanggal = "2015-04-27";
        dlr.setTanggal(tanggal);
        assertEquals(tanggal, dlr.getTanggal());
    }

    /**
     * Test of setTanggal method, of class detail_lihat_resep.
     */
    /**
     * Test of getNama_Dokter method, of class detail_lihat_resep.
     */
    @Test
    public void testGetNama_Dokter() {
        String namaDokter = "DR. I NYOMAN ADNYANA";
        dlr.setNama_Dokter(namaDokter);
        assertEquals(namaDokter, dlr.getNama_Dokter());
    }

    /**
     * Test of setNama_Dokter method, of class detail_lihat_resep.
     */
    /**
     * Test of getNama_Pasien method, of class detail_lihat_resep.
     */
    @Test
    public void testGetNama_Pasien() {
        String namaPasien = "DEWI";
        dlr.setNamaPasien(namaPasien);
        assertEquals(namaPasien, dlr.getNama_Pasien());
    }

    /**
     * Test of setNamaPasien method, of class detail_lihat_resep.
     */
    /**
     * Test of getQty method, of class detail_lihat_resep.
     */
    @Test
    public void testGetQty() {
        int qty = 6;
        dlr.setQty(qty);
        assertEquals(qty, dlr.getQty());
    }

    /**
     * Test of setQty method, of class detail_lihat_resep.
     */
    /**
     * Test of getObat method, of class detail_lihat_resep.
     */
    @Test
    public void testGetObat() {
        String namaObat = "BATUK";
        dlr.setObat(namaObat);
        assertEquals(namaObat, dlr.getObat());
    }

    /**
     * Test of setObat method, of class detail_lihat_resep.
     */
    /**
     * Test of getIdObat method, of class detail_lihat_resep.
     */
    @Test
    public void testGetIdObat() {
        String idObat = "OBT01";
        dlr.setIdObat(idObat);
        assertEquals(idObat, dlr.getIdObat());
    }

    /**
     * Test of setIdObat method, of class detail_lihat_resep.
     */
}