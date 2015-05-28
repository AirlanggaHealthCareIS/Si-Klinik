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
        List<obat_kritis> output = ok.getObatKritis();
        List<obat_kritis> target = new ArrayList<>();
        obat_kritis ambil = new obat_kritis();
        ambil.setID_OBAT("O1");
        ambil.setNAMA_OBAT("IBUPROFEN");
        ambil.setNAMA_SUPPLIER("PT GRACIA PHARMINDO");
        //ambil.setSELISIH(Integer.parseInt("2"));
        target.add(ambil);
        ambil = new obat_kritis();
        ambil.setID_OBAT("O2");
        ambil.setNAMA_OBAT("PROFEN");
        ambil.setNAMA_SUPPLIER("PT GRACIA PHARMINDO");
        target.add(ambil);
        ambil = new obat_kritis();
        ambil.setID_OBAT("O3");
        ambil.setNAMA_OBAT("PARASETAMOL");
        ambil.setNAMA_SUPPLIER("PT COMPHIPAR");
        //ambil.setSELISIH(Integer.parseInt("2"));
        target.add(ambil);
        ambil = new obat_kritis();
        ambil.setID_OBAT("O5");
        ambil.setNAMA_OBAT("AMOXCILIN");
        ambil.setNAMA_SUPPLIER("PT HOLI PHARMACEUTICAL INDUSTR");
        //ambil.setSELISIH(Integer.parseInt("2"));
        target.add(ambil);
        for(int i = 0; i<output.size(); i++){
            assertEquals(target.get(i).getID_OBAT(), output.get(i).getID_OBAT());
            assertEquals(target.get(i).getNAMA_OBAT(), output.get(i).getNAMA_OBAT());
            assertEquals(target.get(i).getNAMA_SUPPLIER(), output.get(i).getNAMA_SUPPLIER());
            //assertEquals(target.get(i).getSELISIH(), output.get(i).getSELISIH());
        }
    }
    
    @Test
    public void testGetPO() throws Exception{
        System.out.println("getPO");
        List<Pemesanan_Obat> output = po.getPO();
        List<Pemesanan_Obat> target = new ArrayList<>();
        Pemesanan_Obat ambil = new Pemesanan_Obat();
        ambil.setId_Pemesnan_obat("PO2");
        ambil.setId_supplier("SUP003");
        ambil.setTgl_Pemesanan("2015-05-21");
        target.add(ambil);
        ambil = new Pemesanan_Obat();
        ambil.setId_Pemesnan_obat("PO3");
        ambil.setId_supplier("SUP003");
        ambil.setTgl_Pemesanan("2015-05-21");
        target.add(ambil);
        ambil = new Pemesanan_Obat();
        ambil.setId_Pemesnan_obat("PO4");
        ambil.setId_supplier("SUP003");
        ambil.setTgl_Pemesanan("2015-05-21");
        target.add(ambil);
        for(int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getId_Pemesanan_obat(), output.get(i).getId_Pemesanan_obat());
            assertEquals(target.get(i).getId_supplier(), output.get(i).getId_supplier());
            assertEquals(target.get(i).getTgl_Pemesanan(), output.get(i).getTgl_Pemesanan());
        }
    }
}
