/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Supplier_Server;
import database.entity.Supplier;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import junit.framework.TestCase;

/**
 *
 * @author user
 */
public class Test_Tambah_Data_Supplier_Server extends TestCase {
    Supplier_Server ss ;
        
    public Test_Tambah_Data_Supplier_Server() throws RemoteException {
        ss = new Supplier_Server();
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
    public void testGetSupplier(){
        try {Supplier_Server suppServer = new Supplier_Server();
            List<Supplier> output = suppServer.getSupliers();
            List<Supplier> target = new ArrayList<Supplier>();
            Supplier s = new Supplier();
            s.setId_Supplier("SUP001");
            s.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUSTR");
            s.setAlamat_Supplier("JL . LEUWI GAJAH NO. 100 CIMINDI ");
            s.setKota_Supplier("CIMAHI");
            s.setTelepon_Supplier("0318969078");
            s.setNPWP_Supplier("34.129.035.1-601.000");
            s.setJenis_pajak_Supplier("PPH PASAL 22 FARMASI");
            s.setKode_Pajak_Supplier("PAJAKFAR2");
            target.add(s);
            for (int i = 0; i < output.size(); i++) {
                assertEquals(target.get(i).getId_Supplier(), output.get(i).getId_Supplier());
                assertEquals(target.get(i).getNama_Supplier(), output.get(i).getNama_Supplier());
                assertEquals(target.get(i).getAlamat_Supplier(), output.get(i).getAlamat_Supplier());
                assertEquals(target.get(i).getKota_Supplier(), output.get(i).getKota_Supplier());
                assertEquals(target.get(i).getTelepon_Supplier(), output.get(i).getTelepon_Supplier());
                assertEquals(target.get(i).getNPWP_Supplier(), output.get(i).getNPWP_Supplier());
                assertEquals(target.get(i).getJenis_pajak_Supplier(), output.get(i).getJenis_pajak_Supplier());
                assertEquals(target.get(i).getKode_Pajak_Supplier(), output.get(i).getKode_Pajak_Supplier());
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Tambah_Data_Supplier_Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Test
    public void testGetLastSupplier(){
        try {
            Supplier_Server suppServer = new Supplier_Server();
            Supplier output = suppServer.getLastSupplier();           
            Supplier target = new Supplier();
            target.setId_Supplier("SUP001");
            target.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUSTR");
            target.setAlamat_Supplier("JL . LEUWI GAJAH NO. 100 CIMINDI ");
            target.setKota_Supplier("CIMAHI");
            target.setTelepon_Supplier("0318969078");
            target.setNPWP_Supplier("34.129.035.1-601.000");
            target.setJenis_pajak_Supplier("PPH PASAL 22 FARMASI");
            target.setKode_Pajak_Supplier("PAJAKFAR2");
            
            
                assertEquals(target.getId_Supplier(), output.getId_Supplier());
                assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
                assertEquals(target.getAlamat_Supplier(), output.getAlamat_Supplier());
                assertEquals(target.getKota_Supplier(), output.getKota_Supplier());
                assertEquals(target.getTelepon_Supplier(), output.getTelepon_Supplier());
                assertEquals(target.getNPWP_Supplier(), output.getNPWP_Supplier());
                assertEquals(target.getJenis_pajak_Supplier(), output.getJenis_pajak_Supplier());
                assertEquals(target.getKode_Pajak_Supplier(), output.getKode_Pajak_Supplier());
            
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Tambah_Data_Supplier_Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     public void testInsertSupplier(){
        try {Supplier_Server suppServer = new Supplier_Server();
            Supplier s = new Supplier();
            s.setId_Supplier("SUP001");
            s.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUSTR");
            s.setAlamat_Supplier("JL . LEUWI GAJAH NO. 100 CIMINDI ");
            s.setKota_Supplier("CIMAHI");
            s.setTelepon_Supplier("0318969078");
            s.setNPWP_Supplier("34.129.035.1-601.000");
            s.setJenis_pajak_Supplier("PPH PASAL 22 FARMASI");
            s.setKode_Pajak_Supplier("PAJAKFAR2");
            suppServer.insertSupplier(s);
            Supplier output=suppServer.getLastSupplier();
            Supplier target=s;
                assertEquals(target.getId_Supplier(), output.getId_Supplier());
                assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
                assertEquals(target.getAlamat_Supplier(), output.getAlamat_Supplier());
                assertEquals(target.getKota_Supplier(), output.getKota_Supplier());
                assertEquals(target.getTelepon_Supplier(), output.getTelepon_Supplier());
                assertEquals(target.getNPWP_Supplier(), output.getNPWP_Supplier());
                assertEquals(target.getJenis_pajak_Supplier(), output.getJenis_pajak_Supplier());
                assertEquals(target.getKode_Pajak_Supplier(), output.getKode_Pajak_Supplier());
            
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Tambah_Data_Supplier_Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
