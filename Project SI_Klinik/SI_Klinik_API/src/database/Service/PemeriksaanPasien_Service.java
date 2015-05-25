/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Pasien;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author user
 */
public interface PemeriksaanPasien_Service extends Remote {
    List <Pasien> insertPasien (Pasien Pasien) throws RemoteException;
    List <Pasien> updatePasien(Pasien Pasien) throws RemoteException;
    List <Pasien> getPasien(String ID_Pasien) throws RemoteException;
}

