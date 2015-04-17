/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.Transaksi_Periksa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Indyka
 */
public class TableModel_TransaksiPeriksa extends AbstractTableModel{
    private List<Transaksi_Periksa> list = new ArrayList<Transaksi_Periksa>(); 

    public TableModel_TransaksiPeriksa(){
    }

    public Transaksi_Periksa get(int row){
        return list.get(row);
    }

    public void insert(Transaksi_Periksa periksa){
        list.add(periksa);
        fireTableDataChanged();
        }

    public void update(int row,Transaksi_Periksa periksa){
        list.set(row, periksa );
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
            case 0 : return "Tanggal";
            case 1 : return "ID Transaksi Periksa";
            case 2 : return "Total";
                
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
            case 0 : return list.get(rowIndex).getTanggal_Transaksi_Periksa(); 
            case 1 : return list.get(rowIndex).getId_Transaksi_Periksa();
            case 2 : return list.get(rowIndex).getId_Dokter();
            case 3 : return list.get(rowIndex).getTotal_Transaksi_Periksa();
            
            default : return null;
        } 
    }
}
