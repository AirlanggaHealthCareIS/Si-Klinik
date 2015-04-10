/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.Service;

import database.entity.Laporan_Keuangan;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Windows 8.1
 */
public interface Laporan_Keuangan_Service extends Remote {
    Laporan_Keuangan getLaporanKeuangan (String tanggal1, String tanggal2) throws RemoteException;
    List<Laporan_Keuangan> getLaporanKeuangan() throws RemoteException;
}
