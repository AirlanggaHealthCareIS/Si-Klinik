/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Transaksi_Periksa implements Serializable{
    private String Id_Transaksi_Periksa;
    private String Id_Dokter;
    private String Id_Pemasukan;
    private String Id_Pasien;
    private String Subtotal_Transaksi_Periksa;
    private String PPN_Transaksi_Periksa;
    private String Total_Transaksi_Periksa;
    private String Klaim_BPJS;
    private String No_Kartu_Transaksi;
    private String Tanggal_Transaksi_Periksa;
    
            

    public String getId_Transaksi_Periksa() {
        return Id_Transaksi_Periksa;
    }

    public void setId_Transaksi_Periksa(String Id_Transaksi_Periksa) {
        this.Id_Transaksi_Periksa = Id_Transaksi_Periksa;
    }

    public String getId_Dokter() {
        return Id_Dokter;
    }

    public void setId_Dokter(String Id_Dokter) {
        this.Id_Dokter = Id_Dokter;
    }

     public String getId_Pemasukan() {
        return Id_Pemasukan;
    }

    public void setId_Pemasukan(String Id_Pemasukan) {
        this.Id_Pemasukan = Id_Pemasukan;
    }
    
     public String getId_Pasien() {
        return Id_Pasien;
    }

    public void setId_Pasien(String Id_Pasien) {
        this.Id_Pasien = Id_Pasien;
    }
    
     public String getSubtotal_Transaksi_Periksa() {
        return Subtotal_Transaksi_Periksa;
    }

    public void setSubtotal_Transaksi_Periksa(String Subtotal_Transaksi_Periksa) {
        this.Subtotal_Transaksi_Periksa = Subtotal_Transaksi_Periksa;
    }
    
     public String getPPN_Transaksi_Periksa() {
        return PPN_Transaksi_Periksa;
    }

     public void setPPN_Transaksi_Periksa(String PPN_Transaksi_Periksa) {
        this.PPN_Transaksi_Periksa = PPN_Transaksi_Periksa;
    }
    
     public String getTotal_Transaksi_Periksa() {
        return Total_Transaksi_Periksa;
    }
     
     public void setTotal_Transaksi_Periksa(String Total_Transaksi_Periksa) {
        this.Total_Transaksi_Periksa = Total_Transaksi_Periksa;
    }
     
     public String getKlaim_BPJS() {
        return Klaim_BPJS;
    }
     
     public void setKlaim_BPJS(String Klaim_BPJS) {
        this.Klaim_BPJS = Klaim_BPJS;
    }
     
    public String getNo_Kartu_Transaksi() {
        return No_Kartu_Transaksi;
    }
     
     public void setNo_Kartu_Transaksi(String No_Kartu_Transaksi) {
        this.No_Kartu_Transaksi = No_Kartu_Transaksi;
    }
     
     public String getTanggal_Transaksi_Periksa() {
        return Tanggal_Transaksi_Periksa;
    }
     
     public void setTanggal_Transaksi_Periksa(String Tanggal_Transaksi_Periksa) {
        this.Tanggal_Transaksi_Periksa = Tanggal_Transaksi_Periksa;
    }     
}
