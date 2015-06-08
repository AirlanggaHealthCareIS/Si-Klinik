/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModel_Supplier extends AbstractTableModel{
     private List<Supplier> list = new ArrayList<Supplier>(); //ambil list supplier dari bridge

    public TableModel_Supplier(){
    }

    public Supplier get(int row){
        return list.get(row);
    }

    public void insert(Supplier supplier){
        list.add(supplier);
        fireTableDataChanged();
        }

    public void update(int row,Supplier supplier){
        list.set(row, supplier);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Supplier> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID_SUPPLIER";
            case 1 : return "NAMA_SUPPLIER";
            case 2 : return "ALAMAT_SUPPLIER";
            case 3 : return "KOTA_SUPPLIER";
            case 4 : return "TELEPON_SUPPLIER";          
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
            case 0 : return list.get(rowIndex).getId_Supplier();
            case 1 : return list.get(rowIndex).getNama_Supplier();
            case 2 : return list.get(rowIndex).getAlamat_Supplier();
            case 3 : return list.get(rowIndex).getKota_Supplier();
            case 4 : return list.get(rowIndex).getTelepon_Supplier();
                
            default : return null;
        }
    }
}
