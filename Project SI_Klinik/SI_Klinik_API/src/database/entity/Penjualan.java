/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;
import java.io.Serializable;
import java.util.ArrayList;


public class Penjualan implements Serializable{
    private String Id_Obat;
    private String Nama_Obat;    
    private int Qty;
    private int Harga;
    private int Total;
    private String keterangan;
    private int Stok;
    
    public String getId_Obat() {
        return Id_Obat;
    }

    public void setId_Obat(String Id_Obat) {
        this.Id_Obat = Id_Obat;
    }

    public String getNama_Obat() {
        return Nama_Obat;
    }

    public void setNama_Obat(String Nama_Obat) {
        this.Nama_Obat = Nama_Obat;
    }
    
    public int getQty() {
        return Qty;
    }

    public void setQty(int Nomor) {
        this.Qty = Nomor;
    }
    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        this.Total = total;
    }
    
     public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        this.Harga= harga;
    }
    public int getStok() {
        return Stok;
    }

    public void setStok(int Stok) {
        this.Stok= Stok;
    }
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String ket) {
        this.keterangan = ket;
    }
}
