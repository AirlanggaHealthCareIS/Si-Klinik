/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.entity.pendaftaran;
import database.Service.Pendaftaran_Service;
import database.entity.dokter;
import database.entity.poliklinik;
import si_klinik_server.DatabaseUtilities;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Pendaftaran_Server extends UnicastRemoteObject implements Pendaftaran_Service {
    
    public Pendaftaran_Server() throws RemoteException {
    
    }
    
    @Override
    public pendaftaran insertPendaftaran(pendaftaran Pendaftaran) throws RemoteException{
        System.out.println("Client Melakukan Proses Insert");
        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO pendaftaran (ID_PENDAFTARAN, ID_PETUGAS, ID_DOKTER, ID_PASIEN, ID_POLI, TGL_PERIKSA, KELUHAN, NO_ANTRIAN) VALUES (NULL, ?,?,?,?,?,?,?)"
        );
        
        statement.setString(1, Pendaftaran.getId_Petugas());
        statement.setString(2, Pendaftaran.getId_Dokter());
        statement.setString(3, Pendaftaran.getId_Pasien());
        statement.setString(4, Pendaftaran.getId_Poli());
        statement.setString(5, Pendaftaran.getTanggal_Periksa());
        statement.setString(6, Pendaftaran.getKeluhan());
        statement.setInt(7, Pendaftaran.getAntrian());
       
        statement.executeUpdate();
        
        return Pendaftaran;
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
    public void updatePendaftaran(pendaftaran Pendaftaran) throws RemoteException{
    System.out.println("Client Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE pendaftaran SET ID_PETUGAS=?, ID_DOKTER=?, ID_PASIEN=?, ID_POLI=?, TGL_PERIKSA=?, KELUHAN=?, ANTRIAN=?" +
                 "WHERE ID_PENDAFTARAN =?"
         );
                 
        statement.setString(1, Pendaftaran.getId_Petugas());
        statement.setString(2, Pendaftaran.getId_Dokter());
        statement.setString(3, Pendaftaran.getId_Pasien());
        statement.setString(4, Pendaftaran.getId_Poli());
        statement.setString(5, Pendaftaran.getTanggal_Periksa());
        statement.setString(6, Pendaftaran.getKeluhan());
        statement.setInt(7, Pendaftaran.getAntrian());
        statement.setString(8, Pendaftaran.getId_Pendaftaran());
        
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
    public pendaftaran getPendaftaran (String ID_Pendaftaran) throws RemoteException{
    System.out.println("Client Melakukan Proses Get By Id");
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT ID_PETUGAS, ID_DOKTER, ID_PASIEN, ID_POLI, TGL_PERIKSA, KELUHAN, NO_ANTRIAN FROM Pendaftaran WHERE ID_PENDAFTARAN =?");
            statement.setString(1, ID_Pendaftaran);
            ResultSet result = statement.executeQuery();
            
            pendaftaran a = null;
            
            if(result.next()){
                a = new pendaftaran();
                a.setId_Dokter(result.getString("ID_DOKTER"));
                a.setId_Petugas(result.getString("ID_PETUGAS"));
                a.setId_Pasien(result.getString("ID_PASIEN"));
                a.setId_Poli(result.getString("ID_POLI"));
                a.setTanggal_Periksa(result.getString("TGL_PERIKSA"));
                a.setKeluhan(result.getString("KELUHAN"));
                a.setAntrian(result.getInt("NO_ANTRIAN"));
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
    
    @Override    
    public List<pendaftaran> getPendaftarans(String tanggal) throws RemoteException{
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM pendaftaran WHERE TGL_PERIKSA=?");
            statement.setString(1, tanggal);
            ResultSet result = statement.executeQuery();
            
            List<pendaftaran> list = new ArrayList<pendaftaran>();

            while(result.next()){
                pendaftaran a = new pendaftaran();
                a.setId_Dokter(result.getString("ID_DOKTER"));
                a.setId_Petugas(result.getString("ID_PETUGAS"));
                a.setId_Pasien(result.getString("ID_PASIEN"));
                a.setId_Poli(result.getString("ID_POLI"));
                a.setTanggal_Periksa(result.getString("TGL_PERIKSA"));
                a.setKeluhan(result.getString("KELUHAN"));
                a.setAntrian(result.getInt("NO_ANTRIAN"));
                list.add(a);
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
    public List<poliklinik> getPoli(){
    System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM poliklinik ORDER BY nama_poli ASC");
            ResultSet result = statement.executeQuery();
            
            List<poliklinik> list = new ArrayList<poliklinik>();

            while(result.next()){
                poliklinik p = new poliklinik();
                p.setId_Poli(result.getString("ID_POLI"));
                p.setNama_Poli(result.getString("NAMA_POLI"));
                list.add(p);
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
    public poliklinik getPoliFromNama(String nama){
         PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM poliklinik WHERE nama_poli=?");
            statement.setString(1, nama);
            ResultSet result = statement.executeQuery();
            poliklinik p =null; 
            
            if(result.next()){ 
                p = new poliklinik();
                p.setId_Poli(result.getString("ID_POLI"));
                p.setNama_Poli(result.getString("NAMA_POLI"));             
            }
           result.close();
           return p;
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
    public List<dokter> GetDokter(String id_poli){
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT D.NAMA_DOKTER,D.ID_DOKTER,D.ID_POLI FROM DOKTER AS D, JADWAL AS J WHERE D.ID_DOKTER=J.ID_DOKTER AND J.HARI = DAYOFWEEK(CURDATE()) AND J.JAM_MASUK < HOUR(CURTIME()) AND J.JAM_PULANG > HOUR(CURTIME()) AND D.ID_POLI =?");
            statement.setString(1, id_poli);
            ResultSet result = statement.executeQuery();
            
            List<dokter> list = new ArrayList<dokter>();

            while(result.next()){
                dokter d = new dokter();
                d.setid_dokter(result.getString("ID_DOKTER"));
                d.setnama_dokter(result.getString("NAMA_DOKTER"));
                d.setid_poli(result.getString("ID_POLI"));
                list.add(d);
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
    public int getJumlahAntrianDokter(String id_dokter, String id_poli){
        
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT COUNT(*) FROM pendaftaran WHERE ID_DOKTER =? AND ID_POLI =? AND STATUS = 0 AND TGL_PERIKSA = CURDATE()");
            statement.setString(1, id_dokter);
            statement.setString(2, id_dokter);
            ResultSet result = statement.executeQuery();
            
            int i = 0;

            if(result.next()){
                i = result.getInt("COUNT(*)");
            }            
           result.close();
           return i;
        }
        catch(SQLException exception){
          exception.printStackTrace();
          return 0;
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
   


