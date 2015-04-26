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
public class Detail_Lihat_Resep_Server1 extends UnicastRemoteObject implements Detail_Lihat_Resep_Service{

    public Detail_Lihat_Resep_Server1() throws RemoteException {
    
    }

    @Override
    public List<detail_lihat_resep> getLihatResep(String resep) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT RM.ID_PASIEN, D.NAMA_DOKTER, RM.TGL_REKAM_MEDIS FROM detail_resep_obat AS DRO, dokter AS D, rekam_medis AS RM WHERE DRO.ID_DETAIL_RESEP = '"+resep+"' AND RM.ID_REKAM_MEDIS = DRO.ID_REKAM_MEDIS AND D.ID_DOKTER = RM.ID_DOKTER");

          List<detail_lihat_resep> list = new ArrayList<detail_lihat_resep>();

          while(result.next()){
                detail_lihat_resep lihat_resep = new detail_lihat_resep();
                lihat_resep.setId_Pasien(result.getInt("ID_PASIEN"));
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
    public List<detail_lihat_resep> getLihatResepDetail(String resep) throws RemoteException {
        System.out.println("Client Melakukan Proses Get All");
        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "select O.ID_OBAT,O.NAMA_OBAT, O.STOK_OBAT, D.QTY_DETAIL_RESEP FROM detail_resep_obat AS D, obat AS O WHERE D.ID_DETAIL_RESEP =? AND D.ID_OBAT = O.ID_OBAT");
          statement.setString(1, resep);          
            System.out.println(statement.toString());
          ResultSet result = statement.executeQuery();

          List<detail_lihat_resep> list = new ArrayList<detail_lihat_resep>();

          while(result.next()){
                detail_lihat_resep detail_resep = new detail_lihat_resep();
                detail_resep.setIdObat(result.getString("ID_OBAT"));                
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
