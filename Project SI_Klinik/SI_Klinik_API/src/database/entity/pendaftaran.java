/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class pendaftaran implements Serializable{
    private String Id_Pendaftaran;
    private String Id_Petugas;
    private String Id_Dokter;
    private String Id_Pasien;
    private String Id_Poli;
    private String Tanggal_Periksa;
    private String Keluhan;
    
    
    
    public String getId_Pendaftaran() {
        return Id_Pendaftaran;
    }

    public void setId_Pendaftaran(String Id_Pendaftaran) {
        this.Id_Pendaftaran = Id_Pendaftaran;
    }

    public String getId_Petugas() {
        return Id_Petugas;
    }

    public void setId_Petugas(String Id_Petugas) {
        this.Id_Petugas = Id_Petugas;
    }
    
    public String getId_Dokter() {
        return Id_Dokter;
    }
    
    public void setId_Dokter(String Id_Dokter) {
        this.Id_Dokter = Id_Dokter;
    }

    public String getId_Pasien() {
        return Id_Pasien;
    }

    public void setId_Pasien(String Id_Pasien) {
        this.Id_Pasien = Id_Pasien;
    }

     public String getId_Poli() {
        return Id_Poli;
    }

    public void setId_Poli(String Id_Poli) {
        this.Id_Poli = Id_Poli;
    }
    
    public String getTanggal_Periksa() {
        return Tanggal_Periksa;
    }
    
    public void setTanggal_Periksa(String Tanggal_Periksa) {
        this.Tanggal_Periksa = Tanggal_Periksa;
    }
    
    public String getKeluhan () {
        return Keluhan;
    }
    
    public void setKeluhan ( String Keluhan) {
        this.Keluhan = Keluhan;
    }
}
