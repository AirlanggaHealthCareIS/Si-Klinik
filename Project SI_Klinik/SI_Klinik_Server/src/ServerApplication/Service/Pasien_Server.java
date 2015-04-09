/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;

import database.entity.Pasien;
import database.Service.Pasien_Service;
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
public class Pasien_Server extends UnicastRemoteObject implements Pasien_Service {
    
    public Pasien_Server() throws RemoteException {
    
    }
    
    public Pasien insertPasien(Pasien Pasien) throws RemoteException {

        System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO Pasien (ID_PASIEN, NAMA_PASIEN, ALAMAT_PASIEN, JENIS_KELAMIN_PASIEN, TEMAPT_LAHIR_PASIEN, TGL_LAHIR_PASIEN,"
                + " NOMOR_TELEPON_PASIEN, UMUR_PASIEN, AGAMA_PASIEN, PEKERJAAN_PASIEN, NOMOR_BPJS-PASIEN, GOLONGAN_DARAH_PASIEN ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        
        statement.setString(1, Pasien.getId_Pasien());
        statement.setString(2, Pasien.getNama_Pasien());
        statement.setString(3, Pasien.getAlamat());
        statement.setString(4, Pasien.getJenis_Kelamin());
        statement.setString(5, Pasien.getTempat_Lahir());
        statement.setString(6, Pasien.getTanggal_Lahir());
        statement.setString(7, Pasien.getNomor_Telepon());
        statement.setString(8, Pasien.getUmur());
        statement.setString(9, Pasien.getAgama());
        statement.setString(10,Pasien.getPekerjaan());
        statement.setString(11,Pasien.getNomor_BPJS_Pasien());
        statement.setString(12,Pasien.getGolongan_Darah());
        
        statement.executeUpdate();
        
        return Pasien;
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
    
    public void updatePasien(Pasien Pasien) throws RemoteException {

        System.out.println("Client Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE Pasien SET NAMA_PASIEN = ?" +
                 ", ALAMAT_PASIEN = ?, JENIS_KELAMIN_PASIEN = ?, TEMAPT_LAHIR_PASIEN = ?, TGL_LAHIR_PASIEN = ?,"
                + " NOMOR_TELEPON_PASIEN = ?, UMUR_PASIEN = ?, AGAMA_PASIEN = ?, PEKERJAAN_PASIEN = ?, NOMOR_BPJS-PASIEN = ?, GOLONGAN_DARAH_PASIEN = ?" +
                 "WHERE ID_PASIEN = ?"
         );
         
        statement.setString(1, Pasien.getId_Pasien());
        statement.setString(2, Pasien.getNama_Pasien());
        statement.setString(3, Pasien.getAlamat());
        statement.setString(4, Pasien.getJenis_Kelamin());
        statement.setString(5, Pasien.getTempat_Lahir());
        statement.setString(6, Pasien.getTanggal_Lahir());
        statement.setString(7, Pasien.getNomor_Telepon());
        statement.setString(8, Pasien.getUmur());
        statement.setString(9, Pasien.getAgama());
        statement.setString(10,Pasien.getPekerjaan());
        statement.setString(11,Pasien.getNomor_BPJS_Pasien());
        statement.setString(12,Pasien.getGolongan_Darah());

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

    public Pasien getCustomer (String Id_Pasien) throws RemoteException {

        System.out.println("Client Melakukan Proses Get By Id");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                 "SELECT * FROM petugas WHERE ID_PASIEN = ?");

            ResultSet result = statement.executeQuery();

            Pasien Pasien = null;

            if(result.next()){
                Pasien.setId_Pasien(result.getString("ID_PASIEN"));
                Pasien.setNama_Pasien(result.getString("NAMA_PASIEN"));
                Pasien.setAlamat(result.getString("ALAMAT_PASIEN"));
                Pasien.setJenis_Kelamin(result.getString("JENIS_KELAMIN_PASIEN"));
                Pasien.setTempat_Lahir(result.getString("TEMPAT_LAHIR_PASIEN"));
                Pasien.setTanggal_Lahir(result.getString("TANGGAL_LAHIR_PASIEN"));
                Pasien.setNomor_Telepon(result.getString("NOMOR_TELEPON_PASIEN"));
                Pasien.setUmur(result.getString("UMUR_PASIEN"));
                Pasien.setAgama(result.getString("AGAMA_PASIEN"));
                Pasien.setPekerjaan(result.getString("PEKERJAAN_PASIEN"));
                Pasien.setNomor_BPJS_Pasien(result.getString("NOMOR_BPJS_PASIEN"));
                Pasien.setGolongan_Darah(result.getString("GOLONGAN_DARAH_PASIEN"));
            }

            return Pasien;

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
    public Pasien getPasien(String ID_Pasien) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
