/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.Service.pemesanan_obat_service;
import database.entity.Pemesanan_Obat;
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
 * @author asus
 */
public class pemesanan_obat_server extends UnicastRemoteObject implements pemesanan_obat_service{

    public pemesanan_obat_server () throws RemoteException{
        
    }
    
    
    @Override
    public Pemesanan_Obat insertPemesananObat(Pemesanan_Obat PO) throws RemoteException {
        System.out.println("Apoteker Melakukan Proses Insert pemesanan obat");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `pemesanan_obat`(`id_pemesanan_obat`, `id_supplier`, `tgl_pemesanan_obat`) VALUES (?,?,?)"
        );
        
        statement.setString(1, PO.getId_Pemesanan_obat());
        statement.setString(2, PO.getId_supplier());
        statement.setString(3, PO.getTgl_Pemesanan());
       
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
        }    }

    public List<Pemesanan_Obat> getPO() throws RemoteException {
        System.out.println("apoteker Melakukan Proses Get All PO");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT * FROM `pemesanan_obat`");

          List list = new ArrayList();
          
          while(result.next()){
            Pemesanan_Obat a = new Pemesanan_Obat();
            a.setId_Pemesnan_obat(result.getString("ID_PEMESANAN_OBAT"));
            a.setId_supplier(result.getString("ID_SUPPLIER"));
            a.setTgl_Pemesanan(result.getString("TGL_PEMESANAN_OBAT"));
              list.add(a);
          }
          
          result.close();

          return list;

        }catch(SQLException exception){
          exception.printStackTrace();
          return null;
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                   exception.printStackTrace();
                }
            }
        }}
    
}
