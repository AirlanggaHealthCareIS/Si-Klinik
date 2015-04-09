/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Administrator
 */
public class pasien {
     private String id_pasien;
    private String nama_pasien;
    private String alamat;
    private String jenis_kelamin;
    private String tgl_lahir;
    private String no_telepon;
    private String umur;
    private String agama;
    private String pekerjaan;
    private String tempat_lahir;
    private String no_bpjs_pasien;
    private String gol_darah;
    
    public String getID_pasien() {
        return id_pasien;
    }
    public void setID_pasien(String id_pasien) {
        this.id_pasien= id_pasien;
    }
    public String getNama_pasien() {
        return nama_pasien;
    }
    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien= nama_pasien;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat= alamat;
    }
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin= jenis_kelamin;
    }
    public String getTgl_lahir() {
        return tgl_lahir;
    }
    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir= tgl_lahir;
    }
    public String getNo_telepon() {
        return no_telepon;
    }
    public void setNo_telepon(String no_telepon) {
        this.no_telepon= no_telepon;
    }
    public String getUmur() {
        return umur;
    }
    public void setUmur(String umur) {
        this.umur= umur;
    }
    public String getAgama() {
        return agama;
    }
    public void setAgama(String agama) {
        this.agama= agama;
    }
    public String getPekerjaan() {
        return pekerjaan;
    }
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan= pekerjaan;
    }
    public String getTempat_lahir() {
        return tempat_lahir;
    }
    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir= tempat_lahir;
    }
    public String getNo_bpjs_pasien() {
        return no_bpjs_pasien;
    }
    public void setNo_bpjs_pasien(String no_bpjs_pasien) {
        this.no_bpjs_pasien= no_bpjs_pasien;
    }
}
