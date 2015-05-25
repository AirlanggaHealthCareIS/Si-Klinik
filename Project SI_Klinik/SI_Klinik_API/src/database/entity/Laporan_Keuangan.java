/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.entity;

import java.io.Serializable;

/**
 *
 * @author Windows 8.1
 */
public class Laporan_Keuangan implements Serializable{
    String id;
    String tanggal;
    String keterangan;
    String ref;
    int pemasukan;
    int pengeluaran;
    int saldo;
    int flag;
    
    public void setId (String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setTanggal (String tanggal){
        this.tanggal = tanggal;
    }
    
    public String getTanggal(){
        return tanggal;
    }
    
    public void setKeterangan (String keterangan){
        this.keterangan = keterangan;
    }
    
    public String getKeterangan(){
        return keterangan;
    }
    
    public void setRef (String ref){
        this.ref = ref;
    }
    
    public String getRef () {
        return ref;
    }
    
    public void setPemasukan (int pemasukan){
        this.pemasukan = pemasukan;
    }
    
    public int getPemasukan(){
        return pemasukan;
    }
    
    public void setPengeluaran (int pengeluaran){
        this.pengeluaran = pengeluaran;
    }
    
    public int getPengeluaran(){
        return pengeluaran;
    }
    
    public void setSaldo (int saldo){
        this.saldo = saldo;
    }
    
    public int getSaldo(){
        return saldo;
    }
    public void setFlag (int flag){
        this.flag = flag;
    }
    
    public int getFlag(){
        return flag;
    }
}
