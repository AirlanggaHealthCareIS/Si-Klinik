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
            

    public String getid_obat() {
        return id_obat;
    }

    public void setid_obat(String id_obat) {
        this.id_obat = id_obat;
    }

    public String getnama_obat() {
        return nama_obat;
    }

    public void setnama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

     public float getdosis() {
        return dosis;
    }

    public void setdosis(float dosis) {
        this.dosis = dosis;
    }
    
     public String getketerangan_obat() {
        return keterangan_obat;
    }

    public void setketerangan_obat(String keterangan_obat) {
        this.keterangan_obat = keterangan_obat;
    }
    
     public int getstock_obat() {
        return stock_obat;
    }

    public void setstock_obat(int stock_obat) {
        this.stock_obat = stock_obat;
    }
    
     public String getpabrik_obat() {
        return pabrik_obat;
    }

     public void setpabrik_obat(String pabrik_obat) {
        this.pabrik_obat = pabrik_obat;
    }
    
     public String getjenis_obat() {
        return jenis_obat;
    }
     
     public void setjenis_obat(String jenis_obat) {
        this.jenis_obat = jenis_obat;
    }
    
     public String getkemasan() {
        return kemasan;
    }
     
    public void setkemasan(String kemasan) {
        this.kemasan = kemasan;
    }
    
     public int getharga_obat() {
        return harga_obat;
    }
     public void setharga_obat (int harga_obat){
         this.harga_obat = harga_obat;
     }
}
