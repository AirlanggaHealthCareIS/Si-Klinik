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
    public List<detail_transaksi_obat> getDetailTO (String id_transaksi_obat) throws RemoteException{
        System.out.println("Client Melakukan Proses Get detailTO");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT distinct o.nama_obat, d.qty_detail_transaksi, (o.harga_obat*d.qty_detail_transaksi) as harga FROM obat as o, detail_transaksi_obat as d where o.id_obat=(SELECT d.id_obat FROM detail_transaksi_obat as d where d.id_transaksi_obat=?)");
            statement.setString(1, id_transaksi_obat);
            System.out.println(id_transaksi_obat);
            ResultSet result = statement.executeQuery();
            
            List<detail_transaksi_obat> list = new ArrayList<detail_transaksi_obat>() {};
            while(result.next()){
                System.out.println("TESTING HERE");
                detail_transaksi_obat to = new detail_transaksi_obat();
                to.setid_obat(result.getString("nama_obat"));
                to.setqty_detail_transaksi(Integer.parseInt(result.getString("qty_detail_transaksi")));
                to.setid_transaksi_obat(result.getString("harga"));
                list.add(to);
                System.out.println("TESTING HERE33"+result.getString("qty_detail_transaksi"));
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
