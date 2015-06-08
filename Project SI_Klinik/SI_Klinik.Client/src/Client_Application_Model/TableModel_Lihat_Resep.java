/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.detail_lihat_resep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tinot
 */
public class TableModel_Lihat_Resep extends AbstractTableModel{
    private List<detail_lihat_resep> list = new ArrayList<detail_lihat_resep>(); //ambil list Customers dari bridge
    
    public TableModel_Lihat_Resep(){
    
    }
    
    public void insert(detail_lihat_resep supplier){
        list.add(supplier);
        fireTableDataChanged();
        }

    public void update(int row,detail_lihat_resep supplier){
        list.set(row, supplier);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    public detail_lihat_resep get(int row){
        return list.get(row);
    }
    
    public void setData(List<detail_lihat_resep> list){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "Nama Obat";
            case 1 : return "QTY Obat";
            case 2 : return "Kemasan";
            case 3 : return "Keterangan";                 
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
            case 0 : return list.get(rowIndex).getObat();
            case 1 : return list.get(rowIndex).getQty();
            case 2 : return list.get(rowIndex).getKemasan();
            case 3 : return list.get(rowIndex).getKeterangan();
            default : return null;
        }
    }
}

