/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Test_PetugasEntity {
    petugas p;
    public Test_PetugasEntity() {
        p = new petugas();
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
    public void testSetGetIDPetugas(){
        String idPetugas = "PET001";
        p.setId_Petugas(idPetugas);
        assertEquals(idPetugas, p.getId_Petugas());
    }
    
    @Test
    public void testSetGetNamaPetugas(){
        String namaPetugas = "Jessica";
        p.setNama_Petugas(namaPetugas);
        assertEquals(namaPetugas, p.getNama_Petugas());
    }
    
    @Test
    public void testSetGetJabatan(){
        String jabatan = "KASIR";
        p.setJabatan(jabatan);
        assertEquals(jabatan, p.getJabatan());
    }
     
    @Test
    public void testSetGetAlamat(){
        String Alamat = "Kalijudan";
        p.setAlamat(Alamat);
        assertEquals(Alamat, p.getAlamat());
    } 
    
    @Test
    public void testSetGetTelepon(){
        String telp = "12345";
        p.setTelepon(telp);
        assertEquals(telp, p.getTelepon());
    }
    
    @Test
    public void testSetGetTanggalLahir(){
        String tanggalLahir = "1994-06-30";
        p.setTanggalLahir(tanggalLahir);
        assertEquals(tanggalLahir, p.getTanggalLahir());
    } 
    
    @Test
    public void testSetGetJenkel(){
        String jenkel = "P";
        p.setJenKel(jenkel);
        assertEquals(jenkel, p.getJenKel());
    } 
    
    @Test
    public void testSetGetAgama(){
        String agama = "Kristen";
        p.setAgama(agama);
        assertEquals(agama, p.getAgama());
    }
    
    @Test
    public void testSetGetPassword(){
        String password = "pass";
        p.setPassword(password);
        assertEquals(password, p.getPassword());
    } 
}
