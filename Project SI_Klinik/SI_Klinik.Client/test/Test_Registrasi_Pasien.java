/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI_StafKlinik.Panel_Registrasi_Pasien;
import Form_Server.main;
import GUI_Login.Login;
import database.Service.Pasien_Service;
import database.entity.Pasien;
import ServerApplication.Service.Pasien_Server;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author user
 */
public class Test_Registrasi_Pasien {
    Pasien_Server ps;
    Pasien p;
    
    public Test_Registrasi_Pasien() throws RemoteException{
     p = new Pasien ();
     ps = new Pasien_Server ();
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
    public void testValidasiRegistrasiPasien (){
        String id_pasien = "";
        String no_telp = "";
        String no_bpjs = "";
        
        p.setId_Pasien(id_pasien);
        p.setNomor_Telepon(no_telp);
        p.setNomor_BPJS_Pasien(no_bpjs);
            assertEquals (id_pasien, p.getId_Pasien());
            assertEquals (no_telp, p.getNomor_Telepon());
            assertEquals (no_bpjs, p.getNomor_BPJS_Pasien());
    }
    
    @Test
    public void testValidasiReefreshPetugas (){
     String Id_Pasien = "";
     String Nama_Pasien = "";
     String Alamat = "";
     String Jenis_Kelamin = "";
     String Tempat_Lahir = "";
     String Tanggal_Lahir = "";
     String Nomor_Telepon = "";
     String Umur = " ";
     String Agama = " ";
     String Pekerjaan = " ";
     String Nomor_BPJS_Pasien = " ";
     String Golongan_Darah = " ";
     String suku = " ";
     String status = " ";
     
     p.setId_Pasien(Id_Pasien);
     p.setNama_Pasien(Nama_Pasien);
     p.setAlamat(Alamat);
     p.setJenis_Kelamin(Jenis_Kelamin);
     p.setTempat_Lahir(Tempat_Lahir);
     p.setTanggal_Lahir(Tanggal_Lahir);
     p.setNomor_Telepon(Nomor_Telepon);
     p.setUmur(Umur);
     p.setAgama(Agama);
     p.setPekerjaan(Pekerjaan);
     p.setNomor_BPJS_Pasien(Nomor_BPJS_Pasien);
     p.setGolongan_Darah(Golongan_Darah);
     p.setSuku(suku);
     p.setStatus(status);
        assertEquals (Id_Pasien, p.getId_Pasien());
        assertEquals (Nama_Pasien, p.getNama_Pasien());
        assertEquals (Alamat, p.getAlamat());
        assertEquals (Jenis_Kelamin, p.getJenis_Kelamin());
        assertEquals (Tempat_Lahir, p.getTempat_Lahir());
        assertEquals (Tanggal_Lahir, p.getTanggal_Lahir());
        assertEquals (Nomor_Telepon, p.getNomor_Telepon());
        assertEquals (Umur, p.getUmur());
        assertEquals (Agama, p.getAgama());
        assertEquals (Pekerjaan, p.getPekerjaan());
        assertEquals (Nomor_BPJS_Pasien, p.getNomor_BPJS_Pasien());
        assertEquals (Golongan_Darah, p.getGolongan_Darah());
        assertEquals (suku, p.getSuku());
        assertEquals (status, p.getStatus());
        
    }
    }


