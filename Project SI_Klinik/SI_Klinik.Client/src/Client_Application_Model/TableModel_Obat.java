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
            case 0 : return "ID_OBAT";
            case 1 : return "NAMA_SUPPLIER";
            case 2 : return "NAMA_OBAT";
            case 3 : return "DOSIS";
            case 4 : return "KETERANGAN_OBAT";
            case 5 : return "STOK_OBAT";
            case 6 :return "STOK_KRITIS";
            case 7 : return "PABRIK_OBAT";
            case 8 : return "JENIS_OBAT";
            case 9 : return "KEMASAN";     
            case 10: return "HARGA_OBAT";
            default: return null;
        }
    }   
    public int getRowCount() {
        return list.size();
    }   
    public int getColumnCount() {
        return 11;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getid_obat();
            case 1 : return list.get(rowIndex).getNamaSupplier();
            case 2 : return list.get(rowIndex).getnama_obat();
            case 3 : return list.get(rowIndex).getdosis();
            case 4 : return list.get(rowIndex).getketerangan_obat();
            case 5 : return list.get(rowIndex).getstok_obat();
            case 6 : return list.get(rowIndex).getstok_kritis();
            case 7 : return list.get(rowIndex).getpabrik_obat();
            case 8 : return list.get(rowIndex).getjenis_obat();
            case 9 : return list.get(rowIndex).getkemasan();    
            case 10 : return list.get(rowIndex).getharga_obat();
            
            default : return null;
        }
    }
}



