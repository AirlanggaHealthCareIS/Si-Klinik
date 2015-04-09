/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class poliklinik implements Serializable{
    private String Id_Poli;
    private String Nama_Poli;
    
            

    public String getId_Poli() {
        return Id_Poli;
    }

    public void setId_Poli(String Id_Poli) {
        this.Id_Poli = Id_Poli;
    }

    public String getNama_Poli() {
        return Nama_Poli;
    }

    public void setNama_Petugas(String Nama_Poli) {
        this.Nama_Poli = Nama_Poli;
    }
}

