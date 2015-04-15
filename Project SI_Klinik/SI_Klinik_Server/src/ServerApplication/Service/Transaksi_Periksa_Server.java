/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Detail_Resep_Service;
import database.Service.Transaksi_Periksa_Service;
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
    public Transaksi_Periksa getTransaksi(String id_pasien) throws RemoteException{
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                "SELECT * FROM transaksi_periksa WHEN id_pasien =?"
            );
        
            statement.setString(1, id_pasien);
            ResultSet result = statement.executeQuery();
            Transaksi_Periksa x = new Transaksi_Periksa();
            
            while(result.next()){
                x.setId_Dokter(result.getString("id_dokter"));
                x.setId_Pasien(result.getString("id_pasien"));
                x.setId_Pemasukan(result.getString("id_pemasukan"));
                x.setId_Transaksi_Periksa(result.getString("id_transaksi_periksa"));
                x.setKlaim_BPJS(result.getString("klaim_bpjs"));
                x.setNo_Kartu_Transaksi(result.getString("no_kartu_transaksi"));
                x.setPPN_Transaksi_Periksa(result.getString("ppn_transaksi_periksa"));
                x.setSubtotal_Transaksi_Periksa(result.getString("subtotal_transaksi_periksa"));
                x.setTanggal_Transaksi_Periksa(result.getString("tanggal_transaksi_periksa"));
                x.setTotal_Transaksi_Periksa(result.getString("total_transaksi_periksa"));
            }
            result.close();
            return x;
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
    public List<Transaksi_Periksa> getTransaksis(String id_pasien) throws RemoteException {
        
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                "SELECT * FROM transaksi_periksa WHEN id_pasien =?"
            );
        
            statement.setString(1, id_pasien);
            ResultSet result = statement.executeQuery();
            List<Transaksi_Periksa> list = new ArrayList<Transaksi_Periksa>();
        
            while(result.next()){
                Transaksi_Periksa x = new Transaksi_Periksa();
                
                x.setId_Dokter(result.getString("id_dokter"));
                x.setId_Pasien(result.getString("id_pasien"));
                x.setId_Pemasukan(result.getString("id_pemasukan"));
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
