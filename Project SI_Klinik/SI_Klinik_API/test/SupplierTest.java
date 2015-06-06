/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.Supplier;
import database.entity.Supplier;
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
public class SupplierTest {
    Supplier sup;
    
    public SupplierTest() {
        sup = new Supplier();
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
     * Test of getId_Supplier method, of class Supplier.
     */
    @Test
    public void testGetId_Supplier() {
        String id_supplier = "SUP001";
        sup.setId_Supplier(id_supplier);
        assertEquals(id_supplier,sup.getId_Supplier());
    }

    /**
     * Test of setId_Supplier method, of class Supplier.
     */
    

    /**
     * Test of getAlamat_Supplier method, of class Supplier.
     */
    @Test
    public void testGetAlamat_Supplier() {
        String Alm_supplier = "JL . LEUWI GAJAH NO. 100 CIMINDI ";
        sup.setAlamat_Supplier(Alm_supplier);
        assertEquals(Alm_supplier,sup.getAlamat_Supplier());
        
        
    }

    /**
     * Test of setAlamat_Supplier method, of class Supplier.
     */
    
    /**
     * Test of getNama_Supplier method, of class Supplier.
     */
    @Test
    public void testGetNama_Supplier() {
       String nama_supplier = "PT HOLI PHARMACEUTICAL INDUSTR";
        sup.setNama_Supplier(nama_supplier);
       assertEquals(nama_supplier,sup.getNama_Supplier());
    }

    /**
     * Test of setNama_Supplier method, of class Supplier.
     */
    

    /**
     * Test of getKota_Supplier method, of class Supplier.
     */
    @Test
    public void testGetKota_Supplier() {
        String kota_supplier = "CIMAHI";
        sup.setKota_Supplier(kota_supplier);
        assertEquals(kota_supplier,sup.getKota_Supplier());
    }

    /**
     * Test of setKota_Supplier method, of class Supplier.
     */
    
    /**
     * Test of getTelepon_Supplier method, of class Supplier.
     */
    @Test
    public void testGetTelepon_Supplier() {
        String telp_supplier = "0318969078";
        sup.setTelepon_Supplier(telp_supplier);
        assertEquals(telp_supplier,sup.getTelepon_Supplier());
    }

    /**
     * Test of setTelepon_Supplier method, of class Supplier.
     */
    
    /**
     * Test of getNPWP_Supplier method, of class Supplier.
     */
    @Test
    public void testGetNPWP_Supplier() {
       String npwp_supplier = "34.129.035.1-601.000";
        sup.setNPWP_Supplier(npwp_supplier);
        assertEquals(npwp_supplier,sup.getNPWP_Supplier());
    }

    /**
     * Test of setNPWP_Supplier method, of class Supplier.
     */
    
    /**
     * Test of getJenis_pajak_Supplier method, of class Supplier.
     */
    @Test
    public void testGetJenis_pajak_Supplier() {
        String JP_supplier = "PPH PASAL 22 FARMASI";
        sup.setJenis_pajak_Supplier(JP_supplier);
        assertEquals(JP_supplier,sup.getJenis_pajak_Supplier());
    }

    /**
     * Test of setJenis_pajak_Supplier method, of class Supplier.
     */
    
    /**
     * Test of getKode_Pajak_Supplier method, of class Supplier.
     */
    @Test
    public void testGetKode_Pajak_Supplier() {
        String KP_supplier = "PAJAKFAR2";
        sup.setKode_Pajak_Supplier(KP_supplier);
        assertEquals(KP_supplier,sup.getKode_Pajak_Supplier());
    }

    /**
     * Test of setKode_Pajak_Supplier method, of class Supplier.
     */
    
}
