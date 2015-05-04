/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import GUI_StafKlinik.Panel_Laporan_Keuangan;
import ServerApplication.Service.Laporan_Keuangan_Server;
import database.entity.Laporan_Keuangan;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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
public class Test_Panel_Laporan_Keuangan {
    Panel_Laporan_Keuangan panel;
        
    public Test_Panel_Laporan_Keuangan() throws RemoteException, NotBoundException {
        panel = new Panel_Laporan_Keuangan();
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
    public void testRefreshIfAdaData() throws RemoteException {
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-05";
        panel.refresh(tanggal1, tanggal2);
        List<Laporan_Keuangan> output= panel.getlaporan();
        List<Laporan_Keuangan> target = new ArrayList<>();
        
        Laporan_Keuangan ambil = new Laporan_Keuangan();
        ambil.setTanggal("2015-04-01");
        ambil.setRef("");
        ambil.setPemasukan(0);
        ambil.setSaldo(2404000);
        target.add(ambil);
        
        
        Laporan_Keuangan ambil1 = new Laporan_Keuangan();
        ambil1.setTanggal("2015-04-01");
        ambil1.setRef("O-1");
        ambil1.setPemasukan(150000);
        ambil1.setSaldo(2554000);
        target.add(ambil1);
        
         for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
            assertEquals(target.get(i).getRef(), output.get(i).getRef());
            assertEquals(target.get(i).getPemasukan(), output.get(i).getPemasukan());
            assertEquals(target.get(i).getSaldo(), output.get(i).getSaldo());
            
         }
         
    }
    
    @Test
    public void testRefreshIfTidakAdaData() throws RemoteException {
        String tanggal1 = "2015-04-01";
        String tanggal2 = "2015-04-05";
        panel.refresh(tanggal1, tanggal2);
        List<Laporan_Keuangan> output= panel.getlaporan();
        List<Laporan_Keuangan> target = new ArrayList<>();
        
        Laporan_Keuangan ambil = new Laporan_Keuangan();
        ambil.setTanggal("2015-04-01");
        ambil.setRef("");
        ambil.setPemasukan(0);
        ambil.setSaldo(2404000);
        target.add(ambil);
        
        
        Laporan_Keuangan ambil1 = new Laporan_Keuangan();
        ambil1.setTanggal("2015-04-01");
        ambil1.setRef("O-1");
        ambil1.setPemasukan(150000);
        ambil1.setSaldo(2554000);
        target.add(ambil1);
        
         for (int i=0; i<output.size(); i++){
            assertEquals(target.get(i).getTanggal(), output.get(i).getTanggal());
            assertEquals(target.get(i).getRef(), output.get(i).getRef());
            assertEquals(target.get(i).getPemasukan(), output.get(i).getPemasukan());
            assertEquals(target.get(i).getSaldo(), output.get(i).getSaldo());
            
         }
         
    }
    
}
