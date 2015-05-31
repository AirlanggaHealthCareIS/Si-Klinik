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
    
    Penggajian p;
    
    public Test_Penggajian() {
        p = new Penggajian();
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
     * Test of setTanggal method, of class Penggajian.
     */
    @Test
    public void testSetGetTanggal() {
        System.out.println("set tanggal");
        String tanggal = "2015-05-31";
        p.setTanggal(tanggal);
        assertEquals(p.getTanggal(), tanggal);
    }

    @Test
    public void testSetGetNamaPegawai() {
        System.out.println("set nama pegawai");
        String nama = "Dr. Retno Wisasti, S";
        p.setNamaPegawai(nama);
        assertEquals(p.getNamaPegawai(), nama);
    }

    @Test
    public void testSetGetIdPenggajian() {
        System.out.println("set id penggajian");
        String id = "1";
        p.setIdPenggajian(id);
        assertEquals(p.getIdPenggajian(), id);
    }

    @Test
    public void testSetGetIdPegawai() {
        System.out.println("set id pegawai");
        String idp = "DOK001";
        p.setIdPegawai(idp);
        assertEquals(p.getIdPegawai(), idp);
    }

    @Test
    public void testSetGetTotalPeriksa() {
        System.out.println("set total periksa");
        int periksa = 13;
        p.setTotalPeriksa(periksa);
        assertEquals(p.getTotalPeriksa(), periksa);
    }

    @Test
    public void testSetGetTarifPeriksa() {
        System.out.println("set tarif periksa");
        int tarif = 50000;
        p.setTarifPeriksa(tarif);
        assertEquals(p.getTarifPeriksa(), tarif);
    }

    @Test
    public void testSetGetGajiPokok() {
        System.out.println("set gaji pokok");
        int gajiPokok = 1000000;
        p.setGajiPokok(gajiPokok);
        assertEquals(p.getGajiPokok(), gajiPokok);
    }

    @Test
    public void testSetGetGajiTambahan() {
        System.out.println("set gaji tambahan");
        int gajiTambahan = 740000;
        p.setGajiTambahan(gajiTambahan);
        assertEquals(p.getGajiTambahan(), gajiTambahan);
    }

    @Test
    public void testSetGetTotalGaji() {
        System.out.println("set total gaji");
        int totalGaji = 1740000;
        p.setTotalGaji(totalGaji);
        assertEquals(p.getTotalGaji(), totalGaji);
    }

    @Test
    public void testSetGetPresensi() {
        System.out.println("setTanggal");
        int presensi = 6;
        p.setPresensi(presensi);
        assertEquals(p.getPresensi(), presensi);
    }

    @Test
    public void testSetGetGajiPeriksa() {
        System.out.println("setTanggal");
        int gajiPeriksa = 650000;
        p.setGajiPeriksa(gajiPeriksa);
        assertEquals(p.getGajiPeriksa(), gajiPeriksa);
    }
    
}
