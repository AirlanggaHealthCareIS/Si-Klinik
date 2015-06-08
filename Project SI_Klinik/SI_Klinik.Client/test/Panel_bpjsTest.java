/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI_StafKlinik.Panel_bpjs;
import database.entity.Transaksi_Periksa;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author win7
 */
public class Panel_bpjsTest {
    
    public Panel_bpjsTest() {
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
     * Test of open method, of class Panel_bpjs.
     */
    @Test
    public void testRefresh() throws RemoteException, NotBoundException {
        Panel_bpjs panel = new Panel_bpjs(9999,"0.0.0.0");
        boolean target = true;
        int bulan = 5;
        boolean output = panel.refresh(bulan);
        assertEquals(target, output);
    }
    
    
    @Test
    public void testRefreshIfNull() throws RemoteException, NotBoundException {
        Panel_bpjs panel = new Panel_bpjs(9999,"0.0.0.0");
        boolean target = true;
        int bulan = 10;
        boolean output = panel.refresh(bulan);
        assertEquals(target, output);
    }
    
    @Test
    public void testCreatePdf (){
        try {
            List<Transaksi_Periksa> list = new ArrayList<>();
            Transaksi_Periksa tp = new Transaksi_Periksa();
            tp.setId_Dokter("DOK001");
            tp.setId_Pasien("1");
            tp.setId_Transaksi_Periksa("TP001");
            tp.setKlaim_BPJS("bpjs");
            tp.setNo_Kartu_Transaksi("01");
            tp.setPPN_Transaksi_Periksa("ppn");
            tp.setSubtotal_Transaksi_Periksa("10000");
            tp.setTanggal_Transaksi_Periksa("2015-08-10");
            tp.setTotal_Transaksi_Periksa("100000");
            list.add(tp);
            Panel_bpjs panel = new Panel_bpjs(9999,"0.0.0.0"); 
            boolean output= panel.createPdf(list);
            boolean expOutput = true;
            assertEquals(expOutput, output);
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_bpjsTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Panel_bpjsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testOpen(){
        try {
            Panel_bpjs panel = new Panel_bpjs (9999,"0.0.0.0");            
            boolean output  = panel.open("D:/document/report1.pdf");
            boolean target = false;
            assertEquals(target, output);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Panel_bpjsTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Panel_bpjsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
