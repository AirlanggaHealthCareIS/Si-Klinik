/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Transaksi_Periksa;
import java.rmi.RemoteException;

/**
 *
 * @author Indyka
 */
public interface Transaksi_Periksa_Service {

    Transaksi_Periksa getTransaksi(String id_pasien) throws RemoteException;
}
