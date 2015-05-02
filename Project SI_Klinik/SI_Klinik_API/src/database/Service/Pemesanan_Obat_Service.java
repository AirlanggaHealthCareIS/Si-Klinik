/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Pemesanan_Obat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author asus
 */
public interface Pemesanan_Obat_Service extends Remote{
    Pemesanan_Obat insertPemesananObat(Pemesanan_Obat PO) throws RemoteException;
    List<Pemesanan_Obat>getPO() throws RemoteException;
}
