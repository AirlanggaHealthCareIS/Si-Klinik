/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.detail_lihat_resep;
import database.entity.detail_resep_obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tinot
 */
public class TabelModel_InputResep extends AbstractTableModel{
    private List<detail_lihat_resep> list = new ArrayList<detail_lihat_resep>(); //ambil list Customers dari bridge
    
    public TabelModel_InputResep(){
    
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
            case 0 : return "Kode Obat";
            case 1 : return "Nama Obat";
            case 2 : return "QTY Obat";

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
            case 0 : return list.get(rowIndex).getIdObat();
            case 1 : return list.get(rowIndex).getObat();
            case 2 : return list.get(rowIndex).getQty();
                
            default : return null;
        }
    }
}
