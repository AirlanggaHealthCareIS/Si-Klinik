/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Tindakan_Periksa implements Serializable{
    private String Id_Tindakan_Periksa;
    private String Id_Dokter;
    private String Id_Pemasukan;
    private String Id_Pasien;
    private int Subtotal_Transaksi;
    private float PPN_Transaksi_Periksa;
    private int Total_Transaksi_Periksa;
    private String Klaim_BPJS;
    private String Nomor_Kartu_Transaksi;
    private String Tanggal_transaksi_Periksa;
    
    
            

    public String getId_Tindakan_Periksa() {
        return Id_Tindakan_Periksa;
    }

    public void setId_Tindakan_Periksa(String Id_Tindakan_Dokter) {
        this.Id_Tindakan_Periksa = Id_Tindakan_Periksa;
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

    public int getSubtotal_Transaksi() {
        return Subtotal_Transaksi;
    }

    public void setSubtotal_Transaksi(int Id_Pasien) {
        this.Subtotal_Transaksi = Subtotal_Transaksi;
    }  
    
    public float getPPN_Transaksi_Periksa() {
        return PPN_Transaksi_Periksa;
    }

    public void setPPN_Transaksi_Periksa(float PPN_Transaksi_Periksa) {
        this.PPN_Transaksi_Periksa = PPN_Transaksi_Periksa;
    }  
    public int getTotal_Transaksi_Periksa() {
        return Total_Transaksi_Periksa;
    }

    public void setTotal_Transaksi_Periksa(int Total_Transaksi_Periksa) {
        this.Total_Transaksi_Periksa = Total_Transaksi_Periksa;
    }  
    
    public String getKlaim_BPJS() {
        return Klaim_BPJS;
    }

    public void setKlaim_BPJS(String Klaim_BPJS) {
        this.Klaim_BPJS = Klaim_BPJS;
    }  
    
    public String getNomor_Kartu_Transaksi() {
        return Nomor_Kartu_Transaksi;
    }

    public void setNomor_Kartu_Transaksi(String Nomor_Kartu_Transaksi) {
        this.Nomor_Kartu_Transaksi = Nomor_Kartu_Transaksi;
    }
    
    public String getTanggal_transaksi_Periksa() {
        return Tanggal_transaksi_Periksa;
    }

    public void setTanggal_transaksi_Periksa(String Tanggal_transaksi_Periksa) {
        this.Tanggal_transaksi_Periksa = Tanggal_transaksi_Periksa;
    }  
}
