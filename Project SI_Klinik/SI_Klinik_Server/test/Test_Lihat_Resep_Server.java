/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Lihat_Resep_Server;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import database.entity.lihatResep;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tinot
 */
public class Test_Lihat_Resep_Server {
    Lihat_Resep_Server ls ;
    
    public Test_Lihat_Resep_Server() {
        try {
            ls = new Lihat_Resep_Server();
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Lihat_Resep_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * Test of getLihatResep method, of class Lihat_Resep_Server.
     */
    @Test
    public void testGetLihatResep() throws Exception {
        System.out.println("getLihatResep");
        List<lihatResep> output = ls.getLihatResep();
        List<lihatResep> target = new ArrayList<>();
        lihatResep ambil = new lihatResep();
        ambil.setId_Pasien(1);
        ambil.setId_rekam_medik("2-2");
        ambil.setTanggal("2015-04-28");        
        target.add(ambil);
        
        for (int i = 0; i < output.size(); i++) {
            assertEquals(target.get(i).getId_Pasien(), output.get(i).getId_Pasien());
            assertEquals(target.get(i).getId_rekam_medik(), output.get(i).getId_rekam_medik());
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
        }
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLihatResep method, of class Lihat_Resep_Server.
     */
    @Test
    public void testGetLihatResep_int() throws Exception {
        System.out.println("getLihatResepInt");
        int id = 1;
        List<lihatResep> output = ls.getLihatResep(id);
        List<lihatResep> target = new ArrayList<>();
        lihatResep ambil = new lihatResep();
        ambil.setId_Pasien(id);
        ambil.setId_rekam_medik("2-2");
        ambil.setTanggal("2015-04-28");
        target.add(ambil);
        for (int i = 0; i < output.size(); i++) {
            assertEquals(target.get(i).getId_Pasien(), output.get(i).getId_Pasien());
            assertEquals(target.get(i).getId_rekam_medik(), output.get(i).getId_rekam_medik());
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
        }
//        fail("The test case is a prototype.");
    }
}
