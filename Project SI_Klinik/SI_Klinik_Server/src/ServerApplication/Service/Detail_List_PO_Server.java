/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
import database.Service.List_PO_Service;
import database.Service.Pemesanan_Obat_Service;
import database.entity.detil_pesan_obat;
import database.entity.detil_pesan_obat;
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
 * @author alif
 */
public class Detail_List_PO_Server extends UnicastRemoteObject implements List_PO_Service{

    public Detail_List_PO_Server () throws RemoteException{
        
    }
        
    @Override
    public detil_pesan_obat insertListPO(detil_pesan_obat PO) throws RemoteException {
        System.out.println("Apoteker Melakukan Proses Insert detil pemesanan obat");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `detil_pemesanan_obat`(`id_pemesanan_obat`, `id_obat`, `jumlah_pesanan`, status) VALUES (?,?,?,?)"
        );      
        
        statement.setString(1, PO.getId_Pemesanan_obat());
        statement.setString(2, PO.getId_obat());
        statement.setInt(3, PO.getJumlah_Pesan());
        statement.setInt(4, PO.getStatus());       
        System.out.println(statement.toString());
        statement.executeUpdate();
        
        return PO;
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
