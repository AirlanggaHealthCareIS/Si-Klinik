/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Tindakan_Periksa_Service;
import database.entity.Tindakan_Periksa;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import si_klinik_server.DatabaseUtilities;

/**
 *
 * @author Acer
 */
public class Tindakan_Periksa_Server extends UnicastRemoteObject implements Tindakan_Periksa_Service {
    
    public Tindakan_Periksa_Server() throws RemoteException{
        
    }

    @Override
    public Tindakan_Periksa insertTindakan_Periksa(Tindakan_Periksa periksa) throws RemoteException {
        System.out.println("proses insert Transaksi periksa");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `tindakan_periksa`(`ID_TINDAKAN_PERIKSA`, `ID_REKAM_MEDIS`, `ID_TINDAKAN_DOKTER`, `ID_TRANSAKSI_PERIKSA`) VALUES (null,?,?,?)");
            
            statement.setString(1, periksa.getId_Rekam_Medis());
            statement.setString(2, periksa.getId_Tindakan_Dokter());
            statement.setString(3, periksa.getId_Transaksi_Periksa());
            statement.execute();
            
            return periksa;
        }
        catch(SQLException exception){
            return null;
        }
        finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

}
