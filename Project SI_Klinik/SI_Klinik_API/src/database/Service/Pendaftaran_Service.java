/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.pendaftaran;
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
}