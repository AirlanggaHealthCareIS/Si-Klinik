/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Rekam_Medis implements Serializable{
    private String Id_Rekam_Medis;
    private String Id_Dokter;
    private String Id_Pasien;
    private String Id_penyakit;
    private String Tanggal_Rekam_Medis;
    private String Alergi_Obat;
    private String Anamnesa;
    private String Pemeriksaan;
    private String Terapi;
    private String Diagnosa;
    private String Hasil;
    private String Status;
    private String Keterangan_Obat_Rekam_Medis;
    private String Rujukan_Dokter;
    private String Tindakan_Dokter_Rekam_Medis;
            

    public String getId_Rekam_Medis() {
        return Id_Rekam_Medis;
    }

    public void setId_Petugas(String Id_Rekam_Medis) {
        this.Id_Rekam_Medis = Id_Rekam_Medis;
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
    
     public String getId_penyakit() {
        return Id_penyakit;
    }

    public void setId_penyakit(String Id_penyakit) {
        this.Id_penyakit = Id_penyakit;
    }
    
     public String getTanggal_Rekam_Medis() {
        return Tanggal_Rekam_Medis;
    }

    public void setTanggal_Rekam_Medis(String Tanggal_Rekam_Medis) {
        this.Tanggal_Rekam_Medis = Tanggal_Rekam_Medis;
    }
    
     public String getAlergi_Obat() {
        return Alergi_Obat;
    }

     public void setAlergi_Obat(String Alergi_Obat) {
        this.Alergi_Obat = Alergi_Obat;
    }
    
     public String getAnamnesa() {
        return Anamnesa;
    }
     
     public void setAnamnesa(String Anamnesa) {
        this.Anamnesa = Anamnesa;
    }
     
     public String getPemeriksaan() {
        return Pemeriksaan;
    }
     
     public void setPemeriksaan(String Pemeriksaan) {
        this.Pemeriksaan = Pemeriksaan;
    }
     
    public String getTerapi() {
        return Terapi;
    }
     
     public void setTerapi(String Terapi) {
        this.Terapi = Terapi;
    }
     
     public String getDiagnosa() {
        return Diagnosa;
    }
     
     public void setDiagnosa(String Diagnosa) {
        this.Diagnosa = Diagnosa;
    }
     
     public String getHasil() {
        return Hasil;
    }
     
     public void setHasil(String Hasil) {
        this.Hasil = Hasil;
    }
     
     public String getStatus() {
        return Status;
    }
     
     public void setStatus(String Status) {
        this.Status = Status;
    }
     
     public String getKeterangan_Obat_Rekam_Medis() {
        return Keterangan_Obat_Rekam_Medis;
    }
     
     public void setKeterangan_Obat_Rekam_Medis(String Keterangan_Obat_Rekam_Medis) {
        this.Keterangan_Obat_Rekam_Medis = Keterangan_Obat_Rekam_Medis;
    }
     
     public String getRujukan_Dokter() {
        return Rujukan_Dokter;
    }
     
     public void setRujukan_Dokter(String Rujukan_Dokter) {
        this.Rujukan_Dokter = Rujukan_Dokter;
    }
     
     public String getTindakan_Dokter_Rekam_Medis() {
        return Tindakan_Dokter_Rekam_Medis;
    }
     
     public void setTindakan_Dokter_Rekam_Medis(String Tindakan_Dokter_Rekam_Medis) {
        this.Tindakan_Dokter_Rekam_Medis = Tindakan_Dokter_Rekam_Medis;
    }
}
