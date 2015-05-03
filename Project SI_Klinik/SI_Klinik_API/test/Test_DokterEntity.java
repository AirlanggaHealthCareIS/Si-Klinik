/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entity.dokter;
import database.entity.petugas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JESSICA
 */
public class Test_DokterEntity {
    dokter d;
    
    public Test_DokterEntity() {
        d = new dokter();
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
    public void testSetGetIDDokter(){
        String idDokter = "DOK001";
        d.setid_dokter(idDokter);
        assertEquals(idDokter, d.getid_dokter());
    }
    
    @Test
    public void testSetGetNamaDokter(){
        String namaDokter = "Jessica";
        d.setnama_dokter(namaDokter);
        assertEquals(namaDokter, d.getnama_dokter());
    }
    
    @Test
    public void testSetGetIDPoli(){
        String poli = "pol001";
        d.setid_poli(poli);
        assertEquals(poli,d.getid_poli());
    }
     
    @Test
    public void testSetGetAlamat(){
        String Alamat = "Kalijudan";
        d.setalamat_dokter(Alamat);
        assertEquals(Alamat, d.getalamat_dokter());
    } 
    
    @Test
    public void testSetGetTelepon(){
        String telp = "12345";
        d.settelepon_dokter(telp);
        assertEquals(telp, d.gettelepon_dokter());
    }
    
    @Test
    public void testSetGetTanggalLahir(){
        String tanggalLahir = "1994-06-30";
        d.settgl_lahir_dokter(tanggalLahir);
        assertEquals(tanggalLahir, d.gettgl_lahir_dokter());
    } 
    
    @Test
    public void testSetGetJenkel(){
        String jenkel = "P";
        d.setjenis_kelamin_dokter(jenkel);
        assertEquals(jenkel,d.getjenis_kelamin_dokter());
    } 
    
    @Test
    public void testSetGetAgama(){
        String agama = "Kristen";
        d.setagama_dokter(agama);
        assertEquals(agama, d.getagama_dokter());
    }
    
    @Test
    public void testSetGetPassword(){
        String password = "pass";
        d.setpassword_dokter(password);
        assertEquals(password, d.getpassword_dokter());
    } 
   
    @Test
    public void testSetGetIzin(){
        String izin = "1234";
        d.setno_ijin(izin);
        assertEquals(izin, d.getno_ijin());
    } 
    
    @Test
    public void testSetGetTarif(){
        int tarif = 10000;
        d.settarif_dokter(tarif);
        assertEquals(tarif, d.gettarif_dokter());
    } 
    
}
