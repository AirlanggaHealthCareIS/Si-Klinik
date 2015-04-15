/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerApplication.Service;

import database.entity.Rekam_Medis;
import database.Service.RekamMedik_Service;
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
public class Rekam_Medis_Server extends UnicastRemoteObject implements RekamMedik_Service {
    
    public Rekam_Medis_Server() throws RemoteException {
    
    }
    
    @Override
    public Rekam_Medis insertRekamMedik(Rekam_Medis rekam) throws RemoteException{
        System.out.println("Client Melakukan Proses Insert");

        PreparedStatement statement = null;
        try{
        statement = DatabaseUtilities.getConnection().prepareStatement(
            "INSERT INTO `rekam_medis`(`ID_REKAM_MEDIS`, `ID_DOKTER`, `ID_PASIEN`, `TGL_REKAM_MEDIS`, `ALERGI_OBAT`, `RIWAYAT_SEKARANG`, `RIWAYAT_DAHULU`, `RIWAYAT_KELUARGA`, `KETERANGAN_PEKERJAAN`, `KEBIASAAN`, `KEADAAN_UMUM`, `GCS`, `KESADARAN`, `TENSI`, `NADI`, `RR`, `TEMPERATURE`, `PEMERIKSAAN_LAIN`, `TPL`, `RUJUKAN_DOKTER`) VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
        );
        
        statement.setString(1, rekam.getId_Dokter());
        statement.setString(2, rekam.getId_Pasien());
        statement.setString(3, rekam.getTanggal_Rekam_Medis());
        statement.setString(4, rekam.getAlergi_Obat());
        statement.setString(5, rekam.getRiwayat_Sekarang());
        statement.setString(6, rekam.getRiwayat_Dahulu());
        statement.setString(7, rekam.getRiwayat_Keluarga());
        statement.setString(8, rekam.getKeterangan_Pekerjaan());
        statement.setString(9, rekam.getKebiasaan());
        statement.setString(10, rekam.getKeadaanUmum());
        statement.setInt(11, rekam.getGCS());
        statement.setString(12, rekam.getKesadaran());
        statement.setString(13, rekam.getTensi());
        statement.setInt(14, rekam.getNadi());
        statement.setInt(15, rekam.getRR());
        statement.setInt(16, rekam.getTemperature());
        statement.setString(17, rekam.getPemeriksaan_Lain());
        statement.setString(18, rekam.getTPL());
        statement.setString(19, rekam.getRujukan_Dokter());
        
        statement.executeUpdate();
        
        return rekam;
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
    public void updateRekamMedik(Rekam_Medis rekam) throws RemoteException{
        System.out.println("Client Melakukan Proses Update");

        PreparedStatement statement = null;
        try{
         statement = DatabaseUtilities.getConnection().prepareStatement(
                 "UPDATE `rekam_medis` SET `ID_DOKTER`=?,`ID_PASIEN`=?,`TGL_REKAM_MEDIS`=?,`ALERGI_OBAT`=?,`RIWAYAT_SEKARANG`=?,`RIWAYAT_DAHULU`=?,`RIWAYAT_KELUARGA`=?,`KETERANGAN_PEKERJAAN`=?,`KEBIASAAN`=?,`KEADAAN_UMUM`=?,`GCS`=?,`KESADARAN`=?,`TENSI`=?,`NADI`=?,`RR`=?,`TEMPERATURE`=?,`PEMERIKSAAN_LAIN`=?,`TPL`=?,`RUJUKAN_DOKTER`=?"
                 + "WHERE `ID_REKAM_MEDIS`= ?"
         );
         
        statement.setString(1, rekam.getId_Dokter());
        statement.setString(2, rekam.getId_Pasien());
        statement.setString(3, rekam.getTanggal_Rekam_Medis());
        statement.setString(4, rekam.getAlergi_Obat());
        statement.setString(5, rekam.getRiwayat_Sekarang());
        statement.setString(6, rekam.getRiwayat_Dahulu());
        statement.setString(7, rekam.getRiwayat_Keluarga());
        statement.setString(8, rekam.getKeterangan_Pekerjaan());
        statement.setString(9, rekam.getKebiasaan());
        statement.setString(10, rekam.getKeadaanUmum());
        statement.setInt(11, rekam.getGCS());
        statement.setString(12, rekam.getKesadaran());
        statement.setString(13, rekam.getTensi());
        statement.setInt(14, rekam.getNadi());
        statement.setInt(15, rekam.getRR());
        statement.setInt(16, rekam.getTemperature());
        statement.setString(17, rekam.getPemeriksaan_Lain());
        statement.setString(18, rekam.getTPL());
        statement.setString(19, rekam.getRujukan_Dokter());
        statement.setString(20, rekam.getId_Rekam_Medis());
         
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
    public Rekam_Medis getRekamMedik (String ID_Rekam) throws RemoteException{
        System.out.println("Client Melakukan Proses Get By Id");
        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT `ID_REKAM_MEDIS`, `ID_DOKTER`, `ID_PASIEN`, `TGL_REKAM_MEDIS`, `ALERGI_OBAT`, `RIWAYAT_SEKARANG`, `RIWAYAT_DAHULU`, `RIWAYAT_KELUARGA`, `KETERANGAN_PEKERJAAN`, `KEBIASAAN`, `KEADAAN_UMUM`, `GCS`, `KESADARAN`, `TENSI`, `NADI`, `RR`, `TEMPERATURE`, `PEMERIKSAAN_LAIN`, `TPL`, `RUJUKAN_DOKTER` FROM rekam_medis WHERE ID_REKAM_MEDIS =?");
            statement.setString(1, ID_Rekam);
            ResultSet result = statement.executeQuery();
            
            Rekam_Medis a = null;
            
            if(result.next()){
                a = new Rekam_Medis();
                a.setId_Rekam_Medis(result.getString("ID_REKAM_MEDIS"));
                a.setId_Dokter(result.getString("ID_DOKTER"));
                a.setId_Pasien(result.getString("ID_PASIEN"));
                a.setTanggal_Rekam_Medis(result.getString("TGL_REKAM_MEDIS"));
                a.setAlergi_Obat(result.getString("ALERGI_OBAT"));
                a.setRiwayat_Sekarang(result.getString("RIWAYAT_SEKARANG"));
                a.setRiwayat_Dahulu(result.getString("RIWAYAT_DAHULU"));
                a.setRiwayat_Keluarga(result.getString("RIWAYAT_KELUARGA"));
                a.setKeterangan_Pekerjaan(result.getString("KETERANGAN_PEKERJAAN"));
                a.setKebiasaan(result.getString("KEBIASAAN"));
                a.setKeadaanUmum(result.getString("KEADAAN_UMUM"));
                a.setGCS(result.getInt("GCS"));
                a.setKesadaran(result.getString("KESADARAN"));
                a.setTensi(result.getString("TENSI"));
                a.setNadi(result.getInt("NADI"));
                a.setRR(result.getInt("RR"));
                a.setTemperature(result.getInt("TEMPERATURE"));
                a.setPemeriksaan_Lain(result.getString("PEMERIKSAAN_LAIN"));
                a.setTPL(result.getString("TPL"));
                a.setRujukan_Dokter(result.getString("RUJUKAN_DOKTER"));
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
    public List<Rekam_Medis> getRekamMediks(String ID_Pasien) throws RemoteException{
        System.out.println("Client Melakukan Proses Get All");

        PreparedStatement statement = null;
        
        try{
            statement = DatabaseUtilities.getConnection().prepareStatement("SELECT * FROM rekam_medis WHERE ID_PASIEN=?");
            statement.setString(1, ID_Pasien);
            ResultSet result = statement.executeQuery();
            
            List<Rekam_Medis> list = new ArrayList<Rekam_Medis>();

            while(result.next()){
                Rekam_Medis a = new Rekam_Medis();
                a.setId_Rekam_Medis(result.getString("ID_REKAM_MEDIS"));
                a.setId_Dokter(result.getString("ID_DOKTER"));
                a.setId_Pasien(result.getString("ID_PASIEN"));
                a.setTanggal_Rekam_Medis(result.getString("TGL_REKAM_MEDIS"));
                a.setAlergi_Obat(result.getString("ALERGI_OBAT"));
                a.setRiwayat_Sekarang(result.getString("RIWAYAT_SEKARANG"));
                a.setRiwayat_Dahulu(result.getString("RIWAYAT_DAHULU"));
                a.setRiwayat_Keluarga(result.getString("RIWAYAT_KELUARGA"));
                a.setKeterangan_Pekerjaan(result.getString("KETERANGAN_PEKERJAAN"));
                a.setKebiasaan(result.getString("KEBIASAAN"));
                a.setKeadaanUmum(result.getString("KEADAAN_UMUM"));
                a.setGCS(result.getInt("GCS"));
                a.setKesadaran(result.getString("KESADARAN"));
                a.setTensi(result.getString("TENSI"));
                a.setNadi(result.getInt("NADI"));
                a.setRR(result.getInt("RR"));
                a.setTemperature(result.getInt("TEMPERATURE"));
                a.setPemeriksaan_Lain(result.getString("PEMERIKSAAN_LAIN"));
                a.setTPL(result.getString("TPL"));
                a.setRujukan_Dokter(result.getString("RUJUKAN_DOKTER"));
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
}