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
    String no_ijin = "d20030001rs";
    String telp = "0315674360";
    int b = 50000;
    
    d.setno_ijin(no_ijin);
    d.settelepon_dokter(telp);
    d.settarif_dokter(b);
        assertEquals(no_ijin, d.getno_ijin());
        assertEquals (telp,d.gettelepon_dokter());
        assertEquals (b,d.gettarif_dokter());
    
}
    // buat 
    
}
    //public void testValidateRegistrasiDokter throws RemoteException, NotBoundException{
      // ds = new Login();
       // String id = "PET001";
       // String password = "PET001JESS";
       // l.setUsernamePassword(id, password);        
       // boolean output = l.ValidateLogin();
       // boolean target = true;
       // assertEquals(target, output);
       // assertEquals("KASIR", l.jabatan);
       // assertEquals (false,l.aktorIniDokter);
    
    


