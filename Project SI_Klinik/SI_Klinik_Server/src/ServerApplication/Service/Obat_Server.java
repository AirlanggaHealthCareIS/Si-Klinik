/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
 
import database.Service.Obat_Service;
import database.entity.obat;
import database.entity.obat_kritis;
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
    
    @Override
    public obat insertObat (obat obat) throws RemoteException {

        System.out.println("Apoteker Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO obat (ID_OBAT, ID_SUPPLIER, NAMA_OBAT, DOSIS, KETERANGAN_OBAT, STOK_OBAT, PABRIK_OBAT, JENIS_OBAT, KEMASAN, HARGA_OBAT) values(?,?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        
        statement.setString(1, obat.getid_obat());
        statement.setString(2, obat.getIdSupplier());
        statement.setString(3, obat.getnama_obat());
        statement.setFloat(4, obat.getdosis());
        statement.setString(5, obat.getketerangan_obat());
        statement.setInt(6, obat.getstok_obat());
        statement.setString(7, obat.getpabrik_obat());
        statement.setString(8, obat.getjenis_obat());
        statement.setString(9, obat.getkemasan());
        statement.setInt(10, obat.getharga_obat());
       
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
    @Override
 public void updateObat(obat obat) throws RemoteException {

        System.out.println("Apoteker Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE obat SET ID_SUPPLIER = ?, NAMA_OBAT =?" +
                 ",DOSIS =?, KETERANGAN_OBAT =?, STOK_OBAT =? , PABRIK_OBAT =?, JENIS_OBAT =?, KEMASAN =? , HARGA_OBAT =? " +
                 "WHERE ID_OBAT =?"
         );         
         
        statement.setString(10, obat.getid_obat());
        statement.setString(1, obat.getIdSupplier());
        statement.setString(2, obat.getnama_obat());
        statement.setFloat(3, obat.getdosis());
        statement.setString(4, obat.getketerangan_obat());
        statement.setInt(5, obat.getstok_obat());
        statement.setString(6, obat.getpabrik_obat());
        statement.setString(7, obat.getjenis_obat());
        statement.setString(8, obat.getkemasan());
        statement.setInt(9, obat.getharga_obat());

            System.out.println(statement.toString());
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

    @Override
    public obat getObat(String id_obat) throws RemoteException {

         System.out.println("Apoteker Melakukan Proses Get By Id");
         PreparedStatement statement = null;
         try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM obat WHERE ID_OBAT =?");
            statement.setString(1, id_obat);
            ResultSet result = statement.executeQuery();

            obat obat = new obat();

            if(result.next()){
                obat.setid_obat(result.getString("ID_OBAT"));
                obat.setIdSupplier(result.getString("ID_SUPPLIER"));
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
    
    public List<obat_kritis> getObatKritis() throws RemoteException {
        System.out.println("proses get obat kritis");
        Statement statement = null;        
        try {
            
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("select O.`ID_OBAT`, O.`NAMA_OBAT`, s.NAMA_SUPPLIER, ((O.STOK_KRITIS - O.STOK_OBAT)+1)  AS SELISIH from obat as O, supplier as s where `STOK_KRITIS` >=`STOK_OBAT` and O.ID_SUPPLIER = S.ID_SUPPLIER");

          List list = new ArrayList();
          
          while(result.next()){
            obat_kritis a = new obat_kritis();
            a.setID_OBAT(result.getString("ID_OBAT"));
            a.setNAMA_OBAT(result.getString("NAMA_OBAT"));
            a.setNAMA_SUPPLIER(result.getString("NAMA_SUPPLIER"));
            a.setSELISIH(result.getInt("SELISIH"));
            list.add(a);
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

    

    @Override 
    public List<obat> getAllObat () throws RemoteException{
        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT * FROM `obat`");

          List<obat> list = new ArrayList();
          
          while(result.next()){
              obat o = new obat();
              o.setid_obat(result.getString("ID_OBAT"));
              o.setIdSupplier(result.getString("ID_SUPPLIER"));
              o.setnama_obat(result.getString("NAMA_OBAT"));
              o.setstok_kritis(result.getInt("STOK_KRITIS"));
              o.setdosis(result.getFloat("DOSIS"));
              o.setketerangan_obat(result.getString("KETERANGAN_OBAT"));
              o.setstok_obat(result.getInt("STOK_OBAT"));    
              o.setpabrik_obat(result.getString("PABRIK_OBAT"));
              o.setjenis_obat(result.getString("JENIS_OBAT"));
              o.setkemasan(result.getString("KEMASAN"));
              o.setharga_obat(result.getInt("HARGA_OBAT"));
            list.add(o);
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
        }
    }
    
    @Override 
    public List<obat> getAllObatSort () throws RemoteException{
        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT o.ID_OBAT, o.NAMA_OBAT, s.NAMA_SUPPLIER, o.DOSIS, o.KETERANGAN_OBAT, o.STOK_OBAT, o.STOK_KRITIS, o.PABRIK_OBAT, o.JENIS_OBAT, o.KEMASAN, o.HARGA_OBAT from obat as o, supplier as s where s.ID_SUPPLIER = o.ID_SUPPLIER ORDER BY NAMA_OBAT ASC");

          List<obat> list = new ArrayList();
          
          while(result.next()){
              obat o = new obat();
              o.setid_obat(result.getString("ID_OBAT"));
              o.setnama_supplier(result.getString("NAMA_SUPPLIER"));
              o.setnama_obat(result.getString("NAMA_OBAT"));
              o.setstok_kritis(result.getInt("STOK_KRITIS"));
              o.setdosis(result.getFloat("DOSIS"));
              o.setketerangan_obat(result.getString("KETERANGAN_OBAT"));
              o.setstok_obat(result.getInt("STOK_OBAT"));
              o.setpabrik_obat(result.getString("PABRIK_OBAT"));
              o.setjenis_obat(result.getString("JENIS_OBAT"));
              o.setkemasan(result.getString("KEMASAN"));
              o.setharga_obat(result.getInt("HARGA_OBAT"));
            list.add(o);
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
        }
    }
    
    @Override
    public List getObatList(String nama) throws RemoteException {
        System.out.println("Client Melakukan Proses Get All by Name");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT NAMA_OBAT FROM `obat` WHERE ID_OBAT LIKE '"+nama+"%'"+"ORDER BY ID_OBAT DESC");

          List list = new ArrayList();
          
          while(result.next()){
            list.add(result.getString("NAMA_OBAT"));
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
        }
    }

    @Override
    public String getIdObat(String nama) throws RemoteException {
        System.out.println("Client Melakukan Proses Get Id by Name");
        String hasil = "";

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT ID_OBAT FROM `obat` WHERE NAMA_OBAT = '"+nama+"'");

          
          while(result.next()){
              hasil = result.getString("ID_OBAT");
          }
          
            System.out.println(hasil);
          result.close();

          return hasil;

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
        }
    }
    @Override 
    public obat getLastObat () throws RemoteException{
        System.out.println("Client Melakukan Proses Get All");

        Statement statement = null;
        try{
          statement = DatabaseUtilities.getConnection().createStatement();

          ResultSet result = statement.executeQuery("SELECT * FROM `obat`");

          obat o = null;
          
          while(result.next()){
              o = new obat();
              o.setid_obat(result.getString("ID_OBAT"));
              o.setnama_obat(result.getString("NAMA_OBAT"));
              o.setstok_kritis(result.getInt("STOK_KRITIS"));
              o.setdosis(result.getFloat("DOSIS"));
              o.setketerangan_obat(result.getString("KETERANGAN_OBAT"));
              o.setstok_obat(result.getInt("STOK_OBAT"));    
              o.setpabrik_obat(result.getString("PABRIK_OBAT"));
              o.setjenis_obat(result.getString("JENIS_OBAT"));
              o.setkemasan(result.getString("KEMASAN"));
              o.setharga_obat(result.getInt("HARGA_OBAT"));
              o.setnama_supplier(result.getString("NAMA_SUPPLIER"));
          }
          
          result.close();

          return o;

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
        }
    }

    }

