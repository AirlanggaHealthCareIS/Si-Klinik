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
    
     public Laporan_Keuangan getLaporanKeuangan (String tanggal) throws RemoteException {
//
        System.out.println("Client Melakukan Proses Get By Periode tanggal");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM transaksi WHERE tanggal_transaksi LIKE '% ? %'?" 
            );
            
            ResultSet result = statement.executeQuery();

            Laporan_Keuangan laporan_keuangan = null;

            if(result.next()){
                laporan_keuangan.setPeriode(""+result.getDate("TANGGAL_TRANSAKSI"));
                laporan_keuangan.setKeterangan(result.getString(""));
                laporan_keuangan.setRef(result.getString(""));
                laporan_keuangan.setPemasukan(result.getInt("TOTAL_MASUK"));
                laporan_keuangan.setPengeluaran(result.getInt("TOTAL_KELUAR"));
                laporan_keuangan.setSaldo(result.getInt("SALDO"));
            }
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
     
     public List<Laporan_Keuangan> getLaporanKeuangan() throws RemoteException {

        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT * FROM transaksi WHERE tanggal_transaksi LIKE '% ? %'");

          List<Laporan_Keuangan> list = new ArrayList<Laporan_Keuangan>();

          while(result.next()){
                Laporan_Keuangan laporan_keuangan = new Laporan_Keuangan();
                
                laporan_keuangan.setPeriode(""+result.getDate("TANGGAL_TRANSAKSI"));
                laporan_keuangan.setKeterangan(result.getString(""));
                laporan_keuangan.setRef(result.getString(""));
                laporan_keuangan.setPemasukan(result.getInt("TOTAL_MASUK"));
                laporan_keuangan.setPengeluaran(result.getInt("TOTAL_BELI"));
                laporan_keuangan.setSaldo(result.getInt("SALDO"));
                
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
}