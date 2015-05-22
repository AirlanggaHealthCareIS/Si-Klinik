/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI_Presensi.GUI_Presensi;
import java.rmi.RemoteException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class GUI_PresensiTest {
    
    public GUI_PresensiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getTanggal method, of class GUI_Presensi.
     */
    @Test
    public void testGetTanggal() throws RemoteException {
        System.out.println("getTanggal");
        GUI_Presensi instance = new GUI_Presensi();
        String expResult = "";
        String result = instance.getTanggal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTanggalView method, of class GUI_Presensi.
     */
    @Test
    public void testGetTanggalView() throws RemoteException {
        System.out.println("getTanggalView");
        GUI_Presensi instance = new GUI_Presensi();
        String expResult = "";
        String result = instance.getTanggalView();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTime method, of class GUI_Presensi.
     */
    @Test
    public void testGetTime() throws RemoteException {
        System.out.println("getTime");
        GUI_Presensi instance = new GUI_Presensi();
        String expResult = "";
        String result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class GUI_Presensi.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GUI_Presensi.main(args);
    }
}
