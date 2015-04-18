/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.detail_lihat_resep;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author tinot
 */
public interface Detail_Lihat_Resep_Service extends Remote{
    List<detail_lihat_resep> getLihatResep(String resep) throws RemoteException;
    List<detail_lihat_resep> getLihatResepDetail(String resep) throws RemoteException;
}
