/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.Jadwal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BOCIL
 */
public class TableModel_Jadwal extends AbstractTableModel{
    private List<Jadwal> list = new ArrayList<Jadwal>(); //ambil list Customers dari bridge
    
    public TableModel_Jadwal(){
    
    }
    
    public void insert(Jadwal jadwal){
        list.add(jadwal);
        fireTableDataChanged();
        }

    public void update(int row,Jadwal jadwal){
        list.set(row, jadwal);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    public Jadwal get(int row){
        return list.get(row);
    }
    
    public void setData(List<Jadwal> jadwal){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID Jadwal";
            case 1 : return "ID Dokter";
            case 2 : return "ID Poli";
            case 3 : return "Hari";
            case 4 : return "Jam";

            default: return null;
        }
    }
     
     public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 6;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getid_jadwal();
            case 1 : return list.get(rowIndex).getid_dokter();
            case 2 : return list.get(rowIndex).getid_poli();
            case 3 : return list.get(rowIndex).gethari();
            case 4 : return list.get(rowIndex).getjam();
                
            default : return null;
        }
    }
}
