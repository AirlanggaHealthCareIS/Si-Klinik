/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Tindakan_Dokter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Acer
 */
public class TableModel_Tindakan_Periksa_Dokter extends AbstractTableModel{
     private List<Tindakan_Dokter> list = new ArrayList<Tindakan_Dokter>(); 

    public TableModel_Tindakan_Periksa_Dokter(){
    }

    public Tindakan_Dokter get(int row){
        return list.get(row);
    }

    public void insert(Tindakan_Dokter periksa){
        list.add(periksa);
        fireTableDataChanged();
        }

    public void update(int row,Tindakan_Dokter periksa){
        list.set(row, periksa );
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Tindakan_Dokter> list){
        this.list = list;
        fireTableDataChanged();    
    }
    
@Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Id_Tindakan_Dokter";
            case 1 : return "Tindakan_Dokter";
            case 2 : return "Biaya_Tindakan_Dokter";
            default: return null;
        }
    }

    public int getRowCount() {
       return list.size();
         }    

    @Override
    public int getColumnCount() {
    return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
            case 0 : return list.get(rowIndex).getId_Tindakan_Dokter();
            case 1 : return list.get(rowIndex).getTindakan_Dokter();
            case 2 : return list.get(rowIndex).getBiaya_Tindakan_Dokter();    
    
            default : return null;
        } 
    }
}
    



