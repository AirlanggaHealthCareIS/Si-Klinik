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
        
        Supplier output = ss.getLastSupplier();
        Supplier target = new Supplier();
        target.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUSTR");
        assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
    }
    
//    @Test
//    public void testFieldKosong() throws RemoteException, NotBoundException{
//        f = new Form_Data_Supplier_Tambah();
//        Supplier temp = new Supplier();
//        
//        temp.setId_Supplier("");
//        temp.setNama_Supplier("");
//        temp.setAlamat_Supplier("");
//        temp.setKota_Supplier("CIMAHI");
//        temp.setTelepon_Supplier("");
//        temp.setNPWP_Supplier("");
//        temp.setKode_Pajak_Supplier("");
//        temp.setJenis_pajak_Supplier("");
////        boolean output = f.ValidateIsi();
////        System.out.println(output);
//        boolean target = true;
////        assertEquals(target, output);
////        Supplier output = ss.getLastSupplier();
////        Supplier target = new Supplier();
////        target.setNama_Supplier("PT HOLI PHARMACEUTICAL INDUSTR");
////        assertEquals(target.getNama_Supplier(), output.getNama_Supplier());
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
