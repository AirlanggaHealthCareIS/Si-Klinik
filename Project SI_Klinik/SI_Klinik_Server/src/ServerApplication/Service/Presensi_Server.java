/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication.Service;
import database.entity.Presensi;
import database.Service.Presensi_Service;
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
 * @author tinot
 */
public class Presensi_Server extends UnicastRemoteObject implements Presensi_Service{

    public Presensi_Server () throws RemoteException {
    
    }
    
    @Override
    public Presensi insertPresensi(Presensi presensi) throws RemoteException {
        System.out.println("proses insert presensi");
        PreparedStatement statement = null;
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO presensi (TANGGAL_MASUK, ID, JAM_MASUK, JAM_KELUAR) values(?,?,?,?)");
            
            statement.setString(1, presensi.getTanggal_masuk());
            statement.setString(2, presensi.getId_pegawai());
            statement.setString(3, presensi.getJam_masuk());
            statement.setString(4, presensi.getJam_keluar());
            System.out.println(statement.toString());
            statement.execute();
            return presensi;
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

    
    @Override
    public String getPegawai(String ID_Pegawai) throws RemoteException {
        System.out.println("melakukan proses getby ID_PEGAWAI");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT NAMA_PETUGAS FROM petugas WHERE ID_PETUGAS = ?");
            statement.setString(1, ID_Pegawai);
            ResultSet result = statement.executeQuery();
            
            Presensi a = null;
            
            if(result.next()){
                a = new Presensi();
                a.setNama_Pegawai((result.getString("NAMA_PETUGAS")));
            }
            return a.getNama_Pegawai().toString();
            
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
    public String getDokter(String ID_Dokter) throws RemoteException {
        System.out.println("melakukan proses getby ID_DOKTER");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT NAMA_DOKTER FROM dokter WHERE ID_DOKTER = ?");
            statement.setString(1, ID_Dokter);
            ResultSet result = statement.executeQuery();
            
            Presensi a = null;
            
            if(result.next()){
                a = new Presensi();
                a.setNama_Dokter((result.getString("NAMA_DOKTER")));
            }
            return a.getNama_Dokter().toString();
            
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
    public void updatePresensi(Presensi p) throws RemoteException {
        System.out.println("proses update Presensi");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
            "UPDATE presensi SET JAM_KELUAR=? WHERE ID=? AND TANGGAL_MASUK=? ");
            statement.setString(1, p.getJam_keluar());
            statement.setString(2, p.getId_pegawai());
            statement.setString(3, p.getTanggal_masuk());
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

    @Override
    public Presensi getPegawaiFromPresensi(String ID_Pegawai, String tanggal) throws RemoteException {
        System.out.println("melakukan proses getAll Presensi");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM presensi WHERE ID = ? AND TANGGAL_MASUK = ?");
            statement.setString(1, ID_Pegawai);
            statement.setString(2, tanggal);
            ResultSet result = statement.executeQuery();
            
            Presensi a = null;
            
            if(result.next()){
                a = new Presensi();
                a.setId_pegawai((result.getString("ID")));
                a.setTanggal_masuk((result.getString("TANGGAL_MASUK")));
                a.setJam_masuk((result.getString("JAM_MASUK")));
                a.setJam_keluar((result.getString("JAM_KELUAR")));
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
    public List<Presensi> getPegawaiCek(String ID) throws RemoteException {
        System.out.println("proses get Pegawai");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT ID_PETUGAS, NAMA_PETUGAS FROM petugas WHERE ID_PETUGAS = '"+ID+"'");
            List<Presensi> list = new ArrayList<Presensi>();
            
            while(result.next()){
                Presensi a = new Presensi();
                a.setId_pegawai((result.getString("ID_PETUGAS")));
                a.setNama_Pegawai((result.getString("NAMA_PETUGAS")));
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
    public Presensi getLastPresensi() throws RemoteException {
        System.out.println("proses get ALL PRESENSI");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM presensi ORDER BY TANGGAL_MASUK DESC LIMIT 1");
            Presensi a = null;
            while(result.next()){
                a = new Presensi();
                a.setTanggal_masuk((result.getString("TANGGAL_MASUK")));
                a.setId_pegawai(result.getString("ID"));
                a.setJam_masuk(result.getString("JAM_MASUK"));
                a.setJam_keluar(result.getString("JAM_KELUAR"));
            }    
            result.close();
            return a;
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
    public List<Presensi> getDokterCek(String ID) throws RemoteException {
        System.out.println("proses get Dokter");
        Statement statement = null;
        
        try {
            statement = DatabaseUtilities.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT ID_DOKTER, NAMA_DOKTER FROM dokter WHERE ID_DOKTER = '"+ID+"'");
            List<Presensi> list = new ArrayList<Presensi>();
            
            while(result.next()){
                Presensi a = new Presensi();
                a.setId_pegawai((result.getString("ID_DOKTER")));
                a.setNama_Dokter((result.getString("NAMA_DOKTER")));
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
    
}
