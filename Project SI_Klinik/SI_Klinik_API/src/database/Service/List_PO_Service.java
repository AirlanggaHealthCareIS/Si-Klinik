/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;

import database.entity.detil_pesan_obat;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author JESSICA
 */
public interface List_PO_Service extends Remote {
    detil_pesan_obat insertListPO(detil_pesan_obat PO) throws RemoteException;
    
}
