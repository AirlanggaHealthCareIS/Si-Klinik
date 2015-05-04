/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import database.entity.Laporan_Keuangan;
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
public class Test_Laporan_Keuangan {
    Laporan_Keuangan lk;
    public Test_Laporan_Keuangan() {
        lk = new Laporan_Keuangan();
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
     * Test of setTanggal method, of class Laporan_Keuangan.
     */
    
    @Test
    public void testSetGetTanggal() {
        String tanggal = "2015-04-01";
        lk.setTanggal(tanggal);
        assertEquals(tanggal, lk.getTanggal());
    }

    @Test
    public void testSetGetKeterangan() {
        String ket = "Pemasukan dari penjualan obat";
        lk.setKeterangan(ket);
        assertEquals(ket, lk.getKeterangan());
    }

    @Test
    public void testSetGetRef() {
        String ref = "O-1";
        lk.setRef(ref);
        assertEquals(ref, lk.getRef());
    }

    @Test
    public void testSetGetPemasukan() {
        int pemasukan = 150000;
        lk.setPemasukan(pemasukan);
        assertEquals(pemasukan, lk.getPemasukan());
    }

    @Test
    public void testSetGetPengeluaran() {
        int pengeluaran = 0;
        lk.setPengeluaran(pengeluaran);
        assertEquals(pengeluaran, lk.getPengeluaran());
    }

    @Test
    public void testSetGetSaldo() {
        int saldo = 2554000;
        lk.setSaldo(saldo);
        assertEquals(saldo, lk.getSaldo());
    }

    @Test
    public void testSetGetFlag() {
        int flag = 3;
        lk.setFlag(flag);
        assertEquals(flag, lk.getFlag());
    }
    
    @Test
    public void testSetGetTanggal2() {
        String tanggal = "2015-03-24";
        lk.setTanggal(tanggal);
        assertEquals(tanggal, lk.getTanggal());
    }

    @Test
    public void testSetGetKeterangan2() {
        String ket = "Pemasukan dari tindakan pemeriksaan dokter";
        lk.setKeterangan(ket);
        assertEquals(ket, lk.getKeterangan());
    }

    @Test
    public void testSetGetRef2() {
        String ref = "PE-1";
        lk.setRef(ref);
        assertEquals(ref, lk.getRef());
    }

    @Test
    public void testSetGetPemasukan2() {
        int pemasukan = 100000;
        lk.setPemasukan(pemasukan);
        assertEquals(pemasukan, lk.getPemasukan());
    }

    @Test
    public void testSetGetPengeluaran2() {
        int pengeluaran = 0;
        lk.setPengeluaran(pengeluaran);
        assertEquals(pengeluaran, lk.getPengeluaran());
    }

    @Test
    public void testSetGetSaldo2() {
        int saldo = 2504000;
        lk.setSaldo(saldo);
        assertEquals(saldo, lk.getSaldo());
    }

    @Test
    public void testSetGetFlag2() {
        int flag = 1;
        lk.setFlag(flag);
        assertEquals(flag, lk.getFlag());
    }
    
    @Test
    public void testSetGetTanggal3() {
        String tanggal = "2015-03-25";
        lk.setTanggal(tanggal);
        assertEquals(tanggal, lk.getTanggal());
    }

    @Test
    public void testSetGetKeterangan3() {
        String ket = "Pemasukan dari penjualan obat";
        lk.setKeterangan(ket);
        assertEquals(ket, lk.getKeterangan());
    }

    @Test
    public void testSetGetRef3() {
        String ref = "B-1";
        lk.setRef(ref);
        assertEquals(ref, lk.getRef());
    }

    @Test
    public void testSetGetPemasukan3() {
        int pemasukan = 0;
        lk.setPemasukan(pemasukan);
        assertEquals(pemasukan, lk.getPemasukan());
    }

    @Test
    public void testSetGetPengeluaran3() {
        int pengeluaran = 100000;
        lk.setPengeluaran(pengeluaran);
        assertEquals(pengeluaran, lk.getPengeluaran());
    }

    @Test
    public void testSetGetSaldo3() {
        int saldo = 2404000;
        lk.setSaldo(saldo);
        assertEquals(saldo, lk.getSaldo());
    }

    @Test
    public void testSetGetFlag3() {
        int flag = 2;
        lk.setFlag(flag);
        assertEquals(flag, lk.getFlag());
    }
    
    @Test
    public void testSetGetTanggal4() {
        String tanggal = "2015-04-11";
        lk.setTanggal(tanggal);
        assertEquals(tanggal, lk.getTanggal());
    }

    @Test
    public void testSetGetKeterangan4() {
        String ket = "Pemasukan dari penjualan obat";
        lk.setKeterangan(ket);
        assertEquals(ket, lk.getKeterangan());
    }

    @Test
    public void testSetGetRef4() {
        String ref = "B-2";
        lk.setRef(ref);
        assertEquals(ref, lk.getRef());
    }

    @Test
    public void testSetGetPemasukan4() {
        int pemasukan = 0;
        lk.setPemasukan(pemasukan);
        assertEquals(pemasukan, lk.getPemasukan());
    }

    @Test
    public void testSetGetPengeluaran4() {
        int pengeluaran = 200000;
        lk.setPengeluaran(pengeluaran);
        assertEquals(pengeluaran, lk.getPengeluaran());
    }

    @Test
    public void testSetGetSaldo4() {
        int saldo = 2400000;
        lk.setSaldo(saldo);
        assertEquals(saldo, lk.getSaldo());
    }

    @Test
    public void testSetGetFlag4() {
        int flag = 5;
        lk.setFlag(flag);
        assertEquals(flag, lk.getFlag());
    }
}
