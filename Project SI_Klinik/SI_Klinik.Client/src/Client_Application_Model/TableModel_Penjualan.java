/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Penjualan;        
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModel_Penjualan extends AbstractTableModel{
     private List<Penjualan> list = new ArrayList<Penjualan>(); 

    public TableModel_Penjualan(){
    }

    public Penjualan get(int row){
        return list.get(row);
    }

    public void insert(Penjualan penjualan){
        list.add(penjualan);
        fireTableDataChanged();
        }

    public void update(int row,Penjualan penjualan){
        list.set(row, penjualan);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Penjualan> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID Obat";
            case 1 : return "Nama Obat";
            case 2 : return "Stok";    
            case 3 : return "Jumlah Beli";
            case 4 : return "Harga Satuan";
            case 5 : return "Total Harga";            
            case 6 : return "Keterangan";
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
            case 0 : return list.get(rowIndex).getId_Obat();
            case 1 : return list.get(rowIndex).getNama_Obat();                
            case 2 : return list.get(rowIndex).getStok();
            case 3 : return list.get(rowIndex).getQty();
            case 4 : return list.get(rowIndex).getHarga();
            case 5 : return list.get(rowIndex).getTotal();  
            case 6 : return list.get(rowIndex).getKeterangan();
            default : return null;
        }
    }
}


