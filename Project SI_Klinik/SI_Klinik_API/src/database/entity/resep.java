/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;

/**
 *
 * @author tinot
 */
public class resep implements Serializable{
    private String kode_obat;
    private String nama_obat;
    private int qty;
    
    public String getkode_obat() {
        return kode_obat;
    }

    public void setkode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }
    
    public String getnama_obat() {
        return nama_obat;
    }

    public void setnama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
    
    public int getqty() {
        return qty;
    }

    public void setqty(int qty) {
        this.qty = qty;
    }
}
