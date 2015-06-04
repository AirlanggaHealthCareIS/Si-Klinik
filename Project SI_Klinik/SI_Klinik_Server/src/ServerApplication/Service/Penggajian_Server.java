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
    
    public Penggajian insertGaji(Penggajian p) throws RemoteException {
        System.out.println("proses insert Penggajian");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "INSERT INTO `penggajian`(`id_gaji`, `tanggal_gaji`, `id_pegawai`, `nama_pegawai`, `gaji_pokok`, `gaji_tambahan`, `total_gaji`) \n"+
                    "VALUES (null,?,?,?,?,?,?)"
            );
            System.out.println(statement.toString());

            statement.setString(1, p.getTanggal());
            statement.setString(2, p.getIdPegawai());
            statement.setString(3, p.getNamaPegawai());
            statement.setInt(4, p.getGajiPokok());
            statement.setInt(5, p.getGajiTambahan());
            statement.setInt(6, p.getTotalGaji());
            System.out.println(statement.toString());
            statement.execute();
            return p;
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
    
    public List<Penggajian> getPenggajianNonDokter () throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Periode tanggal");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT P.ID_PETUGAS AS ID_Pegawai, P.NAMA_PETUGAS AS nama_pegawai, P.GAJI_POKOK_PETUGAS AS Gaji_Pokok   \n" +
                    "FROM petugas as P     \n" +
                    "ORDER BY P.ID_PETUGAS" 
            );
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();

           List<Penggajian> list = new ArrayList<Penggajian>();

          while(result.next()){
                Penggajian penggajian = new Penggajian();
                
                penggajian.setIdPegawai(result.getString("ID_Pegawai"));
                penggajian.setNamaPegawai(result.getString("nama_pegawai"));
                penggajian.setGajiPokok(result.getInt("Gaji_Pokok"));
                
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
    
    public List<Penggajian> getPenggajianDokter() throws RemoteException {
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                "SELECT D.ID_DOKTER AS ID_Pegawai, D.NAMA_DOKTER AS nama_pegawai, D.GAJI_POKOK_DOKTER AS Gaji_Pokok \n" +
                "FROM DOKTER as D\n" +
                "ORDER BY D.ID_DOKTER"
            );
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            List<Penggajian> list = new ArrayList<Penggajian>();
            
          while(result.next()){
              Penggajian penggajian = new Penggajian(); 
              
              penggajian.setIdPegawai(result.getString("ID_Pegawai"));
              penggajian.setNamaPegawai(result.getString("nama_pegawai"));
              penggajian.setGajiPokok(result.getInt("Gaji_Pokok"));
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
    
    public List<Penggajian> getGajiPeriksa(String tanggal1, String tanggal2) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                "SELECT RM.`ID_DOKTER`, COUNT(`ID_REKAM_MEDIS`) AS PERIKSA, D.`TARIF_DOKTER`, D.`GAJI_POKOK_DOKTER`\n" +
                "FROM REKAM_MEDIS AS RM, DOKTER AS D\n" +
                "WHERE RM.`TGL_REKAM_MEDIS`>= ? AND RM.`TGL_REKAM_MEDIS`<= ? AND RM.`ID_DOKTER`= D.`ID_DOKTER`\n" +
                "GROUP BY RM.`ID_DOKTER`"
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            List<Penggajian> list = new ArrayList<Penggajian>();
            
            while(result.next()){
                Penggajian penggajian = new Penggajian(); 
                
                penggajian.setIdPegawai(result.getString("ID_DOKTER"));
                penggajian.setTotalPeriksa(result.getInt("PERIKSA"));
                penggajian.setTarifPeriksa(result.getInt("TARIF_DOKTER"));
                penggajian.setGajiPokok(result.getInt("GAJI_POKOK_DOKTER"));
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
    
    public List<Penggajian> getPresensi(String tanggal1, String tanggal2) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT P.ID, COUNT(P.ID) as MASUK\n" +
                    "FROM PRESENSI AS P\n" +
                    "WHERE P.`TANGGAL_MASUK`>=? AND P.`TANGGAL_MASUK`<=? \n" +
                    "GROUP BY P.ID"
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            List<Penggajian> list = new ArrayList<Penggajian>();
            
           while(result.next()){
                Penggajian penggajian = new Penggajian(); 
                
                penggajian.setIdPegawai(result.getString("ID"));
                penggajian.setPresensi(result.getInt("MASUK"));
                System.out.println("Presensi : "+result.getInt("MASUK"));
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
    
     public Penggajian getLastPenggajian() throws RemoteException {
        System.out.println("proses get ALL Penggajian");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM penggajian ORDER BY id_gaji DESC LIMIT 1 ");
            Penggajian a = null;
            System.out.println(statement.toString());
            while(result.next()){
                a = new Penggajian();
                a.setIdPegawai((result.getString("ID_PEGAWAI")));
                a.setNamaPegawai(result.getString("NAMA_PEGAWAI"));
                a.setTanggal(result.getString("tanggal_gaji"));
                a.setGajiPokok(result.getInt("gaji_pokok"));
                a.setGajiTambahan(result.getInt("gaji_tambahan"));
                a.setTotalGaji(result.getInt("total_gaji"));
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
