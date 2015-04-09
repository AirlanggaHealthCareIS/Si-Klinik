/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Tindakan_Dokter implements Serializable{
    private String Id_Tindakan_Dokter;
    private String Tindakan_Dokter;
    private String Biaya_Tindakan_Dokter;
    
    
            

    public String getId_Tindakan_Dokter() {
        return Id_Tindakan_Dokter;
    }

    public void setId_Tindakan_Dokter(String Id_Tindakan_Dokter) {
        this.Id_Tindakan_Dokter = Id_Tindakan_Dokter;
    }

    public String getTindakan_Dokter() {
        return Tindakan_Dokter;
    }

    public void setTindakan_Dokter(String Tindakan_Dokter) {
        this.Tindakan_Dokter = Tindakan_Dokter;
    }

     public String getBiaya_Tindakan_Dokter() {
        return Biaya_Tindakan_Dokter;
    }

    public void setBiaya_Tindakan_Dokter(String Biaya_Tindakan_Dokter) {
        this.Biaya_Tindakan_Dokter = Biaya_Tindakan_Dokter;
    }   
}
