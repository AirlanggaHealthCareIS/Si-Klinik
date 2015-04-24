/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
import database.entity.detail_lihat_resep;
import database.entity.detail_resep_obat;
import database.Service.Detail_Lihat_Resep_Service;
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
public class Detail_Lihat_Resep_Server extends UnicastRemoteObject implements Detail_Lihat_Resep_Service{

    public Detail_Lihat_Resep_Server() throws RemoteException {
    
    }

    @Override
    public List<detail_lihat_resep> getLihatResep(String rekam) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT RM.ID_PASIEN, P.NAMA_PASIEN, D.NAMA_DOKTER, RM.TGL_REKAM_MEDIS FROM detail_resep_obat AS DRO, dokter AS D, rekam_medis AS RM, pasien AS P WHERE RM.ID_REKAM_MEDIS = '"+rekam+"' AND RM.ID_PASIEN = P.ID_PASIEN AND RM.ID_REKAM_MEDIS = DRO.ID_REKAM_MEDIS AND D.ID_DOKTER = RM.ID_DOKTER");

          List<detail_lihat_resep> list = new ArrayList<detail_lihat_resep>();

          while(result.next()){
                detail_lihat_resep lihat_resep = new detail_lihat_resep();
                lihat_resep.setId_Pasien(result.getInt("ID_PASIEN"));
                lihat_resep.setNamaPasien(result.getString("NAMA_PASIEN"));
                lihat_resep.setNama_Dokter(result.getString("NAMA_DOKTER"));
                lihat_resep.setTanggal(result.getString("TGL_REKAM_MEDIS"));
                list.add(lihat_resep);
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
    public List<detail_lihat_resep> getLihatResepDetail(String rekam) throws RemoteException {
        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT O.NAMA_OBAT, D.QTY_DETAIL_RESEP FROM detail_resep_obat AS D, obat AS O WHERE D.ID_REKAM_MEDIS = '"+rekam+"' AND D.ID_OBAT = O.ID_OBAT");

          List<detail_lihat_resep> list = new ArrayList<detail_lihat_resep>();

          while(result.next()){
                detail_lihat_resep detail_resep = new detail_lihat_resep();
                detail_resep.setObat(result.getString("NAMA_OBAT"));
                detail_resep.setQty(result.getInt("QTY_DETAIL_RESEP"));
                list.add(detail_resep);
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
