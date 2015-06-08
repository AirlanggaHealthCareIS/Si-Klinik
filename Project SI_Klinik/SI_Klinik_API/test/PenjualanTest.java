/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import database.entity.Penjualan;
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
public class PenjualanTest {
Penjualan a;
public PenjualanTest(){
   a = new Penjualan();
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
     * Test of getId_Obat method, of class Penjualan.
     */
  @Test
    public void testSetGetId_obat() {
        String idobat="O1";
       a.setId_Obat(idobat);
       assertEquals(idobat, a.getId_Obat());
       
    }
    @Test
    public void testSetGetnama_obat() {
        String namaobat="IBUPROFEN";
        a.setNama_Obat(namaobat);
        assertEquals(namaobat, a.getNama_Obat());

}
    
     @Test
    public void testSetGetqyt() {
        int quantity = 10;
        a.setQty(quantity);
        assertEquals(quantity, a.getQty());
    }
 @Test
    public void testSetGetharga() {
        int harga = 17000;
        a.setHarga(harga);
        assertEquals(harga, a.getHarga());
    }
@Test
    public void testSettotal() {
        int tot = 11000;
        a.setTotal(tot);
        assertEquals(tot, a.getTotal());
    }

    @Test
    public void testSetGetketerangan() {
        String ket="";
        a.setKeterangan(ket);
        assertEquals(ket, a.getKeterangan());

}
    
    @Test
    public void testSetstock() {
        int stock = 13;
        a.setStok(stock);
        assertEquals(stock, a.getStok());
    }
    

}
    
    

       
    
    

