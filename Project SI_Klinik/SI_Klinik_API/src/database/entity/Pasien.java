/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Pasien implements Serializable{
    private String Id_Pasien;
    private String Nama_Pasien;
    private String Alamat;
    private String Jenis_Kelamin;
    private String Tempat_Lahir;
    private String Tanggal_Lahir;
    private String Nomor_Telepon;
    private String Umur;
    private String Agama;
    private String Pekerjaan;
    private String Nomor_BPJS_Pasien;
    private String Golongan_Darah;
            

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

    public String getJenis_Kelamin() {
        return Jenis_Kelamin;
    }

    public void setJenis_Kelamin(String Jenis_Kelamin) {
        this.Jenis_Kelamin = Jenis_Kelamin;
    }

     public String getTempat_Lahir() {
        return Tempat_Lahir;
    }

    public void setTempat_Lahir(String Tempat_Lahir) {
        this.Tempat_Lahir = Tempat_Lahir;
    }
    
    public String getTanggal_Lahir() {
        return Tanggal_Lahir;
    }
    
    public void setTanggal_Lahir(String Tanggal_Lahir) {
        this.Tanggal_Lahir = Tanggal_Lahir;
    }
    
    public String getNomor_Telepon () {
        return Nomor_Telepon;
    }
    
    public void setNomor_Telepon ( String Nomor_Telepon) {
        this.Nomor_Telepon = Nomor_Telepon;
    }
    
    public String getUmur () {
        return Umur;
    }
    
    public void setUmur ( String Umur) {
        this.Umur = Umur;
}
    
    public String getAgama () {
        return Agama;
    }
    
    public void setAgama ( String Agama) {
        this.Agama = Agama;
    }
    
    public String getPekerjaan () {
        return Pekerjaan;
    }
    
    public void setPekerjaan ( String Pekerjaan) {
        this.Pekerjaan = Pekerjaan;
    
}
    
    public String getNomor_BPJS_Pasien () {
        return Nomor_BPJS_Pasien;
    }
    
    public void setNomor_BPJS_Pasien ( String Nomor_BPJS_Pasien) {
        this.Nomor_BPJS_Pasien = Nomor_BPJS_Pasien;
    
}
    
    public String getGolongan_Darah () {
        return Golongan_Darah;
    }
    
    public void setGolongan_Darah ( String Golongan_Darah) {
        this.Golongan_Darah = Golongan_Darah;
    }
}