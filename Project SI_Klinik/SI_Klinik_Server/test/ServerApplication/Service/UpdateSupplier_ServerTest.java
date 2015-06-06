/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.entity.Supplier;
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
public class UpdateSupplier_ServerTest {
    
    public UpdateSupplier_ServerTest() {
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
     * Test of updateSupplier method, of class Supplier_Server.
     */
    @Test
    public void testUpdateSupplier() throws Exception {
        Supplier_Server supServer = new Supplier_Server();
        Supplier output = new Supplier();
        Supplier target = new Supplier();
        
        String Id_supplier = "SUP003";
        String nama = "PT COMBHIPAR";
        String alamat = "JL . RAYA SIMPANG 383 PADALARANG";
        String kota = "Cileunyi";
        String telepon = "0223756121";
        String NPWP = "07.015.027.7-170.000";
        String jenis_pajak = "PPH PASAL 22 FARMASI";
        String kode_pajak = "PAJAKFAR2";
        
        target.setId_Supplier(Id_supplier);
        target.setNama_Supplier(nama);
        target.setAlamat_Supplier(alamat);
        target.setKota_Supplier(kota);
        target.setTelepon_Supplier(telepon);
        target.setNPWP_Supplier(NPWP);
        target.setJenis_pajak_Supplier(jenis_pajak);
        target.setKode_Pajak_Supplier(kode_pajak);
        
        supServer.updateSupplier(target);
        output = supServer.getSupplier(Id_supplier);
        
        assertEquals(target.getId_Supplier(), output.getId_Supplier());
        assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
        assertEquals(target.getTelepon_Supplier(), output.getTelepon_Supplier());
        assertEquals(target.getAlamat_Supplier(), output.getAlamat_Supplier());
        assertEquals(target.getKota_Supplier(), output.getKota_Supplier());
        assertEquals(target.getKode_Pajak_Supplier(), output.getKode_Pajak_Supplier());
        assertEquals(target.getJenis_pajak_Supplier(), output.getJenis_pajak_Supplier());
        assertEquals(target.getNPWP_Supplier(), output.getNPWP_Supplier());
    }
}
