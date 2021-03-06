/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Administrator
 */
public class TableModel_Obat extends AbstractTableModel{
     private List<obat> list = new ArrayList<obat>(); 

    public TableModel_Obat(){
    }

    public obat get(int row){
        return list.get(row);
    }

    public void insert(obat obat){
        list.add(obat);
        fireTableDataChanged();
        }

    public void update(int row,obat obat){
        list.set(row, obat);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<obat> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID OBAT";
            case 1 : return "NAMA OBAT";
            case 2 : return "NAMA SUPPLIER";   
            case 3 : return "STOK OBAT";
            case 4 : return "STOK KRITIS";  
            case 5 : return "KEMASAN";  
            case 6: return "HARGA OBAT";
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
            case 0 : return list.get(rowIndex).getid_obat();
            case 1 : return list.get(rowIndex).getnama_obat();
            case 2 : return list.get(rowIndex).getNamaSupplier();
            case 3 : return list.get(rowIndex).getstok_obat();
            case 4 : return list.get(rowIndex).getstok_kritis();
            case 5 : return list.get(rowIndex).getkemasan();    
            case 6 : return list.get(rowIndex).getharga_obat();
            
            default : return null;
        }
    }
}




