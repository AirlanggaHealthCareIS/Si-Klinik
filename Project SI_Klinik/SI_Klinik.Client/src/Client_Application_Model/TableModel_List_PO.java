/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.Pemesanan_Obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aliffahri
 */
public class TableModel_List_PO extends AbstractTableModel{
        private List<Pemesanan_Obat> list = new ArrayList<Pemesanan_Obat>();
    
    public TableModel_List_PO(){
        
    }
    public Pemesanan_Obat get(int row){
        return list.get(row);
    }
    public void update(int row, Pemesanan_Obat pemesanan_obat){
        list.set(row, pemesanan_obat);
        fireTableDataChanged();
    }
    
    public void setData(List<Pemesanan_Obat> list){
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "id_po";
            case 1 : return "supplier";
            case 2 : return "tanggal pesan";
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
            case 0 : return list.get(rowIndex).getId_Pemesanan_obat();
            case 1 : return list.get(rowIndex).getNama_supplier();
            case 2 : return list.get(rowIndex).getTgl_Pemesanan();   
            default : return null;
        }
    }
}
