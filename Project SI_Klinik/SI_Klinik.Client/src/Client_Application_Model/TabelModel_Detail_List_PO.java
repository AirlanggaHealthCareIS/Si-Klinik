/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.detil_pesan_obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aliffahri
 */
public class TabelModel_Detail_List_PO extends AbstractTableModel{
        private List<detil_pesan_obat> list = new ArrayList<detil_pesan_obat>();
    
    public TabelModel_Detail_List_PO(){
        
    }
    public detil_pesan_obat get(int row){
        return list.get(row);
    }
    public void update(int row, detil_pesan_obat pemesanan_obat){
        list.set(row, pemesanan_obat);
        fireTableDataChanged();
    }
    
    public void setData(List<detil_pesan_obat> list){
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "id_obat";
            case 1 : return "nama obat";
            case 2 : return "jumlah pesan";
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
            case 0 : return list.get(rowIndex).getId_obat();
            case 1 : return list.get(rowIndex).getNama_Obat();
            case 2 : return list.get(rowIndex).getJumlah_Pesan();   
            default : return null;
        }
    }
}
