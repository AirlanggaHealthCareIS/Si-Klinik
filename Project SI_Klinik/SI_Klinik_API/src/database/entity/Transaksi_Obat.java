/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Transaksi_Obat implements Serializable{
    private String Id_Transaksi_Obat;
    private String Id_Pemasukan;
    private String Tanggal_Jual;
    private String Subtotal_Transaksi_Obat;
    private String PPN_Transaksi_Obat;
    private String Total_Transaksi_Obat;
    
            

    public String getId_Transaksi_Obat() {
        return Id_Transaksi_Obat;
    }

    public void setId_Transaksi_Obat(String Id_Transaksi_Obat) {
        this.Id_Transaksi_Obat = Id_Transaksi_Obat;
    }

    public String getId_Pemasukan() {
        return Id_Pemasukan;
    }

    public void setId_Pemasukan(String Id_Pemasukan) {
        this.Id_Pemasukan = Id_Pemasukan;
    }

     public String getTanggal_Jual() {
        return Tanggal_Jual;
    }

    public void setTanggal_Jual(String Tanggal_Jual) {
        this.Tanggal_Jual = Tanggal_Jual;
    }
    
     public String getSubtotal_Transaksi_Obat() {
        return Subtotal_Transaksi_Obat;
    }

    public void setSubtotal_Transaksi_Obat(String Subtotal_Transaksi_Obat) {
        this.Subtotal_Transaksi_Obat = Subtotal_Transaksi_Obat;
    }
    
     public String getPPN_Transaksi_Obat() {
        return PPN_Transaksi_Obat;
    }

    public void setPPN_Transaksi_Obat(String PPN_Transaksi_Obat) {
        this.PPN_Transaksi_Obat = PPN_Transaksi_Obat;
    }
    
     public String getTotal_Transaksi_Obat() {
        return Total_Transaksi_Obat;
    }

     public void setTotal_Transaksi_Obat(String Total_Transaksi_Obat) {
        this.Total_Transaksi_Obat = Total_Transaksi_Obat;
    }   
}
