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
    Presensi insertPresensi(Presensi presensi) throws RemoteException;
    void updatePresensi(Presensi presensi) throws RemoteException;
    String getPegawai (String ID_Pegawai) throws RemoteException;
    Presensi getPegawaiFromPresensi (String ID_Pegawai, String tanggal) throws RemoteException;
    String getDokter (String ID_Pegawai) throws RemoteException;
    List<Presensi> getPegawaiCek(String ID) throws RemoteException;
    Presensi getLastPresensi() throws RemoteException;
}
