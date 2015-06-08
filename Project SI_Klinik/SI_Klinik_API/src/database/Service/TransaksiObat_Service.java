/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Transaksi_Obat;
import database.entity.detail_Assessment;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public interface TransaksiObat_Service extends Remote {
    Transaksi_Obat insertTO(Transaksi_Obat to) throws RemoteException;
    Transaksi_Obat getLastTO() throws RemoteException;
    Transaksi_Obat getTO(String id_transaksi_obat) throws RemoteException;
}