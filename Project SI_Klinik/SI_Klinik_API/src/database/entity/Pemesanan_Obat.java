/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.util.List;

/**
 *
 * @author asus
 */
public class Pemesanan_Obat {
    private List <detil_pesan_obat> list;
    private String id_pemesanan_obat;
    private String id_supplier;
    private String tgl_pemesanan;
    
    
    public void setId_Pemesnan_obat(String a){
        id_pemesanan_obat = a;
    }
    public String getId_Pemesanan_obat(){
        return id_pemesanan_obat;
    }
    public void setTgl_Pemesanan(String a){ 
        tgl_pemesanan = a;
    }
    public String getTgl_Pemesanan(){
        return tgl_pemesanan;
    }
    public void setId_supplier(String a){
        id_supplier = a;
    }
    public String getId_supplier(){
        return id_supplier;
    }
    public void setList (List<detil_pesan_obat> a){
        list = a;
    }
    public List getList(){
        return list;
    }
}
