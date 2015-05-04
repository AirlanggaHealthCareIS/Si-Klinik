/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import database.entity.obat;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class obatTest {
    obat obt;
    
    public obatTest() {
        obt = new obat();
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
     * Test of getid_obat method, of class obat.
     */
    @Test
    public void testGetid_obat() {
     String id_obat = "O101";
     obt.setid_obat(id_obat);
     assertEquals(id_obat, obt.getid_obat());
    }

    /**
     * Test of setid_obat method, of class obat.
     */

    /**
     * Test of getnama_obat method, of class obat.
     */
    @Test
    public void testGetnama_obat() {
     String nama_obat = "IBUPROFEN";
     obt.setnama_obat(nama_obat);
     assertEquals(nama_obat, obt.getnama_obat());
        
    }

    /**
     * Test of setnama_obat method, of class obat.
     */

    /**
     * Test of getdosis method, of class obat.
     */
    @Test
    public void testGetdosis() {
        float dosis = (float) 0.2;
        obt.setdosis(dosis);
        assertEquals(dosis, obt.getdosis(), 0.2);
        
    }

    /**
     * Test of getNamaSupplier method, of class obat.
     */

    /**
     * Test of setdosis method, of class obat.
     */
   

    /**
     * Test of getketerangan_obat method, of class obat.
     */
    @Test
    public void testGetketerangan_obat() {
        String keterangan_obat = "NULL";
        obt.setketerangan_obat(keterangan_obat);
        assertEquals(keterangan_obat, obt.getketerangan_obat());
    }

    /**
     * Test of setketerangan_obat method, of class obat.
     */
   

    /**
     * Test of getstok_obat method, of class obat.
     */
    @Test
    public void testGetstok_obat() {
        int stok_obat = 10;
        obt.setstok_obat(stok_obat);
        assertEquals(stok_obat, obt.getstok_obat());
    }

    /**
     * Test of setstok_obat method, of class obat.
     */
   

    /**
     * Test of getstok_kritis method, of class obat.
     */
    @Test
    public void testGetstok_kritis() {
        int stok_kritis = 5;
        obt.setstok_kritis(stok_kritis);
        assertEquals(stok_kritis, obt.getstok_kritis());
    }

    /**
     * Test of setstok_kritis method, of class obat.
     */
   

    /**
     * Test of getpabrik_obat method, of class obat.
     */
    @Test
    public void testGetpabrik_obat() {
        String pabrik_obat = "PT COMBIPHAR";
        obt.setpabrik_obat(pabrik_obat);
        assertEquals(pabrik_obat, obt.getpabrik_obat());
    }

    /**
     * Test of setpabrik_obat method, of class obat.
     */
   
    /**
     * Test of getjenis_obat method, of class obat.
     */
    @Test
    public void testGetjenis_obat() {
     String jenis_obat = "TABLET";
     obt.setjenis_obat(jenis_obat);
     assertEquals(jenis_obat, obt.getjenis_obat());
    }

    /**
     * Test of setjenis_obat method, of class obat.
     */
   
    /**
     * Test of getkemasan method, of class obat.
     */
    @Test
    public void testGetkemasan() {
      String kemasan = "BOTOL";
      obt.setkemasan(kemasan);
      assertEquals(kemasan, obt.getkemasan());
    }

    /**
     * Test of setkemasan method, of class obat.
     */
   

    /**
     * Test of getharga_obat method, of class obat.
     */
    @Test
    public void testGetharga_obat() {
        int harga_obat = 17000;
        obt.setharga_obat(harga_obat);
        assertEquals(harga_obat, obt.getharga_obat());
    }

    /**
     * Test of setid_obat method, of class obat.
     */
    
    

    /**
     * Test of setnama_obat method, of class obat.
     */
    
    /**
     * Test of getNamaSupplier method, of class obat.
     */
    

    /**
     * Test of setdosis method, of class obat.
     */
   

    /**
     * Test of setketerangan_obat method, of class obat.
     */
    

    /**
     * Test of setstok_obat method, of class obat.
     */
   

    /**
     * Test of setstok_kritis method, of class obat.
     */
   

    /**
     * Test of setpabrik_obat method, of class obat.
     */
   

    /**
     * Test of setjenis_obat method, of class obat.
     */
  
    /**
     * Test of setkemasan method, of class obat.
     */
    

    /**
     * Test of setharga_obat method, of class obat.
     */
    

    /**
     * Test of setharga_obat method, of class obat.
     */
    
}