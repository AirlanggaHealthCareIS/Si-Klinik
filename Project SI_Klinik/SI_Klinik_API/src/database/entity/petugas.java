/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class petugas implements Serializable{
    private String Id_Petugas;
    private String Nama_Petugas;
    private String Jabatan;
    private String Alamat;
    private String Telepon;
    private String TanggalLahir;
    private String JenKel;
    private String Agama;
    private String Password;
            

    public String getId_Petugas() {
        return Id_Petugas;
    }

    public void setId_Petugas(String Id_Petugas) {
        this.Id_Petugas = Id_Petugas;
    }

    public String getNama_Petugas() {
        return Nama_Petugas;
    }

    public void setNama_Petugas(String Nama_Petugas) {
        this.Nama_Petugas = Nama_Petugas;
    }

     public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }
    
    public String getAlamat() {
        return Alamat;
    }
    
    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }
    
     public String getTelepon() {
        return Telepon;
    }

    public void setTanggalLahir(String TanggalLahir) {
        this.TanggalLahir = TanggalLahir;
    }
    
     public String getTanggalLahir() {
        return TanggalLahir;
    }

     public void setJenKel(String JenKel) {
        this.JenKel = JenKel;
    }
    
     public String getJenKel() {
        return JenKel;
    }
     
     public void setAgama(String Agama) {
        this.Agama = Agama;
    }
    
     public String getAgama() {
        return Agama;
    }
     
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
     public String getPassword() {
        return Password;
    }
}
