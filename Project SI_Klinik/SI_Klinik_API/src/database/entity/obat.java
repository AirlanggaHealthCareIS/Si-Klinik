/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class obat implements Serializable{ 
    private String id_obat;
    private String id_supplier;
    private String nama_obat;
    private float dosis;
    private String keterangan_obat;
    private int stok_obat;
    private int stok_kritis;
    private String pabrik_obat;
    private String jenis_obat;
    private String kemasan;
    private String NamaSupplier;
    private int harga_obat;
            

    public String getid_obat() {
        return id_obat;
    }

    public void setid_obat(String id_obat) {
        this.id_obat = id_obat;
    }
    public void setnama_supplier(String n){
        this.NamaSupplier = n;
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
     public String getNamaSupplier(){
         return NamaSupplier;
     }

      public String getIdSupplier(){
         return id_supplier;
     }
      public void setIdSupplier(String n){
          this.id_supplier = n;
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
    
     public int getstok_obat() {
        return stok_obat;
    }

    public void setstok_obat(int stok_obat) {
        this.stok_obat = stok_obat;
    }
      public int getstok_kritis() {
        return stok_kritis;
    }

    public void setstok_kritis(int stok_kritis) {
        this.stok_kritis = stok_kritis;
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
