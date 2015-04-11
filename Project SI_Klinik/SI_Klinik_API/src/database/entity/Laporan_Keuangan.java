/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Windows 8.1
 */
public class Laporan_Keuangan implements Serializable{
    String periode;
    String keterangan;
    String ref;
    int pemasukan;
    int pengeluaran;
    int saldo;
    
    public void setPeriode(String periode){
        this.periode = periode;
    }
    
    public String getPeriode(){
        return periode;
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
        this.pemasukan = pemasukan;
    }
    
    public int getPengeluaran(){
        return pemasukan;
    }
    
    public void setSaldo (int saldo){
        this.pemasukan = pemasukan;
    }
    
    public int getSaldo(){
        return pemasukan;
    }
}
