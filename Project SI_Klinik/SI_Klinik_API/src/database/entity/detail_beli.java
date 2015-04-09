/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Acer
 */
public class detail_beli {
    private String id_detail_beli;
    private String id_obat;
    private String id_beli;
    private int qty_detail_beli;
    
    
    public String getid_detail_beli() {
        return id_detail_beli;
    }

    public void setid_detail_beli(String id_detail_beli) {
        this.id_detail_beli = id_detail_beli;
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
    
    public int getqty_detail_beli() {
        return qty_detail_beli;
    }

    public void setqty_detail_beli(int qty_detail_beli) {
        this.qty_detail_beli = qty_detail_beli;
    }   
        
    }
  

