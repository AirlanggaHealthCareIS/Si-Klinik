/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.Service;

import database.entity.Penggajian;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author Windows 8.1
 */
public interface Penggajian_Service extends Remote {
   List<Penggajian> getPenggajianSemuaPegawai (String tanggal1, String tanggal2) throws RemoteException;
   List<Penggajian> getPenggajianNonDokter (String tanggal1, String tanggal2) throws RemoteException;
   List<Penggajian> getPenggajianDokter (String tanggal1, String tanggal2) throws RemoteException;
   List<Penggajian> getGajiPeriksa (String tanggal1, String tanggal2) throws RemoteException;
}
