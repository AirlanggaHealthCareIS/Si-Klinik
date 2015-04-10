/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.detail_resep_obat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author tinot
 */
public interface Resep_Service extends Remote{
    detail_resep_obat insertResep(detail_resep_obat resep) throws RemoteException;

    void updateResep(detail_resep_obat resep) throws RemoteException;

    detail_resep_obat getResep (String ID_Petugas) throws RemoteException;

    List<detail_resep_obat> getResep() throws RemoteException;
}
