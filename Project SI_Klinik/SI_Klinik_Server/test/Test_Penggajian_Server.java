/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import database.entity.Penggajian;
import ServerApplication.Service.Penggajian_Server;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Test_Penggajian_Server {
    Penggajian_Server ps;
    
    public Test_Penggajian_Server() {
        try {
            ps = new Penggajian_Server();
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Penggajian_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * Test of insertGaji method, of class Penggajian_Server.
     */
    
    @Test
    public void testInsertGaji() throws Exception {
            Penggajian_Server penggajianServer = new Penggajian_Server();
            Penggajian p = new Penggajian();
            
                p.setTanggal("2015-05-03");
                p.setIdPegawai("PET007");
                p.setNamaPegawai("Triyah");
                p.setGajiPokok(3000000);
                p.setGajiTambahan(30000);
                p.setTotalGaji(3030000);
                
                penggajianServer.insertGaji(p);
                Penggajian output = penggajianServer.getLastPenggajian();
                Penggajian target = p;
                
                    assertEquals(target.getTanggal(), output.getTanggal());
                    assertEquals(target.getIdPegawai(), output.getIdPegawai());
                    assertEquals(target.getNamaPegawai(), output.getNamaPegawai());
                    assertEquals(target.getGajiPokok(), output.getGajiPokok());
                    assertEquals(target.getGajiTambahan(), output.getGajiTambahan());
                    assertEquals(target.getTotalGaji(), output.getTotalGaji());
    }

    /**
     * Test of getPenggajianNonDokter method, of class Penggajian_Server.
     */
    @Test
    public void testGetPenggajianNonDokter() throws Exception {
        List<Penggajian> target = new ArrayList<>();
        List<Penggajian> output = ps.getPenggajianNonDokter();
        Penggajian ambil = new Penggajian();
        
        ambil.setIdPegawai("PET001");
        ambil.setNamaPegawai("JESSICA");
        ambil.setGajiPokok(2000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET002");
        ambil.setNamaPegawai("ALIF");
        ambil.setGajiPokok(2000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET003");
        ambil.setNamaPegawai("YULIASTI");
        ambil.setGajiPokok(2500000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET004");
        ambil.setNamaPegawai("MELLA");
        ambil.setGajiPokok(2500000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET005");
        ambil.setNamaPegawai("INDYKA");
        ambil.setGajiPokok(2500000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET006");
        ambil.setNamaPegawai("MERRY");
        ambil.setGajiPokok(3000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET007");
        ambil.setNamaPegawai("TRIYAH");
        ambil.setGajiPokok(3000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("PET008");
        ambil.setNamaPegawai("MELINDA");
        ambil.setGajiPokok(3000000);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getNamaPegawai(), output.get(i).getNamaPegawai());
            assertEquals(target.get(i).getGajiPokok(), output.get(i).getGajiPokok());
        }
    }

    /**
     * Test of getPenggajianDokter method, of class Penggajian_Server.
     */
    @Test
    public void testGetPenggajianDokter() throws Exception {
        List<Penggajian> target = new ArrayList<>();
        List<Penggajian> output = ps.getPenggajianDokter();
        Penggajian ambil = new Penggajian();
        
        ambil.setIdPegawai("DOK001");
        ambil.setNamaPegawai("DR. RETNO WISASTI, S");
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK002");
        ambil.setNamaPegawai("DR. FADJAR ARIBOWO");
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK003");
        ambil.setNamaPegawai("DRG. DYAH AYU R. W.");
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK004");
        ambil.setNamaPegawai("DRG. BACHTIAR EFFEND");
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK005");
        ambil.setNamaPegawai("DR. NUGROHO TJANDRA ");
        ambil.setGajiPokok(25000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK006");
        ambil.setNamaPegawai("DR. I NYOMAN ADNYANA");
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK007");
        ambil.setNamaPegawai("DR. BUDIARTO, SP. PK");
        ambil.setGajiPokok(10000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK008");
        ambil.setNamaPegawai("DR. MARIANA HAROEN, ");
        ambil.setGajiPokok(400000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK009");
        ambil.setNamaPegawai("DR. RAHARDJO ARIYO M");
        ambil.setGajiPokok(30000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK010");
        ambil.setNamaPegawai("DR. HERI KABULLAH, S");
        ambil.setGajiPokok(20000000);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getNamaPegawai(), output.get(i).getNamaPegawai());
            assertEquals(target.get(i).getGajiPokok(), output.get(i).getGajiPokok());
        }
    }

    /**
     * Test of getGajiPeriksa method, of class Penggajian_Server.
     */
    @Test
    public void testGetGajiPeriksa() throws Exception {
        List<Penggajian> target = new ArrayList<>();
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-02";
        List<Penggajian> output = ps.getGajiPeriksa(tanggal1, tanggal2);
        Penggajian ambil = new Penggajian();
        
        ambil.setIdPegawai("DOK001");
        ambil.setTarifPeriksa(50000);
        ambil.setTotalPeriksa(3);
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK002");
        ambil.setTarifPeriksa(50000);
        ambil.setTotalPeriksa(1);
        ambil.setGajiPokok(1000000);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getTarifPeriksa(), output.get(i).getTarifPeriksa());
            assertEquals(target.get(i).getTotalPeriksa(), output.get(i).getTotalPeriksa());
            assertEquals(target.get(i).getGajiPokok(), output.get(i).getGajiPokok());
        }
    }

    /**
     * Test of getPresensi method, of class Penggajian_Server.
     */
    @Test
    public void testGetPresensi() throws Exception {
        String tanggal1 = "2015-04-02";
        String tanggal2 = "2015-04-02";
        List<Penggajian> output = ps.getPresensi(tanggal1, tanggal2);
        List<Penggajian> target = new ArrayList<>();
        Penggajian ambil = new Penggajian();
        
        ambil.setIdPegawai("DOK001");
        ambil.setPresensi(1);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getPresensi(), output.get(i).getPresensi());
        }
    }
    
    @Test
    public void testGetLastPenggajian(){
        try {
            Penggajian_Server gajiServer = new Penggajian_Server();
            Penggajian output = gajiServer.getLastPenggajian();           
            Penggajian target = new Penggajian();
            target.setIdPegawai("PET007");
            target.setNamaPegawai("Triyah");
            target.setTanggal("2015-05-03");
            target.setGajiPokok(3000000);
            target.setGajiTambahan(30000);
            target.setTotalGaji(3030000);
            
                assertEquals(target.getIdPegawai(), output.getIdPegawai());
                assertEquals(target.getNamaPegawai(), output.getNamaPegawai());
                assertEquals(target.getTanggal(), output.getTanggal());
                assertEquals(target.getGajiPokok(), output.getGajiPokok());
                assertEquals(target.getGajiTambahan(), output.getGajiTambahan());
                assertEquals(target.getTotalGaji(), output.getTotalGaji());
            
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Tambah_Data_Supplier_Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
