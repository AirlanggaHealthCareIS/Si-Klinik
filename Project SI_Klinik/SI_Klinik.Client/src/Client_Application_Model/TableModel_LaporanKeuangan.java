/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client_Application_Model;

import database.entity.Laporan_Keuangan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 8.1
 */
public class TableModel_LaporanKeuangan extends AbstractTableModel{
    private List<Laporan_Keuangan> list = new ArrayList<Laporan_Keuangan>(); //ambil list Customers dari bridge
    
    public TableModel_LaporanKeuangan(){
    
    }
    
    public void insert(Laporan_Keuangan supplier){
        list.add(supplier);
        fireTableDataChanged();
        }

    public void update(int row,Laporan_Keuangan supplier){
        list.set(row, supplier);
        fireTableDataChanged();
    }

    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    public Laporan_Keuangan get(int row){
        return list.get(row);
    }
    
    public void setData(List<Laporan_Keuangan> list){
        this.list = list;
        fireTableDataChanged();
    }
    
     @Override
     public String getColumnName(int column) {
        switch(column){
            case 0 : return "tanggal";
            case 1 : return "keterangan";
            case 2 : return "ref";
            case 3 : return "pemasukan";
            case 4 : return "pengeluaran";
            case 5 : return "saldo";

            default: return null;
        }
    }
     
     public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 6;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getTanggal();
            case 1 : return list.get(rowIndex).getKeterangan();
            case 2 : return list.get(rowIndex).getRef();
            case 3 : return list.get(rowIndex).getPemasukan();
            case 4 : return list.get(rowIndex).getPengeluaran();
            case 5 : return list.get(rowIndex).getSaldo();
                
            default : return null;
        }
    }

}
