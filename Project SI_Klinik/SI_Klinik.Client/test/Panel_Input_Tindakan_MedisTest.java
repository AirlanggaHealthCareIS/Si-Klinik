/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI_Dokter.Panel_Input_Tindakan_Medis;
import ServerApplication.Service.Dokter_Server;
import database.Service.Tindakan_Dokter_Service;
import database.Service.Tindakan_Periksa_Service;
import database.Service.Transaksi_Periksa_Service;
import database.entity.dokter;
import database.entity.petugas;
import GUI_Dokter.Panel_Input_Tindakan_Medis;
import database.entity.Tindakan_Dokter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
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
public class Panel_Input_Tindakan_MedisTest {
    Panel_Input_Tindakan_Medis p;
    List<Tindakan_Dokter> list = new ArrayList<Tindakan_Dokter>();
    private Tindakan_Dokter_Service service6;
    
    public Panel_Input_Tindakan_MedisTest() throws RemoteException, NotBoundException {
    
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
     * Test of getTanggal method, of class Panel_Input_Tindakan_Medis.
     */
    @Test
    public void testGetTanggal() {
        System.out.println("getTanggal");
        Panel_Input_Tindakan_Medis instance = new Panel_Input_Tindakan_Medis();
        String tanggal = "2015-05-11";
        String result = instance.getTanggal();
        assertEquals(tanggal, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateTindakanMedis method, of class Panel_Input_Tindakan_Medis.
     */
    @Test
    public void testUpdateTindakanMedis() {
        try {
            System.out.println("updateTindakanMedis");
            list.add(service6.getTindakan_Dokter("INFUS"));
            p.listTindakan_Medis.add("INFUS");
            String expResult= p.listTindakan_Medis.get(0).toString();
            //instance.updateTindakanMedis();
            //fail("The test case is a prototype.");
            assertEquals(expResult, list.get(0).getTindakan_Dokter());
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_Input_Tindakan_MedisTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateLists method, of class Panel_Input_Tindakan_Medis.
     */
//    @Test
//    public void testUpdateLists() {
//        System.out.println("updateLists");
//        JList list = null;
//        Vector a = null;
//        Panel_Input_Tindakan_Medis instance = null;
//        instance.updateLists(list, a);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
