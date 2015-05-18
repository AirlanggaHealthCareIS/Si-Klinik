/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import database.entity.Penggajian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows 8.1
 */
public class Test_Penggajian {
    
    Penggajian g;
    
    public Test_Penggajian() {
        g = new Penggajian();
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
    public void testSetGetTanggal() {
        String tanggal = "2015-04-06";
        g.setTanggal(tanggal);
        assertEquals(tanggal, g.getTanggal());
    }

    @Test
    public void testSetGetNamaPegawai() {
        String nama = "TRIYAH";
        g.setNamaPegawai(nama);
        assertEquals(nama, g.getNamaPegawai());
    }

    @Test
    public void testSetGetIdPenggajian() {
        String idPenggajian = "G003";
        g.setIdPenggajian(idPenggajian);
        assertEquals(idPenggajian, g.getIdPenggajian());
    }

    @Test
    public void testSetGetIdPegawai() {
        String idPegawai = "PET007";
        g.setIdPegawai(idPegawai);
        assertEquals(idPegawai, g.getIdPegawai());
    }

    @Test
    public void testSetGetTotalPeriksa() {
        int totalPeriksa = 0;
        g.setTotalPeriksa(totalPeriksa);
        assertEquals(totalPeriksa, g.getTotalPeriksa());
    }

    
    @Test
    public void testSetGetTarifPeriksa() {
        int tarifPeriksa = 0;
        g.setTarifPeriksa(tarifPeriksa);
        assertEquals(tarifPeriksa, g.getTarifPeriksa());
    }

    @Test
    public void testSetGetGajiPokok() {
        int gajiPokok = 3000000;
        g.setGajiPokok(gajiPokok);
        assertEquals(gajiPokok, g.getGajiPokok());
    }

    @Test
    public void testSetGetGajiTambahan() {
        int gajiTambahan = 0;
        g.setGajiTambahan(gajiTambahan);
        assertEquals(gajiTambahan, g.getGajiTambahan());
    }

    @Test
    public void testSetGetTotalGaji() {
        int totalGaji = 3000000;
        g.setTotalGaji(totalGaji);
        assertEquals(totalGaji, g.getTotalGaji());
    }
}
