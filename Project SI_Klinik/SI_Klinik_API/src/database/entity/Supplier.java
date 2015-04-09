/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Supplier implements Serializable{
    private String Id_Supplier;
    private String Nama_Supplier;
    private String Kota_Supplier;
    private String Telepon_Supplier;
    private String NPWP_Supplier;
    private String Jenis_pajak_Supplier;
    private String Kode_Pajak_Supplier;
    
            

    public String getId_Supplier() {
        return Id_Supplier;
    }

    public void setId_Supplier(String Id_Supplier) {
        this.Id_Supplier = Id_Supplier;
    }

    public String getNama_Supplier() {
        return Nama_Supplier;
    }

    public void setNama_Supplier(String Nama_Supplier) {
        this.Nama_Supplier = Nama_Supplier;
    }

     public String getKota_Supplier() {
        return Kota_Supplier;
    }

    public void setKota_Supplier(String Kota_Supplier) {
        this.Kota_Supplier = Kota_Supplier;
    }
    
     public String getTelepon_Supplier() {
        return Telepon_Supplier;
    }

    public void setTelepon_Supplier(String Telepon_Supplier) {
        this.Telepon_Supplier = Telepon_Supplier;
    }
    
     public String getNPWP_Supplier() {
        return NPWP_Supplier;
    }

    public void setNPWP_Supplier(String NPWP_Supplier) {
        this.NPWP_Supplier = NPWP_Supplier;
    }
    
     public String getJenis_pajak_Supplier() {
        return Jenis_pajak_Supplier;
    }

     public void setJenis_pajak_Supplier(String Jenis_pajak_Supplier) {
        this.Jenis_pajak_Supplier = Jenis_pajak_Supplier;
    }
    
     public String getKode_Pajak_Supplier() {
        return Kode_Pajak_Supplier;
    }
     
     public void setKode_Pajak_Supplier(String Kode_Pajak_Supplier) {
        this.Kode_Pajak_Supplier = Kode_Pajak_Supplier;
    }
}