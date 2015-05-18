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
     * Test of getPenggajianSemuaPegawai method, of class Penggajian_Server.
     */
    @Test
    public void testGetPenggajianSemuaPegawai() throws Exception {
        System.out.println("getPenggajianSemuaPegawai");
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-06";
        List<Penggajian> output = ps.getPenggajianSemuaPegawai(tanggal1, tanggal2);
        List<Penggajian> target = new ArrayList();
        Penggajian ambil = new Penggajian();
        
        ambil.setIdPenggajian("G002");
        ambil.setIdPegawai("DOK002");
        ambil.setNamaPegawai("DR. FADJAR ARIBOWO");
        ambil.setTanggal("2015-04-06");
        ambil.setGajiPokok(3000000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPenggajian("G003");
        ambil.setIdPegawai("PET007");
        ambil.setNamaPegawai("TRIYAH");
        ambil.setTanggal("2015-04-06");
        ambil.setGajiPokok(3000000);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getIdPenggajian(), output.get(i).getIdPenggajian());
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getNamaPegawai(), output.get(i).getNamaPegawai());
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
            assertEquals(target.get(i).getGajiPokok(), output.get(i).getGajiPokok());
        }
    }

    /**
     * Test of getPenggajianNonDokter method, of class Penggajian_Server.
     */
    @Test
    public void testGetPenggajianNonDokter() throws Exception {
        System.out.println("getPenggajianNonDokter");
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-06";
        List<Penggajian> output = ps.getPenggajianNonDokter(tanggal1, tanggal2);
        List<Penggajian> target = new ArrayList();
        Penggajian ambil = new Penggajian();
        ambil.setTanggal("2015-04-06");
        ambil.setIdPenggajian("G003");
        ambil.setIdPegawai("PET007");
        ambil.setNamaPegawai("TRIYAH");
        ambil.setGajiPokok(3000000);
        ambil.setGajiTambahan(0);
        ambil.setTotalGaji(3000000);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
            assertEquals(target.get(i).getIdPenggajian(), output.get(i).getIdPenggajian());
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getNamaPegawai(), output.get(i).getNamaPegawai());
            assertEquals(target.get(i).getGajiPokok(), output.get(i).getGajiPokok());
            assertEquals(target.get(i).getGajiTambahan(), output.get(i).getGajiTambahan());
            assertEquals(target.get(i).getTotalGaji(), output.get(i).getTotalGaji());
        }
    }

    /**
     * Test of getPenggajianDokter method, of class Penggajian_Server.
     */
    @Test
    public void testGetPenggajianDokter() throws Exception {
        System.out.println("getPenggajianDokter");
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-08";
        List<Penggajian> output = ps.getPenggajianDokter(tanggal1, tanggal2);
        List<Penggajian> target = new ArrayList();
        
        Penggajian ambil = new Penggajian();
        ambil.setIdPegawai("DOK001");
        ambil.setNamaPegawai("DR. RETNO WISASTI, S");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(100000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK002");
        ambil.setNamaPegawai("DR. FADJAR ARIBOWO");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(1);
        ambil.setTarifPeriksa(100000);
        ambil.setGajiTambahan(100000);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK003");
        ambil.setNamaPegawai("DRG. DYAH AYU R. W.");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(120000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK004");
        ambil.setNamaPegawai("DRG. BACHTIAR EFFEND");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(120000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK005");
        ambil.setNamaPegawai("DR. NUGROHO TJANDRA ");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(150000);
        ambil.setGajiTambahan(0);
        target.add(ambil);

        ambil = new Penggajian();
        ambil.setIdPegawai("DOK006");
        ambil.setNamaPegawai("DR. I NYOMAN ADNYANA");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(150000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK007");
        ambil.setNamaPegawai("DR. BUDIARTO, SP. PK");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(150000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK008");
        ambil.setNamaPegawai("DR. MARIANA HAROEN, ");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(100000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK009");
        ambil.setNamaPegawai("DR. RAHARDJO ARIYO M");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(100000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        ambil = new Penggajian();
        ambil.setIdPegawai("DOK010");
        ambil.setNamaPegawai("DR. HERI KABULLAH, S");
        ambil.setGajiPokok(3000000);
        ambil.setTotalPeriksa(0);
        ambil.setTarifPeriksa(100000);
        ambil.setGajiTambahan(0);
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getIdPegawai(), output.get(i).getIdPegawai());
            assertEquals(target.get(i).getNamaPegawai(), output.get(i).getNamaPegawai());
            assertEquals(target.get(i).getGajiPokok(), output.get(i).getGajiPokok());
            assertEquals(target.get(i).getTotalPeriksa(), output.get(i).getTotalPeriksa());
            assertEquals(target.get(i).getTarifPeriksa(), output.get(i).getTarifPeriksa());
            assertEquals(target.get(i).getGajiTambahan(), output.get(i).getGajiTambahan());
        }
    }

    /**
     * Test of getGajiDokter method, of class Penggajian_Server.
     */
    
    @Test
    public void testGetGajiDokter() throws Exception {
        System.out.println("getGajiDokter");
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-06";
        String idDokter = "DOK002";
        List<Penggajian> output = ps.getGajiDokter(tanggal1, tanggal2, idDokter);
        List<Penggajian> target = new ArrayList();
        Penggajian ambil = new Penggajian();
        ambil.setTanggal("2015-04-06");
        ambil.setIdPenggajian("G002");
        target.add(ambil);
        
        for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
            assertEquals(target.get(i).getIdPenggajian(), output.get(i).getIdPenggajian());
        }
    }
    
}
