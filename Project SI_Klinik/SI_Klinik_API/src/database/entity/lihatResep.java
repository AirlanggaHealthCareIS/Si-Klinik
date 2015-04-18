/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author tinot
 */
public class lihatResep implements Serializable{
    private int Id_Pasien;
    private String Id_rekam_medik;
    private String Id_resep;
    private String Tanggal;
    
    public int getId_Pasien() {
        return Id_Pasien;
    }

    public void setId_Pasien(int Id_Pasien) {
        this.Id_Pasien = Id_Pasien;
    }

    public String getId_rekam_medik() {
        return Id_rekam_medik;
    }

    public void setId_rekam_medik(String Id_rekam_medik) {
        this.Id_rekam_medik = Id_rekam_medik;
    }
    
    public String getId_resep() {
        return Id_resep;
    }
    
    public void setId_resep(String Id_resep) {
        this.Id_resep = Id_resep;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }
}
