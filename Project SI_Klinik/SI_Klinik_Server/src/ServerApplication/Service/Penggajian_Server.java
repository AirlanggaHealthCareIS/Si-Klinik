/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerApplication.Service;

import database.entity.Penggajian;
import database.entity.Laporan_Keuangan;
import database.Service.Penggajian_Service;
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
 * @author Windows 8.1
 */
public class Penggajian_Server extends UnicastRemoteObject implements Penggajian_Service {
    
    public Penggajian_Server() throws RemoteException {
        
    }
    
    public List<Penggajian> getPenggajianSemuaPegawai (String tanggal1, String tanggal2) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Periode tanggal");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT G.id_gaji AS ID_Gaji, D.ID_DOKTER AS ID_Pegawai, D.NAMA_DOKTER AS nama_pegawai, G.tanggal_gaji AS tanggal, D.GAJI_POKOK_DOKTER AS Gaji_Pokok  \n" +
                    "FROM penggajian AS G, dokter AS D\n" +
                    "WHERE G.tanggal_gaji>=? AND G.tanggal_gaji<=? AND G.id_pegawai = D.ID_DOKTER\n" +
                    "UNION \n" +
                    "SELECT G.id_gaji AS ID_Gaji, P.ID_PETUGAS AS ID_Pegawai, P.NAMA_PETUGAS AS nama_pegawai, G.tanggal_gaji AS tanggal,P.GAJI_POKOK_PETUGAS AS Gaji_Pokok  \n" +
                    "FROM penggajian AS G, dokter AS D, petugas as P \n" +
                    "WHERE G.tanggal_gaji>=? AND G.tanggal_gaji<=? AND G.id_pegawai = P.ID_PETUGAS" 
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            statement.setString(3, tanggal1);
            statement.setString(4, tanggal2);
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();

           List<Penggajian> list = new ArrayList<Penggajian>();

          while(result.next()){
                Penggajian penggajian = new Penggajian();
                
                penggajian.setTanggal(result.getString("tanggal"));
                penggajian.setIdPenggajian(result.getString("ID_Gaji"));
                penggajian.setIdPegawai(result.getString("ID_Pegawai"));
                penggajian.setNamaPegawai(result.getString("nama_pegawai"));
                penggajian.setGajiPokok(result.getInt("Gaji_Pokok"));
                
                for (int i=0; i<list.size(); i++) {
                    if(list.get(i).getIdPegawai().startsWith("PET")){
                        Penggajian penggajian1 = new Penggajian();
                        penggajian.setTotalGaji(result.getInt("Gaji_Pokok"));
                        list.add(penggajian1);
                    }
                }
                list.add(penggajian);
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
    
    public List<Penggajian> getPenggajianNonDokter (String tanggal1, String tanggal2) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Periode tanggal");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT G.id_gaji AS ID_Gaji, P.ID_PETUGAS AS ID_Pegawai, P.NAMA_PETUGAS AS nama_pegawai, G.tanggal_gaji AS tanggal, P.GAJI_POKOK_PETUGAS AS Gaji_Pokok, P.GAJI_POKOK_PETUGAS AS Total_Gaji    \n" +
                    "FROM penggajian AS G, petugas as P     \n" +
                    "WHERE G.tanggal_gaji>=? AND G.tanggal_gaji<=? AND G.id_pegawai = P.ID_PETUGAS  \n" +
                    "ORDER BY G.id_gaji" 
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();

           List<Penggajian> list = new ArrayList<Penggajian>();

          while(result.next()){
                Penggajian penggajian = new Penggajian();
                
                penggajian.setTanggal(result.getString("tanggal"));
                penggajian.setIdPenggajian(result.getString("ID_Gaji"));
                penggajian.setIdPegawai(result.getString("ID_Pegawai"));
                penggajian.setNamaPegawai(result.getString("nama_pegawai"));
                penggajian.setGajiPokok(result.getInt("Gaji_Pokok"));
                penggajian.setGajiTambahan(0);
                penggajian.setTotalGaji(result.getInt("Total_Gaji"));
                
                list.add(penggajian);
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
    
    public List<Penggajian> getPenggajianDokter (String tanggal1, String tanggal2) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Periode tanggal");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT D.ID_DOKTER, D.NAMA_DOKTER, D.GAJI_POKOK_DOKTER, D.TARIF_DOKTER, T.jumlah, (\n" +
                    "T.jumlah * D.TARIF_DOKTER\n" +
                    ") AS DETAIL_DOKTER\n" +
                    "FROM DOKTER AS D\n" +
                    "LEFT JOIN (\n" +
                    "\n" +
                    "SELECT RM.ID_DOKTER AS ID_DOKTER, COUNT( RM.ID_REKAM_MEDIS ) AS jumlah\n" +
                    "FROM rekam_medis AS RM\n" +
                    "WHERE RM.TGL_REKAM_MEDIS >=? \n" +
                    "AND RM.TGL_REKAM_MEDIS <=? \n" +
                    "GROUP BY RM.ID_DOKTER\n" +
                    ") AS T ON D.ID_DOKTER = T.ID_DOKTER"
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();

           List<Penggajian> list = new ArrayList<Penggajian>();

          while(result.next()){
                Penggajian penggajian = new Penggajian();
                
//                penggajian.setTanggal(result.getString("tanggal"));
//                penggajian.setIdPenggajian(result.getString("ID_Gaji"));
                penggajian.setIdPegawai(result.getString("ID_DOKTER"));
                penggajian.setNamaPegawai(result.getString("NAMA_DOKTER"));
                penggajian.setGajiPokok(result.getInt("GAJI_POKOK_DOKTER"));
                penggajian.setTotalPeriksa(result.getInt("jumlah"));
                penggajian.setTarifPeriksa(result.getInt("TARIF_DOKTER"));
                penggajian.setGajiTambahan(result.getInt("DETAIL_DOKTER"));
                
                list.add(penggajian);
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
    
    public List<Penggajian> getGajiDokter(String tanggal1, String tanggal2, String id_dokter) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT G.id_gaji AS ID_Gaji, G.tanggal_gaji AS tanggal\n" +
                    "FROM penggajian AS G, dokter AS D\n" +
                    "WHERE G.tanggal_gaji>=? AND G.tanggal_gaji<=? AND G.ID_Pegawai = ?"
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            statement.setString(3, id_dokter);
            
            Penggajian penggajian = new Penggajian(); 
            ResultSet result = statement.executeQuery();
            
            List<Penggajian> list = new ArrayList<Penggajian>();
            
          while(result.next()){
                penggajian.setTanggal(result.getString("tanggal"));
                penggajian.setIdPenggajian(result.getString("ID_Gaji"));
                list.add(penggajian);
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
