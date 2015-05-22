/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Presensi_Server;
import database.entity.Presensi;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class Presensi_ServerTest {
    Presensi_Server ps;
    public Presensi_ServerTest() throws RemoteException {
        ps = new Presensi_Server();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertPresensi method, of class Presensi_Server.
     */
    @Test
    public void testInsertPresensi() throws Exception {
        try {
            Presensi_Server pServer = new Presensi_Server();
            Presensi s = new Presensi();
            s.setTanggal_masuk("2015-05-22");
            s.setId_pegawai("PET003");
            s.setJam_masuk("07:01:22");
            s.setJam_keluar("16:03:34");
            pServer.insertPresensi(s);
            Presensi output = pServer.getLastPresensi();
            Presensi target = s;
                assertEquals(target.getTanggal_masuk(), output.getTanggal_masuk());
                assertEquals(target.getId_pegawai(), output.getId_pegawai());
                assertEquals(target.getJam_masuk(), output.getJam_masuk());
                assertEquals(target.getJam_keluar(), output.getJam_keluar());
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Tambah_Data_Supplier_Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Test of getPegawai method, of class Presensi_Server.
     */
    @Test
    public void testGetPegawai() throws Exception {
        System.out.println("getPegawai");
        Presensi_Server pServer = new Presensi_Server();
        String ID_Pegawai = "PET003";
        String output = pServer.getPegawai(ID_Pegawai);
        String target = "YULIASTI";
        assertEquals(target, output);
    }

    /**
     * Test of getDokter method, of class Presensi_Server.
     */
    @Test
    public void testGetDokter() throws Exception {
        System.out.println("getDokter");
        Presensi_Server pServer = new Presensi_Server();
        String ID_Dokter = "DOK001";
        String output = pServer.getDokter(ID_Dokter);
        String target = "DR. RETNO WISASTI, S";
        assertEquals(output, target);
    }
    
    /**
     * Test of getPegawaiFromPresensi method, of class Presensi_Server.
     */
    @Test
    public void testGetPegawaiFromPresensi() throws Exception {
        System.out.println("getPegawaiFromPresensi");
        Presensi output = new Presensi();
        String ID_Pegawai = "PET003";
        String tanggal = "2015-05-22";
        Presensi_Server instance = new Presensi_Server();
        output.setTanggal_masuk("2015-05-22");
        output.setId_pegawai("PET003");
        output.setJam_masuk("07:01:22");
        output.setJam_keluar("16:03:34");
        Presensi target = instance.getPegawaiFromPresensi(ID_Pegawai, tanggal);
        assertEquals(target.getTanggal_masuk(), output.getTanggal_masuk());
        assertEquals(target.getId_pegawai(), output.getId_pegawai());
        assertEquals(target.getJam_masuk(), output.getJam_masuk());
        assertEquals(target.getJam_keluar(), output.getJam_keluar());
    }

    /**
     * Test of updatePresensi method, of class Presensi_Server.
     */
    @Test
    public void testUpdatePresensi() throws Exception {
        System.out.println("updatePresensi");
        String ID = "PET003";
        String jamKel = "16:03:34";
        String jamMas = "07:01:22";
        String tanggal = "2015-05-22";
        
        
        Presensi output = new Presensi();
        output.setId_pegawai(ID);
        output.setJam_keluar(jamKel);
        output.setTanggal_masuk(tanggal);
        
        Presensi target = new Presensi();
        target.setTanggal_masuk(tanggal);
        target.setId_pegawai(ID);
        target.setJam_masuk(jamMas);
        target.setJam_keluar(jamKel);
        
        Presensi_Server instance = new Presensi_Server();
        instance.updatePresensi(output);
        output = instance.getPegawaiFromPresensi(ID, tanggal);
        
        assertEquals(target.getTanggal_masuk(), output.getTanggal_masuk());
        assertEquals(target.getId_pegawai(), output.getId_pegawai());
        assertEquals(target.getJam_masuk(), output.getJam_masuk());
        assertEquals(target.getJam_keluar(), output.getJam_keluar());
        
    }

    /**
     * Test of getPegawaiCek method, of class Presensi_Server.
     */
    @Test
    public void testGetPegawaiCek() throws Exception {
        System.out.println("getPegawaiCek");
        String ID = "PET003";
        List<Presensi> output = ps.getPegawaiCek(ID);
        List<Presensi> target = new ArrayList<>();
        Presensi p = new Presensi();
        p.setId_pegawai(ID);
        target.add(p);
        assertEquals(target.get(0).getId_pegawai(), output.get(0).getId_pegawai());
    }
}
