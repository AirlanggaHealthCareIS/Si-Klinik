/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Transaksi_Obat implements Serializable{
    private String Id_Transaksi_Obat;
    private String Tanggal_Jual;
    private int Subtotal_Transaksi_Obat;
    private float PPN_Transaksi_Obat;
    private int Total_Transaksi_Obat;
    
            

    public String getId_Transaksi_Obat() {
        return Id_Transaksi_Obat;
    }

    public void setId_Transaksi_Obat(String Id_Transaksi_Obat) {
        this.Id_Transaksi_Obat = Id_Transaksi_Obat;
    }
     public String getTanggal_Jual() {
        return Tanggal_Jual;
    }

    public void setTanggal_Jual(String Tanggal_Jual) {
        this.Tanggal_Jual = Tanggal_Jual;
    }
    
     public int getSubtotal_Transaksi_Obat() {
        return Subtotal_Transaksi_Obat;
    }

    public void setSubtotal_Transaksi_Obat(int Subtotal_Transaksi_Obat) {
        this.Subtotal_Transaksi_Obat = Subtotal_Transaksi_Obat;
    }
    
     public float getPPN_Transaksi_Obat() {
        return PPN_Transaksi_Obat;
    }

    public void setPPN_Transaksi_Obat(float PPN_Transaksi_Obat) {
        this.PPN_Transaksi_Obat = PPN_Transaksi_Obat;
    }
    
     public int getTotal_Transaksi_Obat() {
        return Total_Transaksi_Obat;
    }

     public void setTotal_Transaksi_Obat(int Total_Transaksi_Obat) {
        this.Total_Transaksi_Obat = Total_Transaksi_Obat;
    }   
}
