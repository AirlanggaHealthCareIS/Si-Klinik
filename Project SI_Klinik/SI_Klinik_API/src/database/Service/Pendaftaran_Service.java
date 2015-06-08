/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.dokter;
import database.entity.pendaftaran;
import database.entity.poliklinik;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public interface Pendaftaran_Service extends Remote {
    pendaftaran insertPendaftaran(pendaftaran Pendaftaran) throws RemoteException;
    void updatePendaftaran(pendaftaran Pendaftaran) throws RemoteException;
    pendaftaran getPendaftaran (String ID_Pendaftaran) throws RemoteException;
    List<pendaftaran> getPendaftarans(String tanggal) throws RemoteException;
    List<poliklinik> getPoli() throws RemoteException;
    List<dokter> GetDokter(String id_poli) throws RemoteException;
    poliklinik getPoliFromNama(String nama) throws RemoteException;
    int getJumlahAntrianDokter(String id_dokter, String id_poli) throws RemoteException;
}