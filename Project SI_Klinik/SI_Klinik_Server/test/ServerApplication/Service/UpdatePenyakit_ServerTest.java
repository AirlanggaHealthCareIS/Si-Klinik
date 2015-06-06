/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.entity.Penyakit;
import java.util.List;
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
public class UpdatePenyakit_ServerTest {
    
    public UpdatePenyakit_ServerTest() {
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
     * Test of insertPenyakit method, of class Penyakit_Server.
     */
    
    /**
     * Test of updatePenyakit method, of class Penyakit_Server.
     */
    @Test
    public void testUpdatePenyakit() throws Exception {
        Penyakit_Server  penS = new Penyakit_Server();
        Penyakit output;
        Penyakit target = new Penyakit();
        target.setId_Penyakit(7);
        target.setNama_Penyakit("Akal-akalan");
        penS.updatePenyakit(target);
        output = penS.getPenyakitID(7);
        assertEquals(target.getId_Penyakit(), output.getId_Penyakit());
        assertEquals(target.getNama_Penyakit(), output.getNama_Penyakit());
    }

    /**
     * Test of getPenyakitAll method, of class Penyakit_Server.
     */
    
    /**
     * Test of getLastPenyakit method, of class Penyakit_Server.
     */
    
}
