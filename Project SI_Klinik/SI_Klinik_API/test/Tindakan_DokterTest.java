/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import database.entity.Tindakan_Dokter;
import database.entity.petugas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Acer
 */
public class Tindakan_DokterTest {
     Tindakan_Dokter p;
    public Tindakan_DokterTest() {
    p = new Tindakan_Dokter ();    
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
    public void testSetGetId_Tindakan_Dokter() {
        String id_Tindakan_Dokter = "TD001";
        p.setId_Tindakan_Dokter(id_Tindakan_Dokter);
        assertEquals(id_Tindakan_Dokter, p.getId_Tindakan_Dokter());
    
    }


    @Test
    public void testSetGetTindakan_Dokter() {
        String Tindakan_Dokter = "infus pasang";
        p.setTindakan_Dokter(Tindakan_Dokter);
        assertEquals (Tindakan_Dokter, p.getTindakan_Dokter());
    }

    @Test
    public void testSetGetBiaya_Tindakan_Dokter() {
        int Biaya_Tindakan_Dokter = 40000;
        p.setBiaya_Tindakan_Dokter(Biaya_Tindakan_Dokter);
        assertEquals (Biaya_Tindakan_Dokter, p.getBiaya_Tindakan_Dokter());
    
    }
}
