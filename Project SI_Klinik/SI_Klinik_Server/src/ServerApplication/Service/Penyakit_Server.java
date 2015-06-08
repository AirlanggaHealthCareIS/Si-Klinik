/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Assessment_Service;
import database.Service.Penyakit_Service;
import database.entity.Penyakit;
import database.entity.detail_Assessment;
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
 * @author JESSICA
 */
public class Penyakit_Server extends UnicastRemoteObject implements Penyakit_Service {
    
    public Penyakit_Server() throws RemoteException {    
    }
    
   
    public Penyakit insertPenyakit(Penyakit a) throws RemoteException {
        System.out.println("proses insert PENYAKIT");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO penyakit(ID_PENYAKIT, NAMA_PENYAKIT) values(null,?)");
            
            statement.setString(1, a.getNama_Penyakit());
            System.out.println(statement.toString());
            statement.execute();
            return a;
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
    
    public void updatePenyakit(Penyakit b) throws RemoteException {
        System.out.println("proses update PENYAKIT");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "UPDATE penyakit SET  NAMA_PENYAKIT=? WHERE ID_PENYAKIT=?");
            statement.setString(1, b.getNama_Penyakit());
            statement.setInt(2, b.getId_Penyakit());
            statement.executeUpdate();  
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
    
    
    
     @Override
    public List<Penyakit> getPenyakitAll() throws RemoteException {
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM `penyakit` ORDER BY ID_PENYAKIT DESC");            
            ResultSet result = statement.executeQuery();
            
            List<Penyakit> list = new ArrayList<Penyakit>();

            while(result.next()){
                Penyakit a = new Penyakit();
                a.setId_Penyakit(result.getInt("ID_PENYAKIT"));
                a.setNama_Penyakit(result.getString("NAMA_PENYAKIT"));
                list.add(a);
            }
           result.close();

          return list;

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
                   exception.printStackTrace();
                }
            }
        }
    }

    

    @Override
    public Penyakit getLastPenyakit() throws RemoteException {
     System.out.println("proses get ALL PENYAKIT");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM penyakit ORDER BY ID_PENYAKIT DESC LIMIT 1");
          Penyakit a = null;
            while(result.next()){
                a = new Penyakit();
                a.setId_Penyakit((result.getInt("ID_PENYAKIT")));
                a.setNama_Penyakit(result.getString("NAMA_PENYAKIT"));
                
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

    @Override
    public Penyakit getPenyakitID(int id_penyakit) throws RemoteException {
        System.out.println("proses get PENYAKIT By ID");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM penyakit WHERE ID_PENYAKIT = "+id_penyakit);
          Penyakit a = null;
            while(result.next()){
                a = new Penyakit();
                a.setId_Penyakit((result.getInt("ID_PENYAKIT")));
                a.setNama_Penyakit(result.getString("NAMA_PENYAKIT"));
                
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
