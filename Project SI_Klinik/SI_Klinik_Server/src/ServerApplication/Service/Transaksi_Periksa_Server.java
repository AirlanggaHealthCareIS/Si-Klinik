/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Detail_Resep_Service;
import database.Service.Transaksi_Periksa_Service;
import database.entity.Tindakan_Dokter;
import database.entity.Transaksi_Periksa;
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
 * @author Indyka
 */
public class Transaksi_Periksa_Server extends UnicastRemoteObject implements Transaksi_Periksa_Service{
    
    public Transaksi_Periksa_Server() throws RemoteException {
    
    }
    
    @Override
    public Transaksi_Periksa insertTransaksi (Transaksi_Periksa a)throws RemoteException {
        System.out.println("proses insert Transaksi periksa");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `transaksi_periksa`(`ID_TRANSAKSI_PERIKSA`, `ID_DOKTER`, `ID_PASIEN`, `SUBTOTAL_TRANSAKSI_PERIKSA`, `PPN_TRANSAKSI_PERIKSA`, `TOTAL_TRANSAKSI_PERIKSA`, `KLAIM_BPJS`, `NO_KARTU_TRANSAKSI`, `TANGGAL_TRANSAKSI_PERIKSA`) VALUES (null,?,?,?,?,?,?,?,?)");
            
            statement.setString(1, a.getId_Dokter());
            statement.setString(2, a.getId_Pasien());
            statement.setString(3, a.getSubtotal_Transaksi_Periksa());
            statement.setString(4, a.getPPN_Transaksi_Periksa());
            statement.setString(5, a.getTotal_Transaksi_Periksa());
            statement.setString(6, a.getKlaim_BPJS());
            statement.setString(7, a.getNo_Kartu_Transaksi());
            statement.setString(8, a.getTanggal_Transaksi_Periksa());
            System.out.println(statement.toString());
            statement.execute();
            
            return a;
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
    
    @Override
    public List<Transaksi_Periksa> getTransaksis(String id_pasien) throws RemoteException {
        System.out.println("bomb");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                "SELECT * FROM transaksi_periksa WHERE id_pasien =?"
            );
        
            statement.setString(1, id_pasien);
            System.out.println(id_pasien);
            ResultSet result = statement.executeQuery();
            List<Transaksi_Periksa> list = new ArrayList<Transaksi_Periksa>();
        
            while(result.next()){
                Transaksi_Periksa x = new Transaksi_Periksa();
                
                x.setId_Dokter(result.getString("id_dokter"));
                x.setId_Pasien(result.getString("id_pasien"));
                x.setId_Transaksi_Periksa(result.getString("id_transaksi_periksa"));
                x.setKlaim_BPJS(result.getString("klaim_bpjs"));
                x.setNo_Kartu_Transaksi(result.getString("no_kartu_transaksi"));
                x.setPPN_Transaksi_Periksa(result.getString("ppn_transaksi_periksa"));
                x.setSubtotal_Transaksi_Periksa(result.getString("subtotal_transaksi_periksa"));
                x.setTanggal_Transaksi_Periksa(result.getString("tanggal_transaksi_periksa"));
                x.setTotal_Transaksi_Periksa(result.getString("total_transaksi_periksa"));
                list.add(x);
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

                }
            }
        }
        

    }

    @Override
    public Transaksi_Periksa getLastTransaksi() throws RemoteException {
        System.out.println("Client Melakukan Proses Get by ID");
        
        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM transaksi_periksa ORDER BY id_transaksi_periksa DESC limit 1");
        
        ResultSet result = statement.executeQuery();
        Transaksi_Periksa x = new Transaksi_Periksa();
        if (result.next()){
            x.setId_Dokter(result.getString("id_dokter"));
            x.setId_Pasien(result.getString("id_pasien"));
            x.setId_Transaksi_Periksa(result.getString("id_transaksi_periksa"));
            x.setKlaim_BPJS(result.getString("klaim_bpjs"));
            x.setNo_Kartu_Transaksi(result.getString("no_kartu_transaksi"));
            x.setPPN_Transaksi_Periksa(result.getString("ppn_transaksi_periksa"));
            x.setSubtotal_Transaksi_Periksa(result.getString("subtotal_transaksi_periksa"));
            x.setTanggal_Transaksi_Periksa(result.getString("tanggal_transaksi_periksa"));
            x.setTotal_Transaksi_Periksa(result.getString("total_transaksi_periksa"));
        }        
        return x;
        
        }
        catch (SQLException exception){
        exception.printStackTrace();
        return null;
      }
      finally {
            if(statement !=null){
                try{
                    statement.close();
                }catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Transaksi_Periksa> getBPJS(int bulan) throws RemoteException {
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                "SELECT * FROM transaksi_periksa WHEN MONTH(tanggal_transaksi_periksa) =?"
            );
        
            statement.setInt(1, bulan);
            ResultSet result = statement.executeQuery();
            List<Transaksi_Periksa> list = new ArrayList<Transaksi_Periksa>();
        
            while(result.next()){
                Transaksi_Periksa x = new Transaksi_Periksa();
                
                x.setId_Dokter(result.getString("id_dokter"));
                x.setId_Pasien(result.getString("id_pasien"));
                x.setId_Transaksi_Periksa(result.getString("id_transaksi_periksa"));
                x.setKlaim_BPJS(result.getString("klaim_bpjs"));
                x.setNo_Kartu_Transaksi(result.getString("no_kartu_transaksi"));
                x.setPPN_Transaksi_Periksa(result.getString("ppn_transaksi_periksa"));
                x.setSubtotal_Transaksi_Periksa(result.getString("subtotal_transaksi_periksa"));
                x.setTanggal_Transaksi_Periksa(result.getString("tanggal_transaksi_periksa"));
                x.setTotal_Transaksi_Periksa(result.getString("total_transaksi_periksa"));
                list.add(x);
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

                }
            }
        }
    }
}
