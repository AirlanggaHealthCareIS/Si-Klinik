/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.Presensi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author tinot
 */
public interface Presensi_Service extends Remote{
    Presensi insertPresensi(Presensi supplier) throws RemoteException;
    Presensi getPegawai (String ID_Pegawai) throws RemoteException;
    Presensi getDokter (String ID_Pegawai) throws RemoteException;
}
