/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Obat_Server;
import ServerApplication.Service.pemesanan_obat_server;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import database.entity.obat_kritis;
import database.entity.Pemesanan_Obat;
import database.entity.obat;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
        
/**
 *
 * @author asus
 */
public class Test_Generate_PO {
    Obat_Server ok;
    pemesanan_obat_server po;
    
    public Test_Generate_PO(){
        try {
            ok = new Obat_Server();
            po = new pemesanan_obat_server();
        } catch (Exception e) {
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
    
    @Test
    public void testGetObatKritis() throws Exception{
        System.out.println("getobatkritis");
        //List<obat> output = ok.getObatKritis();
        List<obat> target = new ArrayList<>();
        obat ambil = new obat();
        ambil.setid_obat("O1");
        ambil.setnama_obat("IBUPROFEN");
        target.add(ambil);
        ambil = new obat();
        ambil.setid_obat("O2");
        ambil.setnama_obat("PROFEN");
        target.add(ambil);
        ambil = new obat();
        ambil.setid_obat("O3");
        ambil.setnama_obat("PARASETAMOL");
        target.add(ambil);
////        for(int i = 0; i<output.size(); i++){
////            assertEquals(target.get(i).getid_obat(), output.get(i).getid_obat());
////            assertEquals(target.get(i).getnama_obat(), output.get(i).getnama_obat());
////        }
    }
    
    @Test
    public void testGetPO() throws Exception{
        System.out.println("getPO");
        List<Pemesanan_Obat> output = po.getPO();
        List<Pemesanan_Obat> target = new ArrayList<>();
        Pemesanan_Obat ambil = new Pemesanan_Obat();
        ambil.setId_Pemesnan_obat("PO1");
        ambil.setId_supplier("SUP001");
        ambil.setTgl_Pemesanan("2015-04-08");
        target.add(ambil);
        for(int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getId_Pemesanan_obat(), output.get(i).getId_Pemesanan_obat());
            assertEquals(target.get(i).getId_supplier(), output.get(i).getId_supplier());
            assertEquals(target.get(i).getTgl_Pemesanan(), output.get(i).getTgl_Pemesanan());
        }
    }
}
