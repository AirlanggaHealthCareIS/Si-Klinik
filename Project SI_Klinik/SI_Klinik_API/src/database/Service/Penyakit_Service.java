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
    List<Penyakit> getPenyakitAll () throws RemoteException;
}