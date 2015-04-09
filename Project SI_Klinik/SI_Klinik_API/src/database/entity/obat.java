/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Administrator
 */
public class obat {
     private String id_obat;
    private String nama_obat;
    private float dosis;
    private String keterangan_obat;
    private int stock_obat;
    private String pabrik_obat;
    private String jenis_obat;
    private String kemasan;
    private int harga_obat;
    
    public String getID_obat() {
        return id_obat;
    }
    public void setID_obat(String id_obat) {
        this.id_obat = id_obat;
    }
    public String getNama_obat() {
        return nama_obat;
    }
    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
    public float getDosis() {
        return dosis;
    }
    public void setDosis(float dosis) {
        this.dosis = dosis;
    }
    public String getKeterangan_obat() {
        return keterangan_obat;
    }
    public void setKeterangan_obat(String keterangan_obat) {
        this.keterangan_obat = keterangan_obat;
    }
    public int getStock_obat() {
        return stock_obat;
    }
    public void setStock_obat(int stock_obat) {
        this.stock_obat = stock_obat;
    }
    public String getPabrik_obat() {
        return pabrik_obat;
    }
    public void setPabrik_obat(String pabrik_obat) {
        this.pabrik_obat = pabrik_obat;
    }
    public String getJenis_obatt() {
        return jenis_obat;
    }
    public void setJenis_obat(String jenis_obat) {
        this.jenis_obat = jenis_obat;
    }
    public String getKemasan() {
        return kemasan;
    }
    public void setKemasan(String kemasan) {
        this.kemasan = kemasan;
    }
    public int getHarga_obat() {
        return harga_obat;
    }
    public void setHarga_obat(int harga_obat) {
        this.harga_obat = harga_obat;
    }
}
