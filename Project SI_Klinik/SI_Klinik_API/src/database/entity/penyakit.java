/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Administrator
 */
public class penyakit {
    private String id_penyakit;
    private String nama_penyakit;
  
    public String getID_penyakit() {
        return id_penyakit;
    }
    public void setID_penyakit(String id_penyakit) {
        this.id_penyakit= id_penyakit;
    }
    public String getNama_penyakit() {
        return nama_penyakit;
    }
    public void setNama_penyakit(String nama_penyakit) {
        this.nama_penyakit= nama_penyakit;
    }
}
