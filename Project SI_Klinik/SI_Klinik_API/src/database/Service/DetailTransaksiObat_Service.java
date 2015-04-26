/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Transaksi_Obat;
import database.entity.detail_Assessment;
import database.entity.detail_transaksi_obat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public interface DetailTransaksiObat_Service extends Remote {
    detail_transaksi_obat insertDTO(detail_transaksi_obat dto) throws RemoteException;
}