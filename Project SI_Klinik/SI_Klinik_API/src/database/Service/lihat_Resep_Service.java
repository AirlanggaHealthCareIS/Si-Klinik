/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.lihatResep;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author tinot
 */
public interface lihat_Resep_Service extends Remote {
    List<lihatResep> getLihatResep() throws RemoteException;
    List<lihatResep> getLihatResep(int id) throws RemoteException;
}
