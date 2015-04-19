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
    
    public void ubahJadwal(String id_jadwal, String hari, String jam){
        PreparedStatement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "UPDATE hari, jam SET ?, ? WHERE id_jadwal = ?");
            statement.setString(1, hari);
            statement.setString(2, jam);
            statement.setString(3, id_jadwal);
            
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
            statement.executeUpdate();
            ResultSet result = statement.executeQuery();
            
            jadwal x = new jadwal(); 
            
            
            while(result.next()){
                x.sethari(result.getString("hari"));
                x.setid_dokter(result.getString("id_dokter"));
                x.setid_poli(result.getString("id_poli"));
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
}

