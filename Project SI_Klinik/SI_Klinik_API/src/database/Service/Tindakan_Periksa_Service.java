/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.Tindakan_Periksa ;
import database.entity.petugas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/**
 *
 * @author Acer
 */
public interface Tindakan_Periksa_Service extends Remote {
   Tindakan_Periksa insertTindakan_Periksa(Tindakan_Periksa periksa) throws RemoteException;
//
//    void updateTindakan_Periksa(Tindakan_Periksa periksa) throws RemoteException;
//
//    Tindakan_Periksa getTindakan_Periksa (String Tindakan_Periksa) throws RemoteException;

    
}
