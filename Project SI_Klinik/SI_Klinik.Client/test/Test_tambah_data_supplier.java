/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import GUI_Apoteker.Form_Data_Supplier_Tambah;
import ServerApplication.Service.Supplier_Server;
import database.entity.Supplier;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import junit.framework.TestCase;

/**
 *
 * @author user
 */
public class Test_tambah_data_supplier {
    Form_Data_Supplier_Tambah f;
    Supplier_Server ss;
    
    public Test_tambah_data_supplier() throws RemoteException {
        
        ss = new Supplier_Server();
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
    public void testNamaSupplierSudahAda() throws RemoteException, NotBoundException{        
//        Supplier output = ss.getLastSupplier();
//        Supplier target = new Supplier();
//        target.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUST");
//        assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
        f = new Form_Data_Supplier_Tambah();        
        f.setNama("PT HOLI PHARMACEUTICAL INDUST");        
        boolean output = f.cekNamaSupplierSudahAda();        
        boolean target = true;
        assertEquals(target, output);
    }
    
     @Test
    public void testTambahSupplierBenar() throws RemoteException, NotBoundException{        
//        Supplier output = ss.getLastSupplier();
//        Supplier target = new Supplier();
//        target.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUST");
//        assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
        f = new Form_Data_Supplier_Tambah();
        Supplier sup = new Supplier();
        sup.setNama_Supplier("Merry");
        sup.setAlamat_Supplier("Jalan lalala");
        sup.setJenis_pajak_Supplier("jenispajak");
        sup.setKode_Pajak_Supplier("018298128");
        sup.setKota_Supplier("surabaya");
        sup.setNPWP_Supplier("17987");
        sup.setTelepon_Supplier("08129127676");
        f.setNama(sup.getNama_Supplier());        
        f.setAlamat(sup.getAlamat_Supplier());
        f.setJenisPajak(sup.getJenis_pajak_Supplier());
        f.setKodePajak(sup.getKode_Pajak_Supplier());
        f.setNPWP(sup.getNPWP_Supplier());
        f.setKota(sup.getKota_Supplier());
        f.setTelp(sup.getTelepon_Supplier());
        boolean output = f.TambahSupplier();
        boolean target = true;
        assertEquals(target, output);
        Supplier s = ss.getLastSupplier();
        assertEquals(s.getNama_Supplier(), sup.getNama_Supplier());
        assertEquals(s.getAlamat_Supplier(), sup.getAlamat_Supplier());
        assertEquals(s.getJenis_pajak_Supplier(), sup.getJenis_pajak_Supplier());
        assertEquals(s.getKode_Pajak_Supplier(), sup.getKode_Pajak_Supplier());
        assertEquals(s.getKota_Supplier(), sup.getKota_Supplier());
        assertEquals(s.getNPWP_Supplier(), sup.getNPWP_Supplier());
        assertEquals(s.getTelepon_Supplier(), sup.getTelepon_Supplier());
    }
    
    @Test
    public void testFieldKosong() throws RemoteException, NotBoundException{
        f = new Form_Data_Supplier_Tambah();
        Supplier temp = new Supplier();
        temp.setId_Supplier("");
        temp.setNama_Supplier("");
        temp.setAlamat_Supplier("");
        temp.setKota_Supplier("CIMAHI");
        temp.setTelepon_Supplier("");
        temp.setNPWP_Supplier("");
        temp.setKode_Pajak_Supplier("");
        temp.setJenis_pajak_Supplier("");
        boolean output = f.TambahSupplier();
        System.out.println(output);
        boolean target = false;
        assertEquals(target, output);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
