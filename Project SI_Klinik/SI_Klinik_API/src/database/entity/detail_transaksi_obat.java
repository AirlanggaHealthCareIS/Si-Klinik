/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class detail_transaksi_obat implements Serializable{
    private String id_detail_obat;
    private String id_transaksi_obat;
    private String id_obat;
    private int qty_detail_transaksi;
    
    
    public String getid_detail_obat() {
        return id_detail_obat;
    }

    public void setid_detail_obat(String id_detail_obat) {
        this.id_detail_obat = id_detail_obat;
    }
    
    public String getidtransaksi_obat() {
        return id_transaksi_obat;
    }

    public void setid_transaksi_obat(String id_transaksi_obat) {
        this.id_transaksi_obat = id_transaksi_obat;
    }
    
    public String getid_obat() {
        return id_obat;
    }

    public void setid_obat(String id_obat) {
        this.id_obat = id_obat;
    }
    
    public int getqty_detail_transaksi() {
        return qty_detail_transaksi;
    }

    public void setqty_detail_transaksi(int qty_detail_transaksi) {
        this.qty_detail_transaksi = qty_detail_transaksi;
    }
    
}
