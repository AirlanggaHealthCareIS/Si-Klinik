/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

/**
 *
 * @author Acer
 */
public class jadwal {
    private String id_jadwal;
    private String id_dokter;
    private String hari;
    private String jam;
    private String id_poli;
      
    
    public String getid_jadwal() {
        return id_jadwal;
    }

    public void setid_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getid_dokter() {
        return id_dokter;
    }

    public void setid_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }

     public String gethari() {
        return hari;
    }

    public void sethari(String hari) {
        this.hari = hari;
    }
    
     public String getjam() {
        return jam;
    }

    public void setjam(String jam) {
        this.jam = jam;
    }
    
    public String getid_poli() {
        return id_poli;
    }

    public void setid_poli(String a) {
        this.id_poli=a ;
    }
    
    
}
