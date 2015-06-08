/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Application_Model;

import database.entity.detail_transaksi_obat;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Indyka
 */
public class TableModel_Detail_Transaksi_Obat extends AbstractTableModel{
    private List<detail_transaksi_obat> list = new ArrayList<detail_transaksi_obat>();
    
    public TableModel_Detail_Transaksi_Obat(){
        
    }
    public detail_transaksi_obat get(int row){
        return list.get(row);
    }
    public void update(int row, detail_transaksi_obat pemesanan_obat){
        list.set(row, pemesanan_obat);
        fireTableDataChanged();
    }
    
    public void setData(List<detail_transaksi_obat> list){
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Obat";
            case 1 : return "Qty";
            case 2 : return "Total";
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
            case 0 : return list.get(rowIndex).getid_obat();
            case 1 : return list.get(rowIndex).getqty_detail_transaksi();
            case 2 : return list.get(rowIndex).getidtransaksi_obat();   
            default : return null;
        }
    }
}
