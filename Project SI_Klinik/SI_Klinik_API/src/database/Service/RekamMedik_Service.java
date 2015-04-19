/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.Rekam_Medis;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public interface RekamMedik_Service extends Remote{
    Rekam_Medis insertRekamMedik(Rekam_Medis rekam) throws RemoteException;
    void updateRekamMedik(Rekam_Medis rekam) throws RemoteException;
    Rekam_Medis getRekamMedik (String ID_Rekam) throws RemoteException;
    List<Rekam_Medis> getRekamMediks(String ID_Pasien) throws RemoteException;
    Rekam_Medis getLastRekamMedik (String ID_Pasien) throws RemoteException;
}
