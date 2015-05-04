/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.lihatResep;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class Test_lihatResep {
    lihatResep lr;
    public Test_lihatResep() {
        lr = new lihatResep();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId_Pasien method, of class lihatResep.
     */
    @Test
    public void testGetId_Pasien() {
        int idPasien = 5;
        lr.setId_Pasien(idPasien);
        assertEquals(idPasien, lr.getId_Pasien());
    }

    /**
     * Test of setId_Pasien method, of class lihatResep.
     */
    /**
     * Test of getId_rekam_medik method, of class lihatResep.
     */
    @Test
    public void testGetId_rekam_medik() {
        String idRekamMedik = "rk01";
        lr.setId_rekam_medik(idRekamMedik);
        assertEquals(idRekamMedik, lr.getId_rekam_medik());
    }

    /**
     * Test of setId_rekam_medik method, of class lihatResep.
     */
    /**
     * Test of getId_resep method, of class lihatResep.
     */
    @Test
    public void testGetId_resep() {
        String idResep = "RES01";
        lr.setId_resep(idResep);
        assertEquals(idResep, lr.getId_resep());
    }

    /**
     * Test of setId_resep method, of class lihatResep.
     */
    /**
     * Test of getTanggal method, of class lihatResep.
     */
    @Test
    public void testGetTanggal() {
        String tanggal = "2015-04-27";
        lr.setTanggal(tanggal);
        assertEquals(tanggal, lr.getTanggal());
    }

    /**
     * Test of setTanggal method, of class lihatResep.
     */
}