/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.detail_beli;
import database.entity.detail_beli1;
import database.entity.detil_pesan_obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aliffahri
 */
public class TableModel_Detail_List_Beli extends AbstractTableModel{
        private List<detail_beli1> list = new ArrayList<detail_beli1>();
    
    public TableModel_Detail_List_Beli(){
        
    }
    public detail_beli1 get(int row){
        return list.get(row);
    }
    public void update(int row, detail_beli1 db){
        list.set(row, db);
        fireTableDataChanged();
    }
    
    public void setData(List<detail_beli1> list){
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Nama Obat";
            case 1 : return "Jumlah Pesan";
            case 2 : return "Jumlah Barang yang Datang";
            default: return null;
        }
    }   
    public int getRowCount() {
        return list.size();
    }   
    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getnama_obat();
            case 1 : return list.get(rowIndex).getqtypesan();
            case 2 : return list.get(rowIndex).getqtydatang();
            default : return null;
        }
    }
}
