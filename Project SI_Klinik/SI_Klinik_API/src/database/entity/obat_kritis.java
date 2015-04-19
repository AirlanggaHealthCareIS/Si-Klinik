/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author asus
 */
public class obat_kritis implements Serializable{
    private String id_obat;
    private int no;
    private String NAMA_OBAT;
    private int SELISIH;
    private String NAMA_SUPPLIER;
    
    
    public int getNo(){
        return no;
    }
    public void setNo(int a){
        no =a;
    }
    public String getID_OBAT(){
        return id_obat;
    }
    public void setID_OBAT(String a){
        id_obat = a;
                
    }
    public String getNAMA_OBAT(){
        return NAMA_OBAT;
    }
    public void setNAMA_OBAT(String a){
        NAMA_OBAT = a;
    }
    public int getSELISIH(){
        return SELISIH;
}
    public void setSELISIH(int a){
        SELISIH = a;
    }
    public void setNAMA_SUPPLIER(String a){
        NAMA_SUPPLIER = a;
    }
    public String getNAMA_SUPPLIER(){
        return NAMA_SUPPLIER;
    
}
}
    
    
