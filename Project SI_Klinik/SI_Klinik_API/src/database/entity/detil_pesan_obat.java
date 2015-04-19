/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author asus
 */
public class detil_pesan_obat {
    private String id_pemesanan_obat;
    private String id_obat;
    private int jumlah_pesan;
    private int status;
    
    public  void setId_Pemesanan_obat(String a){
        id_pemesanan_obat = a;
    }
    public String getId_Pemesanan_obat(){
        return id_pemesanan_obat;
    }
    public void setStatus(int a){
        status =a;
    }
    public int getStatus(){
        return status;
    }
    public void setId_obat(String a){
        id_obat = a;
    }
    public String getId_obat(){
        return id_obat;
    }
    
    public void setJumlah_pesan(int a){
        jumlah_pesan = a;
    }
    
    public int getJumlah_Pesan(){
        return jumlah_pesan;
    }
}
