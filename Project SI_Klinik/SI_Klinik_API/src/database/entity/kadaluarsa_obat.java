/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Acer
 */
public class kadaluarsa_obat {
    private String id_kadaluarsa_obat;
    private String id_obat;
    private String tanggal_kadaluarsa_obat;
      
    
    public String getid_kadaluarsa_obat() {
        return id_kadaluarsa_obat;
    }

    public void setid_kadaluarsa_obat(String id_kadaluarsa_obat) {
        this.id_kadaluarsa_obat = id_kadaluarsa_obat;
    }

    public String getid_obat() {
        return id_obat;
    }

    public void setid_obat(String id_obat) {
        this.id_obat = id_obat;
    }

     public String gettanggal_kadaluarsa_obat() {
        return tanggal_kadaluarsa_obat;
    }

    public void settanggal_kadaluarsa_obat(String tanggal_kadaluarsa_obat) {
        this.tanggal_kadaluarsa_obat = tanggal_kadaluarsa_obat;
    }
}
