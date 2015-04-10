/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Service;
import database.entity.Supplier;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author user
 */
public interface Supplier_Service  extends Remote{
    Supplier insertSupplier(Supplier supplier) throws RemoteException;

    void updateSupplier(Supplier supplier) throws RemoteException;

    Supplier getSupplier (String ID_Supplier) throws RemoteException;
    List<Supplier> getSupliers() throws RemoteException;
    
}
