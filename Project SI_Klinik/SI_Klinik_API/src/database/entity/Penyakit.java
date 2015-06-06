/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Penyakit implements Serializable{
    private int Id_Penyakit;
    private String Nama_Penyakit;
    
            

    public int getId_Penyakit() {
        return Id_Penyakit;
    }

    public void setId_Penyakit(int Id_Penyakit) {
        this.Id_Penyakit = Id_Penyakit;
    }

    public String getNama_Penyakit() {
        return Nama_Penyakit;
    }

    public void setNama_Penyakit(String Nama_Penyakit) {
        this.Nama_Penyakit = Nama_Penyakit;
    }
}

