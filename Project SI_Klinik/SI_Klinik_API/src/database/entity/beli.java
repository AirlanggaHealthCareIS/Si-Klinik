/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Acer
 */
public class beli {
    private String id_beli;
    private String id_supplier;
    private String id_pengeluaran;
    private String tanggal_beli;
    private int sub_total;
    private float ppn_beli;
    private int total_beli;
    
    
    public String getid__beli() {
        return id_beli;
    }

    public void setid_beli(String id_beli) {
        this.id_beli = id_beli;
    }

    public String getid_supplier() {
        return id_supplier;
    }

    public void setid_supplier(String id_supplier) {
        this.id_supplier = id_supplier;
    }

     public String getid_pengeluaran() {
        return id_pengeluaran;
    }

    public void setid_pengeluaran(String id_pengeluaran) {
        this.id_pengeluaran = id_pengeluaran;
    }
    
     public String gettanggal_beli() {
        return tanggal_beli;
    }

    public void settanggal_beli(String tanggal_beli) {
        this.tanggal_beli = tanggal_beli;
    }
    
     public int getsub_total() {
        return sub_total;
    }

    public void setsub_total(int sub_total) {
        this.sub_total = sub_total;
    }
    
     public float getppn_beli() {
        return ppn_beli;
    }

     public void setppn_beli(float ppn_beli) {
        this.ppn_beli = ppn_beli;
    }
    
     public int gettotal_beli() {
        return total_beli;
    }

}
