/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Assessment_Service;
import database.Service.TransaksiObat_Service;
import database.entity.Transaksi_Obat;
import database.entity.detail_Assessment;
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
 * @author JESSICA
 */
public class TransaksiObat_Server extends UnicastRemoteObject implements TransaksiObat_Service {
    
    public TransaksiObat_Server() throws RemoteException {    
    }
    
    @Override
    public Transaksi_Obat insertTO(Transaksi_Obat to) throws RemoteException{
         System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `transaksi_obat`(`ID_TRANSAKSI_OBAT`, `TANGGAL_JUAL`, `SUBTOTAL_TRANSAKSI_OBAT`, `PPN_TRANSAKSI_OBAT`, `TOTAL_TRANSAKSI_OBAT`) VALUES (null,?,?,?,?)"
        );
        
        statement.setString(1, to.getTanggal_Jual());
        statement.setInt(2, to.getSubtotal_Transaksi_Obat()); 
        statement.setFloat(3, to.getPPN_Transaksi_Obat());
        statement.setInt(4, to.getTotal_Transaksi_Obat());
        statement.executeUpdate();
        
        return to;
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
    public Transaksi_Obat getLastTO () throws RemoteException{
        System.out.println("Client Melakukan Proses Get Last TO");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM  `transaksi_obat` ORDER BY ID_TRANSAKSI_OBAT DESC LIMIT 1");
            
            ResultSet result = statement.executeQuery();
            
            Transaksi_Obat to = new Transaksi_Obat();
            while(result.next()){
                to.setId_Transaksi_Obat(result.getString("ID_TRANSAKSI_OBAT"));
                to.setTanggal_Jual(result.getString("TANGGAL_JUAL"));
                to.setSubtotal_Transaksi_Obat(result.getInt("SUBTOTAL_TRANSAKSI_OBAT"));
                to.setPPN_Transaksi_Obat(result.getFloat("PPN_TRANSAKSI_OBAT"));
                to.setTotal_Transaksi_Obat(result.getInt("TOTAL_TRANSAKSI_OBAT"));
            }
           result.close();

          return to;

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
