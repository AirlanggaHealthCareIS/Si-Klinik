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
    public Presensi getPegawai(String ID_Pegawai) throws RemoteException {
        System.out.println("melakukan proses getby ID_PEGAWAI");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT NAMA_PEGAWAI FROM petugas WHERE ID_PEGAWAI = ?");
            statement.setString(1, ID_Pegawai);
            ResultSet result = statement.executeQuery();
            
            Presensi a = null;
            
            if(result.next()){
                a = new Presensi();
                a.setNama_Pegawai((result.getString("NAMA_PEGAWAI")));
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
    public Presensi getDokter(String ID_Dokter) throws RemoteException {
        System.out.println("melakukan proses getby ID_DOKTER");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT NAMA_DOKTER FROM petugas WHERE ID_DOKTER = ?");
            statement.setString(1, ID_Dokter);
            ResultSet result = statement.executeQuery();
            
            Presensi a = null;
            
            if(result.next()){
                a = new Presensi();
                a.setNama_Dokter((result.getString("NAMA_DOKTER")));
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
