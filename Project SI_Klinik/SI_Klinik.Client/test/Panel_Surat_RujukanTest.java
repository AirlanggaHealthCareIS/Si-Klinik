/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI_Dokter.Panel_Surat_Rujukan;
import database.entity.Pasien;
import database.entity.Rekam_Medis;
import database.entity.detail_Assessment;
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
 * @author Acer
 */
public class Panel_Surat_RujukanTest {
    Panel_Surat_RujukanTest sr;
   
    
    public Panel_Surat_RujukanTest() {
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

    /**
     * Test of open method, of class Panel_Surat_Rujukan.
     */
    @Test
    public void testCreateStringParagraph() {
        Pasien p = new Pasien();
        p.setNama_Pasien("Adi");
        Rekam_Medis rm = new Rekam_Medis();
        List<detail_Assessment> list = new ArrayList<detail_Assessment>();
        detail_Assessment d = new detail_Assessment();
        d.setAssessment("leukimia");        
        list.add(d);
        rm.setAssessment(list);
        String nama = "Rumah Sakit Sehat";        
        String a="";
        a = a+ "Rumah Sakit Rujukan: " +nama+"\n";
        a = a+ "Mohon konsultasi dan perawatan selanjutnya untuk: "+"\n";
        a = a+ "Nama Pasien : Adi\n";
        a = a+ "Diagnosa :leukimia\n";
        a = a+ "Demikian dan terimakasih.";
        String target = a;
        Panel_Surat_Rujukan panel = new Panel_Surat_Rujukan(rm,p, nama);
        String output = panel.createStringParagraph();
        System.out.println(output);
        System.out.println("");
        System.out.println(target);
        assertEquals(target, output);
    }
}
