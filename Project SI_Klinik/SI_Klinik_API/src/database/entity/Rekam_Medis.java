/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Rekam_Medis implements Serializable{
    private String Id_Rekam_Medis;
    private String Id_Dokter;
    private String Id_Pasien;
    private String Tanggal_Rekam_Medis;
    private String Nama_Dokter;
    private String Alergi_Obat;
    private String Riwayat_Sekarang;
    private String Riwayat_Dahulu;
    private String Riwayat_Keluarga;
    private String Keterangan_Pekerjaan;
    private String Kebiasaan;
    private String Keadaan_Umum;
    private int gcs;
    private String Kesadaran;
    private String Tensi;
    private int Nadi;
    private int RR;
    private int Temperature;
    private String Pemeriksaan_Lain;
    private String TPL;
    private String Rujukan_Dokter;
    private List<detail_Assessment>list;
    
            
    public String getId_Rekam_Medis() {
        return Id_Rekam_Medis;
    }

    public void setId_Rekam_Medis(String Id_Rekam_Medis) {
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
    
     public String getRujukan_Dokter() {
        return Rujukan_Dokter;
    }
     
     public void setRujukan_Dokter(String Rujukan_Dokter) {
        this.Rujukan_Dokter = Rujukan_Dokter;
    }
     
     public String getNama_Dokter() {
        return Nama_Dokter;
    }
     
     public void setNama_Dokter(String Nama_Dokter) {
        this.Nama_Dokter = Nama_Dokter;
    }
     
      public String getRiwayat_Sekarang() {
        return Riwayat_Sekarang;
    }
     
     public void setRiwayat_Sekarang(String Riwayat_Sekarang) {
        this.Riwayat_Sekarang = Riwayat_Sekarang;
    }
       public String getRiwayat_Dahulu() {
        return Riwayat_Dahulu;
    }
     
     public void setRiwayat_Dahulu(String Riwayat_Dahulu) {
        this.Riwayat_Dahulu = Riwayat_Dahulu;
    }
     
     public String getRiwayat_Keluarga() {
        return Riwayat_Keluarga;
    }
     
     public void setRiwayat_Keluarga(String Riwayat_Keluarga) {
        this.Riwayat_Keluarga = Riwayat_Keluarga;
    }
     
      public String getKeterangan_Pekerjaan() {
        return Keterangan_Pekerjaan;
    }
     
     public void setKeterangan_Pekerjaan(String Keterangan_Pekerjaan) {
        this.Keterangan_Pekerjaan = Keterangan_Pekerjaan;
    }
     
     public String getKebiasaan() {
        return Kebiasaan;
    }
     
     public void setKebiasaan(String Kebiasaan) {
        this.Kebiasaan= Kebiasaan;
    }
     
    public String getKeadaanUmum() {
        return Keadaan_Umum;
    }
     
     public void setKeadaanUmum(String Keadaan_Umum) {
        this.Keadaan_Umum= Keadaan_Umum;
    }
     public String getKesadaran() {
        return Kesadaran;
    }
     
     public void setKesadaran(String Kesadaran) {
        this.Kesadaran= Kesadaran;
    }
     
      public String getTensi() {
        return Tensi;
    }
     
     public void setTensi(String Tensi) {
        this.Tensi= Tensi;
    }
     
      public String getPemeriksaan_Lain() {
        return Pemeriksaan_Lain;
    }
     
     public void setPemeriksaan_Lain(String Pemeriksaan_Lain) {
        this.Pemeriksaan_Lain= Pemeriksaan_Lain;
    }
     
     public String getTPL() {
        return TPL;
    }
     
     public void setTPL(String TPL) {
        this.TPL= TPL;
    }
     
      public int getGCS() {
        return gcs;
    }
     
     public void setGCS(int gcs) {
        this.gcs= gcs;
    }
     
     public int getNadi() {
        return Nadi;
    }
     
     public void setNadi(int Nadi) {
        this.Nadi= Nadi;
    }
     
     public int getRR() {
        return RR;
    }
     
     public void setRR(int RR) {
        this.RR=RR;
    }
     
     public int getTemperature() {
        return Temperature;
    }
     
     public void setTemperature(int Temperature) {
        this.Temperature=Temperature;
    }
     
     public List getAssessment(){
         return list;
     }
     
     public void setTemperature(List <detail_Assessment> list) {
        this.list = list;
    }
     
     public String getAssessments(){
         String assessment = "";
         for(int i=0; i<list.size();i++){
             if(i==0){
                assessment = assessment+list.get(i);
             }
             else{
                assessment = assessment+"; "+list.get(i);
             }             
         }
         return assessment;
     }
}

