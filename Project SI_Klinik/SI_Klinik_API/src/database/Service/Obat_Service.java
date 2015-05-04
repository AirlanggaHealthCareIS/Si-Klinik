/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.obat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author Administrator
 */
public interface Obat_Service extends Remote {
    obat insertObat(obat obat) throws RemoteException;

    void updateObat(obat obat) throws RemoteException;

    obat getObat (String id_obat) throws RemoteException;
    
    List getObatList(String nama) throws RemoteException;
    
    List<obat> getAllObat () throws RemoteException;
    
    List<obat> getAllObatSort () throws RemoteException;
    
    String getIdObat(String nama) throws RemoteException;
    
    List<obat> getObatKritis() throws RemoteException;
    
    obat getLastObat() throws RemoteException;
}
