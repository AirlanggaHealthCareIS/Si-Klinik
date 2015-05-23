/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Penyakit;
import database.entity.detail_Assessment;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public interface Penyakit_Service extends Remote {
    Penyakit insertPenyakit(Penyakit penyakit) throws RemoteException;
    void updatePenyakit(Penyakit penyakit) throws RemoteException;
    Penyakit getId_Penyakit (String Nama_Penyakit) throws RemoteException;   
    Penyakit getPenyakit (String ID_Penyakit) throws RemoteException;
    List<Penyakit> getPenyakitAll () throws RemoteException;
    Penyakit getLastPenyakit()throws RemoteException;
}