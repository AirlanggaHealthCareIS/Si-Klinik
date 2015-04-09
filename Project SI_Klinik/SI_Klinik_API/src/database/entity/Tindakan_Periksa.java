/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Tindakan_Periksa implements Serializable{
    private String Id_Tindakan_Periksa;
    private String Id_Rekam_Medis;
    private String Id_Tindakan_Dokter;
    private String Id_Transaksi_Periksa;
    
    
            

    public String getId_Tindakan_Periksa() {
        return Id_Tindakan_Periksa;
    }

    public void setId_Tindakan_Periksa(String Id_Tindakan_Dokter) {
        this.Id_Tindakan_Periksa = Id_Tindakan_Periksa;
    }

    public String getId_Rekam_Medis() {
        return Id_Rekam_Medis;
    }

    public void setId_Rekam_Medis(String Id_Rekam_Medis) {
        this.Id_Rekam_Medis = Id_Rekam_Medis;
    }

     public String getId_Tindakan_Dokter() {
        return Id_Tindakan_Dokter;
    }

    public void setId_Tindakan_Dokter(String Id_Tindakan_Dokter) {
        this.Id_Tindakan_Dokter = Id_Tindakan_Dokter;
    }  
    
    public String getId_Transaksi_Periksa() {
        return Id_Transaksi_Periksa;
    }

    public void setId_Transaksi_Periksa(String Id_Transaksi_Periksa) {
        this.Id_Transaksi_Periksa = Id_Transaksi_Periksa;
    }  
}
