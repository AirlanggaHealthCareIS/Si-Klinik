/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.entity.obat;
import database.Service.Obat_Service;
import database.Service.Obat_Service;
import database.entity.obat;
import database.Service.Generate_PO_Service;
import si_klinik_server.DatabaseUtilities;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Obat_Server extends UnicastRemoteObject implements Obat_Service {
    
    public Obat_Server() throws RemoteException {
    
    }
    
    public obat insertObat (obat obat) throws RemoteException {

        System.out.println("Apoteker Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO petugas (ID_OBAT, NAMA_OBAT, DOSIS, KETERANGAN_OBAT, STOCK_OBAT, PABRIK_OBAT, JENIS_OBAT, KEMASAN, HARGA_OBAT) values(?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        
        statement.setString(1, obat.getid_obat());
        statement.setString(2, obat.getnama_obat());
        statement.setFloat(3, obat.getdosis());
        statement.setString(4, obat.getketerangan_obat());
        statement.setInt(5, obat.getstok_obat());
        statement.setString(6, obat.getpabrik_obat());
        statement.setString(7, obat.getjenis_obat());
        statement.setString(8, obat.getkemasan());
        statement.setInt(9, obat.getharga_obat());
       
        statement.executeUpdate();
        
        return obat;
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
 public void updateObat(obat obat) throws RemoteException {

        System.out.println("Apoteker Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE obat SET NAMA_OBAT = ?" +
                 ",DOSIS = ?, KETERANGAN_OBAT = ?, STOK_OBAT = ? , PABRIK_OBAT = ?, JENIS_OBAT = ?, KEMASAN = ? , HARGA_OBAT = ?" +
                 "WHERE ID_OBAT = ?"
         );
         
        statement.setString(1, obat.getid_obat());
        statement.setString(2, obat.getnama_obat());
        statement.setFloat(3, obat.getdosis());
        statement.setString(4, obat.getketerangan_obat());
        statement.setInt(5, obat.getstok_obat());
        statement.setString(6, obat.getpabrik_obat());
        statement.setString(7, obat.getjenis_obat());
        statement.setString(8, obat.getkemasan());
        statement.setInt(9, obat.getharga_obat());

        statement.executeUpdate();
        }
        catch(SQLException exception){
          exception.printStackTrace();
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

    public obat getObat(String id_obat) throws RemoteException {

        System.out.println("Apoteker Melakukan Proses Get By Id");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                 "SELECT * FROM obat WHERE ID_OBAT = ?");

            ResultSet result = statement.executeQuery();

            obat obat = null;

            if(result.next()){
                obat.setid_obat(result.getString("ID_OBAT"));
                obat.setnama_obat(result.getString("NAMA_OBAT"));
                obat.setdosis(result.getFloat("DOSIS"));
                obat.setketerangan_obat(result.getString("KETERANGAN_OBAT"));
                obat.setstok_obat(result.getInt("STOK_OBAT"));
                obat.setpabrik_obat(result.getString("PABRIK_OBAT"));
                obat.setjenis_obat(result.getString("JENIS_OBAT"));
                obat.setkemasan(result.getString("KEMASAN"));
                obat.setharga_obat(result.getInt("HARGA_OBAT"));
            }
            return obat;
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
    public List<obat> getObatKritis() throws RemoteException {
        System.out.println("proses get obat kritis");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM OBAT WHERE STOK_OBAT <= STOK_KRITIS");
            List<obat> list = new ArrayList<obat>();
            
            while(result.next()){
                obat obat = new obat();
                obat.setid_obat(result.getString("ID_OBAT"));
                obat.setnama_obat(result.getString("NAMA_OBAT"));
              
               
                //list.add(a);
            }
            result.close();
            return list;
        } 
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException  exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
    
}
