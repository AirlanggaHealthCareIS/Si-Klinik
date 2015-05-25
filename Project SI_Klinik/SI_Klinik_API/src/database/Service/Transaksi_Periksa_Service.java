/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Transaksi_Periksa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Indyka
 */
public interface Transaksi_Periksa_Service extends Remote{
    Transaksi_Periksa getTagihan(String id_transaksi) throws RemoteException;
    List<Transaksi_Periksa> getBPJS(int bulan) throws RemoteException;
    Transaksi_Periksa getLastTransaksi() throws RemoteException;
    Transaksi_Periksa insertTransaksi(Transaksi_Periksa a) throws RemoteException;
    List<Transaksi_Periksa> getTransaksis(String id_pasien) throws RemoteException;
}
