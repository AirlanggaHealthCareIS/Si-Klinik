/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.entity;

import java.io.Serializable;

/**
 *
 * @author Windows 8.1
 */
public class Penggajian implements Serializable{
    String tanggal;
    String idPenggajian;
    String namaPegawai;
    String idPegawai;
    int totalPeriksa;
    int tarifPeriksa;
    int gajiPokok;
    int gajiTambahan;
    int gajiPeriksa;
    int totalGaji;
    int presensi;
    
    public void setTanggal (String tanggal){
        this.tanggal = tanggal;
    }
    
    public String getTanggal(){
        return tanggal;
    }
    
    public void setNamaPegawai (String namaPegawai){
        this.namaPegawai = namaPegawai;
    }
    
    public String getNamaPegawai(){
        return namaPegawai;
    }
    
    public void setIdPenggajian (String idPenggajian){
        this.idPenggajian = idPenggajian;
    }
    
    public String getIdPenggajian(){
        return idPenggajian;
    }
    
    public void setIdPegawai (String idPegawai){
        this.idPegawai = idPegawai;
    }
    
    public String getIdPegawai(){
        return idPegawai;
    }
    
    public int getTotalPeriksa () {
        return totalPeriksa;
    }
    
    public void setTotalPeriksa (int totalPeriksa){
        this.totalPeriksa = totalPeriksa;
    }
    
    public int getTarifPeriksa () {
        return tarifPeriksa;
    }
    
    public void setTarifPeriksa (int tarifPeriksa){
        this.tarifPeriksa = tarifPeriksa;
    }
    
    public int getGajiPokok () {
        return gajiPokok;
    }
    
    public void setGajiPokok (int gajiPokok){
        this.gajiPokok = gajiPokok;
    }
    
    public int getGajiTambahan () {
        return gajiTambahan;
    }
    
    public void setGajiTambahan (int gajiTambahan){
        this.gajiTambahan = gajiTambahan;
    }
    
    public int getTotalGaji () {
        return totalGaji;
    }
    
    public void setTotalGaji (int totalGaji){
        this.totalGaji = totalGaji;
    }
    
    public int getPresensi () {
        return presensi;
    }
    
    public void setPresensi (int presensi){
        this.presensi = presensi;
    }
    
    public int getGajiPeriksa () {
        return gajiPeriksa;
    }
    
    public void setGajiPeriksa (int gajiPeriksa){
        this.gajiPeriksa = gajiPeriksa;
    }
}
