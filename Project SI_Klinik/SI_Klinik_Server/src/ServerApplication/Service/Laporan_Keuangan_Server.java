/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerApplication.Service;

import database.entity.Laporan_Keuangan;
import database.Service.Laporan_Keuangan_Service;
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
public class Laporan_Keuangan_Server extends UnicastRemoteObject implements Laporan_Keuangan_Service {
    
    public Laporan_Keuangan_Server() throws RemoteException {
        
    }
    
    public Laporan_Keuangan insertPengeluaran(Laporan_Keuangan lk) throws RemoteException {
        System.out.println("proses insert Penggajian");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "INSERT INTO `pengeluaran`(`ID_Transaksi`, `Tanggal`, `Jumlah`, `Saldo`, `Flag`) VALUES (?,?,?,?,?)"
            );
            System.out.println(statement.toString());
            statement.setString(1, lk.getId());
            statement.setString(2, lk.getTanggal());
            statement.setInt(3, lk.getPengeluaran());
            statement.setInt(4, lk.getSaldo());
            statement.setInt(5, lk.getFlag());
            System.out.println(statement.toString());
            statement.execute();
            return lk;
        }
        catch(SQLException exception){
            exception.printStackTrace();
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
    
     public List<Laporan_Keuangan> getLaporanKeuangan (String tanggal1, String tanggal2) throws RemoteException {
        System.out.println("Client Melakukan Proses Get By Periode tanggal");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT M.ID_Transaksi AS ID, M.Tanggal AS Tanggal, M.Jumlah AS Jumlah, M.Saldo AS Saldo, M.Flag AS Flag FROM penerimaan AS M where M.Tanggal>=? AND M.Tanggal<=? UNION SELECT P.ID_Transaksi AS ID, P.Tanggal AS Tanggal, P.Jumlah AS Jumlah, P.Saldo AS Saldo, P.Flag AS Flag FROM pengeluaran AS P where P.Tanggal>=? AND P.Tanggal<=? ORDER BY Flag" 
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal2);
            statement.setString(3, tanggal1);
            statement.setString(4, tanggal2);
            
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();

           List<Laporan_Keuangan> list = new ArrayList<Laporan_Keuangan>();

          while(result.next()){
                Laporan_Keuangan laporan_keuangan = new Laporan_Keuangan();
                
                laporan_keuangan.setTanggal(result.getString("Tanggal"));
                laporan_keuangan.setRef(result.getString("ID"));
                laporan_keuangan.setPemasukan(result.getInt("Jumlah"));
                laporan_keuangan.setSaldo(result.getInt("Saldo"));                
                laporan_keuangan.setFlag(result.getInt("Flag"));
                
                list.add(laporan_keuangan);
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
     
     public List<Laporan_Keuangan> getLaporanKeuangan() throws RemoteException {

        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT M.ID_Transaksi AS ID, M.Tanggal AS Tanggal, M.Jumlah AS Jumlah, M.Saldo AS Saldo, M.Flag AS Flag FROM penerimaan AS M UNION ELECT P.ID_Transaksi AS ID, P.Tanggal AS Tanggal, P.Jumlah AS Jumlah, P.Saldo AS Saldo, P.Flag AS Flag FROM pengeluaran AS P ORDER BY Flag");

          List<Laporan_Keuangan> list = new ArrayList<Laporan_Keuangan>();

          while(result.next()){
                Laporan_Keuangan laporan_keuangan = new Laporan_Keuangan();
                
                laporan_keuangan.setTanggal(result.getString("Tanggal"));
                laporan_keuangan.setRef(result.getString("ID"));
                laporan_keuangan.setPemasukan(result.getInt("Jumlah"));
                laporan_keuangan.setSaldo(result.getInt("Saldo"));                
                laporan_keuangan.setFlag(result.getInt("Flag"));
                
                list.add(laporan_keuangan);
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
     
    public Laporan_Keuangan getSaldoAwal(String tanggal1) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT M.ID_Transaksi AS ID, M.Tanggal AS Tanggal, M.Jumlah AS Jumlah, M.Saldo AS Saldo, M.Flag AS Flag FROM penerimaan AS M WHERE M.Tanggal <? UNION SELECT P.ID_Transaksi AS ID, P.Tanggal AS Tanggal, P.Jumlah AS Jumlah, P.Saldo AS Saldo, P.Flag AS Flag FROM pengeluaran AS P WHERE P.Tanggal < ? ORDER BY Flag DESC LIMIT 1" 
            );
            statement.setString(1, tanggal1);
            statement.setString(2, tanggal1);
            Laporan_Keuangan laporan_keuangan = new Laporan_Keuangan(); 
            ResultSet result = statement.executeQuery();

          if(result.next()){
                laporan_keuangan.setTanggal(result.getString("Tanggal"));
                laporan_keuangan.setRef(result.getString("ID"));
                laporan_keuangan.setPemasukan(result.getInt("Jumlah"));
                laporan_keuangan.setSaldo(result.getInt("Saldo"));                
                laporan_keuangan.setFlag(result.getInt("Flag"));
          }
          result.close();

          return laporan_keuangan;

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
    public Laporan_Keuangan getPengeluaranAwal(String tanggal1) throws RemoteException {
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT P.ID_Transaksi AS ID, P.Tanggal AS Tanggal, P.Jumlah AS Jumlah, P.Saldo AS Saldo, P.Flag AS Flag FROM pengeluaran AS P WHERE P.Tanggal <? ORDER BY Flag DESC LIMIT 1" 
            );
            statement.setString(1, tanggal1);
            Laporan_Keuangan laporan_keuangan = new Laporan_Keuangan(); 
            ResultSet result = statement.executeQuery();

          if(result.next()){
                laporan_keuangan.setTanggal(result.getString("Tanggal"));
                laporan_keuangan.setRef(result.getString("ID"));
                laporan_keuangan.setPemasukan(result.getInt("Jumlah"));
                laporan_keuangan.setSaldo(result.getInt("Saldo"));                
                laporan_keuangan.setFlag(result.getInt("Flag"));
          }
          result.close();

          return laporan_keuangan;

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
