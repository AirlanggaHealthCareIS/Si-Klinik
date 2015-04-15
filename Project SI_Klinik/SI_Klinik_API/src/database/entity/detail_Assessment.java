/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import java.io.Serializable;

/**
 *
 * @author JESSICA
 */
public class detail_Assessment implements Serializable {
    private String Id_Rekam_Medis;
    private String Assessment;
    private String PPL;
    private String TX;
    private String DX;
    private String MX;
    private String EX;
    
    public String getId_Rekam_Medis() {
        return Id_Rekam_Medis;
    }

    public void setId_Rekam_Medis(String Id_Rekam_Medis) {
        this.Id_Rekam_Medis = Id_Rekam_Medis;
    }

    public String getAssessment() {
        return Assessment;
    }

    public void setAssessment(String Assessment) {
        this.Assessment = Assessment;
    }
    
     public String getTX() {
        return TX;
    }

    public void setTX(String TX) {
        this.TX = TX;
    }
    
    public String getDX() {
        return DX;
    }

    public void setDX(String DX) {
        this.DX = DX;
    }
    
    public String getMX() {
        return MX;
    }

    public void setMX(String MX) {
        this.MX = MX;
    }
    
    public String getEX() {
        return EX;
    }

    public void setEX(String EX) {
        this.EX = EX;
    }
    public String getPPL() {
        return PPL;
    }

    public void setPPL(String PPL) {
        this.PPL = PPL;
    }
}
