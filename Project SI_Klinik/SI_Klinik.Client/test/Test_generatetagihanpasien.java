
import GUI_Kasir.Panel_generatetagihanpasien;
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Indyka
 */
public class Test_generatetagihanpasien extends TestCase{
    
    Registry registry;
    Panel_generatetagihanpasien Panel;
    main m;
    
    public Test_generatetagihanpasien() throws RemoteException, NotBoundException {        
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
    public void testCariTagihanIfNull() throws RemoteException, NotBoundException{
        Panel = new Panel_generatetagihanpasien();
        String id_pasien = "";
        Panel.setId_pasien(id_pasien);
        boolean output = Panel.validateIdPasien();
        boolean target = true;
        assertEquals(target, output);
        assertEquals("ISI", Panel.validateIdPasien());
        assertEquals (false,Panel.validateIdPasien());
    }
    
    @Test
    public void testSelectedRowIfNull() throws RemoteException, NotBoundException{
        Panel = new Panel_generatetagihanpasien();
        int selectedRow = 0;
        Panel.setSelectedRow(selectedRow);
        boolean output = Panel.validateSelectedRow();
        boolean target = true;
        assertEquals(target, output);
        assertEquals("ISI", Panel.validateSelectedRow());
        assertEquals (false,Panel.validateSelectedRow());
    }
    
       
    
}
