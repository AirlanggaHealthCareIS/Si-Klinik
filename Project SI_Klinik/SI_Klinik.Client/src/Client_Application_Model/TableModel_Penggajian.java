/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client_Application_Model;

import database.entity.Penggajian;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 8.1
 */
public class TableModel_Penggajian extends AbstractTableModel{
     private List<Penggajian> list = new ArrayList<Penggajian>(); //ambil list Customers dari bridge
    
    public TableModel_Penggajian(){
    
    }

    public Penggajian get(int row){
        return list.get(row);
    }
    
    public void setData(List<Penggajian> list){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "Tanggal";
            case 1 : return "ID Penggajian";
            case 2 : return "ID Pegawai";
            case 3 : return "Nama Pegawai";
            case 4 : return "Gaji Pokok";
            case 5 : return "Gaji Tambahan";
            case 6 : return "Total Gaji";

            default: return null;
        }
    }
     
     public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 7;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getTanggal();
            case 1 : return list.get(rowIndex).getIdPenggajian();
            case 2 : return list.get(rowIndex).getIdPegawai();
            case 3 : return list.get(rowIndex).getNamaPegawai();
            case 4 : return list.get(rowIndex).getGajiPokok();
            case 5 : return list.get(rowIndex).getGajiTambahan();
            case 6 : return list.get(rowIndex).getTotalGaji();
                
            default : return null;
        }
    }

}
