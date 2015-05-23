/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Client_Application_Model.TableModel_Resep;
import GUI_Apoteker.Panel_Resep;
import database.entity.lihatResep;
import java.awt.List;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tinot
 */
public class Panel_ResepTest {
    Panel_Resep p;
            
    public Panel_ResepTest() throws RemoteException, NotBoundException {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testListResepNotNull() throws RemoteException, NotBoundException {
        p = new Panel_Resep(2); 
        p.ceks();
        TableModel_Resep output = p.getTabel();
        TableModel_Resep target = new TableModel_Resep();
        ArrayList <lihatResep> temp = new ArrayList<>();
        lihatResep baru = new lihatResep();
        baru.setId_Pasien(2);
        baru.setId_rekam_medik("rk02");
        baru.setTanggal("2015-04-17");
        temp.add(baru);
        target.setData(temp);
        for (int i = 0; i < output.getRowCount(); i++) {
            lihatResep l= output.get(i);
            assertEquals(target.get(i).getId_Pasien(), l.getId_Pasien());
            assertEquals(target.get(i).getId_rekam_medik(), l.getId_rekam_medik());
            assertEquals(target.get(i).getTanggal(), l.getTanggal());
        }
    }
    
    @Test
    public void testListResepNull() throws RemoteException, NotBoundException {
        p = new Panel_Resep(0); 
        p.ceks();
        TableModel_Resep output = p.getTabel();
        TableModel_Resep target = new TableModel_Resep();
        ArrayList <lihatResep> temp = new ArrayList<>();
        lihatResep baru = new lihatResep();
        baru.setId_Pasien(5);
        baru.setId_rekam_medik("rk01");
        baru.setTanggal("2015-04-27");
        temp.add(baru);
        baru  = new lihatResep();
        baru.setId_Pasien(2);
        baru.setId_rekam_medik("rk02");
        baru.setTanggal("2015-04-17");
        temp.add(baru);
        target.setData(temp);        
        for (int i = 0; i < output.getRowCount(); i++) {
            lihatResep l= output.get(i);
            assertEquals(target.get(i).getId_Pasien(), l.getId_Pasien());
            assertEquals(target.get(i).getId_rekam_medik(), l.getId_rekam_medik());
            assertEquals(target.get(i).getTanggal(), l.getTanggal());
        }
        
    }

}
