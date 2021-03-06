/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.lihatResep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tinot
 */
public class TableModel_Resep extends AbstractTableModel{
    private List<lihatResep> list = new ArrayList<lihatResep>(); //ambil list Customers dari bridge
    
    public TableModel_Resep(){
    
    }
    
    public void insert(lihatResep resep){
        list.add(resep);
        fireTableDataChanged();
        }

    public void update(int row,lihatResep resep){
        list.set(row, resep);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    public lihatResep get(int row){
        return list.get(row);
    }
    
    public void setData(List<lihatResep> list){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "NO";
            case 1 : return "ID REKAM MEDIK";
            case 2 : return "TANGGAL REKAM MEDIK";            
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
            case 0 : return list.get(rowIndex).getNo();
            case 1 : return list.get(rowIndex).getId_rekam_medik();
            case 2 : return list.get(rowIndex).getTanggal();
                
            default : return null;
        }
    }
}
