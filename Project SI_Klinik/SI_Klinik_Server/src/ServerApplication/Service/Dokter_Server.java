/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerApplication.Service;

import database.entity.dokter;
import database.Service.Dokter_Service;
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
public class Dokter_Server extends UnicastRemoteObject implements Dokter_Service {
    
    public Dokter_Server() throws RemoteException {
    
    }
    
    public dokter insertDokter(dokter dokter) throws RemoteException {

        System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO dokter (ID_DOKTER, ID_POLI, NAMA_DOKTER, ALAMAT_DOKTER,TGL_LAHIR_DOKTER, TELEPON_DOKTER, JENIS_KELAMIN_DOKTER, AGAMA_DOKTER, PASSWORD_DOKTER, NO_IJIN, TARIF_DOKTER) values(?,?,?,?,?,?,?,?,?,?,?)"
        );
        
        statement.setString(1, dokter.getid_dokter());
        statement.setString(2, dokter.getid_poli());
        statement.setString(3, dokter.getnama_dokter());
        statement.setString(4, dokter.getalamat_dokter());
        statement.setString(5, dokter.gettgl_lahir_dokter());
        statement.setString(6, dokter.gettelepon_dokter());
        statement.setString(7, dokter.getjenis_kelamin_dokter());
        statement.setString(8, dokter.getagama_dokter());
        statement.setString(9, dokter.getpassword_dokter());
        statement.setString(10, dokter.getno_ijin());
        statement.setInt(11, dokter.gettarif_dokter());
       
        statement.executeUpdate();
        
        return dokter;
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
    
    public void updateDokter(dokter dokter) throws RemoteException {

        System.out.println("Client Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE dokter SET ID_POLI=?, NAMA_DOKTER=?, ALAMAT_DOKTER=?,TGL_LAHIR_DOKTER=?, TELEPON_DOKTER=?, JENIS_KELAMIN_DOKTER=?, AGAMA_DOKTER=?, PASSWORD_DOKTER=?, NO_IJIN=?, TARIF_DOKTER=?" +
                 "WHERE ID_DOKTER =?"
         );
                 
        statement.setString(1, dokter.getid_poli());
        statement.setString(2, dokter.getnama_dokter());
        statement.setString(3, dokter.getalamat_dokter());
        statement.setString(4, dokter.gettgl_lahir_dokter());
        statement.setString(5, dokter.gettelepon_dokter());
        statement.setString(6, dokter.getjenis_kelamin_dokter());
        statement.setString(7, dokter.getagama_dokter());
        statement.setString(8, dokter.getpassword_dokter());
        statement.setString(9, dokter.getno_ijin());
        statement.setInt(10, dokter.gettarif_dokter());
        statement.setString(11, dokter.getid_dokter());
        
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

    public dokter getDokter (String Id_Dokter) throws RemoteException {

        System.out.println("Client Melakukan Proses Get By Id");
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT ID_DOKTER, ID_POLI, NAMA_DOKTER, ALAMAT_DOKTER,TGL_LAHIR_DOKTER, TELEPON_DOKTER, JENIS_KELAMIN_DOKTER, AGAMA_DOKTER, PASSWORD_DOKTER, NO_IJIN, TARIF_DOKTER FROM dokter WHERE ID_DOKTER =?");
            statement.setString(1, Id_Dokter);
            ResultSet result = statement.executeQuery();
            
            dokter a = null;
            
            if(result.next()){
                a = new dokter();
                a.setid_dokter(result.getString("ID_DOKTER"));
                a.setnama_dokter(result.getString("NAMA_DOKTER"));
                a.setid_poli(result.getString("ID_POLI"));
                a.setalamat_dokter(result.getString("ALAMAT_DOKTER"));                
                a.settelepon_dokter(result.getString("TELEPON_DOKTER"));
                a.setjenis_kelamin_dokter(result.getString("JENIS_KELAMIN_DOKTER"));
                a.settgl_lahir_dokter(result.getString("TGL_LAHIR_DOKTER"));
                a.setagama_dokter(result.getString("AGAMA_DOKTER"));                
                a.setpassword_dokter(result.getString("PASSWORD_DOKTER"));
                a.setno_ijin(result.getString("NO_IJIN"));                
                a.settarif_dokter(result.getInt("TARIF_DOKTER"));
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
    
     public dokter getDokter (String Id_Dokter, String password) throws RemoteException {

        System.out.println("Client Melakukan Proses Get By Id And Password");

        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
                 "SELECT ID_DOKTER, NAMA_DOKTER, ID_POLI, ALAMAT_DOKTER, TELEPON_DOKTER, TGL_LAHIR_DOKTER, JENIS_KELAMIN_DOKTER, NO_IJIN, AGAMA_DOKTER, TARIF_DOKTER, PASSWORD_DOKTER FROM dokter WHERE ID_DOKTER =? AND PASSWORD_DOKTER=?");

            statement.setString(1, Id_Dokter);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            
            dokter a = null;
            
            if(result.next()){
                a = new dokter();
                a.setid_dokter(result.getString("ID_DOKTER"));
                a.setnama_dokter(result.getString("NAMA_DOKTER"));
                a.setid_poli(result.getString("ID_POLI"));
                a.setalamat_dokter(result.getString("ALAMAT_DOKTER"));                
                a.settelepon_dokter(result.getString("TELEPON_DOKTER"));
                a.settgl_lahir_dokter(result.getString("TGL_LAHIR_DOKTER"));
                a.setjenis_kelamin_dokter(result.getString("JENIS_KELAMIN_DOKTER"));
                a.setagama_dokter(result.getString("AGAMA_DOKTER"));                
                a.setpassword_dokter(result.getString("PASSWORD_DOKTER"));
                a.setno_ijin(result.getString("NO_IJIN"));                
                a.settarif_dokter(result.getInt("TARIF_DOKTER"));
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
