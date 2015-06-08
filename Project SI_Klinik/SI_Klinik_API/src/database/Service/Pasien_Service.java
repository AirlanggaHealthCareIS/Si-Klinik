/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Pasien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Windows 8.1
 */
public interface Pasien_Service extends Remote {
    Pasien insertPasien(Pasien Pasien) throws RemoteException;

    void updatePasien(Pasien Pasien) throws RemoteException;

    Pasien getPasien (String ID_Pasien) throws RemoteException;

    List<Pasien> getAllPasien() throws RemoteException;
    
    Pasien getPasienFromNama (String Nama_Pasien) throws RemoteException;
}