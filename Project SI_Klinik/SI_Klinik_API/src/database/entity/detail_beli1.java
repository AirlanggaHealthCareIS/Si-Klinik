/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Acer
 */
public class detail_beli1 {
    private String id_obat;
    private String nama_obat;
    private String id_beli;
    private int qty_pesan;
    private int qty_datang;
    
    
    public String getnama_obat() {
        return nama_obat;
    }

    public void setnama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
    
    public String getid_obat() {
        return id_obat;
    }

    public void setid_obat(String id_obat) {
        this.id_obat = id_obat;
    }
    
    public String getid_beli() {
        return id_beli;
    }

    public void setid_beli(String id_beli) {
        this.id_beli = id_beli;
    }
    
    public int getqtypesan() {
        return qty_pesan;
    }

    public void setqtypesan(int qty_pesan) {
        this.qty_pesan = qty_pesan;
    }   
    
     public int getqtydatang() {
        return qty_datang;
    }

    public void setqtydatang(int qty_datang) {
        this.qty_datang = qty_datang;
    }       
}
  

