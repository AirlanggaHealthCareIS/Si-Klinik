/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.jadwal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BOCIL
 */
public class TableModel_Jadwal extends AbstractTableModel{
    private List<jadwal> list = new ArrayList<jadwal>(); //ambil list Customers dari bridge
    
    public TableModel_Jadwal(){
    
    }
    
    public void insert(jadwal jadwal){
        list.add(jadwal);
        fireTableDataChanged();
        }

    public void update(int row,jadwal jadwal){
        list.set(row, jadwal);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    public jadwal get(int row){
        return list.get(row);
    }
    
    public void setData(List<jadwal> list){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID Jadwal";
            case 1 : return "ID Dokter";
            case 2 : return "Hari";
            case 3  : return "Jam";

            default: return null;
        }
    }
     
     public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getid_jadwal();
            case 1 : return list.get(rowIndex).getid_dokter();
            case 2 : return list.get(rowIndex).gethari();
            case 3 : return list.get(rowIndex).getjam();
                
            default : return null;
        }
    }
}
