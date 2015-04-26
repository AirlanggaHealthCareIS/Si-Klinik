/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.Assessment_Service;
import database.Service.DetailTransaksiObat_Service;
import database.Service.TransaksiObat_Service;
import database.entity.Transaksi_Obat;
import database.entity.detail_Assessment;
import database.entity.detail_transaksi_obat;
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
public class DetailTransaksiObat_Server extends UnicastRemoteObject implements DetailTransaksiObat_Service {
    
    public DetailTransaksiObat_Server() throws RemoteException {    
    }
    
    @Override
    public detail_transaksi_obat insertDTO(detail_transaksi_obat dto) throws RemoteException{
         System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `detail_transaksi_obat`(`ID_DETAIL_TRANSAKSI_OBAT`, `ID_TRANSAKSI_OBAT`, `ID_OBAT`, `QTY_DETAIL_TRANSAKSI`) VALUES (null,?,?,?)"
        );
        
        statement.setString(1, dto.getidtransaksi_obat());
        statement.setString(2, dto.getid_obat()); 
        statement.setInt(3, dto.getqty_detail_transaksi());
        statement.executeUpdate();
        
        return dto;
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
