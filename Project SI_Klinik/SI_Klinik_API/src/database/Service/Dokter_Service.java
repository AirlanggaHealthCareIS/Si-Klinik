/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.Service;

import database.entity.dokter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Windows 8.1
 */
public interface Dokter_Service extends Remote {
    dokter insertDokter(dokter dokter) throws RemoteException;

    void updateDokter(dokter dokter) throws RemoteException;

    dokter getDokter (String ID_Dokter) throws RemoteException;

    dokter getDokter (String ID_Dokter, String Password_Dokter) throws RemoteException;
}