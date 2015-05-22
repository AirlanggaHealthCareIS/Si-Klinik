/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.Presensi;
import database.entity.Presensi;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class PresensiTest {
    Presensi p;
    public PresensiTest() {
        p = new Presensi();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getTanggal_masuk method, of class Presensi.
     */
    @Test
    public void testGetSetTanggal_masuk() {
        System.out.println("getTanggal_masuk");
        String TanggalMasuk = "2015-05-22";
        p.setTanggal_masuk(TanggalMasuk);
        assertEquals(TanggalMasuk, p.getTanggal_masuk());
    }

    /**
     * Test of getJam_masuk method, of class Presensi.
     */
    @Test
    public void testGetSetJam_masuk() {
        System.out.println("getJam_masuk");
        String JamMasuk = "07:01:31";
        p.setJam_masuk(JamMasuk);
        assertEquals(JamMasuk, p.getJam_masuk());
    }


    /**
     * Test of getJam_keluar method, of class Presensi.
     */
    @Test
    public void testGetSetJam_keluar() {
        System.out.println("getJam_keluar");
        String JamKeluar = "16:01:52";
        p.setJam_keluar(JamKeluar);
        assertEquals(JamKeluar, p.getJam_keluar());
    }

    

    /**
     * Test of getId_pegawai method, of class Presensi.
     */
    @Test
    public void testGetSetId_pegawai() {
        System.out.println("getId_pegawai");
        String IdPeg = "PET003";
        p.setId_pegawai(IdPeg);
        assertEquals(IdPeg, p.getId_pegawai());
    }

    

    /**
     * Test of getNama_Pegawai method, of class Presensi.
     */
    @Test
    public void testGetSetNama_Pegawai() {
        System.out.println("getNama_Pegawai");
        String NamaPeg = "YULIASTI";
        p.setNama_Pegawai(NamaPeg);
        assertEquals(NamaPeg, p.getNama_Pegawai());
    }

    

    /**
     * Test of getNama_Dokter method, of class Presensi.
     */
    @Test
    public void testGetSetNama_Dokter() {
        System.out.println("getNama_Dokter");
        String NamaDok = "DR. RETNO WISASTI, S";
        p.setNama_Dokter(NamaDok);
        assertEquals(NamaDok, p.getNama_Dokter());
    }

}
