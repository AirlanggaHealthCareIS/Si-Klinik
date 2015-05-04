/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI_Apoteker.Panel_Generate_PO;
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
 * @author asus
 */
public class Test_Generate_PO extends TestCase{
    Registry registry;
    Panel_Generate_PO PO;
    main m;
    
    public  Test_Generate_PO() throws RemoteException, NotBoundException{
    }
    
    @BeforeClass
    public static  void server() throws RemoteException, NotBoundException{
    }
    
    @AfterClass
    public static  void tearDownClass(){        
    }
    
    @After
    public void tearDown(){        
    }
    
    @Test
    public void TestGetObatKritis() throws Exception{
        
    }
}

