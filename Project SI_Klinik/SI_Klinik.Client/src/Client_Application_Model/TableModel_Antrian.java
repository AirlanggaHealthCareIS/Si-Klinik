/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Antrian;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModel_Antrian extends AbstractTableModel{
     private List<Antrian> list = new ArrayList<Antrian>(); //ambil list supplier dari bridge

    public TableModel_Antrian(){
    }

    public Antrian get(int row){
        return list.get(row);
    }

    public void insert(Antrian supplier){
        list.add(supplier);
        fireTableDataChanged();
        }

    public void update(int row,Antrian supplier){
        list.set(row, supplier);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Antrian> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "No Antrian";
            case 1 : return "Nama";
            case 2 : return "Alamat";
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
            case 0 : return list.get(rowIndex).getNomor();
            case 1 : return list.get(rowIndex).getNama_Pasien();
            case 2 : return list.get(rowIndex).getAlamat();
            default : return null;
        }
    }
}
