/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI_StafKlinik.Panel_Registrasi_Staf;
import Form_Server.main;
import GUI_Login.Login;
import database.Service.Dokter_Service;
import database.Service.Petugas_Service;
import database.entity.dokter;
import database.entity.petugas;
import ServerApplication.Service.Petugas_Server;
import ServerApplication.Service.Dokter_Server;
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
public class Test_Registrasi_Staf {
    Petugas_Server ps;
    Dokter_Server ds;
    dokter d;
    petugas p;
    
    public Test_Registrasi_Staf() throws RemoteException{
    ps = new Petugas_Server();
    ds = new Dokter_Server();
    d = new dokter ();
    p = new petugas ();
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
    public void testValidasiRegistrasiDokter (){
    String id_dokter = "DOK001";
    String id_poli = "pol001";
    String no_ijin = "d20030001rs";
    String telp = "0315674360";
    int b = 50000;
    
    d.setid_dokter(id_dokter);
    d.setid_poli(id_poli);
    d.setno_ijin(no_ijin);
    d.settelepon_dokter(telp);
    d.settarif_dokter(b);
        assertEquals (id_dokter, d.getid_dokter());
        assertEquals (id_poli, d.getid_poli());
        assertEquals(no_ijin, d.getno_ijin());
        assertEquals (telp,d.gettelepon_dokter());
        assertEquals (b,d.gettarif_dokter());
    
}
    
     @Test
    public void testValidasiRegistrasiPetugas (){
    String id_petugas = "PET001";
    String telepon = "081330734979";
    
    p.setId_Petugas(id_petugas);
    p.setTelepon(telepon);
        assertEquals(id_petugas, p.getId_Petugas());
        assertEquals (telepon,p.getTelepon());
    
    
}
     
     @Test
    public void testValidasiReefreshPetugas (){
    String id_petugas = "PET001";
    String nama_petugas = "JESSICA";
    String alamat_petugas = "JL. KAYON NO. 3 SURABAYA TIMUR";
    String jabatan = "KASIR";
    String tanggalLahir = "1993-02-10";
    String telepon = "081330734979";
    String agama = "KRISTEN";
    
    p.setId_Petugas(id_petugas);
    p.setNama_Petugas(nama_petugas);
    p.setAlamat(agama);
    p.setJabatan(jabatan);
    p.setTanggalLahir(tanggalLahir);
    p.setTelepon(telepon);
    p.setAgama(agama);
        assertEquals(id_petugas, p.getId_Petugas());
        assertEquals (nama_petugas, p.getNama_Petugas());
        assertEquals (alamat_petugas, p.getAlamat());
        assertEquals (jabatan, p.getJabatan());
        assertEquals (tanggalLahir, p.getTanggalLahir());
        assertEquals (telepon,p.getTelepon());
        assertEquals (agama, p.getAgama());
    
}
     
     @Test
    public void testValidasiReefreshdokter (){
    String id_dokter = "DOK001";
    String id_poli = "pol001";
    String nama_dokter = "DR. RETNO WISASTI, S";
    String alamat_dokter = "JL. WR. SUPRATMAN 59 SURABAYA TIMUR/GUBENG";
    String tanggal_lahir = "1975-03-18";
    String telp = "0315674360";
    String agama = "ISLAM";
    String no_ijin = "d20030001rs";
    int tarif = 50000;
    
    d.setid_dokter(id_dokter);
    d.setid_poli(id_poli);
    d.setnama_dokter(nama_dokter);
    d.setalamat_dokter(alamat_dokter);
    d.settgl_lahir_dokter(tanggal_lahir);
    d.settelepon_dokter(telp);
    d.setagama_dokter(agama);
    d.setno_ijin(no_ijin);
    d.settarif_dokter(tarif);
        assertEquals (id_dokter, d.getid_dokter());
        assertEquals (id_poli, d.getid_poli());
        assertEquals (nama_dokter, d.getnama_dokter());
        assertEquals (alamat_dokter, d.getalamat_dokter());
        assertEquals (tanggal_lahir, d.gettgl_lahir_dokter());
        assertEquals (telp, d.gettelepon_dokter());
        assertEquals (agama, d.getagama_dokter());
        assertEquals (no_ijin, d.getagama_dokter());
        assertEquals (tarif, d.gettarif_dokter());
        
    }
}
    
    
    


