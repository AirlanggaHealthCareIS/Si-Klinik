/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerApplication.Service;

import database.entity.petugas;
import database.Service.Petugas_Service;
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
 * @author Windows 8.1
 */
public class Petugas_Server extends UnicastRemoteObject implements Petugas_Service {
    
    public Petugas_Server() throws RemoteException {
    
    }
    
    public petugas insertPetugas(petugas petugas) throws RemoteException {

        System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO petugas (ID_PETUGAS, NAMA_PETUGAS, JABATAN_PETUGAS, ALAMAT_PETUGAS, TELEPON_PETUGAS, TGL_LAHIR_PETUGAS, JENIS_KELAMIN_PETUGAS, AGAMA_PETUGAS, PASSWORD_PETUGAS) values(?,?,?,?,?,?,?,?,?)"
        );
        
        statement.setString(1, petugas.getId_Petugas());
        statement.setString(2, petugas.getNama_Petugas());
        statement.setString(3, petugas.getJabatan());
        statement.setString(4, petugas.getAlamat());
        statement.setString(5, petugas.getTelepon());
        statement.setString(6, petugas.getTanggalLahir());
        statement.setString(7, petugas.getJenKel());
        statement.setString(8, petugas.getAgama());
        statement.setString(9, petugas.getPassword());
       
        statement.executeUpdate();
        
        return petugas;
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
    
    public void updatePetugas(petugas petugas) throws RemoteException {

        System.out.println("Client Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE petugas SET NAMA_PETUGAS =?, JABATAN_PETUGAS =?, ALAMAT_PETUGAS =?, TELEPON_PETUGAS =? , TGL_LAHIR_PETUGAS =?, JENIS_KELAMIN_PETUGAS =?, AGAMA_PETUGAS =? , PASSWORD_PETUGAS =?" +
                 "WHERE ID_PETUGAS =?"
         );
                 
        statement.setString(1, petugas.getNama_Petugas());
        statement.setString(2, petugas.getJabatan());
        statement.setString(3, petugas.getAlamat());
        statement.setString(4, petugas.getTelepon());
        statement.setString(5, petugas.getTanggalLahir());
        statement.setString(6, petugas.getJenKel());
        statement.setString(7, petugas.getAgama());
        statement.setString(8, petugas.getPassword());
        statement.setString(9, petugas.getId_Petugas());
        
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

    public petugas getPetugas (String Id_Petugas) throws RemoteException {

        System.out.println("Client Melakukan Proses Get By Id");
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT ID_PETUGAS, NAMA_PETUGAS, JABATAN_PETUGAS, ALAMAT_PETUGAS, TELEPON_PETUGAS, TGL_LAHIR_PETUGAS, JENIS_KELAMIN_PETUGAS, AGAMA_PETUGAS, PASSWORD_PETUGAS FROM petugas WHERE ID_PETUGAS =?");
            statement.setString(1, Id_Petugas);
            ResultSet result = statement.executeQuery();
            
            petugas a = null;
            
            if(result.next()){
                a = new petugas();
                a.setId_Petugas(result.getString("ID_PETUGAS"));
                a.setNama_Petugas(result.getString("NAMA_PETUGAS"));
                a.setJabatan(result.getString("JABATAN_PETUGAS"));
                a.setAlamat(result.getString("ALAMAT_PETUGAS"));
                a.setTelepon(result.getString("TELEPON_PETUGAS"));
                a.setTanggalLahir(result.getString("TGL_LAHIR_PETUGAS"));
                a.setAgama(result.getString("AGAMA_PETUGAS"));
                a.setJenKel(result.getString("JENIS_KELAMIN_PETUGAS"));
                a.setPassword(result.getString("PASSWORD_PETUGAS"));
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
    
     public petugas getPetugas (String Id_Petugas, String password) throws RemoteException {

        System.out.println("Client Melakukan Proses Get By Id And Password");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                 "SELECT ID_PETUGAS, NAMA_PETUGAS, JABATAN_PETUGAS, ALAMAT_PETUGAS, TELEPON_PETUGAS, TGL_LAHIR_PETUGAS, JENIS_KELAMIN_PETUGAS, AGAMA_PETUGAS, PASSWORD_PETUGAS FROM petugas WHERE ID_PETUGAS =? AND PASSWORD_PETUGAS=?");

            statement.setString(1, Id_Petugas);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            
            petugas a = null;
            
            if(result.next()){
                a = new petugas();
                a.setId_Petugas(result.getString("ID_PETUGAS"));
                a.setNama_Petugas(result.getString("NAMA_PETUGAS"));
                a.setJabatan(result.getString("JABATAN_PETUGAS"));
                a.setAlamat(result.getString("ALAMAT_PETUGAS"));
                a.setTelepon(result.getString("TELEPON_PETUGAS"));
                a.setTanggalLahir(result.getString("TGL_LAHIR_PETUGAS"));
                a.setAgama(result.getString("AGAMA_PETUGAS"));
                a.setJenKel(result.getString("JENIS_KELAMIN_PETUGAS"));
                a.setPassword(result.getString("PASSWORD_PETUGAS"));
            }
            return a;
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
