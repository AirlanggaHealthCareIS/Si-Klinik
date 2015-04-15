/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Rekam_Medis;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModel_RM_Awal extends AbstractTableModel{    
     private List<Rekam_Medis> list = new ArrayList<Rekam_Medis>(); //ambil list rekam_medis dari bridge

    public TableModel_RM_Awal(){
    }

    public Rekam_Medis get(int row){
        return list.get(row);
    }

    public void insert(Rekam_Medis rekam_medis){
        list.add(rekam_medis);
        fireTableDataChanged();
        }

    public void update(int row,Rekam_Medis rekam_medis){
        list.set(row, rekam_medis);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Rekam_Medis> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Tanggal";
            case 1 : return "Diagnosa";
            case 2 : return "Nama Dokter";
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
            case 0 : return list.get(rowIndex).getTanggal_Rekam_Medis();
            case 1 : return list.get(rowIndex).getAssessments();
            case 2 : return list.get(rowIndex).getNama_Dokter();
            default : return null;
        }
    }
}
