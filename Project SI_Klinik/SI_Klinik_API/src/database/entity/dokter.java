/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class dokter implements Serializable{
    private String id_dokter;
    private String id_poli;
    private String nama_dokter;
    private String alamat_dokter;
    private String tgl_lahir_dokter;
    private String telepon_dokter;
    private String jenis_kelamin_dokter;
    private String agama_dokter;
    private String password_dokter;
    private String no_ijin;
    private int tarif_dokter;
    
    
    public String getid_dokter() {
        return id_dokter;
    }

    public void setid_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }
    
    public String getid_poli() {
        return id_poli;
    }

    public void setid_poli(String id_poli) {
        this.id_poli = id_poli;
    }
    
    public String getnama_dokter() {
        return nama_dokter;
    }

    public void setnama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }
    
    public String getalamat_dokter() {
        return alamat_dokter;
    }

    public void setalamat_dokter(String alamat_dokter) {
        this.alamat_dokter = alamat_dokter;
    }
    public String gettgl_lahir_dokter() {
        return tgl_lahir_dokter;
    }

    public void settgl_lahir_dokter(String tgl_lahir_dokter) {
        this.tgl_lahir_dokter = tgl_lahir_dokter;
    }
    
    public String gettelepon_dokter() {
        return telepon_dokter;
    }

    public void settelepon_dokter(String telepon_dokter) {
        this.telepon_dokter = telepon_dokter;
    }
    
    public String getjenis_kelamin_dokter() {
        return jenis_kelamin_dokter;
    }

    public void setjenis_kelamin_dokter(String jenis_kelamin_dokter) {
        this.jenis_kelamin_dokter = jenis_kelamin_dokter;
    }
    
    public String getagama_dokter() {
        return agama_dokter;
    }

    public void setagama_dokter(String agama_dokter) {
        this.agama_dokter = agama_dokter;
    }
    
    public String getpassword_dokter() {
        return password_dokter;
    }

    public void setpassword_dokter(String password_dokter) {
        this.password_dokter = password_dokter;
    }
    
    public String getno_ijin() {
        return no_ijin;
    }

    public void setno_ijin(String no_ijin) {
        this.no_ijin = no_ijin;
    }
    
    public int gettarif_dokter() {
        return tarif_dokter;
    }

    public void settarif_dokter(int tarif_dokter) {
        this.tarif_dokter = tarif_dokter;
    }
}
