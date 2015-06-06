/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ServerApplication.Service.Penyakit_Server;
import database.entity.Penyakit;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
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
public class TambahPenyakit_ServerTest {
    Penyakit_Server pen;
    public TambahPenyakit_ServerTest() throws RemoteException {
        pen = new Penyakit_Server();
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
//    @Test
//    public void testInsertPenyakit() throws Exception {
//        
//            Penyakit_Server PenServer = new Penyakit_Server();
//            Penyakit s = new Penyakit();
//            s.setId_Penyakit("34");
//            s.setNama_Penyakit("Asam Lambung");
//            
//            PenServer.insertPenyakit(s);
//            Penyakit output=PenServer.getLastPenyakit();
//            Penyakit target=s;
//                assertEquals(target.getId_Penyakit(), output.getId_Penyakit());
//                assertEquals(target.getNama_Penyakit(), output.getNama_Penyakit());
//                
//         
//    }

   
    @Test
    public void testGetPenyakitAll() throws Exception {
        Penyakit_Server penServer = new Penyakit_Server();
            List<Penyakit> output = penServer.getPenyakitAll();
            List<Penyakit> target = new ArrayList<Penyakit>();
            Penyakit s = new Penyakit();
            s.setId_Penyakit(1);
            s.setNama_Penyakit("Ablasio Retina");
            target.add(s);
            for (int i = 0; i < 1; i++) {
                assertEquals(target.get(i).getId_Penyakit(), output.get(i).getId_Penyakit());
                assertEquals(target.get(i).getNama_Penyakit(), output.get(i).getNama_Penyakit());
            }
    }

    /**
     * Test of getId_Penyakit method, of class Penyakit_Server.
     */
    

    /**
     * Test of getLastPenyakit method, of class Penyakit_Server.
     */
    @Test
    public void testGetLastPenyakit() throws Exception {
            Penyakit_Server penServer = new Penyakit_Server();
            Penyakit output = penServer.getLastPenyakit();
            Penyakit target = new Penyakit();
            target.setId_Penyakit(34);
            target.setNama_Penyakit("Asam Lambung");
            
                assertEquals(target.getId_Penyakit(), output.getId_Penyakit());
                assertEquals(target.getNama_Penyakit(), output.getNama_Penyakit());
    }
    
    @Test
    public void testGetPenyakitID() throws Exception {
        Penyakit_Server penS = new Penyakit_Server();
        Penyakit output  = new Penyakit();
        Penyakit target = new Penyakit();
        int id_penyakit = 4;
        String nama_penyakit = "Abses Tangan";
        
        target.setId_Penyakit(id_penyakit);
        target.setNama_Penyakit(nama_penyakit);
        output = penS.getPenyakitID(id_penyakit);
        
        assertEquals(target.getId_Penyakit(), output.getId_Penyakit());
        assertEquals(target.getNama_Penyakit(), output.getNama_Penyakit());
    }
    
}
