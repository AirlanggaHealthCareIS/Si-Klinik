/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI_Login.Login;
import Form_Server.main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
public class Test_Login extends TestCase{
    Registry registry;
    Login l;
    main m;
    
    public Test_Login() throws RemoteException, NotBoundException {        
    }

    @BeforeClass
    public static void server() throws RemoteException, NotBoundException {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws RemoteException {   
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testValidateLoginIfKasir() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "PET001";
        String password = "PET001JESS";
        l.setUsernamePassword(id, password);        
        boolean output = l.ValidateLogin();
        boolean target = true;
        assertEquals(target, output);
        assertEquals("KASIR", l.jabatan);
        assertEquals (false,l.aktorIniDokter);
    }
    
    @Test
    public void testValidateLoginIfApoteker() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "PET004";
        String password = "pet004mell";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = true;
        assertEquals(target, output);
        assertEquals("APOTEKER", l.jabatan);
        assertEquals (false,l.aktorIniDokter);
    }
    
    @Test
     public void testValidateLoginIfDokter() throws RemoteException, NotBoundException{
        l = new Login();        
        String id = "DOK001";
        String password = "dok001retn";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = true;
        assertEquals(target, output);
        assertEquals (true,l.aktorIniDokter);
    }
    
     @Test
    public void testValidateLoginIfPasswordFalse() throws RemoteException, NotBoundException{
        l = new Login();
        
        String id = "PET001";
        String password = "1";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = false;
        assertEquals(target, output);
        assertEquals(Color.white, l.getColorNama());
        assertEquals(Color.red, l.getColorPass());
        assertEquals(true,l.getBooleanjLabel7());
        assertEquals(false,l.getBooleanjLabel8());
    }
     
     @Test
    public void testValidateLoginIfPasswordNull() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "PET001";
        String password = "";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = false;
        assertEquals(target, output);
        assertEquals(Color.white, l.getColorNama());
        assertEquals(Color.red, l.getColorPass());
        assertEquals(true,l.getBooleanjLabel7());
        assertEquals(false,l.getBooleanjLabel8());
    }
     
      @Test
    public void testValidateLoginIfStafKlinik() throws RemoteException, NotBoundException{
          l = new Login();       
          String id = "PET006";
        String password = "pet006merr";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = true;
        assertEquals(target, output);
        assertEquals("PERAWAT", l.jabatan);
        assertEquals (false,l.aktorIniDokter);
    }
      
       @Test
    public void testValidateLoginIfBothUsernamePasswordFalse() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "001";
        String password = "1";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = false;
        assertEquals(target, output);
        assertEquals(Color.red, l.getColorNama());
        assertEquals(Color.red, l.getColorPass());
        assertEquals(true,l.getBooleanjLabel7());
        assertEquals(true,l.getBooleanjLabel8());
    }
       
         @Test
    public void testValidateLoginIfBothUsernamePasswordNull() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "";
        String password = "";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = false;
        assertEquals(target, output);
        assertEquals(Color.red, l.getColorNama());
        assertEquals(Color.red, l.getColorPass());
        assertEquals(true,l.getBooleanjLabel7());
        assertEquals(true,l.getBooleanjLabel8());
    }
         
           @Test
    public void testValidateLoginIfUsernameFalse() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "001";
        String password = "dok001retn";
        l.setUsernamePassword(id, password);
        boolean output = l.ValidateLogin();
        boolean target = false;
        assertEquals(target, output);
        assertEquals(Color.red, l.getColorNama());
        assertEquals(Color.red, l.getColorPass());
        assertEquals(true,l.getBooleanjLabel7());
        assertEquals(true,l.getBooleanjLabel8());
    }
   
    @Test
    public void testStartRegistry() throws RemoteException, NotBoundException{
        l = new Login();
        String id = "DOK001";
        String password = "dok001retn";
        l.setUsernamePassword(id, password);
        l.ValidateLogin();
        l.startRegistry();
        assertNotNull(l.service3);
        assertNotNull(l.service4);
        assertNotNull(l.service5);
        assertNotNull(l.service6);
        assertNotNull(l.service7);
        assertNotNull(l.service8);
        assertNotNull(l.service10);
        assertNotNull(l.service12);
        assertNotNull(l.service13);
        assertNotNull(l.service14);
        assertNotNull(l.service15);
        assertNotNull(l.service16);
        assertNotNull(l.service17);
        assertNotNull(l.service18);
        assertNotNull(l.service19);
        assertNotNull(l.service20);
        assertNotNull(l.service21);
        assertNotNull(l.service22);
    }
    
    
}

