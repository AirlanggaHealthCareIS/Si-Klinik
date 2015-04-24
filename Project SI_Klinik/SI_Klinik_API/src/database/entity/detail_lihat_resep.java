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
public class detail_lihat_resep implements Serializable{
    private int Id_Pasien;
    private String Tanggal;
    private String nama_Dokter;
    private String nama_obat;
    private String nama_pasien;
    private int qty;
    
    public int getId_Pasien() {
        return Id_Pasien;
    }

    public void setId_Pasien(int Id_Pasien) {
        this.Id_Pasien = Id_Pasien;
    }
    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }
    
    public String getNamaPasien() {
        return nama_pasien;
    }

    public void setNamaPasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNama_Dokter() {
        return nama_Dokter;
    }

    public void setNama_Dokter(String nama_Dokter) {
        this.nama_Dokter = nama_Dokter;
    }
    
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public String getObat() {
        return nama_obat;
    }

    public void setObat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
}
