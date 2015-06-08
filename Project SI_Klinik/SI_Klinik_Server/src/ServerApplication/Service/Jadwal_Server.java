/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import si_klinik_server.DatabaseUtilities;
import database.Service.Jadwal_Service;
import database.entity.dokter;
import database.entity.jadwal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BOCIL
 */
public class Jadwal_Server extends UnicastRemoteObject implements Jadwal_Service {
    
    public Jadwal_Server() throws RemoteException{
        
    }
    
     public void insertJadwal(String id_dokter, String hari, String jam){
        PreparedStatement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "INSERT INTO `jadwal`(`ID_DOKTER`, `HARI`, `JAM`) VALUES (?,?,?)");
            statement.setString(1, id_dokter);
            statement.setString(2, hari);
            statement.setString(3, jam);
            statement.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Jadwal_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ubahJadwal(String id_jadwal, String jam){
        PreparedStatement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "UPDATE jadwal SET JAM=? WHERE id_jadwal=?");
            statement.setString(1, jam);
            statement.setString(2, id_jadwal);
            
            statement.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Jadwal_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<jadwal> getJadwal(String hari) throws RemoteException{
        PreparedStatement statement = null;
        
        List<jadwal> list = new ArrayList<jadwal>();
        
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM jadwal WHERE hari = ?");
            statement.setString(1, hari);
            ResultSet result = statement.executeQuery();
            
            jadwal x = new jadwal(); 
            
            
            while(result.next()){
                x.sethari(result.getString("hari"));
                x.setid_dokter(result.getString("id_dokter"));
                x.setid_jadwal(result.getString("id_jadwal"));
                x.setjam(result.getString("jam"));
                
                list.add(x);
            }
            
            result.close();
            
            return list;
            
        } 
        
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
    public List<String> getIDDokter() throws RemoteException{
        PreparedStatement statement = null;
        
        List<String> list = new ArrayList<String>();
        
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT id_dokter FROM dokter");
            ResultSet result = statement.executeQuery();
            
            
            while(result.next()){
                list.add(result.getString("id_dokter"));
            }
            
            result.close();
            
            return list;
            
        } 
        
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

