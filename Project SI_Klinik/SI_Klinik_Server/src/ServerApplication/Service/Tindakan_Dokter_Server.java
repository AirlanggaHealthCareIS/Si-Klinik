/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
import database.Service.Petugas_Service;
import database.entity.Tindakan_Dokter ;
import database.Service.Tindakan_Dokter_Service;
import database.entity.petugas;
import si_klinik_server.DatabaseUtilities;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Acer
 */
public class Tindakan_Dokter_Server extends UnicastRemoteObject implements Tindakan_Dokter_Service {
    
    public Tindakan_Dokter_Server() throws RemoteException{
        
    }
    
    public Tindakan_Dokter insertTindakan_Dokter (Tindakan_Dokter dokter) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Insert");
        
        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
                    "INSERT INTO tindakan dokter (ID_TINDAKAN_DOKTER, TINDAKAN_DOKTER, BIAYA_TINDAKAN_DOKTER) values (?, ?, ?) values (?' ?, ?')"
        );
        
        statement.setString(1, dokter.getId_Tindakan_Dokter());
        statement.setString(2, dokter.getTindakan_Dokter());
        statement.setInt(3, dokter.getBiaya_Tindakan_Dokter());
        statement.executeUpdate();
        
        return dokter;
        }
        catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }
        finally{
            if (statement !=null){
                try{
                    statement.close();
                }catch(SQLException exception){
                    
                }    
            }
                
       }
  }
 public void updateTindakan_Dokter (Tindakan_Dokter dokter) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Update");
        
        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE dokter SET ID_TINDAKAN_DOKTER = ?" +
                 ", TINDAKAN_DOKTER = ?, BIAYA_TINDAKAN_DOKTER = ?" +
                 "WHERE ID_TINDAKAN_DOKTER = ?"
                
        );
        
        statement.setString(1, dokter.getId_Tindakan_Dokter());
        statement.setString(2, dokter.getTindakan_Dokter());
        statement.setInt(3, dokter.getBiaya_Tindakan_Dokter());

        
        statement.executeUpdate();
        
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        finally{
            if (statement !=null){
                try{
                    statement.close();
                }catch(SQLException exception){
                    
                }    
            }
                
       }
  }   

    @Override
    public Tindakan_Dokter getTindakan_Dokter(String Tindakan_Dokter) throws RemoteException {
        System.out.println("Client Melakukan Proses Get by ID");
        
        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM dokter WHERE ID_TINDAKAN_DOKTER = ?");
        
        ResultSet result = statement.executeQuery();
        
        Tindakan_Dokter dokter = null;
        
        if (result.next()){
            dokter.setId_Tindakan_Dokter(result.getString("ID_TINDAKAN_DOKTER"));
//            dokter.setBiaya_Tindakan_Dokter(result.getString("TINDAKAN_DOKTER"));
//            dokter.setBiaya_Tindakan_Dokter(result.getString("BIAYA_TINDAKAN_DOKTER"));
        }
        
        return dokter;
        
        }
        catch (SQLException exception){
        exception.printStackTrace();
        return null;
      }
      finally {
            if(statement !=null){
                try{
                    statement.close();
                }catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
    }


}   
        
        
        
 