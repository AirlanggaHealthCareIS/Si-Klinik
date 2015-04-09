/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Pengeluaran implements Serializable{
    private String Id_Pengeluaran;
    private String Tanggal_Pengeluaran;
    
            

    public String getId_Pengeluaran() {
        return Id_Pengeluaran;
    }

    public void setId_Pengeluaran(String Id_Pengeluaran) {
        this.Id_Pengeluaran = Id_Pengeluaran;
    }

    public String getTanggal_Pengeluaran() {
        return Tanggal_Pengeluaran;
    }

    public void setTanggal_Pengeluaran(String Tanggal_Pengeluaran) {
        this.Tanggal_Pengeluaran = Tanggal_Pengeluaran;
    }
}
