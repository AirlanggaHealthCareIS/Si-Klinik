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
    public void updateResep(detail_resep_obat resep) throws RemoteException {
        System.out.println("Client Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE detail_resep_obat SET QTY_DETAIL_RESEP = ?" +
                 "WHERE ID_DETAIL_RESEP = ?"
         );
         
        statement.setInt(1, resep.getqty_detail_resep());
        statement.setString(2, resep.getid_detail_resep());

        statement.executeUpdate();

        }
        catch(SQLException exception){
          exception.printStackTrace();
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
    public detail_resep_obat getResep(String ID_rekam) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Id");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                 "SELECT * FROM detail_resep_obat WHERE ID_DETAIL_RESEP = ?");
            
            statement.setString(1, ID_rekam);
            
            ResultSet result = statement.executeQuery();

            detail_resep_obat detail_resep = null;

            if(result.next()){
                detail_resep.setid_detail_resep(result.getString("ID_DETAIL_RESEP"));
                detail_resep.setid_rekam_medis(result.getString("ID_REKAM_MEDIS"));
                detail_resep.setid_obat(result.getString("ID_OBAT"));
                detail_resep.setqty_detail_resep(result.getInt("QTY_DETAIL_RESEP"));
            }

            return detail_resep;

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
    public List<detail_resep_obat> getResep() throws RemoteException {
        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT O.NAMA_OBAT, D.QTY_DETAIL_RESEP FROM detail_resep_obat AS D, obat AS O WHERE D.ID_OBAT = O.ID_OBAT");

          List<detail_resep_obat> list = new ArrayList<detail_resep_obat>();

          while(result.next()){
                detail_resep_obat resep = new detail_resep_obat();
                resep.setid_obat(result.getString("NAMA_OBAT"));
                resep.setqty_detail_resep(result.getInt("QTY_DETAIL_RESEP"));
                list.add(resep);
          }

          result.close();

          return list;

        }catch(SQLException exception){
          exception.printStackTrace();
          return null;
        }finally{
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
