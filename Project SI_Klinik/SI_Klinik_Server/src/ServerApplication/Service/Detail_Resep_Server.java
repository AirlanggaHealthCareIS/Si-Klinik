/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Detail_Resep_Service;
import database.entity.detail_resep_obat;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import si_klinik_server.DatabaseUtilities;

/**
 *
 * @author MELINDA
 */
public class Detail_Resep_Server extends UnicastRemoteObject implements Detail_Resep_Service {
    
    public Detail_Resep_Server() throws RemoteException{
        
    }

    @Override
    public detail_resep_obat insertResep(detail_resep_obat resep) throws RemoteException {
        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO detail_resep_obat (ID_DETAIL_RESEP, ID_REKAM_MEDIS, ID_OBAT, QTY_DETAIL_RESEP)"
                + " VALUES (null, ?, ?, ?)"
        );
        
        //statement.setString(1, resep.getid_detail_resep());
        statement.setString(1, resep.getid_rekam_medis());
        statement.setString(2, resep.getid_obat());
        statement.setInt(3, resep.getqty_detail_resep());
        
        statement.executeUpdate();
        
        return resep;
        }
        catch(SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement != null){
                try{
                   statement.close();
                }catch(SQLException exception){

                }
            }
        }
    }

    @Override
    public detail_resep_obat getLastResep() throws RemoteException {
        System.out.println("proses get LAST RESEP");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM detail_resep_obat ORDER BY ID_DETAIL_RESEP DESC LIMIT 1");
            detail_resep_obat a = null;
            while(result.next()){
                a = new detail_resep_obat();
                a.setid_detail_resep((result.getInt("ID_DETAIL_RESEP")));
                a.setid_rekam_medis(result.getString("ID_REKAM_MEDIS"));
                a.setid_obat(result.getString("ID_OBAT"));
                a.setqty_detail_resep(result.getInt("QTY_DETAIL_RESEP"));
            }    
            result.close();
            return a;
        } 
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException  exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

}
