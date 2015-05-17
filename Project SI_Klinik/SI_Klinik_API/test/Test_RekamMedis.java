/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.Rekam_Medis;
import database.entity.dokter;
import database.entity.petugas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JESSICA
 */
public class Test_RekamMedis {
    Rekam_Medis r;
    
    public Test_RekamMedis() {
        r = new Rekam_Medis();
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
    
    @Test
    public void testSetGetIDRekamMedis(){
        String idRekam = "1-1";
        r.setId_Rekam_Medis(idRekam);
        assertEquals(idRekam, r.getId_Rekam_Medis());
    }
    
    @Test
    public void testSetGetIDDokter(){
        String idDokter = "DOK001";
        r.setId_Dokter(idDokter);
        assertEquals(idDokter, r.getId_Dokter());
    }
    
    @Test
    public void testSetGetIDPasien(){
        String idPasien = "1";
        r.setId_Pasien(idPasien);
        assertEquals(idPasien, r.getId_Pasien());
    }
}
