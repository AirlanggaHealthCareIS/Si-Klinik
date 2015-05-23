/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.AfterClass;
import database.entity.detail_resep_obat;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class Test_detail_resep_obat {
    detail_resep_obat dro;
    public Test_detail_resep_obat() {
        dro = new detail_resep_obat();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getid_detail_resep method, of class detail_resep_obat.
     */
    @Test
    public void testSetGetid_detail_resep() {
        int idDetailResep = 20;
        dro.setid_detail_resep(idDetailResep);
        assertEquals(idDetailResep, dro.getid_detail_resep());
    }

    /**
     * Test of setid_detail_resep method, of class detail_resep_obat.
     */
    
    /**
     * Test of getid_rekam_medis method, of class detail_resep_obat.
     */
    @Test
    public void testSetGetid_rekam_medis() {
        String idRekamMedis = "rk01";
        dro.setid_rekam_medis(idRekamMedis);
        assertEquals(idRekamMedis, dro.getid_rekam_medis());
    }

    /**
     * Test of setid_rekam_medis method, of class detail_resep_obat.
     */
    
    /**
     * Test of getid_obat method, of class detail_resep_obat.
     */
    @Test
    public void testSetGetid_obat() {
        String idObat = "OBT01";
        dro.setid_obat(idObat);
        assertEquals(idObat, dro.getid_obat());
    }

    /**
     * Test of setid_obat method, of class detail_resep_obat.
     */
    
    /**
     * Test of getqty_detail_resep method, of class detail_resep_obat.
     */
    @Test
    public void testSetGetqty_detail_resep() {
        int qtyObat = 6;
        dro.setqty_detail_resep(qtyObat);
        assertEquals(qtyObat, dro.getqty_detail_resep());
    }

    /**
     * Test of setqty_detail_resep method, of class detail_resep_obat.
     */
    
}
