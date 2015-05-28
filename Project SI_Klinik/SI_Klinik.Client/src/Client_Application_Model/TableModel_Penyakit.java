/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Penyakit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModel_Penyakit extends AbstractTableModel{
     private List<Penyakit> list = new ArrayList<Penyakit>(); //ambil list penyakit dari bridge

    public TableModel_Penyakit(){
    }

    public Penyakit get(int row){
        return list.get(row);
    }

    public void insert(Penyakit penyakit){
        list.add(penyakit);
        fireTableDataChanged();
        }

    public void update(int row,Penyakit penyakit){
        list.set(row, penyakit);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Penyakit> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID_PENYAKIT";
            case 1 : return "NAMA_PENYAKIT";
                          
            default: return null;
        }
    }

    
    public int getRowCount() {
        return list.size();
    }

    
    public int getColumnCount() {
        return 2;
    }

   
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getId_Penyakit();
            case 1 : return list.get(rowIndex).getNama_Penyakit();
                
            default : return null;
        }
    }
}
