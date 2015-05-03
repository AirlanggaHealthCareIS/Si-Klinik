/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ServerApplication.Service.Dokter_Server;
import ServerApplication.Service.Petugas_Server;
import database.entity.dokter;
import database.entity.petugas;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author JESSICA
 */
public class Test_Server_Login extends TestCase{
    Petugas_Server ps ;
    Dokter_Server ds;
    
    public Test_Server_Login() {
        try {
            ps = new Petugas_Server();
            ds = new Dokter_Server();
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Server_Login.class.getName()).log(Level.SEVERE, null, ex);
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
    public void testGetPetugas(){
        try {
            String idPetugas = "PET001";
            String username = "PET001JESS";
            petugas output = ps.getPetugas(idPetugas,username);
            petugas target = new petugas();
            target.setId_Petugas("PET001");
            target.setNama_Petugas("JESSICA");
            target.setJabatan("KASIR");
            target.setAlamat("JL. KAYON NO. 3 SURABAYA TIMUR");
            target.setTelepon("081330734979");
            target.setTanggalLahir("1993-02-10");
            target.setJenKel("P");
            target.setAgama("KRISTEN");
            target.setPassword("PET001JESS");
            assertEquals(target.getId_Petugas(), output.getId_Petugas());
            assertEquals(target.getNama_Petugas(),output.getNama_Petugas());
            assertEquals(target.getJabatan(),output.getJabatan());            
            assertEquals(target.getAlamat(), output.getAlamat());
            assertEquals(target.getTelepon(), output.getTelepon());
            assertEquals(target.getTanggalLahir(), output.getTanggalLahir());
            assertEquals(target.getJenKel(), output.getJenKel());            
            assertEquals(target.getAgama(), output.getAgama());
            assertEquals(target.getPassword(), output.getPassword());
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Server_Login.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    @Test
    public void testGetDokter(){
        try {
            String idDokter = "DOK001";
            String password = "dok001retn";
            dokter output = ds.getDokter(idDokter,password);
            dokter target = new dokter();
            target.setid_dokter("DOK001");   
            target.setid_poli("pol001");
            target.setnama_dokter("DR. RETNO WISASTI, S");
            target.setalamat_dokter("JL. WR. SUPRATMAN 59 SURABAYA TIMUR/GUBENG");
            target.settgl_lahir_dokter("1975-03-18");
            target.settelepon_dokter("0315674360");
            target.setjenis_kelamin_dokter("P");
            target.setagama_dokter("ISLAM");
            target.setpassword_dokter("dok001retn");
            target.setno_ijin("d20030001rs");
            target.settarif_dokter(50000);            
            assertEquals(target.getid_dokter(), output.getid_dokter());
            assertEquals(target.getid_poli(),output.getid_poli());
            assertEquals(target.getnama_dokter(),output.getnama_dokter());
            assertEquals(target.getalamat_dokter(),output.getalamat_dokter());
            assertEquals(target.gettgl_lahir_dokter(),output.gettgl_lahir_dokter());
            assertEquals(target.gettelepon_dokter(),output.gettelepon_dokter());
            assertEquals(target.getjenis_kelamin_dokter(),output.getjenis_kelamin_dokter());
            assertEquals(target.getagama_dokter(),output.getagama_dokter());
            assertEquals(target.getpassword_dokter(),output.getpassword_dokter());
            assertEquals(target.getno_ijin(),output.getno_ijin());
            assertEquals(target.gettarif_dokter(),output.gettarif_dokter());                    
        } catch (RemoteException ex) {
            Logger.getLogger(Test_Server_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
