/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tinot
 */
public class Presensi implements Serializable{
    private String Tanggal_masuk;
    private String Jam_masuk;
    private String Jam_keluar;
    private String Id_pegawai;
    private String Nama_Pegawai;
    private String Nama_Dokter;
    
    public String getTanggal_masuk() {
        return Tanggal_masuk;
    }

    public void setTanggal_masuk(String Tanggal_masuk) {
        this.Tanggal_masuk = Tanggal_masuk;
    }
    
    public String getJam_masuk() {
        return Jam_masuk;
    }

    public void setJam_masuk(String Jam_masuk) {
        this.Jam_masuk = Jam_masuk;
    }
    
    public String getJam_keluar() {
        return Jam_keluar;
    }

    public void setJam_keluar(String Jam_keluar) {
        this.Jam_keluar = Jam_keluar;
    }
    
    public String getId_pegawai() {
        return Id_pegawai;
    }

    public void setId_pegawai(String Id_pegawai) {
        this.Id_pegawai = Id_pegawai;
    }
    
    public String getNama_Pegawai() {
        return Nama_Pegawai;
    }

    public void setNama_Pegawai(String Nama_Pegawai) {
        this.Nama_Pegawai = Nama_Pegawai;
    }
    
    public String getNama_Dokter() {
        return Nama_Dokter;
    }

    public void setNama_Dokter(String Nama_Dokter) {
        this.Nama_Dokter = Nama_Dokter;
    }
    
}
