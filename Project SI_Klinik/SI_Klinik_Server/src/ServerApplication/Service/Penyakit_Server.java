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
    
    @Override
    public List<Penyakit> getPenyakitAll() throws RemoteException {
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM `penyakit` ORDER BY NAMA_PENYAKIT ASC");            
            ResultSet result = statement.executeQuery();
            
            List<Penyakit> list = new ArrayList<Penyakit>();

            while(result.next()){
                Penyakit a = new Penyakit();
                a.setId_Penyakit(result.getString("ID_PENYAKIT"));
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
}
