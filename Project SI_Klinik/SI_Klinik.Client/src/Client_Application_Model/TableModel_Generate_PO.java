/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.obat_kritis;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author alif
 */
public class TableModel_Generate_PO {
    private List<obat_kritis> list = new ArrayList<obat_kritis>();
    
    public TableModel_Generate_PO(){
        
    }
    public obat_kritis get(int row){
        return list.get(row);
    }
    public void update(int row, obat_kritis obat_kritis){
        list.set(row, obat_kritis);
        fireTableDataChanged();
    }
    
    public void setData(List<obat_kritis> list){
        this.list = list;
        fireTableDataChanged();
    }

     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "no";
            case 1 : return "ID_OBAT";
            case 2 : return "NAMA_OBAT";
            case 3 : return "JUMLAH_YANG_HARUS_DIPESAN";
            case 4 : return "SUPPLIER";
            default: return null;
        }
    }   
    public int getRowCount() {
        return list.size();
    }   
    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getNo();
            case 1 : return list.get(rowIndex).getID_OBAT();
            case 2 : return list.get(rowIndex).getNAMA_OBAT();
            case 3 : return list.get(rowIndex).getSELISIH();
            case 4 : return list.get(rowIndex).getNAMA_SUPPLIER();   
            default : return null;
        }
    }
}
