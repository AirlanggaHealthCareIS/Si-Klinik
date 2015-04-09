/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Pemasukan implements Serializable{
    private String Id_Pemasukan;
    private String Tanggal_Pemasukan;
    
            

    public String getId_Pemasukan() {
        return Id_Pemasukan;
    }

    public void setId_Pemasukan(String Id_Pemasukan) {
        this.Id_Pemasukan = Id_Pemasukan;
    }

    public String getTanggal_Pemasukan() {
        return Tanggal_Pemasukan;
    }

    public void setTanggal_Pemasukan(String Tanggal_Pemasukan) {
        this.Tanggal_Pemasukan = Tanggal_Pemasukan;
    }
}
