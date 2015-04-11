/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class detail_resep_obat implements Serializable{
    private String id_detail_resep;
    private String id_rekam_medis;
    private String id_obat;
    private int qty_detail_resep;
    
    
    public String getid_detail_resep() {
        return id_detail_resep;
    }

    public void setid_detail_resep(String id_detail_resep) {
        this.id_detail_resep = id_detail_resep;
    }
    
    public String getid_rekam_medis() {
        return id_rekam_medis;
    }

    public void setid_rekam_medis(String id_rekam_medis) {
        this.id_rekam_medis = id_rekam_medis;
    }
    
    public String getid_obat() {
        return id_obat;
    }

    public void setid_obat(String id_obat) {
        this.id_obat = id_obat;
    }
    
    public int getqty_detail_resep() {
        return qty_detail_resep;
    }

    public void setqty_detail_resep(int qty_detail_resep) {
        this.qty_detail_resep = qty_detail_resep;
    }   
        
    }
