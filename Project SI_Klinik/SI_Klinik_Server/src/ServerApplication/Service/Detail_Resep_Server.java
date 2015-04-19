/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Detail_Resep_Service;
import database.entity.detail_resep_obat;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author JESSICA
 */
public class Detail_Resep_Server extends UnicastRemoteObject implements Detail_Resep_Service {
    
    public Detail_Resep_Server() throws RemoteException{
        
    }

    @Override
    public detail_resep_obat insertResep(detail_resep_obat resep) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateResep(detail_resep_obat resep) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public detail_resep_obat getResep(String ID_rekam) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<detail_resep_obat> getResep() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
