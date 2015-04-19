/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.Tindakan_Dokter;
import database.entity.petugas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface Tindakan_Dokter_Service extends Remote {
    Tindakan_Dokter insertTindakan_Dokter(Tindakan_Dokter dokter) throws RemoteException;

    void updateTindakan_Dokter(Tindakan_Dokter dokter) throws RemoteException;

    Tindakan_Dokter getTindakan_Dokter (String Tindakan_Dokter) throws RemoteException;

    List<Tindakan_Dokter> getAllTindakan_Dokter () throws RemoteException;
}
