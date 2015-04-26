/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;
import database.entity.Antrian;
import database.entity.Transaksi_Periksa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModel_fakbpjs extends AbstractTableModel{
     private List<Transaksi_Periksa> list = new ArrayList<Transaksi_Periksa>(); //ambil list supplier dari bridge

    public TableModel_fakbpjs(){
    }

    public Transaksi_Periksa get(int row){
        return list.get(row);
    }

    public void insert(Transaksi_Periksa tps){
        list.add(tps);
        fireTableDataChanged();
        }

    public void update(int row,Transaksi_Periksa tps){
        list.set(row, tps);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }

    public void setData(List<Transaksi_Periksa> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID Pasien";
            case 1 : return "ID Transaksi Pasien";
            case 2 : return "Nomor BPJS";
            case 3 : return "Jumlah Transaksi";
            case 4 : return "Tanggal Transaksi";
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
            case 0 : return list.get(rowIndex).getId_Pasien();
            case 1 : return list.get(rowIndex).getId_Transaksi_Periksa();
            case 2 : return list.get(rowIndex).getKlaim_BPJS();
            case 3 : return list.get(rowIndex).getTotal_Transaksi_Periksa();
            case 4 : return list.get(rowIndex).getTanggal_Transaksi_Periksa();
            default : return null;
        }
    }
}
