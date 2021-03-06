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

          ResultSet result = statement.executeQuery("SELECT DISTINCT RM.ID_PASIEN, RM.ID_REKAM_MEDIS, RM.TGL_REKAM_MEDIS FROM detail_resep_obat AS DRO, rekam_medis AS RM WHERE DRO.ID_REKAM_MEDIS = RM.ID_REKAM_MEDIS ORDER BY RM.ID_PASIEN DESC");

          List<lihatResep> list = new ArrayList<lihatResep>();

          while(result.next()){
                lihatResep resep = new lihatResep();
                System.out.println("se"+result.getInt("ID_PASIEN"));
                resep.setId_Pasien(result.getInt("ID_PASIEN"));
                resep.setId_rekam_medik(result.getString("ID_REKAM_MEDIS"));
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
        
        PreparedStatement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().prepareStatement(
            "SELECT RM.ID_PASIEN, RM.ID_REKAM_MEDIS, RM.TGL_REKAM_MEDIS FROM rekam_medis AS RM WHERE RM.ID_PASIEN =? ORDER BY RM.TGL_REKAM_MEDIS DESC");
        
          statement.setInt(1, id); 
          ResultSet result = statement.executeQuery();
          
          List<lihatResep> list = new ArrayList<lihatResep>();

          while(result.next()){
                lihatResep resep = new lihatResep();
                resep.setId_Pasien(result.getInt("ID_PASIEN"));
                resep.setId_rekam_medik(result.getString("ID_REKAM_MEDIS"));
                resep.setTanggal(result.getString("TGL_REKAM_MEDIS"));
                list.add(resep);
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
