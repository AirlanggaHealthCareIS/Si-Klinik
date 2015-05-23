/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Detail_Resep_Server;
import database.entity.detail_resep_obat;
import java.rmi.RemoteException;
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
public class Detail_Resep_ServerTest {
    Detail_Resep_Server drs;
    public Detail_Resep_ServerTest() throws RemoteException {
        drs = new Detail_Resep_Server();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertResep method, of class Detail_Resep_Server.
     */
    @Test
    public void testInsertResep() throws Exception {
        try {
            Detail_Resep_Server pServer = new Detail_Resep_Server();
            detail_resep_obat s = new detail_resep_obat();
            s.setid_detail_resep(12);
            s.setid_rekam_medis("1-1");
            s.setid_obat("O1");
            s.setqty_detail_resep(8);
            pServer.insertResep(s);
            detail_resep_obat output = pServer.getLastResep();
            detail_resep_obat target = s;
                assertEquals(target.getid_detail_resep(), output.getid_detail_resep());
                assertEquals(target.getid_rekam_medis(), output.getid_rekam_medis());
                assertEquals(target.getid_obat(), output.getid_obat());
                assertEquals(target.getqty_detail_resep(), output.getqty_detail_resep());
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Tambah_Data_Supplier_Server.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Test
    public void getLastResep() throws Exception {
        Detail_Resep_Server pServer = new Detail_Resep_Server();
        detail_resep_obat target = new detail_resep_obat();
        target.setid_detail_resep(4);
        target.setid_rekam_medis("1-17");
        target.setid_obat("O9");
        target.setqty_detail_resep(2);
        
        detail_resep_obat output = new detail_resep_obat();
        output = pServer.getLastResep();
        
        assertEquals(target.getid_detail_resep(), output.getid_detail_resep());
        assertEquals(target.getid_rekam_medis(), output.getid_rekam_medis());
        assertEquals(target.getid_obat(), output.getid_obat());
        assertEquals(target.getqty_detail_resep(), output.getqty_detail_resep());
    }
}
