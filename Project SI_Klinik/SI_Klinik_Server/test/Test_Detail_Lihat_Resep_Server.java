/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Detail_Lihat_Resep_Server;
import database.entity.detail_lihat_resep;
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
public class Test_Detail_Lihat_Resep_Server {
    Detail_Lihat_Resep_Server dls;
    
    public Test_Detail_Lihat_Resep_Server() {
        try {
            dls = new Detail_Lihat_Resep_Server();
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Lihat_Resep_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLihatResep method, of class Detail_Lihat_Resep_Server.
     */
    @Test
    public void testGetLihatResep() throws Exception {
        System.out.println("getLihatResep");
        String rekam = "rk01";
        List<detail_lihat_resep> output = dls.getLihatResep(rekam);
        List<detail_lihat_resep> target = new ArrayList<>();
        detail_lihat_resep ambil = new detail_lihat_resep();
        ambil.setId_Pasien(5);
        ambil.setNamaPasien("DEWI");
        ambil.setNama_Dokter("DR. I NYOMAN ADNYANA");
        ambil.setTanggal("2015-04-27");
        target.add(ambil);
        assertEquals(target.get(0).getId_Pasien(), output.get(0).getId_Pasien());
        assertEquals(target.get(0).getNama_Pasien(), output.get(0).getNama_Pasien());
        assertEquals(target.get(0).getNama_Dokter(), output.get(0).getNama_Dokter());
        assertEquals(target.get(0).getTanggal(), output.get(0).getTanggal());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLihatResepDetail method, of class Detail_Lihat_Resep_Server.
     */
    @Test
    public void testGetLihatResepDetail() throws Exception {
        System.out.println("getLihatResepDetail");
        String rekam = "rk01";
        List<detail_lihat_resep> output = dls.getLihatResepDetail(rekam);
        List<detail_lihat_resep> target = new ArrayList<>();
        detail_lihat_resep ambil = new detail_lihat_resep();
        ambil.setObat("BATUK");
        ambil.setQty(6);
        target.add(ambil);
        
        assertEquals(target.get(0).getObat(), output.get(0).getObat());
        assertEquals(target.get(0).getQty(), output.get(0).getQty());
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
