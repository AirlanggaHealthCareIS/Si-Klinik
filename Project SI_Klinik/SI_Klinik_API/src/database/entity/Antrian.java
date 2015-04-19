/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;
import java.io.Serializable;
import java.util.ArrayList;


public class Antrian implements Serializable{
    private String Id_Pasien;
    private String Nama_Pasien;
    private String Alamat;
    private int Nomor;
    private String keluhan;
    
    public String getId_Pasien() {
        return Id_Pasien;
    }

    public void setId_Pasien(String Id_Pasien) {
        this.Id_Pasien = Id_Pasien;
    }

    public String getNama_Pasien() {
        return Nama_Pasien;
    }

    public void setNama_Pasien(String Nama_Pasien) {
        this.Nama_Pasien = Nama_Pasien;
    }
    
    public String getAlamat() {
        return Alamat;
    }
    
    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
    
    public String getKeluhan() {
        return keluhan;
    }
    
    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public int getNomor() {
        return Nomor;
    }

    public void setNomor(int Nomor) {
        this.Nomor = Nomor;
    }
}