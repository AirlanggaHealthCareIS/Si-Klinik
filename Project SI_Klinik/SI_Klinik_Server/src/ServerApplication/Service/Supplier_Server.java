/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
import database.entity.Supplier;
import database.Service.Supplier_Service;
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
 * @author user
 */
public class Supplier_Server extends UnicastRemoteObject implements Supplier_Service {
    
     public Supplier_Server () throws RemoteException {
    
    }
    
     public Supplier insertSupplier(Supplier a) throws RemoteException {
        System.out.println("proses insert SUPPLIER");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO supplier(Id_Supplier, Nama_Supplier, Alamat_Supplier, Kota_Supplier, Telepon_Supplier, NPWP_Supplier, Jenis_pajak_Supplier, Kode_Pajak_Supplier) values(?,?,?,?)");
            
            statement.setString(1, a.getId_Supplier());
            statement.setString(2, a.getNama_Supplier());
            statement.setString(3, a.getAlamat_Supplier());
            statement.setString(4, a.getKota_Supplier());
            statement.setString(5, a.getTelepon_Supplier());
            statement.setString(6, a.getNPWP_Supplier());
            statement.setString(7, a.getJenis_pajak_Supplier());
            statement.setString(8, a.getKode_Pajak_Supplier());
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
        
    public void updateSupplier(Supplier b) throws RemoteException {
        System.out.println("proses update SUPPLIER");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "UPDATE supplier SET  Nama_Supplier=?, Alamat_Supplier=?, Kota_Supplier=?, Telepon_Supplier=?, NPWP_Supplier=?, Jenis_pajak_Supplier=?, KODE_SUPPLIER=? WHERE ID_SUPLIER=?");
            statement.setString(1, b.getNama_Supplier());
            statement.setString(2, b.getAlamat_Supplier());
            statement.setString(3, b.getKota_Supplier());
            statement.setString(4, b.getTelepon_Supplier());
            statement.setString(5, b.getNPWP_Supplier());
            statement.setString(6, b.getJenis_pajak_Supplier());
            statement.setString(7, b.getKode_Pajak_Supplier());
            statement.setString(8, b.getId_Supplier());
            statement.executeUpdate();  
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
    public Supplier getSupplier(String IdSuplier) throws RemoteException {
        System.out.println("melakukan proses getby ID_bahan");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM supplier WHERE ID_SUPLIER = ?");
            statement.setString(1, IdSuplier);
            ResultSet result = statement.executeQuery();
            
            Supplier a = null;
            
            if(result.next()){
                a = new Supplier();
                a.setId_Supplier((result.getString("Id_Supplier")));
                a.setNama_Supplier(result.getString("Nama_Supplier"));
                a.setAlamat_Supplier(result.getString("Alamat_Supplier"));
                a.setKota_Supplier(result.getString("Kota_Supplier"));
                a.setTelepon_Supplier(result.getString("Telepon_Supplier"));
                a.setNPWP_Supplier(result.getString("NPWP_Supplier"));
                a.setJenis_pajak_Supplier(result.getString("Jenis_pajak_Supplier"));
                a.setKode_Pajak_Supplier(result.getString("Kode_Pajak_Supplier"));
                
            }
            return a;
            
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement != null){
                try{
                    statement.close();
                }
                catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            
        }
    }

        
        
        
        
    }

