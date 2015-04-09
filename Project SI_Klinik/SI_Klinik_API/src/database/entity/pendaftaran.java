/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Administrator
 */
public class pendaftaran {
    private String id_pendaftaran;
    private String id_petugas;
    private String id_dokter;
    private String id_pasien;
    private String id_poli;
    private String tgl_periksa;
    private String keluhan;
    
    public String getID_pendaftaran() {
        return id_pendaftaran;
    }
    public void setID_pendaftaran(String id_pendaftaran) {
        this.id_pendaftaran= id_pendaftaran;
    }
    public String getID_petugas() {
        return id_petugas;
    }
    public void setID_petugas(String id_petugas) {
        this.id_petugas= id_petugas;
    }
      public String getID_dokter() {
        return id_dokter;
    }
    public void setID_dokter(String id_pasien) {
        this.id_dokter= id_dokter;
    }
      public String getID_pasien() {
        return id_pasien;
    }
    public void setID_pasien(String id_pasien) {
        this.id_pasien= id_pasien;
    }
      public String getID_poli() {
        return id_poli;
    }
    public void setID_poli(String id_poli) {
        this.id_poli= id_poli;
    }
     public String getTgl_periksa() {
        return tgl_periksa;
    }
    public void setTgl_periksa(String tgl_periksa) {
        this.tgl_periksa= tgl_periksa;
    }
     public String getKeluhan() {
        return keluhan;
    }
    public void setKeluhan(String keluhan) {
        this.keluhan= keluhan;
    }

}
