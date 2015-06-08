/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.util.List;

/**
 *
 * @author Acer
 */
public class detail_beli {
    private String id_beli;
    private String id_supplier;
    private String nama_supplier;
    private String tanggal;
    private int subtotal;
    private int ppn_beli;
    private int total_beli;
    private String id_po;
    private List<detail_beli1> list;
    
    
    
    public String getid_beli() {
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
    
    public String getnama_supplier() {
        return nama_supplier;
    }

    public void setnama_supplier(String nama_supplier) {
        this.nama_supplier = nama_supplier;
    }
    
    public String gettanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }   
    
    public String getIDPO() {
        return id_po;
    }

    public void setIDPO(String idpo) {
        this.id_po = idpo;
    }  
    
    public int getsub() {
        return subtotal;
    }

    public void setsub(int sub) {
        this.subtotal = sub;
    }  
     public int getppn() {
        return ppn_beli;
    }

    public void setppn(int ppn) {
        this.ppn_beli = ppn;
    }  
    
     public int gettotal() {
        return total_beli;
    }

    public void settotal(int sub) {
        this.total_beli = sub;
    }  
        
    }
  

