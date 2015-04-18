/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
import database.entity.lihatResep;
import database.Service.lihat_Resep_Service;
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
 * @author tinot
 */
public class Lihat_Resep_Server extends UnicastRemoteObject implements lihat_Resep_Service{

    public Lihat_Resep_Server() throws RemoteException {
    
    }
    
    @Override
    public List<lihatResep> getLihatResep() throws RemoteException {
        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT RM.ID_PASIEN, RM.ID_REKAM_MEDIS, DRO.ID_DETAIL_RESEP, RM.TGL_REKAM_MEDIS FROM detail_resep_obat AS DRO, rekam_medis AS RM WHERE RM.ID_REKAM_MEDIS = DRO.ID_REKAM_MEDIS");

          List<lihatResep> list = new ArrayList<lihatResep>();

          while(result.next()){
                lihatResep resep = new lihatResep();
                resep.setId_Pasien(result.getInt("ID_PASIEN"));
                resep.setId_rekam_medik(result.getString("ID_REKAM_MEDIS"));
                resep.setId_resep(result.getString("ID_DETAIL_RESEP"));
                resep.setTanggal(result.getString("TGL_REKAM_MEDIS"));
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

    @Override
    public List<lihatResep> getLihatResep(int id) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT RM.ID_PASIEN, RM.ID_REKAM_MEDIS, DRO.ID_DETAIL_RESEP, RM.TGL_REKAM_MEDIS FROM detail_resep_obat AS DRO, rekam_medis AS RM WHERE RM.ID_PASIEN = "+id+" AND RM.ID_REKAM_MEDIS = DRO.ID_REKAM_MEDIS");

          List<lihatResep> list = new ArrayList<lihatResep>();

          while(result.next()){
                lihatResep resep = new lihatResep();
                resep.setId_Pasien(result.getInt("ID_PASIEN"));
                resep.setId_rekam_medik(result.getString("ID_REKAM_MEDIS"));
                resep.setId_resep(result.getString("ID_DETAIL_RESEP"));
                resep.setTanggal(result.getString("TGL_REKAM_MEDIS"));
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
