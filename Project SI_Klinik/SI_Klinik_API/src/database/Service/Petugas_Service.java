/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.Service;

import database.entity.petugas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Windows 8.1
 */
public interface Petugas_Service extends Remote {
    petugas insertPetugas(petugas petugas) throws RemoteException;

    void updatePetugas(petugas petugas) throws RemoteException;

    petugas getPetugas (String ID_Petugas) throws RemoteException;

}