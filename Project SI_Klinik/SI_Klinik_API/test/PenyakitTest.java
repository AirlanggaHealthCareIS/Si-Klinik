/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.Penyakit;
import database.Service.Penyakit_Service;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class PenyakitTest {
   Penyakit pen;
    public PenyakitTest() {
        pen = new Penyakit();
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
     * Test of getId_Penyakit method, of class Penyakit.
     */
    @Test
    public void testGetId_Penyakit() {
        String id_penyakit = "P-1";
        pen.setId_Penyakit(id_penyakit);
        assertEquals(id_penyakit,pen.getId_Penyakit());
    }

    

    /**
     * Test of getNama_Penyakit method, of class Penyakit.
     */
    @Test
    public void testGetNama_Penyakit() {
       String nama_penyakit = "Ablasio Retina";
        pen.setNama_Penyakit(nama_penyakit);
        assertEquals(nama_penyakit,pen.getNama_Penyakit());
    }

    
}
