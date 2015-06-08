/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.jadwal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author BOCIL
 */
public interface Jadwal_Service extends Remote{
    
    List<jadwal> getJadwal (String hari) throws RemoteException;
    void ubahJadwal (String id_jadwal, String jam) throws RemoteException;
    List<String> getIDDokter() throws RemoteException;
    void insertJadwal(String id_dokter, String hari, String jam);
}
